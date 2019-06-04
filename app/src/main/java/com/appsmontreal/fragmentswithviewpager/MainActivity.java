package com.appsmontreal.fragmentswithviewpager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.appsmontreal.fragmentswithviewpager.Connection.FragmentEventListener;
import com.appsmontreal.fragmentswithviewpager.Model.User;

public class MainActivity extends AppCompatActivity implements FragmentEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onUserAdded(User user) {

    }

    @Override
    public void onUserUpdated(User newUser) {

    }

    @Override
    public void onUserListClicked(User user) {

    }
}
