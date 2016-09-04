# SuperSimpleStocks
Super Simple Stocks Example

#Requirements

Provide working source code that will :-

  * For a given stock,
  
    * calculate the dividend yield

    * calculate the P/E Ratio

    * record a trade, with timestamp, quantity of shares, buy or sell indicator and price

    * Calculate Stock Price based on trades recorded in past 15 minutes

  * Calculate the GBCE All Share Index using the geometric mean of prices for all stocks

# Design
![Technical Design](http://mcflurro.myds.me/puertaycajon/images/SimpleStocksDesing.jpg "Technical Design")
In the figure above it can be seen that the project was implemented development patterns as Singleton and
a Factory simplified pattern. Also it has been applied the concept of polimorphism in Stocks classes. Another
alternative could be introduce the Spring core framework to sustitute those patterns by dependency inyection
and inversion of control in a easy way, but in my opinion, the simplicity of the exercise does not justify the use of an extra
framework. 

# Configuration

Prerequisites: 
* Git
* JDK 1.8 

# Execution

Clone git repository:
```sh
git clone https://github.com/manoloonline/SuperSimpleStocks.git
```

And later:

* Import the project in NetBeans and run


      OR
 

* Execute it using with classic command line:


# Test

Some unitary tests have been implemented specially for the most complex class Market

# Author

Manuel Ibáñez Martin
