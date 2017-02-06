package co.ankit.demomvp.view;

import java.util.List;

import co.ankit.demomvp.model.Repository;

public interface MainMvpView extends MvpView {

    void showRepositories(List<Repository> repositories);

    void showMessage(int stringId);

    void showProgressIndicator();
}
