/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import Business.EcoSystem;
import Business.DB4OUtil.DB4OUtil;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
//import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import userinterface.AdopterRole.AdopterRegistrationJPanel;
import userinterface.PetOwnerRole.PetOwnerRegistrationJPanel;
import userinterface.WitnessRole.WitnessRegisterJPanel;

/**
 *
 * @author Lingfeng
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    private EcoSystem system;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    UserAccount userAccount;
    Enterprise inEnterprise;
    Organization inOrganization;
    Network network;
    
    public MainJFrame() {
        initComponents();
        system = dB4OUtil.retrieveSystem();
        this.setSize(1300, 780);
        this.setLocation(100, 40);
        
        //ImageIcon icon = new ImageIcon("2.png");
        //container.setIcon(icon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        logoutJButton = new javax.swing.JButton();
        container = new javax.swing.JPanel();
        loginjPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        userNameJTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        btnWitnessRegister = new javax.swing.JButton();
        btnAdopterRegister = new javax.swing.JButton();
        loginJButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnOwnerRegister = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane1.setDividerLocation(50);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        logoutJButton.setText("Logout");
        logoutJButton.setEnabled(false);
        logoutJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(579, Short.MAX_VALUE)
                .addComponent(logoutJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoutJButton)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        container.setLayout(new java.awt.CardLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("User Name");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Password");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Want to adopt a pet?");

        btnWitnessRegister.setText("Witness Registeration");
        btnWitnessRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWitnessRegisterActionPerformed(evt);
            }
        });

        btnAdopterRegister.setText("Adopter Registration");
        btnAdopterRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdopterRegisterActionPerformed(evt);
            }
        });

        loginJButton.setText("Login");
        loginJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginJButtonActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Try to find your missing pet?");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Found a stray animal?");

        btnOwnerRegister.setText("Pet Owner Registeration");
        btnOwnerRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOwnerRegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginjPanelLayout = new javax.swing.GroupLayout(loginjPanel);
        loginjPanel.setLayout(loginjPanelLayout);
        loginjPanelLayout.setHorizontalGroup(
            loginjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginjPanelLayout.createSequentialGroup()
                .addGroup(loginjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginjPanelLayout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addGroup(loginjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(loginjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(loginJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userNameJTextField)))
                    .addGroup(loginjPanelLayout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(loginjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(loginjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdopterRegister)
                            .addComponent(btnOwnerRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnWitnessRegister))))
                .addContainerGap())
        );
        loginjPanelLayout.setVerticalGroup(
            loginjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginjPanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(loginjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(loginjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(loginJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(loginjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnWitnessRegister)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(loginjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btnAdopterRegister))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(loginjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(btnOwnerRegister))
                .addContainerGap())
        );

        container.add(loginjPanel, "card2");

        jSplitPane1.setRightComponent(container);
        container.getAccessibleContext().setAccessibleParent(container);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
        

    private void loginJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginJButtonActionPerformed
        // Get user name
        String userName = userNameJTextField.getText();
        // Get Password
        char[] passwordCharArray = passwordField.getPassword();
        String password = String.valueOf(passwordCharArray);
        
        inEnterprise = null;
        inOrganization = null;
        network = null;
        //Step1: Check in the system admin user account directory if you have the user
        userAccount=system.getUserAccountDirectory().authenticateUser(userName, password);
        
        
        if(userAccount==null){
            //Step 2: Go inside each network and check each enterprise
            for(Network network:system.getNetworkList()){
                //Step 2.a: check against each enterprise
                for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList()){
                    userAccount=enterprise.getUserAccountDirectory().authenticateUser(userName, password);
                    if(userAccount==null){
                       //Step 3:check against each organization for each enterprise
                       for(Organization organization:enterprise.getOrganizationDirectory().getOrganizationList()){
                           userAccount=organization.getUserAccountDirectory().authenticateUser(userName, password);
                           if(userAccount!=null){
                               inEnterprise=enterprise;
                               inOrganization=organization;
                               break;
                           }
                       }
                        
                    }
                    else{
                       inEnterprise=enterprise;
                       break;
                    }
                    if(inOrganization!=null){
                        break;
                    }  
                }
                if(inEnterprise!=null){
                    break;
                }
            }
        }
        
        if(userAccount==null){
            JOptionPane.showMessageDialog(null, "Invalid credentials");
            return;
        }
        else{
            CardLayout layout=(CardLayout)container.getLayout();
            container.add("workArea",userAccount.getRole().createWorkArea(container, userAccount, inOrganization, inEnterprise, network, system));
            layout.next(container);
        }
        
        loginJButton.setEnabled(false);
        logoutJButton.setEnabled(true);
        userNameJTextField.setEnabled(false);
        passwordField.setEnabled(false);
    }//GEN-LAST:event_loginJButtonActionPerformed

    private void logoutJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutJButtonActionPerformed
        logoutJButton.setEnabled(false);
        userNameJTextField.setEnabled(true);
        passwordField.setEnabled(true);
        loginJButton.setEnabled(true);

        userNameJTextField.setText("");
        passwordField.setText("");

        container.removeAll();
        container.add("login", loginjPanel);
        CardLayout crdLyt = (CardLayout) container.getLayout();
        crdLyt.next(container);
        dB4OUtil.storeSystem(system);
    }//GEN-LAST:event_logoutJButtonActionPerformed

    private void btnAdopterRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdopterRegisterActionPerformed
        // TODO add your handling code here:
        AdopterRegistrationJPanel arjp = new AdopterRegistrationJPanel(container, system);
        container.add("AdopterRegistrationJPanel",arjp);
        CardLayout layout = (CardLayout)container.getLayout();
        layout.next(container);
    }//GEN-LAST:event_btnAdopterRegisterActionPerformed

    private void btnOwnerRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOwnerRegisterActionPerformed
        // TODO add your handling code here:
        PetOwnerRegistrationJPanel porjp = new PetOwnerRegistrationJPanel(container, system);
        container.add("PetOwnerRegistrationJPanel",porjp);
        CardLayout layout = (CardLayout)container.getLayout();
        layout.next(container);
    }//GEN-LAST:event_btnOwnerRegisterActionPerformed

    private void btnWitnessRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWitnessRegisterActionPerformed
        // TODO add your handling code here:
        WitnessRegisterJPanel jp = new WitnessRegisterJPanel(container, system);
        container.add("WitnessRegistrationJPanel",jp);
        CardLayout layout = (CardLayout)container.getLayout();
        layout.next(container);
    }//GEN-LAST:event_btnWitnessRegisterActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdopterRegister;
    private javax.swing.JButton btnOwnerRegister;
    private javax.swing.JButton btnWitnessRegister;
    private javax.swing.JPanel container;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton loginJButton;
    private javax.swing.JPanel loginjPanel;
    private javax.swing.JButton logoutJButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField userNameJTextField;
    // End of variables declaration//GEN-END:variables
}
