// CSC1016S assignment 03
// Exercise 3
// Sibusiso Buthelezi
// BTHSIB016
// Date: 28/08/2021

// A java class that store added Ticket objects that have been issued.
public class Register {
    private Ticket[] tickets;
    private int numTickets;

    public Register(){
        // Create a new Register object and initialize all the instances.
        this.tickets = new Ticket[100];
        numTickets = 0;
    }
    public void add(Ticket ticket){
        // Store a given Ticket in the register, then increment numTickets by 1.
        tickets[numTickets++] = ticket;
    }
    public boolean contains(String ticketID){
        // Determine whether a ticket with the given ID is in the collection.
        for (int i = 0; i < numTickets; i++){
            if (tickets[i].ID().equals(ticketID)){
                return true;
            }
        }
        return false;
    }
    public Ticket retrieve(String ticketID){
        // Get the Ticket with the given ID from the collection.
        for (int i = 0; i < numTickets; i++) {
            if (tickets[i].ID().equals(ticketID))
                return tickets[i];
        }
        return null;
    }
}
