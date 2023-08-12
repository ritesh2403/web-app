package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.CustomerDaoImp;
import Entity.Customer;

@Service
public class CustomerServiceImp implements CustomerService {

	@Autowired
	private CustomerDaoImp dao;

	@Override
	public List<Customer> customers() {
		// TODO Auto-generated method stub
		return dao.customers();
	}

	@Override
	public void save(Customer cust) {
		// TODO Auto-generated method stub
		dao.save(cust);
	}

	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return dao.getCustomer(id);
	}

	@Override
	public void deleteCusomer(int id) {
		// TODO Auto-generated method stub
       dao.deleteCusomer(id);
	}

	public void savecustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	public void loadData() {
		// TODO Auto-generated method stub
		dao.loadData();
	}

}
