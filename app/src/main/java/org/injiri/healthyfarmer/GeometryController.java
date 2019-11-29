package org.injiri.healthyfarmer;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class GeometryController {

    private static final String TAG = GeometryController.class.getSimpleName();
    public static ArrayList<Carepoint> carePointArrayList = new ArrayList<Carepoint>();

    public static ArrayList<Carepoint> deserializeCarepointData(StringBuffer carepointsStringBuffer) {


        try {

            carePointArrayList.clear();
            JSONObject jsonpObject = new JSONObject(carepointsStringBuffer.toString());
            JSONArray jsonArray = jsonpObject.getJSONArray("results");

            for (int index = 0; index < jsonArray.length(); index++) {

                try {
                    JSONObject jsonObject = jsonArray.getJSONObject(index);
                    Carepoint carepoint = new Carepoint();


                    if (jsonObject.getString("name") != null) {
                        carepoint.setName(jsonObject.getString("name"));

                    } else carepoint.setName("Not Available");

                    try {
                        if (jsonObject.getJSONObject("opening_hours").getBoolean("open_now"))
                            carepoint.setOpeningHours("Opened");
                        else carepoint.setOpeningHours("closed");
                    } catch (Exception e) {
                        carepoint.setOpeningHours("  ");
                    }
                    carepoint.setContact(jsonObject.getString("vicinity"));
                    carepoint.setGeometry(new double[]{jsonObject.getJSONObject("geometry").getJSONObject("location").getDouble("lat"),
                            jsonObject.getJSONObject("geometry").getJSONObject("location").getDouble("lng")});

                    carePointArrayList.add(carepoint);

                } catch (Exception e) {
                    Log.e(TAG, "deserializeCarepointData: " + e);
                }

            }

            return carePointArrayList;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "deserializeCarepointData: " + e);

            return new ArrayList<>();
        }

    }
}
