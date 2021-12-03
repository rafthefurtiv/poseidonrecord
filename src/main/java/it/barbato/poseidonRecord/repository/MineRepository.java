package it.barbato.poseidonRecord.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MineRepository<T, ID> extends CrudRepository<T, ID> {

    Page<T> findAll(Pageable pageable);
}
