/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.richstring;

import org.eclipse.xtend.core.tests.util.TemporaryFolder;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(NoImplicitImportsRuntimeInjectorProvider.class)
public class RichStringCompilerTest extends AbstractRichStringEvaluationTest {
	
	@Inject
	private RichStringCompilerTestHelper testHelper;
	
	@Rule
	@Inject public TemporaryFolder tempFolder;
	
	@Before
	public void setUp() throws Exception {
		testHelper.setUp();
	}

	@Override
	public void assertOutput(String expectedOutput, String richString) throws Exception {
		String platformExpectedOutput = expectedOutput.replace("\n", nl());
		testHelper.assertEvaluatesTo(platformExpectedOutput, richString);
	}

	public void assertOutput(String expectedOutput, String imports, String richString) throws Exception {
		String platformExpectedOutput = expectedOutput.replace("\n", nl());
		testHelper.assertEvaluatesTo(imports, (Object) platformExpectedOutput, richString);
	}

	@Test public void testIf_09() throws Exception {
		assertOutput("foobar\n",
				"import static extension org.eclipse.xtext.xbase.lib.ObjectExtensions.*",
				"'''\n"+
				"  «IF 'a'.charAt(0)!='a'»\n"+
				"	  foobar«ENDIF»\n"+
				"'''");
	}
	
	@Test public void testVariableInString_01() throws Exception {
		assertOutput("1, 2, 3, 4, 5, 6, 7, 8, 9, 10",
				"import static extension org.eclipse.xtext.xbase.lib.IntegerExtensions.*", 
				"'''«var max = 10»«FOR i: 1..max SEPARATOR ', '»«i»«ENDFOR»'''");
	}
	
	@Test public void testForLoop_27() throws Exception {
		assertOutput(
				"foo\n",
				"'''«FOR a: com.google.common.collect.Lists.newArrayList(new testdata.OuterClass$InnerClass())»\n" +
				"   foo\n" +
				"«ENDFOR»'''");
	}
	
	@Test public void testBug343148() throws Exception {
		assertOutput(" zonk a\n\n zonk b\n\n zonk c",
				"import static extension org.eclipse.xtext.xbase.lib.IterableExtensions.*",
				"'''«com.google.common.collect.Lists.newArrayList('a','b','c').join('\n\n',[e|''' zonk «e»'''])»'''");
	}
	
	@Test public void testBug349762() throws Exception {
		assertOutput("1,2\n2,4\n",
				"import static extension org.eclipse.xtext.xbase.lib.IterableExtensions.* " +
				"import static extension org.eclipse.xtext.xbase.lib.IntegerExtensions.* ",
				"''' \n" + 
				"  «FOR i:1..2»\n" + 
				"    «FOR j:(1..2).map(k | k*i) SEPARATOR ','»«j»«ENDFOR»\n" + 
				"  «ENDFOR»\n" + 
				"'''");
	}
	
	@Test public void testBug440006() throws Exception {
		assertOutput("1,2\n",
				"import static extension org.eclipse.xtext.xbase.lib.IterableExtensions.* " +
				"import static extension org.eclipse.xtext.xbase.lib.IntegerExtensions.* ",
				"''' \n" + 
						"  «FOR i:#[1..2]»\n" + 
						"    «FOR j:i SEPARATOR ','»«j»«ENDFOR»\n" + 
						"  «ENDFOR»\n" + 
				"'''");
	}
	
	@Test public void testBug440006b() throws Exception {
		assertOutput("1,2\n",
				"import static extension org.eclipse.xtext.xbase.lib.IntegerExtensions.*",
				"''' \n" + 
						"  «FOR i:#{1..2}»\n" + 
						"    «FOR j:i SEPARATOR ','»«j»«ENDFOR»\n" + 
						"  «ENDFOR»\n" + 
				"'''");
	}
}
