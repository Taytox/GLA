/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealership;
/**
 *
 * @author EZLuke
 */
public class Dealership {
static Vehicle[] stock = new Vehicle[5];
 //Dealership taysideAuto = new Dealership();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       addStock();
       listStock();
       
       //getVehicleDetails(606);
       //isVehicleInStock(610);
        
    }
    
    public static void addStock(){
        stock[0]= (new Hatchback("Ford","Focus",2016,Colour.BLUE,10000,606,Gearbox.MANUAL,PossibleAdditions.SATNAV,PossibleAdditions.PARKINGSENSOR,PossibleAdditions.TOWBAR));
        stock[1]=(new Estate("Audi","RS6",2013,Colour.BLACK,50000,608,Gearbox.MANUAL,PossibleAdditions.SATNAV));
        stock[2]=(new Saloon("Mercedes-Benz","C-Class",2015,Colour.RED,13000,177,Gearbox.AUTOMATIC));
        stock[3]=(new Suv("Land Rover","Range Rover",2000,Colour.GREEN,73000,151,Gearbox.AUTOMATIC,PossibleAdditions.TOWBAR,PossibleAdditions.ROOFRACK));
        stock[4]=(new Motorbike("Harley-Davidson","Iron 883",2018,Colour.BLACK,11000,690,Gearbox.MANUAL));
    }
    public static void listStock(){
        
        System.out.println("\nCurrent Stock");
        System.out.format("|%-16s|%-16s|%-16s|%-16s|%-16s|%-16s|%-16s|%-32s|%n", "VIM", "Make", "Model","Year","Body Type","Colour","Gearbox", "Additions");
        for(Vehicle i : stock){
        getVehicleDetails(i.getVIN());
        castCar(i);
       
        }
    }
    
    private static  boolean isVehicleInStock(int VIN){
        for (Vehicle i : stock){
        if (i.getVIN() == VIN){
            System.out.println("It is in the list");
            return true;
        }
        }
            System.out.println("Not in the list");
        return false;
    }
    
    public static void getVehicleDetails(int VIN){
        for (Vehicle i : stock){
        if (i.getVIN() == VIN){ 
           System.out.format("|%-16d|%-16s|%-16s|%-16d|%-16s|%-16s|%-32s|%n", i.getVIN(),i.getMake(),i.getModel(),i.getYearMade(),i.getColour(),i.getGearType(),i.getAdditionsList());
        }
        }
    }
    
     private static void castCar(Vehicle i){
        
        if(i instanceof Car){
            
              //return "temp";
              System.out.println("Car");
        } else 
           // return "N/A";
            System.out.println(" not Car");
    }
    
}
