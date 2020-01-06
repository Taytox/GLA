/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealership;
import java.util.ArrayList;
/**
 *
 * @author EZLuke
 */
public class Dealership {
static ArrayList<Vehicle> stock = new ArrayList<>();
 //Dealership taysideAuto = new Dealership();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       addVehicle();
       listStock();
       //getVehicleDetails(606);
       //isVehicleInStock(610);
        
    }
    
    public static void addVehicle(){
        stock.add(new Car("Ford","Focus",2016,Colour.BLUE,BodyType.HATCHBACK,10000,606,Gearbox.MANUAL,PossibleAdditions.SATNAV,PossibleAdditions.PARKINGSENSOR,PossibleAdditions.TOWBAR));
        stock.add(new Car("BMW","M3",2019,Colour.BLACK,BodyType.SALOON,50000,608,Gearbox.MANUAL,PossibleAdditions.SATNAV));
        stock.add(new Car("Ford","Fiesta",2015,Colour.RED,BodyType.HATCHBACK,13000,177,Gearbox.AUTOMATIC));
    }
    public static void listStock(){
        int counter = 0;
        System.out.println("\nCurrent Stock");
        System.out.format("|%-16s|%-16s|%-16s|%-16s|%-16s|%-16s|%-16s|%-32s|%n", "VIM", "Make", "Model","Year","Body Type","Colour","Gearbox", "Additions");
        while(counter < stock.size()){
       // System.out.println("\nVIN : " + stock.get(counter).getVIN()+ " Make: " + stock.get(counter).getMake() + " Model: " + stock.get(counter).vehicleModel);
        //stock.get(counter).checkForAddition();
        //System.out.println();
        getVehicleDetails(stock.get(counter).getVIN());
        counter++; 
    }
    }
    private static  boolean isVehicleInStock(int VIN){
        int counter = 0;
        while(counter < stock.size())
        if (stock.get(counter).getVIN() == VIN){
            System.out.println("It is in the list");
            return true;
        }else{
            counter++;
        }
            System.out.println("Not in the list");
        return false;
    }
    public static void getVehicleDetails(int VIM){
       int counter = 0;
       
        while(counter < stock.size())
        if (stock.get(counter).getVIN() == VIM){ 
           System.out.format("|%-16d|%-16s|%-16s|%-16d|%-16s|%-16s|%-16s|%-32s|%n", stock.get(counter).getVIN(),stock.get(counter).getMake(),stock.get(counter).getModel(),stock.get(counter).getYearMade(),castCar(counter),stock.get(counter).getColour(),stock.get(counter).getGearType(),stock.get(counter).getAdditionsList());
           break;
        }
        else{
                   counter++;
                   }
        } 
    
    private static String castCar(int index){
        
        if(stock.get(index) instanceof Car){
               return (((Car)stock.get(index)).getBodyType()).toString();
        } else 
            return "N/A";
    }
    }
