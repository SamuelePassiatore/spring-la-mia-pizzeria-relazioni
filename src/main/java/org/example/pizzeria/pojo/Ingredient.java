package org.example.pizzeria.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Ingredient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	private String name;

	@Column(columnDefinition = "TEXT")
	@Size(min = 0, max = 65536)
	private String description;

	@ManyToMany(mappedBy = "categories")
	private List<Book> books;

	public Category() { }
	public Category(String name) {

		setName(name);
	}
	public Category(String name, String description) {

		this(name);

		setDescription(description);
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private boolean hasDescription() {

		return getDescription() != null;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {

		return "[" + getId() + "] " + getName() + 
				(hasDescription() ? "\n" + getDescription() : "");
	}
	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Category)) return false;

		Category cObj = (Category) obj;

		return getId() == cObj.getId();
	}
	@Override
	public int hashCode() {

		return getId();
	}
}
