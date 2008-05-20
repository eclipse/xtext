/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parseerrorhandling;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.xtext.XtextGrammarTest;
import org.eclipse.xtext.core.parser.IParseErrorHandler;
import org.eclipse.xtext.generator.tests.AbstractGeneratorTest;
import org.eclipse.xtext.parser.XtextGrammarTestASTFactory;

public class ParseErrorHandlingTest extends AbstractGeneratorTest {

	public void testLexError() throws Exception {
		ErrorHandler errors = new ErrorHandler();
		getInvocations("import 'holla' % as foo", errors);
		assertEquals("%", errors.get(0).text);
		assertEquals(1, errors.get(0).line);
		assertEquals(15, errors.get(0).offset);
		assertEquals(1, errors.get(0).length);
		assertEquals(1, errors.size());
	}

	public void testParseError1() throws Exception {
		ErrorHandler errors = new ErrorHandler();
		getInvocations("import 'holla' foo returns x::y::Z : name=ID;", errors);
		assertEquals("::", errors.get(0).text);
		assertEquals(1, errors.get(0).line);
		assertEquals(31, errors.get(0).offset);
		assertEquals(2, errors.get(0).length);
		assertEquals(1, errors.size());
	}
	
	public void testParseError2() throws Exception {
		ErrorHandler errors = new ErrorHandler();
		Object object = getModel("import 'holla' foo returns y::Z : name=ID #;", new XtextGrammarTestASTFactory(), errors);
		assertWithXtend("'ID'", "parserRules.first().eAllContents.typeSelect(XtextTest::RuleCall).first().name", object);
	}
	
	public void testParseError3() throws Exception {
		ErrorHandler errors = new ErrorHandler();
		Object object = getModel("import 'holla' foo returns y::Z : name=ID #############", new XtextGrammarTestASTFactory(), errors);
		assertWithXtend("'ID'", "parserRules.first().eAllContents.typeSelect(XtextTest::RuleCall).first().name", object);
	}
	
	public void testParseError4() throws Exception {
		ErrorHandler errors = new ErrorHandler();
		Object object = getModel("import 'holla' foo returns y::Z : name=ID # 'foo'; bar : 'stuff'", new XtextGrammarTestASTFactory(), errors);
		System.out.println(errors);
		assertWithXtend("'ID'", "parserRules.first().eAllContents.typeSelect(XtextTest::RuleCall).first().name", object);
		assertWithXtend("null", "parserRules.first().eAllContents.typeSelect(XtextTest::Keyword).first().name", object);
		assertWithXtend("\"'stuff'\"", "parserRules.get(1).eAllContents.typeSelect(XtextTest::Keyword).first().value", object);
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
		
		@Override
		public String toString() {
			StringBuffer buff = new StringBuffer();
			for (ErrorEntry e : errors) {
				buff.append(e.toString()).append("\n");
			}
			return buff.toString();
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
