package javaapplication2;

import java.util.ArrayList;

public class client {
    private static int counter = 0; // Static counter to generate unique IDs
    private int id; // Instance variable to store unique ID
    private String nom;
    private String prenom;
    private ArrayList<transaction> historique;

    // Constructor
    public client(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.historique = new ArrayList<>();
        this.id = ++counter; // Increment counter and assign to id
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public ArrayList<transaction> getHistorique() {
        return historique;
    }

    // Method to add a transaction to the historique
    public void addTransaction(transaction t) {
        historique.add(t);
    }

    // Method to display client details
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", historique=" + historique +
                '}';
    }
}
