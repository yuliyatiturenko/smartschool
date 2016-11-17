package com.smartschool.rest.repository;

import com.smartschool.rest.model.Massage;
import javafx.scene.Parent;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Repository
public class MassageRepository {
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    EntityManager entityManager;

    public List<Massage> getAllMassageForClassByClassId(int id) {
        Query query = entityManager.createQuery("select m.massage_text, m.parent_id from Massage m  where m.class_id = :id");
        query.setParameter("id", id);

        List<Massage> massages = query.getResultList();

        return massages;
    }
    public List<Massage> getParentMassageByNumber(String num) {
        Query query = entityManager.createQuery("select m.massage_text, m.massage_date, m.massage_time from Massage m inner join StudentParent p  on  m.parent_id = 0 or m.parent_id = p.parent_id  where p.parent_mobnum = :num");
        query.setParameter("num", num);

        List<Massage> massages = query.getResultList();

        return massages;
    }
}
