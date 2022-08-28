package edu.escuelaing.arep.sparkheroku;

public class  Iexhttpservice extends HTTPservice {
    String stock = "aapl";

    @Override
    public String getURL() {
        return "https://cloud.iexapis.com/stable/stock/"+stock+"/quote?token=pk_2e7e62c52e724e1b83c7782bc27da301";
    }

    @Override
    public void setStock(String stock) {
        this.stock = stock;

    }

    @Override
    public String getStock() {
        return stock;
    }
}
