package com.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoListController {

	private Map<Long, String> todoMap = new HashMap();
	
	@RequestMapping(value="/add/{todoMessage}", method=RequestMethod.PUT)
	public String addTodo(@PathVariable("todoMessage") String todoMessage) throws Exception{
		
		todoMap.put(System.currentTimeMillis(), todoMessage);
		
		return "OK";
	}
	
	@RequestMapping(value="/list")
	public Map<Long, String> getTodoList() throws Exception{
		
		return todoMap;
	}
	
	@RequestMapping(value="/delete/{key}", method=RequestMethod.DELETE)
	public Map<Long, String> deleteTodo(@PathVariable("key") long key) throws Exception{
		if(todoMap.containsKey(key)) {
			todoMap.remove(key);
		}
		return todoMap;
	}
}
