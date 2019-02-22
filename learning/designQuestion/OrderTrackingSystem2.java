package learning.designQuestion;
import java.util.*;

 class Order {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return new Date();
    }

    public Order(int id) {
        this.id = id;
    }
}

 interface Event {
    Class<? extends Event> getType();
}

interface Handler<E extends Event> {
    public void onEvent(E event);
}

 class DeliveryBoy {
    private String name;

    public DeliveryBoy(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

 abstract class AbstractEvent implements Event {
    public Class<? extends Event> getType() {
        return getClass();
    }
}



 class EventDispatcher {
    private Map<Class<? extends Event>, Handler<? extends Event>> handlers;

    public EventDispatcher() {
        handlers = new HashMap<>();
    }

    public <E extends Event> void registerHandler(Class<E> eventType, Handler<E> handler) {
        handlers.put(eventType, handler);
    }

    public <E extends Event> void dispatch(E event) {
        Handler<E> handler = (Handler<E>) handlers.get(event.getClass());

        if (handler != null) {
            handler.onEvent(event);
        }
    }
}

 class OrderReceivedEvent extends AbstractEvent {
    private Order order;

    public OrderReceivedEvent(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return this.order;
    }
}

 class UserAssignedEvent extends AbstractEvent {
    private DeliveryBoy boy;
    private Order order;

    public UserAssignedEvent(DeliveryBoy boy, Order order) {
        this.boy = boy;
        this.order = order;
    }

    public DeliveryBoy getDeliveryBoy() {
        return this.boy;
    }
    public Order getOrder() { return this.order; }
}

 class OrderPickedUpEvent extends AbstractEvent {
    private Order order;

    public OrderPickedUpEvent(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return this.order;
    }
}

 class OrderDeliveredEvent extends AbstractEvent {
    private Order order;
    private DeliveryBoy boy;

    public OrderDeliveredEvent(DeliveryBoy boy, Order order) {
        this.order = order;
        this.boy = boy;
    }

    public Order getOrder() {
        return this.order;
    }

    public DeliveryBoy getDeliveryBoy() {
        return this.boy;
    }
}

 class OrderReceivedEventHandler implements Handler<OrderReceivedEvent> {
    @Override
    public void onEvent(OrderReceivedEvent event) {
        System.out.println("Order ID - " + event.getOrder().getId() + " - Received on Date - " + event.getOrder().getDate());
    }
}

 class UserAssignedEventHandler implements Handler<UserAssignedEvent> {
    @Override
    public void onEvent(UserAssignedEvent event) {
        System.out.println("Delivery boy - " + event.getDeliveryBoy().getName() + " - is assigned to the Order ID - " + event.getOrder().getId());
    }
}

 class OrderPickedUpEventHandler implements Handler<OrderPickedUpEvent> {
    @Override
    public void onEvent(OrderPickedUpEvent event) {
        System.out.println("Order ID - " + event.getOrder().getId() + " - picked up on Date - " + event.getOrder().getDate());
    }
}

 class OrderDeliveredEventHandler implements Handler<OrderDeliveredEvent> {
    @Override
    public void onEvent(OrderDeliveredEvent event) {
        System.out.println("Order ID - " + event.getOrder().getId() + " - delivered on Date - " + event.getOrder().getDate() + " - by Delivery Boy - " + event.getDeliveryBoy().getName());
        System.out.println();
    }
}

public class OrderTrackingSystem2 {
    public static void main(String[] args) {
        Queue<String> deliveryBoys = new LinkedList<>();
        String[] nameOfDeliveryBoys = {"Tom", "Dick", "Harry", "Gordon", "Leon", "Michael"};

        for (int i = 0; i < 10; i ++) {
            deliveryBoys.add(nameOfDeliveryBoys[(int)(Math.random() * nameOfDeliveryBoys.length)]);
        }

        Queue<Order> orders = new LinkedList<>();

        for (int j = 1; j <= 10; j++) {
            orders.add(new Order(j));
        }

        EventDispatcher dispatcher = new EventDispatcher();

        dispatcher.registerHandler(OrderReceivedEvent.class, new OrderReceivedEventHandler());
        dispatcher.registerHandler(UserAssignedEvent.class, new UserAssignedEventHandler());
        dispatcher.registerHandler(OrderPickedUpEvent.class, new OrderPickedUpEventHandler());
        dispatcher.registerHandler(OrderDeliveredEvent.class, new OrderDeliveredEventHandler());

        while(!orders.isEmpty()) {
            DeliveryBoy deliveryBoy = new DeliveryBoy(deliveryBoys.poll());
            Order currentOrder = orders.poll();

            dispatcher.dispatch(new OrderReceivedEvent(currentOrder));
            dispatcher.dispatch(new UserAssignedEvent(deliveryBoy, currentOrder));
            dispatcher.dispatch(new OrderPickedUpEvent(currentOrder));
            dispatcher.dispatch(new OrderDeliveredEvent(deliveryBoy, currentOrder));
        }
    }
}