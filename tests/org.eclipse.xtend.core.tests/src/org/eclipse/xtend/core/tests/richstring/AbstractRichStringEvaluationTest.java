/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.richstring;

import org.eclipse.xtend.core.tests.RuntimeInjectorProvider;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(RuntimeInjectorProvider.class)
public abstract class AbstractRichStringEvaluationTest extends Assert {

	public abstract void assertOutput(String expectedOutput, String richString) throws Exception;
	
	@Test public void testSimpleTemplate() throws Exception {
		assertOutput("foobar", "'''foobar'''");
	}
	
	@Test public void testSimpleTemplateWithLeadingSpace() throws Exception {
		assertOutput("  foobar", "'''  foobar'''");
	}
	
	@Test public void testSimpleTemplateWithTrailingSpace() throws Exception {
		assertOutput("foobar   ", "'''foobar   '''");
	}
	
	@Test public void testExpressionTemplate() throws Exception {
		assertOutput("foobar", "'''«'foobar'»'''");
	}
	
	@Test public void testExpressionTemplateWithLeadingSpace() throws Exception {
		assertOutput("  foobar", "'''  «'foobar'»'''");
	}
	
	@Test public void testExpressionTemplateWithTrailingSpace() throws Exception {
		assertOutput("foobar   ", "'''«'foobar'»   '''");
	}
	
	@Test public void testExpressionTemplateWithTrailingLiteral() throws Exception {
		assertOutput(
			"start\n"+
			"  first line\n" +
			"  second line\n",
			"'''«'start'»\n" +
			"  first line\n" +
			"  second line\n" +
			"		'''");
	}
	
	@Test public void testMLExpressionTemplate() throws Exception {
		assertOutput("foo\nbar", "'''«'foo\nbar'»'''");
	}
	
	@Test public void testMLExpressionTemplateWithLeadingSpace() throws Exception {
		assertOutput("  foo\n  bar", "'''  «'foo\nbar'»'''");
	}
	
	@Test public void testMLExpressionTemplateWithTrailingSpace() throws Exception {
		assertOutput("foo\nbar   ", "'''«'foo\nbar'»   '''");
	}
	
	@Test public void testMultiLineTemplate() throws Exception {
		assertOutput(
				"foobar\n", 
				"'''\n" +
				"  foobar\n" +
				"'''");
	}
	
	@Test public void testMultiLineTemplate_01() throws Exception {
		assertOutput(
				" foobar\n" +
				"   foobar\n" +
				"foobar\n",
				"'''\n" +
				"  foobar\n" +
				"    foobar\n" +
				" foobar\n" +
				"'''");
	}
	
	@Test public void testMultiLineTemplate_02() throws Exception {
		assertOutput(
				"  foobar\n" +
				"    foobar\n" +
				" foobar\n",
				"'''  foobar\n" +
				"    foobar\n" +
				" foobar\n" +
				"'''");
	}
	
	@Test public void testMultiLineTemplate_03() throws Exception {
		assertOutput(
				"  foobar\n" +
				"    foobar\n" +
				" foobar  ",
				"'''  foobar\n" +
				"    foobar\n" +
				" foobar  '''");
	}
	
	@Test public void testIf_01() throws Exception {
		assertOutput("foobar", "'''«IF true»foobar«ENDIF»'''");
	}
	
	@Test public void testIf_02() throws Exception {
		assertOutput("", "'''«IF false»foobar«ENDIF»'''");
	}
	
	@Test public void testIf_03() throws Exception {
		assertOutput("zonk", "'''«IF false»foobar«ELSE»zonk«ENDIF»'''");
	}
	
	@Test public void testIf_04() throws Exception {
		assertOutput("zonk", "'''«IF false»foobar«ELSEIF true»zonk«ENDIF»'''");
	}
	
	@Test public void testIf_05() throws Exception {
		assertOutput("zonk", "'''«IF false»foobar«ELSEIF false»foobar«ELSE»zonk«ENDIF»'''");
	}
	
	@Test public void testIf_06() throws Exception {
		assertOutput("foobar\n", 
				"'''\n"+
				"«IF true»\n"+
				"	foobar«ENDIF»\n"+
				"'''");
	}
	
	@Test public void testIf_07() throws Exception {
		assertOutput("foobar\n", 
				"'''\n"+
				"  «IF true»\n"+
				"	  foobar«ENDIF»\n"+
				"'''");
	}
	
