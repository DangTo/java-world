package tutorial.java.thread;

public class SynchronizedCounter implements Runnable {
	private int c = 0;
	private Object lock = new Object();

	// Note constructors cannot be synchronized
	public synchronized void synchronizedMethod() {
		c++;
		System.out.println(Thread.currentThread().getName() + " increment:" + c);
	}

	public void synchronizedBlock() {
		synchronized (this/*lock*/) {
			c++;
			System.out.println(Thread.currentThread().getName() + " decrement:" + c);
		}
	}

	public int value() {
		return c;
	}

	public void run() {
		while (c < 20) {
			// synchronizedMethod();
			synchronizedBlock();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " result:" + value());
	}

	public static void main(String[] args) {
		SynchronizedCounter counter = new SynchronizedCounter();
		Thread thread1 = new Thread(counter, "Thread A");
		Thread thread2 = new Thread(counter, "Thread B");
		Thread thread3 = new Thread(counter, "Thread C");

		thread1.start();
		thread2.start();
		thread3.start();
	}
}
