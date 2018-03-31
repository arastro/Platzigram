package com.ivan.platzigram.view;

//import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.ivan.platzigram.R;
import com.ivan.platzigram.view.fragments.HomeFragment;
import com.ivan.platzigram.view.fragments.ProfileFragment;
import com.ivan.platzigram.view.fragments.SearchFragment;

public class ContainerActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.home:
                    transaction.replace(R.id.container,new HomeFragment()).commit();
                    return true;
                case R.id.profile:
                    transaction.replace(R.id.container,new ProfileFragment()).commit();
                    return true;
                case R.id.search:
                    transaction.replace(R.id.container,new SearchFragment())
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottombar);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);




    }

}
