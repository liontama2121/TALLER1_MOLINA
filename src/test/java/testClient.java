import edu.escuelaing.arep.sparkheroku.CurrentServiceInstance;
import edu.escuelaing.arep.sparkheroku.HTTPheroku;
import edu.escuelaing.arep.sparkheroku.HTTPservice;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.io.IOException;

public class testClient {
    /**
     * prueba de igualdad entre el contenido de lo que obtiene nuestro servicio Heroku en la consulta a Alpha
     * ventage API y la consulta directa a Alpha ventage API, ambos siendo consultados a IBM como es por
     * defecto en nuestro caso.
     * @throws IOException Controla excepciones generadas por mala conexión
     * @throws JSONException Controla excepciones generadas por tipos JSON
     */
    @Test
    public void PruebaIgualHerokuAlphaIBMVSAlphaIBM() throws IOException, JSONException {
        String ExpectedJSON="",site="https://sparkheroku.herokuapp.com/facadealpha?st=IBM", HerokuJSON="";
        HTTPservice stockService = CurrentServiceInstance.getInstance().getAlphahttpservice();
        ExpectedJSON = stockService.TimeSeriesDaily();
        HerokuJSON = HTTPheroku.HerokuJSON(site);
        JSONAssert.assertEquals(ExpectedJSON,HerokuJSON.toString(),true);
    }
    /**
     * prueba de desigualdad entre el contenido de lo que obtiene nuestro servicio Heroku en la consulta a Alpha
     * ventage API hacia Microsoft y la consulta directa a Alpha ventage API hacia Facebook.
     * @throws IOException Controla excepciones generadas por mala conexión
     * @throws JSONException Controla excepciones generadas por tipos JSON
     */
    @Test
    public void PruebaDiferenteHerokuAlphafbVSAlphaMSTF() throws IOException, JSONException{
        String ExpectedJSON="",site="https://sparkheroku.herokuapp.com/facadealpha?st=MSTF", HerokuJSON="";
        HTTPservice stockService = CurrentServiceInstance.getInstance().getAlphahttpservice();
        ExpectedJSON = stockService.TimeSeriesDaily();
        HerokuJSON = HTTPheroku.HerokuJSON(site);
        JSONAssert.assertNotEquals(ExpectedJSON,HerokuJSON.toString(),true);
    }
    /**
     * prueba de igualdad entre el contenido de lo que obtiene nuestro servicio Heroku en la consulta a Alpha
     * ventage API hacia Google y la consulta directa a Alpha ventage API hacia Google también.
     * @throws IOException Controla excepciones generadas por mala conexión
     * @throws JSONException Controla excepciones generadas por tipos JSON
     */
    @Test
    public void PruebaIgualHerokuAlphaGOOGVSAlphaGOOG() throws IOException, JSONException{
        String ExpectedJSON="",site="https://sparkheroku.herokuapp.com/facadealpha?st=GOOG", HerokuJSON="";
        HTTPservice stockService = CurrentServiceInstance.getInstance().getAlphahttpservice();
        stockService.setStock("GOOG");
        ExpectedJSON = stockService.TimeSeriesDaily();
        HerokuJSON = HTTPheroku.HerokuJSON(site);
        JSONAssert.assertEquals(ExpectedJSON,HerokuJSON.toString(),true);
    }
    /**
     * pprueba de igualdad entre el contenido de lo que obtiene nuestro servicio Heroku en la consulta a Iex Cloud
     * API y la consulta directa a Iex Cloud API ambas con stock como aapl.
     * @throws IOException Controla excepciones generadas por mala conexión
     * @throws JSONException Controla excepciones generadas por tipos JSON
     */
    @Test
    public void PruebaIgualHerokuIEXvsIEX() throws IOException, JSONException{
        String ExpectedJSON="",site="https://cloud.iexapis.com/stable/stock/aapl/quote?token=pk_8a6cc2e8c79a4d01a8e938fb171f1d9c", HerokuJSON="";
        HTTPservice stockService = CurrentServiceInstance.getInstance().getIexhttpservice();
        ExpectedJSON = stockService.TimeSeriesDaily();
        HerokuJSON = HTTPheroku.HerokuJSON(site);
        JSONAssert.assertEquals(ExpectedJSON,HerokuJSON.toString(),true);
    }


}
