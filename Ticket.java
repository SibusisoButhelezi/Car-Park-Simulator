// CSC1016S assignment 03
// Exercise 2
// Sibusiso Buthelezi
// BTHSIB016
// Date: 28/08/2021

// A java class that creates Ticket objects that represent car park tickets.
// Each ticket has a unique ID and time of issue (24-hour clock).

public class Ticket {
    private String id;
    private Time issueTime;

    public Ticket(Time currentTime){
        // Creates a new Ticket that has a given time of issue and unique ID
        id = UIDGenerator.makeUID();
        issueTime = currentTime;
    }
    public String ID(){
        // Obtain this Ticket's ID
        return id;
    }
    public Duration age(Time currentTime){
        // Obtain this Ticket's age i.e. the issue time subtracted from the given time.
        return currentTime.subtract(issueTime);
    }
    public String toString(){
        // Obtain a String representation of this Ticket object in the form:
        // "Ticket[id="ddddd", time="hh:mm:ss"]"
        return "Ticket[id=" + id + ", time=" + issueTime + "]";
    }
}

