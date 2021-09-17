package org.acme.experiment.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import org.acme.experiment.model.Answer;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class AnswerRepository implements PanacheRepository<Answer> {

    @Transactional
    public  List<Answer> findByText(String text) {
        return find("lower(question.text) like :text",
                    Parameters.with("text", "%" + text.toLowerCase(Locale.ROOT) + "%")).list();
    }
}
