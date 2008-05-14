package org.eclipse.xtext.parseerrorhandling;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.XtextGrammarTest;
import org.eclipse.xtext.core.parser.IParseErrorHandler;
import org.eclipse.xtext.generator.tests.AbstractGeneratorTest;

public class ParseErrorHandlingTest extends AbstractGeneratorTest {
	@Override
	protected Class<?> getTheClass() {
		return XtextGrammarTest.class;
	}

	public void testLexError() throws Exception {
		final List<String> errors = new ArrayList<String>();
		parse("import 'holla' % as foo", new IParseErrorHandler() {
			public void handleParserError(int offset, int length, String text, String message) {
				System.out.println(message + ":'" + text + "' (" + offset + "," + length + ")");
				errors.add(text);
			}
		});
		assertEquals("%",errors.get(0));
		assertEquals(1, errors.size());
	}
}