	@Test public void testIf_08() throws Exception {
		assertOutput("foobar\n", 
				"'''\n"+
				"  «var Object x = '_foobar'»" +
				"  «IF x instanceof String»\n"+
				"	  «x.substring(1)»\n" +
				"  «ENDIF»\n"+
				"'''");
	}
	
	@Test public void testMultilineIf_01() throws Exception {
		assertOutput(
				"foobar\n", 
				"'''\n" +
				"  «IF true»\n" +
				"    foobar\n" +
				"  «ENDIF»\n" +
				"'''");
	}
	
	@Test public void testMultilineIf_02() throws Exception {
		assertOutput(
				"", 
				"'''\n" +
				"	«IF false»\n" +
				"		foobar\n" +
				"	«ENDIF»\n" +
				"'''");
	}
	
	@Test public void testMultilineIf_03() throws Exception {
		assertOutput(
				"zonk\n", 
				"'''\n" +
				"«IF false»\n" +
				"  foobar\n" +
				"«ELSE»\n" +
				"  zonk\n" +
				"«ENDIF»\n" +
				"'''");
	}
	
	@Test public void testMultilineIf_04() throws Exception {
		assertOutput(
				"zonk\n", 
				"'''\n" +
				"«IF false»\n" +
				"	foobar\n" +
				"«ELSEIF true»\n" +
				"	zonk\n" +
				"«ENDIF»\n" +
				"'''");
	}
	
	@Test public void testMultilineIf_05() throws Exception {
		assertOutput(
				"zonk\n", 
				"'''\n" +
				"		«IF false»\n" +
				"				foobar\n" +
				"		«ELSEIF false»\n" +
				"				foobar\n" +
				"		«ELSE»\n" +
				"				zonk\n" +
				"		«ENDIF»\n" +
				"'''");
	}
	
	@Test public void testNestedIf_01() throws Exception {
		assertOutput(
				"foobar\n", 
				"'''\n" +
				"	«IF true»\n" +
				"		«IF true»\n" +
				"				foobar\n" +
				"		«ENDIF»\n" +
				"	«ENDIF»\n" +
				"'''");
	}
	
	@Test public void testNestedIf_02() throws Exception {
		assertOutput(
				"foobar\n", 
				"'''\n" +
				"	«IF true»\n" +
				"		«IF true»foobar«ENDIF»\n" +
				"	«ENDIF»\n" +
				"'''");
	}
	
	@Test public void testNestedIf_03() throws Exception {
		assertOutput(
				"", 
				"'''\n" +
				"	«IF true»\n" +
				"		«IF false»foobar«ENDIF»\n" +
				"	«ENDIF»\n" +
				"'''");
	}
	
	@Test public void testNestedIf_04() throws Exception {
		assertOutput(
				"", 
				"'''\n" +
				"	«IF true»\n" +
				"		«IF false»\n" +
				"				foobar\n" +
				"		«ENDIF»\n" +
				"	«ENDIF»\n" +
				"'''");
	}
	
	@Test public void testNestedIf_05() throws Exception {
		assertOutput(
				"", 
				"'''\n" +
				"	«IF false»\n" +
				"		«IF true»foobar«ENDIF»\n" +
				"	«ENDIF»\n" +
				"'''");
	}
	
	@Test public void testNestedIf_06() throws Exception {
		assertOutput(
				"", 
				"'''\n" +
				"	«IF false»\n" +
				"		«IF true»\n" +
				"				foobar\n" +
				"		«ENDIF»\n" +
				"	«ENDIF»\n" +
				"'''");
	}
	
	@Test public void testInconsistentWhitespace_01() throws Exception {
		assertOutput(
				"foobar\n", 
				"'''\n" +
				"  «IF true»\n" +
				"		«IF true»\n" +
				"				foobar\n" +
				"		«ENDIF»\n" +
				"  «ENDIF»\n" +
				"'''");
	}
	
	@Test public void testTrailingEmptyLine_01() throws Exception {
		assertOutput(
				"\n", 
				"'''\n" +
				"		«IF false»\n" +
				"				foobar\n" +
				"		«ENDIF»\n" +
				"\n" +
				"'''");
	}
	
	@Test public void testTrailingEmptyLine_02() throws Exception {
		assertOutput(
				"foobar\n"+
				"\n", 
				"'''\n" +
				"		«IF true»\n" +
				"				foobar\n" +
				"		«ENDIF»\n" +
				"\n" +
				"'''");
	}
	
