package csku.mockitodemo.pubsub;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class PublisherMockTest {

    @Mock private Subscriber subscriber1;
    @Mock private Subscriber subscriber2;

    // class under test (CUT)
    private Publisher publisher;

    @BeforeEach
    void initMocks() {
        MockitoAnnotations.initMocks(this);
        publisher = new DefaultPublisher();
    }

    @Test
    void testPublisher_One_SubscriberReceivesMessage() {

        // using mock object
        String message = "greeting";

        publisher.add(subscriber1);
        publisher.publish(message);

        // "verify"
        verify(subscriber1).receive(message);
    }

    @Test
    void testPublisher_Two_SubscribersReceivesMessage() {

        // using mock object
        String message = "greeting";

        publisher.add(subscriber1);
        publisher.add(subscriber2);
        publisher.publish(message);

        // "verify"
        verify(subscriber1).receive(message);
        verify(subscriber2).receive(message);
    }
}
