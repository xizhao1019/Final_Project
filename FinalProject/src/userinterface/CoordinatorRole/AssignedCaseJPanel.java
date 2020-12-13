/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CoordinatorRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.IncidentEnterprise;
import Business.Network.Network;
import Business.Organization.IncidentReportingOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AnimalRecord;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zhaoxi
 */
public class AssignedCaseJPanel extends javax.swing.JPanel {
    private JPanel container;
    EcoSystem system;
    UserAccount userAccount;
    //AnimalRecord record;
    
    /**
     * Creates new form AssignTransporterJPanel
     */
    public AssignedCaseJPanel(JPanel container, EcoSystem sys, UserAccount ua) {
        initComponents();
        this.container = container;
        this.system = sys;
        this.userAccount = ua;
        
        txtID.setEditable(false);
        txtAnimalType.setEditable(false);
        txtID.setEditable(false);
        txtReportDate.setEditable(false);
        txtVolunteer.setEditable(false);
        txtHospital.setEditable(false);
        txtShelter.setEditable(false);
        txtMessage.setEditable(false);

        popTable();
        displayInfo();
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
        tblAssigned = new javax.swing.JTable();
        btnAssignVolunteer = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnAssignHospital = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtReportDate = new javax.swing.JTextField();
        txtAnimalType = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtShelter = new javax.swing.JTextField();
        txtHospital = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtVolunteer = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMessage = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        btnAssignShelter = new javax.swing.JButton();
        lblPicture = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        tblAssigned.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Case ID", "Animal Type", "City", "Report Date", "Volunteer", "Hospital", "Shelter", "Witness Message", "Statusl"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAssigned);

        btnAssignVolunteer.setText("Assgin A Volunteer");
        btnAssignVolunteer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignVolunteerActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnAssignHospital.setText("Assign A Hospital");
        btnAssignHospital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignHospitalActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Case ID");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Report Date");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Shelter");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Animal Type");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Hospital");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Volunteer");

        txtMessage.setColumns(20);
        txtMessage.setRows(5);
        jScrollPane2.setViewportView(txtMessage);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Message");

        btnAssignShelter.setText("Assign A Shelter");
        btnAssignShelter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignShelterActionPerformed(evt);
            }
        });

        lblPicture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPicture.setText("Animal Picture");
        lblPicture.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblPicture.setSize(new java.awt.Dimension(97, 22));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtReportDate, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAnimalType, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtVolunteer, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtHospital, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                    .addComponent(txtShelter)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jScrollPane2)))
                        .addGap(36, 36, 36)
                        .addComponent(lblPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 959, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(btnAssignVolunteer, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnAssignHospital, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnAssignShelter, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtReportDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtAnimalType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtVolunteer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtHospital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtShelter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(lblPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAssignVolunteer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAssignHospital, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAssignShelter, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void popTable() {
        DefaultTableModel model = (DefaultTableModel) tblAssigned.getModel();

        model.setRowCount(0);
        for (Network n : system.getNetworkList()) {        
        
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                //System.out.println(e.getWorkQueue().getWorkRequestList().size());
                if (e instanceof IncidentEnterprise) {
                    //System.out.println("in enterprise"); //test
                    for (Organization org : e.getOrganizationDirectory().getOrganizationList()) {
                        if (org instanceof IncidentReportingOrganization) {
                            for (WorkRequest wq : org.getWorkQueue().getWorkRequestList()) {
                                //System.out.println("in workrequest"); //test
                                if (wq instanceof AnimalRecord) {
                                    //System.out.println("in animal record"); //test
                                    if (((AnimalRecord)wq).getReportingRequest().getAssignedCoordinator() == userAccount) {
                                        Object row[] = new Object[9];
                                        row[0] = wq;
                                        row[1] = ((AnimalRecord)wq).getReportingRequest().getAnimalType();
                                        row[2] = ((AnimalRecord) wq).getReportingRequest().getCity();
                                        row[3] = ((AnimalRecord)wq).getReportingRequest().getRequestDate();
                                        //row[4] = ((AnimalRecord)wq).getVolunteerRequest().getVolunteer()==null ? "--":((AnimalRecord)wq).getVolunteerRequest().getVolunteer();
                                        if ( ((AnimalRecord)wq).getVolunteerRequest().getVolunteer()==null) {
                                            row[4] = "not assigned";
                                        } else if (((AnimalRecord) wq).getVolunteerRequest().getStatus().equals("Volunteer Declined")) {
                                            row[4] = "Declined";
                                        } else {
                                            row[4] = ((AnimalRecord)wq).getVolunteerRequest().getVolunteer();
                                        }
                                        
                                        //row[5] = ((AnimalRecord)wq).getHospitalRequest().getHospitalOrg()==null ? "--" :((AnimalRecord)wq).getHospitalRequest().getHospitalOrg();
                                        if (((AnimalRecord) wq).getHospitalRequest().getHospitalOrg() == null) {
                                            row[5] = "not assigned";
                                        } else if ( ((AnimalRecord) wq).getHospitalRequest().getStatus().equals("Hospital Declined")) {
                                           row[5] = "Declined";
                                        } else {
                                            row[5] = ((AnimalRecord)wq).getHospitalRequest().getHospitalOrg();
                                        }
                                        
                                        //row[6] = ((AnimalRecord)wq).getShelterRequest().getShelterOrg()==null? "--" : ((AnimalRecord)wq).getShelterRequest().getShelterOrg();
                                        if (((AnimalRecord)wq).getShelterRequest().getShelterOrg()==null) {
                                            row[6] = "not assigned";
                                        } else if (((AnimalRecord) wq).getShelterRequest().getStatus().equals("Shelter Admin Declined")) {
                                            row[6] = "Declined";
                                        } else {
                                            row[6] =((AnimalRecord)wq).getShelterRequest().getShelterOrg();
                                        }
                                        
                                        row[7] = ((AnimalRecord)wq).getLatestMessage();
                                        row[8] = ((AnimalRecord)wq).getStatus();
                                        ((DefaultTableModel) tblAssigned.getModel()).addRow(row);
                                    }
                                    
                                }

                            }
                        }
                    }
                }

            }
            
        }
    
    }
    
    public void displayInfo(){
        ListSelectionModel model = tblAssigned.getSelectionModel();
        model.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        model.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = tblAssigned.getSelectedRow();
                if(row>=0) {
                    AnimalRecord ar = (AnimalRecord)tblAssigned.getValueAt(row, 0);
                    txtAnimalType.setText(ar.getReportingRequest().getAnimalType());
                    txtID.setText(ar.getID());
                    txtReportDate.setText(ar.getReportingRequest().getRequestDate().toString());
                    txtVolunteer.setText(ar.getVolunteerRequest().getVolunteer()==null ? "--":ar.getVolunteerRequest().getVolunteer().getEmployee().getName());
                    txtHospital.setText(ar.getHospitalRequest().getHospitalOrg() ==null ? "--": ar.getHospitalRequest().getHospitalOrg().getName());
                    txtShelter.setText(ar.getShelterRequest().getShelterOrg() ==null ? "--": ar.getShelterRequest().getShelterOrg().getName());
                    String message = "";
                    for (int i = 0; i < ar.getMsgList().size(); i++) {
                        message += ar.getMsgList().get(i) + "\n";
                    }
                    txtMessage.setText(message);

                    String imagePath = ar.getReportingRequest().getImagePath();
                    Image im;
                        if (row == 0) {
                            im = new ImageIcon(this.getClass().getResource(imagePath)).getImage();
                        }else{
                            im = Toolkit.getDefaultToolkit().createImage(imagePath);
                        }
                    im = im.getScaledInstance(lblPicture.getWidth(), lblPicture.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon ii = new ImageIcon(im);
                    lblPicture.setIcon(ii);
                }
            }
        });
    }
    
    public void reset(){
        txtID.setText("");
        txtAnimalType.setText("");
        txtID.setText("");
        txtReportDate.setText("");
        txtVolunteer.setText("");
        txtHospital.setText("");
        txtShelter.setText("");
        txtMessage.setText("");
    }
    
    private void btnAssignShelterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignShelterActionPerformed
        // TODO add your handling code here:
        int row = tblAssigned.getSelectedRow();
        if(row<0) {
             JOptionPane.showMessageDialog(null, "Please select a case from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        AnimalRecord ar = (AnimalRecord) tblAssigned.getValueAt(row, 0);
        if (ar.getShelterRequest().getShelterOrg()==null || ar.getShelterRequest().getStatus().equals("Shelter Admin Declined")) {
            AssignShelterJPanel jp = new AssignShelterJPanel(container, system, ar);
            container.add("AssignShelterJPanel",jp);
            CardLayout layout = (CardLayout)container.getLayout();
            layout.next(container);
        }
        else
            JOptionPane.showMessageDialog(null, "Shelter already assigned!", "Warning", JOptionPane.WARNING_MESSAGE);

    }//GEN-LAST:event_btnAssignShelterActionPerformed

    private void btnAssignVolunteerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignVolunteerActionPerformed
        // TODO add your handling code here:
        int row = tblAssigned.getSelectedRow();
        if(row<0) {
             JOptionPane.showMessageDialog(null, "Please select a case from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        AnimalRecord ar = (AnimalRecord) tblAssigned.getValueAt(row, 0);
        
        if (ar.getVolunteerRequest().getVolunteer()==null || ar.getVolunteerRequest().getStatus().equals("Volunteer Declined")) {
            AssignVolunteerJPanel jp = new AssignVolunteerJPanel(container, system, ar);
            container.add("AssignVolunteerJPanel",jp);
            CardLayout layout = (CardLayout)container.getLayout();
            layout.next(container);
        }
        else
            JOptionPane.showMessageDialog(null, "Volunteer already assigned!", "Warning", JOptionPane.WARNING_MESSAGE);

    }//GEN-LAST:event_btnAssignVolunteerActionPerformed

    private void btnAssignHospitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignHospitalActionPerformed
        // TODO add your handling code here:
        int row = tblAssigned.getSelectedRow();
        if(row<0) {
             JOptionPane.showMessageDialog(null, "Please select a case from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        AnimalRecord ar = (AnimalRecord) tblAssigned.getValueAt(row, 0);
        
        if (ar.getHospitalRequest().getHospitalOrg()==null || ar.getHospitalRequest().getStatus().equals("Hospital Declined")) {
            AssignHospitalJPanel jp = new AssignHospitalJPanel(container, system, ar);
            container.add("AssignHospitalJPanel",jp);
            CardLayout layout = (CardLayout)container.getLayout();
            layout.next(container);
        } else {
            JOptionPane.showMessageDialog(null, "Hospital already assigned!", "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnAssignHospitalActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
        
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssignHospital;
    private javax.swing.JButton btnAssignShelter;
    private javax.swing.JButton btnAssignVolunteer;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblPicture;
    private javax.swing.JTable tblAssigned;
    private javax.swing.JTextField txtAnimalType;
    private javax.swing.JTextField txtHospital;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextArea txtMessage;
    private javax.swing.JTextField txtReportDate;
    private javax.swing.JTextField txtShelter;
    private javax.swing.JTextField txtVolunteer;
    // End of variables declaration//GEN-END:variables
}