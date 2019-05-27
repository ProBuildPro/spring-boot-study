package top.cfish.elasticsearch.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import top.cfish.elasticsearch.entity.Customer;

import java.util.List;

/**
 * @author: isisiwish
 * @date: 2019/5/24
 * @time: 16:31
 */
public interface CustomerRepository extends ElasticsearchRepository<Customer, String>
{
	List<Customer> findByAddress(String address);
	
	Customer findByUsername(String username);
	
	Page<Customer> findByAddress(String address, Pageable pageable);
	
	int deleteByUsername(String username);
	
	@Override
	void deleteById(String s);
	
	int deleteCustomerByUsername(String username);
}
