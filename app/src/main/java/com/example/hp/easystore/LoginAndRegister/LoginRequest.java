package com.example.hp.easystore.LoginAndRegister;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hp on 05-Jul-17.
 */

public class LoginRequest extends StringRequest{

    private static final String LOGIN_REQUEST_URL = "url here";
    private Map<String, String> params;

    public LoginRequest(String phno, String passowrd, Response.Listener<String> listener)
    {
        super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null);

        params = new HashMap<>();

        params.put("phno", phno);

        params.put("password", passowrd);
    }


    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
