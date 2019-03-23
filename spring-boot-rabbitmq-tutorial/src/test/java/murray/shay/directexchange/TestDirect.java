package murray.shay.directexchange;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDirect {

	@Autowired
	private DirectSender send;

	@Test
	public void directSender() {
		Long s = new Date().getTime();
		for (int i = 1; i < 3; i++) {
			send.send();
		}
		Long e = new Date().getTime();
		Long total = e - s;
		System.err.println("Total Time: " + total);
		for (int i = 1; i < 3; i++) {
			send.send2();
		}
	}
}