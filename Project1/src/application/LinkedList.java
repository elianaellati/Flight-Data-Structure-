package application;

import java.util.Collections;

public class LinkedList<T> {
	Node<T> head;

	public void insert(T data) {
		Node<T> m = new Node(data);
		Node<T> curr = head;
		Node<T> prev = null;

		int l = 0;
		String p;
		String k;
		if (head == null) {

			head = m;
		} else {
			if (data instanceof Flight) {
				if (((Flight) curr.getF()).getFlightnumber() < ((Flight) data).getFlightnumber()) {
					l = 1;
				}
			}
			if (data instanceof Passengers) {

				if (((Passengers) curr.getF()).getFullname()
						.compareToIgnoreCase(((Passengers) data).getFullname()) < 0) {
					l = 1;
				}
			}

			while ((curr != null) && l == 1) {
				prev = curr;
				curr = curr.getNext();
				if (curr != null) {
					if (data instanceof Flight) {
						if (((Flight) curr.getF()).getFlightnumber() < ((Flight) data).getFlightnumber()) {
							l = 1;
						} else
							l = 0;
					}
					if (data instanceof Passengers) {

						if (((Passengers) curr.getF()).getFullname()
								.compareToIgnoreCase(((Passengers) data).getFullname()) < 0) {
							l = 1;
						} else
							l = 0;
					}
				}

			}
			if (head == null)
				head = m;
			else if (prev == null) {
				m.setNext(head);
				head = m;

			} else {
				prev.setNext(m);
				m.setNext(curr);
			}
		}

	}

	public void checkkk() {
		Node<T> curr = head;
		Node<T> cur = curr.getNext();
		while (curr != null) {
			cur = curr.getNext();
			while (cur != null) {
				if (((Flight) curr.getF()).flightnumber == ((Flight) cur.getF()).flightnumber) {

					curr.setNext(cur.getNext());
				}
				cur = cur.getNext();
			}
			curr = curr.getNext();
		}
	}

	public void chec() {
		Node<T> curr = head;
		Node<Passengers> cur = ((Flight) curr.getF()).p.head;
		Node<Passengers> cu = cur.getNext();
		while (curr != null) {
			cur = ((Flight) curr.getF()).p.head;
			while (cur != null) {
				cu = cur.getNext();
				while (cu != null) {
					if (cur.getF().getTicketnumber().compareToIgnoreCase(cu.getF().getTicketnumber()) == 0) {
						cur.setNext(cu.getNext());
					}
					cu = cu.getNext();
				}
				cur = cur.getNext();
			}
			curr = curr.getNext();
		}
	}

	public Node<T> check(int p) {
		Node<T> curr = head;
		while (curr != null) {
			if (((Flight) curr.getF()).getFlightnumber() == p) {
				return curr;
			}
			curr = curr.getNext();
		}
		return null;
	}

	public void checkk(Node<Flight> f, int o) {
		Node<Passengers> cur = f.getF().p.head;
		while (cur != null) {
			cur.getF().setFlightnumber(o);
			cur = cur.getNext();
		}

	}

	public Node reserved(String b) {
		Node<T> curr = head;
		Node<Passengers> cur;

		while (curr != null) {
			cur = ((Flight) curr.getF()).p.head;
			while (cur != null) {
				if (cur.getF().getFullname().compareToIgnoreCase(b) == 0) {
					return cur;
				}
				cur = cur.getNext();
			}
			curr = curr.getNext();
		}
		return null;
	}

	public void delete(String ticket, Node<T> f) {
		Node<Passengers> prev = null;
		Node<Passengers> cur = ((Flight) f.getF()).p.head;
		while (cur != null && cur.getF().getFullname().compareToIgnoreCase(ticket) != 0) {

			prev = cur;
			cur = cur.getNext();
		}
		if (cur == ((Flight) f.getF()).p.head) {
			((Flight) f.getF()).p.head = ((Flight) f.getF()).p.head.getNext();
		} else {
			prev.setNext(cur.getNext());
		}
	}

	public void print() {
		Node<T> curr = head;
		if (head == curr) {
			System.out.print("Head-->" + ((Flight) curr.getF()).getFlightnumber() + "-->");
			curr = curr.getNext();
		}
		while (curr != null) {
			System.out.print(((Flight) curr.getF()).getFlightnumber() + "-->");
			curr = curr.getNext();
		}
		if (curr == null) {
			System.out.print("Null");

		}

	}

	public String printt() {
		String w = "";
		Node<T> curr = head;
		while (curr != null) {
			w = w + curr.getF().toString() + "\n";
			curr = curr.getNext();
		}
		return w;

	}

}