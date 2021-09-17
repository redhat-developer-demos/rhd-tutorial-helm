package org.acme.experiment;

import org.acme.experiment.model.Answer;
import org.acme.experiment.model.Question;
import org.acme.experiment.repository.AnswerRepository;
import org.acme.experiment.repository.QuestionRepository;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/ask")
public class FAQResource {

    @Inject
    QuestionRepository questionRepository;

    @ConfigProperty(name="region")
    String region;

    @Inject
    AnswerRepository answerRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Question> findAll() {
        return questionRepository.findAll().list();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Question create(Question question) {
        question.setRegion(region);
        questionRepository.persist(question);
        return question;
    }

    @GET
    @Path("{region}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Question> findAllByRegion(@PathParam("region") String region) {
        return questionRepository.findByRegion(region);
    }

    @POST
    @Path("/one")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public List<Answer> findAnswer(String question) {
        List<Answer> answers = answerRepository.findByText(question);
        return answers;
    }

}