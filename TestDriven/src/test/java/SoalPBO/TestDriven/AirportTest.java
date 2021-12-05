package SoalPBO.TestDriven;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

public class AirportTest {
	 @DisplayName("Given there is an economy flight") 
	 @Nested 
	 class EconomyFlightTest { 
		 private Flight economyFlight; 
		 @BeforeEach
		 void setUp() { 
			 economyFlight = new EconomyFlight("1");  
		 } 
	 
	 @Test
	 public void testEconomyFlightRegularPassenger() {
		 Passenger mike = new Passenger("Mike", false); 
		 assertEquals("1", economyFlight.getId()); 
		 assertEquals(true, economyFlight.addPassenger(mike)); 
		 assertEquals(1, economyFlight.getPassengersList().size()); 
		 assertEquals("Mike",economyFlight.getPassengersList().get(0).getName()); 
		 assertEquals(true, economyFlight.removePassenger(mike)); 
		 assertEquals(0, economyFlight.getPassengersList().size()); 
	 	}
	 
	 @Test
	 public void testEconomyFlightVipPassenger() {
	 Passenger james = new Passenger("James", true); 
	 	assertEquals("1", economyFlight.getId()); 
	 	assertEquals(true, economyFlight.addPassenger(james)); 
	 	assertEquals(1, economyFlight.getPassengersList().size()); 
	 	assertEquals("James", economyFlight.getPassengersList().get(0).getName()); 
	 	assertEquals(false, economyFlight.removePassenger(james)); 
	 	assertEquals(1, economyFlight.getPassengersList().size()
	 	); 
	 	}
	 }

	@DisplayName("Given there is a business flight")
	@Nested
	class BusinessFlightTest {
		private Flight businessFlight; 

		@BeforeEach
		void setUp() {
			businessFlight = new BusinessFlight("2"); 
		}	
		@Nested 
		@DisplayName("When we have a regular passenger") 
		class RegularPassenger { 
			@Test
			@DisplayName("Then you cannot add or remove him  from a business flight") 
			public void testBusinessFlightRegularPassenger() {
				Passenger Mike = new Passenger("Mike", false);
				assertAll("Verify all conditions for a regular passenger and a business flight", 
						() -> assertEquals(false, businessFlight.addPassenger(Mike)), 
						() -> assertEquals(0, businessFlight.getPassengersList().size()), 
						() -> assertEquals(false, businessFlight.removePassenger(Mike)), 
						() -> assertEquals(0, businessFlight.getPassengersList().size()) 
						);
				}
			}
		@Nested 
		@DisplayName("When we have a VIP passenger") 
		class VipPassenger { 
			@Test
			@DisplayName("Then you can add him but cannot remove him from a business flight") 
			public void testBusinessFlightVipPassenger() {
				Passenger James = new Passenger("James", false);
				assertAll("Verify all conditions for a VIP passenger and a business flight", 
				() -> assertEquals(true, businessFlight.addPassenger(James)), 
				() -> assertEquals(1, businessFlight.getPassengersList().size()), 
				() -> assertEquals(false, businessFlight.removePassenger(James)), 
				() -> assertEquals(1, businessFlight.getPassengersList().size()) 
				);
				
			}
		}
	}
		
}
