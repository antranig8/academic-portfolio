/**
 * WarehouseSimulation class that implements the simulation interface
 * @author Antranig Tatarian
 */
public class WarehouseSimulation implements SimulationInterface{
	// Fields to setup variables
	private Order[] order;
	private int minute;
	private int next;
	private int releaseIndex;
	// Queue and Stack
	private MyPriorityQueue<Order> priorityQueue;
	private MyStack<Order> returns;
	// Trackers
	private int totalArrived = 0;
	private int totalShipped = 0;
	private int totalLate = 0;
	
	/**
	 * Constructor to setup warehouse fields
	 * @param Order[] orders
	 */
	public WarehouseSimulation(Order[] orders) {
		// Set order
		if(orders == null) {
			this.order = new Order[0];
		}
		else {
			this.order = orders;
		}
		// Setup orderComparator
		OrderComparator cmp = new OrderComparator();
		// Setup queue and stack
		this.priorityQueue = new MyPriorityQueue<>(cmp);
		this.returns = new MyStack<>();
	}
		/**
		 * Tick method to simulate time moving by 1 minute.
		 * Add orders, ship orders, or move orders to late stack
		 */
		@Override
		public void tick() {
			// Release an order
			if(next < order.length) {
				Order other = order[next++];
				other.setArrivalMinute(minute);
				priorityQueue.enqueue(other);
				totalArrived++;
			}
			// Ship an order if there is one in line
			if(!priorityQueue.isEmpty()) {
				Order shipment = priorityQueue.dequeue();
				totalShipped++;
				// If the shipment is past the deadline minute send it to return stack
				if(minute > shipment.getDeadlineMinute()) {
					totalLate++;
					returns.push(shipment);
				}
			}
			// Advance time by 1 minute
			minute++;
		}
		/**
		 * isFinished method to track if the orders were released into the queue and the queue is empty
		 * @return true if orders were released and queue is empty
		 */
		@Override
		public boolean isFinished() {
			if(next >= order.length && priorityQueue.isEmpty()) {
				return true;
			}
			else {
				return false;
			}
		}
		// Getters
		@Override
		public int getCurrentMinute() {
			return minute;
		}
		@Override
		public int getTotalArrived() {
			return totalArrived;
		}
		@Override
		public int getTotalShipped() {
			return totalShipped;
		}
		@Override
		public int getTotalLate() {
			return totalLate;
		}
}
