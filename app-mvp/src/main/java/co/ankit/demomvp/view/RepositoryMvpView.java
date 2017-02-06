package co.ankit.demomvp.view;

import co.ankit.demomvp.model.User;

public interface RepositoryMvpView extends MvpView {

    void showOwner(final User owner);

}
