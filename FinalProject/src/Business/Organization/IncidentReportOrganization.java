/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.RegisteredReporterRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author suoxiyue
 */
public class IncidentReportOrganization extends Organization{
    
    public IncidentReportOrganization() {
        super(Type.IncidentReport.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new RegisteredReporterRole());
        
        return roles;
    }
    
}
