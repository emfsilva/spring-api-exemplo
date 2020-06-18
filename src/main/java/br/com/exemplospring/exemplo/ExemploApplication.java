package br.com.exemplospring.exemplo;

import br.com.exemplospring.exemplo.entity.User;
import br.com.exemplospring.exemplo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class ExemploApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExemploApplication.class, args);
    }
}