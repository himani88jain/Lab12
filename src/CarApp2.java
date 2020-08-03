import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarApp2 {
	public static List<Car> cars = new ArrayList<>();
	public static Scanner scnr = new Scanner(System.in);

	public static void main(String[] args) {

		cars.add(new Car("Subaru", "Impreza", 2019, 24000.00));
		cars.add(new Car("Hyonda", "Prior", 2016, 29000.00));
		cars.add(new Car("GC", "Chirpus", 2017, 34000.00));
		cars.add(new UsedCar("Toyata", "Camri", 2010, 20000.00, 4500));
		cars.add(new UsedCar("Nissan", "Cube", 2009, 15000.00, 3300.00));
		cars.add(new UsedCar("GC", "Witherell", 2016, 12250.00, 3500));

		listCar();
		boolean choice = true;
		int id = 0;
		do {
			try {

				id = Validator.getInt(scnr, "Which car would you like?");

				if (id == cars.size() + 1) {
					break;
				}

				getCarId(id);
				
				//Validating if user like to buy the car or not?
				choice = Validator.getYesNo(scnr, "Would you like to buy this car?");
				if (choice) {
					System.out.println("Excellent! Our finance department will be in touch shortly.");
					buyCar(id);
					listCar();
				} else
					System.out.println("Sorry to hear you don't want to buy this car!");

			}
			// Throwing exception in case you enter id out of the range
			catch (IndexOutOfBoundsException e) {
				System.out.println("Please enter the number in the range.");
			}
		} while (choice);

		System.out.println("Have a great Day");
	}

	
	//Displaying all cars(new and used)
	public static void listCar() {
		System.out.println("Current Inventory:");
		int id = 1;
		for (Car c : cars) {
			if (c instanceof UsedCar) {
				System.out.printf("%-2d%-10s%-10s%-10d%-1s%-10.2f%-5s%-10.2f\n", id, c.getMake(), c.getModel(),
						c.getYear(), "$", c.getPrice(), " (Used) ", ((UsedCar) c).getMileage());
				id++;
			} else {
				System.out.printf("%-2d%-10s%-10s%-10d%-1s%-10.2f\n", id, c.getMake(), c.getModel(), c.getYear(), "$",
						c.getPrice());
				id++;
			}
		}
		System.out.printf("%-2d%-10s\n", id, "Quit");
	}

	
	//Displaying which car you want to check
	public static void getCarId(int id) {
		System.out.println(cars.get(id - 1));
	}

	
	//Removing car from the list once user buys it
	public static void buyCar(int id) {
		cars.remove(id - 1);

	}

}
