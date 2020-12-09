/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ShelterAdminRole;

import Business.EcoSystem;
import Business.Enterprise.AdoptionEnterprise;
import Business.Enterprise.Enterprise;
import Business.Organization.AdopterOrganization;
import Business.Organization.Organization;
import Business.Organization.PetOwnerOrganization;
import static Business.Role.Role.RoleType.Adopter;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AdopterAdoptionRequest;
import Business.WorkQueue.AnimalRecord;
import Business.WorkQueue.PetOwnerAdoptionRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author suoxiyue
 */
public class ManageAdoptionsJPanel extends javax.swing.JPanel {

    private JPanel container;
    Organization organization;
    UserAccount userAccount;
    /**
     * Creates new form RequestFromPetOwner
     */
    public ManageAdoptionsJPanel(JPanel container, Organization org, UserAccount ua) {
        initComponents();
        this.container = container;
        this.organization = org;
        this.userAccount = ua;
        
        popTable();
        //popTablePetOwner();
    }
    
    public void popTable() {
        DefaultTableModel model = (DefaultTableModel) tblAdoptions.getModel();
        model.setRowCount(0);
        
        for (Enterprise enterprise : userAccount.getState().getEnterpriseDirectory().getEnterpriseList()) {
            if (enterprise instanceof AdoptionEnterprise) {
                for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    
                    if (org instanceof AdopterOrganization) {                        
                        for (UserAccount ua : org.getUserAccountDirectory().getUserAccountList() ) {
                           for (WorkRequest wr : ua.getWorkQueue().getWorkRequestList()) {
                                if (wr instanceof AdopterAdoptionRequest) {
                                     //System.out.println("in animalrecord"); //test
                                     Object row[] = new Object[9]; 
                                     row[0] = wr;
                                     row[1] = ((AdopterAdoptionRequest) wr).getAnimal().getID();
                                     row[2] = ((AdopterAdoptionRequest) wr).getAnimal().getReportingRequest().getAnimalType();
                                     row[3] = ((AdopterAdoptionRequest) wr).getAnimal().getBreed() ==null ? "--": ((AdopterAdoptionRequest) wr).getAnimal().getBreed();
                                     row[4] = ((AdopterAdoptionRequest) wr).getAnimal().getPetName() ==null ? "--": ((AdopterAdoptionRequest) wr).getAnimal().getPetName();
                                     row[5] = ((AdopterAdoptionRequest) wr).getAnimal().getShelterRequest().getAssignedStaff();
                                     row[6] = ((AdopterAdoptionRequest) wr).getAnimal().getStatus();
                                     row[7] = ((AdopterAdoptionRequest) wr).getAdopter();
                                     row[8] = "Adopter";

                                     ((DefaultTableModel) tblAdoptions.getModel()).addRow(row);
                                }
                            }                           
                        }
                    }
                    
                    if (org instanceof PetOwnerOrganization) {                        
                        for (UserAccount ua : org.getUserAccountDirectory().getUserAccountList() ) {
                           for (WorkRequest wr : ua.getWorkQueue().getWorkRequestList()) {                               
                                if (wr instanceof PetOwnerAdoptionRequest) {
                                    Object row[] = new Object[9]; 
                                    row[0] = wr;
                                    row[1] = ((PetOwnerAdoptionRequest) wr).getAnimal().getID();
                                    row[2] = ((PetOwnerAdoptionRequest) wr).getAnimal().getReportingRequest().getAnimalType();
                                    row[3] = ((PetOwnerAdoptionRequest) wr).getAnimal().getBreed() ==null ? "--": ((PetOwnerAdoptionRequest) wr).getAnimal().getBreed();
                                    row[4] = ((PetOwnerAdoptionRequest) wr).getAnimal().getPetName()  ==null ? "--": ((PetOwnerAdoptionRequest) wr).getAnimal().getPetName();
                                    row[5] = ((PetOwnerAdoptionRequest) wr).getAnimal().getShelterRequest().getAssignedStaff();
                                    row[6] = ((PetOwnerAdoptionRequest) wr).getAnimal().getStatus();
                                    row[7] = ((PetOwnerAdoptionRequest) wr).getAdopter();
                                    row[8] = "Pet Owner";
                                            
                                    ((DefaultTableModel) tblAdoptions.getModel()).addRow(row);
                                }
                            }                           
                        }
                    }                 
                    
                }
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

        jScrollPane2 = new javax.swing.JScrollPane();
        tblAdoptions = new javax.swing.JTable();
        btnProcess = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        tblAdoptions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Request ID", "Animal ID", "Type", "Breed", "Name", "Staff", "Status", "Requested By", "Role"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblAdoptions);

        btnProcess.setText("Process");
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Adoption Request ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 44, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 937, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(429, 429, 429)
                        .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessActionPerformed

          int row = tblAdoptions.getSelectedRow();
          if(row<0) {
              JOptionPane.showMessageDialog(null, "Please select a request to process!", "Warning",JOptionPane.WARNING_MESSAGE);
              return;
          } 
          WorkRequest wr = (WorkRequest)tblAdoptions.getValueAt(row, 0);
          if (wr instanceof AdopterAdoptionRequest) {
              ProcessAdopterRequestJPanel jp = new ProcessAdopterRequestJPanel(container, (AdopterAdoptionRequest)wr);
              container.add("ProcessAdopterRequestJPanel",jp);
              CardLayout layout = (CardLayout)container.getLayout();
              layout.next(container);           
          }
          if (wr instanceof PetOwnerAdoptionRequest) {
              ProcessPetOwnerRequestJPanel jp = new ProcessPetOwnerRequestJPanel(container, (PetOwnerAdoptionRequest)wr);
              container.add("ProcessPetOwnerRequestJPanel",jp);
              CardLayout layout = (CardLayout)container.getLayout();
              layout.next(container);
          }

    }//GEN-LAST:event_btnProcessActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnProcess;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblAdoptions;
    // End of variables declaration//GEN-END:variables
}
