package edu.esprit.entities;

import java.sql.Timestamp;
import java.util.Objects;

public class Reservation {
    private int idReservation;
    private Timestamp dateReser;
    private int ticketsNumber;
    private boolean accessByAdmin;

    // Foreign key
    private Exposition exposition;
    private User client;
    public Reservation(){

    }
    public Reservation(int idReservation, Timestamp dateReser, int ticketsNumber, boolean accessByAdmin, Exposition exposition, User client) {
        this.idReservation = idReservation;
        this.dateReser = dateReser;
        this.ticketsNumber = ticketsNumber;
        this.accessByAdmin = accessByAdmin;
        this.exposition = exposition;
        this.client = client;
    }
    public Reservation( Timestamp dateReser, int ticketsNumber, boolean accessByAdmin, Exposition exposition, User client) {
        this.dateReser = dateReser;
        this.ticketsNumber = ticketsNumber;
        this.accessByAdmin = accessByAdmin;
        this.exposition = exposition;
        this.client = client;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public Timestamp getDateReser() {
        return dateReser;
    }

    public void setDateReser(Timestamp dateReser) {
        this.dateReser = dateReser;
    }

    public int getTicketsNumber() {
        return ticketsNumber;
    }

    public void setTicketsNumber(int ticketsNumber) {
        if (ticketsNumber > 0) {
            this.ticketsNumber = ticketsNumber;
        } else {
            System.out.println("Erreur : Le nombre de tickets doit être positif.");
        }
    }
    public boolean isAccessByAdmin() {
        return accessByAdmin;
    }

    public void setAccessByAdmin(boolean accessByAdmin) {
        this.accessByAdmin = accessByAdmin;
    }

    public Exposition getExposition() {
        return exposition;
    }

    public void setExposition(Exposition exposition) {
        this.exposition = exposition;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation that)) return false;
        return getIdReservation() == that.getIdReservation();
    }

    @Override
    public String toString() {
        return "Reservation{" +

                ", dateReser=" + dateReser +
                ", ticketsNumber=" + ticketsNumber +
                ", accessByAdmin=" + accessByAdmin +
                ", exposition=" + exposition +
                ", client=" + client +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdReservation());
    }
}
