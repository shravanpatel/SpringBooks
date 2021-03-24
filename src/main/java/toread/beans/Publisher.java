package toread.beans;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
public @Data class Publisher {
	@Column(name="publisher")
	private String name;
	@Column(name="publisher_type")
	private String type;
	@Column(name="publisher_location")
	private String location;
	
	public Publisher() {
		super();
	}
	
	public Publisher(String name, String type, String location) {
		super();
		this.name = name;
		this.type = type;
		this.location = location;
	}
	
	public Publisher(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Publisher [name=" + name + ", type=" + type + ", location=" + location + "]";
	}
}
