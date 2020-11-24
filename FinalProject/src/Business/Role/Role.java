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
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public abstract class Role {
    
    public enum RoleType{
        SystemAdmin("SystemAdmin"),
        
        IncidentEnterpriseAdmin("Incident Enterprise Admin"),
        RescueEnterpriseAdmin("Rescue Enterprise Admin"),
        AdoptionEnterpriseAdmin("Adoption Enterprise Admin"),
        OperationEnterpriseAdmin("Operation Enterprise Admin"),
        
        Witness("Witness"),
        Volunteer("Volunteer"),
        HospitalAdmin("HospitalAdmin"),
        Vet("Vet"),
        ShelterAdmin("ShelterAdmin"),
        ShelterStaff("ShelterStaff"),
        Adopter("Registered Adopter"),      
        PetOwner("Registered PetOwner"),
        CoordinatorAdmin("CoordinatorAdmin"),
        Coordinator("Coordinator");
        
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise,
            Network network,
            EcoSystem business);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
    
}