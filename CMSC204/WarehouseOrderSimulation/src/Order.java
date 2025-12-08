/**
 * Class representing an order in the system.
 * @author Antranig Tatarian
 */
public class Order {
	// Private fields
	private String orderId;
	private int arrivalMinute;
	private int deadlineMinute;
	/**
	 * Paramterized constructor to get order id and deadline
	 * @param orderId
	 * @param deadline
	 */
	public Order(String orderId, int deadline) {
		this.orderId = orderId;
		this.deadlineMinute = deadline;
		this.arrivalMinute = -1;
	}
	/**
	 * method to set the arrival Minute
	 * @param arrival
	 */
	public void setArrivalMinute(int arrival) {
		this.arrivalMinute = arrival;
	}
	/**
	 * method to set the deadline minute
	 * @param deadline
	 */
	public void setDeadlineMinute(int deadline) {
		this.deadlineMinute = deadline;
	}
	/**
	 * method to get the arrival Minute
	 * @return arrivalMinute
	 */
	public int getArrivalMinute() {
		return arrivalMinute;
	}
	/**
	 * method to get the deadline Minute
	 * @return deadlineMinute
	 */
	public int getDeadlineMinute() {
		return deadlineMinute;
	}
	/**
	 * method to get the order id
	 * @return orderId
	 */
	public String getId() {
		return orderId;
	}
	/**
	 * method to returin the toString
	 * for testing purposes
	 * @return orderId
	 */
	@Override
	public String toString() {
		return orderId;
	}
	
}
