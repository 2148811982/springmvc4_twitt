package twitt.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Twitt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column
	private String text;
	
	@Column(name = "publish_time")
	private Date publishTime;
	
	/*@Column(name = "user_id")
	private Long userId;*/
	@ManyToOne(cascade = {CascadeType.DETACH})
	@JoinColumn(name="user_id")
	private TwUser user;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public TwUser getUser() {
		return user;
	}

	public void setUser(TwUser user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "title=" + title + ": text=" + text;
	}
}
