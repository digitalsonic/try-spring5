package me.digitalsonic.tryspring5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TrySpring5ApplicationTests {
	@Autowired
	private WebTestClient webTestClient;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testKingsman() {
		webTestClient.get().uri("/books/kingsman").exchange()
				.expectStatus().isOk()
				.expectBody().equals("Manners Maketh Man");
	}
}
