package com.zybooks.cmsc234_project1_piggy_bank;

public class CalculationUtil {

    // calculates the total
    public static double sum(int quarter, int dime, int nickel, int penny) {
        double totalQ = (double)quarter * 0.25;
        double totalD = (double)dime * 0.10;
        double totalN = (double)nickel * 0.05;
        double totalP = (double)penny * 0.01;
        return totalQ + totalD + totalP + totalP;
    }


    public static double subtract(double total, double subtractionAmount) {
        return total - subtractionAmount;
    }

    public static double add(double total, double additionAmount) {
        return total + additionAmount;
    }
}
