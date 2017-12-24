package me.digitalsonic.tryspring5;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Slf4j
public class DataInitializerRunner implements ApplicationRunner{
    @Autowired
    private StandardBookRepository bookRepository;
    @Autowired
    private ReactiveRedisTemplate redisTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Arrays.asList(1, 2, 3).stream()
                .forEach(i -> {
                    redisTemplate.opsForValue()
                            .set(i.toString(), new Book(i.toString()))
                            .subscribe(b -> log.info("Save book {} OK? {}", i, b));
                    bookRepository.save(new Book(i.toString()));
                });
    }
}
