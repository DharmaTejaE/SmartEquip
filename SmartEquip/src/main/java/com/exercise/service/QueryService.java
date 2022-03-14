package com.exercise.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class QueryService implements IQueryService {

	String ques1 = "Hey Service, can you provide me a question with numbers to add";
	String ques2 = "Great. The original question was";
	String ques3 = "Sorry, the original question was";
	Map<String,Integer> userQuestionMap = new HashMap<String,Integer>();
	
	@Override
	public String query(String question) {
		// TODO Auto-generated method stub
		String answer = "Here you go, solve the question:";
		int n1  = (int) Math.random();
		int n2  = (int) Math.random();
		int n3  = (int) Math.random();
		int  add = n1+n2+n3;
		if(question.contains(ques1)) {
			answer = answer.concat(" Please sum the numbers ").concat(String.valueOf(n1)).concat(",")
					.concat(String.valueOf(n2)).concat(",").concat(String.valueOf(n3));
			userQuestionMap.put(answer.split(":")[1], add);
			return answer;
		} else if(question.contains(ques2)) {
			String answerfromClient = question.split("is ")[1];
			Set<String> allquestions = userQuestionMap.keySet();
			boolean correctAnswer = false;
			for(String key : allquestions) {
				if(question.contains(key)) {
					if(String.valueOf(userQuestionMap.get(key)).equalsIgnoreCase(answerfromClient)) {
						correctAnswer = true;
					}
				}
			}
			if(correctAnswer)
				return "That's great";
			else
				return "That's wrong. Pleease try again";
		} else if(question.contains(ques2)) {
			String secondAnswerfromClient = question.split("is ")[1];
			Set<String> allquestions = userQuestionMap.keySet();
			boolean correctAnswer = false;
			for(String key : allquestions) {
				if(question.contains(key)) {
					if(String.valueOf(userQuestionMap.get(key)).equalsIgnoreCase(secondAnswerfromClient)) {
						correctAnswer = true;
					}
				}
			}
			if(correctAnswer)
				return "That's great";
			else
				return "That's wrong. Pleease try again";
		}
		return null;
	}

}
