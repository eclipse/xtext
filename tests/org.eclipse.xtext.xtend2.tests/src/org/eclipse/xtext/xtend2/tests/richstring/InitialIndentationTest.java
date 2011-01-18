/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.richstring;

import org.eclipse.xtext.xtend2.richstring.InitialTemplateIndentationComputer;
import org.eclipse.xtext.xtend2.xtend2.RichString;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class InitialIndentationTest extends AbstractRichStringTest {

	public void assertInitialIndentation(String expectedIndentation, String richString) throws Exception {
		RichString parsedString = richString(richString);
		InitialTemplateIndentationComputer computer = new InitialTemplateIndentationComputer();
		String actualIndentation = computer.doSwitch(parsedString);
		assertEquals(richString, expectedIndentation, actualIndentation);
	}
	
	public void testEmptyTemplate_01() throws Exception {
		assertInitialIndentation("", "''''''");
	}
	
	public void testEmptyTemplate_02() throws Exception {
		assertInitialIndentation("", "'''\n'''");
		assertInitialIndentation("", "'''\r\n'''");
	}
	
	public void testSingleLineTemplate() throws Exception {
		assertInitialIndentation("", "'''name'''");
		assertInitialIndentation("", "'''«name»'''");
	}
	
	public void testTextInFirstLine() throws Exception {
		assertInitialIndentation("", "'''  name'''");
		assertInitialIndentation("", "'''  name\n" +
				"  '''");
		assertInitialIndentation("", "'''  name\r\n" +
		"  '''");
	}
	
	public void testExpressionInFirstLine() throws Exception {
		assertInitialIndentation("", "'''  «name»'''");
		assertInitialIndentation("", "'''  «name»\n" +
				"  '''");
		assertInitialIndentation("", "'''  «name»\r\n" +
		"  '''");
	}
	
	public void testTextInLastLine() throws Exception {
		assertInitialIndentation("  ", "'''\n" +
				"  name'''");
		assertInitialIndentation("  ", "'''\r\n" +
				"  name'''");
	}
	
	public void testExpressionInLastLine() throws Exception {
		assertInitialIndentation("  ", "'''\n" +
				"  «name»'''");
		assertInitialIndentation("  ", "'''\r\n" +
				"  «name»'''");
	}
	
	public void testWSInLastLine() throws Exception {
		assertInitialIndentation("  ", "'''\n" +
				"  name\n" +
				" '''");
		assertInitialIndentation("  ", "'''\r\n" +
				"  name\r\n" +
				" '''");
	}
	
	public void testWSInFirstLine() throws Exception {
		assertInitialIndentation(" ", "'''  \n" +
				" name\n" +
				"'''");
		assertInitialIndentation(" ", "'''  \r\n" +
				" name\r\n" +
				"'''");
	}
	
	public void testIndentedTemplate() throws Exception {
		assertInitialIndentation("  ", "'''\n" +
				"  name\n" +
				"'''");
		assertInitialIndentation("  ", "'''\r\n" +
				"  name\r\n" +
				"'''");
	}
	
	public void testEmptyLine() throws Exception {
		assertInitialIndentation("  ", "'''\n" +
				"\n" +
				"  name\n" +
				" \n" +
				"'''");
		assertInitialIndentation("  ", "'''\r\n" +
				"\r\n" +
				"  name\r\n" +
				"\r\n" +
				"'''");
	}
	
	public void testMixedLineBreaks() throws Exception {
		assertInitialIndentation("  ", "'''\n" +
				"  name\r\n" +
				"  name\n" +
				"'''");
	}
	
	public void testContinuouslyIndentedTemplate_01() throws Exception {
		assertInitialIndentation("\t ", "'''\n" +
				"\t name\n" +
				"\t   name\n" +
				"'''");
		assertInitialIndentation("\t ", "'''\r\n" +
				"\t name\r\n" +
				"\t   name\r\n" +
				"'''");
	}
	
	public void testContinuouslyIndentedTemplate_02() throws Exception {
		assertInitialIndentation("\t ", "'''\n" +
				"\t   name\n" +
				"\t name\n" +
				"'''");
		assertInitialIndentation("\t ", "'''\r\n" +
				"\t   name\r\n" +
				"\t name\r\n" +
				"'''");
	}
	
}
