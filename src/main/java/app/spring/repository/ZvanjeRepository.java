package app.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.spring.model.Zvanje;

@Repository
public interface ZvanjeRepository extends CrudRepository<Zvanje, Long>{

}
