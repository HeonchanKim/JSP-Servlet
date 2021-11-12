package day12;

// 은행 계좌를 표현하는 클래스 BankAccount
class BankAccount{
	// 필드
	private String owner;
	private int accountNumber;
	private int balance;
	
	
	
	// 생성자
	public BankAccount(String owner, int accountNumber) {
		setOwner(owner);
		setAccountNumber(accountNumber);
	}
	public BankAccount() {
		this.owner = null;
		this.accountNumber = 0;
	}
	
	// 설정자
	private void setOwner(String owner) {
		// TODO: 이름 검사
		this.owner = owner != null ? owner : null; 
		}
	private void setAccountNumber(int accountNumber) {
		// TODO: 계좌 번호 검사
		this.accountNumber = accountNumber;
		}
	
	// 접근자
	public String getOwner() { return owner; }
	public int getAccountNumber() { return accountNumber; }
	public int getBalance() { return balance; }
	
	// 메서드
	public BankAccount deposite(int amount) {
		// 입금하는 금액은 반드시 0보다 커야한다!
		if (amount <= 0) {
			System.out.println("[ERROR] Invalid amount!");
			return this;
		}
		// 입금하면 잔고 증가
		balance += amount;
		
		System.out.println("You have deposited " + amount + " won.");
		// 객체 자신을 반환
		return this;
	}
	public BankAccount withdraw(int amount) {
		// 출금하는 금액은 반드시 0보다 커야하고 잔고보다 작어야 한다!
		// -> amount > 0 && amount < balance
		//  !(amount > 0 && amount < balance)
		// -> amount <= 0 || amount >= balance
		if (amount <= 0 || amount >= balance) {
			System.out.println("[ERROR] Invalid amount!");
			return this;
		}
		// 출금하면 잔고 감소
		balance -= amount;
		System.out.println("You have withdrawn " + amount + " won.");
		// 객체 자신을 반환
		return this;
	}
	
	
	// 출력
	public void printBalance() {
		System.out.println("Balance: " + balance + "\n");
	}
	public void print() {
		System.out.println("Owner: " + owner);
		System.out.println("Account Nuber: " + accountNumber);
		printBalance();
	}
}

public class Ex02 {
	public static void main(String[] args) {
		// 객체 생성
		BankAccount myAccount = new BankAccount("Michael Jackson", 13275);
		
		myAccount.print();
		myAccount.deposite(10000).printBalance();
		myAccount.withdraw(5000).printBalance();
		// 속성 접근 연산자의 첫번째는 객체, 두번째는 메소드나 필드가 되어야한다!!
		// deposite 과 withdraw의 반환값이 myAccount가 되어야한다
	}
}
