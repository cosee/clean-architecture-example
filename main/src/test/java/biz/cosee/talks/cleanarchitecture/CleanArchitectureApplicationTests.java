package biz.cosee.talks.cleanarchitecture;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThatCode;

@SpringBootTest
class CleanArchitectureApplicationTests {

	@Test
	void contextLoads() {
		// just test if the context runs
		assertThatCode(() -> {}).doesNotThrowAnyException();
	}
}
