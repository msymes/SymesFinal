package app;

import java.util.LinkedList;
import org.apache.poi.ss.formula.functions.*;
public class Loan {
	double dLoanAmount;
	double dInterestRate;
	double iTerm;
	double dFutureValue = 0;
	boolean bInterestCalc = true;
	double dExtraPayment;
	public int numberPayments = (int)iTerm*12;
	public double totalInterest;
	
	public LinkedList<Payment> loanPayments = new LinkedList<Payment>();
	
	
	public Loan(double dLoanAmount, double dInterestRate, double iTerm, double ExtraPayment) {
		super();
		this.dLoanAmount = dLoanAmount;
		this.dInterestRate = dInterestRate;
		this.iTerm = iTerm;
		this.dExtraPayment = ExtraPayment;
		Amortization();
	}
	
		
	
	public void Amortization(){
		double newbal;
		double month_interest = (dInterestRate / 12);
		int number_payments = (int)iTerm * 12;
		double interest_payment;
		double principal_payment;
		double balance = dLoanAmount;
		int i =0;

		double payment = dLoanAmount * month_interest /
               ( 1 - 1 / Math.pow(1 + month_interest, number_payments) );
		
		for(i=0; i<number_payments;i++) {
			if(balance<(payment+dExtraPayment)) {
				break;
			}
			interest_payment = balance * month_interest;
			principal_payment = payment - interest_payment + dExtraPayment; 
			newbal = balance - principal_payment; 
			balance = newbal; 
			Payment p = new Payment(payment, interest_payment,principal_payment,i,balance);
			loanPayments.add(p);
			totalInterest += interest_payment;
		}
		// last month
		principal_payment = balance;
		interest_payment = balance * month_interest;
		payment = principal_payment + interest_payment;
		newbal = 0.0;
		balance = 0.0;
		Payment p = new Payment(payment, interest_payment,principal_payment,i+1,balance);
		loanPayments.add(p);
		numberPayments = i+1;
		totalInterest+= interest_payment;

}
	public class Payment {
		private double Payment;
		private double Interest;
		private double Principal;
		private int PaymentNumber;
		private double Balance;
		
		public double getPayment() {
			return Payment;
		}

		public void setPayment(double payment) {
			Payment = payment;
		}

		public double getInterest() {
			return Interest;
		}

		public void setInterest(double interest) {
			Interest = interest;
		}

		public double getPrincipal() {
			return Principal;
		}

		public void setPrincipal(double principal) {
			Principal = principal;
		}

		public int getPaymentNumber() {
			return PaymentNumber;
		}

		public void setPaymentNumber(int paymentNumber) {
			PaymentNumber = paymentNumber;
		}

		public double getBalance() {
			return Balance;
		}

		public void setBalance(double balance) {
			Balance = balance;
		}

		public Payment(double payment, double interest, double principal, int number, double Balance) {
			this.Payment = payment;
			this.Interest = interest;
			this.Principal = principal;
			this.PaymentNumber = number;
			this.Balance = Balance;
		}
	}
}
	