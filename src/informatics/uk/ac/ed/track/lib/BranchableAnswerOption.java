/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informatics.uk.ac.ed.track.lib;

/**
 *
 * @author Rachel
 */
public class BranchableAnswerOption extends AnswerOption {
    
    /* Question to proceed to if this option is chosen */
    private int nextQuestionId;
    
    public BranchableAnswerOption(int optionId, String option) {
        super(optionId, option);
    }
    
    public BranchableAnswerOption(int optionId, String option, 
            int nextQuestionId) {
        super(optionId, option);
        this.nextQuestionId = nextQuestionId;
    }
    
}
