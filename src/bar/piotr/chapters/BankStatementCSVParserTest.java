package bar.piotr.chapters;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Assert;
import org.junit.Test;

public class BankStatementCSVParserTest {
	
	
	final BankStatementParser bankStatementParser = new BankStatementCSVParser();
	
	@Test
	public void shouldParseOneCorrectLine() throws Exception{
		
		final String line = "30-01-2017,-50,Tesco";
		final String line2 = "18-07-2019,-12,Car Wash";
		
		final BankTransaction result = bankStatementParser.parseFrom(line);
		final BankTransaction result2 = bankStatementParser.parseFrom(line2);
		
		final BankTransaction expected = new BankTransaction(LocalDate.of(2017,  Month.JANUARY, 30), -50, "Tesco");
		final BankTransaction expected2 = new BankTransaction(LocalDate.of(2019,  Month.JULY, 18), -12, "Car Wash");
		
		final double tolerance = 0d;
		
		Assert.assertEquals(expected.getDate(), result.getDate());
		Assert.assertEquals(expected.getAmount(), result.getAmount(), tolerance);
		Assert.assertEquals(expected.getDescription(), result.getDescription());
		Assert.assertEquals(expected2.getDate(), result2.getDate());
		Assert.assertEquals(expected2.getAmount(), result2.getAmount(), tolerance);
		Assert.assertEquals(expected2.getDescription(), result2.getDescription());

//		System.out.println(expected.toString() + result.toString());
	}

}
