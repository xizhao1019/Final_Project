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
import userinterface.PetOwnerRole.PetOwnerWorkAreaJPanel;
import userinterface.ShelterAdminRole.ProcessPetOwnerRequestJPanel;


/**
 *
 * @author suoxiyue
 */
public class PetOwnerRole extends Role {
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise,
            Network network,
            EcoSystem business) {
        return new PetOwnerWorkAreaJPanel(userProcessContainer,account);
    }
    
    public JPanel processAdoptionRequestWorkArea(
            JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            Network network,
            EcoSystem business) {
        return new ProcessPetOwnerRequestJPanel(userProcessContainer);
    }
    
    @Override
    public String toString(){
        return (RoleType.PetOwner.getValue());
    }
}
