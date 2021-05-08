import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    private Movie m1;
    private Movie m2;
    private Movie m3;

    private Rental r1;
    private Rental r2;
    private Rental r3;
    private Rental r4;

    private Customer c1;
    private Customer c2;
    private Customer c3;

    @BeforeEach
    private void test() {
        // Movies
        m1 = new Movie("Movie 1", 1);
        m2 = new Movie("Movie 2", 2);
        m3 = new Movie("Movie 3", 3);

        // Rentals
        r1 = new Rental(m1, 10);
        r2 = new Rental(m2, 5);
        r3 = new Rental(m2, 2);
        r4 = new Rental(m3, 3);

        // Customers
        c1 = new Customer("Customer 1");
        c2 = new Customer("Customer 2");
        c3 = new Customer("Customer 3");

        // Rentals <-> Customers
        c1.addRental(r1);
        c2.addRental(r2);
        c3.addRental(r3);
        c3.addRental(r4);
    }

    @Test
    @DisplayName("Statements should return correct String")
    public void testStatements() {
        // Actual results
        String result1 = c1.statement();
        String result2 = c2.statement();
        String result3 = c3.statement();

        // Expected results
        String result1Expected = "Rental Record for Customer 1\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tMovie 1\t\t10\t30.0\n" +
                "Amount owed is 30.0\n" +
                "You earned 2 frequent renter points";
        String result2Expected = "Rental Record for Customer 2\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tMovie 2\t\t5\t4.5\n" +
                "Amount owed is 4.5\n" +
                "You earned 1 frequent renter points";
        String result3Expected = "Rental Record for Customer 3\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tMovie 2\t\t2\t1.5\n" +
                "\tMovie 3\t\t3\t0.0\n" +
                "Amount owed is 1.5\n" +
                "You earned 2 frequent renter points";

        // Actual <-> Expected
        assertEquals(result1, result1Expected);
        assertEquals(result2, result2Expected);
        assertEquals(result3, result3Expected);
    }

    @Test
    @DisplayName("HTML Statements should return correct String")
    public void testHtmlStatements() {
        // Actual results
        String result1 = c1.htmlStatement();
        System.out.println(result1);
        String result2 = c2.htmlStatement();
        System.out.println(result2);
        String result3 = c3.htmlStatement();
        System.out.println(result3);

        // Expected results
        String result1Expected = "<h1>Rentals for <em>Customer 1</em></h1><p>\n" +
                "Movie 1: 30.0<br>\n" +
                "You owe <em>30.0</em>\n" +
                "On this rental you earned <em>2</em> frequent renter points</p>";
        String result2Expected = "<h1>Rentals for <em>Customer 2</em></h1><p>\n" +
                "Movie 2: 4.5<br>\n" +
                "You owe <em>4.5</em>\n" +
                "On this rental you earned <em>1</em> frequent renter points</p>";
        String result3Expected = "<h1>Rentals for <em>Customer 3</em></h1><p>\n" +
                "Movie 2: 1.5<br>\n" +
                "Movie 3: 0.0<br>\n" +
                "You owe <em>1.5</em>\n" +
                "On this rental you earned <em>2</em> frequent renter points</p>";

        // Actual <-> Expected
        assertEquals(result1, result1Expected);
        assertEquals(result2, result2Expected);
        assertEquals(result3, result3Expected);
    }

}
