package bar.piotr.chapters;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class BankStatementProcessor {

	private final List<BankTransaction> bankTransactions;

	public BankStatementProcessor(List<BankTransaction> bankTransactions) {
		// TODO Auto-generated constructor stub
		this.bankTransactions = bankTransactions;
	}

	public double calculateTotalAmount() {
		double amount = 0d;
		for (final BankTransaction bankTransaction : bankTransactions) {
			amount += bankTransaction.getAmount();
		}
		return amount;  
	}

	public double calculateTotalInMonth(final Month month) {
		double amount = 0d;
		for (final BankTransaction bankTransaction : bankTransactions) {
			if (bankTransaction.getDate().getMonth() == month) {
				amount += bankTransaction.getAmount();
			}
		}
		return amount;
	}

	public double calculateTotalForCategory(final String category) {
		double amount = 0d;
		for (final BankTransaction bankTransaction : bankTransactions) {
			if (bankTransaction.getDescription().equals(category)) {
				amount += bankTransaction.getAmount();
			}
		}
		return amount;
	}

	public double calculateTotalSpent() {
		double amount = 0d;
		for (final BankTransaction bankTransaction : bankTransactions) {
			if (bankTransaction.getAmount() < 0) {
				amount += bankTransaction.getAmount();
			}
		}
		return amount;
	}
	
	public double findMaxInPeriod(LocalDate startDate, LocalDate endDate) {
		
		double maxValue = Double.MIN_VALUE;
		
		for (final BankTransaction bankTransaction : bankTransactions) {
			if ((bankTransaction.getDate().isAfter(startDate)||bankTransaction.getDate().isEqual(startDate)) & (bankTransaction.getDate().isBefore(endDate)||bankTransaction.getDate().isEqual(endDate))) {
				if(bankTransaction.getAmount() > maxValue) {
					maxValue = bankTransaction.getAmount();
				};
			}
		}
		
		return maxValue;
	}
}