	@Test public void testTrailingEmptyLine_03() throws Exception {
		assertOutput(
				"foobar\n"+
				"\n", 
				"'''\n" +
				"		«IF true»\n" +
				"				foobar\n" +
				"		«ENDIF»\n" +
				"		\n" +
				"'''");
	}
	
	@Test public void testTrailingEmptyLine_04() throws Exception {
		assertOutput(
				"foobar\n"+
				"\n", 
				"'''\n" +
				"		«IF true»\n" +
				"				foobar\n" +
				"		«ENDIF»\n" +
				"		\n" +
				"'''");
	}
	
	@Test public void testTrailingEmptyLine_05() throws Exception {
		assertOutput(
				"foobar\n"+
				"  \n", 
				"'''    \n" +
				"		«IF true»\n" +
				"				foobar\n" +
				"		«ENDIF»\n" +
				"		  \n" +
				"'''");
	}
	
	@Test public void testTrailingEmptyLine_06() throws Exception {
		assertOutput(
				"foobar\n"+
				"  \n", 
				"'''\n" +
				"		foobar\n" +
				"		  \n" +
				"'''");
	}
	
	@Test public void testTrailingEmptyLine_07() throws Exception {
		assertOutput(
				"foobar\n"+
				"  \n", 
				"'''\n" +
				"		«IF true»foobar«ENDIF»\n" +
				"		  \n" +
				"'''");
	}
	
	@Test public void testTrailingEmptyLine_08() throws Exception {
		assertOutput(
				"\n", 
				"'''\n" +
				"\n" +
				"'''");
	}
	
	@Test public void testEmptyLineInBetween_01() throws Exception {
		assertOutput(
				"test\n" +
				"\n" +
				"test\n", 
				"'''\n" +
				"  test\n" +
				"\n" +
				"  test\n" +
				"'''");
	}
	
	@Test public void testEmptyLineInBetween_02() throws Exception {
		assertOutput(
				"  test\n" +
				"\n" +
				"test\n", 
				"'''\n" +
				"    test\n" +
				"\n" +
				"  test\n" +
				"'''");
	}
	
	@Test public void testEmptyLineInBetween_03() throws Exception {
		assertOutput(
				"test\n" +
				"\n" +
				"  test\n", 
				"'''\n" +
				"    test\n" +
				"\n" +
				"      test\n" +
				"'''");
	}
	
	@Test public void testTrailingWhitespace_01() throws Exception {
		assertOutput(
				"foobar \n", 
				"'''\n" +
				"\t\t«'foobar'» \n" +
				"'''");
	}

	@Test public void testForLoop_01() throws Exception {
		assertOutput(
				"",
				"'''«FOR a: ''.toCharArray»foobar«ENDFOR»'''");
	}
	
	@Test public void testForLoop_02() throws Exception {
		assertOutput(
				"",
				"'''\n" +
				"  «FOR a:''.toCharArray»\n" +
				"    foobar\n" +
				"  «ENDFOR»\n" +
				"'''");
	}
	
	@Test public void testForLoop_03() throws Exception {
		assertOutput(
				"",
				"'''«FOR a:'1'.toCharArray»«FOR a1:''.toCharArray»foobar«ENDFOR»«ENDFOR»'''");
	}
	
	@Test public void testForLoop_04() throws Exception {
		assertOutput(
				"",
				"'''\n" +
				"  «FOR a:'1'.toCharArray»\n" +
				"    «FOR a1:''.toCharArray»\n" +
				"      foobar\n" +
				"    «ENDFOR»\n" +
				"  «ENDFOR»\n" +
				"'''");
	}
	
	@Test public void testForLoop_05() throws Exception {
		assertOutput(
				"foobar",
				"'''«FOR a:'1'.toCharArray»foobar«ENDFOR»'''");
	}
	
	@Test public void testForLoop_06() throws Exception {
		assertOutput(
				"foobar\n",
				"'''\n" +
				"  «FOR a:'1'.toCharArray»\n" +
				"    foobar\n" +
				"  «ENDFOR»\n" +
				"'''");
	}
	
	@Test public void testForLoop_07() throws Exception {
		assertOutput(
				"  foobar",
				"'''  «FOR a:'1'.toCharArray»«FOR a1:'1'.toCharArray»foobar«ENDFOR»«ENDFOR»'''");
	}
	
