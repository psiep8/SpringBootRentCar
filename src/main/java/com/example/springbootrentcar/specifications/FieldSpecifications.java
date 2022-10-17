package com.example.springbootrentcar.specifications;

import com.example.springbootrentcar.entity.Utente;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@RequiredArgsConstructor
public class FieldSpecifications implements Specification<Utente> {
    private final String campo, filter;

    @Override
    public Predicate toPredicate(Root<Utente> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Predicate filtername = criteriaBuilder.like(root.get(campo.toLowerCase()), "%" + filter + "%");
        Predicate customer = criteriaBuilder.equal(root.get("customer"), true);
        return criteriaBuilder.and(filtername, customer);
    }
}
