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
    private final String ANSWER_DELIMITER = ";";
    
    public MultipleChoiceMultipleAnswer(int id, String columnName,
            ArrayList<AnswerOption> answerOptions,
            boolean addOther) {
        super(id, TrackQuestionType.MULTIPLE_CHOICE_MULTI_ANSWER, columnName,
                addOther);
        this.setAnswerOptions(answerOptions);
    }
    
    public void setAnswerOptions(ArrayList<AnswerOption> values) {
        for (AnswerOption option: values) {
            if (option.getOption().contains(ANSWER_DELIMITER)) {
                throw new IllegalArgumentException(
                        "Options cannot contain " + ANSWER_DELIMITER + 
                                " as this will be used to "
                                + "delimit the answers in the database.");
            }
        }
        this.answerOptions = values;
    }

    public ArrayList<AnswerOption> getAnswerOptions() {
        return this.answerOptions;
    }
    
}