	@Test public void testForLoop_08() throws Exception {
		assertOutput(
				"foobar\n",
				"'''\n" +
				"  «FOR a:'1'.toCharArray»\n" +
				"    «FOR a1:'1'.toCharArray»\n" +
				"      foobar\n" +
				"    «ENDFOR»\n" +
				"  «ENDFOR»\n" +
				"'''");
	}
	
	@Test public void testForLoop_10() throws Exception {
		assertOutput(
				"foobar\n",
				"'''\n" +
				"  «FOR a:'1'.toCharArray»\n" +
				"    «FOR a1:'1'.toCharArray»foobar«ENDFOR»\n" +
				"  «ENDFOR»\n" +
				"'''");
	}
	
	@Test public void testForLoop_11() throws Exception {
		assertOutput(
				"foobarfoobar\n",
				"'''\n" +
				"  «FOR a:'1'.toCharArray»\n" +
				"    «FOR a1:'12'.toCharArray»foobar«ENDFOR»\n" +
				"  «ENDFOR»\n" +
				"'''");
	}
	
	@Test public void testForLoop_12() throws Exception {
		assertOutput(
				"foobar\n" +
				"foobar\n",
				"'''\n" +
				"  «FOR a:'12'.toCharArray»\n" +
				"    «FOR a1:'1'.toCharArray»foobar«ENDFOR»\n" +
				"  «ENDFOR»\n" +
				"'''");
	}
	
	@Test public void testForLoop_13() throws Exception {
		assertOutput(
				"foobar\n" +
				"foobar\n" +
				"foobar\n" +
				"foobar\n",
				"'''\n" +
				"  «FOR a:'12'.toCharArray»\n" +
				"    «FOR a1:'12'.toCharArray»\n" +
				"      foobar\n" +
				"    «ENDFOR»\n" +
				"  «ENDFOR»\n" +
				"'''");
	}
	
	@Test public void testForLoop_14() throws Exception {
		assertOutput(
				"foobar\n" +
				"foobar\n" +
				"foobar\n" +
				"foobar\n",
				"'''\n" +
				"  «FOR a:'1'.toCharArray»\n" +
				"    «FOR a1:'12'.toCharArray»\n" +
				"      «'foobar\nfoobar'»\n" +
				"    «ENDFOR»\n" +
				"  «ENDFOR»\n" +
				"'''");
	}
	
	@Test public void testForLoop_15() throws Exception {
		assertOutput(
				"  foobar\n" +
				"foobar\n" +
				"  foobar\n" +
				"foobar\n",
				"'''\n" +
				"  «FOR a:'12'.toCharArray»\n" +
				"    «FOR a1:'1'.toCharArray»\n" +
				"      «'  foobar\nfoobar'»\n" +
				"    «ENDFOR»\n" +
				"  «ENDFOR»\n" +
				"'''");
	}
	
	@Test public void testForLoop_16() throws Exception {
		assertOutput(
				"foobar\n" +
				"  foobar\n" +
				"foobar\n" +
				"  foobar\n" +
				"foobar\n" +
				"  foobar\n" +
				"foobar\n" +
				"  foobar\n",
				"'''\n" +
				"  «FOR a:'12'.toCharArray»\n" +
				"    «FOR a1:'12'.toCharArray»\n" +
				"      «'foobar\n  foobar'»\n" +
				"    «ENDFOR»\n" +
				"  «ENDFOR»\n" +
				"'''");
	}
	
	@Test public void testForLoop_17() throws Exception {
		assertOutput(
				"",
				"'''«FOR a: ''.toCharArray BEFORE '<-' SEPARATOR '-' AFTER '->'»foobar«ENDFOR»'''");
	}
	
	@Test public void testForLoop_18() throws Exception {
		assertOutput(
				"<-foobar->",
				"'''«FOR a: '1'.toCharArray BEFORE '<-' SEPARATOR '-' AFTER '->'»foobar«ENDFOR»'''");
	}
	
	@Test public void testForLoop_19() throws Exception {
		assertOutput(
				"<-foobar-foobar->",
				"'''«FOR a: '12'.toCharArray BEFORE '<-' SEPARATOR '-' AFTER '->'»foobar«ENDFOR»'''");
	}
	
	@Test public void testForLoop_20() throws Exception {
		assertOutput(
				"foobar-foobar->",
				"'''«FOR a: '12'.toCharArray SEPARATOR '-' AFTER '->'»foobar«ENDFOR»'''");
	}
	
