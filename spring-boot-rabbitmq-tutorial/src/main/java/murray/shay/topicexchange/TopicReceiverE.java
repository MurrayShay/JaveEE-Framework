package murray.shay.topicexchange;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicReceiverE {

	@RabbitListener(queues="queueE")
	public void process(String messgae) {
		System.err.println("Receiver queueE msg:" + messgae);
	}
}
