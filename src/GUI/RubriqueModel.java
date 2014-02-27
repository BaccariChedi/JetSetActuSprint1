/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;
import entities.Evenement;
import entities.*;
import DAO.EvenementDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ahmed
 */
public class RubriqueModel extends AbstractTableModel {
    String [] headers ={"idEvenemet","Type","Titre","Description","DateEvenemet","Heur","Duree","IDAlbume","IDImage","IDVideo","IDLieu","NbrVue"};
    List<Evenement> listEvenements = new ArrayList<>();
    
    public RubriqueModel()
    {
        EvenementDAO E = new EvenementDAO();
        listEvenements=E.DisplayAllEvenement();
    }

    @Override
    public int getRowCount() {
        return listEvenements.size();
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
       
        switch(i1)
        {
            case 0 :
                return listEvenements.get(i).getIdEvenement();
            case 1: 
                return listEvenements.get(i).getType();
            case 3:
                return listEvenements.get(i).getTitre();
            case 4:
                return listEvenements.get(i).getDescription();
            case 5: 
                return listEvenements.get(i).getDateEvenement();
            case 6:
                return listEvenements.get(i).getDateHeure();
            case 7:
                return listEvenements.get(i).getDuree();
            case 8:
                return listEvenements.get(i).getIdAlum();
            case 9 :
                return listEvenements.get(i).getIdImage();
            case 10:
                return listEvenements.get(i).getIdVideo();
            case 11:
                return listEvenements.get(i).getIdLieu();
            case 12:
                return listEvenements.get(i).getNbrVue();
                default:
                    return null;
             
        }
    }
    @Override
    public String getColumnName(int i) {
        return headers[i];
    }
    
}
