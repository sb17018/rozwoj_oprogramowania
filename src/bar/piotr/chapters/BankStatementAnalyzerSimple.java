/**
 * 
 */
package bar.piotr.chapters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class BankStatementAnalyzerSimple {

	private final static String RESOURCES = "src/resources";
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();
		
		final String fileName = args[0];
		final Path path = Paths.get(RESOURCES, fileName);
		final List<String> lines = Files.readAllLines(path);

		final List<BankTransaction> bankTransactions = bankStatementParser.parseLineeFromCSV(lines);

		System.out.println("The total for all transactions is " + calculateTotalAmount(bankTransactions));
		System.out.println("Transactions in January " + selectInMonth(bankTransactions, Month.JANUARY));
	}

	
	public static double calculateTotalAmount(final List<BankTransaction> bankTransactions) {
		double amount = 0d;
		for(final BankTransaction bankTransaction : bankTransactions) {
			amount += bankTransaction.getAmount();
		}
		return amount;
	}
	
	public static List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions, Month month){
		List<BankTransaction> transactionsInMonth = new ArrayList<>();
		for(final BankTransaction bankTransaction : bankTransactions) {
			if(bankTransaction.getDate().getMonth() == month) {
				transactionsInMonth.add(bankTransaction);
			}
		}
		
		return transactionsInMonth ;
	}
}
