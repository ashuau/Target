package learning.designQuestion;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class OrderTrackingSystem {


    public static interface Observer<T> {
        public void onChange(T subject);
    }

    public static interface Subject<T>{
        public boolean registerObserver(Observer<T> observer);
        public void notifyAllObservers();
        public boolean deleteObserver(Observer<T> observer);
    }

    public static enum OrderStatus {
        Received("Received"),
        Assigned("Assigned"),
        Delivered("Delivered"),
        PickedUp("PickedUp");

        public String description;

        OrderStatus(String description) {
            this.description = description;
        }
    }

    public static class DeliveryBoy {
        private int id;
        private String name;

        public DeliveryBoy(int id, String name){
            this.id = id;
            this.name = name;
        }
    }

    public static class Order implements Subject<Order> {

        private ArrayList<Observer<Order>> observers;
        private final int id;
        private Date expectedTime;
        private OrderStatus status;
        private DeliveryBoy deliveryBoy;

        public Order(int id, Date expectedTime){
            this.observers = new ArrayList<Observer<Order>>();
            this.id = id;
            this.expectedTime = expectedTime;
        }

        public int getId(){
            return this.id;
        }

        public void assignDeliveryBoy(DeliveryBoy deliveryBoy) {
            this.deliveryBoy = deliveryBoy;
            this.setStatus(OrderStatus.Assigned);
        }

        public void setStatus(OrderStatus status) {
            this.status = status;
            this.notifyAllObservers();
        }

        @Override
        public boolean registerObserver(Observer<Order> observer) {
            if(!this.observers.contains(observer)) {
                this.observers.add(observer);
                return true;
            }
            return false;
        }

        @Override
        public boolean deleteObserver(Observer<Order> observer) {
            return this.observers.remove(observer);
        }

        @Override
        public void notifyAllObservers() {
            for(Observer<Order> observer:this.observers) {
                observer.onChange(this);
            }
        }
    }

    public static class OrderManager implements Observer<Order> {

        private ArrayList<Order> orders;

        public OrderManager() {
            this.orders = new ArrayList<Order>();
        }

        public boolean addOrder(Order order) {
            if(!this.orders.contains(order)){
                this.orders.add(order);
                order.registerObserver(this);
                order.setStatus(OrderStatus.Received);
                return true;
            }

            return false;
        }

        @Override
        public void onChange(Order subject) {

            String msg = String.format("Order #%d status changed - %s",
                    subject.getId(),
                    subject.status.description);
            System.out.println(msg);
        }

    }

    public static void main(String[] args) {
        OrderManager orderManager = new OrderManager();
        DeliveryBoy mainDeliveryBoy = new DeliveryBoy(100, "Main Delivery Boy");

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, 2);
        Date date1 = cal.getTime();

        Order order1 = new Order(1, date1);

        //Order Received
        orderManager.addOrder(order1);

        //Order Assigned
        order1.assignDeliveryBoy(mainDeliveryBoy);

        //Order Delivered
        order1.setStatus(OrderStatus.Delivered);

        //Picked Up
        order1.setStatus(OrderStatus.PickedUp);

    }

}