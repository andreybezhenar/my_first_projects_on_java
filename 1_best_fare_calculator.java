// problem: in this project you will write a Java program that determines 
// the best fare option for someone visiting New York City who plans to use the NYC transit system. 
// the program should use constructors, methods, conditionals, loops, and arrays.

// decision:


import java.util.Arrays;

public class TransitCalculator {
  
  //days and rides: 
  int numberOfDays;
  int numberOfRides; 
  
  //availabale price options:
  double[] fareOptions = new double[]{2.75, 33.0, 127.0}; 

  //constructor:
  public TransitCalculator(int days, int rides) {
    numberOfDays = days; 
    numberOfRides = rides; 
  }
  
  //price per ride for option with unlimited rides for 7 days:
  public double unlimited7Price() {
      
    int numberOfPurchases = numberOfDays / 7; // number of purchases.
    if (numberOfDays%7 != 0) { // if the calculated number of purchases does not cover all days, then we need to buy one more.
      numberOfPurchases++;
  };
  
    double totallPrice = numberOfPurchases * fareOptions[1]; // total price.
    double pricePerRide = totallPrice / numberOfRides; // price per ride for option with unlimited rides for 7 days.
  
  return pricePerRide; 
  }
  
  
  // method to find the best option:
  public void getBestFare(){
    
    // array of prices per ride for all options:
    double[] arrayPrices = new double[]{fareOptions[0], unlimited7Price(), (fareOptions[2] / numberOfRides)};
    
    Arrays.sort(arrayPrices); // sort array to find min price. it will be element with [0] index.
    double bestPriceEver1 = arrayPrices[0]; // best price.
    String bestPriceEver2 = String.format("%.2f",bestPriceEver1); // rounded best price.
    System.out.println("The best price is: " + bestPriceEver2 + "$");
    
    // conditional statement IF to find corresponding fare option: 
    if (bestPriceEver1 == fareOptions[0]){
        System.out.println("You should take single option!");
        
    } else if (bestPriceEver1 == unlimited7Price()) {
        System.out.println("You should take weekly option!");
        
    } else {
        System.out.println("You should take monthly option!");
    }
}
 
  // main:
  public static void main(String[] args){
  
    TransitCalculator myRide = new TransitCalculator(6,14){}; // 6 days and 14 rides 
    System.out.println("Number of days: " + myRide.numberOfDays);
    System.out.println("Number of rides: " + myRide.numberOfRides);
         System.out.println();
            myRide.getBestFare();
  }
}

  /*
  mistakes to remember:
  1. be careful working with double and int (!);
  2. only empty array shoud have number in [];
  3. study deeper IF and how we use variables in it (!);
  4. play with method getBestFare(). try to return a String that communicates the findings.
  
  */
