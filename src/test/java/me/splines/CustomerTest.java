package me.splines;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    private Customer c1;
    private Customer c2;
    private Customer c3;

    @BeforeEach
    public void setUp() {
        // Movies
        Movie m1 = new Movie("me.splines.Movie 1", Movie.REGULAR);
        Movie m2 = new Movie("me.splines.Movie 2", Movie.NEW_RELEASE);
        Movie m3 = new Movie("me.splines.Movie 3", Movie.CHILDRENS);

        // Rentals
        Rental r1 = new Rental(m1, 10);
        Rental r2 = new Rental(m2, 5);
        Rental r3 = new Rental(m2, 2);
        Rental r4 = new Rental(m3, 3);

        // Customers
        c1 = new Customer("me.splines.Customer 1");
        c2 = new Customer("me.splines.Customer 2");
        c3 = new Customer("me.splines.Customer 3");

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
        String result1Expected = "me.splines.Rental Record for me.splines.Customer 1\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tme.splines.Movie 1\t\t10\t14.0\n" +
                "Amount owed is 14.0\n" +
                "You earned 1 frequent renter points";
        String result2Expected = "me.splines.Rental Record for me.splines.Customer 2\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tme.splines.Movie 2\t\t5\t15.0\n" +
                "Amount owed is 15.0\n" +
                "You earned 2 frequent renter points";
        String result3Expected = "me.splines.Rental Record for me.splines.Customer 3\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tme.splines.Movie 2\t\t2\t6.0\n" +
                "\tme.splines.Movie 3\t\t3\t1.5\n" +
                "Amount owed is 7.5\n" +
                "You earned 3 frequent renter points";

        // Expected <-> Actual
        assertEquals(result1Expected, result1);
        assertEquals(result2Expected, result2);
        assertEquals(result3Expected, result3);
    }

    @Test
    @DisplayName("HTML Statements should return correct String")
    public void testHtmlStatements() {
        // Actual results
        String result1 = c1.htmlStatement();
        String result2 = c2.htmlStatement();
        String result3 = c3.htmlStatement();

        // Expected results
        String result1Expected = "<h1>Rentals for <em>me.splines.Customer 1</em></h1><p>\n" +
                "me.splines.Movie 1: 14.0<br>\n" +
                "You owe <em>14.0</em>\n" +
                "On this rental you earned <em>1</em> frequent renter points</p>";
        String result2Expected = "<h1>Rentals for <em>me.splines.Customer 2</em></h1><p>\n" +
                "me.splines.Movie 2: 15.0<br>\n" +
                "You owe <em>15.0</em>\n" +
                "On this rental you earned <em>2</em> frequent renter points</p>";
        String result3Expected = "<h1>Rentals for <em>me.splines.Customer 3</em></h1><p>\n" +
                "me.splines.Movie 2: 6.0<br>\n" +
                "me.splines.Movie 3: 1.5<br>\n" +
                "You owe <em>7.5</em>\n" +
                "On this rental you earned <em>3</em> frequent renter points</p>";

        // Expected <-> Actual
        assertEquals(result1Expected, result1);
        assertEquals(result2Expected, result2);
        assertEquals(result3Expected, result3);
    }

}
