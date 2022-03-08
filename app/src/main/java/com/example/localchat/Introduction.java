package com.example.localchat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public class Introduction extends Activity {
    int change;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // status which know (user registered or not)
//        change = PrefConfig.loadChange(this);
        // User permission for sending sms

        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }
    // Check if PERMISSION is GRANTED or NOT GRANTED
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1100) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "rugsat berildi", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "rugsat berilmedi", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }
}
