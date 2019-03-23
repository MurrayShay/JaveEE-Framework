package murray.shay.fanoutexchange;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutReceiverA {

	@RabbitListener(queues="queueA")
	public void process(String messgae) {
		System.err.println("Receiver queueA msg:" + messgae);
	}
}
