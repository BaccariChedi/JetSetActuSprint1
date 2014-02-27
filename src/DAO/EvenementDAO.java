/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import UTIL.MyConnection;
import entities.Evenement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;


/**
 *
 * @author Ahmed
 */
public class EvenementDAO {
    
 public void insertEvenement(Evenement e){

        String requete = "insert into evenement(type,titre,description,dateEvenement,dateHeure,duree,idAlbum,idImage,idVideo,idLieu,nbrVue) "
                + "values (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1,e.getType());
            ps.setString(2, e.getTitre());
            ps.setString(3, e.getDescription());
            ps.setString(4,  e.getDateEvenement());
            ps.setString(5, e.getDateHeure());
            ps.setDouble(6, e.getDuree());
            ps.setInt(7, e.getIdAlum());
            ps.setInt(8, e.getIdImage());
            ps.setInt(9, e.getIdVideo());
            ps.setInt(10, e.getIdLieu());
            ps.setInt(11, e.getNbrVue());
         ps.executeUpdate();
            System.out.println("Ajout du client effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }

   
    public void updateEvenement(Evenement e,int id){
        String requete = "update evenement set type=? , titre=?, description=?,dateEvenement=?,dateHeure=?,duree=?"
                + ",idAlbum=?,idImage=?,idVideo=?,idLieu=?,nbrVue=? where idEvenement=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
              ps.setString(1,e.getType());
            ps.setString(2, e.getTitre());
            ps.setString(3, e.getDescription());
            ps.setString(4, e.getDateEvenement());
            ps.setString(5, e.getDateHeure());
            ps.setDouble(6, e.getDuree());
            ps.setInt(7, e.getIdAlum());
            ps.setInt(8, e.getIdImage());
            ps.setInt(9, e.getIdVideo());
            ps.setInt(10, e.getIdLieu());
            ps.setInt(11, e.getNbrVue());
            ps.setInt(12, id);
            ps.executeUpdate();
            System.out.println("Mise à jour d'evenement effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }
    }
   
 public void vue(int id){
        String requete = "update evenement set nbrVue=? where idEvenement=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
          ps.setInt(1, findEvenementById(id).getNbrVue()+1);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Mise à jour vue effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }
    }
   

    public void deleteEvenement(int id){
        String requete = "delete from evenement where idEvenement=?";
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
    public Evenement findEvenementById(int id){
    Evenement Evenement = new Evenement();
     String requete = "select * from evenement where idEvenement=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                Evenement.setIdEvenement(resultat.getInt(1));
                Evenement.setType(resultat.getString(2));
                Evenement.setTitre(resultat.getString(3));
                Evenement.setDescription(resultat.getString(4));
                Evenement.setDateEvenement(resultat.getString(5));
                Evenement.setDateHeure(resultat.getString(6));
                Evenement.setDuree(resultat.getDouble(7));
                Evenement.setIdAlum(resultat.getInt(8));
                Evenement.setIdImage(resultat.getInt(9));
                Evenement.setIdVideo(resultat.getInt(10));
                Evenement.setIdLieu(resultat.getInt(11));
                Evenement.setNbrVue(resultat.getInt(12));
             
                
            }
            return Evenement;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return null;
        }
    }

     public Evenement findEvenementByType(String type){
    Evenement Evenement = new Evenement();
     String requete = "select * from evenement where type=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, type);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                Evenement.setIdEvenement(resultat.getInt(1));
                Evenement.setType(resultat.getString(2));
                Evenement.setTitre(resultat.getString(3));
                Evenement.setDescription(resultat.getString(4));
                Evenement.setDateEvenement(resultat.getString(5));
                Evenement.setDateHeure(resultat.getString(6));
                Evenement.setDuree(resultat.getDouble(7));
                Evenement.setIdAlum(resultat.getInt(8));
                Evenement.setIdImage(resultat.getInt(9));
                Evenement.setIdVideo(resultat.getInt(10));
                Evenement.setIdLieu(resultat.getInt(11));
                Evenement.setNbrVue(resultat.getInt(12));
             
                
            }
            return Evenement;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return null;
        }
    } public Evenement findEvenementByTitre(String type){
    Evenement Evenement = new Evenement();
     String requete = "select * from evenement where titre=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, type);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                Evenement.setIdEvenement(resultat.getInt(1));
                Evenement.setType(resultat.getString(2));
                Evenement.setTitre(resultat.getString(3));
                Evenement.setDescription(resultat.getString(4));
                Evenement.setDateEvenement(resultat.getString(5));
                Evenement.setDateHeure(resultat.getString(6));
                Evenement.setDuree(resultat.getDouble(7));
                Evenement.setIdAlum(resultat.getInt(8));
                Evenement.setIdImage(resultat.getInt(9));
                Evenement.setIdVideo(resultat.getInt(10));
                Evenement.setIdLieu(resultat.getInt(11));
                Evenement.setNbrVue(resultat.getInt(12));
             
                
            }
            return Evenement;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return null;
        }
    }
    public Evenement findEvenementByTypeDate(String type){
    Evenement Evenement = new Evenement();
     String requete = "select * from evenement where type=? order by dateEvenement desc";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, type);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                Evenement.setIdEvenement(resultat.getInt(1));
                Evenement.setType(resultat.getString(2));
                Evenement.setTitre(resultat.getString(3));
                Evenement.setDescription(resultat.getString(4));
                Evenement.setDateEvenement(resultat.getString(5));
                Evenement.setDateHeure(resultat.getString(6));
                Evenement.setDuree(resultat.getDouble(7));
                Evenement.setIdAlum(resultat.getInt(8));
                Evenement.setIdImage(resultat.getInt(9));
                Evenement.setIdVideo(resultat.getInt(10));
                Evenement.setIdLieu(resultat.getInt(11));
                Evenement.setNbrVue(resultat.getInt(12));
             
                
            }
            return Evenement;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return null;
        }
    }
    public List<Evenement> DisplayAllEvenement (){
        
 List<Evenement> listeeven = new ArrayList<Evenement>();

        String requete = "select * from evenement ";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                
                Evenement Evenement =new Evenement();
            Evenement.setIdEvenement(resultat.getInt(1));
                Evenement.setType(resultat.getString(2));
                Evenement.setTitre(resultat.getString(3));
                Evenement.setDescription(resultat.getString(4));
                Evenement.setDateEvenement(resultat.getString(5));
                Evenement.setDateHeure(resultat.getString(6));
                Evenement.setDuree(resultat.getDouble(7));
                Evenement.setIdAlum(resultat.getInt(8));
                Evenement.setIdImage(resultat.getInt(9));
                Evenement.setIdVideo(resultat.getInt(10));
                Evenement.setIdLieu(resultat.getInt(11));
                Evenement.setNbrVue(resultat.getInt(12));

                listeeven.add(Evenement);
            }
            return listeeven;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
            return null;
        }
    }
     public List<Evenement> DisplayAllEvenementbyDate (){
        
 List<Evenement> listeeven = new ArrayList<Evenement>();

        String requete = "select * from evenement order by dateEvenement";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                
                Evenement Evenement =new Evenement();
            Evenement.setIdEvenement(resultat.getInt(1));
                Evenement.setType(resultat.getString(2));
                Evenement.setTitre(resultat.getString(3));
                Evenement.setDescription(resultat.getString(4));
                Evenement.setDateEvenement(resultat.getString(5));
                Evenement.setDateHeure(resultat.getString(6));
                Evenement.setDuree(resultat.getDouble(7));
                Evenement.setIdAlum(resultat.getInt(8));
                Evenement.setIdImage(resultat.getInt(9));
                Evenement.setIdVideo(resultat.getInt(10));
                Evenement.setIdLieu(resultat.getInt(11));
                Evenement.setNbrVue(resultat.getInt(12));

                listeeven.add(Evenement);
            }
            return listeeven;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
            return null;
        }
    } 
     public List<Evenement> DisplayAllEvenementByType (String type){
        
 List<Evenement> listeeven = new ArrayList<Evenement>();

        String requete = "select * from evenement where type=? order by type,dateEvenement";
        try {
     PreparedStatement ps =MyConnection.getInstance().prepareStatement(requete);
           
              ps.setString(1, type);
            ResultSet resultat = ps.executeQuery();

            while(resultat.next()){
                
                Evenement Evenement =new Evenement();
            Evenement.setIdEvenement(resultat.getInt(1));
                Evenement.setType(resultat.getString(2));
                Evenement.setTitre(resultat.getString(3));
                Evenement.setDescription(resultat.getString(4));
                Evenement.setDateEvenement(resultat.getString(5));
                Evenement.setDateHeure(resultat.getString(6));
                Evenement.setDuree(resultat.getDouble(7));
                Evenement.setIdAlum(resultat.getInt(8));
                Evenement.setIdImage(resultat.getInt(9));
                Evenement.setIdVideo(resultat.getInt(10));
                Evenement.setIdLieu(resultat.getInt(11));
                Evenement.setNbrVue(resultat.getInt(12));

                listeeven.add(Evenement);
            }
            return listeeven;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
            return null;
        }
    }
   
   

    
   
    
     public List<Evenement> DisplayAllEvenementbyTitreAndType (String Type , String Titre){
        
 List<Evenement> listeeven = new ArrayList<>();

        String requete = "select * from evenement where type ='"+Type+"' and titre='"+Titre+"' ";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                
                Evenement Evenement =new Evenement();
            Evenement.setIdEvenement(resultat.getInt(1));
                Evenement.setType(resultat.getString(2));
                Evenement.setTitre(resultat.getString(3));
                Evenement.setDescription(resultat.getString(4));
                Evenement.setDateEvenement(resultat.getString(5));
                Evenement.setDateHeure(resultat.getString(6));
                Evenement.setDuree(resultat.getDouble(7));
                Evenement.setIdAlum(resultat.getInt(8));
                Evenement.setIdImage(resultat.getInt(9));
                Evenement.setIdVideo(resultat.getInt(10));
                Evenement.setIdLieu(resultat.getInt(11));
                Evenement.setNbrVue(resultat.getInt(12));

                listeeven.add(Evenement);
            }
            return listeeven;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
            return null;
        }
    } 
     

     public List<Evenement> DisplayAllEvenementbyIDAndType (String Type , int Id){
        
 List<Evenement> listeeven = new ArrayList<>();

        String requete = "select * from evenement where type ='"+Type+"' and idEvenement='"+Id+"' ";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                
                Evenement Evenement =new Evenement();
            Evenement.setIdEvenement(resultat.getInt(1));
                Evenement.setType(resultat.getString(2));
                Evenement.setTitre(resultat.getString(3));
                Evenement.setDescription(resultat.getString(4));
                Evenement.setDateEvenement(resultat.getString(5));
                Evenement.setDateHeure(resultat.getString(6));
                Evenement.setDuree(resultat.getDouble(7));
                Evenement.setIdAlum(resultat.getInt(8));
                Evenement.setIdImage(resultat.getInt(9));
                Evenement.setIdVideo(resultat.getInt(10));
                Evenement.setIdLieu(resultat.getInt(11));
                Evenement.setNbrVue(resultat.getInt(12));

                listeeven.add(Evenement);
            }
            return listeeven;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
            return null;
        }
    }
}
