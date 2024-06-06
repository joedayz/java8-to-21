package pe.joedayz.training.collections.reactive;

import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;
import java.util.stream.IntStream;

public class FlowTest {

    public static void main(String[] args) throws InterruptedException {
        try(SubmissionPublisher<String> publisher = new SubmissionPublisher<>()){
            publisher.subscribe(new MySubscriber());

            IntStream.range(0, 15)
                    .mapToObj(String::valueOf)
                    .forEach(publisher::submit);
        }
        Thread.sleep(100000);
    }
}

class MySubscriber implements Subscriber<String> {

    private Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        requestItem(subscription);
    }

    @Override
    public void onNext(String item) {
        System.out.println("Received item: " + item);
        requestItem(subscription);
    }

    @Override
    public void onError(Throwable err) {
        System.out.println("Error: " + err.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("Completed");
    }

    private void requestItem(Subscription subscription) {
        System.out.println("Requesting 1 item...");
        subscription.request(1);
    }
}
