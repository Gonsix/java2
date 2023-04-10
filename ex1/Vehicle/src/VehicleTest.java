
public abstract class VehicleTest {
    public static void describe(Vehicle v) {
        System.out.println(v); // インスタンスをメソッドなしで呼び出しているので、getItem()みたいな定義が必要
    }

    public static void main(String[] args) {
        Vehicle vehicles[] = {
            new Car("Camly", "Toyota", "Suzuki", "Gasoline", 70. , 15.15, 5),
            new Car("Aqua", "Toyota", "Nakazija", "Hybrid", 36. , 40.0, 5),
            new MiniVan("Sienna", "Toyota", "Tanaka", "Gasoline", 75., 9.0, 8, true),
            new MiniVan("Odyssey", "Honda", "Kikuchi", "Diesel", 56., 11.0, 8, false),
            new MiniVan("Presage", "Nissan", "Shirotora", "Gasoline", 60., 7.0, 7, false),
            new Truck("Tundra", "Toyota", "Sugai", "Diesel", 100., 6.76, 5, 310),
            new Truck("Ridgeline", "Honda", "Watanabe", "Diesel", 83.279, 7.23, 5, 250)
        };

        PetroleumPrice priceInfo = new PetroleumPrice(128.7, 105.7); // Petroleum : 石油

        for(Vehicle v: vehicles) {
            describe(v);
            System.out.println("Movable distance " + v.movableDistance() + "Km");
            System.out.println("Cost for 100 Km: " + v.costFor100Km(priceInfo) + "Yen");
            System.out.println();
        }
        System.out.println();
        System.out.println("After Aircondition is ON\n");
        
        for (Vehicle v: vehicles) {
            v.setAirConON();
            describe(v);
            System.out.println("Movable distance " + v.movableDistance() + "Km");
            System.out.println("Cost for 100 Km: " + v.costFor100Km(priceInfo) + "Yen");
            System.out.println();
        }
    }
}   

abstract class Vehicle {
    String modelName;
    String company;
    String owner;
    String engineType;
    double tankSize;        // liter
    double fuelConsumption; // Km / liter

    Vehicle(String modelName, String company, String owner, String engineType, 
            double tankSize, double fuelConsumption) {
        this.modelName = modelName;
        this.company = company;
        this.owner = owner;
        this.engineType = engineType;
        this.tankSize = tankSize;
        this.fuelConsumption = fuelConsumption;
    }

    public String toString() {
        return "ModelName: " + this.modelName + ", " + "Company: " + this.company 
                    + ", " + "Owner: " + this.owner + ", " + "EngineType: " + this.engineType
                    + ", " + "TankSize: " + this.tankSize 
                    + ", " + "FuelConsumption: " + this.fuelConsumption ;

    }

    public double movableDistance() {
        return this.tankSize*this.fuelConsumption;
    }

    public abstract double costFor100Km(PetroleumPrice priceInfo);
    public abstract void setAirConON();
    public abstract void setAirConOFF();


}


class Car extends Vehicle {
    int numberOfSeats;
    boolean airConditionOn = false;

    Car(String modelName, String company, String owner, String engineType, 
    double tankSize, double fuelConsumption, int numberOfSeats) {

        super(modelName, company, owner, engineType, tankSize, fuelConsumption);
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString(){
        return "ModelName: " + this.modelName + ", " + "Company: " + this.company 
                    + ", " + "Owner: " + this.owner + ", " + "EngineType: " + this.engineType
                    + ", " + "TankSize: " + this.tankSize 
                    + ", " + "FuelConsumption: " + this.fuelConsumption 
                    + ", " + "NumberOfSeat: " + this.numberOfSeats;
    }

    public double costFor100Km(PetroleumPrice priceInfo){
        // Car uses only gasoline 
       double fuelPrice = priceInfo.getGasolineCost();
       return (100.0 / this.fuelConsumption) * fuelPrice;
    }

    public void setAirConON(){
        this.airConditionOn = true;
        this.fuelConsumption = this.fuelConsumption*0.85;
    }
    public void setAirConOFF(){
        this.airConditionOn = false;
        this.fuelConsumption = this.fuelConsumption*(100.0/85.0);
    }

}

class MiniVan extends Vehicle {

