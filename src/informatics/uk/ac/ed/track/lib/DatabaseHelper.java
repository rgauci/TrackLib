/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informatics.uk.ac.ed.track.lib;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Rachel
 */
public class DatabaseHelper {
 
    public static final String DATABASE_NAME = "informatics.uk.ac.ed.track";
    public static final String TABLE_NAME_SURVEY_RESPONSES = "SurveyResponses";
    
    public static final String COLUMN_NAME_ROW_ID = "RowID";
    public static final String COLUMN_NAME_DAY_NUMBER = "DayNumber";
    public static final String COLUMN_NAME_NOTIFICATION_TIME = "NotificationTime";
    public static final String COLUMN_NAME_PARTICIPANT_ID = "ParticipantID";
    public static final String COLUMN_NAME_SURVEY_COMPLETED_TIME = "SurveyCompletedTime";
    
    public static final int VARCHAR_COLUMN_PADDING = 50;
    
    /**
     * @param questions List of track questions with corresponding Column Names.
     * @param dbUsername Database user to be created, will have all privileges on the Track database (except for GRANT).
     * @param dbPassword Database password for the DB user having dbUsername.
     * @param filePath File where DB creation SQL file is to be saved.
     */
    public static void createDatabaseSqlFile (ArrayList<TrackQuestion> questions, 
            String dbUsername, String dbPassword, String filePath) {        
        StringBuilder sqlSb = new StringBuilder();
        
        sqlSb.append("DROP DATABASE IF EXISTS `" + DATABASE_NAME + "`;\n\n");
        sqlSb.append("CREATE DATABASE `" + DATABASE_NAME + "`;\n\n");
        sqlSb.append("GRANT ALL ON `" + DATABASE_NAME + "`.* TO `").append(dbUsername).append("`@`%` IDENTIFIED BY '" + dbPassword + "';\n\n");     
        sqlSb.append("USE `" + DATABASE_NAME + "`;\n\n");
        sqlSb.append("CREATE TABLE `" + TABLE_NAME_SURVEY_RESPONSES + "` (\n");
        sqlSb.append("\t`" + COLUMN_NAME_ROW_ID + "` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n");
        sqlSb.append("\t`" + COLUMN_NAME_PARTICIPANT_ID + "` INT,\n");
        sqlSb.append("\t`" + COLUMN_NAME_DAY_NUMBER + "` INT,\n");
        sqlSb.append("\t`" + COLUMN_NAME_NOTIFICATION_TIME + "` DATETIME,\n");
        sqlSb.append("\t`" + COLUMN_NAME_SURVEY_COMPLETED_TIME + "` DATETIME,\n");
        
        for (int i = 0; i < questions.size(); i++) {
            
            TrackQuestion question  = questions.get(i);
            String columnType;
            
            switch (question.getQuestionType()) {
                case LIKERT_SCALE:
                    columnType = "INT";
                    break;
                case FREE_TEXT_SINGLE_LINE:
                case FREE_TEXT_MULTI_LINE:
                    columnType = String.format("VARCHAR(%1$d)", 
                            ((FreeTextQuestion)question).getCharacterLimit() 
                                    + VARCHAR_COLUMN_PADDING);
                    break;
                default:
                    columnType = "TEXT";
            }
                
            sqlSb.append("\t`").append(question.getColumnName()).append("` ").append(columnType);
            
            if (i < (questions.size() - 1)) {
                sqlSb.append(",\n");
            } else {
                sqlSb.append("\n");
            }
        }
        
        sqlSb.append(");\n");
        
        // save to file
        try {
            PrintWriter pw = new PrintWriter(filePath);
            pw.write(sqlSb.toString());
            pw.close();
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }
}
