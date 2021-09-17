package org.acme.experiment.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.experiment.model.Answer;
import org.acme.experiment.model.Question;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class QuestionRepository implements PanacheRepository<Question> {

    public List<Question> findByRegion(String region) {
        return find("region=?1", region).list();
    }
}
