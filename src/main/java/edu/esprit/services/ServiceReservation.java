package edu.esprit.services;

import edu.esprit.entities.Exposition;
import edu.esprit.entities.Reservation;
import edu.esprit.entities.User;
import edu.esprit.utils.DataSource;

import java.sql.*;
import java.util.HashSet;
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
            ps.setInt(4, r.getExposition().getId());
            ps.setInt(5,r.getClient().getId_user());

            ps.executeUpdate();
            System.out.println("Reservation added!");



        }catch(SQLException e){
            System.out.println(e.getMessage());

        }
    }

    @Override
    public void modifier(Reservation r) {
        String req = "UPDATE reservation SET date_reser=?, tickets_number=?, accessByAdmin=?, id_exposition=?, id_user=? WHERE id_reservation=?";
        try{
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setTimestamp(1, r.getDateReser());
            ps.setInt(2,r.getTicketsNumber());
            ps.setBoolean(3,r.isAccessByAdmin());
            ps.setInt(4, r.getExposition().getId());
            ps.setInt(5,r.getClient().getId_user());
            ps.setInt(6, r.getIdReservation());
            ps.executeUpdate();
            System.out.println("reservation modifié  !");




        }catch (SQLException e) {
            System.out.println(e.getMessage());

        }


    }

    @Override
    public void supprimer(int id) {
        String req = "DELETE FROM reservation WHERE id_reservation=?";
        try{
            PreparedStatement ps=cnx.prepareStatement(req);
            ps.setInt(1,id);
            ps.executeUpdate();
            System.out.println("reservation deleted succesfully !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }


    }

    @Override
    public Reservation getOneById(int id) {
        String req = "SELECT * FROM reservation WHERE id_reservation=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id); //  the value for the placeholder
            ResultSet res = ps.executeQuery(); // Execution ta3 prepared statement

            if (res.next()) {
                Timestamp datereser = res.getTimestamp("Date_reser");
                int ticketsNumber = res.getInt("tickets_number");
                Boolean accessByAdmin = res.getBoolean("accessByAdmin");
                int idExposition = res.getInt("id_exposition");
                int id_user = res.getInt("id_user");

                ServiceExposition serviceExposition = new ServiceExposition();
                Exposition exposition = serviceExposition.getOneById(idExposition);

                ServicePersonne servicePersonne = new ServicePersonne();
                User user = servicePersonne.getOneById(id_user);

                System.out.println("reservation mijouda  !");
                return new Reservation(id, datereser, ticketsNumber, accessByAdmin, exposition, user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public Set<Reservation> getAll() {
        Set<Reservation> reservations=new HashSet<>();
        String req="SELECT * FROM reservation";
        try{
            Statement st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);
            while(res.next()){
                int id = res.getInt(1);
                Timestamp datereser = res.getTimestamp("Date_reser");
                int ticketsNumber = res.getInt("tickets_number");
                Boolean accessByAdmin = res.getBoolean("accessByAdmin");
                int idExposition = res.getInt("id_exposition");
                int id_user = res.getInt("id_user");

                ServiceExposition serviceExposition = new ServiceExposition();
                Exposition exposition = serviceExposition.getOneById(idExposition);

                ServicePersonne servicePersonne = new ServicePersonne();
                User user = servicePersonne.getOneById(id_user);


                Reservation reser=new Reservation(id, datereser, ticketsNumber, accessByAdmin, exposition, user);
                reservations.add(reser);
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return reservations;
    }

}



