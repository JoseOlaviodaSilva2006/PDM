package com.example.aula2;

import java.util.ArrayList;
import java.util.Arrays;

public class PlanetaDAO {
    private final ArrayList<Planeta> planetas;

    public PlanetaDAO() {
        planetas = new ArrayList<>();
        planetas.add(new Planeta("Sol", R.drawable.sun));
        planetas.add(new Planeta("Mercúrio", R.drawable.mercury));
        planetas.add(new Planeta("Vênus", R.drawable.venus));
        planetas.add(new Planeta("Terra", R.drawable.earth));
        planetas.add(new Planeta("Marte", R.drawable.mars));
        planetas.add(new Planeta("Júpiter", R.drawable.jupter));
        planetas.add(new Planeta("Saturno", R.drawable.saturn));
        planetas.add(new Planeta("Urano", R.drawable.uranus));
        planetas.add(new Planeta("Netuno", R.drawable.neptune));
    }

    public ArrayList<Planeta> getPlanetas() {
        return planetas;
    }
}
