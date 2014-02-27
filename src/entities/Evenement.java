/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.util.Date;

/**
 *
 * @author Chedi
 */
public class Evenement {
    
    private int idEvenement;
    private String type;
    private String titre;
    private String description;
    private String dateEvenement;
    private String DateHeure;
    private double duree;
    private int idAlum;
    private int idImage;
    private int idVideo;
    private int idLieu;
    private int nbrVue;

    public int getIdAlum() {
        return idAlum;
    }

    public void setIdAlum(int idAlum) {
        this.idAlum = idAlum;
    }

    public int getIdEvenement() {
        return idEvenement;
    }

    public String getType() {
        return type;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public String getDateEvenement() {
        return dateEvenement;
    }

    public String getDateHeure() {
        return DateHeure;
    }

    public double getDuree() {
        return duree;
    }

    public int getIdImage() {
        return idImage;
    }

    public int getIdVideo() {
        return idVideo;
    }

    public int getIdLieu() {
        return idLieu;
    }

    public int getNbrVue() {
        return nbrVue;
    }

    public void setIdEvenement(int idEvenement) {
        this.idEvenement = idEvenement;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateEvenement(String dateEvenement) {
        this.dateEvenement = dateEvenement;
    }

    public void setDateHeure(String DateHeure) {
        this.DateHeure = DateHeure;
    }

    public void setDuree(double duree) {
        this.duree = duree;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public void setIdVideo(int idVideo) {
        this.idVideo = idVideo;
    }

    public void setIdLieu(int idLieu) {
        this.idLieu = idLieu;
    }

    public void setNbrVue(int nbrVue) {
        this.nbrVue = nbrVue;
    }

    @Override
    public String toString() {
        return "Evenement{" + "idEvenement=" + idEvenement + ", type=" + type + ", titre=" + titre + ", description=" + description + ", dateEvenement=" + dateEvenement + ", DateHeure=" + DateHeure + ", duree=" + duree + ", idAlum=" + idAlum + ", idImage=" + idImage + ", idVideo=" + idVideo + ", idLieu=" + idLieu + ", nbrVue=" + nbrVue + '}';
    }

   
    
    
    
}
