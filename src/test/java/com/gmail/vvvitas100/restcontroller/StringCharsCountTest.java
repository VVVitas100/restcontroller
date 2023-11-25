package com.gmail.vvvitas100.restcontroller;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class StringCharsCountTest {

	Map<Character, Long> expected;
    @BeforeEach
    public void setup(){
		expected = new LinkedHashMap<>();
		
    }
	
	@Test
	public void getCountEmptyTask() {
		String in = "";
		Map<Character, Long> actual = StringCharsCount.getCount(in);
		assertEquals(expected, actual);
	}

	@Test
	public void getCountTestTask() {
		String in = "aaaaabcccc";
		expected.put('a', 5L);
		expected.put('c', 4L);
		expected.put('b', 1L);
		
		Map<Character, Long> actual = StringCharsCount.getCount(in);
		assertEquals(expected, actual);
	}

    @Test
	public void getCountPositiveTest() {
		String in = " я⛅☁☺ ☁⛅⛅⛅А☁■ ";
		expected.put('⛅', 4L);
		expected.put('☁', 3L);
		expected.put(' ', 3L);
		expected.put('☺', 1L);
		expected.put('я', 1L);
		expected.put('А', 1L);
		expected.put('■', 1L);

		Map<Character, Long> actual = StringCharsCount.getCount(in);
		assertEquals(expected, actual);
	}

	@Test
	public void getCountNegativeTest() {
		String in = "🕒🕛";
		expected.put('\uD83D', 2L);
		expected.put('\uDD52', 1L);
		expected.put('\uDD5B', 1L);
				
		Map<Character, Long> actual = StringCharsCount.getCount(in);
		assertEquals(expected, actual);
	}


}