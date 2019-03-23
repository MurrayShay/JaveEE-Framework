package murray.shay.directexchange;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import murray.shay.fanoutexchange.FanoutSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestFanout {
	
	@Autowired
	private FanoutSender send;

	@Test
	public void fanoutSender() {
		send.sent();
	}
}
