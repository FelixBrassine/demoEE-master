package be.technobel.fbrassine.demoee.servlets.service;

import be.technobel.fbrassine.demoee.servlets.model.Voiture;

import java.util.List;

public interface GarageService {

    void ajouter(Voiture toAdd);

    List<Voiture> getAll();

}
