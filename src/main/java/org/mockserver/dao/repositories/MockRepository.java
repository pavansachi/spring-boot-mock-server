package org.mockserver.dao.repositories;

import org.mockserver.dao.models.MockRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface MockRepository extends CrudRepository<MockRequest, Long> {
	
	public MockRequest findByPath(String path);

}