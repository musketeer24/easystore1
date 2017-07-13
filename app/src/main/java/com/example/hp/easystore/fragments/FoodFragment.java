package com.example.hp.easystore.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hp.easystore.R;
import com.example.hp.easystore.subcategoryfragment.AutomotiveandMoreFragment;
import com.example.hp.easystore.subcategoryfragment.BakeryFragment;
import com.example.hp.easystore.subcategoryfragment.BooksStoreFragment;
import com.example.hp.easystore.subcategoryfragment.Camera_AccessoriesFragment;
import com.example.hp.easystore.subcategoryfragment.FastfoodFragment;
import com.example.hp.easystore.subcategoryfragment.FurnitureFragment;
import com.example.hp.easystore.subcategoryfragment.GroceriesFragment;
import com.example.hp.easystore.subcategoryfragment.Kids_BabyFragment;
import com.example.hp.easystore.subcategoryfragment.Kitchen_Diningfragment;
import com.example.hp.easystore.subcategoryfragment.LaptopsFragment;
import com.example.hp.easystore.subcategoryfragment.LightingFragment;
import com.example.hp.easystore.subcategoryfragment.Luggage_TravelFragment;
import com.example.hp.easystore.subcategoryfragment.MenFragment;
import com.example.hp.easystore.subcategoryfragment.Mobiles_AccessoriesFragment;
import com.example.hp.easystore.subcategoryfragment.Pens_stationaryFragment;
import com.example.hp.easystore.subcategoryfragment.PersonalCareFragment;
import com.example.hp.easystore.subcategoryfragment.Printers_MonitorsFragment;
import com.example.hp.easystore.subcategoryfragment.RestaurantFragment;
import com.example.hp.easystore.subcategoryfragment.ServiceCentersFragment;
import com.example.hp.easystore.subcategoryfragment.Sports_FitnessFragment;
import com.example.hp.easystore.subcategoryfragment.TV_HomeappsFragment;
import com.example.hp.easystore.subcategoryfragment.WomenFragment;

import java.lang.reflect.Array;


/**
 * A simple {@link Fragment} subclass.
 */
public class FoodFragment extends Fragment {

    private ListView listView;
    FragmentManager manager;
    String[] contentList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        Log.e("C VAL", getArguments().getString("primaryFragment", "xyzasadsad"));

        switch (getArguments().getString("primaryFragment", "xyzasadsad")) {

            case "food_category":
                contentList = getResources().getStringArray(R.array.food_category);
                break;

            case "fashion_category":
                contentList = getResources().getStringArray(R.array.fashion_category);
                break;

            case "electronics_category":
                contentList = getResources().getStringArray(R.array.electronics_category);
                break;

            case "home_category":
                contentList = getResources().getStringArray(R.array.home_category);
                break;

            case "books_category":
                contentList = getResources().getStringArray(R.array.books_category);
                break;

            case "utilities_category":
                contentList = getResources().getStringArray(R.array.utilities_category);
                break;

            default:
                contentList = getResources().getStringArray(R.array.food_category);
                break;
        }

