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
public class ShelterStaffOrganization extends Organization {
    
    public ShelterStaffOrganization() {
        super(Type.ShelterStaff.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new ShelterStaffRole());
        return roles;
    }
    
}