    int numberOfSeats;
    boolean airConditionOn = false;
    boolean hasAutoDoor = false;

    MiniVan(String modelName, String company, String owner, String engineType, 
    double tankSize, double fuelConsumption, int numberOfSeats, boolean hasAutoDoor) {

        super(modelName, company, owner, engineType, tankSize, fuelConsumption);
        this.numberOfSeats = numberOfSeats;
        this.hasAutoDoor = hasAutoDoor;
    }

    @Override
    public String toString(){
        return "ModelName: " + this.modelName + ", " + "Company: " + this.company 
                    + ", " + "Owner: " + this.owner + ", " + "EngineType: " + this.engineType
                    + ", " + "TankSize: " + this.tankSize 
                    + ", " + "FuelConsumption: " + this.fuelConsumption 
                    + ", " + "NumberOfSeat: " + this.numberOfSeats 
                    + ", " + "HasAutoDoor: " + this.hasAutoDoor;
    }    

    public void setHasAutoDoor() {
        this.hasAutoDoor = true;
    }

    public double costFor100Km(PetroleumPrice priceInfo){
        double fuelPrice = 0; 
       
        if (this.engineType == "Gasoline" || this.engineType == "Hybrid") {
            fuelPrice = priceInfo.getGasolineCost();
        } 
        else if (this.engineType == "Diesel") {
            fuelPrice = priceInfo.getDieselCost();
        }

       return (100.0 / this.fuelConsumption) * fuelPrice;
    }

    public void setAirConON(){
        this.airConditionOn = true;
        this.fuelConsumption = this.fuelConsumption*0.75;
    }
    public void setAirConOFF(){
        this.airConditionOn = false;
        this.fuelConsumption = this.fuelConsumption*(100.0/75.0);
    }
}


class Truck extends Vehicle {
    int numberOfSeats;
    boolean airConditionOn = false;
    double power;

    Truck(String modelName, String company, String owner, String engineType, 
    double tankSize, double fuelConsumption, int numberOfSeats, double power) {

        super(modelName, company, owner, engineType, tankSize, fuelConsumption);
        this.numberOfSeats = numberOfSeats;
        this.power = power;
    }

    @Override
    public String toString(){
        return "ModelName: " + this.modelName + ", " + "Company: " + this.company 
                    + ", " + "Owner: " + this.owner + ", " + "EngineType: " + this.engineType
                    + ", " + "TankSize: " + this.tankSize 
                    + ", " + "FuelConsumption: " + this.fuelConsumption 
                    + ", " + "NumberOfSeat: " + this.numberOfSeats 
                    + ", " + "HorsePower: " + this.power;
    }  

    public double costFor100Km(PetroleumPrice priceInfo){
        // The Truck uses only diesel engine.
        double fuelPrice = priceInfo.getDieselCost();

       return (100.0 / this.fuelConsumption) * fuelPrice;
    }

    public void setAirConON(){
        this.airConditionOn = true;
        this.fuelConsumption = this.fuelConsumption*0.75;
    }
    public void setAirConOFF(){
        this.airConditionOn = false;
        this.fuelConsumption = this.fuelConsumption*(100.0/75.0);
    }
    
}


class PetroleumPrice {  //  OK
    double gasolinePrice;   // yen/liter
    double dieselPrice;     // yen/liter

    PetroleumPrice(double gasolineP, double dieselP){
        this.gasolinePrice = gasolineP;
        this.dieselPrice = dieselP;
    }

    public double getGasolineCost(){
        return this.gasolinePrice;
    }
    public double getDieselCost(){
        return this.dieselPrice;
    }
}
