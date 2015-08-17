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
    private int otherOptionNextQuestionId;
    private ArrayList<BranchableAnswerOption> answerOptions;
    
    public MultipleChoiceSingleAnswer(int id, String columnName,
            boolean isBranchable, 
            ArrayList<BranchableAnswerOption> answerOptions,
            boolean addOther) {
        super(id, TrackQuestionType.MULTIPLE_CHOICE_SINGLE_ANSWER, columnName,
                addOther);
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
 
    /**
     * Set next question ID if this question is Branchable and "Other" option
     * is selected.
     * @param value 
     */
    public void setOtherOptionNextQuestionId(int value) {
        this.otherOptionNextQuestionId = value;
    }   
    
    /**
     * Get next question ID if this question is Branchable and "Other" option
     * is selected.
     * @return 
     */
    public int getOtherOptionNextQuestionId() {
        return this.otherOptionNextQuestionId;
    }
}
