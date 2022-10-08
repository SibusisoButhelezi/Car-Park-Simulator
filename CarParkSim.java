// CSC1016S assignment 04
// Exercise 3
// Sibusiso Buthelezi
// BTHSIB016
// Date: 07/09/2021

// Completed version of the CarParkSim.java class
import java.util.Scanner;
/**
 * The CarParkSim class contains the main car park simulation method.
 * It creates and manipulates the main objects, and handles user I/O.
 *
 * @author Stephan Jamieson and ...
 * @version 14/7/2019
 */
public class CarParkSim {
    public static void main(final String[] args) {
        final Scanner keyboard = new Scanner(System.in);
        final Currency currency = new Currency("R", "ZAR", 100);

        // Create a new Clock object starting at midnight "00:00".
        Clock c = new Clock(new Time("00:00"));

        // Create a new Register object where all tickets will be stored
        final Register r = new Register();

        // Create a new TariffTable object where the tariff table will be stored
        final TariffTable tariffTable = new TariffTable(10);

        // Create ten time periods for ten tariff allocations
        final TimePeriod pOne = new TimePeriod(new Duration("minute", 0), new
                Duration("minute", 30));
        final TimePeriod pTwo = new TimePeriod(new Duration("minute", 30), new
                Duration("hour", 1));
        final TimePeriod pThree = new TimePeriod(new Duration("hour", 1), new
                Duration("hour", 3));
        final TimePeriod pFour = new TimePeriod(new Duration("hour", 3), new
                Duration("hour", 4));
        final TimePeriod pFive = new TimePeriod(new Duration("hour", 4), new
                Duration("hour", 5));
        final TimePeriod pSix = new TimePeriod(new Duration("hour", 5), new
                Duration("hour", 6));
        final TimePeriod pSeven = new TimePeriod(new Duration("hour", 6), new
                Duration("hour", 8));
        final TimePeriod pEight = new TimePeriod(new Duration("hour", 8), new
                Duration("hour", 10));
        final TimePeriod pNine = new TimePeriod(new Duration("hour", 10), new
                Duration("hour", 12));
        final TimePeriod pTen = new TimePeriod(new Duration("hour", 12), new
                Duration("day", 1));

        // Create the ten tariff table, allocating a tariff amount to each time period
        tariffTable.addTariff(pOne, new Money("R10", currency));
        tariffTable.addTariff(pTwo, new Money("R15", currency));
        tariffTable.addTariff(pThree, new Money("R20", currency));
        tariffTable.addTariff(pFour, new Money("R30", currency));
        tariffTable.addTariff(pFive, new Money("R40", currency));
        tariffTable.addTariff(pSix, new Money("R50", currency));
        tariffTable.addTariff(pSeven, new Money("R60", currency));
        tariffTable.addTariff(pEight, new Money("R70", currency));
        tariffTable.addTariff(pNine, new Money("R90", currency));
        tariffTable.addTariff(pTen, new Money("R100", currency));

        System.out.println("Car Park Simulator");
        // Print current time.
        System.out.println("The current time is " + c.examine().toString() + ".");
        System.out.println("Commands: tariffs, advance {minutes}, arrive, depart, quit.");
        System.out.print(">");
        String input = keyboard.next().toLowerCase();
        while (!input.equals("quit")) {
            if (input.equals("advance")) {
                // Advance the clock time by the given duration input by the user, then print out the current time
                c.advance(new Duration("minutes", keyboard.nextInt()));
                System.out.println("The current time is " + c.examine().toString() + ".");
            }
            else if (input.equals("tariffs")){
                // Print out the tariff table being used
                System.out.println(tariffTable);
            }
            else if (input.equals("arrive")) {
                // Create a new ticket, add it to the register, print details of ticket issued.
                Ticket ticket = new Ticket(c.examine());
                r.add(ticket);
                System.out.println("Ticket issued: " + ticket + ".");
            }
            else if (input.equals("depart")) {
                String ID = keyboard.next();
                // Determine if ticket is valid, i.e. in the register.
                // If yes, retrieve it, calculate duration of stay and print it, as well as print out the tariff amount to be paid.
                if (r.contains(ID)) {
                    Ticket thisTicket = r.retrieve(ID);
                    System.out.println("Ticket details: " + thisTicket.toString() + ".");
                    System.out.println("Current time: " + c.examine().toString() + ".");
                    Duration duration = thisTicket.age(c.examine());
                    System.out.println("Duration of stay: " + duration.format(duration,"minutes") + ".");
                    System.out.println("Cost of stay : " + tariffTable.getTariff(duration) + ".");
                }
                // If not, print error message.
                else System.out.println("Invalid ticket ID.");
            }

            else {
                System.out.println("That command is not recognised.");
                System.out.println("Commands: advance <minutes>, arrive, depart, quit.");
            }            
            System.out.print(">");
            input = keyboard.next().toLowerCase();
        }            
        System.out.println("Goodbye.");
    }

}
