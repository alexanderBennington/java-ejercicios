package alexander.rrhh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class RrhhApplication {

	public static void main(String[] args) {
		SpringApplication.run(RrhhApplication.class, args);
	}

}
