package day14;

/*
 * ������ ǥ���ϴ� ������
 * */
enum Gender {
	UNDISCLOSDED, MALE, FEMALE, NATURAL;
} 

/*
 * 
 * ����� ǥ���ϴ� Ŭ����
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
 * �������� ǥ���ϴ� Ŭ����
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
		// TODO: �ùٸ� ID���� �˻�
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
 * �л��� ǥ���ϴ� Ŭ����
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
		//TODO: �ùٸ� ID���� �˻�
		this.id = id; 
		}
	public void setYear(int year) {
		// TODO: �ùٸ� �г����� �˻�
		this.year = year >= 1 && year <= 12 ? year : 0; 
		}
	public void setGpa(double gpa) {
		// TODO: �ùٸ� GPA���� �˻�
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

		// ��ü ����
		Teacher porter = new Teacher("Harry Potter", 37, Gender.MALE, 371, "Defense of the Dark");
		Student rose = new Student("Rose Granger-Weasley", 11, Gender.FEMALE, 7128, 2, 4.2);
		
		// ���
		porter.print();
		rose.print();
		
		// Person Ŭ������ �迭
		Person list[] = new Person[2];
		
		list[0] = porter;
		list[1] = rose;
		
		for (int i = 0; i < list.length; i++)
			list[i].print();
		
	}
}
