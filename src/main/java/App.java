// yousaffuentes-cop3330-ex20


/*
 *  UCF COP3330 Fall 2021 Assignment 20 Solution
 *  Copyright 2021 zain yousaffuentes
 */

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("What is the order amount? ");
        int orderAmount = s.nextInt();

        s.nextLine();

        String [] knownStates = new String[2];
        knownStates[0] = "Wisconsin";
        knownStates[1] = "Illinois";

        double finalOrderAmount = orderAmount,
                currTax = 0.0;


        System.out.println("What state do you live in? ");
        String stateLivingIn = s.nextLine();

        if (stateLivingIn.equals(knownStates[0])) {
            System.out.println("What county do you live in? ");

            String countyLivingIn = s.nextLine();

            String [] knownCountiesInWisconsin = new String[2];
            knownCountiesInWisconsin[0] = "Eau Claire";
            knownCountiesInWisconsin[1] = "Dunn";

            double [] knownTaxesOfCountiesInWisconsin = new double[2];
            knownTaxesOfCountiesInWisconsin[0] = 0.005;
            knownTaxesOfCountiesInWisconsin[1] = 0.004;

            double wisconsinSalesTax = 0.05;

            currTax += orderAmount * wisconsinSalesTax;

            if (countyLivingIn.equals(knownCountiesInWisconsin[0])) {

                currTax += orderAmount * knownTaxesOfCountiesInWisconsin[0];

            } else if (countyLivingIn.equals(knownCountiesInWisconsin[1])) {

                currTax += orderAmount * knownTaxesOfCountiesInWisconsin[1];

            };

            finalOrderAmount += currTax;


        } else if (stateLivingIn.equals(knownStates[1])) {

            double illinoisSalesTax = 0.08;
            currTax += orderAmount * illinoisSalesTax;
            finalOrderAmount += currTax;

        };

        currTax = roundToNearestCent(currTax);
        finalOrderAmount = roundToNearestCent(finalOrderAmount);

        System.out.println(String.format("The tax is $%.2f.\nThe total is $%.2f.", currTax, finalOrderAmount));

    }

    public static double roundToNearestCent(double number) {

        double numberRoundedDown = Math.floor(number),
                decimalValue = number - numberRoundedDown,
                inflatedDecimalValue = decimalValue * 100;

        if (inflatedDecimalValue - Math.floor(inflatedDecimalValue) >= 0.5)
            return (Math.ceil(inflatedDecimalValue) / 100) + numberRoundedDown;
        else
            return (Math.floor(inflatedDecimalValue) / 100) + numberRoundedDown;

    };
}
