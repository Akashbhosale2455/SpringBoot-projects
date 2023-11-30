package com.todo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.todo1.dao.EmpDAO;
import com.todo1.dto.EmpDTO;

import net.bytebuddy.matcher.ModifierMatcher.Mode;

@Controller
public class Myctrl {
	@Autowired
	EmpDTO e;
	
	@RequestMapping("/home")
	public String home(Model m)

	{
		EmpDAO em=new EmpDAO();
		em.addEmp();
		
		System.out.println(em.addEmp());
		m.addAttribute("emp",em.addEmp());
		
		return "home";
	}
}
