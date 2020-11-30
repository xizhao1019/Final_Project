/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CoordinatorRole;

import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author suoxiyue
 */
public class CoordinatorWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel container;
    /**
     * Creates new form CoordinatorWorkAreaJPanel
     */
    public CoordinatorWorkAreaJPanel(JPanel container) {
        initComponents();
        this.container = container;
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
        btnNewAssignedCases = new javax.swing.JButton();
        btnViewYourAnimals = new javax.swing.JButton();

        jLabel1.setText("Coordinator Work Area");

        btnNewAssignedCases.setText("New Assigned Cases");
        btnNewAssignedCases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewAssignedCasesActionPerformed(evt);
            }
        });

        btnViewYourAnimals.setText("View Your Animals");
        btnViewYourAnimals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewYourAnimalsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(btnNewAssignedCases)
                        .addGap(170, 170, 170)
                        .addComponent(btnViewYourAnimals)))
                .addGap(120, 120, 120))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addGap(101, 101, 101)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewAssignedCases)
                    .addComponent(btnViewYourAnimals))
                .addGap(174, 174, 174))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewAssignedCasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewAssignedCasesActionPerformed
        // TODO add your handling code here:
        NewAssignedCaseJPanel jp = new NewAssignedCaseJPanel(container);
        container.add("NewAssignedCaseJPanel",jp);
        CardLayout layout = (CardLayout)container.getLayout();
        layout.next(container);
    }//GEN-LAST:event_btnNewAssignedCasesActionPerformed

    private void btnViewYourAnimalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewYourAnimalsActionPerformed
        // TODO add your handling code here:
        ViewYourAnimals jp = new ViewYourAnimals(container);
        container.add("ViewYourAnimals",jp);
        CardLayout layout = (CardLayout)container.getLayout();
        layout.next(container);
    }//GEN-LAST:event_btnViewYourAnimalsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNewAssignedCases;
    private javax.swing.JButton btnViewYourAnimals;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
