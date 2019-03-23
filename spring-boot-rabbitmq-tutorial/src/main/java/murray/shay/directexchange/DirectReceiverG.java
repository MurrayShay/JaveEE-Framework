package murray.shay.directexchange;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;

@Component
public class DirectReceiverG {

	@RabbitListener(queues = "queueG", containerFactory = "rabbitListenerContainerFactory")
	public void process(String messgae, Channel channel) {
		System.err.println("Channel No: " + channel.getChannelNumber());
		System.err.println("Receiver queueG msg:" + messgae + "threadid:" + Thread.currentThread().getId());
	}

}
