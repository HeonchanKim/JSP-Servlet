package day12;

// ���� ���¸� ǥ���ϴ� Ŭ���� BankAccount
class BankAccount{
	// �ʵ�
	private String owner;
	private int accountNumber;
	private int balance;
	
	
	
	// ������
	public BankAccount(String owner, int accountNumber) {
		setOwner(owner);
		setAccountNumber(accountNumber);
	}
	public BankAccount() {
		this.owner = null;
		this.accountNumber = 0;
	}
	
	// ������
	private void setOwner(String owner) {
		// TODO: �̸� �˻�
		this.owner = owner != null ? owner : null; 
		}
	private void setAccountNumber(int accountNumber) {
		// TODO: ���� ��ȣ �˻�
		this.accountNumber = accountNumber;
		}
	
	// ������
	public String getOwner() { return owner; }
	public int getAccountNumber() { return accountNumber; }
	public int getBalance() { return balance; }
	
	// �޼���
	public BankAccount deposite(int amount) {
		// �Ա��ϴ� �ݾ��� �ݵ�� 0���� Ŀ���Ѵ�!
		if (amount <= 0) {
			System.out.println("[ERROR] Invalid amount!");
			return this;
		}
		// �Ա��ϸ� �ܰ� ����
		balance += amount;
		
		System.out.println("You have deposited " + amount + " won.");
		// ��ü �ڽ��� ��ȯ
		return this;
	}
	public BankAccount withdraw(int amount) {
		// ����ϴ� �ݾ��� �ݵ�� 0���� Ŀ���ϰ� �ܰ��� �۾�� �Ѵ�!
		// -> amount > 0 && amount < balance
		//  !(amount > 0 && amount < balance)
		// -> amount <= 0 || amount >= balance
		if (amount <= 0 || amount >= balance) {
			System.out.println("[ERROR] Invalid amount!");
			return this;
		}
		// ����ϸ� �ܰ� ����
		balance -= amount;
		System.out.println("You have withdrawn " + amount + " won.");
		// ��ü �ڽ��� ��ȯ
		return this;
	}
	
	
	// ���
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
		// ��ü ����
		BankAccount myAccount = new BankAccount("Michael Jackson", 13275);
		
		myAccount.print();
		myAccount.deposite(10000).printBalance();
		myAccount.withdraw(5000).printBalance();
		// �Ӽ� ���� �������� ù��°�� ��ü, �ι�°�� �޼ҵ峪 �ʵ尡 �Ǿ���Ѵ�!!
		// deposite �� withdraw�� ��ȯ���� myAccount�� �Ǿ���Ѵ�
	}
}
