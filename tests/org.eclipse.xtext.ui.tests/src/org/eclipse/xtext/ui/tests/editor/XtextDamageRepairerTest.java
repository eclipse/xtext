/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor;

import junit.framework.TestCase;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.ui.editor.XtextDamagerRepairer;

import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class XtextDamageRepairerTest extends TestCase {

	private IRegion check(String before, int start, int replaceLength, String text) throws BadLocationException {
		Document doc = new Document(before);
		XtextDamagerRepairer repairer = new XtextDamagerRepairer(getTokenScanner(), new Provider<Lexer>() {

			public Lexer get() {
				return new org.eclipse.xtext.parser.antlr.internal.InternalXtextLexer();
			}
		});
		repairer.setDocument(doc);
		Listener listener = new Listener(repairer);
		doc.addDocumentListener(listener);
		doc.replace(start, replaceLength, text);
		return listener.lastRegion;
	}
	
	private void assertEquals(int expStart, int expLength, IRegion actual) {
		assertEquals(expStart, actual.getOffset());
		assertEquals(expLength, actual.getLength());
	}
	
	public void testEmptyDocs() throws Exception {
		assertEquals(0,0,check("",0,0,""));
	}
	
	public void testAddToEmptyDoc() throws Exception {
		assertEquals(0,3,check("",0,0,"foo"));
	}
	
	public void testRemoveToEmptyDoc() throws Exception {
		assertEquals(0,0,check("foo",0,3,""));
	}
	
	public void testRemoveFullElement() throws Exception {
		assertEquals(4,0,check("foo bar",4,3,""));
	}
	
	public void testRemovePartlyElement() throws Exception {
		assertEquals(4,1,check("foo bar",5,2,""));
	}
	
	public void testAddElement() throws Exception {
		assertEquals(4,12,check("foo bar",7,0," honolulu"));
	}
	
	public void testChangeInTheMiddleElement() throws Exception {
		assertEquals(4,4,check("foo bar import",6,1,"z"));
	}
	
	public void testComplicatedStuff1() throws Exception {
		assertEquals(0,22,check("test : 'mo*/in' foo;",0,0,"/*"));
	}
	
	public void testBug276628() throws Exception {
		assertEquals(7,10,check("Rule2: 'keyword';",8,9,"keyword';"));
	}
	
	public void testBug279061() throws Exception {
		assertEquals(3,2, check("foo(x", 3, 2, "(x"));
	}
	
	public void testMlEndOfLine() throws Exception {
		String model = "/* foo ";
		String end = "*/";
		
		assertEquals(0,(model+end).length(), check(model+end,0,model.length(),model));
	}
	public void testMlEndOfLine2() throws Exception {
		String model = "foo /* foo ";
		String end = "*/";
		
		assertEquals(0,(model+end).length(), check(model+end,0,model.length(),model));
	}
	
	/**
	 * @author Sven Efftinge - Initial contribution and API
	 * 
	 */
	private final class Listener implements IDocumentListener {
		/**
		 * 
		 */
		private final XtextDamagerRepairer repairer;
		public IRegion lastRegion;

		/**
		 * @param repairer
		 */
		private Listener(XtextDamagerRepairer repairer) {
			this.repairer = repairer;
		}

		public void documentChanged(DocumentEvent event) {
			lastRegion = repairer.getDamageRegion(null, event, false);
		}

		public void documentAboutToBeChanged(DocumentEvent event) {
			// TODO Auto-generated method stub

		}
	}

	private ITokenScanner getTokenScanner() {
		return new ITokenScanner() {

			public void setRange(IDocument document, int offset, int length) {
			}

			public IToken nextToken() {
				return null;
			}

			public int getTokenOffset() {
				return 0;
			}

			public int getTokenLength() {
				return 0;
			}
		};
	}
}
