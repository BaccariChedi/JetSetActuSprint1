/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jetsetactu;

import DAO.CommentaireDAO;
import DAO.EvenementDAO;
import DAO.LieuDAO;
import DAO.ReservationDAO;
import DAO.UserDAO;

import entities.Commentaire;
import entities.Evenement;
import entities.Lieu;
import entities.Reservation;
import entities.User;
import java.io.FileWriter;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.print.attribute.DateTimeSyntax;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Chedi
 */
        /*a.setDateDebut("2014.12.1");*/
       public class Test {
         
    public static void main(String[] args) {
  
        Reservation r=new Reservation();
        ReservationDAO d=new ReservationDAO();
        
        List<Reservation> l=new ArrayList<>();
        l=d.DisplayAllReservationsNonAcceptee();
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }
    }
    
}
      
     
     
       

