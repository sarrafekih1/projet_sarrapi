package edu.esprit.tests;
import edu.esprit.entities.Exposition;
import edu.esprit.entities.Reservation;
import edu.esprit.entities.User;
import edu.esprit.services.ServiceExposition;
import edu.esprit.services.ServicePersonne;
import edu.esprit.services.ServiceReservation;
import edu.esprit.utils.DataSource;

import java.security.Provider;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        DataSource dataSource = DataSource.getInstance();
        dataSource.getCnx();

        ServicePersonne personne=new ServicePersonne();
        ServiceExposition exposition=new ServiceExposition();
        ServiceReservation reservation=new ServiceReservation();

        Exposition e=new Exposition();
        User p = new User();
        Reservation r = new Reservation();

///////////////:REESERVATION/::::::::::::::::::::::::::::
        // Création d'une réservation
//        r.setDateReser(Timestamp.valueOf(LocalDateTime.now())); // Utilisation de la date actuelle
//        r.setTicketsNumber(4);
//        r.setAccessByAdmin(false);
//        Exposition exp_add_reser=exposition.getOneById(9);
//        r.setExposition(exp_add_reser); // Association avec l'exposition1
//        User user_add_rese=personne.getOneById(1);
//        r.setClient(user_add_rese); //
//        reservation.ajouter(r);

//        //modifier reservation
//        r.setIdReservation(1);
//        r.setDateReser(Timestamp.valueOf(LocalDateTime.now())); // Utilisation de la date actuelle
//        r.setTicketsNumber(10);
//        r.setAccessByAdmin(true);
//        Exposition exp_reser=exposition.getOneById(4);
//        r.setExposition(exp_reser); // Association avec l'exposition1
//        User user_rese=personne.getOneById(1);
//        r.setClient(user_rese); //
//        reservation.modifier(r);

        //get  id de  reservation
//    System.out.println(reservation.getOneById(1));

        //afficher tout les reservations
        //System.out.println(reservation.getAll());

        //delete reservation
//        reservation.supprimer(6);

        //tri par date ancienne
        //System.out.println(reservation.triparDateAncienne());






        ///////////////:EXPOSITION/::::::::::::::::::::::::::::

////////********ajouterrrrr exposition********////////
//        e.setNom("kitty");
//        e.setTheme("magic");
//        e.setDateDebut(Timestamp.valueOf(LocalDateTime.of(2022, 4, 1, 12, 0))); // Remplacez avec votre date et heure de début
//        e.setDateFin(Timestamp.valueOf(LocalDateTime.of(2022, 5, 10, 18, 0)));
//        e.setDescription("mlkjhgf");
//        e.setImage("/images/art/comique");
//        exposition.ajouter(e);

        //////////afficher///////////
       // System.out.println(exposition.getAll());

        //////////modifier////////
        // Modification de l'exposition
//        e.setId(10);
//        e.setNom("kitty");
//        e.setDescription("Nouvelle description");
//        e.setDateDebut(Timestamp.valueOf(LocalDateTime.of(2022, 3, 10, 19, 0)));
//        e.setDateFin(Timestamp.valueOf(LocalDateTime.of(2022, 5, 10, 19, 0)));
//        e.setTheme("love");
//        e.setImage("/images/image_modifiee.jpg");
//        exposition.modifier(e);
//
//
//        System.out.println("Après modification :");
//        System.out.println(exposition.getAll());

        ////*********afficher par id********//
//        System.out.println(exposition.getOneById(4));

        ////******deleted*****//////
//        exposition.supprimer(7);

        //chercher//
       // System.out.println(exposition.chercherParThemeOuNom("magic",""));





       // System.out.println(personne.getAll());
    }
    }
