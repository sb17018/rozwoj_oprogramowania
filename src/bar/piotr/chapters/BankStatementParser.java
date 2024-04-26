package bar.piotr.chapters;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface BankStatementParser {
	
	BankTransaction parseFrom(final String line);

	List<BankTransaction> parseLinesFrom(final List<String> lines);


}
