package me.splines;

// 🔀 Refactoring: Replace type code with state/strategy
public abstract class Price {
    public abstract int getPriceCode();

    // 🔀 Refactoring: Replace conditional with polymorphism
    // 🔀 Refactoring: Replace conditional logic on price code with polymorphism
    // 🔀 Refactoring: Extract method to object whose data the method uses
    // 🔀 Refactoring: Rename variables for better readability
    public abstract double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }

}
