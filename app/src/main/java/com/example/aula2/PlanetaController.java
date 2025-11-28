package com.example.aula2;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PlanetaController {
    private final PlanetaDAO planetaDAO;

    public PlanetaController() {
        this.planetaDAO = new PlanetaDAO();
    }

    public ArrayList<Planeta> getPlaneta() {
        return planetaDAO.getPlanetas();
    }

    public ArrayList<String> getNomePlanetas() {
        return planetaDAO.getPlanetas()
                .stream()
                .map(Planeta::getNome)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
