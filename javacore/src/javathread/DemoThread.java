package javathread;

public class DemoThread extends Thread {
    static class MyThread extends Thread {
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("Thread đang chạy (sử dụng lớp Thread)...");
                try {
                    Thread.sleep(1000); // Tạm dừng thread trong 1 giây
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Sử dụng giao diện Runnable
    static class MyRunnable implements Runnable {
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("Thread đang chạy (sử dụng giao diện Runnable)...");
                try {
                    Thread.sleep(1000); // Tạm dừng thread trong 1 giây
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        // Sử dụng lớp Thread
        MyThread myThread = new MyThread();
        myThread.start();

        // Sử dụng giao diện Runnable
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        // Kiểm tra khi nào thread đã hoàn thành dùng join()
        try {
            myThread.join();
            System.out.println("Thread sử dụng lớp Thread đã hoàn thành.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            thread.join();
            System.out.println("Thread sử dụng giao diện Runnable đã hoàn thành.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Kiểm tra khi nào thread đã hoàn thành dùng isAlive()
//        while (myThread.isAlive() || thread.isAlive()) {
//                // Chờ cho cả hai thread kết thúc
//        }
//        System.out.println("Cả hai thread đã hoàn thành.");
    }
}
