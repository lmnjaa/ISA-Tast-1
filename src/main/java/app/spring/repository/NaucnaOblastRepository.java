package app.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.spring.model.NaucnaOblast;

@Repository
public interface NaucnaOblastRepository extends CrudRepository<NaucnaOblast, Long>{

}
