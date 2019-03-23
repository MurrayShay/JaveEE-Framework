package murray.shay.fanoutexchange;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender {

	@Autowired
	private AmqpTemplate amqpTemplate;

	public void sent() {
		String context = "test fanout sent msg.";
		System.err.println("===>" + context);
		
		amqpTemplate.convertAndSend("fanoutExchange", "", context);
	}

}
