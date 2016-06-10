package com.activitymanager;

/**
 * Created by Benedikt on 07.06.2016.
 */


import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Benedikt on 07.03.2016.
 */
public class AddUserToDatabase extends AsyncTask<String,Void,String> {
    private Context context;
    private RegisterLoginActivity mainActivity;


    public AddUserToDatabase(Context context){
        this.context = context;

    }

    @Override
    protected String doInBackground(String... params) {
        String username = params[0];
        String password = params[1];
        String firstName = params[2];
        String lastName = params[3];


        String link;
        String data;
        BufferedReader bufferedReader;
        String result;

        try {
            data = "?username=" + URLEncoder.encode(username, "UTF-8");
            data += "&password=" + URLEncoder.encode(password, "UTF-8");
            data += "&firstName=" + URLEncoder.encode(firstName, "UTF-8");
            data += "&lastName=" + URLEncoder.encode(lastName, "UTF-8");

            link = "http://activitymanageralpha.lima-city.de/signup.php" + data;
            URL url = new URL(link);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            result = bufferedReader.readLine();
            return result;

        } catch (Exception e) {
            return new String("Exception: " + e.getMessage());

        }

    }

    @Override
    public void onPostExecute(String result) {

        String jsonStr = result.toString();
        if(jsonStr != null){
            try{
                JSONObject jsonObject = new JSONObject(jsonStr);

                String query_result = jsonObject.getString("query_result").toString();

                if(query_result.equals("SUCCESS")){
                    Toast.makeText(context, "Data inserted successfully. Signup successfull.", Toast.LENGTH_SHORT).show();
                    RegisterLoginActivity mainActivity = (RegisterLoginActivity)this.context;
                    mainActivity.openActivityOvervivew();



                }
                else if(query_result.equals("FAILURE")){
                    Toast.makeText(context, "User already in Database. Forgot your password?", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(context, "Couldn't connect to remote database.", Toast.LENGTH_SHORT).show();

                }

            }catch(JSONException e){
                e.printStackTrace();
                Toast.makeText(context, "Error parsing JSON data.", Toast.LENGTH_SHORT).show();
            }


        }
        else {
            Toast.makeText(context, "Couldn't get any JSON data.", Toast.LENGTH_SHORT).show();
        }
    }
}
