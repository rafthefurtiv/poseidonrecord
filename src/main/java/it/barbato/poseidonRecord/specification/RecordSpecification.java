package it.barbato.poseidonRecord.specification;

import it.barbato.poseidonRecord.entity.Record;
import it.barbato.poseidonRecord.utils.RecordFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class RecordSpecification implements Specification<Record> {

    RecordFilter recordFilter;
    public RecordSpecification(RecordFilter recordFilter){
        this.recordFilter = recordFilter;
    }

    @Override
    public Specification<Record> and(Specification<Record> other) {
        return Specification.super.and(other);
    }

    @Override
    public Specification<Record> or(Specification<Record> other) {
        return Specification.super.or(other);
    }

    @Override
    public Predicate toPredicate(Root<Record> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicatesList = new ArrayList<>();

        if(recordFilter != null){

            // categoria
            if(recordFilter.getCategoria()!=null){
                predicatesList.add(criteriaBuilder.equal(root.get("categoria"), recordFilter.getCategoria()));
            }

            // vasca corta
            if(recordFilter.getFlag_vasca_corta()!=null){
                predicatesList.add(criteriaBuilder.equal(root.get("flagVascaCorta"), recordFilter.getFlag_vasca_corta()));
            }
        }

        return criteriaBuilder.and(predicatesList.toArray(new Predicate[predicatesList.size()]));
    }

}
