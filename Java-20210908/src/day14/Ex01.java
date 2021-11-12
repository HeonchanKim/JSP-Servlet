package day14;

/*
 * 성별을 표현하는 열거형
 * */
enum Gender {
	UNDISCLOSDED, MALE, FEMALE, NATURAL;
} 

/*
 * 
 * 사람을 표현하는 클래스
 * */
class Person{
	private String name;
	private int age;
	private Gender gender;
	
	public Person(String name, int age, Gender gender) {
		this.name = name;
		setAge(age);
		this.gender = gender;
	}
	
	public Person() {
		this(null, 0 , Gender.UNDISCLOSDED);
	}
	
	public void setName(String name) { this.name = name; }
	public void setAge(int age) { this.age = age; }
	public void setGender(Gender gender) { this.gender = gender; }
	
	public String getName() { return name; }
	public int age() { return age; }
	public Gender gender() { return gender; }
	
	public void print() {
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Gender: " + gender);
	}
}

/*
 * 선생님을 표현하는 클래스
 * */

class Teacher extends Person {
	private int id;
	private String subject;
	
	public Teacher(String name, int age, Gender gender, int id, String subject) {
		super(name, age, gender);
		
		setId(id);
		this.subject = subject;
	}
	
	public Teacher() {
		this(null, 0, Gender.UNDISCLOSDED, 0, null);
	}
	
	public void setId(int id) { 
		// TODO: 올바른 ID인지 검사
		this.id = id;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public int getId() { return id; }
	public String getSubject() { return subject; }
	
	@Override
	public void print() {
		super.print();
		System.out.println("ID: " + id);
		System.out.println("Subject: " + subject);
		System.out.println();
	}
}

/*
 * 학생을 표현하는 클래스
 * */

class Student extends Person {
	private int id;
	private int year;
	private double gpa;
	
	public Student(String name, int age, Gender gender, int id, int year, double gpa) {
		super(name, age, gender);
		
		setId(id);
		setYear(year);
		setGpa(gpa);
	}
	public Student() {
		this(null, 0, Gender.UNDISCLOSDED, 0, 0, 0);
	}
	
	public void setId(int id) { 
		//TODO: 올바른 ID인지 검사
		this.id = id; 
		}
	public void setYear(int year) {
		// TODO: 올바른 학년인지 검사
		this.year = year >= 1 && year <= 12 ? year : 0; 
		}
	public void setGpa(double gpa) {
		// TODO: 올바른 GPA인지 검사
		this.gpa = gpa >= 0 && gpa <= 4.5 ? gpa : 0;
		}
	
	public int getId() { return id; }
	public int getYear() { return year; }
	public double getGpa() { return gpa; }
	
	@Override
	public void print() {
		super.print();
		
		System.out.println("ID: " + id);
		System.out.println("Year: " + year);
		System.out.println("GPA: " + gpa);
	}
	
}

public class Ex01 {
	public static void main(String[] args) {

		// 객체 생성
		Teacher porter = new Teacher("Harry Potter", 37, Gender.MALE, 371, "Defense of the Dark");
		Student rose = new Student("Rose Granger-Weasley", 11, Gender.FEMALE, 7128, 2, 4.2);
		
		// 출력
		porter.print();
		rose.print();
		
		// Person 클래스의 배열
		Person list[] = new Person[2];
		
		list[0] = porter;
		list[1] = rose;
		
		for (int i = 0; i < list.length; i++)
			list[i].print();
		
	}
}
