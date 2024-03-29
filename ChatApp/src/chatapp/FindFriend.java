/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp;

import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author chetan
 */
public class FindFriend extends javax.swing.JPanel {

    /**
     * Creates new form FindFriend
     */
    DefaultTableModel dtm;
    Connection conn;
    Statement st;
    ResultSet rs;
    String phone="";
    static ImageIcon img;
    public FindFriend(Connection conn,String phone) {
        this.phone=phone;
        dtm=new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
               return false;
            }
            @Override
            //  Returning the Class of each column will allow different
            //  renderers to be used based on Class
            public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
        };
        initComponents();
        this.conn=conn;
        String header[] = new String[] { "image", "name","Phone" };
        dtm.setColumnIdentifiers(header);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable1.setRowHeight(150);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(180);
        try {
            displayUsers();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
    }
    
    private void displayUsers() throws SQLException{
        dtm.setRowCount(0);
        String query="Select * from register where not phone='"+this.phone+"'";
        st=conn.createStatement();
        rs=st.executeQuery(query);
        while(rs.next()){
            
            String username=rs.getString("firstname")+" "+rs.getString("lastname");
            
            Blob imgData = rs.getBlob("image");
            img=getImage(imgData);
            
            String phone=rs.getString("phone");
            dtm.addRow(new Object[] { img,username,phone });
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

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.white));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Search By Firstname:");

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(dtm);
        jScrollPane1.setViewportView(jTable1);

        jButton3.setText("Send Request");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1))
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(jTextField1.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please enter firstname.");
        }
        else{
            try {
                String fname=jTextField1.getText();
                jTextField1.setText("");
                displayUser(fname);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"sorry NO DATA found!");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            displayUsers();
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //sending friend request 
        if(jTable1.getSelectedRow()>=0){
            String phone2=jTable1.getValueAt(jTable1.getSelectedRow(),2).toString();
            String str="insert into req"+phone2+" values(?)";
            try {
                PreparedStatement st=conn.prepareStatement(str);
                st.setString(1, phone);
                st.execute();
                    JOptionPane.showMessageDialog(null,"request has been sent...");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Unable to send request");
                System.out.println(ex.toString());
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Please Select the person you want to send request to!");
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void displayUser(String fname) throws SQLException {
        dtm.setRowCount(0);
        String query="Select * from register where firstname='"+fname+"'";
        st=conn.createStatement();
        rs=st.executeQuery(query);
        while(rs.next()){
            String name=rs.getString("firstname")+" "+rs.getString("lastname");
            Blob imgData = rs.getBlob("image");
            img=getImage(imgData);
            String phone=rs.getString("phone");
            dtm.addRow(new Object[] { img,name,phone });
        }
    }
    
    public static ImageIcon getImage(Blob imgData){
    if(imgData != null){
                try{
                    File tmpFile = new File("tmpImage");
                    FileOutputStream fos = new FileOutputStream(tmpFile);
                    fos.write( imgData.getBytes(1L, (int)imgData.length()) );
                    fos.close();   
                    Image image=ImageIO.read(tmpFile); 
                    img=new ImageIcon(image.getScaledInstance(208,168,Image.SCALE_SMOOTH));
                }catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Image not found..", "Load Error", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Failed To Load Image Data", "Load Error", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException ex) {
                }
            }
            return img;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}

