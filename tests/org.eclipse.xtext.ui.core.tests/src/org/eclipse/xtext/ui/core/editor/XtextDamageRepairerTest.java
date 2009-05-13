/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import junit.framework.TestCase;

import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.parser.antlr.internal.InternalXtextLexer;
import org.eclipse.xtext.ui.core.editor.XtextDamagerRepairer.TokenIterator;

import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class XtextDamageRepairerTest extends TestCase {

	private Document doc;
	private XtextDamagerRepairer repairer;
	private Listener listener;

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		doc = new Document("");
		repairer = new XtextDamagerRepairer(getTokenScanner(), new Provider<Lexer>() {

			public Lexer get() {
				return new org.eclipse.xtext.parser.antlr.internal.InternalXtextLexer();
			}
		});
		repairer.setDocument(doc);
		listener = new Listener(repairer);
		doc.addDocumentListener(listener);
	}

	public void test1() throws Exception {

		doc.set("foo \n import");

		doc.replace(0, 0, "//");

		System.out.println(doc.get(listener.lastRegion.getOffset(), listener.lastRegion.getLength()));

		assertEquals(0, listener.lastRegion.getOffset());
		assertEquals(doc.get().indexOf('\n') + 2, listener.lastRegion.getLength());

	}

	public void test2() throws Exception {

		doc.set("/* foo */ grammar bar /*\n*/");

		doc.replace(7, 2, "");
		assertEquals(0, listener.lastRegion.getOffset());

		assertEquals(0, listener.lastRegion.getOffset());
		assertEquals(doc.get().indexOf('\n') + 3, listener.lastRegion.getLength());

	}

	public void test3() throws Exception {

		doc.set("/* foo  grammar bar /*\n*/");

		doc.replace(7, 0, "*/");
		assertEquals(0, listener.lastRegion.getOffset());
		assertEquals(doc.get().indexOf('\n') + 3, listener.lastRegion.getLength());

	}

	public void test4() throws Exception {

		doc.set("/* foo  grammar bar /*\n*/");

		doc.replace(0, 2, "");
		assertEquals(0, listener.lastRegion.getOffset());
		assertEquals(doc.get().indexOf('\n') + 3, listener.lastRegion.getLength());

	}

	public void test5() throws Exception {
		String text = "/* foo */";
		doc.set(text);

		doc.replace(3, 3, "foo");
		assertEquals(0, listener.lastRegion.getOffset());
		assertEquals(text.length(), listener.lastRegion.getLength());

		doc.replace(3, 3, "foo");
		assertEquals(0, listener.lastRegion.getOffset());
		assertEquals(text.length(), listener.lastRegion.getLength());

		doc.replace(3, 3, "bar");
		assertEquals(0, listener.lastRegion.getOffset());
		assertEquals(text.length(), listener.lastRegion.getLength());

		doc.set("Honolulu");
		doc.set(text);
		assertEquals(0, listener.lastRegion.getOffset());
		assertEquals(text.length(), listener.lastRegion.getLength());
	}

	public void test6() throws Exception {

		doc.set("/* foo  grammar bar /*\n*/");

		doc.replace(2, 0, "\n");
		doc.replace(2, 0, "\n");
		doc.replace(2, 0, "\n");
		assertEquals(0, listener.lastRegion.getOffset());
		assertEquals(doc.getLength(), listener.lastRegion.getLength());

	}

	public void testAppend() throws Exception {
		doc.set("");
		doc.replace(0, 0, "foo");
		assertEquals(0, listener.lastRegion.getOffset());
		assertEquals(3, listener.lastRegion.getLength());

		doc.replace(3, 0, " foo");
		assertEquals(0, listener.lastRegion.getOffset());
		assertEquals(7, listener.lastRegion.getLength());
		
		doc.replace(7, 0, " foo");
		assertEquals(4, listener.lastRegion.getOffset());
		assertEquals(7, listener.lastRegion.getLength());
	}

	public void testLongText() throws Exception {
		StringBuffer buff = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			buff.append("fool ");
		}
		doc.set(buff.toString());

		doc.replace(50, 0, "do");
		assertEquals(49, listener.lastRegion.getOffset());
		assertEquals(3, listener.lastRegion.getLength());
	}

	public void testTokenIteratorGoTo() throws Exception {
		String text = "foo bar 'stuff' // foo \n/* moma*/";
		TokenIterator iterator = TokenIterator.create(new InternalXtextLexer(), text);
		iterator.goTo(10);
		assertEquals(8, iterator.getOffset());
		iterator.goTo(3);
		assertEquals(3, iterator.getOffset());

		iterator.goTo(2);
		assertEquals(0, iterator.getOffset());

		iterator.goTo(24);
		assertEquals(24, iterator.getOffset());

		iterator.goTo(23);
		assertEquals(16, iterator.getOffset());

	}

	public void testTokenIterator() throws Exception {
		TokenIterator iterator = TokenIterator.create(new InternalXtextLexer(), "foo bar 'stuff' // foo \n/* moma*/");

		assertEquals(0, iterator.getOffset());
		assertEquals(0, iterator.getIndex());
		assertEquals(3, iterator.getLength());

		iterator.next();

		assertEquals(3, iterator.getOffset());
		assertEquals(1, iterator.getIndex());
		assertEquals(1, iterator.getLength());

		iterator.next();

		assertEquals(4, iterator.getOffset());
		assertEquals(2, iterator.getIndex());
		assertEquals(3, iterator.getLength());

		iterator.next();

		assertEquals(7, iterator.getOffset());
		assertEquals(3, iterator.getIndex());
		assertEquals(1, iterator.getLength());

		iterator.next();

		assertEquals(8, iterator.getOffset());
		assertEquals(4, iterator.getIndex());
		assertEquals(7, iterator.getLength());
	}

	public void testEmptyTokenIterator() throws Exception {
		TokenIterator iterator = TokenIterator.create(new InternalXtextLexer(), "");

		assertFalse(iterator.hasNext());
		try {
			iterator.next();
			fail();
		} catch (IllegalStateException e) {
			// expected
		}

		assertEquals(-1, iterator.getIndex());
		assertEquals(0, iterator.getLength());
		assertEquals(0, iterator.getOffset());
	}
	
	public void testNextAndBackWard() throws Exception {
		TokenIterator iterator = TokenIterator.create(new InternalXtextLexer(), "foo /* bar\n*/ grammar 'wurst'");
		iterator.next();
		iterator.backward();
		iterator.next();
		iterator.backward();
		iterator.next();
		assertEquals(3,iterator.getOffset());
		assertEquals(1,iterator.getLength());
		iterator.next();
		assertEquals(4,iterator.getOffset());
		assertEquals(9,iterator.getLength());
		iterator.next();
		iterator.next();
		iterator.next();
		iterator.next();
		assertEquals(22,iterator.getOffset());
		assertEquals(7,iterator.getLength());
		iterator.goTo(0);
		assertEquals(0,iterator.getOffset());
		assertEquals(3,iterator.getLength());
		iterator.goTo(29);
		assertEquals(22,iterator.getOffset());
		assertEquals(7,iterator.getLength());
	}
	
	public void testTokenIteratorCreate1() throws Exception {
		TokenIterator i1 = TokenIterator.create(new InternalXtextLexer(), "foo foo");
		i1.next();
		i1.next();
		TokenIterator i2 = TokenIterator.create(new InternalXtextLexer(), "foo foobar", i1);
		assertEquals(4, i2.getOffset());
		assertEquals(6, i2.getLength());
		i2.backward();
		assertEquals(3, i2.getOffset());
		assertEquals(1, i2.getLength());
		i2.backward();
		assertEquals(0, i2.getOffset());
		assertEquals(3, i2.getLength());
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
