package peaje;

public class Car extends Vehicle{
    public Car (String licensePlate){
        super(licensePlate);
    }
    @Override

    public int getTollFee(){
        return 100;
    }
    
}
