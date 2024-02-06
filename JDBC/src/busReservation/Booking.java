package busReservation;
import java.util.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Booking {
	String passengerName;
	int busNo;
	Date date;
	Booking(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Name of Passenger:");
		passengerName = scanner.next();
		System.out.println("Enter BusNo:");
	busNo = scanner.nextInt();
		System.out.println("Enter Date dd-mm-yy");
		String dateInput = scanner.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			date = dateFormat.parse(dateInput);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public boolean isAvailable()throws SQLException {
		BusDAO busdao = new BusDAO();
		BookingDAO bookingdao = new BookingDAO();
		int capacity = busdao.getCapacity(busNo);
		int booked = bookingdao.getBookedCount(busNo,date);
		
		return booked<capacity;
	}

}
