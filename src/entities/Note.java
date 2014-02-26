/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

/**
 *
 * @author aymen
 */
public class Note {
    private int idNote;
    private int idRubrique;
    private int idClient;
    private double nbrEtoile;
    private int nbrNote;

    public int getIdNote() {
        return idNote;
    }

    public void setIdNote(int idNote) {
        this.idNote = idNote;
    }

    public int getIdRubrique() {
        return idRubrique;
    }

    public void setIdRubrique(int idRubrique) {
        this.idRubrique = idRubrique;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public double getNbrEtoile() {
        return nbrEtoile;
    }

    public void setNbrEtoile(double nbrEtoile) {
        this.nbrEtoile = nbrEtoile;
    }

    public int getNbrNote() {
        return nbrNote;
    }

    public void setNbrNote(int nbrNote) {
        this.nbrNote = nbrNote;
    }

    @Override
    public String toString() {
        return "note{" + "idNote=" + idNote + ", idRubrique=" + idRubrique + ", idClient=" + idClient + ", nbrEtoile=" + nbrEtoile + ", nbrNote=" + nbrNote + '}';
    }
    
    
}
