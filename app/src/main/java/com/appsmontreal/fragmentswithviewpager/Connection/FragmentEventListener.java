package com.appsmontreal.fragmentswithviewpager.Connection;

import com.appsmontreal.fragmentswithviewpager.Model.User;

public interface FragmentEventListener {

    void onUserAdded(User user);
    void onUserUpdated(User newUser);
    void onUserListClicked(User user);
}
