/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.VolunteerRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.RescueEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.VolunteerOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AnimalRecord;
import Business.WorkQueue.AnimalReportingRequest;
import Business.WorkQueue.VolunteerRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author suoxiyue
 */
public class VolunteerWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel container;
    EcoSystem system;
    UserAccount userAccount;
    /**
     * Creates new form TransporterWorkAreaJPanel
     */
    public VolunteerWorkAreaJPanel(JPanel container, EcoSystem sys, UserAccount ua) {
        initComponents();
        this.container = container;
        this.system = sys;
        this.userAccount = ua;
        
        valueLabel.setText(userAccount.getEmployee().getName());
        
        popTable();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVolunteerCase = new javax.swing.JTable();
        btnAccept = new javax.swing.JButton();
        btnDecline = new javax.swing.JButton();
        btnProcess = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("Volunteer Work Area");

        tblVolunteerCase.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Case ID", "Animal Type", "Location", "Destination", "Witness", "Message", "Volunteer Status", "Hospital Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblVolunteerCase);

        btnAccept.setText("Accept");
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });

        btnDecline.setText("Decline");
        btnDecline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeclineActionPerformed(evt);
            }
        });

        btnProcess.setText("Process");
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });

        jLabel2.setText("Role: Volunteer");

        jLabel3.setText("Hello,");

        valueLabel.setText("<Volunteer>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDecline, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 905, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDecline, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(195, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void popTable() {
        DefaultTableModel model = (DefaultTableModel) tblVolunteerCase.getModel();
        model.setRowCount(0);
        for (WorkRequest wq : userAccount.getWorkQueue().getWorkRequestList() ) {
           System.out.println("in workrequest");
           if (wq instanceof AnimalRecord) {
                Object row[] = new Object[8]; 
                row[0] = wq;
                row[1] = ((AnimalRecord) wq).getReportingRequest().getAnimalType();
                row[2] = "-no";
                row[3] = ((AnimalRecord) wq).getHospitalRequest() ==null ? "--": ((AnimalRecord) wq).getHospitalRequest().getHospitalOrg().getName();
                row[4] = ((AnimalRecord) wq).getReportingRequest().getWitness();
                row[5] = ((AnimalRecord) wq).getLatestMessage();
                row[6] = ((AnimalRecord) wq).getVolunteerRequest().getStatus() ==null ? "--": ((AnimalRecord) wq).getVolunteerRequest().getStatus();
                row[7] = ((AnimalRecord) wq).getHospitalRequest().getStatus() ==null ? "--": ((AnimalRecord) wq).getHospitalRequest().getStatus();
                ((DefaultTableModel) tblVolunteerCase.getModel()).addRow(row);
           }
           
        }       
   
    }
    
    
    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessActionPerformed
        // TODO add your handling code here:
        int row = tblVolunteerCase.getSelectedRow();
        if(row<0) {
             JOptionPane.showMessageDialog(null, "Please select a request from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        AnimalRecord ar = (AnimalRecord)tblVolunteerCase.getValueAt(row, 0);
        if (ar.getVolunteerRequest().getStatus().equals("Volunteer Declined")) {
            JOptionPane.showMessageDialog(null, "You cannot handle a rejected case");
        } else if (!(ar.getVolunteerRequest().getStatus().equals("Volunteer Accepted"))) {
            JOptionPane.showMessageDialog(null, "Please accept case first");
        } else {
            VolunteerProcessJPanel jp = new VolunteerProcessJPanel(container, ar);
            container.add("VolunteerProcessJPanel",jp);
            CardLayout layout = (CardLayout)container.getLayout();
            layout.next(container);
        }
        
    }//GEN-LAST:event_btnProcessActionPerformed

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        // TODO add your handling code here:
        
        int row = tblVolunteerCase.getSelectedRow();
        if(row<0) {
             JOptionPane.showMessageDialog(null, "Please select a request from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        AnimalRecord ar = (AnimalRecord)tblVolunteerCase.getValueAt(row, 0);
        System.out.println(ar.getHospitalRequest().getStatus()); // test
        if (ar.getVolunteerRequest().getStatus().equals("Volunteer Completed") || ar.getVolunteerRequest().getStatus().equals("Volunteer Accepted") ) {
            JOptionPane.showMessageDialog(null, "Already accepted", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if ((ar.getHospitalRequest().getStatus().equals("Hospital Accepted")) || (ar.getHospitalRequest().getStatus().equals("Vet Assigned") )) {
            ar.getVolunteerRequest().setStatus("Volunteer Accepted");
            JOptionPane.showMessageDialog(null, "Accept case, please go pick up animal");
            popTable();
        }else {
            JOptionPane.showMessageDialog(null, "Wait for hospital administrator accept");
        }
    }//GEN-LAST:event_btnAcceptActionPerformed

    private void btnDeclineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeclineActionPerformed
        // TODO add your handling code here:
        int row = tblVolunteerCase.getSelectedRow();
        if(row<0) {
             JOptionPane.showMessageDialog(null, "Please select a request from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        AnimalRecord ar = (AnimalRecord)tblVolunteerCase.getValueAt(row, 0);
        if (ar.getVolunteerRequest().getStatus().equals("Volunteer Completed") || ar.getVolunteerRequest().getStatus().equals("Volunteer Accepted") ) {
            JOptionPane.showMessageDialog(null, "Already accepted, can not decline.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        ar.getVolunteerRequest().setStatus("Volunteer Declined");
        JOptionPane.showMessageDialog(null, "Request Declined");
        popTable();
    }//GEN-LAST:event_btnDeclineActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnDecline;
    private javax.swing.JButton btnProcess;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVolunteerCase;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
