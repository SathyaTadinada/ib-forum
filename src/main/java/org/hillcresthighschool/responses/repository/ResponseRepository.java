package org.hillcresthighschool.responses.repository;

import org.hillcresthighschool.responses.entity.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Integer> {
}
