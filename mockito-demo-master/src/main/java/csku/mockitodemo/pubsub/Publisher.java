package csku.mockitodemo.pubsub;

public interface Publisher {
    void add(Subscriber subscriber);
    void publish(String message);

}
