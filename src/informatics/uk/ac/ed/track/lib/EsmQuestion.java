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
public class EsmQuestion {
    
    private int id;
    private QuestionType questionType;
    private String title;
    private String questionPrefix;
    private String questionText;
    
    /**
     * Set to (this.id + 1) by default.
     */
    private int nextQuestionId;
    
    /**
     * Whether an answer is required on not. True by default.
     */
    private boolean required;
    
    public EsmQuestion() {}
    
    public EsmQuestion(int id, QuestionType questionType) {
        this.setRequired(true);
        this.id = id;
        this.questionType = questionType;
        this.nextQuestionId = this.id + 1;
    }
   
    public void setId(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("ID must be a positive integer.");
        } else {
            this.id = value;
        }
    }
    
    public void setQuestionPrefix(String value) {
        this.questionPrefix = value;
    }
   
    public void setQuestionText(String value) {
        this.questionText = value;
    }
    
    public void setRequired(boolean value) {
        this.required = value;
    }
    
    public void setTitle(String value) {
        this.title = value;
    }
 
    public int getNextQuestionId() {
        return this.nextQuestionId;
    }
   
}
