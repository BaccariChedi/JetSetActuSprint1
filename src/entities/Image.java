/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

/**
 *
 * @author Romdhane
 */
public class Image {
    private int idImage;
    private String titre;
    private String lienImage;

    public int getIdImage() {
        return idImage;
    }

    public String getTitre() {
        return titre;
    }

    public String getLienImage() {
        return lienImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setLienImage(String lienImage) {
        this.lienImage = lienImage;
    }

    @Override
    public String toString() {
        return "Image{" + "idImage=" + idImage + ", titre=" + titre + ", lienImage=" + lienImage + '}';
    }
    
    
}
