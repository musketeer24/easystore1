package com.example.hp.easystore.fragments;


import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hp.easystore.R;
import com.example.hp.easystore.addbusiness.StoreRegistration;

import java.io.IOException;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment {


    public AccountFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_account, container, false);

        view.findViewById(R.id.addbusiness).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), StoreRegistration.class);
                startActivity(intent);
            }
        });
        // Inflate the layout for this fragment
        return view;


        //here add business button will open registration of store its name, location etc

    }

    private void getLatLngFromAddress(String address) {
        double mLatitude, mLongitude;
        Geocoder geocoder = new Geocoder(getActivity());
        if (geocoder.isPresent()) {
            try {
                List<Address> list = geocoder.getFromLocationName(address, 1);
                Address address1 = list.get(0);
                mLatitude = address1.getLatitude();
                mLongitude = address1.getLongitude();
                Log.i("DETAILS=", String.valueOf(mLatitude + "," + mLongitude));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
