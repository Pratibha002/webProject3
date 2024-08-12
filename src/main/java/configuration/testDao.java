package configuration;

public class testDao {
	// Declares the class testDao as public, meaning it can be accessed from other packages. 
	//This class is used to encapsulate data related to a student.
	
	public int id;
	public String name;
	public int marks;
	public String city;
	
	
	//Defines a constructor that initializes a new testDao object with id, name, marks, and city. 
	//The this keyword is used to refer to the current object's fields and to distinguish them from the constructor parameters.
	public testDao(int id, String name, int marks, String city) {
		this.id=id;
		this.name=name;
		this.marks=marks;
		this.city=city;
	}
	
	public int getId() {
		return id;
		//It returns the value of id.
	}

	public void setId(int id) {
		this.id = id;
		//It sets the value of id to the provided parameter.
	}

	public String getName() {
		return name;
		// It returns the value of name.
	}

	public void setName(String name) {
		this.name = name;
		//It sets the value of name to the provided parameter.
	}

	public int getMarks() {
		return marks;
		// It returns the value of marks.
	}

	public void setMarks(int marks) {
		this.marks = marks;
		// It sets the value of marks to the provided parameter.
	}

	public String getCity() {
		return city;
		//It returns the value of city.
	}

	public void setCity(String city) {
		this.city = city;
		// It sets the value of city to the provided parameter.
	}
	 @Override
	 //@Override: Annotation indicating that the toString method overrides a method from the superclass (Object class).
	 
	    public String toString() {
	        return "testDao [id=" + id + ", name=" + name + ", marks=" + marks + ", city=" + city + "]";
	    }
	 //@Override: Annotation indicating that the toString method overrides a method from the superclass (Object class).

}
