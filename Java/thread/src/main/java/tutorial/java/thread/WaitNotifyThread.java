package tutorial.java.thread;

public class WaitNotifyThread implements Runnable {

	private static boolean joy;

	public void run() {
		guardedJoy();
	}

	public synchronized void guardedJoy() {
		// This guard only loops once for each special event, which may not
		// be the event we're waiting for.
		while (!joy) {
			try {
				System.out.println(Thread.currentThread().getName() + " Before Notify.");
				wait();
				System.out.println(Thread.currentThread().getName() + " After Notify");
			} catch (InterruptedException e) {
			}
		}
		System.out.println(Thread.currentThread().getName() + " Joy and efficiency have been achieved!");
	}

	public synchronized void notifyJoy() {
		joy = true;
		notifyAll();
	}

	public static void main(String[] args) {
		WaitNotifyThread thread0 = new WaitNotifyThread();
		Thread thread1 = new Thread(thread0);
		thread1.start();

		try {
			System.out.println(Thread.currentThread().getName() + " Sleep 1s");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() + " Notify thread.");
		thread0.notifyJoy();
	}
}
