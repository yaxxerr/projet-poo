package javaapplication2;

import java.util.Calendar;

public class transaction {
    private client client;
    private agent agent;
    private Calendar date;
    private bienimm bien;
    private String type; // vente, achat, location
    private Calendar dateDebut; // Date de début pour une location
    private Calendar dateFin; // Date de fin pour une location
    private static int id;

    public transaction(client client, agent agent, Calendar date, bienimm bien, String type) {
        this.client = client;
        this.agent = agent;
        this.date = date;
        this.bien = bien;
        this.type = type;
        id++;
    }

    public transaction(client client, agent agent, Calendar date, bienimm bien, String type, Calendar dateDebut, Calendar dateFin) {
        this(client, agent, date, bien, type);
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    // Getters and setters
    public void setClient(client client) {
        this.client = client;
    }

    public void setAgent(agent agent) {
        this.agent = agent;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public void setBien(bienimm bien) {
        this.bien = bien;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDateDebut(Calendar dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Calendar dateFin) {
        this.dateFin = dateFin;
    }

    public client getClient() {
        return client;
    }

    public agent getAgent() {
        return agent;
    }

    public Calendar getDate() {
        return date;
    }

    public bienimm getBien() {
        return bien;
    }

    public String getType() {
        return type;
    }

    public Calendar getDateDebut() {
        return dateDebut;
    }

    public Calendar getDateFin() {
        return dateFin;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transaction ID: ").append(id).append("\n");
        sb.append("Client: ").append(client.getNom()).append(" ").append(client.getPrenom()).append("\n");
        sb.append("Agent: ").append(agent.getNom()).append("\n");
        sb.append("Date: ").append(date.getTime()).append("\n");
        sb.append("Bien: ").append(bien.toString()).append("\n");
        sb.append("Type: ").append(type).append("\n");
        if ("location".equals(type)) {
            sb.append("Date début: ").append(dateDebut.getTime()).append("\n");
            sb.append("Date fin: ").append(dateFin.getTime()).append("\n");
        }
        return sb.toString();
    }
}
