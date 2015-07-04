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
public abstract class MultipleChoiceQuestion extends EsmQuestion {
    
    private final MultipleChoiceQuestionType multiChoiceQuestionType;
    private boolean addOther;
    
    public MultipleChoiceQuestion(
            int id, 
            MultipleChoiceQuestionType multiChoiceQuestionType,
            boolean addOther) {
        super(id, QuestionType.MULTIPLE_CHOICE);
        this.multiChoiceQuestionType = multiChoiceQuestionType;
        this.setAddOther(addOther);
    }
    
    public boolean getAddOther(boolean value) {
        return this.addOther;
    }
    
    public void setAddOther(boolean value) {
        this.addOther = value;
    }
    
}
