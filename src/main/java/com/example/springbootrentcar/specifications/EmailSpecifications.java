package com.example.springbootrentcar.specifications;

import com.example.springbootrentcar.entity.Utente;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.Query;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@RequiredArgsConstructor
public class EmailSpecifications implements Specification<Utente> {
    private final String email;

    @Override
    public Predicate toPredicate(Root<Utente> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Predicate emailColumn = criteriaBuilder.equal(root.get("email"), email);
        return criteriaBuilder.and(emailColumn);
    }
}
