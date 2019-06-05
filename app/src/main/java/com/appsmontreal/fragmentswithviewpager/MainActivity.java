package com.appsmontreal.fragmentswithviewpager;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.appsmontreal.fragmentswithviewpager.Connection.FragmentEventListener;
import com.appsmontreal.fragmentswithviewpager.Dao.UserDao;
import com.appsmontreal.fragmentswithviewpager.Model.User;
import com.appsmontreal.fragmentswithviewpager.Pager.ViewPagerAdapter;


public class MainActivity extends AppCompatActivity implements FragmentEventListener {

    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private UserDao userDao;
    private View v;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userDao = new UserDao();
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        v = findViewById(android.R.id.content);

    }

    @Override
    public void onUserAdded(User user) {
        userDao.addUser(user);
        viewPagerAdapter.notifyDataSetChanged();
//        Toast.makeText(this,"USER ADD", Toast.LENGTH_LONG).show();
        Snackbar.make(v,"USER ADD",Snackbar.LENGTH_LONG).show();

    }

    @Override
    public void onUserUpdated(String oldEmail, User newUser) {
        userDao.updateUser(userDao.getUserByEmail(oldEmail), newUser);
        viewPagerAdapter.notifyDataSetChanged();
//        Toast.makeText(this,"USER UPDATED", Toast.LENGTH_LONG).show();
        Snackbar.make(v,"USER ADD", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onUserListClicked(User user) {
//        Toast.makeText(this,"USER LIST", Toast.LENGTH_LONG).show();
        Snackbar.make(v,"USER ADD", Snackbar.LENGTH_SHORT).show();

    }

    public static void hideKeyboard(@Nullable Context context, @Nullable View view) {
        assert context != null;
        assert view != null;
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getRootView().getWindowToken(), 0);
    }
}
