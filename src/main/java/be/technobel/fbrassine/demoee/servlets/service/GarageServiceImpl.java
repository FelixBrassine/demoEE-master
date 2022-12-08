package be.bstorm.akimts.demoee.servlets.service;

import be.bstorm.akimts.demoee.servlets.model.Voiture;

import java.util.ArrayList;
import java.util.List;

public class GarageServiceImpl implements GarageService{


    // region singleton


    private static GarageServiceImpl instance;
    public static GarageServiceImpl getInstance(){
        if(instance == null){
            instance = new GarageServiceImpl();
        }

        return instance;
    }
    private GarageServiceImpl() {
    }


    // endregion

    private final List<Voiture> list = new ArrayList<>();

    @Override
    public void ajouter(Voiture toAdd) {
        list.add(toAdd);
    }

    @Override
    public List<Voiture> getAll() {
        return new ArrayList<>(list);
    }
}
