package com.example.syncvision;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    SwitchCompat switcher;
    Boolean nightMODE;
    SharedPreferences sharedpreference;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        setTheme(R.style.DarkTheme);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        switcher = findViewById(R.id.switcher);
        sharedpreference = getSharedPreferences("MODE", Context.MODE_PRIVATE);
        nightMODE = sharedpreference.getBoolean("night",false);
        if (nightMODE){
            switcher.setChecked(true);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        switcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nightMODE){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    editor = sharedpreference.edit();
                    editor.putBoolean("night",false);
                }else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    editor = sharedpreference.edit();
                    editor.putBoolean("night",true);
                }
                editor.apply();
            }
        });
    }
    @Override
    public void onStart(){
        super.onStart();
        Log.d("MainActivity","onStart");

    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d("MainActivity","onPause");

    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d("MainActivity","on resume");

    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d("MainActivity","onStop");
    }

    @Override
    public void onRestart(){
        super.onRestart();
        Log.d("MainActivity","onRestart");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity","on destroy");
    }

    //    TextView tvChangeTheme = findBut(R.id.tvChangeTheme);
//    View.OnClickListener(new View.OnClickListener())
//    tvChangeTheme.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//
//            if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//            } else {
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//            }
//
//            finish();
//            startActivity(new Intent(MainActivity.this, MainActivity.this.getClass()));
//        }
//    });

}