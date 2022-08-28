package edu.escuelaing.arep.sparkheroku;

public class CurrentServiceInstance {
    static CurrentServiceInstance _instance = new CurrentServiceInstance();
    Alphahttpservice alphahttpservice;
    Iexhttpservice iexhttpservice;



    private  CurrentServiceInstance (){
        alphahttpservice = new Alphahttpservice();
        iexhttpservice = new Iexhttpservice();
    }
    public static CurrentServiceInstance getInstance(){
        return  _instance;
    }
    public Alphahttpservice getAlphahttpservice() {
        return alphahttpservice;
    }

    public Iexhttpservice getIexhttpservice() {
        return iexhttpservice;
    }

}
