package toread.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;

import lombok.Data;

@Embeddable
public @Data class Author {
	@Column(name="author")
	private String name;
	@Column(name="author_expertise")
	private String expertise;
	@Column(name="author_profession")
	private String profession;
	@OneToMany
	private List<Book> books;
	
	public Author() {
		super();
	}
	
	public Author(String name, String expertise, String profession) {
		super();
		this.name = name;
		this.expertise = expertise;
		this.profession = profession;
	}
	
	public Author(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Author [name=" + name + ", expertise=" + expertise + ", profession=" + profession + "]";
	}
}
