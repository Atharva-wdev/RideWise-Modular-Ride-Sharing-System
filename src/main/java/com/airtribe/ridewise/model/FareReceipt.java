package com.airtribe.ridewise.model;

/**
 * Represents the fare details of a completed ride.
 *
 * Demonstrates Composition as Ride owns FareReceipt.
 */
public class FareReceipt {
    private final double baseFare;
    private final double surgeMultiplier;
    private final double taxes;
    private final double totalFare;

    public FareReceipt(
            double baseFare,
            double surgeMultiplier,
            double taxes,
            double totalFare) {

        this.baseFare = baseFare;
        this.surgeMultiplier = surgeMultiplier;
        this.taxes = taxes;
        this.totalFare = totalFare;
    }

    public double getBaseFare() {
        return baseFare;
    }

    public double getSurgeMultiplier() {
        return surgeMultiplier;
    }

    public double getTaxes() {
        return taxes;
    }

    public double getTotalFare() {
        return totalFare;
    }

    /**
     * Prints a formatted fare receipt.
     */
    public void printReceipt() {

        System.out.println("\n========== Ride Receipt ==========");
        System.out.printf("Base Fare        : ₹%.2f%n", baseFare);
        System.out.printf("Surge Multiplier : %.2fx%n", surgeMultiplier);
        System.out.printf("Taxes            : ₹%.2f%n", taxes);
        System.out.printf("Total Fare       : ₹%.2f%n", totalFare);
        System.out.println("==================================");
    }

    @Override
    public String toString() {
        return "FareReceipt{" +
                "baseFare=" + baseFare +
                ", surgeMultiplier=" + surgeMultiplier +
                ", taxes=" + taxes +
                ", totalFare=" + totalFare +
                '}';
    }
}