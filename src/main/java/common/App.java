package common;

import javax.persistence.EntityManager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.QuestionDAO;
import model.Question;

public class App {
	public static void main(String[] args) {
		// ApplicationContext context = new ClassPathXmlApplicationContext(
		// "Spring-Module.xml");
		//
		// HelloWorld obj = (HelloWorld) context.getBean("helloBean");
		// obj.printHello();
        
	//	EntityManager em;
		
		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());

		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");

		QuestionDAO questionDAO = (QuestionDAO) context.getBean("questionDAO");
		Question question = new Question(1222, "Coffee please?", sqlDate);
		questionDAO.insert(question);

		for (int i = 1; i <= 9; i++) {
			Question question1 = questionDAO.findByQuestionId(i);
			System.out.println(i + question1.getQuestionText() + "," + question1.getPubDate());
		}
	}
}