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
 * Created by Benedikt on 21.04.2016.
 */
public class GetUserFromDatabase extends AsyncTask<String,Void,String> {

    private String firstName;
    private Context context;
    private RegisterLoginActivity mainActivity;
    private HttpURLConnection con = null;


    public GetUserFromDatabase(Context context){
        this.context = context;

    }

    @Override
    protected String doInBackground(String... params) {
        String firstName = params[0];
        String lastName = params[1];


        this.firstName = firstName;





        String link;
        String data;
        BufferedReader bufferedReader;
        String result;

        try {
            data = "?username=" + URLEncoder.encode(firstName, "UTF-8");
            data += "&password=" + URLEncoder.encode(lastName, "UTF-8");
            link = "http://activitymanageralpha.lima-city.de/get_users.php" + data;
            URL url = new URL(link);
            con = (HttpURLConnection) url.openConnection();

            bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            result = bufferedReader.readLine();
            return result;

        } catch (Exception e) {
            return new String("Exception: " + e.getMessage());

        }

    }

    @Override
    public void onPostExecute(String result) {

        Toast.makeText(context, this.firstName, Toast.LENGTH_SHORT).show();
        String jsonStr = result.toString();
        if(jsonStr != null){

            try{
                JSONObject jsonObject = new JSONObject(jsonStr);

                String query_result = jsonObject.getString("query_result").toString();

                if(query_result.equals("success")){
                    Toast.makeText(context, "Login successful!", Toast.LENGTH_SHORT).show();
                    RegisterLoginActivity mainActivity = (RegisterLoginActivity)this.context;
                    mainActivity.openActivityOvervivew();



                }
                else if(query_result.equals("failed")){
                    Toast.makeText(context, "First- or Last name not correct. Need help?", Toast.LENGTH_SHORT).show();

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
