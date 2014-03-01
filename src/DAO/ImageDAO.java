/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entities.Image;
import UTIL.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Romdhane
 */
public class ImageDAO {
     public void insertImage(Image i){

        String requete = "insert into image values (default,?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, i.getTitre());
            ps.setString(2,i.getLienImage());
            ps.executeUpdate();
            System.out.println("Ajout Image effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }


    public void updateImage(Image i,int id ){
        String requete = "update image set titre=? ,lienImage=? where idImage=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, i.getTitre());
            ps.setString(2,i.getLienImage());
            ps.setInt(3, id);
            
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès(image)");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }
    }

    public void deleteAlbum(int id){
        String requete = "delete from album where idAlbum=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Album supprimée");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }


    public Image findImageById(int id){
    Image image = new Image();
     String requete = "select * from image where idImage=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                image.setIdImage(resultat.getInt(1));
                image.setTitre(resultat.getString(2));
                image.setLienImage(resultat.getString(3));
            }
            return image;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche de l'image "+ex.getMessage());
            return null;
        }
    }

    public Image findImageByTitre(String titre){
    Image image = new Image();
     String requete = "select * from image where titre = ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, titre);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                image.setIdImage(resultat.getInt(1));
                image.setTitre(resultat.getString(2));
                image.setLienImage(resultat.getString(3));
                
            }
            return image;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche de l'image "+ex.getMessage());
            return null;
        }
    }

    public List<Image> DisplayAllImage(){


        List<Image> listeimage = new ArrayList<Image>();

        String requete = "select * from image";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                Image image =new Image();
                image.setIdImage(resultat.getInt(1));
                image.setTitre(resultat.getString(2));
                image.setLienImage(resultat.getString(3));

                listeimage.add(image);
            }
            return listeimage;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des images "+ex.getMessage());
            return null;
        }
    }
     
    
    
    
    
    public Image findImageByTitreAndLien(String titre, String Lien){
    Image image = new Image();
     String requete = "select * from image where titre = ? and lienImage=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, titre);
            ps.setString(2, Lien);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                image.setIdImage(resultat.getInt(1));
                image.setTitre(resultat.getString(2));
                image.setLienImage(resultat.getString(3));
                
            }
            return image;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche de l'image "+ex.getMessage());
            return null;
        }
    }
    
}
