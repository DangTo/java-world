package tutorial.java.thread;

public class SleepMessages {

	public static void main(String[] args) throws InterruptedException {
		String[] array = { "Java", "Spring", "Hibernate", "Oracle" };
		for (String tech : array) {
			// sleep for 2s
			Thread.sleep(2000);

			// print tech
			System.out.println(tech);
			Thread.interrupted();
		}
	}
}
