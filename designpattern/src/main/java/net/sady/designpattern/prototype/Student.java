package net.sady.designpattern.prototype;

public class Student implements Prototype{

	private String name;
	private int age;
	private boolean sex;
	
	public Student(String name, int age, boolean sex){
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	
	public Prototype getClone() {
		return new Student(this.name,this.age, this.sex);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}
	
	
}
