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
public class MultipleChoiceMultipleAnswer extends MultipleChoiceQuestion {
    
    private ArrayList<AnswerOption> answerOptions;
    
    public MultipleChoiceMultipleAnswer(int id, 
            ArrayList<AnswerOption> answerOptions,
            boolean addOther) {
        super(id, MultipleChoiceQuestionType.MULTIPLE_ANSWER, addOther);
        this.setAnswerOptions(answerOptions);
    }
    
    public void setAnswerOptions(ArrayList<AnswerOption> values) {
        this.answerOptions = values;
    }

    public ArrayList<AnswerOption> getAnswerOptions() {
        return this.answerOptions;
    }
    
}
