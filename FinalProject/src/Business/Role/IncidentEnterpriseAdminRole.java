/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.IncidentEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.IncidentEnterpriseAdminRole.IncidentEnterpriseAdminWorkAreaJPanel;

/**
 *
 * @author raunak
 */
public class IncidentEnterpriseAdminRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            Network network, 
            EcoSystem business) {
        return new IncidentEnterpriseAdminWorkAreaJPanel(userProcessContainer,account, 
                (IncidentEnterprise) enterprise);
    }

    @Override
    public String toString(){
        return (RoleType.IncidentEnterpriseAdmin.getValue());
    }
    
    
}
