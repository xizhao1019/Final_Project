/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class WorkQueue {
    
    private ArrayList<WorkRequest> workRequestList;

    public WorkQueue() {
        workRequestList = new ArrayList();
    }

    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }
    
    public void deleteRequest(WorkRequest wr) {
        for (int i = 0; i < workRequestList.size(); i++) {
            if(workRequestList.get(i).equals(wr)) {
                workRequestList.remove(i);
            }
        }
    }
}