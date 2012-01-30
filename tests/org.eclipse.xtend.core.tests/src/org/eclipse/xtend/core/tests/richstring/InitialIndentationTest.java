/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.richstring;

import org.eclipse.xtend.core.richstring.InitialTemplateIndentationComputer;
import org.eclipse.xtend.core.xtend.RichString;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class InitialIndentationTest extends AbstractRichStringTest {

	public void assertInitialIndentation(String expectedIndentation, String richString) throws Exception {
		assertInitialIndentation(expectedIndentation, richString, "");
	}
	
	public void assertInitialIndentation(String expectedIndentation, String richString, String initial) throws Exception {
		RichString parsedString = richString(richString);
		InitialTemplateIndentationComputer computer = new InitialTemplateIndentationComputer(initial);
		String actualIndentation = computer.doSwitch(parsedString);
		assertEquals(richString, expectedIndentation, actualIndentation);
	}
	
	@Test public void testEmptyTemplate_01() throws Exception {
		assertInitialIndentation("", "''''''");
		assertInitialIndentation("foobar", "''''''", "foobar");
	}
	
	@Test public void testEmptyTemplate_02() throws Exception {
		assertInitialIndentation("", "'''\n'''");
		assertInitialIndentation("", "'''\r\n'''");
	}
	
	@Test public void testEmptyLastLine_01() throws Exception {
		assertInitialIndentation("		", 
				"'''\n" +
				"		foobar\n" +
				"\n" +
				"'''");
	}
	
	@Test public void testSingleLineTemplate() throws Exception {
		assertInitialIndentation("", "'''name'''");
		assertInitialIndentation("", "'''«null»'''");
	}
	
	@Test public void testTextInFirstLine_01() throws Exception {
		assertInitialIndentation("", "'''  name'''");
		assertInitialIndentation("", "'''  name\n" +
				"  '''");
		assertInitialIndentation("", "'''  name\r\n" +
		"  '''");
	}
	
	@Test public void testTextInFirstLine_02() throws Exception {
		assertInitialIndentation("initial", "'''  name'''", "initial");
		assertInitialIndentation("initial", "'''  name\n" +
				"  '''", "initial");
		assertInitialIndentation("initial", "'''  name\r\n" +
		"  '''", "initial");
	}
	
	@Test public void testExpressionInFirstLine() throws Exception {
		assertInitialIndentation("", "'''  «null»'''");
		assertInitialIndentation("", "'''  «null»\n" +
				"  '''");
		assertInitialIndentation("", "'''  «null»\r\n" +
		"  '''");
	}
	
	@Test public void testTextInLastLine_01() throws Exception {
		assertInitialIndentation("  ", "'''\n" +
				"  name'''");
		assertInitialIndentation("  ", "'''\r\n" +
				"  name'''");
	}
	
	@Test public void testTextInLastLine_02() throws Exception {
		assertInitialIndentation("  ", "'''\n" +
				"  name'''", "initial");
		assertInitialIndentation("  ", "'''\r\n" +
				"  name'''", "initial");
	}
	
	@Test public void testExpressionInLastLine() throws Exception {
		assertInitialIndentation("  ", "'''\n" +
				"  «null»'''");
		assertInitialIndentation("  ", "'''\r\n" +
				"  «null»'''");
	}
	
	@Test public void testWSInLastLine() throws Exception {
		assertInitialIndentation("  ", "'''\n" +
				"  name\n" +
				" '''");
		assertInitialIndentation("  ", "'''\r\n" +
				"  name\r\n" +
				" '''");
	}
	
	@Test public void testWSInFirstLine() throws Exception {
		assertInitialIndentation(" ", "'''  \n" +
				" name\n" +
				"'''");
		assertInitialIndentation(" ", "'''  \r\n" +
				" name\r\n" +
				"'''");
	}
	
	@Test public void testIndentedTemplate() throws Exception {
		assertInitialIndentation("  ", "'''\n" +
				"  name\n" +
				"'''");
		assertInitialIndentation("  ", "'''\r\n" +
				"  name\r\n" +
				"'''");
	}
	
	@Test public void testEmptyLine_01() throws Exception {
		assertInitialIndentation("  ", "'''\n" +
				"\n" +
				"  name\n" +
				" \n" +
				"'''");
		assertInitialIndentation("  ", "'''\r\n" +
				"\r\n" +
				"  name\r\n" +
				" \r\n" +
				"'''");
	}
	
	@Test public void testEmptyLine_02() throws Exception {
		assertInitialIndentation("   ", "'''\n" +
				" \n" +
				"   name\n" +
				"  \n" +
				"'''");
		assertInitialIndentation("   ", "'''\r\n" +
				" \r\n" +
				"   name\r\n" +
				"  \r\n" +
				"'''");
	}
	
	@Test public void testEmptyLine_03() throws Exception {
		assertInitialIndentation("   ", "'''\n" +
				"  \n" +
				"   name\n" +
				" \n" +
				"'''");
		assertInitialIndentation("   ", "'''\r\n" +
				"  \r\n" +
				"   name\r\n" +
				" \r\n" +
				"'''");
	}
	
	@Test public void testMixedLineBreaks() throws Exception {
		assertInitialIndentation("  ", "'''\n" +
				"  name\r\n" +
				"  name\n" +
				"'''");
	}
	
	@Test public void testContinuouslyIndentedTemplate_01() throws Exception {
		assertInitialIndentation("\t ", "'''\n" +
				"\t name\n" +
				"\t   name\n" +
				"'''");
		assertInitialIndentation("\t ", "'''\r\n" +
				"\t name\r\n" +
				"\t   name\r\n" +
				"'''");
	}
	
	@Test public void testContinuouslyIndentedTemplate_02() throws Exception {
		assertInitialIndentation("\t ", "'''\n" +
				"\t   name\n" +
				"\t name\n" +
				"'''");
		assertInitialIndentation("\t ", "'''\r\n" +
				"\t   name\r\n" +
				"\t name\r\n" +
				"'''");
	}
	
	@Test public void testForLoopAndEmptyLine_01() throws Exception {
		assertInitialIndentation("\t\t", 
			"'''\n" + 
			"\n" + 
			"\t\t\t«FOR s: Collections::<String>emptyList»«ENDFOR»\n" + 
			"\t\t}\n" + 
			"'''");
	}
	
	@Test public void testEmptyInput_01() throws Exception {
		assertInitialIndentation("",
				"'''\n" +
				"  \n" +
				"'''");
	}
	
	@Test public void testEmptyInput_02() throws Exception {
		assertInitialIndentation("",
				"'''\n" +
				"  «»\n" +
				"'''");
	}
	
}
