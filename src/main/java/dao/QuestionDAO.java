package dao;

import model.Question;

public interface QuestionDAO {

	public void insert(Question question);
	public Question findByQuestionId(int questionId);
}
