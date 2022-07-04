package com.greatlearning.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.context.Theme;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.studentmanagement.model.Student;
import com.greatlearning.studentmanagement.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/list")
	public String listStudents(Model theModel) {
		List<Student> theStudents = studentService.findAll();
		theModel.addAttribute("students", theStudents);
		return "list-students";

	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Student student = new Student();
		theModel.addAttribute("student", student);
		theModel.addAttribute("mode", "Add");
		return "student-form";

	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") long studentId, Model theModel) {
		Student student = studentService.findById(studentId);
		theModel.addAttribute("student", student);
		theModel.addAttribute("mode", "Update");
		return "student-form";

	}

	@PostMapping("/save")
	public String saveStudent(@RequestParam("studentId") long studentId, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("course") String course,
			@RequestParam("country") String country) {

		Student student = null;

		if (studentId == 0) {
			student = new Student(firstName, lastName, course, country);
		}

		else {
			student = studentService.findById(studentId);
			student.setCountry(country);
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setCourse(course);
		}

		studentService.save(student);
		return "redirect:list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") long studentId) {

		studentService.delete(studentId);
		return "redirect:list";

	}
}
