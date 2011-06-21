/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.richstring;

import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RichStringCompilerTest extends AbstractRichStringEvaluationTest {
	
	@Inject
	private RichStringCompilerTestHelper testHelper;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		AbstractXtend2TestCase.getInjector().injectMembers(this);
		testHelper.setUp();
	}

	@Override
	public void assertOutput(String expectedOutput, String richString) throws Exception {
		testHelper.assertEvaluatesTo(expectedOutput, richString);
	}

	public void testIf_08() throws Exception {
		assertOutput("foobar\n", 
				"'''\n"+
				"  «IF 'a'.charAt(0)!='a'»\n"+
				"	  foobar«ENDIF»\n"+
				"'''");
	}
	
	public void testVariableInString_01() throws Exception {
		assertOutput("1, 2, 3, 4, 5, 6, 7, 8, 9, 10", "'''«var max = 10»«FOR i: 1..max SEPARATOR ', '»«i»«ENDFOR»'''");
	}
	
	public void testForLoop_26() throws Exception {
		assertOutput(
				"foo\n",
				"'''«FOR a: newArrayList(new testdata.OuterClass$InnerClass())»\n" +
				"   foo\n" +
				"«ENDFOR»'''");
	}
	
	public void testBug343148() throws Exception {
		assertOutput(" zonk a\n\n zonk b\n\n zonk c",
				"'''«newArrayList('a','b','c').join('\n\n',[e|''' zonk «e»'''])»'''");
	}
	
	public void testBug349762() throws Exception {
		assertOutput("1,2\n2,4\n",
				"''' \n" + 
				"        «FOR i:1..2»\n" + 
				"            «FOR j:(1..2).map(k | k*i) SEPARATOR ','»«j»«ENDFOR»\n" + 
				"        «ENDFOR»\n" + 
				"'''");
	}
}
