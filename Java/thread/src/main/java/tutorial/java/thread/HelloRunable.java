package tutorial.java.thread;

public class HelloRunable implements Runnable {

	private int count;

	public void run() {
		while (count < 100) {
			count++;
			System.out.println(Thread.currentThread().getName() + " is running... " + count);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Runnable helloRunnable = new HelloRunable();

		Thread runnableThread1 = new Thread(helloRunnable);
		Thread runnableThread2 = new Thread(helloRunnable);
		Thread runnableThread3 = new Thread(helloRunnable);

		// start runnable thread -> implements Runnable make 3 threads use the
		// same HelloRunable object
		runnableThread1.start();
		runnableThread2.start();
		runnableThread3.start();
	}

}
