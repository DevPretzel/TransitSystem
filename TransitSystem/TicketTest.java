package proj4;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class TicketTest {

	@Test
	public void testConstructorAndGetters() {
		try {
			Ticket t = new Ticket(4.0, false, false);
			assertFalse(t.isMonthlyPass());
			assertFalse(t.isDayPass());
			assertEquals(t.getCost(), 4.0);
			assertFalse(t.isExpired());
		}
		catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testInvalidConstructor() {
		try {
			new Ticket(3.0, true, true);
			fail();
		}
		catch(Exception e) {
			
		}
	}
	
	@Test
	public void testSetMonthlyPass() {
		try {
			Ticket t = new Ticket(3.0, false, false);
			assertFalse(t.isMonthlyPass());
			assertFalse(t.isDayPass());
			t.setMonthlyPass(true);
			assertTrue(t.isMonthlyPass());
		}
		catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testSetDayPass() {
		try {
			Ticket t = new Ticket(3.0, false, false);
			assertFalse(t.isDayPass());
			assertFalse(t.isMonthlyPass());
			t.setDayPass(true);
			assertTrue(t.isDayPass());
		}
		catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testSetCost() {
		try {
			Ticket t1 = new Ticket(3.0, false, false);
			Ticket t2 = new Ticket(3.0, true, false);
			Ticket t3 = new Ticket(3.0, false, true);
			
			t1.setCost(2.0);
			t2.setCost(2.0);
			t3.setCost(2.0);
			
			assertEquals(t1.getCost(), 2.0);
			assertEquals(t2.getCost(), 10.0);
			assertEquals(t3.getCost(), 4.0);
		}
		catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void tesGetTicketNum() {
		try {
			Ticket t = new Ticket(3.0, false, false);
			assertTrue(t.getTicketNum() >= 0);
		}
		catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testToString() {
		try {
			Ticket t = new Ticket(3.0, true, false);
			String expected = String.format("Ticket#: %d, Monthly Pass: Yes, Day Pass: No", t.getTicketNum());
			assertEquals(t.toString(), expected);
		}
		catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testEquals() {
		try {
			Ticket t1 = new Ticket(3.0, true, false);
			Ticket t2 = t1;
			Ticket t3 = new Ticket(3.0, true, false);
			assertEquals(t1, t2);
			assertNotEquals(t1, t3);
		}
		catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testGetExpiration() {
		try {
			Ticket t1 = new Ticket(3.0, true, false);
			Ticket t2 = new Ticket(3.0, false, true);
			LocalDate d1 = t1.getExpiration();
			LocalDate d2 = t2.getExpiration();
			assertEquals(d1, LocalDate.now().plusMonths(1));
			assertEquals(d2, LocalDate.now().plusDays(1));
		}
		catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testUseSingleTicket() throws Exception {
		try {
			Ticket t = new Ticket(3.0, false, false);
			assertFalse(t.getUsed());
			assertTrue(t.useTicket());
			assertTrue(t.getUsed());
		}
		catch(Exception e) {
			fail();
		}
	}
}
