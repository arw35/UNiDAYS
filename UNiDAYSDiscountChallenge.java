/**
 * @Adam Williams
 * University of Kent
 * 
 * UNiDAYS Discounting Programming Challenge
 */

import java.util.ArrayList;

public class UNiDAYSDiscountChallenge
{
    // Initialise the variables and create an array list
    private double totalPrice = 0;
    private double delivery = 0;
    ArrayList<String> items = new ArrayList<String>();

    public UNiDAYSDiscountChallenge()
    {
        // The basic splash screen menu that pops up upon creation of the object
        System.out.println("Menu: ");
        System.out.println("");
        System.out.println("A: £8.00");
        System.out.println("B: £12.00 or 2 for £20.00");
        System.out.println("C: £4.00 or 3 for £10.00");
        System.out.println("D: £7.00 or Buy One Get One Free");
        System.out.println("E: £5.00 or 3 for 2");
    }
    
    public void addToBasket(String value)
    {
        // The user enters what item they want to buy, and that item is then added to the array list
        items.add(value);
    }
    
    public void calculateTotalPrice()
    {
        // The calculateTotalPrice function uses the modulo operation to calculate the price of each of the items individually
        // and is added to the other items at the end. The "B" count is explained with comments as all other counts are similar
        // in functionality. 
        
        // Initialise the count variables
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countE = 0;

        // For each loop through the array list that stores the values of each order in the array list in the count variables
        for (String userValue : items)
        {
            if (userValue == "A") {
                countA++;
            } else if (userValue == "B") {
                countB++;
            } else if (userValue == "C") {
                countC++;
            } else if (userValue == "D") {
                countD++;
            } else if (userValue == "E") {
                countE++;
            }
        }
        
        // Calculate price of all "A" items 
        if (countA != 0) {
            totalPrice += countA * 8;
        }
        
        // Calculate price of all "B" items
        if (countB != 0) { // If the "B" count is not 0
            if (countB % 2 == 0) { // If the "B" count modulo is equal to 0
                totalPrice += ((countB / 2) * 20); // The "B" count is halved and multiplied by 20 and added on to the totalPrice variable
            } else {
                totalPrice += (((countB - 1) / 2) * 20 + 12); // Deduct 1 from the "B" count, it is then halved and multiplied by 20, 12 is finally added to supplement the 1 and all is finally added on to the totalPrice variable
            }
        }
        
        // Calculate price of all "C" items
        if (countC != 0) {
            if (countC % 3 == 0) {
                totalPrice += ((countC / 3) * 10);
            } else if (countC % 3 == 1) {
                totalPrice += (((countC - 1) / 3) * 10 + 4);
            } else {
                totalPrice += (((countC - 2) / 3) * 10 + 4);
            }
        }
        
        // Calculate price of all "D" items
        if (countD != 0) {
            if (countD > 1) {
                totalPrice += ((countD * 7) / 2);
            } else {
                totalPrice += countD * 7;
            }
        }
        
        // Calculate price of all "E" items
        if (countE != 0) {
            if (countE % 3 == 0 && countE != 0) {
                totalPrice += ((countE / 3) * 10);
            } else if (countE % 3 == 1) {
                totalPrice += (((countE - 1) / 3) * 10 + 5);
            } else {
                totalPrice += (((countE - 2) / 3) * 10 + 10);
            }
        }  
        
        // If the totalPrice is bigger than 0 and less than 50, then there is a £7 delivery charge
        if (totalPrice < 50 && totalPrice > 0) {
            delivery = 7.00;
        }
        
        // The delivery charge is added onto the total price and a statement is outputted showing the total charge 
        double overallPrice = totalPrice + delivery;
        System.out.println("");
        System.out.println("Your total price is £" + overallPrice + " with a delivery charge of £" + delivery);
    }
}
