// CSC1016S assignment 04
// Exercise 2
// Sibusiso Buthelezi
// BTHSIB016
// Date: 07/09/2021

// A java class that stores and allows access to the tariffs of the stay at a parking

public class TariffTable {
    private ParkingTariff[] tariffTable;
    private int i = 0;

    // Create a TariffTable with the given maximum number of entries
    public TariffTable(int maxSize){
        tariffTable = new ParkingTariff[maxSize];
    }

    public void addTariff(TimePeriod period, Money tariff){
        // Add the tariff for the given period to the table.

        // Execute this if tariffTable is empty
        // Create new ParkingTariff object and add it to tariffTable
        if (i == 0) {
            ParkingTariff newTariff = new ParkingTariff(period, tariff);
            tariffTable[i++] = newTariff;
        }

        // Check if the given time period precedes and is adjacent to that of the previous ParkingTariff object
        // If yes, create a new ParkingTariff object and add it to tariffTable
        else if(tariffTable[i-1].getPeriod().precedes(period) && tariffTable[i-1].getPeriod().adjacent(period)){
            ParkingTariff newTariff = new ParkingTariff(period, tariff);
            tariffTable[i++] = newTariff;
        }

        // If the given time period does not precede and is not adjacent, throw an exception
        else if (!(tariffTable[i-1].getPeriod().adjacent(period))){
            throw new IllegalArgumentException("Tariff periods must be adjacent.");
        }
        else
            throw new IllegalArgumentException("One tariff period must precede the other.");
    }

    public Money getTariff(Duration lengthOfStay){
        // Obtain the tariff for the given length of stay.

        for (int x = 0; x < i + 1; x++ ){
            if (tariffTable[x].getPeriod().includes(lengthOfStay))
                return tariffTable[x].getTariff();
        }
        return null;
    }

    public String toString(){
    // Obtain a String representation of this TariffTable in the form:
    //  <period0> : <tariff0>
    // ...
    // <periodn> : <tariffn>

    String allParkingTariffs = "";
        for (int x = 0; x < i ; x++){
            allParkingTariffs = allParkingTariffs + tariffTable[x].parkingTariffToString();
            if (x < i - 1)
                allParkingTariffs = allParkingTariffs + "\n";
        }
        return allParkingTariffs;
    }

}
