package basics;

import java.lang.invoke.MethodHandles;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(MethodHandles.class.getName());
	static {
		try {
			log.info("Starting the h2 Database Server.");
			org.h2.tools.Server.createTcpServer().start();
			log.info("Server Started.");
		} catch (SQLException e) {
			log.info("Server starting failed due to Exception.Cause is " + e.getClass().getSimpleName());
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
