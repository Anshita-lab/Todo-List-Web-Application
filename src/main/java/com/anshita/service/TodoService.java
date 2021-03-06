package com.anshita.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.anshita.model.Todo;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<Todo>();
	private static int todoCount = 3;

	static {
		todos.add(new Todo(1, "anshita", "Learn Spring MVC", new Date(),
				false));
		todos.add(new Todo(2, "anshita", "Learn Struts", new Date(), false));
		todos.add(new Todo(3, "anshita", "Learn Hibernate", new Date(),
				false));
	}

	public List<Todo> retrieveTodos(String user) {
		List<Todo> filteredTodos = new ArrayList<Todo>();
		for (Todo todo : todos) {
			if (todo.getUser().equals(user))
				filteredTodos.add(todo);
		}
		return filteredTodos;
	}

	public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
		todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
	}

	public void deleteTodo(int id) {
		for (Todo todo : todos) {
			if (todo.getId() == id)
				todos.remove(todo);
		}
	}
}