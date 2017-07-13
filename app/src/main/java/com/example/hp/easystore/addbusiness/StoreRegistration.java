package com.example.hp.easystore.addbusiness;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hp.easystore.R;
import com.example.hp.easystore.activity.Utility.SharedPref;

/**
 * Created by hp on 12-Jul-17.
 */

public class StoreRegistration extends Activity implements View.OnClickListener {
    private EditText etSToreName, etStorephno, etStoreCategory, etTagline, etAddress;
    private Button bRegister;
    private String strStoreName, strStorePhno, strStoreCategory, strTagLine, strAddress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.storeregistration);
        etSToreName = (EditText) findViewById(R.id.etSToreName);
        etStorephno = (EditText) findViewById(R.id.etStorephno);
        etStoreCategory = (EditText) findViewById(R.id.etStoreCategory);
        etTagline = (EditText) findViewById(R.id.etTagline);
        etAddress = (EditText) findViewById(R.id.etAddress);
        bRegister = (Button) findViewById(R.id.bRegister);
        bRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        strStoreName = etSToreName.getText().toString();
        strStorePhno = etStorephno.getText().toString();
        strStoreCategory = etStoreCategory.getText().toString();
        strTagLine = etTagline.getText().toString();
        strAddress = etAddress.getText().toString();
        if (TextUtils.isEmpty(strAddress) && TextUtils.isEmpty(strStoreName) && TextUtils.isEmpty(strStorePhno) && TextUtils.isEmpty(strStoreCategory) && TextUtils.isEmpty(strTagLine)) {
            //all field's are mandatory
            Toast.makeText(this, "All Fields Are Mandatory", Toast.LENGTH_SHORT).show();
        } else {
            //here we are saving business details into the shared preferences
            SharedPref sharedPrefFirst = new SharedPref(this, 1);
            SharedPref sharedPrefSecond = new SharedPref(this, 2);
            SharedPref sharedPrefThird = new SharedPref(this, 3);
            if (new SharedPref(this, 1).getStoreName().equals("null")) {
                sharedPrefFirst.setBussinessDetails(strStoreName, strStorePhno, strStoreCategory, strTagLine, strAddress);
            } else if (new SharedPref(this, 2).getStoreNameSecond().equals("null")) {
                sharedPrefSecond.setBussinessDetails(strStoreName, strStorePhno, strStoreCategory, strTagLine, strAddress);

            } else if (new SharedPref(this, 3).getStoreNameThird().equals("null")) {
                sharedPrefThird.setBussinessDetails(strStoreName, strStorePhno, strStoreCategory, strTagLine, strAddress);

            } else {
                Toast.makeText(this, "Limit exceed", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
