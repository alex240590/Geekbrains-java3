public class MainClassThreads {
    private final Object monitor = new Object();
    private volatile char currentLetter = 'A';
    private static char letterA = 'A';
    private static char letterB = 'B';
    private static char letterC = 'C';

    public static void main(String[] args) {
        MainClassThreads mCT = new MainClassThreads();
        Thread t1 = new Thread(() -> {
            mCT.print(letterA, letterB);
        });
        Thread t2 = new Thread(() -> {
            mCT.print(letterB, letterC);
        });
        Thread t3 = new Thread(() -> {
            mCT.print(letterC, letterA);
        });
        t1.start();
        t2.start();
        t3.start();
    }

    public void print(char A, char B) {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != A) {
                        monitor.wait();
                    }
                    System.out.print(A);
                    currentLetter = B;
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
