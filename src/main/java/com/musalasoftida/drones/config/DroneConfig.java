package com.musalasoftida.drones.config;

import com.musalasoftida.drones.book.Book;
import com.musalasoftida.drones.book.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class DroneConfig {

    @Bean
    CommandLineRunner commandLineRunner(BookRepository bookRepository) {
        return args -> {


            bookRepository.saveAll(
                    List.of(new Book(
                            "The Alchemist",
                            "Heavy"


                    ), new Book(
                            "The Alchemist 2",
                            "Light"

                    ), new Book(
                            "The Alchemist 3",
                            "Medium"

                    ))
            );
        };
    }
}
