/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import DAO.AlbumDAO;
import DAO.EvenementDAO;
import DAO.ImageDAO;
import DAO.LieuDAO;
import DAO.VideoDAO;
import entities.Album;
import entities.Evenement;
import entities.Image;
import entities.Lieu;
import entities.Video;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Romdhane
 */
public class EvenementsBox extends javax.swing.JFrame {

    /**
     * Creates new form hhhhh
     */
    public EvenementsBox() {
        initComponents();
        //VideoBox.setVisible(false);
        remplir_Lieu();
        remplir_Album();
        VideoBox.setEnabled(false);
        ImageBox.setEnabled(false);
        VisibleFalse();
        
    }
    
   
        

    
    public void VisibleFalse()
    {
       EtDate.setVisible(false);
        EtAlbum.setVisible(false);
        EtHeur.setVisible(false);
        EtLieu.setVisible(false);
        EtTitre.setVisible(false);
        EtType.setVisible(false);
        EtImage.setVisible(false); 
    }
    public void remplir_Lieu()
    {
        LieuDAO l = new LieuDAO();
        List<Lieu>  lst=new ArrayList<>();
       lst= l.DisplayAllLieu();
        for(  Lieu n : lst)
        {
            LieuBox.addItem(n.getNom());
        }
    }
    public void remplir_Album()
    {
        AlbumDAO A = new AlbumDAO();
        List<Album>  lstA=new ArrayList<>();
       lstA= A.DisplayAllAlbum();
        for(  Album n : lstA)
        {
            AlbumBox.addItem(n.getTitre());
        }
    }
     private int  ReturnIndexOfEvents (String sh)
    {
         if(sh.equals("News"))
        {
          return 1;
            
        }
        else if(sh.equals("Art"))
        {
          return 2;
            
       
        }else if(sh.equals("Films"))
        {
            return 3;
        }   
        else if (sh.equals("Soirees"))
        {
            return 4;
        }   
        else {return 0;}
    }
    public void EvenementAffiche (Evenement e)
    {
      
    
        
//    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        IdEvenementBox.setText(e.getIdEvenement()+"");
        AlbumBox.setSelectedIndex(e.getIdAlum());
        Image ii = new Image();
        ii=I.findImageById(e.getIdImage());
        ImageBox.setText(ii.getLienImage());
        LieuBox.setSelectedIndex(e.getIdLieu());
        Video vv =new Video();
        vv=V.findVideoById(e.getIdVideo());
        VideoBox.setText(vv.getLienVideo());
        TypeBox.setSelectedIndex(ReturnIndexOfEvents( e.getType()));
        TitreBox.setText(e.getTitre());
        DateEvenementBox.setText(e.getDateEvenement().toString());
        //DateHeureBox.setText(e.getDateHeure().toString());
        
        int i=e.getDateHeure().toString().indexOf(':');
        int l=e.getDateHeure().toString().length();
        String H=e.getDateHeure().toString().substring(0, i);
        String M=e.getDateHeure().toString().substring(i+1, l);
        System.out.println(M+":"+H);
        HeurChoix.setSelectedIndex(Integer.parseInt(H));
        MinChoix.setSelectedIndex(Integer.parseInt(M));
        DescriptionBox2.setText(e.getDescription());
        DureeBox1.setText(e.getDuree()+"");
        //NbrVueBox.setText(e.getNbrVue()+"");
      // ButtonAjouter.setEnabled(false);
        IdEvenementBox.setEnabled(false);
        AlbumBox.setEnabled(false);
        ImageBox.setEnabled(false);
        LieuBox.setEnabled(false);
        VideoBox.setEnabled(false);
        TypeBox.setEnabled(false);
        TitreBox.setEnabled(false);
        HeurChoix.setEnabled(false);
        MinChoix.setEnabled(false);
        DateEvenementBox.setEnabled(false);
        DescriptionBox2.setEnabled(false);
        DureeBox1.setEnabled(false);
        //NbrVueBox.setEnabled(false);
        ValiderButton.setVisible(false);
        if(ReturnIndexOfEvents(e.getType())!=3)
        {
            VideoLab.setVisible(false);
            VideoBox.setVisible(false);
        }
        
        
    }

