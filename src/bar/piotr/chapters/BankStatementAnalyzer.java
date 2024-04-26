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
public class BankStatementAnalyzer {

//	private final static String RESOURCES = "../../../resources/";
	private static final String RESOURCES = "C:/Users/piotr/eclipse-workspace/RozwojOprogramowaniaWPraktyce/resources/";

	/**
	 * @param args
	 * @throws IOException
	 */
	
	public void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException{
		
		final Path path = Paths.get(RESOURCES, fileName);
		final List<String> lines = Files.readAllLines(path);
		
		final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
		
		final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
		
		collectSummary(bankStatementProcessor);
	}
	
	private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
		System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());
		System.out.println("The total in January " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
		System.out.println("The total as salary " + bankStatementProcessor.calculateTotalForCategory("Salary"));		
	}
}