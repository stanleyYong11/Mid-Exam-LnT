package Main;

public class Car extends Vehicle{

	@Override
	public void type() {
		System.out.print("Choose your car model [SUV | Supercar | Minivan]: ");
	}

	@Override
	public void additional() {
		System.out.print("Input enterainment system amount [>= 1]: ");
	}

	@Override
	public void wheel() {
		System.out.print("Input wheel [4 <= wheel >= 6]: ");
	}

	@Override
	public void tune() {
		// TODO Auto-generated method stub
		
	}

}
