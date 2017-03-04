package org.mockserver.dao.repositories;

import org.mockserver.dao.models.MockRequestParam;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface MockRequestParamRepository extends CrudRepository<MockRequestParam, Long> {
	
//	public List<MockRequestParam> findByNameIn(List<String> names);
	
//	public List<MockRequestParam> findByMockRequestRequestIdMethodAndMockRequestRequestIdPathAndNameInAndValueIn(String method, String path, List<String> names, List<String> values);
	
}