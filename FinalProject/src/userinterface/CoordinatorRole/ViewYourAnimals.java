/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CoordinatorRole;

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
import userinterface.GoogleMap.DistanceMap;

/**
 *
 * @author suoxiyue
 */
public class ViewYourAnimals extends javax.swing.JPanel {

    private JPanel container;
    UserAccount userAccount;
    /**
     * Creates new form ViewAllAnimals
     */
    public ViewYourAnimals(JPanel container, UserAccount ua) {
        initComponents();
        this.container = container;
        
        this.userAccount = ua;
        
        txtCaseID.setEditable(false);
        txtReportDate.setEditable(false);
        txtReportBy.setEditable(false);

        // transportation
        txtCoordinator.setEditable(false);                
        txtVolunteer.setEditable(false);         

        // medical info
        txtType.setEditable(false);
        txtAnimalAge.setEditable(false);
        txtBreed.setEditable(false);
        txtSex.setEditable(false);
        txtHospitalname.setEditable(false);
        txtVetname.setEditable(false);
        txtHealth.setEditable(false);
        
        txtShelterName.setEditable(false);
        txtShelterStaff.setEditable(false);
        
        txtAdopterName.setEditable(false);
        txtAdopterDOB.setEditable(false);
        txtAdopterEmail.setEditable(false);
        txtAdopterNumber.setEditable(false);
        txtAdopterState.setEditable(false);
        txtAdopterCity.setEditable(false);
        txtAdopterStreet.setEditable(false);
        txtAdopterApt.setEditable(false);
        txtAdopterZip.setEditable(false);
        
        popTable();
        displayInfo();
    }
    
    public void popTable(){
        DefaultTableModel model = (DefaultTableModel) tblAnimals.getModel();
        model.setRowCount(0);
        
        for (WorkRequest wr : userAccount.getWorkQueue().getWorkRequestList()) {
            if (wr instanceof AnimalRecord) {                             
                Object row[] = new Object[8];
                row[0] = wr;
                row[1] = wr.getRequestDate();
                row[2] = ((AnimalRecord) wr).getReportingRequest().getAnimalType();
                row[3] = ((AnimalRecord) wr).getVolunteerRequest().getVolunteer();
                row[4] = ((AnimalRecord) wr).getHospitalRequest().getHospitalOrg() ==null?"--": ((AnimalRecord) wr).getHospitalRequest().getHospitalOrg();
                row[5] = ((AnimalRecord) wr).getShelterRequest().getShelterOrg();
                if(((AnimalRecord) wr).getAdopterAdoptionRequest() != null) {    
                     row[6] = ((AnimalRecord) wr).getAdopterAdoptionRequest().getAdopter();
                } else if (((AnimalRecord) wr).getPetOwnerAdoptionRequest() != null) {
                      row[6] = "Pet Owner Claimed";
                } else {
                       row[6] = "--";
                }
                row[7] = wr.getStatus();               
                         
                ((DefaultTableModel) tblAnimals.getModel()).addRow(row);
            }
        }
    }
    
