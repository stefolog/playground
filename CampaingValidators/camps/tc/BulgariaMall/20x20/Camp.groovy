import com.stefolog.test.InputData;
import com.stefolog.test.Calculator;

class Camp implements Calculator {
	def BigDecimal points(InputData data) {
		return (data.amount / 10).toLong();
	}	
}
