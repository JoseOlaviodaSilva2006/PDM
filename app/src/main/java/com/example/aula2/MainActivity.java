package com.example.aula2;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listViewPlanetas;
    PlanetaController pController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        initComponents();
        pController = new PlanetaController();

        PlanetaAdapter adapter = new PlanetaAdapter(
                this,
                R.layout.item_lista,
                pController.getPlaneta()
        );

        listViewPlanetas.setAdapter(adapter);

    }

    private void initComponents() {
        listViewPlanetas = findViewById(R.id.listView);
    }

}