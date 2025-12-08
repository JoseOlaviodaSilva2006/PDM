//essa classe separa o view do DAO

package com.example.aula2;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PlanetaController {
    //ele inicializa o DAO
    private final PlanetaDAO planetaDAO;

    public PlanetaController() {
        this.planetaDAO = new PlanetaDAO();
    }

    //
    public ArrayList<Planeta> getPlaneta() {
        //como o controller não tem dados, ele retorna o dao
        return planetaDAO.getPlanetas();
    }

    public ArrayList<String> getNomePlanetas() {
        //o controller pega os dados brutos e vai transformando
        return planetaDAO.getPlanetas() //pega a lista
                .stream() //cria um fluxo
                .map(Planeta::getNome) //pega só o nome de cada objeto
                .collect(Collectors.toCollection(ArrayList::new)); //transforma numa nova lista
    }
}
