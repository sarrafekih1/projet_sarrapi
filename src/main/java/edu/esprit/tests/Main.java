package edu.esprit.tests;
import edu.esprit.entities.Exposition;
import edu.esprit.entities.Reservation;
import edu.esprit.entities.User;
import edu.esprit.services.ServiceExposition;
import edu.esprit.services.ServicePersonne;
import edu.esprit.services.ServiceReservation;
import edu.esprit.utils.DataSource;
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

        //Reservation r=new Reservation();
        //r.setDateReser(new Timestamp(System.currentTimeMillis()));
        //r.setTicketsNumber(2);
       // r.setAccessByAdmin(true);
       // r.setExposition(Exposition);
       // r.setClient(new User());

////////********ajouterrrrr exposition********////////
//        e.setNom("hellll");
//        e.setTheme("magic");
//        e.setDateDebut(Timestamp.valueOf(LocalDateTime.of(2022, 3, 1, 10, 0))); // Remplacez avec votre date et heure de début
//        e.setDateFin(Timestamp.valueOf(LocalDateTime.of(2022, 3, 10, 18, 0)));
//        e.setDescription("mlkjhgf");
//        e.setImage("/images/art/comique");
//        exposition.ajouter(e);

        //////////afficher///////////
        System.out.println(exposition.getAll());

        //////////modifier////////
        // Modification de l'exposition
//        e.setId(1);
//        e.setNom("Exposition Modifiée");
//        e.setDescription("Nouvelle description");
//        e.setDateFin(Timestamp.valueOf(LocalDateTime.of(2022, 3, 10, 19, 0)));
//        e.setTheme("Nouveau thème");
//        e.setImage("/images/image_modifiee.jpg");
//        exposition.modifier(e);
//
//
//        System.out.println("Après modification :");
//        System.out.println(exposition.getAll());

        ////*********afficher par id********//
        System.out.println(exposition.getOneById(4));

        ////******deleted*****//////
        exposition.supprimer(7);





       // System.out.println(personne.getAll());
    }
    }
