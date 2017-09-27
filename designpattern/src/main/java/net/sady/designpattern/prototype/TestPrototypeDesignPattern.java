package net.sady.designpattern.prototype;

public class TestPrototypeDesignPattern {

	public static void main(String[] args) {
		
		Student student = new Student("Shadyaab", 21, true);
		System.out.println(student.toString());
		
		// Instead of creating new object which is expensive we can clone the existing object and then use it 
		Student student2 = (Student) student.getClone();
		student2.setName("Sady");
		System.out.println(student2.toString());
		
		//Checking if the original object is not overridden 
		System.out.println(student.toString());
	}
}
