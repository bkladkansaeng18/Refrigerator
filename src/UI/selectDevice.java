/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Models.User;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


/**
 *
 * @author UP-CE55
 */
public class selectDevice extends javax.swing.JFrame {

    User user;
    Timer timer ;

    /**
     * Creates new form Login
     */
    public selectDevice(User user) {
        initComponents();
        this.user = user;
        jLabel18.setText(user.getName());
        switch (user.getRefrigerator().size()) {
            case 0:
                jLabel5.setVisible(false);
                jLabel10.setVisible(false);
                jLabel8.setVisible(false);
                jLabel11.setVisible(false);
                jLabel7.setVisible(false);
                jLabel9.setVisible(false);
                jLabel2.setVisible(false);
                bnt_item1.setVisible(false);
                bnt_item2.setVisible(false);
                bnt_item3.setVisible(false);
                bnt_item4.setVisible(false);
                break;
            case 1:
//                setIconLabel(jLabel6, user.getRefrigerator().get(0).getRefrig_name());
                setIconLabel(jLabel6, user.getRefrigerator().get(0));
                jLabel2.setText(user.getRefrigerator().get(0).getRefrig_name());                
                jLabel8.setVisible(false);
                jLabel10.setVisible(false);
                jLabel11.setVisible(false);
                jLabel7.setVisible(false);
                jLabel9.setVisible(false);                                
                bnt_item2.setVisible(false);
                bnt_item3.setVisible(false);
                bnt_item4.setVisible(false);
                break;
            case 2:
                setIconLabel(jLabel6, user.getRefrigerator().get(0));
                jLabel2.setText(user.getRefrigerator().get(0).getRefrig_name());   
                setIconLabel(jLabel5, user.getRefrigerator().get(1));
                jLabel10.setText(user.getRefrigerator().get(1).getRefrig_name());   
                jLabel7.setVisible(false);
                 jLabel11.setVisible(false);
                jLabel9.setVisible(false);                      
                bnt_item3.setVisible(false);
                bnt_item4.setVisible(false);
                break;
            case 3:
                setIconLabel(jLabel6, user.getRefrigerator().get(0));
                jLabel2.setText(user.getRefrigerator().get(0).getRefrig_name());   
                setIconLabel(jLabel5, user.getRefrigerator().get(1));
                jLabel10.setText(user.getRefrigerator().get(1).getRefrig_name());   
                setIconLabel(jLabel8, user.getRefrigerator().get(2));
                jLabel11.setText(user.getRefrigerator().get(2).getRefrig_name());  
                jLabel9.setVisible(false);
                bnt_item4.setVisible(false);
                break;
            case 4:
                setIconLabel(jLabel6, user.getRefrigerator().get(0));
                jLabel2.setText(user.getRefrigerator().get(0).getRefrig_name());   
                setIconLabel(jLabel5, user.getRefrigerator().get(1));
                jLabel10.setText(user.getRefrigerator().get(1).getRefrig_name());   
                setIconLabel(jLabel8, user.getRefrigerator().get(2));
                jLabel11.setText(user.getRefrigerator().get(2).getRefrig_name());  
                setIconLabel(jLabel7, user.getRefrigerator().get(3));
                jLabel9.setText(user.getRefrigerator().get(3).getRefrig_name());  
     
                break;
            case 5:
                break;
        }
         timer = new Timer();		
         timer.schedule(new TickTimerTask(), 0, 100000); 

    }
    
