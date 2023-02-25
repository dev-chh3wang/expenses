package com.tmg.xpenses;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@ActiveProfiles("test")
class XpensesApplicationTests {


	MockMvc mockMvc;


	@Test
	void contextLoads() {
	}
}
