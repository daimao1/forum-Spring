package com.damiankoziel.forum;

import com.damiankoziel.forum.commons.Category;
import com.damiankoziel.forum.domain.Post;
import com.damiankoziel.forum.service.PostService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ForumApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForumApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(PostService postService) {
        return args -> {
            List<Category> categories = new ArrayList<>();
            categories.add(Category.CELEBRITY);
            categories.add(Category.PEOPLE);
            postService.create(new Post(1L, "Lana Del Rey",
                    "Lana Del Rey, właśc. Elizabeth Woolridge Grant – amerykańska wokalistka indierockowa, " +
                            "kompozytorka i autorka tekstów piosenek aktywna w przemyśle muzycznym od 2005 roku.Lana Del Rey\",\n" +
                            "                    \"Lana Del Rey, właśc. Elizabeth Woolridge Grant – amerykańska wokalistka indierockowa, \" +\n" +
                            "                            \"kompozytorka i autorka tekstów piosenek aktywna w przemyśle muzycznym od 2005 roku." +
                            "",
                    LocalDateTime.now(), "http://qultqultury.pl/wp-content/uploads/2015/09/lana-del-rey.jpg", categories, 30));
            postService.create(new Post(2L, "Lana Del Rey",
                    "Lana Del Rey, właśc. Elizabeth Woolridge Grant – amerykańska wokalistka indierockowa, " +
                            "kompozytorka i autorka tekstów piosenek aktywna w przemyśle muzycznym od 2005 roku.Lana Del Rey\",\n" +
                            "                    \"Lana Del Rey, właśc. Elizabeth Woolridge Grant – amerykańska wokalistka indierockowa, \" +\n" +
                            "                            \"kompozytorka i autorka tekstów piosenek aktywna w przemyśle muzycznym od 2005 roku.",
                    LocalDateTime.now(), "http://qultqultury.pl/wp-content/uploads/2015/09/lana-del-rey.jpg", categories, 40));
            postService.create(new Post(3L, "Lana Del Rey",
                    "Lana Del Rey, właśc. Elizabeth Woolridge Grant – amerykańska wokalistka indierockowa, " +
                            "kompozytorka i autorka tekstów piosenek aktywna w przemyśle muzycznym od 2005 roku.Lana Del Rey\",\n" +
                            "                    \"Lana Del Rey, właśc. Elizabeth Woolridge Grant – amerykańska wokalistka indierockowa, \" +\n" +
                            "                            \"kompozytorka i autorka tekstów piosenek aktywna w przemyśle muzycznym od 2005 roku.",
                    LocalDateTime.now(), "http://qultqultury.pl/wp-content/uploads/2015/09/lana-del-rey.jpg", categories, 50));
        };
    }
}
