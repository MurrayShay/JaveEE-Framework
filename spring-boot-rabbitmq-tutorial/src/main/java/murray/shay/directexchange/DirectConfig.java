package murray.shay.directexchange;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ChannelListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.client.Channel;

@Configuration
public class DirectConfig {

	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		try {
			connectionFactory.setAddresses("127.0.0.1");
			connectionFactory.setPort(5672);
			connectionFactory.setUsername("guest");
			connectionFactory.setPassword("guest");
			connectionFactory.setChannelCacheSize(2);
			System.err
					.println("connectionFactory.getChannelCacheSize(); 數量:" + connectionFactory.getChannelCacheSize());
			connectionFactory.addChannelListener(new ChannelListener() {
				@Override
				public void onCreate(Channel channel, boolean transactional) {
					System.err.println("ChannelNumber:" + channel.getChannelNumber());
					System.err.println("transactional:" + transactional);

				}
			});

//			connectionFactory.setCacheMode(CacheMode.CONNECTION);
//			Connection c = connectionFactory.createConnection();
//			Channel channel = c.createChannel(true);

		} catch (Exception e) {
			System.err.println("Call connectionFactory throw Exception. " + e);
		}
		return connectionFactory;
	}

	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
//        template.setMessageConverter(new Jackson2JsonMessageConverter());
		return template;
	}

	/**
	 * 
	 * https://stackoverflow.com/questions/47903878/registering-a-listener-service-with-setmessagelistener
	 * 
	 * @param connectionFactory
	 * @return
	 */
	@Bean
	public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		factory.setConcurrentConsumers(1);
		factory.setMaxConcurrentConsumers(1);
//        factory.setMessageConverter(new Jackson2JsonMessageConverter());
		return factory;
	}

	@Bean
	public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory2(ConnectionFactory connectionFactory) {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		factory.setConcurrentConsumers(1);
		factory.setMaxConcurrentConsumers(1);

//        factory.setMessageConverter(new Jackson2JsonMessageConverter());
		return factory;
	}

	@Bean
	public Queue FQueue() {
		return new Queue("queueF");
	}

	@Bean
	public Queue GQueue() {
		return new Queue("queueG");
	}

	@Bean
	public DirectExchange directExchange() {
		return new DirectExchange("directExchange");
	}

	@Bean
	public Binding bindingExchangeF(Queue FQueue, DirectExchange exchange) {
		return BindingBuilder.bind(FQueue).to(exchange).with("directF");
	}

	@Bean
	public Binding bindingExchangeG(Queue GQueue, DirectExchange exchange) {
		return BindingBuilder.bind(GQueue).to(exchange).with("directG");
	}
}
