package murray.shay.fanoutexchange;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {

	@Bean
	public Queue AQueue() {
		return new Queue("queueA");
	}

	@Bean
	public Queue BQueue() {
		return new Queue("queueB");
	}

	@Bean
	public Queue CQueue() {
		return new Queue("queueC");
	}

	@Bean
	public FanoutExchange fanoutExchange() {
		return new FanoutExchange("fanoutExchange");
	}

	@Bean
	public Binding bindingExchangeA(Queue AQueue, FanoutExchange exchange) {
		return BindingBuilder.bind(AQueue).to(exchange);
	}

	@Bean
	public Binding bindingExchangeB(Queue BQueue, FanoutExchange exchange) {
		return BindingBuilder.bind(BQueue).to(exchange);
	}

	@Bean
	public Binding bindingExchangeC(Queue CQueue, FanoutExchange exchange) {
		return BindingBuilder.bind(CQueue).to(exchange);
	}

}
