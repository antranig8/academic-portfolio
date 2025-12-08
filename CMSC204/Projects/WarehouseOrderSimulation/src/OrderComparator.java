import java.util.Comparator;
/**
 * Class that sets up the orderComparator
 */
public class OrderComparator implements Comparator<Order>{
	/**
	 * override the Method to compare orders
	 * checks the deadlines and if needed the arrival times
	 * @param Order a
	 * @param Order b
	 */
	@Override
	public int compare(Order a, Order b) {
		// Check to compare the deadlines
		if(a.getDeadlineMinute() < b.getDeadlineMinute()) {
			return -1;
		}
		else if(a.getDeadlineMinute() > b.getDeadlineMinute()) {
			return 1;
		}
		// If deadlines are equal check the arrival times
		else {
			if(a.getArrivalMinute() < b.getArrivalMinute()) {
				return -1;
			}
			else if(a.getArrivalMinute() > b.getArrivalMinute()) {
				return 1;
			}
			else {
				return 0;
			}
		}
	}
}
