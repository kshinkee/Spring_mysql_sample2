package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="question")
public class Question implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int questionId;
	
	@Column(name="QUESTION_TEXT")
    private String questionText;
    
	@Column(name="PUB_DATE")
    private Date pubDate;
    
    public Question() {    	
    }
    
    public Question(int questionId) {
    	this.questionId = questionId;
    }
    
    public Question(int questionId, String questionText, Date pubDate) {
    	this.questionId = questionId;
    	this.questionText = questionText;
    	this.pubDate = pubDate;
    }
    
    /* Getters and Setters below. */
    
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
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
