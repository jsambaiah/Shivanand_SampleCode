/**
 * 
 */
package com.fleetmgt.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Component;

import com.fleetmgt.model.Customer;
import com.fleetmgt.repository.CustomerRepository;

/**
 * FleetManagementSystem - CustomerServiceImpl.java, Jul 13, 2015, 11:55:31 PM
 * 
 * @author <a href="mailto:shivuamalyal@gmail.com">Shivanand Amalyal</a>
 */
@Component
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> findAllCustomers(String fieldValuePair,
			String fVSeparator, String fFSeperator, String sortField,
			String sortOrder) {

		Query query = getQuery(fieldValuePair, fVSeparator, fFSeperator,
				sortField, sortOrder);
		return customerRepository.findCustomers(query);
	}

	private Query getQuery(String fieldValuePair, String fVSeparator,
			String fFSeperator, String sortField, String sortOrder) {

		Query searchQuery = new Query();
		Map<String, String> fieldValuePairMap = new HashMap<String, String>();
		if (null != fieldValuePair && fieldValuePair.trim().length() > 0)

		{

			fieldValuePairMap = parseStringToMap(fieldValuePair, fVSeparator,
					fFSeperator);

			System.out.println("Map Size ::" + fieldValuePairMap.size());

			if (fieldValuePairMap.size() > 0) {
				Set<Entry<String, String>> entrySet = fieldValuePairMap.entrySet();
				System.out.println("entrySet ::" + entrySet);
				for (Entry<String, String> e:entrySet ){
					searchQuery.addCriteria(Criteria.where(e.getKey()).is(
							e.getValue()));
				}
				/*Set keySet = fieldValuePairMap.keySet();
				Iterator keyIter = keySet.iterator();
				while (keyIter.hasNext())

				{
					String param = (String) keyIter.next();
					searchQuery.addCriteria(Criteria.where(param).is(
							fieldValuePairMap.get(param)));
				}*/
				System.out.println("Search Query :::" + searchQuery);
				if (sortField != null) {
					Sort sort = null;
					if (sortOrder == null || sortOrder.trim().length() == 0
							|| sortOrder.equalsIgnoreCase("1")) {
						System.out.println("ASC sort :::" + searchQuery);
						sort = new Sort(Sort.Direction.ASC, sortField);
					} else if (sortOrder.equalsIgnoreCase("-1")) {
						System.out.println("DESC sort :::" + searchQuery);
						sort = new Sort(Sort.Direction.DESC, sortField);
					}

					searchQuery.with(sort);
				}
				System.out.println("Final Search Query :::" + searchQuery);

			}

		}

		return searchQuery;

	}

	public Map<String, String> parseStringToMap(String kerValuePair,
			String seprator1, String seprator2) {
		Map<String, String> myMap = new HashMap<String, String>();

		String[] pairs = kerValuePair.split(seprator2);
		for (int i = 0; i < pairs.length; i++) {
			String pair = pairs[i];
			String[] keyValue = pair.split(seprator1);
			if (keyValue.length > 1)
				myMap.put(keyValue[0], keyValue[1]);
			else
				myMap.put(pairs[i], null);
		}

		Iterator itr = myMap.entrySet().iterator();
		System.out.println("Map in parseStringToMap method ::" + myMap);
		return myMap;
	}

	@Override
	public List<Customer> findCustomers(String searchParam) {
		Query query=new Query(TextCriteria.forDefaultLanguage().matchingAny(searchParam));
		System.out.println("Query ::" +query);
		 return customerRepository.findCustomers(query);
	}

}
