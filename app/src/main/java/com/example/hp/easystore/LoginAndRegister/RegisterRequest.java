package com.example.hp.easystore.LoginAndRegister;

import android.app.DownloadManager;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hp on 05-Jul-17.
 */

public class RegisterRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "url here";
    private Map<String, String> params;

    public RegisterRequest(String name, String emailid, String phno, String passowrd, Response.Listener<String> listener) {

        super(Method.POST, REGISTER_REQUEST_URL, listener, null);

        params = new HashMap<>();
        params.put("name", name);

        params.put("emailid", emailid);

        params.put("phno", phno);

        params.put("password", passowrd);


    }
    @Override
    public Map<String, String> getParams() {
        return params;
    }
}



