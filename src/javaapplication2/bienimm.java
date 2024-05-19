package javaapplication2;

public class bienimm {
    private static int counter = 0; // Static counter to generate unique IDs
    private int id; // Instance variable to store unique ID
    private String localisation;
    private String type;
    private double prix;
    private double taille;

    public bienimm(String localisation, String type, double prix, double taille) {
        this.localisation = localisation;
        this.type = type;
        this.prix = prix;
        this.taille = taille;
        this.id = ++counter; // Increment counter and assign to id
    }

    // Getters
    public String getLocalisation() {
        return localisation;
    }

    public String getType() {
        return type;
    }

    public double getPrix() {
        return prix;
    }

    public double getTaille() {
        return taille;
    }

    public int getId() {
        return id;
    }

    // Setters
    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    // Method to display property details
    @Override
    public String toString() {
        return "BienImmobilier{" +
                "id=" + id +
                ", localisation='" + localisation + '\'' +
                ", type='" + type + '\'' +
                ", prix=" + prix +
                ", taille=" + taille +
                '}';
    }
}
