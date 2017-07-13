package com.example.hp.easystore.activity;


import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.hp.easystore.fragments.AboutFragment;
import com.example.hp.easystore.R;
import com.example.hp.easystore.fragments.AccountFragment;
import com.example.hp.easystore.fragments.FoodFragment;
import com.example.hp.easystore.fragments.MedicineFragment;

public class MainActivity extends AppCompatActivity {


    private NavigationView navigationView;
    private DrawerLayout drawer;
    private View navHeader;
    private Toolbar toolbar;

    // index to identify current nav menu item
    public static int navItemIndex = 0;

    // tags used to attach the fragments
    private static final String TAG_FOOD = "Food";
    private static final String TAG_FASHION = "Fashion";
    private static final String TAG_ELECTRONICS = "Electronics";
    private static final String TAG_HOME_FURN = "Home & Furniture";
    private static final String TAG_BOOKS = "Books";
    private static final String TAG_MEDICINE = "Medicine";
    private static final String TAG_UTILITIES = "Utilities";
    /*
    private static final String TAG_CART = "Cart";
    private static final String TAG_NOTIFICATION = "Notification";
    private static final String TAG_ORDERS = "Orders";
    */
    private static final String TAG_ACCOUNT = "Account";
    private static final String TAG_ABOUT = "About";
    public static String CURRENT_TAG = TAG_FOOD;

    FragmentManager manager;
    // toolbar titles respected to selected nav menu item
    private String[] activityTitles;

    // flag to load home fragment when user presses back key
    private boolean shouldLoadHomeFragOnBackPress = true;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_navigation_drawer_home);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mHandler = new Handler();

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);

        // load toolbar titles from string resources
        activityTitles = getResources().getStringArray(R.array.nav_item_activity_titles);


    }


    /*
     * Returns respected fragment that user
     * selected from navigation menu
     */
    private void loadHomeFragment() {
        // selecting appropriate nav menu item
        selectNavMenu();

        // set toolbar title
        setToolbarTitle();

        // if user select the current navigation menu again, don't do anything
        // just close the navigation drawer
        if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {
            drawer.closeDrawers();


        }

// Sometimes, when fragment has huge data, screen seems hanging
        // when switching between navigation menus
        // So using runnable, the fragment is loaded with cross fade effect
        // This effect can be seen in GMail app
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                Fragment fragment = getHomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.relativelayout_for_fragment, fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };

// If mPendingRunnable is not null, then add to the message queue
        if (mPendingRunnable != null) {
            mHandler.post(mPendingRunnable);
        }

        //Closing drawer on item click
        drawer.closeDrawers();

        // refresh toolbar menu
        invalidateOptionsMenu();
    }

    private Fragment getHomeFragment() {
        switch (navItemIndex) {
            case 0:
                //food
                FoodFragment foodfragment = new FoodFragment();
                 manager = getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.relativelayout_for_fragment,
                        foodfragment,
                        foodfragment.getTag()).commit();

           /*

            case 9:
                //order
                OrdersFragment ordersfragment = new OrdersFragment();
                 manager = getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.relativelayout_for_fragment,
                        ordersfragment,
                        ordersfragment.getTag()).commit();
                */
            case 1:
                //medicine
                MedicineFragment medicinefragment = new MedicineFragment();
                manager = getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.relativelayout_for_fragment,
                        medicinefragment,
                        medicinefragment.getTag()).commit();
            case 2:
                //account
                AccountFragment accountfragment = new AccountFragment();
                 manager = getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.relativelayout_for_fragment,
                        accountfragment,
                        accountfragment.getTag()).commit();
            case 3:
                //about
                AboutFragment aboutFragment = new AboutFragment();
                manager = getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.relativelayout_for_fragment,
                        aboutFragment,
                        aboutFragment.getTag()).commit();

            default: return new FoodFragment();
        }
    }

    private void setToolbarTitle() {
        getSupportActionBar().setTitle(activityTitles[navItemIndex]);
    }

    private void selectNavMenu() {
        navigationView.getMenu().getItem(navItemIndex).setChecked(true);
    }

    private void setUpNavigationView() {
        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {
                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.nav_food:
                        navItemIndex = 0;
                        CURRENT_TAG = TAG_FOOD;
                        break;
                    case R.id.nav_Fashion:
                        navItemIndex = 1;
                        CURRENT_TAG = TAG_FASHION;
                        break;
                    case R.id.nav_Electronics:
                        navItemIndex = 2;
                        CURRENT_TAG = TAG_ELECTRONICS;
                        break;
                    case R.id.nav_home_furn:
                        navItemIndex = 3;
                        CURRENT_TAG = TAG_HOME_FURN;
                        break;
                    case R.id.nav_books:
                        navItemIndex = 4;
                        CURRENT_TAG = TAG_BOOKS;
                        break;
                    case R.id.nav_medicine:
                        navItemIndex = 5;
                        CURRENT_TAG = TAG_MEDICINE;
                        break;
                    case R.id.nav_utilities:
                        navItemIndex = 6;
                        CURRENT_TAG = TAG_UTILITIES;
                        break;
                    /*case R.id.nav_cart:
                        navItemIndex = 7;
                        CURRENT_TAG = TAG_CART;
                        break;
                    case R.id.nav_notifications:
                        navItemIndex = 8;
                        CURRENT_TAG = TAG_NOTIFICATION;
                        break;
                    case R.id.nav_orders:
                        navItemIndex = 9;
                        CURRENT_TAG = TAG_ORDERS;
                        break;*/
                    case R.id.nav_accunt:
                        navItemIndex = 7;
                        CURRENT_TAG = TAG_ACCOUNT;
                        break;
                    case R.id.nav_about:
                        navItemIndex =8;
                        CURRENT_TAG = TAG_ABOUT;
                        break;

                    default:
                        navItemIndex = 0;
                }
                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);

                loadHomeFragment();

                return true;
            }
        });
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawer.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawers();
            return;
        }

        // This code loads home fragment when back key is pressed
        // when user is in other fragment than home
        if (shouldLoadHomeFragOnBackPress) {
            // checking if user is on other navigation menu
            // rather than home
            if (navItemIndex != 0) {
                navItemIndex = 0;
                CURRENT_TAG = "asdadas";
                loadHomeFragment();
                return;
            }
        }

        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        // show menu only when home fragment is selected
        if (navItemIndex == 0) {
            getMenuInflater().inflate(R.menu.main, menu);
        }

        // when fragment is notifications, load the menu created for notifications
        if (navItemIndex == 3) {
           // getMenuInflater().inflate(R.menu.notifications, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //TODO: make menu for this in main.xml
        /*if (id == R.id.action_logout) {
            Toast.makeText(getApplicationContext(), "Logout user!", Toast.LENGTH_LONG).show();
            return true;
        }

        // user is in notifications fragment
        // and selected 'Mark all as Read'
        if (id == R.id.action_mark_all_read) {
            Toast.makeText(getApplicationContext(), "All notifications marked as read!", Toast.LENGTH_LONG).show();
        }

        // user is in notifications fragment
        // and selected 'Clear All'
        if (id == R.id.action_clear_notifications) {
            Toast.makeText(getApplicationContext(), "Clear all notifications!", Toast.LENGTH_LONG).show();
        }*/

        return super.onOptionsItemSelected(item);
    }
}
