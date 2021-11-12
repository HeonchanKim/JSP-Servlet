package day12;

// å�� ������� ǥ���ϴ� Ŭ���� DeskLamp
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
		// ��ü ����
		DeskLamp myLamp = new DeskLamp();
		
		myLamp.turnOn();
		myLamp.printStatus();
		myLamp.turnOff();
		myLamp.printStatus();
	}
}
