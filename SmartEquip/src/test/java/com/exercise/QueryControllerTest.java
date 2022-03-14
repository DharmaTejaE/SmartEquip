package com.exercise;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.exercise.service.QueryService;

@SpringBootTest
//@WebMvcTest(value = QueryController.class)
public class QueryControllerTest {

	@MockBean
	private QueryService queryService;

	@Test
	public void firstQuery() throws Exception {
		String query = "Here you go, solve the question: "+"\""+"Please sum the numbers 9,5,3";
		Mockito.when(
				queryService.query(Mockito.anyString())).thenReturn(query);

	}

}