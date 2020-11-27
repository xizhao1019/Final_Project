/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.WitnessRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author suoxiyue
 */
public class IncidentReportingOrganization extends Organization{
    
    public IncidentReportingOrganization() {
        super(Type.IncidentReporting.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new WitnessRole());
        
        return roles;
    }
    
    @Override
    public Type getType() {
        return Organization.Type.IncidentReporting;
    }
}