    public boolean verifcation() {
        int i = 0;
        if (DateEvenementBox.getText().equals("01/03/14")) {
            EtDate.setVisible(true);
            i++;
        }

        if (DureeBox1.getText().equals("")) {
            EtAlbum.setVisible(true);
            i++;
        }
        if (!DureeBox1.getText().equals("")) {

            if (i == 0) {
                try {
                    int t = Integer.parseInt(DureeBox1.getText());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "la Durée doit etre un numero svp", "Not Number", JOptionPane.ERROR_MESSAGE);
                }
                i++;
                EtAlbum.setVisible(true);
            }
            i++;
        }
        if (LieuBox.getSelectedIndex() == 0) {
            EtLieu.setVisible(true);
            i++;
        }
        if (TitreBox.getText().equals("")) {
            EtTitre.setVisible(true);
            i++;
        }
        if (TypeBox.getSelectedIndex() == 0) {
            EtType.setVisible(true);
            i++;
        }
        if (ImageBox.getText().equals("Clique Ici")) {
            EtImage.setVisible(true);
            i++;
        }
//EtHeur.setEnabled(false);
        if (i != 0) {
            return false;
        } else {
            return true;
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        ModifierButton = new javax.swing.JButton();
        SupprimerButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        VideoLab = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        IdEvenementBox = new javax.swing.JTextField();
        TitreBox = new javax.swing.JTextField();
        DureeBox = new javax.swing.JTextField();
        ImageBox = new javax.swing.JTextField();
        VideoBox = new javax.swing.JTextField();
        ValiderButton = new javax.swing.JButton();
        TypeBox = new javax.swing.JComboBox();
        LieuBox = new javax.swing.JComboBox();
        MinChoix = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        HeurChoix = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        AlbumBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        DescriptionBox2 = new javax.swing.JTextArea();
        EtType = new javax.swing.JLabel();
        EtTitre = new javax.swing.JLabel();
        EtDate = new javax.swing.JLabel();
        EtHeur = new javax.swing.JLabel();
        EtAlbum = new javax.swing.JLabel();
        EtImage = new javax.swing.JLabel();
        EtLieu = new javax.swing.JLabel();
        DureeBox1 = new javax.swing.JTextField();
        EtDuree = new javax.swing.JLabel();
        DateEvenementBox = new datechooser.beans.DateChooserCombo();

        jLabel12.setText("jLabel12");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 80));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("JetSet");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 51, 204));
        jLabel15.setText("Actu");

        ModifierButton.setBackground(new java.awt.Color(1, 1, 1));
        ModifierButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifierButtonActionPerformed(evt);
            }
        });

        SupprimerButton.setBackground(new java.awt.Color(1, 1, 1));
        SupprimerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupprimerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SupprimerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ModifierButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ModifierButton, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(SupprimerButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ahmed\\Documents\\icon\\home.png")); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel10MouseReleased(evt);
            }
        });

        jLabel18.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ahmed\\Documents\\icon\\return.png")); // NOI18N
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel18MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel18))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("IdEvenement");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("type");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Titre");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Description");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DateEvenement");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Duree");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Album");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Image");

        VideoLab.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        VideoLab.setForeground(new java.awt.Color(255, 255, 255));
        VideoLab.setText("Video");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Lieu");

        ImageBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImageBoxMouseClicked(evt);
            }
        });
        ImageBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImageBoxActionPerformed(evt);
            }
        });

        VideoBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VideoBoxMouseClicked(evt);
            }
        });

        ValiderButton.setText("Valider");
        ValiderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValiderButtonActionPerformed(evt);
            }
        });

        TypeBox.setFont(new java.awt.Font("Ubuntu Condensed", 0, 15)); // NOI18N
        TypeBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-----------", "News", "Art", "Films", "Soirees" }));
        TypeBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TypeBoxMouseClicked(evt);
            }
        });
        TypeBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TypeBoxActionPerformed(evt);
            }
        });
        TypeBox.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                TypeBoxHierarchyChanged(evt);
            }
        });

        LieuBox.setFont(new java.awt.Font("Ubuntu Condensed", 0, 15)); // NOI18N
        LieuBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-----------" }));
        LieuBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LieuBoxMouseClicked(evt);
            }
        });
        LieuBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LieuBoxActionPerformed(evt);
            }
        });
        LieuBox.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                LieuBoxHierarchyChanged(evt);
            }
        });

        MinChoix.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Minutes");

        HeurChoix.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));
        HeurChoix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HeurChoixActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Heure");

        AlbumBox.setFont(new java.awt.Font("Ubuntu Condensed", 0, 15)); // NOI18N
        AlbumBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-----------" }));
        AlbumBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AlbumBoxMouseClicked(evt);
            }
        });
        AlbumBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlbumBoxActionPerformed(evt);
            }
        });
        AlbumBox.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                AlbumBoxHierarchyChanged(evt);
            }
        });

        DescriptionBox2.setColumns(20);
        DescriptionBox2.setRows(5);
        jScrollPane1.setViewportView(DescriptionBox2);

        EtType.setForeground(new java.awt.Color(255, 245, 245));

        EtTitre.setForeground(new java.awt.Color(255, 245, 245));

        EtDate.setForeground(new java.awt.Color(255, 245, 245));

        EtHeur.setForeground(new java.awt.Color(255, 245, 245));

        EtAlbum.setForeground(new java.awt.Color(255, 245, 245));

        EtImage.setForeground(new java.awt.Color(255, 245, 245));

        EtLieu.setForeground(new java.awt.Color(255, 245, 245));

        EtDuree.setForeground(new java.awt.Color(255, 245, 245));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(VideoLab)
                    .addComponent(jLabel11)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(31, 31, 31)
                        .addComponent(HeurChoix, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(TitreBox, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EtTitre))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TypeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DureeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EtType))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(DateEvenementBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EtDate))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(MinChoix, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addComponent(EtHeur))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(AlbumBox, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EtAlbum))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(ImageBox, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EtImage))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(LieuBox, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EtLieu))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(DureeBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EtDuree))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IdEvenementBox, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VideoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(64, 64, 64))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ValiderButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(IdEvenementBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(TypeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(TitreBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EtTitre)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(DureeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(EtType)))
                .addGap(38, 38, 38)
                .addComponent(EtDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(DateEvenementBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(HeurChoix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(MinChoix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EtHeur))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(DureeBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EtDuree))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(AlbumBox, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EtAlbum))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ImageBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(EtImage))
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VideoLab)
                    .addComponent(VideoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(LieuBox, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EtLieu))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ValiderButton))
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ModifierButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifierButtonActionPerformed
        IdEvenementBox.setEnabled(false);
        AlbumBox.setEnabled(true);
        LieuBox.setEnabled(true); 
        TypeBox.setEnabled(true);
        TitreBox.setEnabled(true);
        HeurChoix.setEnabled(true);
        MinChoix.setEnabled(true);
        DateEvenementBox.setEnabled(true);
        DescriptionBox2.setEnabled(true);
        DureeBox.setEnabled(true);
        
        ModifierButton.setVisible(false);
        SupprimerButton.setVisible(false);
        ValiderButton.setVisible(true);
    }//GEN-LAST:event_ModifierButtonActionPerformed

    private void ValiderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValiderButtonActionPerformed
        Evenement e = new  Evenement();
        EvenementDAO E= new EvenementDAO();
        VisibleFalse();
         if(verifcation()== true){
         
        int id=Integer.parseInt(IdEvenementBox.getText());
        e.setIdEvenement(id);
        e.setIdAlum(AlbumBox.getSelectedIndex());
        if(TypeBox.getSelectedIndex()==3){
            v1=V.findVideoByTitreAndLien(v.getTitre(), v.getLienVideo());
           e.setIdVideo(v1.getIdVideo());
            }
        i1=I.findImageByTitreAndLien(i.getTitre(), i.getLienImage());
        e.setIdImage(i1.getIdImage());
        e.setIdLieu(LieuBox.getSelectedIndex());
        e.setTitre(TitreBox.getText());
        e.setType(TypeBox.getModel().toString());
        e.setDateEvenement(DateEvenementBox.getText());
        e.setDescription(DescriptionBox2.getText());
        
        int h=HeurChoix.getSelectedIndex();
        int m=MinChoix.getSelectedIndex();
        String sh=h+":"+m;
        e.setDateHeure(sh);
        e.setDuree(Double.parseDouble(DureeBox1.getText()));
       // e.setNbrVue(Integer.parseInt(NbrVueBox.getText()));
        System.out.println(e.toString());
        E.updateEvenement(e, id);
        JOptionPane.showMessageDialog(null,"Modification effectuée Avec Succès" ," Modification",1);
         }
         else{
             JOptionPane.showMessageDialog(null, "Erreur lors de  La Modification", "Erreur Modification", JOptionPane.ERROR_MESSAGE);
         
         }
    }//GEN-LAST:event_ValiderButtonActionPerformed

    private void SupprimerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupprimerButtonActionPerformed
        // TODO add your handling code here:
        EvenementDAO E= new EvenementDAO();
        E.deleteEvenement(Integer.parseInt(IdEvenementBox.getText()));
        ListRubriqueFrame LRF =new ListRubriqueFrame();
        
        JOptionPane.showMessageDialog(null,"Evenement Supprimer ","Supprimer",1);
        this.setVisible(false);
    }//GEN-LAST:event_SupprimerButtonActionPerformed

    private void TypeBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TypeBoxMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TypeBoxMouseClicked

    private void TypeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TypeBoxActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_TypeBoxActionPerformed

    private void TypeBoxHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_TypeBoxHierarchyChanged

    }//GEN-LAST:event_TypeBoxHierarchyChanged

    private void LieuBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LieuBoxMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_LieuBoxMouseClicked

    private void LieuBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LieuBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LieuBoxActionPerformed

    private void LieuBoxHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_LieuBoxHierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_LieuBoxHierarchyChanged

    private void HeurChoixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HeurChoixActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HeurChoixActionPerformed

    private void ImageBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImageBoxMouseClicked
       String sh= JOptionPane.showInputDialog(null,"Veuillez saisire un Nom D'Image","Nom Image",JOptionPane.QUESTION_MESSAGE);
        JFileChooser ch =new JFileChooser();
        ch.showOpenDialog(null);
        File f =ch.getSelectedFile();
        filename=f.getAbsolutePath();
        ImageBox.setText(filename);
        i.setTitre(sh);
        i.setLienImage(filename);
        I.insertImage(i);
    }//GEN-LAST:event_ImageBoxMouseClicked

    private void AlbumBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AlbumBoxMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_AlbumBoxMouseClicked

    private void AlbumBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlbumBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AlbumBoxActionPerformed

    private void AlbumBoxHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_AlbumBoxHierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_AlbumBoxHierarchyChanged

    private void ImageBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImageBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ImageBoxActionPerformed

    private void VideoBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VideoBoxMouseClicked
       String sh=JOptionPane.showInputDialog(null,"Veuillez saisire un Nom De Video","Nom Video",JOptionPane.QUESTION_MESSAGE);
        JFileChooser ch =new JFileChooser();
        ch.showOpenDialog(null);
        File f =ch.getSelectedFile();
        filename=f.getAbsolutePath();
        VideoBox.setText(filename);
        v.setTitre(sh);
        v.setLienVideo(filename);
        V.insertVideo(v);

    }//GEN-LAST:event_VideoBoxMouseClicked

    private void jLabel10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseReleased
        Accueil a =new Accueil();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel10MouseReleased

    private void jLabel18MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseReleased
        ListRubriqueFrame a =new ListRubriqueFrame();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel18MouseReleased

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(EvenementsBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(EvenementsBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(EvenementsBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(EvenementsBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new EvenementsBox().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox AlbumBox;
    private datechooser.beans.DateChooserCombo DateEvenementBox;
    private javax.swing.JTextArea DescriptionBox2;
    private javax.swing.JTextField DureeBox;
    private javax.swing.JTextField DureeBox1;
    private javax.swing.JLabel EtAlbum;
    private javax.swing.JLabel EtDate;
    private javax.swing.JLabel EtDuree;
    private javax.swing.JLabel EtHeur;
    private javax.swing.JLabel EtImage;
    private javax.swing.JLabel EtLieu;
    private javax.swing.JLabel EtTitre;
    private javax.swing.JLabel EtType;
    private javax.swing.JComboBox HeurChoix;
    private javax.swing.JTextField IdEvenementBox;
    private javax.swing.JTextField ImageBox;
    private javax.swing.JComboBox LieuBox;
    private javax.swing.JComboBox MinChoix;
    private javax.swing.JButton ModifierButton;
    private javax.swing.JButton SupprimerButton;
    private javax.swing.JTextField TitreBox;
    private javax.swing.JComboBox TypeBox;
    private javax.swing.JButton ValiderButton;
    private javax.swing.JTextField VideoBox;
    private javax.swing.JLabel VideoLab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
private ImageIcon format =null;
String filename=null;
int s =0;
byte[] person_image=null;
VideoDAO V = new VideoDAO();
    Video v = new Video();
    Video v1 = new Video();
    ImageDAO I = new ImageDAO();
    Image i = new Image();
    Image i1 = new Image();

}
