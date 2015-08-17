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
public enum TrackQuestionType {
    FREE_TEXT_SINGLE_LINE,
    FREE_TEXT_MULTI_LINE,
    MULTIPLE_CHOICE_SINGLE_ANSWER,
    MULTIPLE_CHOICE_MULTI_ANSWER,
    LIKERT_SCALE;
    
    public static int toInt(TrackQuestionType type) {
        switch (type) {
            case FREE_TEXT_SINGLE_LINE:
                return 0;
            case FREE_TEXT_MULTI_LINE:
                return 1;
            case MULTIPLE_CHOICE_SINGLE_ANSWER:
                return 2;
            case MULTIPLE_CHOICE_MULTI_ANSWER:
                return 3;
            case LIKERT_SCALE:
                return 4;
            default:
                return -1;
        }
    }
    
    public static TrackQuestionType fromInt(int typeInt) {
        switch (typeInt) {
            case 0:
                return FREE_TEXT_SINGLE_LINE;
            case 1:
                return FREE_TEXT_MULTI_LINE;
            case 2:
                return MULTIPLE_CHOICE_SINGLE_ANSWER;
            case 3:
                return MULTIPLE_CHOICE_MULTI_ANSWER;
            case 4:
                return LIKERT_SCALE;
            default:
                throw new IllegalArgumentException("Invalid integer.");
        }
    }
}
