// 🔀 Refactoring: Replace type code with state/strategy
public abstract class Price {
    abstract int getPriceCode();

    // 🔀 Refactoring: Replace conditional with polymorphism
    // 🔀 Refactoring: Replace conditional logic on price code with polymorphism
    // 🔀 Refactoring: Extract method to object whose data the method uses
    // 🔀 Refactoring: Rename variables for better readability
    abstract double getCharge(int daysRented);

}
