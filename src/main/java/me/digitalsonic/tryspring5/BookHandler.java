package me.digitalsonic.tryspring5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@SuppressWarnings("unchecked")
@Component
public class BookHandler {
    @Autowired
    private ReactiveRedisTemplate redisTemplate;

    public Mono<ServerResponse> getOneBook(ServerRequest request) {
        String id = request.pathVariable("id");
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(redisTemplate.opsForValue().get(id), Book.class);
    }

    public void setRedisTemplate(ReactiveRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
