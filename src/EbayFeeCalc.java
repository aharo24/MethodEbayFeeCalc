import java.util.Scanner;

public class EbayFeeCalc {

   public static double ebayFee(double sellPrice) {
      final double BASE_LIST_FEE = 0.50;     // Listing Fee
      final double PERC_50_OR_LESS = 0.13;   // % $50 or less
      final double PERC_50_TO_1000 = 0.05;   // % $50.01..$1000.00
      final double PERC_1000_OR_MORE = 0.02; // % $1000.01 or more
      double feeTot;                         // Resulting eBay fee

      feeTot = BASE_LIST_FEE;

      // Determine additional fee based on selling price
      if (sellPrice <= 50.00) { // $50.00 or lower
         feeTot = feeTot + (sellPrice * PERC_50_OR_LESS);
      }
      else if (sellPrice <= 1000.00) { // $50.01..$1000.00
         feeTot = feeTot + (50 * PERC_50_OR_LESS)
                 + ((sellPrice - 50) * PERC_50_TO_1000);
      }
      else { // $1000.01 and higher
         feeTot = feeTot + (50 * PERC_50_OR_LESS)
                 + ((1000 - 50) * PERC_50_TO_1000)
                 + ((sellPrice - 1000) * PERC_1000_OR_MORE);
      }

      return feeTot;
   }
   
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      double sellingPrice;        // User defined selling price

      // Prompt user for selling price, call eBay fee method
      System.out.print("Enter item selling price (e.g., 65.00): ");
      sellingPrice = scnr.nextDouble();
      System.out.println("eBay fee: $" + ebayFee(sellingPrice));
   }
}