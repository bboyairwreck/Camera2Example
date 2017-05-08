package com.ericchee.camera2example;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.container, Camera2BasicFragment.newInstance())
                    .commit();
        }
    }

    public static void requestCameraPermission(Activity activity, int requestCode) {
        if (!hasCameraPermission(activity)) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                // request for location permission
                activity.requestPermissions(new String[]{Manifest.permission.CAMERA}, requestCode);
            }
        } else {
            Log.d("ActivityMain", "Already has Camera permission");
        }
    }

    public static boolean hasCameraPermission(Context context) {
        return (ActivityCompat.checkSelfPermission(context, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED);
    }

}
