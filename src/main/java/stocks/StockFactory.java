package stocks;

/**
 * Implements a simplified factory pattern to deattach the configuration for
 * instanciate a subclass
 * 
 * @version 1.0
 * @author Manuel Ibañez
 */
public class StockFactory {
    /**
     * Record a new common or preferred stock depending on the fixed dividend
     * value
     * 
     * @param stockSymbol Symbol used for identify the stock it must be unique
     * @param lastDividend Value of last dividend in dolars
     * @param fixedDividend Value of fixed dividend in dolars if it is 0 the stock 
     * will be common and other values will be preferred
     * @param parValue Value of par value in dolars
     * @param tickerPrice Value of ticker price in dolars
     * 
     * @return the Stock object 
     */
    public static Stock createStock(String stockSymbol, double lastDividend, double fixedDividend, double parValue, double tickerPrice){
        if(fixedDividend == 0.0){
            return new CommonStock(stockSymbol, lastDividend, parValue, tickerPrice);
        }else{
            return new PreferredStock(stockSymbol, lastDividend, fixedDividend, parValue, tickerPrice);
        }
    }
}
