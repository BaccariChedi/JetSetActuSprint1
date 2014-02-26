/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 package DAO;


import entities.Video;
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
public class VideoDAO {
    public void insertVideo(Video v){

        String requete = "insert into video values (default,?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, v.getTitre());
            ps.setString(2,v.getLienVideo());
            ps.executeUpdate();
            System.out.println("Ajout video effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }


    public void updateVideo(Video v,int id ){
        String requete = "update image set titre=? ,lienImage=? where idImage=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, v.getTitre());
            ps.setString(2,v.getLienVideo());
            ps.setInt(3, id);
            
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès(video)");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }
    }

    public void deleteVideo(int id){
        String requete = "delete from video where idVideo=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("video supprimée");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }


    public Video findVideoById(int id){
    Video video = new Video();
     String requete = "select * from video where idVideo=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                video.setIdVideo(resultat.getInt(1));
                video.setTitre(resultat.getString(2));
                video.setLienVideo(resultat.getString(3));
            }
            return video;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche de la video "+ex.getMessage());
            return null;
        }
    }

    public Video findVideoByTitre(String titre){
    Video video = new Video();
     String requete = "select * from video where titre = ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, titre);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                video.setIdVideo(resultat.getInt(1));
                video.setTitre(resultat.getString(2));
                video.setLienVideo(resultat.getString(3));
                
            }
            return video;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche de la video "+ex.getMessage());
            return null;
        }
    }

    public List<Video> DisplayAllVideo(){


        List<Video> listevideo = new ArrayList<Video>();

        String requete = "select * from video";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                Video video =new Video();
                video.setIdVideo(resultat.getInt(1));
                video.setTitre(resultat.getString(2));
                video.setLienVideo(resultat.getString(3));

                listevideo.add(video);
            }
            return listevideo;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des video "+ex.getMessage());
            return null;
        }
    }
    
}
