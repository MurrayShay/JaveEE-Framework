package murray.shay.directexchange;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;

@Component
public class DirectReceiverF {

	@RabbitListener(queues = "queueF", containerFactory = "rabbitListenerContainerFactory")
	public void consumer1(String messgae,Channel channel) {
		System.err.println("Channel number info:" + channel.getChannelNumber());
		System.err.println("Threadid:" + Thread.currentThread().getId());
		System.err.println("consumer1 Receiver queueF msg:" + messgae );
	}
	
	@RabbitListener(queues = "queueF", containerFactory = "rabbitListenerContainerFactory2")
	public void consumer2(String messgae,Channel channel) {
		System.err.println("Channel info:" + channel.getChannelNumber());
		System.err.println("Threadid:" + Thread.currentThread().getId());
		System.err.println("consumer2 Receiver queueF msg:" + messgae );
	}
}
