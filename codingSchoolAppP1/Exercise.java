package codingSchoolAppP1;

public class Exercise {
	private int id;
	private String title;
	private String description;
	
	public Exercise(String title, String description) {
		this.title = title;
		this.description = description;
	}
	
	public Exercise() {}
	
	public String toString() {
		return "Title: '" + title + "'\n" + "Description: '" + description + "'";
	}
	
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public Exercise setTitle(String title) {
		this.title = title;
		return this;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Exercise setDescription(String description) {
		this.description = description;
		return this;
	}
	
}
