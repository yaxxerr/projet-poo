package javaapplication2;

import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class JavaApplication2 {
    private static ArrayList<transaction> transactions = new ArrayList<>();
    private static ArrayList<client> clients = new ArrayList<>();
    private static ArrayList<agent> agents = new ArrayList<>();
    private static ArrayList<bienimm> biens = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            String[] options = {
                "Gérer les clients, agents et biens immobiliers",
                "Effectuer une nouvelle transaction",
                "Afficher",
                "Performance de l'agence",
                "Quitter"
            };
            int choice = JOptionPane.showOptionDialog(null, "Choisissez une action", "Menu Principal",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    gererEntities();
                    break;
                case 1:
                    effectuerNouvelleTransaction();
                    break;
                case 2:
                    afficher();
                    break;
                case 3:
                    afficherPerformanceAgence();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    private static void gererEntities() {
        String[] options = {
            "Ajouter/Modifier un client",
            "Ajouter/Modifier un agent",
            "Ajouter/Modifier un bien immobilier"
        };
        int choice = JOptionPane.showOptionDialog(null, "Choisissez une action", "Gestion des Entités",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0:
                gererClients();
                break;
            case 1:
                gererAgents();
                break;
            case 2:
                gererBiensImmobiliers();
                break;
            default:
                break;
        }
    }

    private static void gererClients() {
        String[] options = {"Ajouter un client", "Modifier un client"};
        int choice = JOptionPane.showOptionDialog(null, "Choisissez une action", "Gestion des Clients",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0:
                ajouterClient();
                break;
            case 1:
                modifierClient();
                break;
            default:
                break;
        }
    }

    private static void gererAgents() {
        String[] options = {"Ajouter un agent", "Modifier un agent"};
        int choice = JOptionPane.showOptionDialog(null, "Choisissez une action", "Gestion des Agents",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0:
                ajouterAgent();
                break;
            case 1:
                modifierAgent();
                break;
            default:
                break;
        }
    }

    private static void gererBiensImmobiliers() {
        String[] options = {"Ajouter un bien immobilier", "Modifier un bien immobilier"};
        int choice = JOptionPane.showOptionDialog(null, "Choisissez une action", "Gestion des Biens Immobiliers",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0:
                ajouterBienImmobilier();
                break;
            case 1:
                modifierBienImmobilier();
                break;
            default:
                break;
        }
    }

    private static void ajouterClient() {
        String nom = JOptionPane.showInputDialog("Entrez le nom du client:");
        String prenom = JOptionPane.showInputDialog("Entrez le prénom du client:");
        if (nom != null && prenom != null) {
            client newClient = new client(nom, prenom);
            clients.add(newClient);
            JOptionPane.showMessageDialog(null, "Client ajouté avec succès!");
        }
    }

    private static void modifierClient() {
        client selectedClient = selectClient();
        if (selectedClient == null) return;

        String newNom = JOptionPane.showInputDialog("Entrez le nouveau nom du client:", selectedClient.getNom());
        String newPrenom = JOptionPane.showInputDialog("Entrez le nouveau prénom du client:", selectedClient.getPrenom());

        if (newNom != null && newPrenom != null) {
            selectedClient.setNom(newNom);
            selectedClient.setPrenom(newPrenom);
            JOptionPane.showMessageDialog(null, "Client modifié avec succès!");
        }
    }

    private static void ajouterAgent() {
        String nom = JOptionPane.showInputDialog("Entrez le nom de l'agent:");
        String specialisation = JOptionPane.showInputDialog("Entrez la spécialisation de l'agent:");
        if (nom != null && specialisation != null) {
            agent newAgent = new agent(nom, specialisation);
            agents.add(newAgent);
            JOptionPane.showMessageDialog(null, "Agent ajouté avec succès!");
        }
    }

    private static void modifierAgent() {
        agent selectedAgent = selectAgent();
        if (selectedAgent == null) return;

        String newNom = JOptionPane.showInputDialog("Entrez le nouveau nom de l'agent:", selectedAgent.getNom());
        String newSpecialisation = JOptionPane.showInputDialog("Entrez la nouvelle spécialisation de l'agent:", selectedAgent.getSpecialisation());

        if (newNom != null && newSpecialisation != null) {
            selectedAgent.setNom(newNom);
            selectedAgent.setSpecialisation(newSpecialisation);
            JOptionPane.showMessageDialog(null, "Agent modifié avec succès!");
        }
    }

    private static void ajouterBienImmobilier() {
        String localisation = JOptionPane.showInputDialog("Entrez la localisation du bien:");
        String type = JOptionPane.showInputDialog("Entrez le type du bien:");
        String prixStr = JOptionPane.showInputDialog("Entrez le prix du bien:");
        String tailleStr = JOptionPane.showInputDialog("Entrez la taille du bien (en mètres carrés):");

        if (localisation != null && type != null && prixStr != null && tailleStr != null) {
            try {
                double prix = Double.parseDouble(prixStr);
                double taille = Double.parseDouble(tailleStr);
                bienimm newBien = new bienimm(localisation, type, prix, taille);
                biens.add(newBien);
                JOptionPane.showMessageDialog(null, "Bien immobilier ajouté avec succès!");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Veuillez entrer des valeurs numériques valides pour le prix et la taille.");
            }
        }
    }

    private static void modifierBienImmobilier() {
        bienimm selectedBien = selectBien();
        if (selectedBien == null) return;

        String newLocalisation = JOptionPane.showInputDialog("Entrez la nouvelle localisation du bien:", selectedBien.getLocalisation());
        String newType = JOptionPane.showInputDialog("Entrez le nouveau type du bien:", selectedBien.getType());
        String newPrixStr = JOptionPane.showInputDialog("Entrez le nouveau prix du bien:", selectedBien.getPrix());
        String newTailleStr = JOptionPane.showInputDialog("Entrez la nouvelle taille du bien (en mètres carrés):");

        if (newLocalisation != null && newType != null && newPrixStr != null && newTailleStr != null) {
            try {
                double newPrix = Double.parseDouble(newPrixStr);
                double newTaille = Double.parseDouble(newTailleStr);
                selectedBien.setLocalisation(newLocalisation);
                selectedBien.setType(newType);
                selectedBien.setPrix(newPrix);
                selectedBien.setTaille(newTaille);
                JOptionPane.showMessageDialog(null, "Bien immobilier modifié avec succès!");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Veuillez entrer des valeurs numériques valides pour le prix et la taille.");
            }
        }
    }

    private static void effectuerNouvelleTransaction() {
        client selectedClient = selectClient();
        if (selectedClient == null) return;

        agent selectedAgent = selectAgent();
        if (selectedAgent == null) return;

        bienimm selectedBien = selectBien();
        if (selectedBien == null) return;

        String[] types = {"vente", "achat", "location"};
        String type = (String) JOptionPane.showInputDialog(null, "Sélectionnez le type de transaction", "Type de Transaction",
                JOptionPane.QUESTION_MESSAGE, null, types, types[0]);

        if (type == null) return;

        Calendar date = Calendar.getInstance();

        if ("location".equals(type)) {
            String dateDebutStr = JOptionPane.showInputDialog("Entrez la date de début de location (YYYY-MM-DD):");
            String dateFinStr = JOptionPane.showInputDialog("Entrez la date de fin de location (YYYY-MM-DD):");

            try {
                Calendar dateDebut = parseDate(dateDebutStr);
                Calendar dateFin = parseDate(dateFinStr);
                if (dateDebut.after(dateFin)) {
                    JOptionPane.showMessageDialog(null, "La date de début doit être antérieure à la date de fin.");
                    return;
                }
                transaction newTransaction = new transaction(selectedClient, selectedAgent, date, selectedBien, type, dateDebut, dateFin);
                transactions.add(newTransaction);
                biens.remove(selectedBien);
                selectedClient.addTransaction(newTransaction);
                JOptionPane.showMessageDialog(null, "Transaction de location ajoutée avec succès!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Format de date invalide. Utilisez le format YYYY-MM-DD.");
            }
        } else {
            transaction newTransaction = new transaction(selectedClient, selectedAgent, date, selectedBien, type);
            transactions.add(newTransaction);
            biens.remove(selectedBien);
            selectedClient.addTransaction(newTransaction);
            JOptionPane.showMessageDialog(null, "Transaction de " + type + " ajoutée avec succès!");
        }
    }

    private static Calendar parseDate(String dateStr) throws Exception {
        String[] parts = dateStr.split("-");
        if (parts.length != 3) throw new Exception("Format de date invalide");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]) - 1; // Months are 0-based in Calendar
        int day = Integer.parseInt(parts[2]);
        Calendar date = Calendar.getInstance();
        date.set(year, month, day);
        return date;
    }

    private static void afficher() {
        String[] options = {"Clients", "Biens Immobiliers", "Transactions"};
        int choice = JOptionPane.showOptionDialog(null, "Choisissez une liste à afficher", "Afficher",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0:
                afficherClients();
                break;
            case 1:
                afficherBiensImmobiliers();
                break;
            case 2:
                afficherTransactions();
                break;
            default:
                break;
        }
    }

    private static void afficherClients() {
        StringBuilder sb = new StringBuilder();
        for (client c : clients) {
            sb.append(c).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Liste des clients", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void afficherBiensImmobiliers() {
        StringBuilder sb = new StringBuilder();
        for (bienimm b : biens) {
            sb.append(b).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Liste des biens immobiliers", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void afficherTransactions() {
        StringBuilder sb = new StringBuilder();
        for (transaction t : transactions) {
            sb.append(t).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Historique des transactions", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void afficherPerformanceAgence() {
        int ventes = 0, achats = 0, locations = 0;
        for (transaction t : transactions) {
            switch (t.getType()) {
                case "vente":
                    ventes++;
                    break;
                case "achat":
                    achats++;
                    break;
                case "location":
                    locations++;
                    break;
            }
        }

        String performance = String.format(
                "Performances de l'agence:\nVentes: %d\nAchats: %d\nLocations: %d",
                ventes, achats, locations
        );
        JOptionPane.showMessageDialog(null, performance, "Performance de l'agence", JOptionPane.INFORMATION_MESSAGE);
    }

    private static agent selectAgent() {
        if (agents.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Aucun agent disponible.");
            return null;
        }
        String[] agentNames = agents.stream().map(agent::getNom).toArray(String[]::new);
        String agentName = (String) JOptionPane.showInputDialog(null, "Sélectionnez un agent", "Agents",
                JOptionPane.QUESTION_MESSAGE, null, agentNames, agentNames[0]);
        return agents.stream().filter(a -> a.getNom().equals(agentName)).findFirst().orElse(null);
    }

    private static client selectClient() {
        if (clients.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Aucun client disponible.");
            return null;
        }
        String[] clientNames = clients.stream().map(client -> client.getNom() + " " + client.getPrenom()).toArray(String[]::new);
        String clientName = (String) JOptionPane.showInputDialog(null, "Sélectionnez un client", "Clients",
                JOptionPane.QUESTION_MESSAGE, null, clientNames, clientNames[0]);
        return clients.stream().filter(c -> (c.getNom() + " " + c.getPrenom()).equals(clientName)).findFirst().orElse(null);
    }

    private static bienimm selectBien() {
        if (biens.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Aucun bien immobilier disponible.");
            return null;
        }
        String[] bienDescriptions = biens.stream().map(bienimm::toString).toArray(String[]::new);
        String bienDescription = (String) JOptionPane.showInputDialog(null, "Sélectionnez un bien immobilier", "Biens Immobiliers",
                JOptionPane.QUESTION_MESSAGE, null, bienDescriptions, bienDescriptions[0]);
        return biens.stream().filter(b -> b.toString().equals(bienDescription)).findFirst().orElse(null);
    }
}
