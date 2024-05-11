package org.example.employeemanagementsystem.controller;


import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.employeemanagementsystem.entity.Employee;
import org.example.employeemanagementsystem.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;



    @GetMapping("/")
    public String allEmployee(Model model,HttpSession session){
        List<Employee> employeeList = employeeService.getAll();
        model.addAttribute("emp", employeeList);
        if(session.getAttribute("msg")!=null) {
            model.addAttribute("sessionMsg", session.getAttribute("msg"));
            session.removeAttribute("msg");
        }
        return "home";
    }


    @GetMapping("/add_emp")
    public String addEmp(){
        return "add_emp";
    }

    @PostMapping("/register")
    public String empRegister(@ModelAttribute Employee employee, HttpSession session){
        employeeService.add(employee);
        session.setAttribute("msg","Employee is successfully added");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id,Model model){
        Employee employee = employeeService.getById(id);
        model.addAttribute("emp",employee);
        return "edit";
    }

    @PostMapping("/update")
    public String empEdit(@ModelAttribute Employee employee,HttpSession session){
        employeeService.add(employee);
        session.setAttribute("msg","Employee is successfully updated");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id,HttpSession session){
        employeeService.delete(id);
        session.setAttribute("msg","Employee is successfully deleted");
        return "redirect:/";
    }



}
