package stocks;

/**
 * Abstract superclass for stocks, set a common interface and implements some
 * common attributes
 * 
 * @version 1.0
 * @author Manuel Ibañez
 */

public abstract class Stock {
    protected String symbol;
    protected double parValue;
    protected double lastDividend;
    protected double tickerPrice;
    
   /**
    * Calculate the value of dividend yield
    * 
    * @return The dividend yield value
    */
    
    public abstract double getDividendYield();

   /**
    * Calculate the value of P/E Ratio
    * 
    * @return The P/E Ratio value
    */
    
    public abstract double getPeRatio();
    
    //Getters and Setters

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getParValue() {
        return parValue;
    }

    public void setParValue(double parValue) {
        this.parValue = parValue;
    }

    public double getLastDividend() {
        return lastDividend;
    }

    public void setLastDividend(double lastDividend) {
        this.lastDividend = lastDividend;
    }

    public double getTickerPrice() {
        return tickerPrice;
    }

    public void setTickerPrice(double tickerPrice) {
        this.tickerPrice = tickerPrice;
    }

}
