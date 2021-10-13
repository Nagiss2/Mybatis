package com.example.demoAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoAPI.mapper.UserMapper;
import com.example.demoAPI.model.User;

@RestController
@RequestMapping("/user")

public class UserController {
	@Autowired
	private UserMapper usermapper;

	@GetMapping("/all")
	public List<User> getAll() {
		return usermapper.findAll();
	}

	@PostMapping("/add")
	private String saveData(@RequestBody User user) {
		usermapper.insert(user);
		return "inserted successful";
	}

	@PutMapping("/update")
	private String update(@RequestParam int id, @RequestBody User user) {
		user.setId(id);
		usermapper.update(user);
		return "updated successful";
	}

	@DeleteMapping("/delete")
	private String delete(@RequestParam int id) {

		usermapper.delete(id);

		return "deleted successful";
	}
}
