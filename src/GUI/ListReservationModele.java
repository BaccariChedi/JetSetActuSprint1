/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import DAO.ReservationDAO;
import DAO.AlbumDAO;
import entities.Album;
import entities.Reservation;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Romdhane
 */
public class ListReservationModele  extends AbstractTableModel{
    

   String[] headers={"IdReservation","IdEvenement","IdClient","Nombre de places","Classe"};
    List<Reservation> ListeSt = new ArrayList<Reservation>();
    public ListReservationModele(){
        ReservationDAO stdao = new ReservationDAO();
        ListeSt = stdao. DisplayAllReservation();
    }
    public int getRowCount() {
        return ListeSt.size();
    }

    public int getColumnCount() {
        return headers.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return  ListeSt.get(rowIndex).getIdReservation();
            case 1:
                return ListeSt.get(rowIndex).getIdEvenement();
            case 2:
                return ListeSt.get(rowIndex).getIdClient();
                case 3:
                return ListeSt.get(rowIndex).getNbrPlace();
            case 4:
                return ListeSt.get(rowIndex).getClasse();
          
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return headers[column];
    }

    



}
