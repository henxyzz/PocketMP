
package com.pocketmp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {
    private Button startServerBtn;
    private TextView serverStatus;
    private SwitchMaterial themeSwitch;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startServerBtn = findViewById(R.id.startServerBtn);
        serverStatus = findViewById(R.id.serverStatus);
        themeSwitch = findViewById(R.id.themeSwitch);

        setupServer();
        setupThemeSwitch();
    }

    private void setupServer() {
        startServerBtn.setOnClickListener(v -> {
            // Implementasi start server
            PocketMineServer.start(19132, "0.0.0.0");
            serverStatus.setText("Server berjalan di port 19132");
        });
    }

    private void setupThemeSwitch() {
        themeSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        });
    }
}
