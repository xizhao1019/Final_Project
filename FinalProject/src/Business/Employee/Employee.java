/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import java.util.Random;



/**
 *
 * @author raunak
 */
public class Employee {
    
    private String name;
    private String id;
    private String ID;
    
    private int count = 0;
    private Random random = new Random();

    public Employee() {
        count++;
        ID = "E" + count;
        id = String.format("%04d",random.nextInt(10000));
        ID = "E" + id;
    }

    public String getId() {
        return ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
