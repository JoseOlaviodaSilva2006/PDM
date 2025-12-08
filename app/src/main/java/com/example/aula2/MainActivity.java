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
    //declara a variavel da lista que exibe os planetas
    ListView listViewPlanetas;
    //delcara o controller que vai fornecer os dados
    PlanetaController pController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ativa a tela cheia
        EdgeToEdge.enable(this);
        //conecta o codigo java ao arquivo visual
        setContentView(R.layout.activity_main);

        initComponents();
        pController = new PlanetaController();

        PlanetaAdapter adapter = new PlanetaAdapter(
                this,
            //molde da lista proadapter
                R.layout.item_lista,
                pController.getPlaneta()
        );
//diz pro listview usar o adapter criado
        listViewPlanetas.setAdapter(adapter);

    }

    private void initComponents() {
        listViewPlanetas = findViewById(R.id.listView);
    }

}
