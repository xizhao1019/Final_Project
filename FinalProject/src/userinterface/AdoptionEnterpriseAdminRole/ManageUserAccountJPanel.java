/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AdoptionEnterpriseAdminRole;

//import userinterface.RescueEnterpriseAdminRole.*;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.AdopterOrganization;
import Business.Organization.Organization;
import Business.Organization.PetOwnerOrganization;
import Business.Role.AdopterRole;
import Business.Role.PetOwnerRole;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AdopterRegistrationRequest;
import Business.WorkQueue.AnimalRecord;
import Business.WorkQueue.PetOwnerRegistrationRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class ManageUserAccountJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageUserAccountJPanel
     */
    private JPanel container;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private Organization adopterOrg;
    private Organization petOwnerOrg;
    private AdopterRegistrationRequest adopter;
    private PetOwnerRegistrationRequest petOwner;
    private String imagePath;

    public ManageUserAccountJPanel(JPanel container, Enterprise enterprise, UserAccount userAccount) {
        initComponents();
        this.container = container;
        this.userAccount = userAccount;
        this.enterprise = enterprise;
        this.adopter = new AdopterRegistrationRequest();
        this.petOwner = new PetOwnerRegistrationRequest();
        initOrg();
        popData();
        popComboBox();
        displayInfo();
        
        txtState.setText(userAccount.getState().getName());
        txtState.setEditable(false);
        
    }
    
    public void initOrg(){
        for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList())
            if (org.getType().equals(Organization.Type.Adopter)) {
                adopterOrg = org;
            }else petOwnerOrg = org;
        }
    
    public void popComboBox(){
        roleComboBox.removeAllItems();
        orgComboBox.removeAllItems();
        orgComboBox.addItem(adopterOrg);
        orgComboBox.addItem(petOwnerOrg);
        orgComboBox.setSelectedItem(petOwnerOrg);
        
        orgComboBox.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(final ActionEvent e) {
               Organization org = (Organization) orgComboBox.getSelectedItem();
               if (org.equals(adopterOrg)) {
                    roleComboBox.removeAllItems();
                    roleComboBox.addItem(Role.RoleType.Adopter);
                    
                    typeComboBox.setEnabled(false);
                    txtBreed.setEnabled(false);
                    txtAge.setEnabled(false);
                    txtPetName.setEnabled(false);
                    btnUpload.setEnabled(false);
               }
               if(org.equals(petOwnerOrg)) {
                    roleComboBox.removeAllItems();
                    roleComboBox.addItem(Role.RoleType.PetOwner);
                    
                    typeComboBox.setEnabled(true);
                    txtBreed.setEnabled(true);
                    txtAge.setEnabled(true);
                    txtPetName.setEnabled(true);
                    btnUpload.setEnabled(true);
               }
           }
       });
    }
    
    
    public void popData() {

        DefaultTableModel model = (DefaultTableModel) userJTable.getModel();

        model.setRowCount(0);

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
                Object row[] = new Object[5];
                row[0] = ua;
                row[1] = ua.getEmployee().getId();
                row[2] = ua.getRole();
                row[3] = ua.getUsername();
                row[4] = ua.getPassword();
                ((DefaultTableModel) userJTable.getModel()).addRow(row);
            }
        }
    }
    
    public void displayInfo(){
        ListSelectionModel model = userJTable.getSelectionModel();
        model.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        model.addListSelectionListener(new ListSelectionListener() {
          @Override
          public void valueChanged(ListSelectionEvent e) {
            int row = userJTable.getSelectedRow();
            if(row>=0) {
                UserAccount ua = (UserAccount) userJTable.getValueAt(row, 0);
                    orgComboBox.setEnabled(false);
                    roleComboBox.setEnabled(false);
                    typeComboBox.setEnabled(false);

                    txtFirstName.setEditable(false);
                    txtLastName.setEditable(false);
                    DateChooser.setEnabled(false);
                    txtNumber.setEditable(false);
                    txtEmail.setEditable(false);
                    txtUserName.setEditable(false);
                    txtPassword.setEditable(false);
                    txtCity.setEditable(false);
                    txtStreet.setEditable(false);
                    txtApt.setEditable(false);
                    txtZipCode.setEditable(false);

                    txtBreed.setEditable(false);
                    txtAge.setEditable(false);
                    txtPetName.setEditable(false);

                    btnUpload.setEnabled(false);

                    UserAccount user = (UserAccount)userJTable.getValueAt(row, 0);
                    for (WorkRequest wq : user.getWorkQueue().getWorkRequestList()) {
                        if (wq instanceof AdopterRegistrationRequest ) {
                        txtFirstName.setText(((AdopterRegistrationRequest) wq).getFirstName());
                        txtLastName.setText(((AdopterRegistrationRequest) wq).getLastName());
                        try {
                            Date dob = new SimpleDateFormat("MM-dd-yyyy").parse(
                                    ((AdopterRegistrationRequest) wq).getDoB());
                            DateChooser.setDate(dob);
                        } catch (ParseException ex) {
                            JOptionPane.showMessageDialog(null, ex, "Warning", JOptionPane.WARNING_MESSAGE);
                        }
            
                        orgComboBox.setSelectedItem(adopterOrg);
                        roleComboBox.setSelectedItem(Role.RoleType.Adopter);

                        txtNumber.setText(((AdopterRegistrationRequest) wq).getNumber());
                        txtEmail.setText(((AdopterRegistrationRequest) wq).getEmail());
                        txtUserName.setText(((AdopterRegistrationRequest) wq).getAdopterAccount().getUsername());
                        txtPassword.setText(((AdopterRegistrationRequest) wq).getAdopterAccount().getPassword());
                        txtCity.setText(((AdopterRegistrationRequest) wq).getCity());
                        txtStreet.setText(((AdopterRegistrationRequest) wq).getStreet());
                        txtApt.setText(((AdopterRegistrationRequest) wq).getApt());
                        txtZipCode.setText(((AdopterRegistrationRequest) wq).getZipCode());

                        txtBreed.setText("--");
                        txtAge.setText("--");
                        txtPetName.setText("--");
                        pictureLabel.setIcon(null);
                        }
            
                        if (wq instanceof PetOwnerRegistrationRequest ) {
                        txtFirstName.setText(((PetOwnerRegistrationRequest) wq).getFirstName());
                        txtLastName.setText(((PetOwnerRegistrationRequest) wq).getLastName());
                        try {
                            Date dob = new SimpleDateFormat("MM-dd-yyyy").parse(
                                    ((PetOwnerRegistrationRequest) wq).getDoB());
                            DateChooser.setDate(dob);
                        } catch (ParseException ex) {
                            JOptionPane.showMessageDialog(null, ex, "Warning", JOptionPane.WARNING_MESSAGE);
                        }
            
                        orgComboBox.setSelectedItem(petOwnerOrg);
                        roleComboBox.setSelectedItem(Role.RoleType.PetOwner);

                        txtNumber.setText(((PetOwnerRegistrationRequest) wq).getNumber());
                        txtEmail.setText(((PetOwnerRegistrationRequest) wq).getEmail());
                        txtUserName.setText(((PetOwnerRegistrationRequest) wq).getPetOwnerAccount().getUsername());
                        txtPassword.setText(((PetOwnerRegistrationRequest) wq).getPetOwnerAccount().getPassword());
                        txtCity.setText(((PetOwnerRegistrationRequest) wq).getCity());
                        txtStreet.setText(((PetOwnerRegistrationRequest) wq).getStreet());
                        txtApt.setText(((PetOwnerRegistrationRequest) wq).getApt());
                        txtZipCode.setText(((PetOwnerRegistrationRequest) wq).getZipCode());

                        txtBreed.setText(((PetOwnerRegistrationRequest) wq).getBreed());
                        txtAge.setText(((PetOwnerRegistrationRequest) wq).getAge());
                        txtPetName.setText(((PetOwnerRegistrationRequest) wq).getPetName());

                        imagePath = ((PetOwnerRegistrationRequest) wq).getImagePath();
                        Image im = Toolkit.getDefaultToolkit().createImage(imagePath);
                        im = im.getScaledInstance(pictureLabel.getWidth(), pictureLabel.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon ii = new ImageIcon(im);
                        pictureLabel.setIcon(ii);
                        }
                    }
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

        btnCreatAdopter = new javax.swing.JButton();
        backjButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userJTable = new javax.swing.JTable();
        txtState = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtNumber = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtStreet = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtApt = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtZipCode = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        DateChooser = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        typeComboBox = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        txtBreed = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtPetName = new javax.swing.JTextField();
        pictureLabel = new javax.swing.JLabel();
        btnUpload = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btnCreatePetOwner = new javax.swing.JButton();
        btnCreateNew = new javax.swing.JButton();
        roleComboBox = new javax.swing.JComboBox();
        orgComboBox = new javax.swing.JComboBox();

        btnCreatAdopter.setText("Create Adopter");
        btnCreatAdopter.setEnabled(false);
        btnCreatAdopter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreatAdopterActionPerformed(evt);
            }
        });

        backjButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backjButton1.setText("<< Back");
        backjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Manage Adoption Users");

        userJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "User ID", "Role", "User Name", "Password"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(userJTable);

        jLabel7.setText("Role:");

        jLabel5.setText("City");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("State:");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Organization");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("First Name:");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Last Name:");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Number:");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Email:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Street:");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Apt:");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Zip Code:");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("DOB(MM/DD/YY):");

        DateChooser.setDateFormatString("MM-dd-yyyy");

        jLabel19.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Pet Information");

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Animal Type:");

        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dog", "Cat", "Other" }));

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Breed:");

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Age:");

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Pet Name:");

        pictureLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pictureLabel.setText("Animal Picture");
        pictureLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnUpload.setText("Upload pet picture");
        btnUpload.setEnabled(false);
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("User Name:");

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Password:");

        jLabel23.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Personal Information");

        jLabel24.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("User Account");

        btnCreatePetOwner.setText("Create PetOwner");
        btnCreatePetOwner.setEnabled(false);
        btnCreatePetOwner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreatePetOwnerActionPerformed(evt);
            }
        });

        btnCreateNew.setText("Create Users");
        btnCreateNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateNewActionPerformed(evt);
            }
        });

        roleComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));

        orgComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(orgComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(roleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtBreed, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(46, 46, 46)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(DateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(txtStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(txtApt, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(txtZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addGap(122, 122, 122)
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(18, 18, 18)
                                                        .addComponent(pictureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(40, 40, 40)
                                                        .addComponent(btnUpload))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtPetName, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(btnCreateNew, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCreatAdopter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCreatePetOwner)))
                .addGap(409, 409, 409))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backjButton1)
                .addGap(1, 1, 1)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(DateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(14, 14, 14)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtStreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtApt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(orgComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5)
                                            .addComponent(txtCity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel7)
                                            .addComponent(roleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pictureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18))
                            .addComponent(btnUpload))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtBreed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(txtPetName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreatAdopter)
                    .addComponent(btnCreatePetOwner)
                    .addComponent(btnCreateNew))
                .addGap(28, 28, 28))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreatAdopterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreatAdopterActionPerformed
           // TODO add your handling code here:
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        Date date = DateChooser.getDate();
        String number = txtNumber.getText();
        String email = txtEmail.getText();
        
        String city = txtCity.getText();
        String streetline = txtStreet.getText();
        String apt = txtApt.getText();
        String zipcode = txtZipCode.getText();
        
        String userName = txtUserName.getText();
        String password = txtPassword.getText();
        
        Role.RoleType role = (Role.RoleType) roleComboBox.getSelectedItem();
        
        if(!userName.isBlank() && !password.isBlank() && !city.isBlank() &&  
                !streetline.isBlank() && !apt.isBlank() && !zipcode.isBlank()
                && date.toString().isBlank()){
            SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
            String dob = format.format(date);
            
            Employee employee = new Employee();
            String name = firstName + lastName;
            employee.setName(name);
         
            for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList()){
                if (org instanceof AdopterOrganization) {
                    if (!role.equals(Role.RoleType.Adopter)) {
                        JOptionPane.showMessageDialog(null, "Please select the correct role!", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    UserAccount ua = org.getUserAccountDirectory().createUserAccount(userName, password, employee, new AdopterRole());
                    ua.setState(userAccount.getState());
                    adopter.setAdopterAccount(ua);
                    adopter.setFirstName(firstName);
                    adopter.setLastName(lastName);
                    adopter.setDoB(dob);
                    adopter.setNumber(number);
                    adopter.setEmail(email);
                    adopter.setState(ua.getState());
                    adopter.setCity(city);
                    adopter.setStreet(streetline);
                    adopter.setApt(apt);
                    adopter.setZipCode(zipcode);

                    org.getWorkQueue().getWorkRequestList().add(adopter);
                    ua.getWorkQueue().getWorkRequestList().add(adopter);
            }
        }
            JOptionPane.showMessageDialog(null, "Register successfully!");
            txtFirstName.setText("");
            txtLastName.setText("");
            DateChooser.setDate(null);
            txtNumber.setText("");
            txtEmail.setText("");
            txtUserName.setText("");
            txtPassword.setText("");
            
            txtCity.setText("");
            txtStreet.setText("");
            txtApt.setText("");
            txtZipCode.setText("");
            
            popData();
            btnCreatAdopter.setEnabled(false);
        }
        else JOptionPane.showMessageDialog(null, "Invalid input!", "Warning", JOptionPane.WARNING_MESSAGE);
        
    }//GEN-LAST:event_btnCreatAdopterActionPerformed

    private void backjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton1ActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_backjButton1ActionPerformed

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            imagePath = selectedFile.getAbsolutePath();
            Image im = Toolkit.getDefaultToolkit().createImage(imagePath);
            im = im.getScaledInstance(pictureLabel.getWidth(), pictureLabel.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon ii = new ImageIcon(im);
            pictureLabel.setIcon(ii);
            JOptionPane.showMessageDialog(null, "Animal Picture Uploaded Successfully");
        }
    }//GEN-LAST:event_btnUploadActionPerformed

    private void btnCreatePetOwnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreatePetOwnerActionPerformed
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        Date date = DateChooser.getDate();
        
        String number = txtNumber.getText();
        String email = txtEmail.getText();
       
        String city = txtCity.getText();
        String streetline = txtStreet.getText();
        String apt = txtApt.getText();
        String zipcode = txtZipCode.getText();
        
        String userName = txtUserName.getText();
        String password = txtPassword.getText();
        
        String animalType = (String) typeComboBox.getSelectedItem();
        String breed = txtBreed.getText();
        String age = txtAge.getText();
        String petName = txtPetName.getText();
        
        Role.RoleType role = (Role.RoleType) roleComboBox.getSelectedItem();
        
        if(!userName.isBlank() && !password.isBlank() && !city.isBlank() &&  
                !streetline.isBlank() && !apt.isBlank() && !zipcode.isBlank()
                && !animalType.isBlank() && !breed.isBlank() && !age.isBlank() && !petName.isBlank()
                 && date.toString().isBlank() && !imagePath.isBlank()){
            
            SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
            String dob = format.format(date);
        
            Employee employee = new Employee();
            String name = firstName + lastName;
            employee.setName(name);
            
            for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList()){
                if (org instanceof PetOwnerOrganization) {
                    if (!role.equals(Role.RoleType.Adopter)) {
                        JOptionPane.showMessageDialog(null, "Please select the correct role!", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    UserAccount ua = org.getUserAccountDirectory()
                            .createUserAccount(userName, password, employee, new PetOwnerRole());
                    ua.setState(userAccount.getState());
                    petOwner.setPetOwnerAccount(ua);
                    petOwner.setFirstName(firstName);
                    petOwner.setLastName(lastName);
                    petOwner.setDoB(dob);
                    petOwner.setNumber(number);
                    petOwner.setEmail(email);
                    petOwner.setState(ua.getState());
                    petOwner.setCity(city);
                    petOwner.setStreet(streetline);
                    petOwner.setApt(apt);
                    petOwner.setZipCode(zipcode);

                    petOwner.setAnimalType(animalType);
                    petOwner.setBreed(breed);
                    petOwner.setAge(age);
                    petOwner.setPetName(petName);

                    petOwner.setImagePath(imagePath);

                    org.getWorkQueue().getWorkRequestList().add(petOwner);
                    ua.getWorkQueue().getWorkRequestList().add(petOwner);
                }
            }
        
            JOptionPane.showMessageDialog(null, "Register successfully!");
            txtFirstName.setText("");
            txtLastName.setText("");
            DateChooser.setDate(null);
            txtNumber.setText("");
            txtEmail.setText("");
            txtUserName.setText("");
            txtPassword.setText("");
            txtCity.setText("");
            txtStreet.setText("");
            txtApt.setText("");
            txtZipCode.setText("");
            
            txtBreed.setText("");
            txtAge.setText("");
            txtPetName.setText("");
            pictureLabel.setIcon(null);
            
            popData();
            btnCreatePetOwner.setEnabled(false);
        }
        
        else JOptionPane.showMessageDialog(null, "Invalid input!", "Warning", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btnCreatePetOwnerActionPerformed

    private void btnCreateNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateNewActionPerformed
        
        btnCreatAdopter.setEnabled(true);
        btnCreatePetOwner.setEnabled(true);
        btnUpload.setEnabled(true);
        
        orgComboBox.setEnabled(true);
        orgComboBox.setSelectedItem(Organization.Type.PetOwner);
        roleComboBox.setEnabled(true);
        typeComboBox.setEnabled(true);
        
        txtFirstName.setText("");
        txtLastName.setText("");
        DateChooser.setDate(null);
        DateChooser.setEnabled(true);
        txtNumber.setText("");
        txtEmail.setText("");
        txtUserName.setText("");
        txtPassword.setText("");
        txtCity.setText("");
        txtStreet.setText("");
        txtApt.setText("");
        txtZipCode.setText("");

        txtBreed.setText("");
        txtAge.setText("");
        txtPetName.setText("");
        pictureLabel.setIcon(null);
    }//GEN-LAST:event_btnCreateNewActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateChooser;
    private javax.swing.JButton backjButton1;
    private javax.swing.JButton btnCreatAdopter;
    private javax.swing.JButton btnCreateNew;
    private javax.swing.JButton btnCreatePetOwner;
    private javax.swing.JButton btnUpload;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox orgComboBox;
    private javax.swing.JLabel pictureLabel;
    private javax.swing.JComboBox roleComboBox;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtApt;
    private javax.swing.JTextField txtBreed;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtNumber;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPetName;
    private javax.swing.JTextField txtState;
    private javax.swing.JTextField txtStreet;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JTextField txtZipCode;
    private javax.swing.JComboBox<String> typeComboBox;
    private javax.swing.JTable userJTable;
    // End of variables declaration//GEN-END:variables
}
