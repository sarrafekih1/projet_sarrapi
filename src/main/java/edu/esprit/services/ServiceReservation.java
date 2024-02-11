package edu.esprit.services;

import edu.esprit.entities.Reservation;
import edu.esprit.utils.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

public class ServiceReservation implements IService<Reservation> {
    Connection cnx= DataSource.getInstance().getCnx();


    @Override
    public void ajouter(Reservation r) {
        String req="INSERT INTO `reservation`(`date_reser`, `tickets_number`,`accessByAdmin`,`id_exposition`,`id_user`) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps=cnx.prepareStatement(req);
            ps.setTimestamp(1,r.getDateReser());
            ps.setInt(2,r.getTicketsNumber());
            ps.setBoolean(3,r.isAccessByAdmin());
            ps.setInt(4,r.getExposition().getId());
            ps.setInt(5, r.getClient().getId_user());

            ps.executeUpdate();
            System.out.println("Reservation added!");



        }catch(SQLException e){
            System.out.println(e.getMessage());

        }
    }

    @Override
    public void modifier(Reservation p) {

    }

    @Override
    public void supprimer(int id) {

    }

    @Override
    public Reservation getOneById(int id) {
        return null;
    }

    @Override
    public Set<Reservation> getAll() {
        return null;
    }
}
