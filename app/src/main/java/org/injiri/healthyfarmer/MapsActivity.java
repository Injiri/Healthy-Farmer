package org.injiri.healthyfarmer;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;

public class MapsActivity  extends FragmentActivity implements OnMapReadyCallback {

    private static final String TAG = "MapsActivity";
    private GoogleMap googleMap;
    public double latitude;
    public double longitude;
    ProgressDialog progressDialog;

    ArrayList<Carepoint> carepointArrayList;

    boolean isCarePointsLoaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        carepointArrayList = new ArrayList<>();

        getLastKnowLocation();
    }

    public void getLastKnowLocation() {
        FusedLocationProviderClient fusedLocationProviderClient =
                LocationServices.getFusedLocationProviderClient(MapsActivity.this);
        fusedLocationProviderClient.getLastLocation()
                .addOnSuccessListener(new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        latitude = location.getLatitude();
                        longitude = location.getLongitude();

                        LatLng currentUserLocationLatLng = new LatLng(location.getLatitude(), location.getLongitude());


                        googleMap.addMarker(new MarkerOptions()
                                .position(currentUserLocationLatLng)
                                .title("Your Location")).showInfoWindow();

                        moveCameraToDeviceLocation(currentUserLocationLatLng);

                        fetchCarepoints();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
    }

    private void moveCameraToDeviceLocation(LatLng latLng) {
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 8f), 30, null);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        this.googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        this.googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    public void fetchCarepoints() {
        Log.e(TAG, "fetchCarepoints: latitude :" + latitude);
        FetchCarepointsTask fetchCarepointsTask = new FetchCarepointsTask();
        fetchCarepointsTask.execute();
    }

    public void displayProgressDialog(String title) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading ...");
        progressDialog.setMessage(title);
        progressDialog.setCancelable(false);
        progressDialog.show();

    }

    public class FetchCarepointsTask extends AsyncTask<Void, Carepoint, Void> {

        @SuppressLint("LongLogTag")
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            displayProgressDialog("Fetching carepoints");
        }

        @Override
        protected Void doInBackground(Void... voids) {

            StringBuffer carePointsStringBuffer = HttpRequests.getAllAvailableCarepoints(latitude, longitude);

            Log.e(TAG, "doInBackground: carepointsBuffer " + carePointsStringBuffer);

            if (carePointsStringBuffer == null) {
                carePointsStringBuffer = HttpRequests.getAllAvailableCarepoints(latitude, longitude);
            }

            if (carePointsStringBuffer != null) {

                carepointArrayList.clear();
                for (Carepoint carepoint : GeometryController.deserializeCarepointData(carePointsStringBuffer)) {
                    publishProgress(carepoint);
                    Log.e(TAG, "doInBackground: carepoint detail :" + carepoint.getName());
                }
            } else {
                Log.e(TAG, "doInBackground: buffer null");
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Carepoint... values) {
            for (Carepoint value : values) {
                progressDialog.dismiss();
                addCarepointOnMap(value);
                carepointArrayList.add(value);
            }
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            progressDialog.dismiss();
        }
    }

    private void addCarepointOnMap(Carepoint value) {

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.carepoint_market_df);
        BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(bitmap);

        double[] latlng = value.getGeometry();

        LatLng currentUserLocationLatLng = new LatLng(latlng[0], latlng[1]);

        googleMap.addMarker(new MarkerOptions()
                .position(currentUserLocationLatLng)
                .icon(bitmapDescriptor)
                .title(value.getName())).showInfoWindow();
    }
}

