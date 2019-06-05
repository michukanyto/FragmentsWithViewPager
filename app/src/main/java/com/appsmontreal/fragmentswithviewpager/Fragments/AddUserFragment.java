package com.appsmontreal.fragmentswithviewpager.Fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.appsmontreal.fragmentswithviewpager.Connection.FragmentEventListener;
import com.appsmontreal.fragmentswithviewpager.Model.User;
import com.appsmontreal.fragmentswithviewpager.R;

import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddUserFragment extends Fragment {

    private FragmentEventListener fragmentEventListener;
    public AddUserFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        fragmentEventListener = (FragmentEventListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button addUserButton = view.findViewById(R.id.addUserFragmentButton);
        addUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getView().getRootView().getWindowToken(),0);//hide keyboard
                EditText nameEdiText = view.findViewById(R.id.nameEditText);
                EditText emailEditText = view.findViewById(R.id.emailEditText);
                String name = nameEdiText.getText().toString();
                String email = emailEditText.getText().toString();
                name += " NA";//to control last Name not empty
                String firstName = Arrays.asList(name.split(" ")).get(0);
                String lastName = Arrays.asList(name.split(" ")).get(1);
                fragmentEventListener.onUserAdded(new User(email,firstName,lastName));
            }
        });
    }
}
