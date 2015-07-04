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
public class LikertScaleQuestion extends EsmQuestion implements Branchable {
 
    private boolean isBranchable;
    private ArrayList<BranchableAnswerOption> answerOptions;
    
    public LikertScaleQuestion(int id, 
            boolean isBranchable, 
            ArrayList<BranchableAnswerOption> answerOptions) {
        super(id, QuestionType.LIKERT_SCALE);
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
