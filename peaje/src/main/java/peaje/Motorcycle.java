package peaje;

public class Motorcycle extends Vehicle {
    public Motorcycle(String licensePlate ){
    super(licensePlate);
    }
    @Override
    public int getTollFee(){
        return 50;
    }
    
}
