package application;

public class Flight {
	int flightnumber;
	String airlinename;
	String source;
	String destination;
	int Capacity;

	LinkedList<Passengers> p = new LinkedList<Passengers>();

	public Flight(int token, String airlinename, String source, String destination, int token2) {
		super();
		this.flightnumber = token;
		this.airlinename = airlinename;
		this.source = source;
		this.destination = destination;
		this.Capacity = token2;

	}

	public int getFlightnumber() {
		return flightnumber;
	}

	public void setFlightnumber(int flightnumber) {
		this.flightnumber = flightnumber;
	}

	public String getAirlinename() {
		return airlinename;
	}

	public void setAirlinename(String airlinename) {
		this.airlinename = airlinename;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getCapacity() {
		return Capacity;
	}

	public void setCapacity(int capacity) {
		Capacity = capacity;
	}

	public int length() {
		Node<Passengers>cur=p.head;
		int l=0;
		while(cur!=null) {
			++l;
			cur=cur.getNext();
		}
		return l;
	}



	public boolean capacity() {
		if (length() < Capacity) {
			
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Flight Number --> " + flightnumber + " | " + " Airline Name --> " + airlinename + " | " + "Source --> "
				+ source + "\n" + "Destination --> " + destination + " | " + "Capacity --> " + Capacity + "\n"
				+ "--------------------------------------------------------------------------------------------------------";
	}

}
