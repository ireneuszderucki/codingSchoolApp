package codingSchoolAppP1;

public class Group {
	private int id;
	private String name;
	
	public Group(String name) {
		this.name = name;
	}
	
	public Group() {}
	
	public String toString() {
		return "User_group name: '" + name + "'";
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Group setName(String name) {
		this.name = name;
		return this;
	}
	

}
