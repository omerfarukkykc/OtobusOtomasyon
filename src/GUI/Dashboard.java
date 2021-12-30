package GUI;

import GUI.Buses.ListBuses;
import GUI.Voyages.AddVoyage;
import GUI.Voyages.ListVoyage;
import GUI.clients.ListClient;


import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form islemekrani
     */
    public Dashboard() {
        setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
       

        
    }
    public static void infoBoxView(String infoMessage, String titleBar){
        JOptionPane.showMessageDialog(null, infoMessage, "Information: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lineBorder1 = (javax.swing.border.LineBorder)javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0));
        lineBorder2 = (javax.swing.border.LineBorder)javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0));
        jPanel2 = new javax.swing.JPanel();
        viewsefer = new javax.swing.JButton();
        viewbilet = new javax.swing.JButton();
        leave = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        viewbilet1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        viewsefer.setText("Seferleri Listele");
        viewsefer.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        viewsefer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewseferActionPerformed(evt);
            }
        });

        viewbilet.setText("Otobüsleri Listele");
        viewbilet.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        viewbilet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewbiletActionPerformed(evt);
            }
        });

        leave.setText("Çıkış yap!");
        leave.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        leave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaveActionPerformed(evt);
            }
        });

        jDesktopPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 994, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );

        viewbilet1.setText("Müşterileri Listele");
        viewbilet1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        viewbilet1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewbilet1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(viewsefer, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewbilet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewbilet1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(leave, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDesktopPane1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(viewbilet1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(viewsefer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(viewbilet, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(leave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    ListBuses lb ;
    private void viewbiletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewbiletActionPerformed
       
        if(lb == null || lb.isClosed()){
            lb = new ListBuses();
            jDesktopPane1.add(lb);
            lb.setVisible(true);
            lb.setSize(jDesktopPane1.getWidth(), jDesktopPane1.getHeight());
        }else{
            closeOther(lb);
        }
    }//GEN-LAST:event_viewbiletActionPerformed
    ListVoyage sefergr;
    private void viewseferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewseferActionPerformed
        
        if(sefergr == null || sefergr.isClosed()){
            sefergr = new ListVoyage();
            jDesktopPane1.add(sefergr);
            sefergr.setVisible(true);
            sefergr.setSize(jDesktopPane1.getWidth(), jDesktopPane1.getHeight());
        }else{
            closeOther(sefergr);
        }
    }//GEN-LAST:event_viewseferActionPerformed
    public void closeOther(JInternalFrame a ){
        for(JInternalFrame frame : jDesktopPane1.getAllFrames()){
            if( !frame.equals(a)){
                frame.dispose();
            }
         }
    }
    private void leaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaveActionPerformed
        System.exit(1);
    }//GEN-LAST:event_leaveActionPerformed
    ListClient vClient;
    private void viewbilet1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewbilet1ActionPerformed
        
        if(vClient == null || vClient.isClosed()){
            vClient = new ListClient();
            jDesktopPane1.add(vClient);
            vClient.setVisible(true);
            vClient.setSize(jDesktopPane1.getWidth(), jDesktopPane1.getHeight());
        }else{
            closeOther(vClient);
        }
    }//GEN-LAST:event_viewbilet1ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton leave;
    private javax.swing.border.LineBorder lineBorder1;
    private javax.swing.border.LineBorder lineBorder2;
    private javax.swing.JButton viewbilet;
    private javax.swing.JButton viewbilet1;
    private javax.swing.JButton viewsefer;
    // End of variables declaration//GEN-END:variables
}
