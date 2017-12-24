package me.digitalsonic.tryspring5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebClientTests {
    @LocalServerPort
    private int port;

    @Test
    public void testBooksId() {
        WebClient webClient = WebClient.create("http://localhost:" + port);
        Mono<ClientResponse> response = webClient.get()
                .uri("/books/1")
                .accept(MediaType.APPLICATION_JSON)
                .exchange();
        Book book = response.flatMap(res -> res.bodyToMono(Book.class)).block();
        assertEquals("1", book.getId());
    }
}
