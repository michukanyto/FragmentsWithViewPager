package com.appsmontreal.fragmentswithviewpager.Pager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import com.appsmontreal.fragmentswithviewpager.Fragments.AddUserFragment;
import com.appsmontreal.fragmentswithviewpager.Fragments.DemoFragment;
import com.appsmontreal.fragmentswithviewpager.Fragments.ListUserFragment;
import com.appsmontreal.fragmentswithviewpager.Fragments.UpdateUserFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                AddUserFragment addUserFragment = new AddUserFragment();
                return addUserFragment;
            case 1:
                ListUserFragment listUserFragment = new ListUserFragment();
                return  listUserFragment;
            case 2:
                UpdateUserFragment updateUserFragment = new UpdateUserFragment();
                return updateUserFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0) {
            return "ADD";
        } else if (position == 1) {
            return "LIST";
        } else if (position == 2) {
            return "UPDATE";
        } else {
            return "Nothing";
        }
    }
}

