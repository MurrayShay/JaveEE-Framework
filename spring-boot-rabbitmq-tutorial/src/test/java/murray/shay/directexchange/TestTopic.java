package murray.shay.directexchange;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import murray.shay.topicexchange.TopicSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTopic {

	@Autowired
	private TopicSender sender;

	@Test
	public void topicSender() {
		System.err.println("第一次測試");
		sender.send();
		System.err.println("第二次測試");
		sender.send2();
	}
}
