package junhokama.com.github.springmock;

import junhokama.com.github.springmock.model.PhotoConsumerFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringMockApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringMockApplication.class, args);
	}

	@Autowired
	private PhotoConsumerFeign photoConsumerFeign;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(
			this.photoConsumerFeign.getPhotosById(3L)
		);
	}
}