                class TickTimerTask extends TimerTask{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			notification();
		}
		
	}
               public void notification(){
                  
//                   System.out.println(user.getRefrigerator());
                    Date datenow = new Date();
                    boolean stop = true;
                   for(Models.Refrigerator i : user.getRefrigerator()){
                       for(Models.addItem j : i.getItem()){
                           if( (j.getExp().getYear() < datenow.getYear() || ((j.getExp().getMonth() < datenow.getMonth()) &&  j.getExp().getYear() == datenow.getYear()) || ((j.getExp().getDate() < datenow.getDate())&& j.getExp().getMonth() == datenow.getMonth())) && stop ){
//                               System.out.println(j.getItem().getName() + i.getRefrig_name());
                               int n = JOptionPane.showConfirmDialog(null, "Would you like green eggs and ham?", "An Inane Question",   JOptionPane.YES_NO_OPTION);
//                               System.out.println(n);
                               if(n == 0){
                                   this.dispose();
                                   new showOutofDate(user).setVisible(true);
                                   stop = false;
                               }else{
                               timer.cancel();
                               stop = false;
                               }
                           }

                       }
                   }
               }

    private void setIconLabel(JLabel label, Models.Refrigerator refrid) {

        String band = refrid.getRefrig_band();
        String tmp = "";
        for (int i = 0; i < band.length(); i++) {
            if (band.charAt(i) == ' ') {
                break;
            }
            tmp += band.charAt(i);

        }
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Static/Refrigerator/" +tmp + ".png")));
  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        bnt_item1 = new javax.swing.JButton();
        bnt_item2 = new javax.swing.JButton();
        bnt_item3 = new javax.swing.JButton();
        bnt_item4 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UI-Base");
        setAutoRequestFocus(false);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1024, 768));

        jPanel1.setBackground(new java.awt.Color(225, 225, 225));

        jPanel2.setBackground(new java.awt.Color(17, 13, 133));

        jPanel3.setBackground(new java.awt.Color(233, 14, 21));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        label1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("X");
        label1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        label2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        label2.setForeground(new java.awt.Color(255, 255, 255));
        label2.setText("SELECT DEVICE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Static/Image/350.png"))); // NOI18N

        jPanel6.setBackground(new java.awt.Color(161, 161, 161));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Static/Profile/profile80.png"))); // NOI18N

        jLabel18.setFont(new java.awt.Font("TH Sarabun New", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Name Surname");
        jLabel18.setToolTipText("");

        jButton2.setBackground(new java.awt.Color(217, 173, 78));
        jButton2.setFont(new java.awt.Font("TH Sarabun New", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("EDIT PROFILE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(217, 83, 79));
        jButton4.setFont(new java.awt.Font("TH Sarabun New", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("LOGOUT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton4)))
                    .addComponent(jLabel17))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("TH Sarabun New", 1, 36)); // NOI18N
        jLabel4.setText("Your Device");

        jLabel1.setFont(new java.awt.Font("TH Sarabun New", 1, 24)); // NOI18N
        jLabel1.setText("Click   [+]   to add another device");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Static/Refrigerator/none.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Static/Refrigerator/none.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Static/Refrigerator/none.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Static/Refrigerator/none.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("TH Sarabun New", 1, 24)); // NOI18N
        jLabel2.setText("name1");

        jLabel9.setFont(new java.awt.Font("TH Sarabun New", 1, 24)); // NOI18N
        jLabel9.setText("name4");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("TH Sarabun New", 1, 24)); // NOI18N
        jLabel10.setText("name2");

        jLabel11.setFont(new java.awt.Font("TH Sarabun New", 1, 24)); // NOI18N
        jLabel11.setText("name3");

        bnt_item1.setText("Edit");
        bnt_item1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_item1ActionPerformed(evt);
            }
        });

        bnt_item2.setText("Edit");
        bnt_item2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_item2ActionPerformed(evt);
            }
        });

        bnt_item3.setText("Edit");
        bnt_item3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_item3ActionPerformed(evt);
            }
        });

        bnt_item4.setText("Edit");
        bnt_item4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_item4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(45, 45, 45)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(bnt_item1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(bnt_item2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                                .addComponent(bnt_item3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addGap(46, 46, 46)
                                .addComponent(bnt_item4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(bnt_item1))
                    .addComponent(jLabel9)
                    .addComponent(bnt_item4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(bnt_item2))
                    .addComponent(jLabel11)
                    .addComponent(bnt_item3))
                .addContainerGap(171, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(1024, 629));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bnt_item1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_item1ActionPerformed
        // TODO add your handling code here:
        if(user.getRefrigerator().size() >= 1){
            timer.cancel();
            this.dispose();
            new editDevice(user, user.getRefrigerator().get(0)).setVisible(true);
        }else{
            timer.cancel();
            this.dispose();
            new addDevice(user).setVisible(true);
        }

    }//GEN-LAST:event_bnt_item1ActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        if(user.getRefrigerator().size() >= 4){
            timer.cancel();
            this.dispose();
            new deviceInfo(user, user.getRefrigerator().get(3)).setVisible(true);
        }else{
            timer.cancel();
            this.dispose();
            new addDevice(user).setVisible(true);
        }
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        if(user.getRefrigerator().size() >= 3){
            timer.cancel();
            this.dispose();
            new deviceInfo(user, user.getRefrigerator().get(2)).setVisible(true);
        }else{
            timer.cancel();
            this.dispose();
            new addDevice(user).setVisible(true);
        }
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        if(user.getRefrigerator().size() >= 1){
            timer.cancel();
            this.dispose();
            new deviceInfo(user, user.getRefrigerator().get(0)).setVisible(true);
        }else{
            timer.cancel();
            this.dispose();
            new addDevice(user).setVisible(true);
        }
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        if(user.getRefrigerator().size() >= 2){
            timer.cancel();
            this.dispose();
            new deviceInfo(user, user.getRefrigerator().get(1)).setVisible(true);
        }else{
            timer.cancel();
            this.dispose();
            new addDevice(user).setVisible(true);
        }
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        timer.cancel();
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        timer.cancel();
        this.dispose();
        new Edit_Profile(user).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3MouseClicked

    private void label1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label1MouseClicked
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_label1MouseClicked

    private void bnt_item2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_item2ActionPerformed
        // TODO add your handling code here:
        timer.cancel();
        this.dispose();
      new editDevice(user, user.getRefrigerator().get(1)).setVisible(true);
        
    }//GEN-LAST:event_bnt_item2ActionPerformed

    private void bnt_item3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_item3ActionPerformed
        // TODO add your handling code here:
        timer.cancel();
        this.dispose();
            new editDevice(user, user.getRefrigerator().get(2)).setVisible(true);
    }//GEN-LAST:event_bnt_item3ActionPerformed

    private void bnt_item4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_item4ActionPerformed
        // TODO add your handling code here:
        timer.cancel();
        this.dispose();
            new editDevice(user, user.getRefrigerator().get(3)).setVisible(true);
    }//GEN-LAST:event_bnt_item4ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnt_item1;
    private javax.swing.JButton bnt_item2;
    private javax.swing.JButton bnt_item3;
    private javax.swing.JButton bnt_item4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JPanel jPanel6;
    private java.awt.Label label1;
    private java.awt.Label label2;
    // End of variables declaration//GEN-END:variables
}