        //contentList=getData(getArguments().getString("primaryFragment", "xyzasadsad"));


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food, container, false);
        listView = (ListView) view.findViewById(R.id.food_list);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, contentList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                goToNext(position);
            }
        });
        return view;
    }

    private void goToNext(int position) {
        Log.d("TEST", "goToNext" + position);
        String screenName = contentList[position];


        switch (getArguments().getString("primaryFragment", "xyzasadsad")) {

            case "food_category":
                foodCategory(position);
                break;

            case "fashion_category":
                fashionCategory(position);
                break;

            case "electronics_category":
                electronicsCategory(position);
                break;

            case "home_category":
                homeAndFurnitureCategory(position);
                break;

            case "books_category":
                booksCategory(position);
                break;

            case "utilities_category":
                utilitiesCategory(position);
                break;

            default:
                Toast.makeText(getActivity(), "Please try again later", Toast.LENGTH_SHORT).show();
                break;
        }
/*
        //GroceriesFragment gF = GroceriesFragment.newInstance(screenName, "dum");
        GroceriesFragment gF = new GroceriesFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout, gF);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.addToBackStack(null);
        ft.commit();*/
    }

    private void foodCategory(int position) {

        FragmentTransaction ft = getFragmentManager().beginTransaction();

        switch (position) {
            case 0:
                GroceriesFragment gF = new GroceriesFragment();
                ft.replace(R.id.frameLayout, gF);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
                break;
            case 1:

                FastfoodFragment fF = new FastfoodFragment();
                ft.replace(R.id.frameLayout, fF);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
                break;
            case 2:

                RestaurantFragment restaurantFragment = new RestaurantFragment();
                ft.replace(R.id.frameLayout, restaurantFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
                break;
            case 3:

                BakeryFragment bakeryFragment = new BakeryFragment();
                ft.replace(R.id.frameLayout, bakeryFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
                break;
        }
    }

    private void fashionCategory(int position) {

        FragmentTransaction ft = getFragmentManager().beginTransaction();

        switch (position) {
            case 0:
                MenFragment gF = new MenFragment();
                ft.replace(R.id.frameLayout, gF);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
                break;
            case 1:
                WomenFragment womenFragment = new WomenFragment();
                ft.replace(R.id.frameLayout, womenFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
                break;

            case 2:
                Kids_BabyFragment kids_babyFragment = new Kids_BabyFragment();
                ft.replace(R.id.frameLayout, kids_babyFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
                break;

            case 3:
                PersonalCareFragment personalCareFragment = new PersonalCareFragment();
                ft.replace(R.id.frameLayout, personalCareFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
                break;

        }
    }

    private void electronicsCategory(int position) {

        FragmentTransaction ft = getFragmentManager().beginTransaction();

        switch (position) {
            case 0:
                Mobiles_AccessoriesFragment mobiles_accessoriesFragment = new Mobiles_AccessoriesFragment();
                ft.replace(R.id.frameLayout, mobiles_accessoriesFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
                break;

            case 1:
                TV_HomeappsFragment tv_homeappsFragment = new TV_HomeappsFragment();
                ft.replace(R.id.frameLayout, tv_homeappsFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
                break;

            case 2:
                LaptopsFragment laptopsFragment = new LaptopsFragment();
                ft.replace(R.id.frameLayout, laptopsFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
                break;

            case 3:
                Printers_MonitorsFragment printers_monitorsFragment = new Printers_MonitorsFragment();
                ft.replace(R.id.frameLayout, printers_monitorsFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
                break;

            case 4:
                Camera_AccessoriesFragment camera_accessoriesFragment = new Camera_AccessoriesFragment();
                ft.replace(R.id.frameLayout, camera_accessoriesFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
                break;

        }
    }

    private void homeAndFurnitureCategory(int position) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        switch (position) {
            case 0:
                FurnitureFragment furnitureFragment = new FurnitureFragment();
                ft.replace(R.id.frameLayout, furnitureFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
                break;

            case 1:
                Kitchen_Diningfragment kitchen_diningfragment = new Kitchen_Diningfragment();
                ft.replace(R.id.frameLayout, kitchen_diningfragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
                break;

            case 2:
                LightingFragment lightingFragment = new LightingFragment();
                ft.replace(R.id.frameLayout, lightingFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
                break;

        }
    }

    private void booksCategory(int position) {

        FragmentTransaction ft = getFragmentManager().beginTransaction();

        switch (position) {
            case 0:
                BooksStoreFragment booksStoreFragment = new BooksStoreFragment();
                ft.replace(R.id.frameLayout, booksStoreFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
                break;

            case 1:
                Pens_stationaryFragment pens_stationaryFragment = new Pens_stationaryFragment();
                ft.replace(R.id.frameLayout, pens_stationaryFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
                break;

        }
    }

    private void medicineCategory(int position) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        MedicineFragment medicineFragment = new MedicineFragment();
        ft.replace(R.id.frameLayout, medicineFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.addToBackStack(null);
        ft.commit();
    }

    private void utilitiesCategory(int position) {

        FragmentTransaction ft = getFragmentManager().beginTransaction();

        switch (position) {
            case 0:
                Sports_FitnessFragment sports_fitnessFragment = new Sports_FitnessFragment();
                ft.replace(R.id.frameLayout, sports_fitnessFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
                break;

            case 1:
                Luggage_TravelFragment luggage_travelFragment = new Luggage_TravelFragment();
                ft.replace(R.id.frameLayout, luggage_travelFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
                break;

            case 2:
                ServiceCentersFragment serviceCentersFragment = new ServiceCentersFragment();
                ft.replace(R.id.frameLayout, serviceCentersFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
                break;

            case 3:
                AutomotiveandMoreFragment automotiveandMoreFragment = new AutomotiveandMoreFragment();
                ft.replace(R.id.frameLayout, automotiveandMoreFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
                break;

        }
    }


}
