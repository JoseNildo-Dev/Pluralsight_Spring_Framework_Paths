package br.com.josenildo.trackzilla.repository;

import br.com.josenildo.trackzilla.entity.Release;
import org.springframework.data.repository.CrudRepository;

public interface ReleaseRepository extends CrudRepository<Release, Long> {
}
