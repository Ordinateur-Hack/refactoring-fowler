import java.util.Enumeration;
import java.util.Vector;

class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer (String name){
        this.name = name;
    }

    public void addRental(Rental arg) {
        this.rentals.addElement(arg);
    };

    public String getName (){
        return name;
    }

    public String statement() {
        Enumeration rentals = this.rentals.elements();
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            //show figures for this rental
            result += "\t" + each.getMovie().getTitle()+ "\t" + "\t" + each.getDaysRented() + "\t" + each.getCharge() + "\n";
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    public String htmlStatement() {
        Enumeration rentals = this.rentals.elements();
        String result = "<h1>Rentals for <em>" + getName() + "</em></h1><p>\n";

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            // show figures fo reach rental
            result += each.getMovie().getTitle() + ": " + each.getCharge() + "<br>\n";
        }

        // add footer lines
        result += "You owe <em>" + getTotalCharge() + "</em>\n";
        result += "On this rental you earned <em>" + getTotalFrequentRenterPoints()
                + "</em> frequent renter points</p>";
        return result;
    }

    private double getTotalCharge() {
        // 🔀 Refactoring: Replace Temp with Query (totalAmount)
        // 🔀 Refactoring: Replace Temp with Query
        // 🔀 Refactoring: Extract method
        double result = 0;
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

}
    