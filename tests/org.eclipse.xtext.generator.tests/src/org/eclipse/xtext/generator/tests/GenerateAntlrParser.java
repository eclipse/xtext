package org.eclipse.xtext.generator.tests;

import org.antlr.Tool;

public class GenerateAntlrParser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tool antlr = new Tool(new String[] { "./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g"});
		antlr.process();

	}

}
