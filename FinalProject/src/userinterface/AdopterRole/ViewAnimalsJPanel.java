/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AdopterRole;

import Business.Enterprise.Enterprise;
import Business.Enterprise.RescueEnterprise;
import Business.Organization.AnimalShelterOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AdopterAdoptionRequest;
import Business.WorkQueue.AdopterRegistrationRequest;
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
 * @author suoxiyue
 */
public class ViewAnimalsJPanel extends javax.swing.JPanel {

    private JPanel container;
    private UserAccount ua;
    private AdopterAdoptionRequest adoption;
    //private Organization choosenShelterOrg;
    /**
     * Creates new form AdopterWorkAreaJPanel
     */
    public ViewAnimalsJPanel(JPanel userProcessContainer, UserAccount ua) {
        initComponents();
        this.ua = ua;
        this.container = userProcessContainer;
        
        txtName.setEditable(false);
        txtType.setEditable(false);
        txtAge.setEditable(false);
        txtBreed.setEditable(false);
        txtSex.setEditable(false);
        txtMedicalRecord.setEditable(false);
        
        popTable();
        displayInfo();
    }
    
    public void popTable(){
        DefaultTableModel model = (DefaultTableModel) animalTable.getModel();
        model.setRowCount(0);
        for (Enterprise enterprise : ua.getState().getEnterpriseDirectory().getEnterpriseList()) {
           if (enterprise instanceof RescueEnterprise) {
                for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    if (org instanceof AnimalShelterOrganization) {
                        //choosenShelterOrg = org;
                        for (WorkRequest animal : org.getWorkQueue().getWorkRequestList()) {
                            if ( (animal instanceof AnimalRecord) && (animal.getStatus().equals("Posted For Adoption")) ||(animal.getStatus().equals("Adoption Requested")) ) {
                                Object row[] = new Object[8]; 
                                row[0] = animal;
                                row[1] = ua.getState();
                                row[2] = ((AnimalRecord) animal).getReportingRequest().getAnimalType();
                                row[3]= ((AnimalRecord) animal).getBreed();                               
                                row[4] = ((AnimalRecord) animal).getSex();
                                row[5] = ((AnimalRecord) animal).getAge();
                                row[6] = ((AnimalRecord) animal).getShelterRequest().getShelterOrg();
                                row[7] = animal.getStatus();
                                
                                ((DefaultTableModel) animalTable.getModel()).addRow(row);
                            }
                        }
                    }
                   
                }
                
           }
           
        }
    }
    
    public void displayInfo(){
        ListSelectionModel model = animalTable.getSelectionModel();
        model.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        model.addListSelectionListener(new ListSelectionListener() {
          @Override
          public void valueChanged(ListSelectionEvent e) {
            int row = animalTable.getSelectedRow();
            if(row>=0) {
                AnimalRecord animal = (AnimalRecord) animalTable.getValueAt(row, 0);
                idLabel.setText(animal.getID());
                txtName.setText(animal.getPetName());
                txtType.setText(animal.getReportingRequest().getAnimalType());
                txtAge.setText(animal.getAge());
                txtBreed.setText(animal.getBreed());
                txtSex.setText(animal.getSex());
                
                String healthRecord = "";
                for (String s : animal.getMedicalRecord()) {
                    healthRecord += s + "\n";
                }
                txtMedicalRecord.setText(healthRecord);
                
                String imagePath = animal.getImagePath();
                Image im;
                    if (animal.isAddedAhead() == true) {
                        im = new ImageIcon(this.getClass().getResource(imagePath)).getImage();
                    }else{
                        im = Toolkit.getDefaultToolkit().createImage(imagePath);
                    }               
                im = im.getScaledInstance(pictureLabel.getWidth(), pictureLabel.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon ii = new ImageIcon(im);
                pictureLabel.setIcon(ii);
            }
          }
        });
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
        animalTable = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtType = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtBreed = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMedicalRecord = new javax.swing.JTextArea();
        idLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnRequest = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        pictureLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSex = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("View Animals");

        animalTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Animal ID", "State", "Type", "Breed", "Sex", "Age", "Shelter", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(animalTable);

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel2.setText("Type:");

        jLabel3.setText("Age:");

        jLabel4.setText("Medical Record:");

        txtMedicalRecord.setColumns(20);
        txtMedicalRecord.setRows(5);
        jScrollPane2.setViewportView(txtMedicalRecord);

        idLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        idLabel.setText("<AnimalID>");

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel6.setText("Animal ID");

        jLabel5.setText("Name:");

        btnRequest.setText("I Want This Cute");
        btnRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestActionPerformed(evt);
            }
        });

        jLabel8.setText("Breed:");

        pictureLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pictureLabel.setText("Animal Picture");
        pictureLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setText("Sex:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(btnRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel7)
                                                .addComponent(jLabel8)
                                                .addComponent(jLabel3))
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(27, 27, 27)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                            .addComponent(txtType)
                                            .addComponent(txtBreed)
                                            .addComponent(txtSex)
                                            .addComponent(txtAge, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(idLabel))
                                    .addComponent(jLabel4))
                                .addGap(63, 63, 63)
                                .addComponent(pictureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(369, 369, 369)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 986, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnBack)
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(idLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtBreed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(pictureLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestActionPerformed
        
        int row = animalTable.getSelectedRow();
            if(row<0) {
                JOptionPane.showMessageDialog(null, "Please select any row!", "Warning",JOptionPane.WARNING_MESSAGE);
                return;
            }
            AnimalRecord animal = (AnimalRecord) animalTable.getValueAt(row, 0);
            animal.setStatus("Adoption Requested");
            adoption = new AdopterAdoptionRequest();
            adoption.setAnimal(animal);
            adoption.setStatus("Adoptor Requested");
            
            for (WorkRequest adopter : ua.getWorkQueue().getWorkRequestList()) {
                if (adopter instanceof AdopterRegistrationRequest) {
                    adoption.setAdopter((AdopterRegistrationRequest) adopter);
                    break;
                }
            }
            
            ua.getWorkQueue().getWorkRequestList().add(adoption);
            //choosenShelterOrg.getWorkQueue().getWorkRequestList().add(adoption);
            JOptionPane.showMessageDialog(null, "Thanks for your efforts in saving lives, you request has been sent to the shelter!");
            popTable();
            txtName.setText("");
            txtType.setText("");
            txtAge.setText("");
            txtBreed.setText("");
            txtSex.setText("");
            txtMedicalRecord.setText("");
    }//GEN-LAST:event_btnRequestActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable animalTable;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRequest;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel pictureLabel;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtBreed;
    private javax.swing.JTextArea txtMedicalRecord;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSex;
    private javax.swing.JTextField txtType;
    // End of variables declaration//GEN-END:variables
}
