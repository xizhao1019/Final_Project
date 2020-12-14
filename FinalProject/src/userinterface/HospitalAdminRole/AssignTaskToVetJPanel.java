/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.HospitalAdminRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AnimalRecord;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author suoxiyue
 */
public class AssignTaskToVetJPanel extends javax.swing.JPanel {
    
    private JPanel container;
    //Enterprise enterprise;
    Organization organization;
    //EcoSystem system;
    UserAccount userAccount;
    
    /**
     * Creates new form TaskFromCoordJPanel
     */
    public AssignTaskToVetJPanel(JPanel container, Organization org, UserAccount ua) {
        initComponents();
        this.container = container;
        //this.enterprise = enterprise;
        this.organization = org;
        //this.system = sys;
        this.userAccount = ua;
        
        popTable();
        popVetComboBox();
        
    }
    
    public void popTable() {
        DefaultTableModel model = (DefaultTableModel) tblAssignVet.getModel();
        model.setRowCount(0);
        for (WorkRequest wr : userAccount.getWorkQueue().getWorkRequestList() ) {
           //System.out.println("in workrequest"); //test
           if (wr instanceof AnimalRecord) {
               if( (((AnimalRecord) wr).getHospitalRequest().getStatus()!=null)  &&  (((AnimalRecord) wr).getHospitalRequest().getStatus().equals("Hospital Accepted"))) {
                   Object row[] = new Object[6]; 
                    row[0] = wr;
                    row[1] = ((AnimalRecord) wr).getReportingRequest().getAnimalType();
                    row[2] = ((AnimalRecord) wr).getLatestMessage();
                    row[3] = ((AnimalRecord) wr).getVolunteerRequest().getVolunteer();
                    row[4] = ((AnimalRecord) wr).getHospitalRequest().getAssignedVet();
                    row[5] = ((AnimalRecord) wr).getHospitalRequest().getStatus();
                    ((DefaultTableModel) tblAssignVet.getModel()).addRow(row);
                }
                
           }
           
        }

    }
    
    
    public void popVetComboBox() {
        
        vetCombo.removeAllItems();
        
        for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
            if (ua.getRole().toString().equalsIgnoreCase("Vet") ) {
                vetCombo.addItem(ua);
            }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblAssignVet = new javax.swing.JTable();
        btnAssign = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMessage = new javax.swing.JTextField();
        vetCombo = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        tblAssignVet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Case ID", "Animal Type", "Message", "Volunteer", "Vet", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAssignVet);

        btnAssign.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-medical_doctor.png"))); // NOI18N
        btnAssign.setBorderPainted(false);
        btnAssign.setContentAreaFilled(false);
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("Assign Task To Vet ");

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        btnBack.setBorderPainted(false);
        btnBack.setContentAreaFilled(false);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Vet:");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Message:");

        vetCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vetImage.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1180, 1180, 1180))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(vetCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnAssign, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(190, 190, 190))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vetCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAssign, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignActionPerformed
        // TODO add your handling code here:
        int row = tblAssignVet.getSelectedRow();
        if(row<0) {
             JOptionPane.showMessageDialog(null, "Please select a case from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        AnimalRecord ar = (AnimalRecord)tblAssignVet.getValueAt(row, 0);
        
        UserAccount ua = (UserAccount)vetCombo.getSelectedItem();
        if (ua == null) {
            JOptionPane.showMessageDialog(null, "Please select a vet to assign", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        ar.getHospitalRequest().setLatestMessage(txtMessage.getText());
        String message = "Hospital admin assign vet: " + txtMessage.getText();
        ar.addMessage(message);
        ar.getHospitalRequest().setAssignedVet(ua);
        ar.getHospitalRequest().setStatus("Vet Assigned");
        ar.getVetRequest().setStatus("Vet Assigned");
        ua.getWorkQueue().getWorkRequestList().add(ar);
        JOptionPane.showMessageDialog(null, "Vet assigned");
        
        txtMessage.setEnabled(false);
        popTable();
    }//GEN-LAST:event_btnAssignActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssign;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAssignVet;
    private javax.swing.JTextField txtMessage;
    private javax.swing.JComboBox vetCombo;
    // End of variables declaration//GEN-END:variables
}
