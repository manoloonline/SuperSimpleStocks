package stocks;

/**
 * Subclass of stocks, implements a functional class for a Preferred Stock
 * 
 * @version 1.0
 * @author Manuel Ibañez
 */

public class PreferredStock extends Stock{

    private double fixedDividend;
    
    /**
     * Constructor for the class CommonStock, initializes attributes
     * 
     * @param stockSymbol Symbol used for identify the stock it must be unique
     * @param lastDividend Value of last dividend in dolars
     * @param parValue Value of par value in dolars
     * @param fixedDividend Value of fixed dividend in dolars
     * @param tickerPrice Value of ticker price in dolars
     * 
     */
    
    PreferredStock(String stockSymbol, double lastDividend, double fixedDividend, double parValue, double tickerPrice){
        this.symbol = stockSymbol;
        this.parValue = parValue;
        this.lastDividend = lastDividend;
        this.fixedDividend = fixedDividend;
        this.tickerPrice = tickerPrice;
    }
    
   /**
    * Implement the value of dividend yield
    * 
    * @return The dividend yield value
    */
    
    @Override
    public double getDividendYield() {
        return (fixedDividend*parValue / 100)/tickerPrice;
    }
    
   /**
    * Implement the value of P/E Ratio
    * 
    * @return The P/E Ratio value
    */
    
    @Override
    public double getPeRatio() {
        return tickerPrice/(fixedDividend*parValue / 100);
    }

    
    //Getters and Setters
    
    public double getFixedDividend() {
        return fixedDividend;
    }

    public void setFixedDividend(double fixedDividend) {
        this.fixedDividend = fixedDividend;
    }
    
    
}
