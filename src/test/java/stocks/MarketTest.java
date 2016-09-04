
package stocks;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *Unit Test for Market
 * 
 * @version 1.0
 * @author Manuel Ibañez
 */
public class MarketTest {
    
    public MarketTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getMarket method, of class Market.
     */
    @Test
    public void testGetMarket() {
        System.out.println("getMarket");
        Market result = Market.getMarket();
        assertNotNull(result);
        if(result == null)
            fail("getMarket() not working");
    }

    /**
     * Test of addStock method, of class Market.
     */
    @Test
    public void testAddStock_4args() {
        System.out.println("addStock");
        String stockSymbol = "MIM";
        double lastDividend = 0.1;
        double parValue = 1.0;
        double tickerPrice = 1.0;
        Market instance = Market.getMarket();
        boolean result = instance.addStock(stockSymbol, lastDividend, parValue, tickerPrice);
        assertTrue(result);
        if(!result)
            fail("addStock() not working");
    }

    /**
     * Test of getDividendYield method, of class Market.
     */
    @Test
    public void testGetDividendYield() {
        System.out.println("getDividendYield");
        String symbol = "TEA";
        Market instance = Market.getMarket();
        double expResult = 0.0;
        double result = instance.getDividendYield(symbol);
        assertEquals(expResult, result, 0.0);
        if(expResult != 0.0)
            fail("testGetDividendYield() not working");
    }

    /**
     * Test of getPeRatio method, of class Market.
     */
    @Test
    public void testGetPeRatio() {
        System.out.println("getPeRatio");
        String symbol = "TEA";
        Market instance = Market.getMarket();
        double expResult = Double.POSITIVE_INFINITY;
        double result = instance.getPeRatio(symbol);
        assertEquals(expResult, result, Double.POSITIVE_INFINITY);
        // TODO review the generated test code and remove the default call to fail.
        if(expResult != Double.POSITIVE_INFINITY)
            fail("testGetPeRatio() not working");
    }

    /**
     * Test of recordBuy method, of class Market.
     */
    @Test
    public void testRecordBuy() {
        System.out.println("recordBuy");
        String stockSymbol = "MIM";
        int quantity = 3;
        double price = 2.0;
        Market instance = Market.getMarket();
        boolean result = instance.recordBuy(stockSymbol, quantity, price);
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
        if(!result)
            fail("testRecordBuy() not working");
    }

    /**
     * Test of recordSale method, of class Market.
     */
    @Test
    public void testRecordSale() {
        System.out.println("recordSale");
        String stockSymbol = "MIM";
        int quantity = 3;
        double price = 2.0;
        Market instance = Market.getMarket();
        boolean result = instance.recordSale(stockSymbol, quantity, price);
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
        if(!result)
            fail("testRecordSale() not working");
    }

    /**
     * Test of recordTrade method, of class Market.
     */
    @Test
    public void testRecordTrade() {
        System.out.println("recordTrade");
        String stockSymbol = "MIM";
        Date timestamp = null;
        int quantity = 3;
        String operation = "buy";
        double price = 3.0;
        Market instance = Market.getMarket();
        boolean result = instance.recordTrade(stockSymbol, timestamp, quantity, operation, price);
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
        if(!result)
            fail("testRecordTrade() not working");
    }

    /**
     * Test of getStockPrice method, of class Market.
     */
    @Test
    public void testGetStockPrice() {
        System.out.println("getStockPrice");
        String stockSymbol = "TEA";
        Market instance = Market.getMarket();
        instance.addStock("TEA", 0, 0, 1, 1);
        instance.addStock("POP", 0.08, 0, 1, 1);
        instance.addStock("ALE", 0.23, 0, 0.60, 0.60);
        instance.addStock("GIN", 0.08, 0.02, 1, 1);
        instance.addStock("JOE", 0.13, 0, 2.50, 2.50);
        instance.recordBuy("TEA",200, 1.16);
        instance.recordSale("TEA",500, 1.25);
        instance.recordBuy("POP",350, 1.03);
        instance.recordSale("POP",1100, 1.01);
        instance.recordBuy("ALE",200, 0.75);
        instance.recordSale("ALE",500, 0.78);
        instance.recordBuy("GIN",350, 0.90);
        instance.recordSale("GIN",1100, 0.95);
        instance.recordBuy("JOE",350, 2.56);
        instance.recordSale("JOE",1100, 2.46);
        double expResult = 1.2242857142857142;
        double result = instance.getStockPrice(stockSymbol);
        assertEquals(expResult, result, 0.0);
        if(result != 1.2242857142857142)
            fail("The test case is a prototype.");
    }

    /**
     * Test of getGbceMean method, of class Market.
     */
    @Test
    public void testGetGbceMean() {
        System.out.println("getGbceMean");
        Market instance = Market.getMarket();
        instance.addStock("TEA", 0, 0, 1, 1);
        instance.addStock("POP", 0.08, 0, 1, 1);
        instance.addStock("ALE", 0.23, 0, 0.60, 0.60);
        instance.addStock("GIN", 0.08, 0.02, 1, 1);
        instance.addStock("JOE", 0.13, 0, 2.50, 2.50);
        instance.recordBuy("TEA",200, 1.16);
        instance.recordSale("TEA",500, 1.25);
        instance.recordBuy("POP",350, 1.03);
        instance.recordSale("POP",1100, 1.01);
        instance.recordBuy("ALE",200, 0.75);
        instance.recordSale("ALE",500, 0.78);
        instance.recordBuy("GIN",350, 0.90);
        instance.recordSale("GIN",1100, 0.95);
        instance.recordBuy("JOE",350, 2.56);
        instance.recordSale("JOE",1100, 2.46);
        double expResult = 1.386361187704947;
        double result = instance.getGbceMean();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        if(result != 1.386361187704947)
            fail("The test case is a prototype.");
    }
    
}
