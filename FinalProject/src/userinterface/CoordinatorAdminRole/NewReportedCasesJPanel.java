/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CoordinatorAdminRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.IncidentEnterprise;
import Business.Network.Network;
import Business.Organization.IncidentReportingOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AnimalRecord;
import Business.WorkQueue.AnimalReportingRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author suoxiyue
 */
public class NewReportedCasesJPanel extends javax.swing.JPanel {
    
    private JPanel container;
    

    Enterprise enterprise;
    Organization organization;
    EcoSystem system;
    
    
    /**
     * Creates new form NewReportedCaseJPanel
     */
    public NewReportedCasesJPanel(JPanel container, Enterprise enterprise, Organization org, EcoSystem sys) {
        initComponents();
        this.container = container;
        this.enterprise = enterprise;
        this.organization = org;
        this.system = sys;
        txtMessage.setEditable(false);
        popTable();
        popCoordinatorComboBox();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAssignCoord = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNewCase = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        comboCoordinator = new javax.swing.JComboBox();
        lblPicture = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtMessage = new javax.swing.JTextArea();
        btnView = new javax.swing.JButton();

        btnAssignCoord.setText("Assgin To This Coordinator");
        btnAssignCoord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignCoordActionPerformed(evt);
            }
        });

        tblNewCase.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Case ID", "Animal Type", "Location", "Report Date", "Reported By", "Message", "Coordinator", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblNewCase);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel1.setText("Coordinator List:");

        comboCoordinator.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblPicture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPicture.setText("Animal Picture");
        lblPicture.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Animal Picture:");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Message:");

        txtMessage.setColumns(20);
        txtMessage.setRows(5);
        jScrollPane3.setViewportView(txtMessage);

        btnView.setText("View ");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(194, 194, 194)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboCoordinator, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(226, 226, 226)
                                        .addComponent(btnAssignCoord))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(49, 49, 49)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(48, 48, 48)
                                .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnView)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(comboCoordinator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAssignCoord)))
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void popTable() {

        DefaultTableModel model = (DefaultTableModel) tblNewCase.getModel();
        model.setRowCount(0);
        for (Network n : system.getNetworkList()) {        
            System.out.println("in network");
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                System.out.println(e.getWorkQueue().getWorkRequestList().size()); // test
                if (e instanceof IncidentEnterprise) {
                    System.out.println("in incident enterprise");
                    for (Organization org : e.getOrganizationDirectory().getOrganizationList()) {
                        if (org instanceof IncidentReportingOrganization) {
                            for (WorkRequest wq : org.getWorkQueue().getWorkRequestList()) {
                                if (wq instanceof AnimalRecord) {
                                    
                                    //if (((AnimalReportingRequest) wq).isIsNewReported()) {
                                        Object row[] = new Object[8];
                                        row[0] = wq;
                                        row[1] = ((AnimalRecord) wq).getReportingRequest().getAnimalType();
                                        row[2] = "no";
                                        row[3] = wq.getRequestDate();
                                        row[4] = ((AnimalRecord) wq).getReportingRequest().getWitness();
                                        row[5] = wq.getLatestMessage();
                                        row[6] = ((AnimalRecord) wq).getReportingRequest().getAssignedCoordinator();
                                        row[7] = wq.getStatus();
                                        ((DefaultTableModel) tblNewCase.getModel()).addRow(row);
                                    //}
                                    
                                }

                            }
                        }
                    }
                }

            }
            
        }
    }
    
    public void popCoordinatorComboBox() {
        
        comboCoordinator.removeAllItems();
        
        for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
            if (ua.getRole().toString().equalsIgnoreCase("Coordinator") ) {
                comboCoordinator.addItem(ua);
            }
        }         
    } 
    
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAssignCoordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignCoordActionPerformed
        // TODO add your handling code here:
        int row = tblNewCase.getSelectedRow();
        if(row<0) {
             JOptionPane.showMessageDialog(null, "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        AnimalRecord ar = (AnimalRecord)tblNewCase.getValueAt(row, 0);
        if (ar.getReportingRequest().getAssignedCoordinator()==null) {
            UserAccount ua = (UserAccount)comboCoordinator.getSelectedItem();

            ar.getReportingRequest().setAssignedCoordinator(ua);
            ar.setStatus("Coordinator Assigned");
            
            //set animal record
            // delete on 12/04, b/c animal record added in reporting step
            //AnimalRecord animalrecord = new AnimalRecord();
            //animalrecord.setReportingRequest(wq);

            //add animal record to workqueue
            //organization.getWorkQueue().getWorkRequestList().add(animalrecord);
            String message = "Coordinator Admin assign case to coordinator " + ua;
            ar.addMessage(message);
            JOptionPane.showMessageDialog(null, "Coordinator assigned!");

            popTable();
        }
        else 
            JOptionPane.showMessageDialog(null, "Coordinator already assigned!", "Warning", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btnAssignCoordActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        int row = tblNewCase.getSelectedRow();
        if(row<0) {
             JOptionPane.showMessageDialog(null, "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        AnimalRecord ar = (AnimalRecord)tblNewCase.getValueAt(row, 0);
        for (String s : ar.getMsgList()) {
            txtMessage.setText(s);
        }
        
        String imagePath = ar.getReportingRequest().getImagePath();
        Image im = Toolkit.getDefaultToolkit().createImage(imagePath);
        im = im.getScaledInstance(lblPicture.getWidth(), lblPicture.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon ii = new ImageIcon(im);
        lblPicture.setIcon(ii);
        
    }//GEN-LAST:event_btnViewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssignCoord;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnView;
    private javax.swing.JComboBox comboCoordinator;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblPicture;
    private javax.swing.JTable tblNewCase;
    private javax.swing.JTextArea txtMessage;
    // End of variables declaration//GEN-END:variables
}
