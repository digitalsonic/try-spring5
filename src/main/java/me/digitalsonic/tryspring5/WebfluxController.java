package me.digitalsonic.tryspring5;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
@Slf4j
public class WebfluxController {
    @Autowired
    private ReactiveRedisTemplate redisTemplate;

    @GetMapping("/{id}")
    public Mono<Book> getOne(@PathVariable String id) {
        return redisTemplate.opsForValue().get(id);
    }

    @GetMapping("/")
    public Flux<String> getList() {
        return redisTemplate.keys("*").sort().map(k -> "key=" + k + ";");
    }

    @RequestMapping("/kingsman")
    public Mono<String> god() {
        return Mono.just("Manners Maketh Man");
    }
}
