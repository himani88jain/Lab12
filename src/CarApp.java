import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarApp {

	public static Scanner scnr = new Scanner(System.in);
	public static List<Car> cars = new ArrayList<>();

	public static void main(String[] args) {

		System.out.println("Welcome to Grand Circus Motors Admin Console!");
		int no_of_cars = Validator.getInt(scnr, "How many cars are you entering ");
		for (int i = 0; i < no_of_cars; i++) {
			System.out.print("Enter Car#" + (i + 1) + " ");
			addCar();
		}
		listCar();

	}

	//Adding cars to arraylist
	public static void addCar() {
		Car car = new Car();

		System.out.println("Make: ");
		car.setMake(scnr.nextLine());

		System.out.println("Model: ");
		car.setModel(scnr.nextLine());

		car.setYear(Validator.getInt(scnr, "Years: "));

		car.setPrice(Validator.getDouble(scnr, "Price: "));

		cars.add(car);
	}

	
	//Displaying the list of all cars
	public static void listCar() {
		System.out.println("Current Inventory:");
		for (Car c : cars) {
			System.out.printf("%-20s%-20s%-20d%-2s%-20.2f\n", c.getMake(), c.getModel(), c.getYear(), "$",
					c.getPrice());
		}
	}

}
