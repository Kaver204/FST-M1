package activities;

public class Activity1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	     Car mercedes = new Car();
	        mercedes.make = 2014;
	        mercedes.color = "Black";
	        mercedes.transmission = "Manual";
	    
	        //Using Car class method
	        mercedes.displayCharacterstics();
	        mercedes.accelerate();
	        mercedes.brake();
	    }


}


