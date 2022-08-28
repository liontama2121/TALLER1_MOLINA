package edu.escuelaing.arep.sparkheroku;

public class Alphahttpservice extends HTTPservice{
    String stock = "IBM";
    @Override
    public String getURL() {
        return "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol="+stock+"&apikey=8K9LKQJIZ42L064Y";
    }

    @Override
    public void setStock(String stock) {
        this.stock=stock;


    }

    @Override
    public String getStock() {
        return stock;
    }
}
