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
public abstract class FreeTextQuestion extends TrackQuestion {
    
    private int characterLimit;
    
    public FreeTextQuestion (int id, TrackQuestionType questionType,
            String columnName, String questionText, int characterLimit) {
        super(id, questionType, columnName);
        this.setQuestionText(questionText);
        this.setCharacterLimit(characterLimit);
    }
    
    public void setCharacterLimit(int value){
        this.characterLimit = value;
    }
    
    public int getCharacterLimit(){
        return this.characterLimit;
    }
                 
}
