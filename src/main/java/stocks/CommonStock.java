package stocks;

/**
 * Subclass of stocks, implements a functional class for a Common Stock
 * 
 * @version 1.0
 * @author Manuel Ibañez
 */

public class CommonStock extends Stock{

    /**
     * Constructor for the class CommonStock, initializes attributes
     * 
     * @param stockSymbol Symbol used for identify the stock it must be unique
     * @param lastDividend Value of last dividend in dolars
     * @param parValue Value of par value in dolars
     * @param tickerPrice Value of ticker price in dolars
     * 
     */
    
    CommonStock(String stockSymbol, double lastDividend, double parValue, double tickerPrice){
        this.symbol = stockSymbol;
        this.parValue = parValue;
        this.lastDividend = lastDividend;
        this.tickerPrice = tickerPrice;
    }
    
   /**
    * Implement the value of dividend yield
    * 
    * @return The dividend yield value
    */
    
    @Override
    public double getDividendYield() {
        return lastDividend/tickerPrice;
    }
    
   /**
    * Implement the value of P/E Ratio
    * 
    * @return The P/E Ratio value
    */
    
    @Override
    public double getPeRatio() {
        return tickerPrice/lastDividend;
    }
    
}
