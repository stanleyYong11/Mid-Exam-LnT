package Main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	Scanner scan = new Scanner(System.in);
	
	ArrayList<String> SvehicleType = new ArrayList<>();
	ArrayList<String> ScarMotorcycleType = new ArrayList<>();
	ArrayList<Integer> SentertainmentHelmet = new ArrayList<>();
	ArrayList<String> ScarBrand = new ArrayList<>();
	ArrayList<String> ScarName = new ArrayList<>();
	ArrayList<String> ScarLicense = new ArrayList<>();
	ArrayList<Integer> StopSpeed = new ArrayList<>();
	ArrayList<Integer> SgasCapacity = new ArrayList<>();
	ArrayList<Integer> Swheel = new ArrayList<>();
	
	Car mobil = new Car();
	Motorcycle motor = new Motorcycle();
	MinivanAndSUV mobilBiasa = new MinivanAndSUV();
	Supercar mobilSuper = new Supercar();
	Bike motorSemua = new Bike();
	
	public void menu() {
		System.out.println("1. Input");
		System.out.println("2. View");
		System.out.println("3. Exit");
		System.out.print(">> ");
	}
	
	public void input() {
		
		String vehicleType;
		String carType;
		int carEntertainmentSystem;
		String motorcycleType;
		int motorcycleHelmet;
		
		do {
			System.out.print("Input type [Car | Motorcycle]: ");
			vehicleType = scan.nextLine();
		} while (!vehicleType.equals("Car") && !vehicleType.equals("Motorcycle"));
		SvehicleType.add(vehicleType);
		
		if (vehicleType.equals("Car")) {
			do {
				mobil.type();
				carType = scan.nextLine();
			} while (!carType.equals("SUV") && !carType.equals("Supercar") && !carType.equals("Minivan"));
			ScarMotorcycleType.add(carType);
			
			do {
				try {
					mobil.additional();
					carEntertainmentSystem = scan.nextInt(); scan.nextLine();
				} catch (Exception e) {
					System.err.println("Input numbers only!");
					carEntertainmentSystem = 0;
				}
			} while (!(carEntertainmentSystem >= 1));
			SentertainmentHelmet.add(carEntertainmentSystem);
			
		}else {
			do {
				motor.type();
				motorcycleType = scan.nextLine();
			} while (!motorcycleType.equals("Automatic") && !motorcycleType.equals("Manual"));
			ScarMotorcycleType.add(motorcycleType);
			
			do {
				try {
					motor.additional();
					motorcycleHelmet = scan.nextInt(); scan.nextLine();
				} catch (Exception e) {
					System.err.println("Input number only!");
					motorcycleHelmet = 0;
				}
			} while (!(motorcycleHelmet >= 1));
			SentertainmentHelmet.add(motorcycleHelmet);
		}
		
		String carBrand;
		do {
			System.out.print("Input brand [>= 5]: ");
			carBrand = scan.nextLine();
		} while (!(carBrand.length() >= 5));
		ScarBrand.add(carBrand);
		
		String carName;
		do {
			System.out.print("Input name [>= 5]: ");
			carName = scan.nextLine();
		} while (!(carName.length() >= 5));
		ScarName.add(carName);
		
		String carLicense;
		do {
			System.out.print("Input license: ");
			carLicense = scan.nextLine();
		} while (!(carLicense.length() >= 5));
		ScarLicense.add(carLicense);
		
		int topSpeed = 0;
		do {
			try {
				System.out.print("Input Top Speeed [100 <= topSpeed <= 250]: ");
				topSpeed = scan.nextInt(); scan.nextLine();
			} catch (Exception e) {
				System.err.println("Only input between 100 and 250!");
			}
		} while (!(topSpeed >= 100) || !(topSpeed <= 250));
		StopSpeed.add(topSpeed);
		
		int gasCapacity = 0;
		do {
			try {
				System.out.print("Input Gas Capacity [30 <= topSpeed <= 60]: ");
				gasCapacity = scan.nextInt(); scan.nextLine();
			} catch (Exception e) {
				System.err.println("Only input between 30 and 60!");
			}
		} while (!(gasCapacity >= 30) || !(gasCapacity <= 60));
		SgasCapacity.add(gasCapacity);
		
		int carWheel = 0;
		int motorcycleWheel = 0;
		if (vehicleType.equals("Car")) {
			do {
				try {
					mobil.wheel();
					carWheel = scan.nextInt();
				} catch (Exception e) {
					System.out.println("Input number between 4 and 6 only!");
				}
			} while (!(carWheel >= 4) || !(carWheel <= 6));
			Swheel.add(carWheel);
		}else {
			do {
				try {
					motor.wheel();
					motorcycleWheel = scan.nextInt();
				} catch (Exception e) {
					System.out.println("Input number between 4 and 6 only!");
				}
			} while (!(motorcycleWheel >= 2) || !(motorcycleWheel <= 3));
			Swheel.add(motorcycleWheel);
		}
	}
	
	public void view() {
		int testDrive;
		
		System.out.println("|-----|-------------|-----------------------|");
		System.out.println("|No   |Type         |Name                   |");
		for (int i = 0; i < SvehicleType.size(); i++) {
			System.out.println("|-----|-------------|-----------------------|");
			System.out.printf("|%-4s |%-12s |%-22s |\n", (i+1), SvehicleType.get(i), ScarName.get(i));
		}
		System.out.println("|-----|-------------|-----------------------|");
		System.out.print("Pick a vehicle number to test drive [Enter '0' to exit]: ");
		testDrive = scan.nextInt(); scan.nextLine();
		
		System.out.println("Brand: " + ScarBrand.get(testDrive-1));
		System.out.println("Name: " + ScarName.get(testDrive-1));
		System.out.println("License Plate: " + ScarLicense.get(testDrive-1));
		System.out.println("Type: " + ScarMotorcycleType.get(testDrive-1));
		System.out.println("Gas Capacity: " + SgasCapacity.get(testDrive-1));
		System.out.println("Top Speed: " + StopSpeed.get(testDrive-1));
		System.out.println("Wheel(s): " + Swheel.get(testDrive-1));
		System.out.println("Entertainment System: " + SentertainmentHelmet.get(testDrive-1));
		
		if (SvehicleType.get(testDrive-1).equals("Car")) {
			if (ScarMotorcycleType.get(testDrive-1).equals("Supercar")) {
				mobilSuper.tune();
			}else {
				mobilBiasa.tune();
			}
		}else {
			System.out.print(ScarName.get(testDrive-1) + " ");
			motorSemua.tune();
		}
		
	}
	
	public Main() {
		int pilih = 0;
		
		do {
			menu();
			pilih = scan.nextInt(); scan.nextLine();
			
			switch (pilih) {
			case 1:
				input();
				System.out.println("");
				break;

			case 2:
				view();
				System.out.println("");
				break;
				
			case 3:
				System.exit(0);
				break;
			}
		} while (!(pilih == 3));
	}

	public static void main(String[] args) {
		new Main();
	}

}
