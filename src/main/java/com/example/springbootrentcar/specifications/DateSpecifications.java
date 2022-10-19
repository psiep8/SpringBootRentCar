package com.example.springbootrentcar.specifications;

import com.example.springbootrentcar.dto.AutoDTO;
import com.example.springbootrentcar.dto.PrenotazioneDTO;
import com.example.springbootrentcar.entity.Auto;
import com.example.springbootrentcar.entity.Prenotazione;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class DateSpecifications {

    public static Specification<Prenotazione> getRangeData(LocalDate inizio, LocalDate fine) {
        return (root, query, criteriaBuilder) -> {
            Predicate datePredicateBetween = criteriaBuilder.and(criteriaBuilder.greaterThan(
                    root.get("dataInizio"), inizio), criteriaBuilder.lessThanOrEqualTo(
                    root.get("dataFine"), fine));
            Predicate datePredicate = criteriaBuilder.or(
                    datePredicateBetween,
                    criteriaBuilder.or(
                            criteriaBuilder.between(root.get("dataInizio"), inizio, fine),
                            criteriaBuilder.between(root.get("dataFine"), inizio, fine)
                    )
            );
            Predicate approvedPredicate = criteriaBuilder.equal(root.get("approvata"), true);
            query.distinct(true);
            return criteriaBuilder.and(datePredicate, approvedPredicate);
        };
    }

    public static Specification<Auto> getAutoNotInRange(List<Integer> list) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.not(root.get("idAuto").in(list));

    }


}

