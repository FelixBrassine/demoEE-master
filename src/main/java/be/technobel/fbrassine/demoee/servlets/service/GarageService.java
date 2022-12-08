package be.bstorm.akimts.demoee.servlets.service;

import be.bstorm.akimts.demoee.servlets.model.Voiture;

import java.util.List;

public interface GarageService {

    void ajouter(Voiture toAdd);

    List<Voiture> getAll();

}
