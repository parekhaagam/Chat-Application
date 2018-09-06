package chatapp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Main extends javax.swing.JFrame {
    Statement st;
    Connection conn;
    String phone;
    JSplitPane splitPanev;
    JSplitPane splitPaneh;
    Home home;
    MyFriends myFriends;
    FindFriend findFriend;
    Image btn;
    public Main(Statement st,Connection conn,String phone) {
        this.getContentPane().setBackground(new Color(159,182,205));
        initComponents();
        this.st=st;
        this.conn=conn;
        this.phone=phone;
        home=new Home(this,phone);
        home.setBackground(new Color(159,182,205));
        myFriends=new MyFriends(this,phone,conn);
        myFriends.setBackground(new Color(159,182,205));
        findFriend=new FindFriend(conn,phone);
        findFriend.setBackground(new Color(159,182,205));
        splitPanev=new JSplitPane();
        splitPaneh=new JSplitPane();
        initImageButton();
        
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2-70, dim.height/2-this.getSize().height/2-55);
        this.setSize(770,630);
        this.setResizable(false);
        this.setVisible(true);
        Main_top_panel top = new Main_top_panel();
        top.setBackground(new Color(255,255,255));
        top.setSize(450, 100);
        top.setVisible(true);

        JPanel left = new JPanel(new GridLayout(5,1,50,50));
        left.setBackground(new Color(159,182,205));
        left.add(jButton1);
        left.add(jButton2);
        left.add(jButton3);
        left.add(jButton4);
        left.add(jButton5);
        
        splitPanev.setSize(760,600);
        splitPanev.setDividerSize(0);
        splitPanev.setDividerLocation(70);
        splitPanev.setOrientation(JSplitPane.VERTICAL_SPLIT);
        splitPanev.setTopComponent(top);
        
        
        splitPaneh=new JSplitPane();
        splitPaneh.setSize(760,600);
        splitPaneh.setDividerSize(0);
        splitPaneh.setDividerLocation(100);
        splitPaneh.setLeftComponent(left);
        splitPaneh.setRightComponent(home);
        splitPanev.setBottomComponent( splitPaneh );
        
        this.add(splitPanev);
        jButton6.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent me){
                try {
                    btn = ImageIO.read(new File("src/logout1.png"));
                    jButton6.setIcon(new ImageIcon(btn.getScaledInstance(75,33,Image.SCALE_SMOOTH)));
                    jButton6.setBorderPainted(false);
                } catch (IOException ex) {
                    System.out.println(ex.toString());
                }
            }
            public void mouseExited(MouseEvent me){
                try {
                    btn = ImageIO.read(new File("src/logout2.png"));
                    jButton6.setIcon(new ImageIcon(btn.getScaledInstance(75,33,Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    System.out.println(ex.toString());
                }
            }
        });
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setText("My Groups");

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Find Friends");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Make Group");

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton5))
                .addContainerGap(499, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton6)
                .addGap(36, 36, 36)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addContainerGap(278, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        splitPaneh.setRightComponent(home);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int isYES=JOptionPane.showConfirmDialog(null,"Do you wanna logout?",
                "Choose",JOptionPane.YES_NO_OPTION);
        if(isYES==JOptionPane.YES_OPTION){
            try {
                logout();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        splitPaneh.setRightComponent(myFriends);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        splitPaneh.setRightComponent(findFriend);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void logout() throws SQLException{
        String update="UPDATE register SET online=0 where phone='"+phone+"'";
        st.executeUpdate(update);
        this.setVisible(false);
        LoginPage login=new LoginPage();
        login.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    // End of variables declaration//GEN-END:variables

    private void initImageButton() {
        try {
            btn = ImageIO.read(new File("src/profile.png"));
            jButton1.setIcon(new ImageIcon(btn.getScaledInstance(75,33,Image.SCALE_SMOOTH)));
            
            btn = ImageIO.read(new File("src/friend.png"));
            jButton2.setIcon(new ImageIcon(btn.getScaledInstance(75,33,Image.SCALE_SMOOTH)));
                        
            btn = ImageIO.read(new File("src/logout2.png"));
            jButton6.setIcon(new ImageIcon(btn.getScaledInstance(75,33,Image.SCALE_SMOOTH)));
             
            Border thickBorder = new LineBorder(Color.WHITE,0);
            jButton6.setBorder(thickBorder);
            
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }
}
