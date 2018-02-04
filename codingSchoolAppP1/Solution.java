package codingSchoolAppP1;

public class Solution {
	private int id;
	private String created;
	private String updated;
	private String description;
	
	public Solution(String created, String updated, String description) {
		this.created = created;
		this.updated = updated;
		this.description = description;
	}
	
	public Solution() {}
	
	public String toString() {
		return "Created: '" + created + "'\n" + "Updated: '" + updated + "'\n" + "Description: '" + description + "'";
	}
	
	public int getId() {
		return id;
	}
	
	public String getCreated() {
		return created;
	}
	
	public Solution setCreated(String created) {
		this.created = created;
		return this;
	}
	
	public String getUpdated() {
		return updated;
	}
	
	public Solution setUpdated(String updated) {
		this.updated = updated;
		return this;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Solution setDescription (String description) {
		this.description = description;
		return this;
	}

}
