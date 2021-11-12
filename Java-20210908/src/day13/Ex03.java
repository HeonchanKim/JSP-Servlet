package day13;

enum Genders{
	Undisclosed, Male, Female, Natural;
}

class Person{
	private String name;
	private int age;
	private int gender;
	
	// 생성자
	public Person(String name, int age, int gender) {
		setName(name);
		setAge(age);
		setGender(gender);
	}
	public Person() { this(null, 0, 0); }
	
	// 설정자
	public void setName(String name) { this.name = name; }
	public void setAge(int age) { this.age = age; }
	public void setGender(int gender) { this.gender = gender; }
	// 접근자
	
	// 출력
	public void print() {
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Gender: " + gender);
	}
}

class Teacher extends Person {
	private int id;
	private String subject;
	
	// 생성자
	public Teacher(String str1, int n1, int n2, int n3, String str2) {
		super(str1, n1, n2);
		id = n3;
		subject = str2;
	}
	public Teacher() { this(null, 0, 0, 0, null); }
	// 설정자
	public void setId(int id) { this.id = id; }
	public void setSubject(String subject) { this.subject = subject; }
	
	// 출력
	@Override
	public void print() {
		super.print();
		System.out.println("ID: " + id);
		System.out.println("Subject: " + subject);
		System.out.println();
	}
}

class Student extends Person {
	private int id;
	private int year;
	private double gpa;
	
	// 생성
	public Student(String str3, int n4, int n5, int n6, int n7, double n8) {
		super(str3, n4, n5);
		id = n6;
		year = n7;
		gpa = n8;
	}
	public Student() { this(null, 0, 0, 0, 0, 0); }
	// 설정자
	public void setId(int id) { this.id = id; }
	public void setYear(int year) { this.year = year; }
	public void setGpa(double gpa) { this.gpa = gpa; }
	// 출력
	@Override
	public void print() {
		super.print();
		System.out.println("ID: " + id);
		System.out.println("Year: " + year);
		System.out.println("GPA: " + gpa);
	}
}
public class Ex03 {
	public static void main(String[] args) {
		
		
		// Undisclosed, Male, Female, Natural;
		Genders Undisclosed = Genders.Undisclosed;
		Genders Male = Genders.Male;
		Genders Female = Genders.Female;
		Genders Natural = Genders.Natural;
		
		
		
		Teacher objTeacher = new Teacher("Harry Potter", 37, 1, 371, "Defense of the Dark");
		Student objStudent = new Student("Rose Granger-Weasley", 11, 2, 7128, 2, 4.2);
		
		objTeacher.print();
		objStudent.print();
	}
}
