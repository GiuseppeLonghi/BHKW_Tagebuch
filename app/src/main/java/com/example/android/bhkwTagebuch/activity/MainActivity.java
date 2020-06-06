package com.example.android.bhkwTagebuch.activity;

import androidx.annotation.NonNull;
import com.google.android.material.navigation.NavigationView;
import androidx.fragment.app.Fragment;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.MenuItem;

import com.example.android.bhkwTagebuch.R;
import com.example.android.bhkwTagebuch.fragment.HousesCurrentCounterFragment;
import com.example.android.bhkwTagebuch.fragment.CurrentCounterFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private DrawerLayout mDrawerLayout;

    // tags used to attach the fragments
    private static final String TAG_HOUSES_CURRENT_COUNTERS = "Houses Current Counters";
    private static final String TAG_CURRENT_COUNTER = "Current Counter";
    private static final String TAG_BHKW = "BHKW";
    private static final String TAG_WATER_COUNTER = "Water Counters";
    private static final String TAG_GASZAHLER = "Gaszähler";
    private static final String TAG_NACHSPEISEEINRICHTUNG = "Nachspeiseeinrichtung";
    public static String CURRENT_TAG = TAG_HOUSES_CURRENT_COUNTERS;

    // index to identify current nav menu item
    public static int mNavItemIndex = 0;

    // toolbar titles respected to selected nav menu item
    private String[] mToolbarTitles = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        mToolbarTitles = getResources().getStringArray(R.array.toolbar_titles);

        // To manage callbacks when a list item in the drawer is tapped,
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Following line is needed to fix the issue with icons not displayed correctly
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);

                        // to update the UI based on the item selected
                        switch (menuItem.getItemId()) {
                            case R.id.nav_house_electricity_meter:
                                mNavItemIndex = 0;
                                CURRENT_TAG = TAG_HOUSES_CURRENT_COUNTERS;
                                break;
                            case R.id.nav_electricity_meter:
                                mNavItemIndex = 1;
                                CURRENT_TAG = TAG_CURRENT_COUNTER;
                                break;
                            case R.id.nav_bhkw:
                                mNavItemIndex = 2;
                                CURRENT_TAG = TAG_BHKW;
                                break;
                            case R.id.nav_water_meter:
                                mNavItemIndex = 3;
                                CURRENT_TAG = TAG_WATER_COUNTER;
                                break;
                            case R.id.nav_gas_meter:
                                mNavItemIndex = 4;
                                CURRENT_TAG = TAG_GASZAHLER;
                                break;
                            case R.id.nav_softner:
                                mNavItemIndex = 5;
                                CURRENT_TAG = TAG_NACHSPEISEEINRICHTUNG;
                                break;
                             default:
                                 mNavItemIndex = 0;
                        }

                        // Check whether the menuItem is in checked state
                        if (menuItem.isChecked()) {
                            menuItem.setChecked(false);
                        } else {
                            menuItem.setChecked(true);
                        }
                        menuItem.setChecked(true);

                        // set toolbar title
                        getSupportActionBar().setTitle(mToolbarTitles[mNavItemIndex]);

                        // load the Fragment
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.content_frame, getFragment()).commit();

                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawer(GravityCompat.START);

                        return true;
                    }
                });

        if (savedInstanceState == null) {
            mNavItemIndex = 0;
            CURRENT_TAG = TAG_HOUSES_CURRENT_COUNTERS;

            // Selecting appropriate nav menu item
            navigationView.getMenu().getItem(mNavItemIndex).setChecked(true);

            // if user select the current navigation menu again, don't do anything
            // just close the navigation drawer
            if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null)
                mDrawerLayout.closeDrawers();

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, getFragment()).commit();

            mDrawerLayout.closeDrawers();

            invalidateOptionsMenu();
        }

        basicReadWrite();
    }

    /**
     * It returns the correct fragment selected
     *
     */
    private Fragment getFragment() {
        switch (mNavItemIndex) {
            case 0:
                // Houses Current Counter fragment
                return new HousesCurrentCounterFragment();
            case 1:
                // Stromzahler fragment
                return new CurrentCounterFragment();
            /*case 2:
                // monuments fragment
                return new MonumentsFragment();
            case 3:
                // events fragment
                return new EventsFragment();*/
            default:
                return new HousesCurrentCounterFragment();
        }
    }

    /**
     * To open the drawer when the user taps on the nav drawer button,
     * @param item the menu item
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Basic method used to retrieve an instance of your database using getInstance()
     * and reference the location you want to write to
     */
    public void basicReadWrite() {
        // [START write_message]
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dataBaseRef = database.getReference("message");

        dataBaseRef.setValue("Hello, World!");
        // [END write_message]

        // [START read_message]
        // Read from the database
        dataBaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        // [END read_message]
    }
}
