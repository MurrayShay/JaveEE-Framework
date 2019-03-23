package murray.shay.topicexchange;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicReceiverD {

	@RabbitListener(queues="queueD")
	public void process(String messgae) {
		System.err.println("Receiver queueD msg:" + messgae);
	}
}
