package edu.escuelaing.arep.sparkheroku;

import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import static spark.Spark.*;

import spark.Request;
import spark.Response;

public class App {
    public static void main(String[] args) {
        port(getPort());;
        get("/facadealpha", "application/json", (req, res) -> facadeAlpha(req,res));
        get("/facadeiex", "application/json", (req, res) -> facadeIex(req,res));
        get("/JSClient", (req, res) -> facadeJSClient(req,res));

    }
    private static String  facadeJSClient(Request req, Response res){
        String api = req.queryParams("api");
        String stock = req.queryParams("st");
        String pageContent="";
        if(api==null){
            api="";
        }
        if(stock==null || stock==""){
            pageContent=JSClient.Principal();
        }
        try{
            if(api.equalsIgnoreCase("facadeiex")){
                pageContent=facadeIex(req,res);
            }
            else if(api.equalsIgnoreCase("facadealpha")){
                pageContent=facadeAlpha(req,res);
            }
        }catch (NullPointerException ex){
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pageContent;
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;

    }

    public static String facadeAlpha(Request req, Response res){
        String stock = req.queryParams("st");
        String response = "None";
        HTTPservice stockService = CurrentServiceInstance.getInstance().getAlphahttpservice();
        if(stock!=null && stock!=""){
            stockService.setStock(stock);
        }
        try {
            response= stockService.TimeSeriesDaily();
        }catch (IOException ex){
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }

    public static String facadeIex(Request req, Response res) {
        String stock = req.queryParams("st");
        String response = "None";
        HTTPservice stockService = CurrentServiceInstance.getInstance().getIexhttpservice();
        if (stock != null && stock != "") {
            stockService.setStock(stock);
        }
        try {
            response = stockService.TimeSeriesDaily();
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }
}
