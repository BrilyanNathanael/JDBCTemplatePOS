package com.wirecard.myspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wirecard.myspring.domain.Product;
import com.wirecard.myspring.model.Employee;
import com.wirecard.myspring.repository.ProductRepository;
import com.wirecard.myspring.service.EmployeeService;

@Controller
public class ProductController {
	
	@Autowired
	ProductRepository productRepo;
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String listOfProduct(Model model) {
		model.addAttribute("productList", productRepo.listAll());

		return "product-list";
	}
	
	@GetMapping("/product/form")
	public String showNewEmployeeForm(Model model) {
		model.addAttribute("product", new Product());
		
		return "product-form";
	}
	
	@RequestMapping(value = "/product/view/{code}", method = RequestMethod.GET)
	public String findProduct(@PathVariable("code") String code, Model model) {
//		EmployeeService service = new EmployeeService();
		model.addAttribute("product", productRepo.findByCode(code));
		return "product-view";
	}
	
	@RequestMapping(value="/product/add", method = RequestMethod.POST)
	public String addNewProduct(@ModelAttribute("product") Product product) {
//		EmployeeService service = new EmployeeService();
		
		productRepo.addProduct(product);
		return "redirect:/products";
	}
	
	@RequestMapping(value="/product/update", method = RequestMethod.POST)
	public String updateProduct(@ModelAttribute("product") Product product) {
//		EmployeeService service = new EmployeeService();
		
		productRepo.updateProduct(product);
		return "redirect:/products";
	}

}
