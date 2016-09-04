package stocks;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * Contains the list of stocks and values and provides the functions required
 * in the assesment
 * 
 * @version 1.0
 * @author Manuel Ibañez
 */
public class Market {
    private static Market market;
    private ArrayList<Stock> portfolio;
    private ArrayList<Trade> tradeRecord;
    
    /**
     * Constructor for the class Market, initializes attributes
     */
    private Market(){
        portfolio = new ArrayList();
        tradeRecord = new ArrayList();
    }
    
    /**
     * Prodivides an unique point to access or create the instance of the class,
     * ensures a single instance.
     * 
     * @return A single instance of the class 
     */
    
    public static Market getMarket(){
        if(market==null){
            market = new Market();
        }
        return market;
    }

    /**
     * Record a new common stock
     * 
     * @param stockSymbol Symbol used for identify the stock it must be unique
     * @param lastDividend Value of last dividend in dolars
     * @param parValue Value of par value in dolars
     * @param tickerPrice Value of par value in dolars if 0 it is generated 
     * a one new random based on par value
     * 
     * @return true value if success or false if the value have not been added 
     */
    
    public boolean addStock(String stockSymbol, double lastDividend, double parValue, double tickerPrice){
        return this.addStock(stockSymbol,lastDividend, 0 ,parValue,tickerPrice);

    }
    
    /**
     * Record a new common or preferred stock depending on the fixed dividend
     * value
     * 
     * @param stockSymbol Symbol used for identify the stock it must be unique
     * @param lastDividend Value of last dividend in dolars
     * @param fixedDividend Value of par value in dolars if it is 0 the stock 
     * will be common and other values will be preferred
     * @param parValue Value of par value in dolars
     * @param tickerPrice Value of ticker price in dolars if 0 it is generated 
     * a one new random based on par value
     * 
     * @return true value if success or false if the value have not been added 
     */
    
    public boolean addStock(String stockSymbol, double lastDividend, double fixedDividend, double parValue, double tickerPrice){
        if(parValue == 0)
            return false;
        
        for(Stock st : portfolio){ // Check if the symbol is unique
            if(st.getSymbol().equals(stockSymbol)){
                return false;
            }
        }
                
        if(tickerPrice == 0){// If 0 generate a new one based on par value
            tickerPrice = parValue * (new Random()).nextDouble() * 2;
        }
        
        Stock s = StockFactory.createStock(stockSymbol, lastDividend, fixedDividend, parValue, tickerPrice);
        if(s == null)
            return false;

        portfolio.add(s);
        return true;
    }
 
    /**
     * Return the value of dividend yield
     * 
     * @param symbol Symbol used for identify the stock
     * 
     * @return dividend yield value, 0 if not found
     */
    
    public double getDividendYield(String symbol){
        for(Stock s : portfolio){
            if(s.getSymbol().equals(symbol)){
                return s.getDividendYield();
            }
        }
        return 0;
    }
    
    /**
     * Return the value of P/E Ratio
     * 
     * @param symbol Symbol used for identify the stock
     * 
     * @return P/E Ratio value, 0 if not found
     */  
    
    public double getPeRatio(String symbol){
        for(Stock s : portfolio){
            if(s.getSymbol().equals(symbol)){
                return s.getPeRatio();
            }
        }
        return 0;
    }
    
    /**
     * Record a new buy trade with the current timestamp
     * 
     * @param stockSymbol Symbol used for identify the stock
     * @param quantity Quatity of shares
     * @param price Buying price of one stock in dolars
     * 
     * @return true value if success or false if the trade have not been done 
     */
    
    public boolean recordBuy(String stockSymbol, int quantity, double price){
        return recordTrade(stockSymbol, null,quantity,"buy",price);
    }

    /**
     * Record a new sale trade with the current timestamp
     * 
     * @param stockSymbol Symbol used for identify the stock
     * @param quantity Quatity of shares
     * @param price Sale price of one stock in dolars
     * 
     * @return true value if success or false if the trade have not been done 
     */
    
    public boolean recordSale(String stockSymbol, int quantity, double price){
        return recordTrade(stockSymbol, null,quantity,"buy",price);
    }

    /**
     * Record a new trade
     * 
     * @param stockSymbol Symbol used for identify the stock
     * @param timestamp Timestamp of the operation if null use the current
     * tiemestamp
     * @param quantity Quatity of shares
     * @param operation "buy" or "sell" indicates the type of operation
     * @param price Price of one stock in dolars
     * 
     * @return true value if success or false if the trade have not been done 
     */
    
    public boolean recordTrade(String stockSymbol,Date timestamp, int quantity, String operation, double price){
        Stock stock = null;
        //Check correct params
        if(timestamp == null)
            timestamp = new Date();
        if(quantity < 1)
            return false;
        if(!operation.equals("buy") && !operation.equals("sell"))
            return false;
        if(price <= 0)
            return false;
        for(Stock s : portfolio){
            if(s.getSymbol().equals(stockSymbol)){
                stock = s;
                break;
            }
        }
        if(stock == null)
            return false;
        
        //Record the trade
        tradeRecord.add(new Trade(timestamp, quantity, operation, price, stock));
        
        return true;
    }

    /**
     * Calculate the stock price of a stock based on trades of last 15 min
     * @param stockSymbol Symbol used for identify the stock
     * 
     * @return Returns the stock price value 
     */
    
    public double getStockPrice(String stockSymbol){
        Date thresholdTimestamp = new Date(System.currentTimeMillis()-15*60*1000);
        double amount = 0;
        int shares= 0;
        for(Trade t : tradeRecord){
            if(t.getStock().getSymbol().equals(stockSymbol) && t.getTimestamp().after(thresholdTimestamp)){
                amount += t.getPrice()*t.getQuantity();
                shares += t.getQuantity();
            }
        }
        return amount/shares;
    }
    
    /**
     * Calculate the geometric mean of all stocks in the market based on ticker
     * price
     * 
     * @return Returns the stocks geometric mean of ticker prices values 
     */
    
    public double getGbceMean(){
        double amount = 0;
        for(Stock s : portfolio){
            amount += s.getTickerPrice();
        }
        return Math.pow(amount, 1.0/portfolio.size());
    }
}
