package tutorial.java.thread;

public class HelloRunable implements Runnable {

	public void run() {
		String[] array = { "Java", "Spring", "Hibernate", "Oracle" };
		for (String tech : array) {
			try {
				if (Thread.interrupted())
					System.out.println("Thread is interrupted.");
				// sleep for 2s
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage() + ". Stop all activities.");
				return;
			}

			// print tech
			System.out.println(tech);
		}
	}

	public static void main(String[] args) {
		Runnable helloRunnable = new HelloRunable();
		Thread runnableThread = new Thread(helloRunnable);
		// start runnable thread
		runnableThread.start();

		Thread interruptedThread = new Thread() {

			@Override
			public void run() {
				try {
					// sleep for 5s then interrupt hello thread
					Thread.sleep(5000);
					runnableThread.interrupt();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		interruptedThread.start();
	}

}
