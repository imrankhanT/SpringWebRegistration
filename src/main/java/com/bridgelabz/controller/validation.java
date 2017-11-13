package com.bridgelabz.controller;

import javax.servlet.http.HttpSession;

import com.bridgelabz.model.Employee;

public class validation {

	public  boolean vaildationMethod(Employee userDetail, HttpSession session) {
		boolean valid = true;
		String phoneNumRegx = "^[0-9]{10}$";
		String nameRegx = "^[a-zA-Z]{4,}(?: [a-zA-Z]+){0,2}$";
		String emailRegx = "/^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$/;";
		if (!userDetail.getName().matches(nameRegx)) {
			session.setAttribute("error", "Please Enter the valid name");
			valid = false;
		} else

		if (!userDetail.getMobileNum().matches(phoneNumRegx)) {
			session.setAttribute("error", "Please Enter the valid phone number");
			valid = false;
		} else

		if (!userDetail.getMail().matches(emailRegx)) {
			session.setAttribute("error", "Entered Email id is not correct.....");
			valid = false;
		} else if (userDetail.getPassword().length() < 8 || userDetail.getPassword().length() > 16) {
			session.setAttribute("error", "Please enter the length between 8 to 16 charcter long");
			valid = false;
		} else

		if (userDetail.getPassword() != userDetail.getConfirmPassword()) {
			session.setAttribute("error", "Password did'nt matched");
			valid = false;
		} else {
			valid = true;
		}
		return valid;
	}

}
