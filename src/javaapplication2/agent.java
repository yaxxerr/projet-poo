package javaapplication2;

public class agent {
    private static int counter = 0; // Static counter to generate unique IDs
    private int id; // Instance variable to store unique ID
    private String nom;
    private String specialisation;

    public agent(String nom, String specialisation) {
        this.nom = nom;
        this.specialisation = specialisation;
        this.id = ++counter; // Increment counter and assign to id
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    // Method to display agent details
    @Override
    public String toString() {
        return "Agent{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", specialisation='" + specialisation + '\'' +
                '}';
    }
}
