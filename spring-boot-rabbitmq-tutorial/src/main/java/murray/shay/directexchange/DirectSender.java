package murray.shay.directexchange;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DirectSender {

	@Autowired
	private RabbitTemplate amqpTemplate;

	public void send() {
		String context = "送訊息到queueF(rk=走directF)";
		System.err.println("===>" + context);
		amqpTemplate.convertAndSend("directExchange", "directF", context);
	}
	
	public void send2() {
		String context = "送訊息到queueG(rk=走directG)";
		System.err.println("===>" + context);
		amqpTemplate.convertAndSend("directExchange", "directG", context);
	}
}
