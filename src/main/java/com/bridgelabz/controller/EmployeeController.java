package com.bridgelabz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.DAO.DataBaseOperation;
import com.bridgelabz.model.Employee;

@Controller
public class EmployeeController {

	@Autowired
	Employee employee;

	@Autowired
	DataBaseOperation dao;

	@RequestMapping("/insert")
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {

		employee.setName(request.getParameter("name"));
		employee.setMail(request.getParameter("mail"));
		employee.setPassword(request.getParameter("pass"));
		employee.setConfirmPassword(request.getParameter("cPass"));
		employee.setMobileNum(request.getParameter("mn"));
		ModelAndView view = new ModelAndView();
		String message = dao.emailValidaton();
		System.out.println(message);

		if (message == "login") {
			view.setViewName("index.jsp");
			return view;
		} else {
			view.setViewName("singin.jsp");
			view.addObject("message", message);
			return view;
		}

	}

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		employee.setMail(request.getParameter("mail"));
		employee.setPassword(request.getParameter("pass"));
		String name = dao.fetchEmployee();
		ModelAndView view = new ModelAndView();

		if (name != null) {
			view.addObject("Name", name);
			session.setAttribute("name", name);
			view.setViewName("display.jsp");
			return view;

		} else {
			view.setViewName("index.jsp");
			view.addObject("name", name);
			return view;
		}
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		session.invalidate();
		view.setViewName("index.jsp");
		return view;
	}

}