    public void displayInfo(){
        ListSelectionModel model = tblAnimals.getSelectionModel();
        model.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        model.addListSelectionListener(new ListSelectionListener() {
          @Override
          public void valueChanged(ListSelectionEvent e) {
            int row = tblAnimals.getSelectedRow();
            if(row>=0) {
                AnimalRecord ar = (AnimalRecord) tblAnimals.getValueAt(row, 0);
                
                // reporting info
                txtCaseID.setText(ar.getID());
                txtReportDate.setText(ar.getRequestDate().toString());
                txtReportBy.setText(ar.getReportingRequest().getWitness().getEmployee().getName());
                
                // transportation
                txtCoordinator.setText(ar.getReportingRequest().getAssignedCoordinator().getEmployee().getName());                
                txtVolunteer.setText(ar.getVolunteerRequest().getVolunteer() ==null?"--": ar.getVolunteerRequest().getVolunteer().getEmployee().getName());               
                
                // medical info
                txtType.setText(ar.getReportingRequest().getAnimalType());
                txtAnimalAge.setText(ar.getAge()==null?"--":ar.getAge());
                txtBreed.setText(ar.getBreed()==null?"--":ar.getBreed());
                txtSex.setText(ar.getSex()==null?"--":ar.getSex());
                txtHospitalname.setText(ar.getHospitalRequest().getHospitalOrg() ==null?"--": ar.getHospitalRequest().getHospitalOrg().getName());
                txtVetname.setText(ar.getHospitalRequest().getAssignedVet() ==null?"-": ar.getHospitalRequest().getAssignedVet().getEmployee().getName());
                String healthRecord = "";
                for (String s : ar.getMedicalRecord()) {
                    healthRecord += s + "\n";
                }
                txtHealth.setText(healthRecord);
                
                // shelter info
                txtShelterName.setText(ar.getShelterRequest().getShelterOrg() ==null?"--": ar.getShelterRequest().getShelterOrg().getName());
                txtShelterStaff.setText(ar.getShelterRequest().getAssignedStaff() ==null?"--": ar.getShelterRequest().getAssignedStaff().getEmployee().getName());
                
                
                //adoptor info
                if (ar.getAdopterAdoptionRequest() != null) {
                    txtAdopterName.setText(ar.getAdopterAdoptionRequest().getAdopter().toString());
                    txtAdopterDOB.setText(ar.getAdopterAdoptionRequest().getAdopter().getDoB());
                    txtAdopterEmail.setText(ar.getAdopterAdoptionRequest().getAdopter().getEmail());
                    txtAdopterNumber.setText(ar.getAdopterAdoptionRequest().getAdopter().getNumber());
                    txtAdopterState.setText(ar.getAdopterAdoptionRequest().getAdopter().getState().getName());
                    txtAdopterCity.setText(ar.getAdopterAdoptionRequest().getAdopter().getCity());                                                                  
                    txtAdopterStreet.setText(ar.getAdopterAdoptionRequest().getAdopter().getStreet());  
                    txtAdopterApt.setText(ar.getAdopterAdoptionRequest().getAdopter().getApt());
                    txtAdopterZip.setText(ar.getAdopterAdoptionRequest().getAdopter().getZipCode());
                    
                }else{
                    txtAdopterName.setText("--");
                    txtAdopterDOB.setText("--");
                    txtAdopterEmail.setText("--");
                    txtAdopterNumber.setText("--");
                    txtAdopterState.setText("--");
                    txtAdopterCity.setText("--");
                    txtAdopterStreet.setText("--");
                    txtAdopterApt.setText("--");
                    txtAdopterZip.setText("--");            
                }
                
                if (ar.getPetOwnerAdoptionRequest() != null) {
                    txtAdopterName.setText(ar.getPetOwnerAdoptionRequest().getAdopter().toString());
                    txtAdopterDOB.setText(ar.getPetOwnerAdoptionRequest().getAdopter().getDoB());
                    txtAdopterEmail.setText(ar.getPetOwnerAdoptionRequest().getAdopter().getEmail());
                    txtAdopterNumber.setText(ar.getPetOwnerAdoptionRequest().getAdopter().getNumber());
                    txtAdopterState.setText(ar.getPetOwnerAdoptionRequest().getAdopter().getState().getName());
                    txtAdopterCity.setText(ar.getPetOwnerAdoptionRequest().getAdopter().getCity());
                    txtAdopterStreet.setText(ar.getPetOwnerAdoptionRequest().getAdopter().getStreet());
                    txtAdopterApt.setText(ar.getPetOwnerAdoptionRequest().getAdopter().getApt());
                    txtAdopterZip.setText(ar.getPetOwnerAdoptionRequest().getAdopter().getZipCode());
                } else {
                    txtAdopterName.setText("--");
                    txtAdopterDOB.setText("--");
                    txtAdopterEmail.setText("--");
                    txtAdopterNumber.setText("--");
                    txtAdopterState.setText("--");
                    txtAdopterCity.setText("--");
                    txtAdopterStreet.setText("--");
                    txtAdopterApt.setText("--");
                    txtAdopterZip.setText("--");            
                }
                
                
                String s = "";
                for (String message : ar.getMsgList() ) {
                    s += message + "\n";
                }
                txtMessageList.setText(s);
                
                //show picture
                String imagePath;
                if (ar.getImagePath()==null) {
                    imagePath = ar.getReportingRequest().getImagePath();
                }else{
                    imagePath = ar.getImagePath();
                }
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
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAnimals = new javax.swing.JTable();
        lblPicture = new javax.swing.JLabel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        Reporting = new javax.swing.JPanel();
        txtCaseID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtReportDate = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtReportBy = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        txtVolunteer = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtCoordinator = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        txtHospitalname = new javax.swing.JTextField();
        txtVetname = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtType = new javax.swing.JTextField();
        txtBreed = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtAnimalAge = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        btnHospitalViewMap = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txtSex = new javax.swing.JTextField();
        shelter = new javax.swing.JPanel();
        txtShelterStaff = new javax.swing.JTextField();
        txtShelterName = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtShelterViewMap = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtAdopterApt = new javax.swing.JTextField();
        txtAdopterCity = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtAdopterZip = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtAdopterDOB = new javax.swing.JTextField();
        txtAdopterState = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtAdopterNumber = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtAdopterName = new javax.swing.JTextField();
        txtAdopterEmail = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtAdopterStreet = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtMessageList = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtHealth = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(255, 255, 255));

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        btnBack.setBorderPainted(false);
        btnBack.setContentAreaFilled(false);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tblAnimals.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Animal ID", "Reported Date", "Animal Type", "Volunteer", "Hospital", "Shelter", "Adopted/Found", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAnimals);

        lblPicture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPicture.setText("Animal Picture");
        lblPicture.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTabbedPane4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane4.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jLabel2.setText("Case ID");

        jLabel6.setText("Reported Date");

        jLabel10.setText("Reported By");

        javax.swing.GroupLayout ReportingLayout = new javax.swing.GroupLayout(Reporting);
        Reporting.setLayout(ReportingLayout);
        ReportingLayout.setHorizontalGroup(
            ReportingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReportingLayout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addGroup(ReportingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ReportingLayout.createSequentialGroup()
                        .addGroup(ReportingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(ReportingLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(txtReportBy, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ReportingLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtCaseID, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(215, 215, 215))
                    .addGroup(ReportingLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtReportDate, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94))))
        );
        ReportingLayout.setVerticalGroup(
            ReportingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReportingLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(ReportingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCaseID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ReportingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtReportDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ReportingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtReportBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
        );

        jTabbedPane4.addTab("Reporting Information", Reporting);

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Transported By");

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("Assigned By");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtVolunteer, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCoordinator, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(207, 207, 207))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCoordinator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtVolunteer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(105, 105, 105))
        );

        jTabbedPane4.addTab("Transportation Information", jPanel8);

        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel43.setText("Hospital");

        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel54.setText("Vet Name");

        jLabel11.setText("Animal Type");

        jLabel12.setText("Breed");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Age");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Hospital Location");

        btnHospitalViewMap.setText("View On Map");
        btnHospitalViewMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHospitalViewMapActionPerformed(evt);
            }
        });

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Sex");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAnimalAge, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBreed, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSex, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel54, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnHospitalViewMap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtHospitalname)
                    .addComponent(txtVetname))
                .addGap(27, 27, 27))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtBreed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(btnHospitalViewMap)))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(txtAnimalAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(txtSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHospitalname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel54)
                            .addComponent(txtVetname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40))
        );

        jTabbedPane4.addTab("Medical Information", jPanel9);

        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel57.setText("Shelter Name");

        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel59.setText("Shelter Staff");

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Shelter Location");

        txtShelterViewMap.setText("View On Map");
        txtShelterViewMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtShelterViewMapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout shelterLayout = new javax.swing.GroupLayout(shelter);
        shelter.setLayout(shelterLayout);
        shelterLayout.setHorizontalGroup(
            shelterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shelterLayout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addGroup(shelterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(shelterLayout.createSequentialGroup()
                        .addGroup(shelterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(shelterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtShelterStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtShelterName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(shelterLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtShelterViewMap, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(199, 199, 199))
        );
        shelterLayout.setVerticalGroup(
            shelterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shelterLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(shelterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtShelterName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57))
                .addGap(24, 24, 24)
                .addGroup(shelterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(txtShelterStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(shelterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txtShelterViewMap))
                .addContainerGap())
        );

        jTabbedPane4.addTab("Shelter Information", shelter);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Zip Code");

        jLabel27.setText("City");

        jLabel26.setText("State");

        jLabel17.setText("DOB(MM/DD/YY)");

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Number");

        jLabel16.setText("Adopter Name");

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Email");

        jLabel21.setText("Street Line");

        jLabel20.setText("Apt");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAdopterName, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAdopterDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtAdopterNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtAdopterEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAdopterZip, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAdopterStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAdopterApt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAdopterState, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAdopterCity, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(107, 107, 107))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtAdopterName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtAdopterDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(txtAdopterState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(txtAdopterCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtAdopterEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txtAdopterNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(txtAdopterStreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txtAdopterApt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txtAdopterZip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        jTabbedPane4.addTab("Adopter Information", jPanel2);

        txtMessageList.setColumns(20);
        txtMessageList.setRows(5);
        txtMessageList.setPreferredSize(new java.awt.Dimension(240, 65));
        jScrollPane3.setViewportView(txtMessageList);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-messaging.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Message History:");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-treatment.png"))); // NOI18N

        jLabel29.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Medical History:");

        txtHealth.setColumns(20);
        txtHealth.setRows(5);
        txtHealth.setPreferredSize(new java.awt.Dimension(240, 65));
        jScrollPane2.setViewportView(txtHealth);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 896, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(150, 150, 150))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPicture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane3))
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnHospitalViewMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHospitalViewMapActionPerformed
        // TODO add your handling code here:
        int row = tblAnimals.getSelectedRow();
        if(row<0) {
             JOptionPane.showMessageDialog(null, "Please select a case from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
       AnimalRecord ar = (AnimalRecord) tblAnimals.getValueAt(row, 0);
        
        String coordinates = "['" + ar.getHospitalRequest().getHospitalOrg().getName() + " Location'," 
                + ar.getHospitalRequest().getHospitalOrg().getLocationP().getLatitude() + ", " 
                + ar.getHospitalRequest().getHospitalOrg().getLocationP().getLongitude() + "]";
        
        //System.out.println("===---->>> coordinates is " + coordinates.substring(0, coordinates.length()-1));
        DistanceMap.openMap(coordinates);
    }//GEN-LAST:event_btnHospitalViewMapActionPerformed

    private void txtShelterViewMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtShelterViewMapActionPerformed
        // TODO add your handling code here:
        int row = tblAnimals.getSelectedRow();
        if(row<0) {
             JOptionPane.showMessageDialog(null, "Please select a case from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
       AnimalRecord ar = (AnimalRecord) tblAnimals.getValueAt(row, 0);
        
        String coordinates = "['" + ar.getShelterRequest().getShelterOrg().getName() + " Location'," 
                + ar.getShelterRequest().getShelterOrg().getLocationP().getLatitude() + ", " 
                + ar.getShelterRequest().getShelterOrg().getLocationP().getLongitude() + "]";
        
        //System.out.println("===---->>> coordinates is " + coordinates.substring(0, coordinates.length()-1));
        DistanceMap.openMap(coordinates);
    }//GEN-LAST:event_txtShelterViewMapActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Reporting;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnHospitalViewMap;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JLabel lblPicture;
    private javax.swing.JPanel shelter;
    private javax.swing.JTable tblAnimals;
    private javax.swing.JTextField txtAdopterApt;
    private javax.swing.JTextField txtAdopterCity;
    private javax.swing.JTextField txtAdopterDOB;
    private javax.swing.JTextField txtAdopterEmail;
    private javax.swing.JTextField txtAdopterName;
    private javax.swing.JTextField txtAdopterNumber;
    private javax.swing.JTextField txtAdopterState;
    private javax.swing.JTextField txtAdopterStreet;
    private javax.swing.JTextField txtAdopterZip;
    private javax.swing.JTextField txtAnimalAge;
    private javax.swing.JTextField txtBreed;
    private javax.swing.JTextField txtCaseID;
    private javax.swing.JTextField txtCoordinator;
    private javax.swing.JTextArea txtHealth;
    private javax.swing.JTextField txtHospitalname;
    private javax.swing.JTextArea txtMessageList;
    private javax.swing.JTextField txtReportBy;
    private javax.swing.JTextField txtReportDate;
    private javax.swing.JTextField txtSex;
    private javax.swing.JTextField txtShelterName;
    private javax.swing.JTextField txtShelterStaff;
    private javax.swing.JButton txtShelterViewMap;
    private javax.swing.JTextField txtType;
    private javax.swing.JTextField txtVetname;
    private javax.swing.JTextField txtVolunteer;
    // End of variables declaration//GEN-END:variables
}
