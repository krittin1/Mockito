package csku.mockitodemo.pubsub;

import java.util.ArrayList;
import java.util.List;

public class DefaultPublisher implements Publisher {

    private List<Subscriber> subscribers;

    public DefaultPublisher() {
        subscribers = new ArrayList<>();
    }

    @Override
    public void add(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void publish(String message) {
        for (Subscriber subscriber : subscribers) {
            subscriber.receive(message);
        }
    }
}
