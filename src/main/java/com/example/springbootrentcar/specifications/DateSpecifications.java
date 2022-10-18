package com.example.springbootrentcar.specifications;

import com.example.springbootrentcar.entity.Auto;
import com.example.springbootrentcar.entity.Prenotazione;
import lombok.RequiredArgsConstructor;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class DateSpecifications implements Specification<Auto> {

    private final LocalDate inizio, fine;

    @Override
    public Predicate toPredicate(Root<Auto> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
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
        return criteriaBuilder.and(datePredicate, approvedPredicate);

        /*query = prenotazioni.where(criteriaBuilder.and(datePredicate, approvedPredicate)).distinct(true);
        List<Prenotazione> list = query.getOrderList();
        List<Integer> autoList = new ArrayList<>();
        for (Prenotazione p : list) {
            int id = p.getAuto().getIdAuto();
            autoList.add(id);
        }
        CriteriaQuery<Auto> criteriaAutoQuery = criteriaBuilder.createQuery(Auto.class);
        Root<Auto> autoRoot = criteriaAutoQuery.from(Auto.class);
        CriteriaQuery<Auto> c = criteriaAutoQuery.select(autoRoot);
        if (autoList.size() == 0) {
            return session.createQuery(c).getResultList();
        } else {
            Predicate notIn = criteriaBuilder.not(autoRoot.get("id").in(autoList));
            return session.createQuery(c.where(notIn)).getResultList();
        }
*/

    }

}

