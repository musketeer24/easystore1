package com.example.hp.easystore.subcategoryfragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.easystore.R;
import com.example.hp.easystore.activity.Utility.SharedPref;
import com.example.hp.easystore.subcategoryfragment.GroceryController.GroceryAdapter;
import com.example.hp.easystore.subcategoryfragment.GroceryController.GroceryPojo;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Pens_stationaryFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Pens_stationaryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Pens_stationaryFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Pens_stationaryFragment.OnFragmentInteractionListener mListener;
    //New Variable
    private List<GroceryPojo> groceryPojoList = new ArrayList<>();
    private RecyclerView groceryRecyclerView;
    private GroceryAdapter groceryAdapter;

    public Pens_stationaryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GroceriesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Pens_stationaryFragment newInstance(String param1, String param2) {
        Pens_stationaryFragment fragment = new Pens_stationaryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    /*@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_groceries_list, container, false);
        groceryRecyclerView = (RecyclerView) view.findViewById(R.id.recylerview_groceries_list);
        groceryAdapter = new GroceryAdapter(groceryPojoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        groceryRecyclerView.setLayoutManager(layoutManager);
        groceryRecyclerView.setItemAnimator(new DefaultItemAnimator());
        groceryRecyclerView.setAdapter(groceryAdapter);
        storedummyGroceryList();
        return view;
    }

    private void storedummyGroceryList() {

        //get data from shared preferences
        SharedPref sharedPrefFirst = new SharedPref(getActivity(), 1);
        SharedPref sharedPrefSecond = new SharedPref(getActivity(), 2);
        SharedPref sharedPrefThird = new SharedPref(getActivity(), 3);
        if (!sharedPrefFirst.getStoreName().equals("null")&& sharedPrefFirst.getStoreCategory().equals("pens and stationary")) {
            //shared pref is empty
        /*    GroceryPojo groceryPojo = new GroceryPojo("ABC STORE", "9524562522", "SCO-545 SECTOR 6 KARNAL", "We are top level books and magazine providers in karnal");
            groceryPojoList.add(groceryPojo);

            groceryPojo = new GroceryPojo("XYZ STORE", "9524562522", "SCO-567 SECTOR 7 KARNAL", "We are top level books and magazine providers in karnal");
            groceryPojoList.add(groceryPojo);
*/
            GroceryPojo groceryPojo = new GroceryPojo(sharedPrefFirst.getStoreName(), sharedPrefFirst.getStorePhoneNo(), sharedPrefFirst.getStoreAddress(), sharedPrefFirst.getStoreTagLine());
            groceryPojoList.add(groceryPojo);

        }
        if (!sharedPrefSecond.getStoreNameSecond().equals("null")&& sharedPrefFirst.getStoreCategory().equals("pens and stationary")) {
            GroceryPojo groceryPojo = new GroceryPojo(sharedPrefSecond.getStoreNameSecond(), sharedPrefSecond.getStorePhoneNoSecond(), sharedPrefSecond.getStoreAddressSecond(), sharedPrefSecond.getStoreTagLineSecond());
            groceryPojoList.add(groceryPojo);

        }
        if (!sharedPrefThird.getStoreNameThird().equals("null")&& sharedPrefFirst.getStoreCategory().equals("pens and stationary")) {
            GroceryPojo groceryPojo = new GroceryPojo(sharedPrefThird.getStoreNameThird(), sharedPrefThird.getStorePhoneNoThird(), sharedPrefThird.getStoreAddressThird(), sharedPrefThird.getStoreTagLineThird());
            groceryPojoList.add(groceryPojo);

        }


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
       /* if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
