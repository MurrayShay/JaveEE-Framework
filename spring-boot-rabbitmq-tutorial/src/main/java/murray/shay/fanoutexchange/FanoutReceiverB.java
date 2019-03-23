package murray.shay.fanoutexchange;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutReceiverB {

	@RabbitListener(queues="queueB")
	public void process(String messgae) {
		System.err.println("Receiver queueB msg:" + messgae);
	}
}
