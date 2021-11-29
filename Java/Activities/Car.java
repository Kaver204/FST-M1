package activities;

public class Car {
   // Variables
    String color;
    int make;
    String transmission;
    int tyres;
    int doors;
	
    //Constructor
    Car() {
	tyres = 4;
	doors = 4;
    }

    //Class Methods
    public void displayCharacterstics(){
	System.out.println("Color of the Car: " + color);
	System.out.println("Make of the Car: " + make);
	System.out.println("Transmission of the Car: " + transmission);
	System.out.println("Number of doors : " + doors);
    System.out.println("Number of tyres : " + tyres);
    }

    public void accelerate() {
	System.out.println("Car is moving forward.");
    }
	
    public void brake() {
	System.out.println("Car has stopped.");
    }

}
