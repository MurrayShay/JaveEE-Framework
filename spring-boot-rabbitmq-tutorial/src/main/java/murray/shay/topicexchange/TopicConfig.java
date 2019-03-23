package murray.shay.topicexchange;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfig {
	
	@Bean
	public Queue DQueue() {
		return new Queue("queueD");
	}

	@Bean
	public Queue EQueue() {
		return new Queue("queueE");
	}

	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange("topicExchange");
	}

	@Bean
	public Binding bindingExchangeA(Queue DQueue, TopicExchange exchange) {
		return BindingBuilder.bind(DQueue).to(exchange).with("topic.message");
	}
	
	@Bean
	public Binding bindingExchangeB(Queue EQueue, TopicExchange exchange) {
		return BindingBuilder.bind(EQueue).to(exchange).with("topic.#");
	}

}
