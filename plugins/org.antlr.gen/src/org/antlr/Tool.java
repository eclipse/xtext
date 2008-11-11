package org.antlr;

public class Tool {

	private static final String MESSAGE = "This is a dummy implementation! Please install Real Antlr Generator Plugin 3.0.1";

	public Tool(String[] strings) {
		System.out.println(MESSAGE);
	}

	public void process() {
		System.err.println(MESSAGE);
	}

}
