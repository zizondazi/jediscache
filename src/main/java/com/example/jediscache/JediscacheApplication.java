package com.example.jediscache;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class JediscacheApplication implements ApplicationRunner {

	private final UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(JediscacheApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		userRepository.save(User.builder()
					.name("John Doe")
					.eamil("JohnDoe@gmail.com")
					.build()
		);
		userRepository.save(User.builder()
				.name("aaa")
				.eamil("aaa@gmail.com")
				.build()
		);
		userRepository.save(User.builder()
				.name("Jbbbb")
				.eamil("bbb@gmail.com")
				.build()
		);
		userRepository.save(User.builder()
				.name("Jcccc")
				.eamil("ccc@gmail.com")
				.build()
		);
		userRepository.save(User.builder()
				.name("ddd")
				.eamil("ddd@gmail.com")
				.build()
		);
	}
}
