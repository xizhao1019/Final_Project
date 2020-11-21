/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.DogVetRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author suoxiyue
 */
public class DogVetOrganization extends Organization{
    
    public DogVetOrganization() {
        super(Type.DogVet.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new DogVetRole());
        return roles;
    }
    
}
