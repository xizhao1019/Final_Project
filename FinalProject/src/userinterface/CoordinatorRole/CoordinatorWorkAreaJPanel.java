/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CoordinatorRole;

import Business.EcoSystem;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author suoxiyue
 */
public class CoordinatorWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel container;
    EcoSystem system;
    UserAccount userAccount;
    /**
     * Creates new form CoordinatorWorkAreaJPanel
     */
    public CoordinatorWorkAreaJPanel(JPanel container, EcoSystem sys, UserAccount ua) {
        initComponents();
        this.container = container;
        this.system = sys;
        this.userAccount = ua;
        valueLabel.setText(userAccount.getEmployee().getName());
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
        jLabel2 = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

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

        jLabel2.setText("Hello,");

        valueLabel.setText("<Coordinator>");

        jLabel3.setText("Role: Coordinator");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(btnNewAssignedCases)
                        .addGap(170, 170, 170)
                        .addComponent(btnViewYourAnimals))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(jLabel3)))
                .addGap(99, 99, 99))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewAssignedCases)
                    .addComponent(btnViewYourAnimals))
                .addGap(174, 174, 174))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewAssignedCasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewAssignedCasesActionPerformed
        // TODO add your handling code here:
        NewAssignedCaseJPanel jp = new NewAssignedCaseJPanel(container, system, userAccount);
        container.add("NewAssignedCaseJPanel",jp);
        CardLayout layout = (CardLayout)container.getLayout();
        layout.next(container);
    }//GEN-LAST:event_btnNewAssignedCasesActionPerformed

    private void btnViewYourAnimalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewYourAnimalsActionPerformed
        // TODO add your handling code here:
        ViewYourAnimals jp = new ViewYourAnimals(container, userAccount);
        container.add("ViewYourAnimals",jp);
        CardLayout layout = (CardLayout)container.getLayout();
        layout.next(container);
    }//GEN-LAST:event_btnViewYourAnimalsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNewAssignedCases;
    private javax.swing.JButton btnViewYourAnimals;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
