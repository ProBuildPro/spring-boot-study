package top.cfish.elasticsearch.repository;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.metrics.sum.InternalSum;
import org.elasticsearch.search.aggregations.metrics.sum.SumAggregationBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ResultsExtractor;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import top.cfish.elasticsearch.ElasticsearchApplicationTests;
import top.cfish.elasticsearch.entity.Customer;

import java.util.List;
import java.util.Map;

/**
 * @author: isisiwish
 * @date: 2019/5/24
 * @time: 16:37
 */
@Slf4j
public class CustomerRepositoryTest extends ElasticsearchApplicationTests
{
    @Autowired
    private CustomerRepository repository;
    
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    
    @Test
    public void saveCustomers()
    {
        repository.save(new Customer("Alice", "北京", 13));
        repository.save(new Customer("Bob", "北京", 23));
        repository.save(new Customer("neo", "西安", 30));
        repository.save(new Customer("summer", "烟台", 22));
    }
    
    @Test
    public void fetchAllCustomers()
    {
        log.info("Customer found with findAll()");
        Iterable<Customer> iterable = repository.findAll();
        for (Customer customer : iterable)
        {
            log.info("{}", JSON.toJSONString(customer));
        }
    }
    
    @Test
    public void updateCustomers()
    {
        Customer customer = repository.findByUsername("summer");
        log.info("{}", JSON.toJSONString(customer));
        customer.setAddress("北京市海淀区西直门");
        repository.save(customer);
        Customer rsCustomer = repository.findByUsername("summer");
        log.info("{}", JSON.toJSONString(rsCustomer));
    }
    
    @Test
    public void fetchIndividualCustomers()
    {
        log.info("Customers found with findByAddress(\"北京\")");
        String query = "北京";
        List<Customer> customerList = repository.findByAddress(query);
        for (Customer customer : customerList)
        {
            log.info("{}", JSON.toJSONString(customer));
        }
    }
    
    @Test
    public void fetchPageCustomersA()
    {
        log.info("Customers found with fetchPageCustomers");
        Sort sort = new Sort(Sort.Direction.DESC, "address.keyword");
        Pageable pageable = PageRequest.of(0, 2, sort);
        Page<Customer> customerList = repository.findByAddress("北京", pageable);
        for (Customer customer : customerList)
        {
            log.info("{}", JSON.toJSONString(customer));
        }
    }
    
    @Test
    public void fetchPageCustomersB()
    {
        log.info("Customers found with fetchPageCustomers");
        QueryBuilder customerQuery = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("address", "北京"));
        Page<Customer> customerList = repository.search(customerQuery, PageRequest.of(0, 2));
        for (Customer customer : customerList)
        {
            log.info("{}", JSON.toJSONString(customer));
        }
    }
    
    @Test
    public void fetchAggregation()
    {
        log.info("Customers found with fetchAggregation:");
        
        // 1.使用QueryBuilder构建查询条件
        QueryBuilder customerQuery = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("address", "北京"));
        
        // 2.使用SumAggregationBuilder指明需要聚合的字段
        SumAggregationBuilder sumBuilder = AggregationBuilders.sum("sumAge").field("age");
        
        // 3.以customerQuery和sumBuilder为参数构建成SearchQuery
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(customerQuery).addAggregation(sumBuilder).build();
        
        // 4.使用Aggregations进行查询
        Aggregations aggregations = elasticsearchTemplate.query(searchQuery, new ResultsExtractor<Aggregations>()
        {
            @Override
            public Aggregations extract(SearchResponse response)
            {
                return response.getAggregations();
            }
        });
        
        // 解析聚合查询结果，转换成map集合
        Map<String, Aggregation> aggregationMap = aggregations.asMap();
        
        // 获得对应的聚合函数的聚合子类，该聚合子类也是map集合
        InternalSum sumAge = (InternalSum)aggregationMap.get("sumAge");
        log.info("sum age : {}", sumAge.getValue());
    }
    
    @Test
    public void deleteCustomerA()
    {
        int rs = repository.deleteByUsername("Alice");
        log.info("rs : {}", rs);
    }
    
    @Test
    public void deleteCustomerB()
    {
        int rs = repository.deleteCustomerByUsername("summer");
        log.info("rs : {}", rs);
    }
    
    @Test
    public void deleteCustomers()
    {
        repository.deleteAll();
    }
}
