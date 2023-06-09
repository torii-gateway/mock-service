package org.torii.gateway.mockservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.torii.gateway.mockservice.domain.Content;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {

}
