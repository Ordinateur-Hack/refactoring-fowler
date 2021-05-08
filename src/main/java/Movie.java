public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private Price price;

    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public Price getPrice() {
        return price;
    }

    public void setPriceCode(int priceCode) {
        // 🔀 Refactoring: Replace type code with state/strategy
        switch (priceCode) {
            case REGULAR:
                this.price = new RegularPrice();
                break;
            case CHILDRENS:
                this.price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                this.price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect price code");
        }
    }

    public String getTitle() {
        return title;
    }

    int getFrequentRenterPoints(int daysRented) {
        // 🔀 Refactoring: Replace conditional logic on price code with polymorphism
        if ((price.getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1)
            return 2;
        else
            return 1;
    }

}
