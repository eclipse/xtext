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

import org.eclipse.xtext.XtextGrammarTestLanguageFacade;
import org.eclipse.xtext.XtextGrammarTestStandaloneSetup;
import org.eclipse.xtext.parser.IParseErrorHandler;
import org.eclipse.xtext.parser.XtextGrammarTestASTFactory;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

public class ParseErrorHandlingTest extends AbstractGeneratorTest {
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		XtextGrammarTestStandaloneSetup.doSetup();
		with(XtextGrammarTestLanguageFacade.LANGUAGE_ID);
	}

	public void testLexError() throws Exception {
		ErrorHandler errors = new ErrorHandler();
		getInvocations("import 'holla' % as foo", errors);
		assertEquals(1,errors.size());
		assertEquals("%", errors.get(0).getText());
		assertEquals(1, errors.get(0).getLine());
		assertEquals(15, errors.get(0).getOffset());
		assertEquals(1, errors.get(0).getLength());
		assertEquals(1, errors.size());
	}
	
	public void testStuff() throws Exception {
		System.out.println(getRootNode("import 'holla' % as foo",new ErrorHandler()).serialize());
	}

	public void testParseError1() throws Exception {
		ErrorHandler errors = new ErrorHandler();
		getInvocations("import 'holla' foo returns x::y::Z : name=ID;", errors);
		assertEquals("::", errors.get(0).getText());
		assertEquals(1, errors.get(0).getLine());
		assertEquals(31, errors.get(0).getOffset());
		assertEquals(2, errors.get(0).getLength());
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
		//System.out.println(errors);
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

		public void handleParserError(LeafNode node, String message,
				Object context) {
			errors.add(new ErrorEntry(node, message, context));
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
		String message;
		Object context;
		private LeafNode node;
		public ErrorEntry(LeafNode node2, String message, Object context) {
			super();
			this.node = node2;
			this.message = message;
			this.context = context;
		}
		
		
		public int getLine() {
			return node.line();
		}


		public int getOffset() {
			return node.offset();
		}


		public int getLength() {
			return node.length();
		}


		public String getText() {
			return node.serialize();
		}


		public String getMessage() {
			return message;
		}


		public Object getContext() {
			return context;
		}


		public String toString() {
			return "token:" + node.serialize() + ",message:" + message;
		}
	}

}
