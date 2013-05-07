/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor;

import org.eclipse.xtext.junit4.ui.AbstractDamagerRepairerTest;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.parser.antlr.internal.InternalXtextLexer;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class PresentationDamagerTest extends AbstractDamagerRepairerTest {

	@Test public void testEmptyDocs() throws Exception {
		assertEquals(0,0,check("",0,0,""));
	}
	
	@Test public void testAddToEmptyDoc() throws Exception {
		assertEquals(0,3,check("",0,0,"foo"));
	}
	
	@Test public void testRemoveToEmptyDoc() throws Exception {
		assertEquals(0,0,check("foo",0,3,""));
	}
	
	@Test public void testRemovePartlyElement() throws Exception {
		assertEquals(4,1,check("foo bar",5,2,""));
	}
	
	@Test public void testAddElement() throws Exception {
		assertEquals(4,12,check("foo bar",7,0," honolulu"));
	}
	
	@Test public void testRemoveFullElement() throws Exception {
		assertEquals(3,1,check("foo bar",4,3,""));
	}

	@Test public void testAddElement2() throws Exception {
		assertEquals(4,11,check("foo bar",7,0,"honolulu"));
	}
	
	@Test public void testChangeInTheMiddleElement() throws Exception {
		assertEquals(4,3,check("foo bar import",6,1,"z"));
	}
	
	@Test public void testComplicatedStuff1() throws Exception {
		assertEquals(0,22,check("test : 'mo*/in' foo;",0,0,"/*"));
	}
	
	@Test public void testComplicatedStuff2() throws Exception {
		assertEquals(0,8,check("foo bar",0,0,"foo bar "));
	}
	
	@Test public void testBug276628() throws Exception {
		assertEquals(7,10,check("Rule2: 'keyword';",8,9,"keyword';"));
	}	
	
	@Test public void testBug279061() throws Exception {
		assertEquals(0,5, check("foo(x", 3, 2, "(x"));
	}
	
	@Test public void testPartitionsWithoutSpace() throws Exception {
		String text = "Rule2: 'keyword'DoesNotExist'keyword';";
		assertEquals(text.indexOf("Does"), "DoesNotExistx".length(), check(text, text.indexOf('t') + 1, 0, "x"));
	}
	
	@Test public void testMlEndOfLine() throws Exception {
		String model = "/* foo ";
		String end = "*/";
		
		assertEquals(0,(model+end).length(), check(model+end,0,model.length(),model));
	}
	
	@Test public void testMlEndOfLine2() throws Exception {
		String model = "foo /* foo ";
		String end = "*/";
		
		assertEquals(0,(model+end).length(), check(model+end,0,model.length(),model));
	}

	@Override
	protected Lexer createLexer() {
		return new InternalXtextLexer();
	}

}
