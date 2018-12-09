package common;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.QuestionDAO;
import model.Question;

import static org.junit.Assert.assertEquals;

public class AppTest extends App {
	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");

	QuestionDAO questionDAO = (QuestionDAO) context.getBean("questionDAO");
	
	@Test
    public void doesQueryGetTheFirstRecord() {
    	Question question1 = questionDAO.findByQuestionId(1);
    	assertEquals(question1.getQuestionId(), 1);
    }
}
