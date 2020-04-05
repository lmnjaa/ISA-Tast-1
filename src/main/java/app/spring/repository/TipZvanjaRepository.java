package app.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.spring.model.TipZvanja;

@Repository
public interface TipZvanjaRepository extends CrudRepository<TipZvanja, Long>{

}
