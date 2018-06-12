package com.damiankoziel.forum;

import com.damiankoziel.forum.commons.Category;
import com.damiankoziel.forum.commons.RoleName;
import com.damiankoziel.forum.domain.Comment;
import com.damiankoziel.forum.domain.Post;
import com.damiankoziel.forum.domain.Role;
import com.damiankoziel.forum.repository.RoleRepository;
import com.damiankoziel.forum.service.CommentService;
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
    CommandLineRunner runner(PostService postService, CommentService commentService, RoleRepository roleRepository) {
        return args -> {

            //Load posts
            List<Category> categories = new ArrayList<>();
            categories.add(Category.CELEBRITY);
            categories.add(Category.PEOPLE);
            Post post1 = new Post(4L, "Lana Del Rey",
                    "amerykańska wokalistka indierockowa, kompozytorka i autorka tekstów piosenek[10] aktywna w przemyśle muzycznym" +
                            " od 2005 roku[11]. Jej pseudonim artystyczny jest połączeniem imienia hollywoodzkiej gwiazdy Lany Turner i nazwy" +
                            " Forda Del Rey[10][12]. Nazywana gangsta Nancy Sinatra (ang. „gangsterska Nancy Sinatra”)[9][13][14][15] przez krytyków" +
                            " muzycznych. Była trzykrotnie nominowana do nagrody Grammy. Dwukrotnie w 2014 roku w kategorii „Najlepszy album pop” za" +
                            " minialbum Paradise oraz w kategorii „Najlepsza piosenka filmowa” za utwór „Young and Beautiful”[16]. W 2016 roku uzyskała" +
                            " nominację wraz z The Weeknd do tejże nagrody w kategorii „Album roku” za wydawnictwo zatytułowane Beauty Behind the Madness," +
                            " które współtworzyła wraz z nim i wieloma innymi artystami[17]. W 2015 roku otrzymała nominację do Złotego Globu w kategorii" +
                            " „Najlepsza piosenka” za utwór „Big Eyes” wykorzystany w filmie Wielkie oczy[18]. Jej debiutancki album Born to Die rozszedł" +
                            " się w nakładzie 7 milionów egzemplarzy na całym świecie[19][20], zaś album Ultraviolence w ponadmilionowym nakładzie[21]." +
                            " Według Nielsen SoundScan szacowany nakład ze sprzedaży utworów Del Rey w samych Stanach Zjednoczonych wynosi 4 miliony 500" +
                            " tysięcy egzemplarzy[22]. ",
                    LocalDateTime.now(), "http://qultqultury.pl/wp-content/uploads/2015/09/lana-del-rey.jpg", categories, 30);
            Post post2 = new Post(5L, "Lana Del Rey",
                    "amerykańska wokalistka indierockowa, kompozytorka i autorka tekstów piosenek[10] aktywna w przemyśle muzycznym" +
                            " od 2005 roku[11]. Jej pseudonim artystyczny jest połączeniem imienia hollywoodzkiej gwiazdy Lany Turner i nazwy" +
                            " Forda Del Rey[10][12]. Nazywana gangsta Nancy Sinatra (ang. „gangsterska Nancy Sinatra”)[9][13][14][15] przez krytyków" +
                            " muzycznych. Była trzykrotnie nominowana do nagrody Grammy. Dwukrotnie w 2014 roku w kategorii „Najlepszy album pop” za" +
                            " minialbum Paradise oraz w kategorii „Najlepsza piosenka filmowa” za utwór „Young and Beautiful”[16]. W 2016 roku uzyskała" +
                            " nominację wraz z The Weeknd do tejże nagrody w kategorii „Album roku” za wydawnictwo zatytułowane Beauty Behind the Madness," +
                            " które współtworzyła wraz z nim i wieloma innymi artystami[17]. W 2015 roku otrzymała nominację do Złotego Globu w kategorii" +
                            " „Najlepsza piosenka” za utwór „Big Eyes” wykorzystany w filmie Wielkie oczy[18]. Jej debiutancki album Born to Die rozszedł" +
                            " się w nakładzie 7 milionów egzemplarzy na całym świecie[19][20], zaś album Ultraviolence w ponadmilionowym nakładzie[21]." +
                            " Według Nielsen SoundScan szacowany nakład ze sprzedaży utworów Del Rey w samych Stanach Zjednoczonych wynosi 4 miliony 500" +
                            " tysięcy egzemplarzy[22]. ", LocalDateTime.now(), "http://qultqultury.pl/wp-content/uploads/2015/09/lana-del-rey.jpg", categories, 40);
            Post post3 = new Post(6L, "Lana Del Rey",
                    "amerykańska wokalistka indierockowa, kompozytorka i autorka tekstów piosenek[10] aktywna w przemyśle muzycznym" +
                            " od 2005 roku[11]. Jej pseudonim artystyczny jest połączeniem imienia hollywoodzkiej gwiazdy Lany Turner i nazwy" +
                            " Forda Del Rey[10][12]. Nazywana gangsta Nancy Sinatra (ang. „gangsterska Nancy Sinatra”)[9][13][14][15] przez krytyków" +
                            " muzycznych. Była trzykrotnie nominowana do nagrody Grammy. Dwukrotnie w 2014 roku w kategorii „Najlepszy album pop” za" +
                            " minialbum Paradise oraz w kategorii „Najlepsza piosenka filmowa” za utwór „Young and Beautiful”[16]. W 2016 roku uzyskała" +
                            " nominację wraz z The Weeknd do tejże nagrody w kategorii „Album roku” za wydawnictwo zatytułowane Beauty Behind the Madness," +
                            " które współtworzyła wraz z nim i wieloma innymi artystami[17]. W 2015 roku otrzymała nominację do Złotego Globu w kategorii" +
                            " „Najlepsza piosenka” za utwór „Big Eyes” wykorzystany w filmie Wielkie oczy[18]. Jej debiutancki album Born to Die rozszedł" +
                            " się w nakładzie 7 milionów egzemplarzy na całym świecie[19][20], zaś album Ultraviolence w ponadmilionowym nakładzie[21]." +
                            " Według Nielsen SoundScan szacowany nakład ze sprzedaży utworów Del Rey w samych Stanach Zjednoczonych wynosi 4 miliony 500" +
                            " tysięcy egzemplarzy[22]. ", LocalDateTime.now(), "http://qultqultury.pl/wp-content/uploads/2015/09/lana-del-rey.jpg", categories, 50);

            //Load comments
            Comment comment1 = new Comment(1L, "To jest komentarz numer 1", LocalDateTime.now(), null, post1);
            Comment comment2 = new Comment(1L, "To jest komentarz numer 2", LocalDateTime.now(), null, post2);
            Comment comment3 = new Comment(1L, "To jest komentarz numer 3", LocalDateTime.now(), null, post3);

/*            commentService.create(comment1);
            commentService.create(comment2);
            commentService.create(comment3);*/

            //Load authorities
            Role userRole = new Role();
            userRole.setName(RoleName.ROLE_USER);
            userRole.setId(1L);
            Role adminRole = new Role();
            adminRole.setName(RoleName.ROLE_ADMIN);
            adminRole.setId(2L);
            roleRepository.save(userRole);
            roleRepository.save(adminRole);

        };


    }
}
