package Main;

public class Motorcycle extends Vehicle{

	@Override
	public void type() {
		System.out.print("Choose your motorcycle model [Automatic | Manual]: ");
	}

	@Override
	public void additional() {
		System.out.print("Input helmet amount [>= 1]: ");
	}

	@Override
	public void wheel() {
		System.out.print("Input wheel [2 <= wheel >= 3]: ");
	}

	@Override
	public void tune() {
		// TODO Auto-generated method stub
		
	}

}
