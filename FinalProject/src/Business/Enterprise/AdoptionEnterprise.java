/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author suoxiyue
 */
public class AdoptionEnterprise extends Enterprise {
    
    public AdoptionEnterprise(String name){
        super(name,Enterprise.EnterpriseType.Adoption);
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
