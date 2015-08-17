/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informatics.uk.ac.ed.track.lib;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 *
 * @author Rachel
 */
public class SurveyHelper {
    
    /**
     * Converts questions list to JSON format and saves to file.
     * @param questions Questions to be saved to file.
     * @param filePath File where JSON will be saved.
     * @return Questions in JSON format.
     */
    public static String toJson(ArrayList<TrackQuestion> questions, 
            String filePath) {
        // convert to JSON
        Gson gson = getGson();
        String json = gson.toJson(questions, getListType());
                
        // save to file
        try {
            PrintWriter pw = new PrintWriter(filePath);
            pw.write(json);
            pw.close();
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
        
        return json;
    }
    
    public static ArrayList<TrackQuestion> fromJson(String json) {
        // convert from JSON
        Gson gson = getGson();        
        ArrayList<TrackQuestion> fromJson = gson.fromJson(json, getListType());
        
        return fromJson;
    }
    
    private static Gson getGson() {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.registerTypeAdapterFactory(getRuntimeAdapterFactory());
        Gson gson = builder.create();
        return gson;
    }
    
    private static Type getListType() {
        Type listType = new TypeToken<ArrayList<TrackQuestion>>() {}.getType();
        return listType;
    }
    
    /**
     * Creates and returns a RuntimeTypeAdapterFactory which registers all TrackQuestion concrete types.
     * @return A factory for supporting polymorphic types in lists for GSON serialisation.
     */
    private static RuntimeTypeAdapterFactory<TrackQuestion> getRuntimeAdapterFactory() {
        RuntimeTypeAdapterFactory<TrackQuestion> factory = RuntimeTypeAdapterFactory.of(TrackQuestion.class)
         .registerSubtype(FreeTextQuestionSingleLine.class)
         .registerSubtype(FreeTextQuestionMultiLine.class)
         .registerSubtype(MultipleChoiceSingleAnswer.class)
         .registerSubtype(MultipleChoiceMultipleAnswer.class)
         .registerSubtype(LikertScaleQuestion.class);
        
        return factory;
    }
    
}