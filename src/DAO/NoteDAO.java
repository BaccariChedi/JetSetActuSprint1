/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;


import entities.Note;
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
public class NoteDAO {
    public void insertNote(Note n){

        String requete = "insert into note values (default,?,?,?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            //ps.setInt(1, n.getIdNote());
            ps.setInt(1,n.getIdRubrique());
            ps.setInt(2,n.getIdClient());
            ps.setInt(3, (int) n.getNbrEtoile());
            ps.setInt(4,n.getNbrNote());
            ps.executeUpdate();
            System.out.println("Ajout Note effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }


    public void updateNote(Note n,int id ){
        String requete = "update note set idRubrique=? ,idClient=? ,nbrEtoile=?,nbrNote=? where idNote=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, n.getIdRubrique());
            ps.setInt(2,n.getIdClient());
            ps.setInt(3, (int) n.getNbrEtoile());
            ps.setInt(4,n.getNbrNote());
            ps.setInt(5, id);
            
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès(Note)");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }
    }

    public void deleteNote(int id){
        String requete = "delete from note where idNote=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Note supprimée");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }


    public Note findNoteById(int id){
    Note note = new Note();
     String requete = "select * from note where idNote=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                note.setIdNote(resultat.getInt(1));
                note.setIdRubrique(resultat.getInt(2));
                note.setIdClient(resultat.getInt(3));
                note.setNbrEtoile(resultat.getInt(4));
                note.setNbrNote(resultat.getInt(5));
                
            }
            return note;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche de la note "+ex.getMessage());
            return null;
        }
    }

    //public Note findNoteByTitre(String titre){
    //Image image = new Image();
   //  String requete = "select * from image where titre = ?";
       // try {
        //  PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
          //  ps.setString(1, titre);
           // ResultSet resultat = ps.executeQuery();
            //while (resultat.next())
            //{
              //  image.setIdImage(resultat.getInt(1));
                //image.setTitre(resultat.getString(2));
                //image.setLienImage(resultat.getString(3));
                
            //}//
            //return image;

        //} catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
           // System.out.println("erreur lors de la recherche de l'image "+ex.getMessage());
            //return null;
       // }
    //}

    public List<Note> DisplayAllNote(){


        List<Note> listenote = new ArrayList<Note>();

        String requete = "select * from note";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                Note note =new Note();
                note.setIdNote(resultat.getInt(1));
                note.setIdRubrique(resultat.getInt(2));
                note.setIdClient(resultat.getInt(3));
                 note.setNbrEtoile(resultat.getInt(4));
                  note.setNbrNote(resultat.getInt(5));

                listenote.add(note);
            }
            return listenote;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des note "+ex.getMessage());
            return null;
        }
    }
    
}