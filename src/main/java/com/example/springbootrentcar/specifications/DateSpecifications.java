package com.example.springbootrentcar.specifications;

import com.example.springbootrentcar.entity.Auto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;

@RequiredArgsConstructor
public class DateSpecifications implements Specification<Auto> {

    private final LocalDate inizio, fine;


    @Override
    public Predicate toPredicate(Root<Auto> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Predicate datePredicateBetween = criteriaBuilder.and(criteriaBuilder.greaterThan(
                root.get("data_inizio"), inizio), criteriaBuilder.lessThanOrEqualTo(
                root.get("data_fine"), fine));
        Predicate datePredicate = criteriaBuilder.or(
                datePredicateBetween,
                criteriaBuilder.or(
                        criteriaBuilder.between(root.get("data_inizio"), inizio, fine),
                        criteriaBuilder.between(root.get("data_fine"), inizio, fine)
                )
        );
        Predicate approvedPredicate = criteriaBuilder.equal(root.get("approvata"), true);
        return criteriaBuilder.and(datePredicate, approvedPredicate);
    }

}

