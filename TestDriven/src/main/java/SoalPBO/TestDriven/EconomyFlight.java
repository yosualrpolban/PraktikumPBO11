package SoalPBO.TestDriven;

public class EconomyFlight extends Flight{
	
	public EconomyFlight(String id) { 
		 super(id); 
	}

	@Override
	public boolean addPassenger(Passenger passenger) {
		// TODO Auto-generated method stub
		return  passengers.add(passenger);
	}

	@Override
	public boolean removePassenger(Passenger passenger) {
		// TODO Auto-generated method stub
		if (!passenger.isVip()) { 
			return passengers.remove(passenger); 
		} 
			return false; 
	} 

}
