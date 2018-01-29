package tutorial.java.thread.immutable;

public class RGBExample implements Runnable {

	private static SynchronizedRGB color;

	public RGBExample(SynchronizedRGB color) {
		this.color = color;
	}

	public void run() {
		while (true) {
			int myColorInt = color.getRGB();
			String myColorName = color.getName();
			System.out.println(myColorName + ":" + myColorInt);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		color = new SynchronizedRGB(0, 0, 0, "Pitch Black");
		RGBExample rgb = new RGBExample(color);
		Thread thread1 = new Thread(rgb);
		thread1.start();

		Thread thread2 = new Thread() {
			public void run() {
				for(int i=1; i<=256; i++) {
					color.set(i, i, i, ""+i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}				
			}
		};
		thread2.start();
	}
}
