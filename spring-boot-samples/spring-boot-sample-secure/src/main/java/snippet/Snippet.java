package snippet;

public class Snippet {
	public static void main(String[] args) {
		<build>
				<plugins>
					<plugin>
						<groupId>org.springframework.boot</groupId>
						<artifactId>spring-boot-maven-plugin</artifactId>
					</plugin>
					<plugin>
						<groupId>org.apache.maven.plugins</groupId>
						<artifactId>maven-surefire-plugin</artifactId>
						<configuration>
							<useSystemClassLoader>false</useSystemClassLoader>
						</configuration>
					</plugin>
				</plugins>
			</build>
	}
}

