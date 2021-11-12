package day10;

public class Student {
	// �ʵ�
	private String name;
	private int korean;
	private int math;
	private int english;
	private double average;
	private char grade;
	
	// �޼���
	
	// ������
	public Student(String name, int korean, int math, int english) {
		this.name = name;
		this.korean = korean;
		this.math = math;
		this.english = english;
	}
	public Student() {
		this(null, 0, 0, 0);
		// null ���������� �ƹ��͵� ���������ʴ°��� ��Ÿ��
	}
	
	public Student(Student copy) {
		this(copy.name, copy.korean, copy.math, copy.english);
	}
	
	// ������
	public void setName(String name) { this.name = name; }
	public void setKorean(int korean) { this.korean = isValidScore(korean) ? korean : 0; }
	public void setMath(int math) { this.math = isValidScore(math) ? math: 0; }
	public void setEnglish(int english) { this.english = isValidScore(english) ? english: 0; }
	
	// ��ȿ�� �������� �˻� 
	public boolean isValidScore(int score) {
		return score >= 0 && score <= 100;
	}
	
	// ������
	public String getName() { return name; }
	public int getKorean() { return korean; }
	public int getMath() { return math; }
	public int getEnglish() { return english; }
	
	public double getAverage() {
		average = (double)(korean + math + english) / 3;
		return average;
	}
	public char getGrade() {
		getAverage();
		
		if(average >= 90) grade = 'A';
		else if(average >= 80) grade = 'B';
		else if(average >= 70) grade = 'C';
		else if(average >= 60) grade = 'D';
		else grade = 'F';
		
		return grade;
	}
	
	// ���
	public void print() {
		System.out.println("name : " + name);
		// System.out.println("average : " + getAverage());
		System.out.printf("average : %.2f\n", getAverage());
		// System.out.println("grade : " + getGrade());
		System.out.printf("grade : %s", getGrade());
		System.out.println();
	}
}
