package entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Conference")
public class Conference {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name="topic")
	private String topic;
	// DATE + HOUR
	
	
	//relations
	@OneToOne
	@JoinColumn(name = "room_fk",nullable = false) 
	private Room room ;
	@OneToMany
	private Set<Speaker> Speakers	 ;
	
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public Long getId() {
		return id;
	}
	
	
	


}
