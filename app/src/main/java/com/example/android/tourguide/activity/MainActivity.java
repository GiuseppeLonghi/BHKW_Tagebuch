package com.example.android.tourguide.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.android.tourguide.R;
import com.example.android.tourguide.fragment.EventsFragment;
import com.example.android.tourguide.fragment.HotelsFragment;
import com.example.android.tourguide.fragment.MonumentsFragment;
import com.example.android.tourguide.fragment.RestaurantsFragment;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    // tags used to attach the fragments
    private static final String TAG_HOTELS = "Hotels";
    private static final String TAG_RESTAURANTS = "Restaurants";
    private static final String TAG_MONUMENTS = "Monuments";
    private static final String TAG_EVENTS = "Events";
    public static String CURRENT_TAG = TAG_HOTELS;

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
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);

                        // to update the UI based on the item selected
                        switch (menuItem.getItemId()) {
                            case R.id.nav_hotels:
                                mNavItemIndex = 0;
                                CURRENT_TAG = TAG_HOTELS;
                                break;
                            case R.id.nav_restaurants:
                                mNavItemIndex = 1;
                                CURRENT_TAG = TAG_RESTAURANTS;
                                break;
                            case R.id.nav_monuments:
                                mNavItemIndex = 2;
                                CURRENT_TAG = TAG_MONUMENTS;
                                break;
                            case R.id.nav_events:
                                mNavItemIndex = 3;
                                CURRENT_TAG = TAG_EVENTS;
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
            CURRENT_TAG = TAG_HOTELS;

            // Selecting appropriate nav menu item
            navigationView.getMenu().getItem(mNavItemIndex).setChecked(true);
            // set toolbar title
//            getSupportActionBar().setTitle(mToolbarTitles[mNavItemIndex]);
            // if user select the current navigation menu again, don't do anything
            // just close the navigation drawer
            if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null)
                mDrawerLayout.closeDrawers();

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, getFragment()).commit();

            mDrawerLayout.closeDrawers();

            invalidateOptionsMenu();
        }
    }

    /**
     * It returns the correct fragment selected
     *
     */
    private Fragment getFragment() {
        switch (mNavItemIndex) {
            case 0:
                // hotels fragment
                return new HotelsFragment();
            case 1:
                // restaurants fragment
                return new RestaurantsFragment();
            case 2:
                // monuments fragment
                return new MonumentsFragment();
            case 3:
                // events fragment
                return new EventsFragment();

            default:
                return new HotelsFragment();
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
}
