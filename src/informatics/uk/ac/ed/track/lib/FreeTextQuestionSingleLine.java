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
public class FreeTextQuestionSingleLine extends FreeTextQuestion {
    
    public final static int DEFAULT_CHARACTER_LIMIT = 50;
    
    public FreeTextQuestionSingleLine(int id, String columnName,
            String questionText) {
        super(id, TrackQuestionType.FREE_TEXT_SINGLE_LINE, columnName,
                questionText, DEFAULT_CHARACTER_LIMIT);
    }
    
}
