package helper;

import java.math.BigDecimal;

public class Amount {
	
	private BigDecimal value = null;

	public Amount(BigDecimal value) {
		super();
		this.value = value;
	}
	
	public Amount(String value) {
		super();
		this.value = new BigDecimal(value);
	}
	
	@Override
	public String toString() {
		return value.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
	}
	
	public Amount operator_plus(Amount other) {
		return new Amount(this.value.add(other.value));
	}
	
	public Amount operator_minus(Amount other) {
		return new Amount(this.value.subtract(other.value));
	}
	
	public Amount operator_multiply(int factor) {
		return new Amount(this.value.multiply(new BigDecimal(factor)));
	}
	
	public Amount operator_divide(int divisor) {
		return new Amount(this.value.divide(new BigDecimal(divisor)));
	}
	
}
