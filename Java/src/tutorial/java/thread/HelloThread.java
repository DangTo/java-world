package tutorial.java.thread;

public class HelloThread extends Thread {

	public void run() {
		System.out.println("Thead is running...");
	}

	public static void main(String[] args) {
		Thread helloThread = new HelloThread();
		// start thread
		helloThread.start();
	}

}
