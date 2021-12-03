package it.barbato.poseidonRecord.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface MineRepository<T, ID> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

    Page<T> findAll(Pageable pageable);

    List<T> findAll();

    List<T> findAll(Specification<T> specification);
}
