/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import UTIL.MyConnection;
import entities.Evenement;
import entities.Reservation;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
 *
 * @author Chedi
 */
public class ReservationDAO {
    
    
    
    
   public void insertReservation(Reservation r){

       String requete = "insert into reserv(idEvenement,idClient,nbrPlace,classe,dateReservation) values (?,?,?,?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, r.getIdEvenement());
            ps.setInt(2, r.getIdClient());
            ps.setInt(3, r.getNbrPlace());
            ps.setString(4, r.getClasse());
            ps.setString(5, r.getDateReservation());
        
          
            ps.executeUpdate();
            System.out.println("Ajout du client effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }

   
    public void updateNbrPlaceReservation(int nbr,int id){
        String requete = "update reserv set nbrPlace=? where idReserv=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
             ps.setInt(1, nbr);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Mise à jour du nbr de place effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }
    }
   
   public void updateClasseReservation(String classe,int id){
        String requete = "update reserv set classe=? where idReserv=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
             ps.setString(1, classe);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Mise à jour du nbr de place effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }
    }
   

    public void deleteReservation(int id){
        String requete = "delete from reserv where idReserv=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Evenement supprimée");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }
    public Reservation findReservationById(int id){
    Reservation Reservation = new Reservation();
     String requete = "select * from reserv where idReserv=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                Reservation.setIdReservation(resultat.getInt(1));
                Reservation.setIdEvenement(resultat.getInt(2));
                Reservation.setIdClient(resultat.getInt(3));
                Reservation.setNbrPlace(resultat.getInt(4));
                Reservation.setClasse(resultat.getString(5));
                        Reservation.setDateReservation(resultat.getString(7));
                
             
                
            }
            return Reservation;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return null;
        }
    }
   

     
    
    public List<Reservation> DisplayAllReservationsNonAcceptee(){
        
 List<Reservation> listReservation = new ArrayList<Reservation>();

        String requete = "select * from reserv where accepte=0 order by dateReservation";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                
                Reservation Reservation =new Reservation();
                  Reservation.setIdReservation(resultat.getInt(1));
                Reservation.setIdEvenement(resultat.getInt(2));
                Reservation.setIdClient(resultat.getInt(3));
                Reservation.setNbrPlace(resultat.getInt(4));
                Reservation.setClasse(resultat.getString(5));
                Reservation.setDateReservation(resultat.getString(7));

                listReservation.add(Reservation);
            }
            return listReservation;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
            return null;
        }
    }
        public List<Reservation> DisplayAllReservationsAcceptee(){
        
 List<Reservation> listReservation = new ArrayList<Reservation>();

        String requete = "select * from reserv where accepte=1 order by dateReservation";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                
                Reservation Reservation =new Reservation();
                  Reservation.setIdReservation(resultat.getInt(1));
                Reservation.setIdEvenement(resultat.getInt(2));
                Reservation.setIdClient(resultat.getInt(3));
                Reservation.setNbrPlace(resultat.getInt(4));
                Reservation.setClasse(resultat.getString(5));
                        Reservation.setDateReservation(resultat.getString(7));

                listReservation.add(Reservation);
            }
            return listReservation;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
            return null;
        }
    }
    
    public List<Reservation> DisplayAllReservationsAccepteeByEvenement(Evenement e){
        
 List<Reservation> listReservation = new ArrayList<Reservation>();

        String requete = "select * from reserv where accepte=1 where idEvenement=? order by dateReservation";
        try {
             PreparedStatement ps =MyConnection.getInstance().prepareStatement(requete);
           
              ps.setInt(1, e.getIdEvenement());
            ResultSet resultat = ps.executeQuery();

            while(resultat.next()){
                
                Reservation Reservation =new Reservation();
                  Reservation.setIdReservation(resultat.getInt(1));
                Reservation.setIdEvenement(resultat.getInt(2));
                Reservation.setIdClient(resultat.getInt(3));
                Reservation.setNbrPlace(resultat.getInt(4));
                Reservation.setClasse(resultat.getString(5));
                        Reservation.setDateReservation(resultat.getString(7));

                listReservation.add(Reservation);
            }
            return listReservation;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
            return null;
        }
    }
    public List<Reservation> DisplayAllReservationsNonAccepteeByEvenement(Evenement e){
        
 List<Reservation> listReservation = new ArrayList<Reservation>();

        String requete = "select * from reserv where accepte=0 where idEvenement=? order by dateReservation";
        try {
             PreparedStatement ps =MyConnection.getInstance().prepareStatement(requete);
           
              ps.setInt(1, e.getIdEvenement());
            ResultSet resultat = ps.executeQuery();

            while(resultat.next()){
                
                Reservation Reservation =new Reservation();
                  Reservation.setIdReservation(resultat.getInt(1));
                Reservation.setIdEvenement(resultat.getInt(2));
                Reservation.setIdClient(resultat.getInt(3));
                Reservation.setNbrPlace(resultat.getInt(4));
                Reservation.setClasse(resultat.getString(5));
                        Reservation.setDateReservation(resultat.getString(7));

                listReservation.add(Reservation);
            }
            return listReservation;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
            return null;
        }
    }
}
