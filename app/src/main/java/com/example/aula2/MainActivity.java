package com.example.aula2;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView appListView;
    private PackageManager packageManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        setupUI();
        loadInstalledApps();
    }

    private void setupUI() {
        packageManager = getPackageManager();
        appListView = findViewById(R.id.listview_apps);
        appListView.setOnItemClickListener(this::handleItemClick);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void loadInstalledApps() {
        List<ApplicationInfo> installedApps = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);
        AppAdapter adapter = new AppAdapter(this, R.layout.item_lista, installedApps);
        appListView.setAdapter(adapter);
    }

    private void handleItemClick(AdapterView<?> parent, View view, int position, long id) {
        ApplicationInfo selectedApp = (ApplicationInfo) parent.getItemAtPosition(position);
        launchApplication(selectedApp);
    }

    private void launchApplication(ApplicationInfo appInfo) {
        Toast.makeText(this, "Launching: " + appInfo.loadLabel(packageManager), Toast.LENGTH_SHORT).show();

        Intent launchIntent = packageManager.getLaunchIntentForPackage(appInfo.packageName);
        if (launchIntent != null) {
            startActivity(launchIntent);
        } else {
            Toast.makeText(this, "Could not open the application.", Toast.LENGTH_SHORT).show();
        }
    }

}