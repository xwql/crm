package cn.crm.service;

import cn.crm.bean.Customer;
import cn.crm.utils.Page;


public interface CustomerService {

	// 查询客户列表
	public Page<Customer> findCustomerList(Integer page, Integer rows,
                                           String custName, String custSource, String custIndustry, String custLevel);

	public Customer getCustomerById(Long id);

	public void updateCustomer(Customer customer);

	public void deleteCustomerWithData(Long id);

	/**
	 * 不删除数据
	 * @param id
	 * @param deletereason
	 * @param remark
	 */
	public void deleteCustomer2(Long id,String deletereason,String remark);

	public void saveCustomer(Customer customer);
}
