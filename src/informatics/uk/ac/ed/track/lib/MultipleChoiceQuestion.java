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
public abstract class MultipleChoiceQuestion extends TrackQuestion {
    
    private boolean addOther;
    
    public MultipleChoiceQuestion(
            int id, 
            TrackQuestionType questionType,
            String columnName,
            boolean addOther) {
        super(id, questionType, columnName);
        this.setAddOther(addOther);
    }
    
    public boolean getAddOther() {
        return this.addOther;
    }
    
    public void setAddOther(boolean value) {
        this.addOther = value;
    }
    
}
