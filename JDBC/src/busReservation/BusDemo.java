package busReservation;
import java.util.Scanner;
import java.sql.SQLException;


public class BusDemo {

	public static void main(String[] args) throws SQLException {
		BusDAO busdao = new BusDAO();
		try {
		busdao.displayBusInfo();
		int userOpt = 1;
		Scanner scanner = new Scanner(System.in);
		
		while(userOpt==1) {
			System.out.println("Enter 1 to book 2 to exit");
			userOpt = scanner.nextInt();
			if(userOpt == 1) {
				Booking booking = new Booking();
				if(booking.isAvailable()) {
					BookingDAO bookingdao = new BookingDAO();
					bookingdao.addBooking(booking);
					System.out.println("Your Booking is Confirmed");
				}else {
					System.out.println("Sorry. Bus is Full.Try another bus or date.");
				}
			}
			
		}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}


