class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getCharge() {
        // 🔀 Refactoring: Replace conditional logic on price code with polymorphism
        return getMovie().getCharge(this.daysRented);
    }

    public int getFrequentRenterPoints() {
        // 🔀 Refactoring: Replace conditional logic on price code with polymorphism
        // 🔀 Refactoring: Extract method
        return getMovie().getFrequentRenterPoints(this.daysRented);
    }

}
