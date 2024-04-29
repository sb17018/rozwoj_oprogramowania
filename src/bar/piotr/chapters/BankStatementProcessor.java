package bar.piotr.chapters;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
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
	
	public List<BankTransaction> findTransactions(final BankTransactionFilter bankTransactionFilter) {
		
		final List<BankTransaction> result = new ArrayList<>();
		
		for (final BankTransaction bankTransaction : bankTransactions) {
			if (bankTransactionFilter.test(bankTransaction)) {
				result.add(bankTransaction);
			}
		}	
		return result;
	}
}
