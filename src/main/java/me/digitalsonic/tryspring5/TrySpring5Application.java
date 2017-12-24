package me.digitalsonic.tryspring5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@EnableRedisRepositories
@SpringBootApplication
public class TrySpring5Application {
	public static void main(String[] args) {
		SpringApplication.run(TrySpring5Application.class, args);
	}

	@Bean
	public RouterFunction<?> routerFunction(BookHandler bookHandler) {
		return route(GET("/rf/books/{id}"), bookHandler::getOneBook)
				.and(route(path("/rf/kingsman"),
						request -> ServerResponse.ok().contentType(MediaType.TEXT_HTML)
								.body(BodyInserters.fromObject("Manners Maketh Man"))));
	}
}

