package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Passengers {
	int Flightnumber;
	String Ticketnumber;
	String Fullname;
	String Passportnumber;
	String Nationality;
	Date date;

	public Passengers(int flightnumber, String ticketnumber, String fullname, String passportnumber, String nationality,
			String date) throws ParseException {
		super();
		Flightnumber = flightnumber;
		Ticketnumber = ticketnumber;
		Fullname = fullname;
		Passportnumber = passportnumber;
		Nationality = nationality;
		this.date = new SimpleDateFormat("dd/MM/yyyy").parse(date);
	}

	public int getFlightnumber() {
		return Flightnumber;
	}

	public void setFlightnumber(int flightnumber) {
		Flightnumber = flightnumber;
	}

	public String getTicketnumber() {
		return Ticketnumber;
	}

	public void setTicketnumber(String ticketnumber) {
		Ticketnumber = ticketnumber;
	}

	public String getFullname() {
		return Fullname;
	}

	public void setFullname(String fullname) {
		Fullname = fullname;
	}

	public String getPassportnumber() {
		return Passportnumber;
	}

	public void setPassportnumber(String passportnumber) {
		Passportnumber = passportnumber;
	}

	public String getNationality() {
		return Nationality;
	}

	public void setNationality(String nationality) {
		Nationality = nationality;
	}

	
	@Override
	public String toString() {

		return "Passenger Flight number-->" + Flightnumber + " | " + "Ticket Number-->" + Ticketnumber + " | "
				+ "Full Name-->" + Fullname + "\n" + "Passport Number-->" + Passportnumber + " | " + "Nationality-->"
				+ Nationality + " | " + "Date of Birth-->" + date + "\n"
				+ "--------------------------------------------------------------------------------------------------------------------";

	}

}
