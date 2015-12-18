public class DeadlockSolution {
	public static Object resource1 = new Object();
	public static Object resource2 = new Object();

	private static class ThreadDemo1 extends Thread {
		public void run() {
			synchronized (resource1) {
				System.out.println("Thread 1: Holding resource 1...");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
				}
				System.out.println("Thread 1: Waiting for resource 2...");
				synchronized (resource2) {
					System.out.println("Thread 1: Holding resource 1 & 2...");
				}
			}
		}
	}

	private static class ThreadDemo2 extends Thread {
		public void run() {
			synchronized (resource1) {
				System.out.println("Thread 2: Holding resource 1...");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
				}
				System.out.println("Thread 2: Waiting for resource 2...");
				synchronized (resource2) {
					System.out.println("Thread 2: Holding resource 1 & 2...");
				}
			}
		}
	}

	public static void main(String args[]) {

		ThreadDemo1 T1 = new ThreadDemo1();
		ThreadDemo2 T2 = new ThreadDemo2();
		T1.start();
		T2.start();
	}
}
