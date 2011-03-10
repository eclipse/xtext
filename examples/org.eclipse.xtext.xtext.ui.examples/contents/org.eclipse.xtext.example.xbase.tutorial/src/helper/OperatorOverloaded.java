package helper;

public class OperatorOverloaded {
	public String operator_plus(String b) {
		return "x + "+b;
	}
	public String operator_minus(String b) {
		return "x - "+b;
	}
	public String operator_add(String b) {
		return "x += "+b;
	}
	public String operator_power(String b) {
		return "x ^ "+b;
	}
	public String operator_divide(String b) {
		return "x / "+b;
	}
	public String operator_or(String b) {
		return "x || "+b;
	}
	public String operator_and(String b) {
		return "x && "+b;
	}
	public String operator_equals(String b) {
		return "x == "+b;
	}
	public String operator_notEquals(String b) {
		return "x != "+b;
	}
	public String operator_lessThan(String b) {
		return "x < "+b;
	}
	public String operator_greaterThan(String b) {
		return "x > "+b;
	}
	public String operator_lessEqualsThan(String b) {
		return "x <= "+b;
	}
	public String operator_greaterEqualsThan(String b) {
		return "x >= "+b;
	}
	public String operator_mappedTo(String b) {
		return "x => "+b;
	}
	public String operator_upTo(String b) {
		return "x .. "+b;
	}

	//TODO fix unary operators
//	public String operator_not() {
//		return "!x";
//	}
//	public String operator_minus() {
//		return "-x";
//	}
}
