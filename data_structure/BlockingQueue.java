/**
http://tutorials.jenkov.com/java-concurrency/blocking-queues.html
*/

class BlockingQueue <T> {
	private final Queue<T> queue = new LinkedList<>();
	private final int limit;
	
	public BlockingQueue(int limit) {
		this.limit = limit;
	}
	
	public synchronized void put(T t) throws InterruptedException{
		while (queue.size() == limit) {
			wait();
		}
		if (queue.size() == 0) {
			notifyAll();
		}
		queue.add(t);
	}
	
	public synchronized T take() throws InterruptedException {
		while (queue.size() == 0) {
			wait();
		}
		if (queue.size() == limit) {
			notifyAll();
		}
		return queue.remove(0);
	}
}