/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informatics.uk.ac.ed.track.lib;

/**
 * Single or multi-line free-text question.
 * Question text is required.
 * @author Rachel
 */
public class FreeTextQuestion extends EsmQuestion {
    
    private FreeTextQuestionType freeTextType;
    
    public FreeTextQuestion (int id, FreeTextQuestionType freeTextType,
            String questionText) {
        super(id, QuestionType.FREE_TEXT);
        this.freeTextType = freeTextType;
        this.setQuestionText(questionText);
    }
                 
}
