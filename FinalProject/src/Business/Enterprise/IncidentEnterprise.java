/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import Business.Role.WitnessRole;
import java.util.ArrayList;

/**
 *
 * @author suoxiyue
 */
public class IncidentEnterprise extends Enterprise {
    
    public IncidentEnterprise(String name){
        super(name,Enterprise.EnterpriseType.Incident);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        roles = new ArrayList<Role>();
        roles.add(new WitnessRole());
        return roles;
    }
    
}
