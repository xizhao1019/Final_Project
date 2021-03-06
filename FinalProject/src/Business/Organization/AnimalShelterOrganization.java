/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.ShelterStaffRole;
import java.util.ArrayList;

/**
 *
 * @author suoxiyue
 */
public class AnimalShelterOrganization extends Organization {
    
    public AnimalShelterOrganization() {
        super(Type.AnimalShelter.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new ShelterStaffRole());
        return roles;
    }
    
    @Override
    public Type getType() {
        return Organization.Type.AnimalShelter;
    }
    
    
}
