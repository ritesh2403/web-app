package Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Entity.Customer;
import Service.CustomerServiceImp;

@Component
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerServiceImp service;

	@RequestMapping("/list")
	public ModelAndView listCustomers(Model themodel) {
		ModelAndView mv = new ModelAndView();
		Customer c = new Customer();
		List<Customer> customer = service.customers();
		c.setCustomers(customer);
		mv.addObject("customers", customer);
		mv.setViewName("displayCustomer");

		return mv;

	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView updateCustomer(@RequestParam("customerId") int id) {
		ModelAndView mv = new ModelAndView();
		Customer c = new Customer();
		Customer customer = service.getCustomer(id);
		mv.addObject("Customers", customer);
		mv.addObject("customerid", id);
		mv.setViewName("AddCustomer");
		return mv;

	}
	
	@RequestMapping(value = "/savecustomer", method = RequestMethod.POST)
	public ModelAndView savecustomer(@ModelAttribute Customer customer) {
		ModelAndView mv = new ModelAndView();
		Customer c = new Customer();
		 service.save(customer);
		 List<Customer> customersave = service.customers();
		 System.out.println("save customer"+customersave);
		mv.addObject("customers", customersave);
		mv.setViewName("displayCustomer");
		return mv;

	}
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteCustomer(@RequestParam("customerdelId") int id) {
	
		ModelAndView mv = new ModelAndView();
		Customer c = new Customer();
	
		service.deleteCusomer(id);
		 List<Customer> customersave = service.customers();
		 System.out.println("save customer"+customersave);
		mv.addObject("customers", customersave);
		mv.setViewName("displayCustomer");
		return mv;
	}
	
	
	@RequestMapping(value = "/loadData", method = RequestMethod.GET)
	public ModelAndView loadData() {
	
		ModelAndView mv = new ModelAndView();
		Customer c = new Customer();
	
		service.loadData();
		 List<Customer> customersave = service.customers();
		 System.out.println("save customer"+customersave);
		mv.addObject("customers", customersave);
		mv.setViewName("displayCustomer");
		return mv;
	}
	
	
	

	@RequestMapping(value = "/creditcard", method = RequestMethod.POST)
	public ModelAndView updateCustomer(@RequestBody Customer customer) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("Customers", customer);
		mv.setViewName("edit");
		return mv;

	}

}
