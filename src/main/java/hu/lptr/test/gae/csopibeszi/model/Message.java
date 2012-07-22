package hu.lptr.test.gae.csopibeszi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message implements Serializable {

    private Long id;
	private String text;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
		return id;
	}
    
    public void setId(Long id) {
		this.id = id;
	}
    
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
}
