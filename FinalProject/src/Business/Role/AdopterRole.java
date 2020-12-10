/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.AdopterRole.AdopterWorkAreaJPanel;
import userinterface.ShelterAdminRole.ProcessAdopterRequestJPanel;

/**
 *
 * @author suoxiyue
 */
public class AdopterRole extends Role {
    
    @Override
    public JPanel createWorkArea(
            JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            Network network,
            EcoSystem business) {
        return new AdopterWorkAreaJPanel(userProcessContainer,account);
    }
    
//    public JPanel processAdoptionRequestWorkArea(
//            JPanel userProcessContainer, 
//            UserAccount account, 
//            Organization organization, 
//            Enterprise enterprise, 
//            Network network,
//            EcoSystem business) {
//        return new ProcessAdopterRequestJPanel(userProcessContainer);
//    }
    
    @Override
    public String toString(){
        return (RoleType.Adopter.getValue());
    }
}
