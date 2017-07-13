package com.example.hp.easystore.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.hp.easystore.fragments.AboutFragment;
import com.example.hp.easystore.R;
import com.example.hp.easystore.fragments.AccountFragment;
//import com.example.hp.easystore.fragments.BooksFragment;
//import com.example.hp.easystore.fragments.ElectronicsFragment;
//import com.example.hp.easystore.fragments.FashionFragment;
import com.example.hp.easystore.fragments.FoodFragment;
//import com.example.hp.easystore.fragments.HomeFragment;
import com.example.hp.easystore.fragments.MedicineFragment;
//import com.example.hp.easystore.fragments.UtilitiesFragment;

public class NavigationDrawerHome extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        FragmentManager manager;
        boolean openListFrag=false;
        FoodFragment foodfragment = new FoodFragment();
        Bundle b=new Bundle();
        switch (item.getItemId()) {
            case R.id.nav_food:
                //food


                b.putString("primaryFragment","food_category");
                openListFrag=true;
                //Dummy to open google map here
             /*   MapsFragment mapsFragment = new MapsFragment();
                manager = getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.frameLayout, mapsFragment, mapsFragment.getTag()).commit();
             */
             break;
            case R.id.nav_Fashion:
                //fashion
                b.putString("primaryFragment","fashion_category");
                openListFrag=true;

                break;

            case R.id.nav_Electronics:
                //electronics
                b.putString("primaryFragment","electronics_category");
                openListFrag=true;
                break;

            case R.id.nav_home_furn:
                //home_furn
                b.putString("primaryFragment","home_category");
                openListFrag=true;

                break;
            case R.id.nav_books:
                //books
                b.putString("primaryFragment","books_category");
                openListFrag=true;

                break;
            case R.id.nav_medicine:
                //medicine
                MedicineFragment medicinefragment = new MedicineFragment();
                manager = getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.frameLayout,
                        medicinefragment,
                        medicinefragment.getTag()).commit();
                break;
            case R.id.nav_utilities:
                //utilities
                b.putString("primaryFragment","utilities_category");
                openListFrag=true;

                break;

            case R.id.nav_accunt:
                //account
                AccountFragment accountfragment = new AccountFragment();
                manager = getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.frameLayout,
                        accountfragment,
                        accountfragment.getTag()).commit();
                break;
            case R.id.nav_about:
                //about
                AboutFragment aboutFragment = new AboutFragment();
                manager = getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.frameLayout,
                        aboutFragment,
                        aboutFragment.getTag()).commit();
            default:
                Log.d("Tag", "not selected");
        }
        if(openListFrag) {
            Log.e("B VAL", b.getString("primaryFragment"));
            foodfragment.setArguments(b);
            manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.frameLayout,
                    foodfragment,
                    foodfragment.getTag()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
