package murray.shay.fanoutexchange;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutReceiverC {

	@RabbitListener(queues="queueC")
	public void process(String messgae) {
		System.err.println("Receiver queueC msg:" + messgae);
	}
}
