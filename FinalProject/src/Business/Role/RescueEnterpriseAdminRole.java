/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import userinterface.RescueEnterpriseAdminRole.RescueEnterpriseAdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class RescueEnterpriseAdminRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            Network network, 
            EcoSystem business) {
        return new RescueEnterpriseAdminWorkAreaJPanel(userProcessContainer, enterprise);
    }

    @Override
    public String toString(){
        return (RoleType.RescueEnterpriseAdmin.getValue());
    }
    
}
