package tutorial.java.thread;

public class VolatileTest {

	// The volatile keyword is used to say to the jvm "Warning, this variable
	// may be modified in an other Thread"
	// The volatile force the thread to update the original variable for each
	// variable.
	// If a variable is declared with the volatile keyword then it is guaranteed
	// that any thread that reads the field will see the most recently written
	// value. The volatile keyword will not perform any mutual exclusive lock on
	// the variable.
	private static volatile int MY_INT = 0;

	public static void main(String[] args) {
		new ChangeListener().start();
		new ChangeMaker().start();
	}

	static class ChangeListener extends Thread {
		@Override
		public void run() {
			int local_value = MY_INT;
			while (local_value < 5) {
				if (local_value != MY_INT) {
					System.out.println("Got Change for MY_INT : " + MY_INT);
					System.out.println();
					local_value = MY_INT;
				}
			}
		}
	}

	static class ChangeMaker extends Thread {
		@Override
		public void run() {

			int local_value = MY_INT;
			while (MY_INT < 5) {
				System.out.println("Incrementing MY_INT to " + (local_value + 1));
				MY_INT = ++local_value;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
