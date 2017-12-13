package tutorial.java.thread;

public class HelloThread extends Thread {

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
		Thread helloThread1 = new HelloThread();
		Thread helloThread2 = new HelloThread();
		Thread helloThread3 = new HelloThread();
		// start thread -> extends Thread makes 3 different HelloThread objects
		helloThread1.start();
		helloThread2.start();
		helloThread3.start();
	}

}
