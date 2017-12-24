package me.digitalsonic.tryspring5;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.lang.NonNull;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RedisHash
public class Book implements Serializable {
    @NonNull
    @Id
    private String id;
    @NonNull
    private String title;
    @NonNull
    private String author;

    public Book(String id) {
        this(id, "Title_" + id, "Author_" + id);
    }
}
