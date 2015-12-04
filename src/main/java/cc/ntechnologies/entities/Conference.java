package cc.ntechnologies.entities;

import java.util.Date;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Parent;

@Entity
public class Conference {
	@Id Long id ; 
	@Index private String topic;
	@Index private Date date;

	//relations
	// @Load @Parent private List<Ref<Speaker>> speakers;
	@Parent private Ref<Room> room;

	public Conference() {
		
	}
}
