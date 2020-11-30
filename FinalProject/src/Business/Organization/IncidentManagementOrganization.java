/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.CoordinatorAdminRole;
import Business.Role.CoordinatorRole;
import Business.Role.IncidentEnterpriseAdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author suoxiyue
 */
public class IncidentManagementOrganization extends Organization {
    
    public IncidentManagementOrganization() {
        super(Type.IncidentManagement.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new CoordinatorRole());
        roles.add(new CoordinatorAdminRole());
        return roles;
    }
    
     @Override
    public Type getType() {
        return Organization.Type.IncidentManagement;
    }
    
}
