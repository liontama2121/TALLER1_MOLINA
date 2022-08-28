package edu.escuelaing.arep.sparkheroku;

import com.google.gson.Gson;

public class JSClient {
    private static String pageContent;
    private Gson gson;

    private JSClient(){}
    public static String  Principal(){

        return pageContent;
    }
}
