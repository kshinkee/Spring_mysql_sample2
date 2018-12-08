package model;

import java.util.Date;


public class Question {
//    int questionId;
    String questionText;
    Date pubDate;
    
    public Question() {    	
    }
    
//    public Question(int questionId) {
//    	this.questionId = questionId;
//    }
    
    public Question(String questionText, Date pubDate) {
//    	this.questionId = questionId;
    	this.questionText = questionText;
    	this.pubDate = pubDate;
    }
    
    /* Getters and Setters below. */
    
//	public int getQuestionId() {
//		return questionId;
//	}
//	public void setQuestionId(int questionId) {
//		this.questionId = questionId;
//	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public Date getPubDate() {
		return pubDate;
	}
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
    
}
