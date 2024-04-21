package br.com.igorborba.userapi;

import br.com.igorborba.userapi.entities.User;
import br.com.igorborba.userapi.repositories.UserRepository;
import com.netflix.discovery.EurekaNamespace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class UserApiApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(UserApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.saveAll(List.of(new User( "Igor", "igor@hotmail.com", "123456", 30.0),
                                       new User( "Luiza", "luiza@hotmail.com", "456789", 20.0)));
    }
}
