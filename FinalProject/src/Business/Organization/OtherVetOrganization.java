/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.OtherVetRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author suoxiyue
 */
public class OtherVetOrganization extends Organization {
    
    public OtherVetOrganization() {
        super(Organization.Type.OtherVet.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new OtherVetRole());
        return roles;
    }
    
}