	@Test public void testForLoop_21() throws Exception {
		assertOutput(
				"<-foobar-foobar",
				"'''«FOR a: '12'.toCharArray BEFORE '<-' SEPARATOR '-' »foobar«ENDFOR»'''");
	}
	
	@Test public void testForLoop_22() throws Exception {
		assertOutput(
				"<-foobarfoobar->",
				"'''«FOR a: '12'.toCharArray BEFORE '<-' AFTER '->' »foobar«ENDFOR»'''");
	}
	
	@Test public void testForLoop_23() throws Exception {
		assertOutput(
				"  a,\n  a,\n  a,\n",
				"'''  «FOR a: '123'.toCharArray»\n" +
				"      a,\n" +
				"  «ENDFOR»'''");
	}
	
	@Test public void testForLoop_24() throws Exception {
		assertOutput(
				"  a,\n  a,\n  a\n",
				"'''  «FOR a: '123'.toCharArray SEPARATOR ','»\n" +
				"      a\n" +
				"  «ENDFOR»'''");
	}
	
	@Test public void testForLoop_25() throws Exception {
		assertOutput(
				"  begin [\n  a,\n  a,\n  a\n  ]",
				"'''  «FOR a: '123'.toCharArray BEFORE 'begin [' SEPARATOR ',' AFTER ']' »\n" +
				"      a\n" +
				"  «ENDFOR»'''");
	}
	
	@Test 
	public void testForLoop_26() throws Exception {
		assertOutput(
				" a,\n" +
				"   \t\n" +
				" a,\n" +
				"   \t\n" +
				" a\n", 
				"''' «FOR a: '123'.toCharArray SEPARATOR ',\n  \t'»\n" +
				"      a\n" +
				" «ENDFOR»'''");
	}
	
	@Test public void testBug_365632() throws Exception {
		assertOutput("before\n", 
				"'''\n"+
				"  «FOR s : '1'.toCharArray BEFORE 'before'»\n" + 
				"  «ENDFOR»\n" + 
				"\n'''");
	}
	
	@Test public void testBug_365632_02() throws Exception {
		assertOutput("after\n", 
				"'''\n"+
						"  «FOR s : '1'.toCharArray AFTER 'after'»\n" + 
						"  «ENDFOR»\n" + 
				"\n'''");
	}
	
	@Test public void testBug342724_01() throws Exception {
		assertOutput("test1\ntest3\n",
				"'''\n" + 
				"	«IF true»\n" + 
				"			test1\n" + 
				"		«ELSEIF true»\n" + 
				"			test2\n" + 
				"	«ENDIF»\n" + 
				"	test3\n" + 
				"'''");
	}
	
	@Test public void testEmptyExpressions_01() throws Exception {
		assertOutput("",
				"'''«»'''");
	}
	
	@Test public void testEmptyExpressions_02() throws Exception {
		assertOutput("  ",
				"'''  '''");
		assertOutput("  ",
				"'''  «\n  »'''");
	}
	
	@Test public void testEmptyExpressions_03() throws Exception {
		assertOutput("    ",
				"'''  «\n  »  '''");
	}
	
	@Test public void testEmptyExpressions_04() throws Exception {
		assertOutput("TestTest",
				"'''Test«/* zonk */»Test'''");
	}
	
	@Test public void testEmptyExpressions_05() throws Exception {
		assertOutput("  \n",
				"'''\n" +
				"  \n" +
				"'''");
		assertOutput("  \n",
				"'''\n" +
				"  «»\n" +
				"'''");
	}

	@Test public void testTemplateWithComments_01() throws Exception {
		assertOutput(
				" foobar\n" +
				"   foobar\n" +
				"foobar\n",
				"'''\n" +
				"  foobar\n" +
				"«««    comment\n" +
				"    foobar\n" +
				"«««    comment\n" +
				" foobar\n" +
				"'''");
	}
	
	@Test public void testTemplateWithComments_02() throws Exception {
		assertOutput(
				"  foobar\n" +
				"    foobar\n" +
				" foobar\n",
				"'''  foobar\n" +
				"«««    comment\n" +
				"    foobar\n" +
				"«««    another comment\n" +
				" foobar\n" +
				"'''");
	}
	
	@Test public void testTemplateWithComments_03() throws Exception {
		assertOutput(
				"  foobar\n" +
				"    foobar\n" +
				" foobar  ",
				"'''  foobar\n" +
				"«««    comment\n" +
				"    foobar\n" +
				"«««    comment\n" +
				" foobar  '''");
	}
}
