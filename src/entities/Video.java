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
public class Video {
    private int idVideo;
    private String titre;
    private String lienVideo;

    public int getIdVideo() {
        return idVideo;
    }

    public String getTitre() {
        return titre;
    }

    public String getLienVideo() {
        return lienVideo;
    }

    public void setIdVideo(int idVideo) {
        this.idVideo = idVideo;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setLienVideo(String lienVideo) {
        this.lienVideo = lienVideo;
    }

    @Override
    public String toString() {
        return "Video{" + "idVideo=" + idVideo + ", titre=" + titre + ", lienVideo=" + lienVideo + '}';
    }
    
}
