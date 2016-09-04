package stocks;

import java.util.Date;

/**
 * Main class to execute the program, there is a basic example to show how to
 * work with the implemented functions. 
 *
 * @version 1.0
 * @author Manuel Ibañez
 */
public class Main {
    
    /**
     * Static main class to execute the program
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        Market market = Market.getMarket();
        
        //Load example stocks of the table
        market.addStock("TEA", 0, 0, 1, 1);
        market.addStock("POP", 0.08, 0, 1, 1);
        market.addStock("ALE", 0.23, 0, 0.60, 0.60);
        market.addStock("GIN", 0.08, 0.02, 1, 1);
        market.addStock("JOE", 0.13, 0, 2.50, 2.50);
        
        //Load some example trades with current date as timestamp
        market.recordBuy("TEA",200, 1.16);
        market.recordSale("TEA",500, 1.25);
        market.recordBuy("POP",350, 1.03);
        market.recordSale("POP",1100, 1.01);
        market.recordBuy("ALE",200, 0.75);
        market.recordSale("ALE",500, 0.78);
        market.recordBuy("GIN",350, 0.90);
        market.recordSale("GIN",1100, 0.95);
        market.recordBuy("JOE",350, 2.56);
        market.recordSale("JOE",1100, 2.46);
        
        //Trade 16min before
        market.recordTrade("TEA", new Date(System.currentTimeMillis()-16*60*1000), 1100, "sell", 1.51);

        //Trade 14min before
        market.recordTrade("TEA", new Date(System.currentTimeMillis()-14*60*1000), 1100, "sell", 1.11);
        
        //Execute examples of required functions and the result
        System.out.print("TEA: ");
        System.out.print(market.getDividendYield("TEA") + "  ");
        System.out.print(market.getPeRatio("TEA") + "  ");
        System.out.println(market.getStockPrice("TEA"));
        System.out.println();
        System.out.print("ALE: ");
        System.out.print(market.getDividendYield("ALE") + "  ");
        System.out.print(market.getPeRatio("ALE") + "  ");
        System.out.println(market.getStockPrice("ALE"));
        System.out.println();
        System.out.println("GBCE Mean: " + market.getGbceMean());
        
    }
}
