package co.ankit.demomvp.presenter;

public interface Presenter<V> {

    void attachView(V view);

    void detachView();

}
