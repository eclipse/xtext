package org.eclipse.xtext.parseerrorhandling;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.xtext.XtextGrammarTest;
import org.eclipse.xtext.core.parser.IParseErrorHandler;
import org.eclipse.xtext.generator.tests.AbstractGeneratorTest;

public class ParseErrorHandlingTest extends AbstractGeneratorTest {

	public void testLexError() throws Exception {
		ErrorHandler errors = new ErrorHandler();
		parse("import 'holla' % as foo", errors);
		assertEquals("%", errors.get(0).text);
		assertEquals(1, errors.get(0).line);
		assertEquals(15, errors.get(0).offset);
		assertEquals(1, errors.get(0).length);
		assertEquals(1, errors.size());
	}

	public void testParseError1() throws Exception {
		ErrorHandler errors = new ErrorHandler();
		parse("import 'holla' foo returns x::y::Z : name=ID;", errors);
		assertEquals("::", errors.get(0).text);
		assertEquals(1, errors.get(0).line);
		assertEquals(31, errors.get(0).offset);
		assertEquals(2, errors.get(0).length);
		assertEquals(1, errors.size());
	}

	private final class ErrorHandler implements IParseErrorHandler {
		private final List<ErrorEntry> errors = new ArrayList<ErrorEntry>();


		public void clear() {
			errors.clear();
		}


		public ErrorEntry get(int arg0) {
			return errors.get(arg0);
		}


		public Iterator<ErrorEntry> iterator() {
			return errors.iterator();
		}


		public int size() {
			return errors.size();
		}


		public void handleParserError(int line, int offset, int length, int token, String text, String message,
				Object context) {
			errors.add(new ErrorEntry(line, offset, length, token, text, message, context));
		}
	}

	private final class ErrorEntry {
		int line;
		int offset;
		int length;
		int token;
		String text;
		String message;
		Object context;
		public ErrorEntry(int line, int offset, int length, int token, String text, String message, Object context) {
			super();
			this.line = line;
			this.offset = offset;
			this.length = length;
			this.token = token;
			this.text = text;
			this.message = message;
			this.context = context;
		}
		
		
		public int getLine() {
			return line;
		}


		public int getOffset() {
			return offset;
		}


		public int getLength() {
			return length;
		}


		public int getToken() {
			return token;
		}


		public String getText() {
			return text;
		}


		public String getMessage() {
			return message;
		}


		public Object getContext() {
			return context;
		}


		public String toString() {
			return text + ",l:" + line + ",os:" + offset + ",token:" + token + ",message:" + message;
		}
	}

	@Override
	protected Class<?> getTheClass() {
		return XtextGrammarTest.class;
	}

}
