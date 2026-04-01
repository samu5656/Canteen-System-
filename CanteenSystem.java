import java.util.*;

class OrderQueue {
    private Queue<String> orders = new LinkedList<>();

    public synchronized void placeOrder(String order) {
        orders.add(order);
        System.out.println(Thread.currentThread().getName() + " placed: " + order);
        notify();
    }

    public synchronized String getOrder() {
        while (orders.isEmpty()) {
            try {
                System.out.println("Chef waiting for orders...");
                wait();
            } catch (InterruptedException e) {
                System.out.println("Chef interrupted!");
            }
        }
        return orders.poll();
    }
}

class OrderThread extends Thread {
    private OrderQueue queue;

    public OrderThread(OrderQueue q) {
        this.queue = q;
        setName("OrderThread");
    }

    public void run() {
        try {
            String[] items = {"Burger", "Pizza", "Sandwich"};
            for (String item : items) {
                queue.placeOrder(item);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Order interrupted!");
        }
    }
}

class ChefThread extends Thread {
    private OrderQueue queue;

    public ChefThread(OrderQueue q) {
        this.queue = q;
        setName("ChefThread");
        setPriority(MAX_PRIORITY);
    }

    public void run() {
        try {
            while (true) {
                String order = queue.getOrder();
                System.out.println(getName() + " preparing: " + order);
                Thread.sleep(2000);
                System.out.println(getName() + " completed: " + order);
            }
        } catch (InterruptedException e) {
            System.out.println("Chef stopped!");
        }
    }
}

class PaymentThread extends Thread {
    public PaymentThread() {
        setName("PaymentThread");
    }

    public void run() {
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println(getName() + " processing payment...");
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            System.out.println("Payment interrupted!");
        }
    }
}

class NotificationThread extends Thread {
    public NotificationThread() {
        setName("NotificationThread");
        setPriority(MIN_PRIORITY);
    }

    public void run() {
        try {
            while (true) {
                System.out.println(getName() + " sending pickup notification...");
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            System.out.println("Notification stopped!");
        }
    }
}

public class CanteenSystem {
    public static void main(String[] args) {

        OrderQueue queue = new OrderQueue();

        OrderThread order = new OrderThread(queue);
        ChefThread chef = new ChefThread(queue);
        PaymentThread payment = new PaymentThread();
        NotificationThread notify = new NotificationThread();

        order.start();
        chef.start();
        payment.start();
        notify.start();
    }
}