/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informatics.uk.ac.ed.track.lib;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Rachel
 */
public class TrackQuestion {
    
    private int id;
    private TrackQuestionType questionType;
    private String title;
    private String subTitle;
    private String questionPrefix;
    private String questionText;
    
    /**
     * This is set to (this.id + 1) by default.
     * Must be set to -1 for final question(s).
     */
    private int nextQuestionId;
    
    /**
     * Whether an answer is required on not. True by default.
     */
    private boolean isRequired;
    
    /**
     * Column name to be used for exported data.
     */
    private String columnName;
    
    private final static String columnNamePattern = "^[a-zA-Z0-9_]+$"; // alphanumeric & underscores
    
    public TrackQuestion(int id, TrackQuestionType questionType, String columnName) {
        this.setIsRequired(true);
        this.id = id;
        this.setColumnName(columnName);
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

    public int getId() {
        return this.id;
    }
    
    public TrackQuestionType getQuestionType() {
        return this.questionType;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public String getQuestionText() {
        return this.questionText;
    }
    
    public String getQuestionPrefix() {
        return this.questionPrefix;
    }
    
    public void setQuestionPrefix(String value) {
        this.questionPrefix = value;
    }
   
    public void setQuestionText(String value) {
        this.questionText = value;
    }
    
    public boolean getIsRequired() {
        return this.isRequired;
    }
    
    public void setIsRequired(boolean value) {
        this.isRequired = value;
    }
    
    public void setTitle(String value) {
        this.title = value;
    }
 
    public void setSubTitle(String value) {
        this.subTitle = value;
    }
    
    public String getSubTitle() {
        return this.subTitle;
    }
    
    public int getNextQuestionId() {
        return this.nextQuestionId;
    }
   
    public void setNextQuestionId(int value) {
        this.nextQuestionId = value;
    }
    
    public void setColumnName(String value) {
        Pattern pattern = Pattern.compile(columnNamePattern);
        Matcher matcher = pattern.matcher(value);
        if (matcher.matches()) {
            this.columnName = value;
        } else {
            throw new IllegalArgumentException(
                    "Invalid colum name: "
                            + "Only alphanumeric characters "
                            + "and underscores allowed.");
        }
    }
    
    public String getColumnName() {
        return this.columnName;
    }
}
