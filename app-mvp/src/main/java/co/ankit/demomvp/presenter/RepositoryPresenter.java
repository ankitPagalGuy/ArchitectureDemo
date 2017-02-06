package co.ankit.demomvp.presenter;

import android.util.Log;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import co.ankit.demomvp.DemoApplication;
import co.ankit.demomvp.model.GithubService;
import co.ankit.demomvp.model.User;
import co.ankit.demomvp.view.RepositoryMvpView;

public class RepositoryPresenter implements Presenter<RepositoryMvpView> {

    private static final String TAG = "RepositoryPresenter";

    private RepositoryMvpView repositoryMvpView;
    private Subscription subscription;

    @Override
    public void attachView(RepositoryMvpView view) {
        this.repositoryMvpView = view;
    }

    @Override
    public void detachView() {
        this.repositoryMvpView = null;
        if (subscription != null) subscription.unsubscribe();
    }

    public void loadOwner(String userUrl) {
        DemoApplication application = DemoApplication.get(repositoryMvpView.getContext());
        GithubService githubService = application.getGithubService();
        subscription = githubService.userFromUrl(userUrl)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(application.defaultSubscribeScheduler())
                .subscribe(new Action1<User>() {
                    @Override
                    public void call(User user) {
                        Log.i(TAG, "Full user data loaded " + user);
                        repositoryMvpView.showOwner(user);
                    }
                });
    }
}
