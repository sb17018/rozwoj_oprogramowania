package bar.piotr.chapters;

@FunctionalInterface
public interface BankTransactionFilter {
	boolean test(BankTransaction bankTransaction);
}
