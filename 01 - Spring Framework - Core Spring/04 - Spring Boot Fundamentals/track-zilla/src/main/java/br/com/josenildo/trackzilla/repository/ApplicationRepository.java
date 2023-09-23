package br.com.josenildo.trackzilla.repository;

import br.com.josenildo.trackzilla.entity.Application;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationRepository extends CrudRepository<Application, Long> {
}
