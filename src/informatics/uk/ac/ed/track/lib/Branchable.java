/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informatics.uk.ac.ed.track.lib;

import java.util.ArrayList;

/**
 *
 * @author Rachel
 */
public interface Branchable {
    
    public void setIsBranchable(boolean value);
    public boolean getIsBranchable();
    
    public void setAnswerOptions(ArrayList<BranchableAnswerOption> values);
    public ArrayList<BranchableAnswerOption> getAnswerOptions();
}
