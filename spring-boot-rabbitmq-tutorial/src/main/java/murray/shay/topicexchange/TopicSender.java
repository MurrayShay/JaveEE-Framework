package murray.shay.topicexchange;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSender {

	@Autowired
	private AmqpTemplate amqpTemplate;

	public void send() {
		String context = "test topic1 (routingKey=topic.message)";
		System.err.println("===>" + context);
		amqpTemplate.convertAndSend("topicExchange", "topic.message", context);
	}
	
	public void send2() {
		String context = "test topic2 (routingKey=topic.test)";
		System.err.println("===>" + context);
		amqpTemplate.convertAndSend("topicExchange", "topic.test", context);
	}
}
