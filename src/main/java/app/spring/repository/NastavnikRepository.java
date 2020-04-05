package app.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.spring.model.Nastavnik;

@Repository
public interface NastavnikRepository extends CrudRepository<Nastavnik, Long>{

}
