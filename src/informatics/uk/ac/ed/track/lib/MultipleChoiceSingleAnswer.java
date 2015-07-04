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
public class MultipleChoiceSingleAnswer 
        extends MultipleChoiceQuestion implements Branchable {

    private boolean isBranchable;
    private ArrayList<BranchableAnswerOption> answerOptions;
    
    public MultipleChoiceSingleAnswer(int id, 
            boolean isBranchable, 
            ArrayList<BranchableAnswerOption> answerOptions,
            boolean addOther) {
        super(id, MultipleChoiceQuestionType.SINGLE_ANSWER, addOther);
        this.setIsBranchable(isBranchable);
        this.setAnswerOptions(answerOptions);
    }

    @Override
    public void setIsBranchable(boolean value) {
        this.isBranchable = value;
    }

    @Override
    public boolean getIsBranchable() {
        return this.isBranchable;
    }

    @Override
    public void setAnswerOptions(ArrayList<BranchableAnswerOption> values) {
        this.answerOptions = values;
    }

    @Override
    public ArrayList<BranchableAnswerOption> getAnswerOptions() {
        return this.answerOptions;
    }
    
}
