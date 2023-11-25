package com.gmail.vvvitas100.restcontroller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs(outputDir = "target/snippets")
class RestcontrollerApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void getCountEmptyTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/count").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(
						"{}"));
	}

	@Test
	public void getCountPositiveTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/count?text=я⛅☁☺ ☁⛅ ⛅⛅А☁■").accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json(
						"{" +
									"\"⛅\":4," +
									"\"☁\":3," +
									"\" \":2," +
									"\"■\":1," +
									"\"А\":1," +
									"\"☺\":1," +
									"\"я\":1" +
									"}")).andDo(document("home"));
	}

	@Test
	public void getCountNegativeTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/count?text=🕒🕛").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(
						"{" +
									"\"\\uD83D\":2," +
									"\"\\uDD52\":1," +
									"\"\\uDD5B\":1" +
									"}"));
	}
}
