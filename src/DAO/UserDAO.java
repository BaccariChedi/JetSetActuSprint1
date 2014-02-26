/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import UTIL.MyConnection;
import entities.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Chedi
 */
public class UserDAO {
    
   public void insertClient(User u){

        String requete = "insert into user(nom,prenom,email,pwd,tel,adresse,dateNaissance,role) values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1,u.getNom());
            ps.setString(2, u.getPrenom());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getPwd());
            ps.setInt(5, u.getTel());
            ps.setString(6, u.getAdresse());
            ps.setString(7, u.getDateNaissance());
            ps.setInt(8, 1);
        
          
            ps.executeUpdate();
            System.out.println("Ajout du client effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }
    

   public void ouvrirSession(int id){

        String requete = "insert into session(idClient) values (?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1,id);
      
        
          
            ps.executeUpdate();
            System.out.println("session ajouté avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }
    public void fermerSession(){

        String requete = "delete from session where idSession=0 ";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            
               
            ps.executeUpdate();
            System.out.println("session fermé avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }
    public void updateUser(User c,int id){
        String requete = "update client set nom=? , prenom=?, dateNaissance=?,email=?,pwd=?,adresse=?"
                + ",tel=? where idUser=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1,c.getNom());
            ps.setString(2, c.getPrenom());
            ps.setString(3, c.getDateNaissance());
            ps.setString(4, c.getEmail());
            ps.setString(5, c.getPwd());
            ps.setString(6, c.getAdresse());
            ps.setInt(7, c.getTel());
            ps.setInt(9, id);
            ps.executeUpdate();
            System.out.println("Mise à jour du client effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }
    }
    public void confirmerClient(int id)
    {
       
            String requete = "update user set valide=1 where idUser=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1,id);
           
            ps.executeUpdate();
            System.out.println("user accepté avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }
        
    }

   

    public void deleteUser(int id){
        String requete = "delete from user where idUser=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("user supprimée");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }
    public int getIdClientbySession()
    {
        String requete = "select * from session where idSession=0";
         try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
     
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
          
              return  resultat.getInt(2);
            }
          

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
           return -1;
        }
          return -1;
    }
    public User findUserById(int id){
    User user = new User();
     String requete = "select * from user where idUser=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                user.setIdUser(resultat.getInt(1));
                user.setNom(resultat.getString(2));
                user.setPrenom(resultat.getString(3));
                user.setEmail(resultat.getString(4));
                user.setPwd(resultat.getString(5));
                user.setTel(resultat.getInt(6));
                user.setAdresse(resultat.getString(7));
                user.setDateNaissance(resultat.getString(8));
                user.setRole(resultat.getInt(9));
                user.setValide(resultat.getInt(10));
                
            }
            return user;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return null;
        }
    }

    public User findCUserByNomOrPrenom(String nomOrPrenom){
    User   user = new User();
     String requete = "select * from user where prenom = ? or nom=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, nomOrPrenom);
            ps.setString(2, nomOrPrenom);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
               user.setIdUser(resultat.getInt(1));
                user.setNom(resultat.getString(2));
                user.setPrenom(resultat.getString(3));
                user.setEmail(resultat.getString(4));
                user.setPwd(resultat.getString(5));
                user.setTel(resultat.getInt(6));
                user.setAdresse(resultat.getString(7));
                user.setDateNaissance(resultat.getString(8));
                user.setRole(resultat.getInt(9));
                user.setValide(resultat.getInt(10));
            }
            return user;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return null;
        }
    }
     public User findCUserByEmail(String email){
    User   user = new User();
     String requete = "select * from user where email = ? ";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, email);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
               user.setIdUser(resultat.getInt(1));
                user.setNom(resultat.getString(2));
                user.setPrenom(resultat.getString(3));
                user.setEmail(resultat.getString(4));
                user.setPwd(resultat.getString(5));
                user.setTel(resultat.getInt(6));
                user.setAdresse(resultat.getString(7));
                user.setDateNaissance(resultat.getString(8));
                user.setRole(resultat.getInt(9));
                user.setValide(resultat.getInt(10));
            }
            return user; 

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return null;
        }
    }
public boolean VerifEmail(String email){
   
     String requete = "select * from user where email = ? ";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, email);
        
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
              return true;
            }
           

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return false;
        }
       return false;
    }

    public int verifUthentification(String email,String pwd)
  {    
       int valide=-1;
       int role;
       String requete = "select * from user where email = ? and pwd = ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, email);
            ps.setString(2, pwd);
            ResultSet resultat = ps.executeQuery();
            if(resultat.next() )
            {      
            role =resultat.getInt(9);
            valide =resultat.getInt(10);
              
            if( role == 2)
            {
                System.out.println("bonjour admin");
                return role;
            }
             if(valide == 0 && role == 1)
            {
                
                System.out.println("bonjour client non validé");
                return valide;
            }
              if(valide == 1 && role == 1)
            {
                System.out.println("bonjour client  validé");
                return role;
            }
            
            }
            else 
            {
                return -1;
            }

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return -2;
        }
        return -1;
  }
    public List<User> DisplayAllUserValide (){
        
 List<User> listeUsert = new ArrayList<User>();

        String requete = "select * from user where valide=1";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                
                User user =new User();
            user.setIdUser(resultat.getInt(1));
                user.setNom(resultat.getString(2));
                user.setPrenom(resultat.getString(3));
                user.setEmail(resultat.getString(4));
                user.setPwd(resultat.getString(5));
                user.setTel(resultat.getInt(6));
                user.setAdresse(resultat.getString(7));
                user.setDateNaissance(resultat.getString(8));
                user.setRole(resultat.getInt(9));
                user.setValide(resultat.getInt(10));

                listeUsert.add(user);
            }
            return listeUsert;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
            return null;
        }
    }
  public List<User> DisplayAllUserNonValide (){
        
 List<User> listUser = new ArrayList<User>();

        String requete = "select * from user where valide=0";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                
                User user =new User();
              user.setIdUser(resultat.getInt(1));
                user.setNom(resultat.getString(2));
                user.setPrenom(resultat.getString(3));
                user.setEmail(resultat.getString(4));
                user.setPwd(resultat.getString(5));
                user.setTel(resultat.getInt(6));
                user.setAdresse(resultat.getString(7));
                user.setDateNaissance(resultat.getString(8));
                user.setRole(resultat.getInt(9));
                user.setValide(resultat.getInt(10));

                listUser.add(user);
            }
            return listUser;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
            return null;
        }
    }
  
 
 
}
