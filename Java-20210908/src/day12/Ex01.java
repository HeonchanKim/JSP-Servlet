package day12;

// 책상 조명등을 표현하는 클래스 DeskLamp
class DeskLamp{
	private boolean isOn;

	public DeskLamp() { isOn = false; }
	
	public void turnOn() { isOn = true; }
	public void turnOff() { isOn = false; }
	
	public void printStatus() {
		System.out.println("Status: " + (isOn ? "On" : "Off"));
	}
}
public class Ex01 {
	public static void main(String[] args) {
		// 객체 생성
		DeskLamp myLamp = new DeskLamp();
		
		myLamp.turnOn();
		myLamp.printStatus();
		myLamp.turnOff();
		myLamp.printStatus();
	}
}
