/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.richstring;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RichStringCompilerTest extends AbstractRichStringEvaluationTest {
	
	@Inject
	private RichStringCompilerTestHelper testHelper;
	
	@Before
	public void setUp() throws Exception {
		testHelper.setUp();
	}

	@Override
	public void assertOutput(String expectedOutput, String richString) throws Exception {
		String platformExpectedOutput = expectedOutput.replace("\n", nl());
		testHelper.assertEvaluatesTo(platformExpectedOutput, richString);
	}

	@Test public void testIf_09() throws Exception {
		assertOutput("foobar\n", 
				"'''\n"+
				"  «IF 'a'.charAt(0)!='a'»\n"+
				"	  foobar«ENDIF»\n"+
				"'''");
	}
	
	@Test public void testVariableInString_01() throws Exception {
		assertOutput("1, 2, 3, 4, 5, 6, 7, 8, 9, 10", "'''«var max = 10»«FOR i: 1..max SEPARATOR ', '»«i»«ENDFOR»'''");
	}
	
	@Test public void testForLoop_27() throws Exception {
		assertOutput(
				"foo\n",
				"'''«FOR a: newArrayList(new testdata.OuterClass$InnerClass())»\n" +
				"   foo\n" +
				"«ENDFOR»'''");
	}
	
	@Test public void testBug343148() throws Exception {
		assertOutput(" zonk a\n\n zonk b\n\n zonk c",
				"'''«newArrayList('a','b','c').join('\n\n',[e|''' zonk «e»'''])»'''");
	}
	
	@Test public void testBug349762() throws Exception {
		assertOutput("1,2\n2,4\n",
				"''' \n" + 
				"        «FOR i:1..2»\n" + 
				"            «FOR j:(1..2).map(k | k*i) SEPARATOR ','»«j»«ENDFOR»\n" + 
				"        «ENDFOR»\n" + 
				"'''");
	}
}
