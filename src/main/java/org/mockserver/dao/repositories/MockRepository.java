package org.mockserver.dao.repositories;

import org.mockserver.dao.models.Mock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface MockRepository extends CrudRepository<Mock, Long> {
	
	public Mock findByPath(String path);

}