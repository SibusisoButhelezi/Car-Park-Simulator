// CSC1016S assignment 04
// Exercise 1
// Sibusiso Buthelezi
// BTHSIB016
// Date: 07/09/2021

// A java class that creates Parking Tariff objects, which are to be stored in the Tariff Table

public class ParkingTariff {
    private TimePeriod period;
    private Money tariff;

    public ParkingTariff(TimePeriod p, Money tariff){
        period = p;
        this.tariff = tariff;
    }

    // Obtain the period of the ParkingTariff
    public TimePeriod getPeriod(){
        return period;
    }

    // Set the time period for this ParkingTariff
    public void setPeriod(TimePeriod period){
        this.period = period;
    }

    // Obtain the tariff amount of the ParkingTariff
    public Money getTariff(){
        return tariff;
    }

    // Set the tariff amount for the ParkingTariff
    public void setTariff(Money tariff){this.tariff = tariff;}

    // Obtain a string representation of the time period of the ParkingTariff
    public String periodToString(){return period.toString();}

    // Obtain a string representation of the tariff amount of the ParkingTariff
    public String tariffToString(){return tariff.toString();}

    // Obtain a string representation of the entire ParkingTariff
    public String parkingTariffToString(){return period.toString() + " : " + tariff.toString();}
}