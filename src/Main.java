import java.util.ArrayList;

abstract class Vehicles {
    private String model;
    private String Brand;
    private String VehicleNumber;
    private int ID;
    protected double rentPerDay;
    public Vehicles(String model, String Brand, String VehicleNumber, int ID,  double rentPerDay) {
        this.model = model;
        this.Brand = Brand;
        this.VehicleNumber = VehicleNumber;
        this.ID = ID;
        this.rentPerDay = rentPerDay;
    }
   public String getname(){
        return model;

   }
   public String getBrand(){
        return Brand;
   }
   public String getVehicleNumber(){
        return VehicleNumber;
   }
   public int getID(){
        return ID;
   }
   public double getrentPerDay(){
        return rentPerDay;
   }
  public abstract double CalculateRent(int Days);

    @Override
    public String toString(){
        return "Vehicle[Model=" + model + ",Brand=" + Brand + ", VehicleNumber=" + VehicleNumber + ", ID=" + ID + ",rentPerDay= " + rentPerDay + "]";
    }
}

class LuxuryCar extends Vehicles {

     private double luxuryTax;

    public LuxuryCar(String model, String Brand, String VehicleNumber, double luxuryTax,int ID,  double rentPerDay) {
        super(model,Brand,VehicleNumber,ID,rentPerDay);
        this.luxuryTax = luxuryTax;

    }
    @Override
    public double CalculateRent(int Days) {
        return (Days*rentPerDay)+luxuryTax;
    }


}

class StandardCar extends Vehicles {

    public StandardCar(String model, String Brand, String VehicleNumber, int ID, double rentPerDay) {
        super(model, Brand, VehicleNumber, ID, rentPerDay);

    }

    @Override
    public double CalculateRent(int Days) {
        return rentPerDay * Days;
    }
}
    class Rental {

        private Vehicles vehicle;
        private int days;

        public Rental(Vehicles vehicle, int days) {
            this.vehicle = vehicle;
            this.days = days;
        }

        public void printBill() {
            System.out.println("Vehicle ID: " + vehicle.getID());
            System.out.println("Days: " + days);
            System.out.println("Total Rent: " + vehicle.CalculateRent(days));
        }
    }




   
class VehicleFleet{
    private ArrayList<Vehicles> vehiclesList;

    public VehicleFleet() {
        vehiclesList = new ArrayList<>();
    }

   public  void addVehicles(Vehicles vehicles){
        vehiclesList.add(vehicles);

   }
   public void removeVehicles(int id){
        Vehicles vehicleToRemove = null;
        for( Vehicles vehicle : vehiclesList){
            if(vehicle.getID() == id){
                vehicleToRemove = vehicle;
                break;
            }

        }
        if(vehicleToRemove != null){
            vehiclesList.remove(vehicleToRemove);
        }


   }
    public void displayVehicles(){
        for(Vehicles vehicle : vehiclesList){
            System.out.println(vehicle);
        }
    }



}




public class Main {
    public static void main(String[] args) {
        VehicleFleet vehicleFleet = new VehicleFleet();
        LuxuryCar Veh1 = new LuxuryCar("AudiA3Type8L","Audi","MH09AL1998",1227.90,100,12655);
        StandardCar Veh2 = new StandardCar("ToyotaYaris", "Toyota","MH32Jk8906",105,5500);

        vehicleFleet.addVehicles(Veh1);
        vehicleFleet.addVehicles(Veh2);    // vehicleFleet not VehicleFleet
        System.out.println("Vehicle Fleet List :");
        vehicleFleet.displayVehicles();
        System.out.println("Removing Vehicles :");
        vehicleFleet.removeVehicles(105);
        System.out.println("Remaining Vehicles List :");
        vehicleFleet.displayVehicles();

        Rental rental1  = new Rental(Veh1,12);
        rental1.printBill();
        Rental rental2  = new Rental(Veh2,27);
        rental2.printBill();

        }
    }
