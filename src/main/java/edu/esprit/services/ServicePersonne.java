package edu.esprit.services;

import edu.esprit.entities.User;
import edu.esprit.utils.DataSource;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class ServicePersonne implements IService<User> {
    Connection cnx= DataSource.getInstance().getCnx();
    @Override
    public void ajouter(User p) {

    }

    @Override
    public void modifier(User p) {

    }

    @Override
    public void supprimer(int id) {

    }

    @Override
    public User getOneById(int id) {
        return null;
    }

    @Override
    public Set<User> getAll() {
        Set<User> personnes = new HashSet<>();

        String req = "Select * from user";
        try {
            Statement st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);
            while (res.next()){
                int id = res.getInt(1);
                String nom = res.getString("nom_user");
                String prenom = res.getString(3);
                String email = res.getString(4);
                String mdp = res.getString(5);
                String num_tel = res.getString(6);
                Date d_naissance = res.getDate("date_de_naissance");
                String carte_pro = res.getString(8);
                String role = res.getString(9);
                User p = new User(id,nom,prenom,email,mdp,num_tel,d_naissance,carte_pro,role);
                personnes.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return personnes;
    }
}
