package stocks;

import java.util.Date;

/**
 * Implements an abstraccion of a trade
 * 
 * @version 1.0
 * @author Manuel Ibañez
 */
public class Trade {
    private Date timestamp;
    private double quantity;
    private String indicator;
    private double price;
    private Stock stock;
    
    /**
     * Constructor for the class Trade, initializes attributes
     * 
     * @param timestamp Timestamp of the operation
     * @param quantity Quatity of shares
     * @param operation "buy" or "sell" indicates the type of operation
     * @param price Price of one stock in dolars
     * @param stock Stock object asociate to the trade
     */
    
    public Trade(Date timestamp, int quantity, String operation, double price, Stock stock){
        this.timestamp = timestamp;
        this.quantity = quantity;
        this.indicator = operation;
        this.price = price;
        this.stock = stock;
    }

    //Getters and Setters
    
    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getIndicator() {
        return indicator;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
    
    
}
