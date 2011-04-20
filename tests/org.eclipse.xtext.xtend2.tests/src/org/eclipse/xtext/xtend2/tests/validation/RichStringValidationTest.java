/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.validation;

import org.eclipse.xtext.junit.validation.ValidationTestHelper;
import org.eclipse.xtext.xtend2.tests.richstring.AbstractRichStringTest;
import org.eclipse.xtext.xtend2.validation.IssueCodes;
import org.eclipse.xtext.xtend2.xtend2.RichString;
import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class RichStringValidationTest extends AbstractRichStringTest {

	@Inject
	private ValidationTestHelper validationTestHelper;
	
	public void testRichStringValidation_01() throws Exception {
		RichString richString = richString("'''\n"
				+ "\tindentedLine\n"
				+ "'''");
		validationTestHelper.assertNoIssues(richString);
	}
	
	public void testRichStringValidation_02() throws Exception {
		RichString richString = richString("'''  \n"
				+ "\t\tindentedLine\n"
				+ "\t\tindentedLine\n"
				+ "  '''");
		validationTestHelper.assertNoIssues(richString);
	}
	
	public void testRichStringValidation_03() throws Exception {
		RichString richString = richString("'''  \n"
				+ "  \tindentedLine\n"
				+ "  \tindentedLine\n"
				+ "  '''");
		validationTestHelper.assertNoIssues(richString);
	}
	
	public void testRichStringValidation_04() throws Exception {
		RichString richString = richString("'''  \n"
				+ "\t\tindentedLine\n"
				+ "  \tindentedLine\n"
				+ "  '''");
		validationTestHelper.assertWarning(richString, Xtend2Package.Literals.RICH_STRING_LITERAL, IssueCodes.INCONSISTENT_INDENTATION, "inconsistent", "indentation");
	}
	
	public void testRichStringValidation_05() throws Exception {
		RichString richString = richString("'''    \n"
				+ "\t\tindentedLine\n"
				+ "\t\tindentedLine\n"
				+ "  last line'''");
		validationTestHelper.assertWarning(richString, Xtend2Package.Literals.RICH_STRING_LITERAL, IssueCodes.INCONSISTENT_INDENTATION, "inconsistent", "indentation");
	}
	
	public void testRichStringValidation_06() throws Exception {
		RichString richString = richString("'''        \n"
				+ "  \tindentedLine\n"
				+ "  \tindentedLine\n"
				+ "  last line '''");
		validationTestHelper.assertNoIssues(richString);
	}
	
	public void testRichStringValidation_07() throws Exception {
		RichString richString = richString("'''  content  '''");
		validationTestHelper.assertNoIssues(richString);
	}
	
	public void testRichStringValidation_08() throws Exception {
		RichString richString = richString("'''  \n"
				+ "\t\tindentedLine\n"
				+ "\t\tindentedLine\n"
				+ "'''");
		validationTestHelper.assertNoIssues(richString);
	}
	
	public void testNoException_01() throws Exception {
		RichString richString = richString(
				"'''«'start'»\n" + 
				"		  first line\n'''");
		validationTestHelper.assertNoIssues(richString);
	}
	
	public void testNoException_02() throws Exception {
		RichString richString = richString(
				"'''«'start'»\n" + 
				"		  first line\n" +
				"\n" +
				"'''");
		validationTestHelper.assertNoIssues(richString);
	}
	
	public void testNoException_03() throws Exception {
		RichString richString = richString(
				"'''«'start'»\n" + 
				"		  first line\n" +
				"  \n" +
				"'''");
		validationTestHelper.assertNoIssues(richString);
	}
	
	public void testNoException_04() throws Exception {
		RichString richString = richString(
				"'''«'start'»\n" +
				"  '''");
		validationTestHelper.assertNoIssues(richString);
	}
	
	public void testNoException_05() throws Exception {
		RichString richString = richString(
				"'''«'start'»\n" +
				"'''");
		validationTestHelper.assertNoIssues(richString);
	}
	
	public void testNoException_06() throws Exception {
		RichString richString = richString(
				"'''\n" +
				"'''");
		validationTestHelper.assertNoIssues(richString);
	}
	
	public void testNoException_07() throws Exception {
		RichString richString = richString(
				"''''''");
		validationTestHelper.assertNoIssues(richString);
	}
	
	public void testNoException_08() throws Exception {
		RichString richString = richString(
				"'''«'start'»\n" + 
				"		  first line\n" +
				"«'end'»'''");
		validationTestHelper.assertNoIssues(richString);
	}
	
	public void testNoException_09() throws Exception {
		RichString richString = richString(
		"'''«'start'»'''");
		validationTestHelper.assertNoIssues(richString);
	}
	
	public void testNoException_10() throws Exception {
		RichString richString = richString(
				"'''  «'test'»'''");
		validationTestHelper.assertNoIssues(richString);
	}
	
	public void testBug342438_01() throws Exception {
		RichString richString = richString(
				"'''\n" + 
				"  «FOR c : 'test'.bytes»«'test123'»\n" + 
				"  «ENDFOR»\n" + 
				"  «FOR c : 'test'.bytes»«'test123'»\n" + 
				"  «ENDFOR»\n" + 
				"  «FOR c : 'test'.bytes»«'test123'»\n" + 
				"  «ENDFOR»\n" + 
				"'''");
		validationTestHelper.assertNoIssues(richString);
	}
	
	public void testBug342438_02() throws Exception {
		RichString richString = richString(
				"'''\n" + 
				"  «FOR c : 'test'.bytes»«'test123'»«ENDFOR»\n" + 
				"  «FOR c : 'test'.bytes»«'test123'»«ENDFOR»\n" + 
				"  «FOR c : 'test'.bytes»«'test123'»«ENDFOR»\n" + 
				"'''");
		validationTestHelper.assertNoIssues(richString);
	}
	
	public void testBug342438_03() throws Exception {
		RichString richString = richString(
				"'''\n" + 
				"  «FOR c : 'test'.bytes»\n" +
				"    «'test123'»«ENDFOR»\n" + 
				"  «FOR c : 'test'.bytes»\n" +
				"    «'test123'»«ENDFOR»\n" + 
				"  «FOR c : 'test'.bytes»\n" +
				"    «'test123'»«ENDFOR»\n" + 
				"'''");
		validationTestHelper.assertNoIssues(richString);
	}
	
	public void testBug342438_04() throws Exception {
		RichString richString = richString(
				"'''\n" + 
				"  «FOR c : 'test'.bytes»«FOR c1 : 'test'.bytes»«'test123'»«ENDFOR»\n" + 
				"  «ENDFOR»\n" + 
				"  «FOR c : 'test'.bytes»«FOR c1 : 'test'.bytes»«'test123'»\n" + 
				"  «ENDFOR»«ENDFOR»\n" + 
				"  «FOR c : 'test'.bytes»«FOR c1 : 'test'.bytes»«FOR c2 : 'test'.bytes»«'test123'»«ENDFOR»\n" + 
				"  «ENDFOR»«ENDFOR»\n" + 
				"'''");
		validationTestHelper.assertNoIssues(richString);
	}
	
	public void testBug342438_05() throws Exception {
		RichString richString = richString(
				"'''«FOR a: 'test'.bytes»\n" +
				"   foo\n" +
				"«ENDFOR»'''");
		validationTestHelper.assertNoIssues(richString);
	}
	
	public void testBug342438_06() throws Exception {
		RichString richString = richString(
				"'''«FOR a: ''.bytes»foobar«ENDFOR»'''");
		validationTestHelper.assertNoIssues(richString);
	}
	
	public void testBug342438_07() throws Exception {
		RichString richString = richString(
				"'''«FOR a:'1'.bytes»«FOR a1:''.bytes»foobar«ENDFOR»«ENDFOR»'''");
		validationTestHelper.assertNoIssues(richString);
	}
	
	public void testBug342438_08() throws Exception {
		RichString richString = richString(
				"'''  «FOR a:'1'.bytes»«FOR a1:'1'.toCharArray»foobar«ENDFOR»«ENDFOR»'''");
		validationTestHelper.assertNoIssues(richString);
	}
	
	public void testBug342438_09() throws Exception {
		RichString richString = richString(
				"'''  «FOR a: '123'.toCharArray»\n" +
				"      a,\n" +
				"  «ENDFOR»'''");
		validationTestHelper.assertNoIssues(richString);
	}

	public void testBug342724_01() throws Exception {
		RichString richString = richString(
				"'''\n" + 
				"	«IF true»\n" + 
				"		test\n" + 
				"	«ENDIF»\n" + 
				"	test\n" + 
				"'''");
		validationTestHelper.assertNoIssues(richString);
	}
	
	public void testBug342724_02() throws Exception {
		RichString richString = richString(
				"'''\n" + 
				"	«IF true»\n" + 
				"	test\n" + 
				"	«ELSEIF true»\n" + 
				"	test\n" + 
				"	«ENDIF»\n" + 
				"	test\n" + 
				"'''");
		validationTestHelper.assertNoIssues(richString);
	}
	
	public void testBug342724_03() throws Exception {
		RichString richString = richString(
				"'''\n" + 
				"	«IF true»\n" + 
				"			test\n" + 
				"		«ELSEIF true»\n" + 
				"			test\n" + 
				"	«ENDIF»\n" + 
				"	test\n" + 
				"'''");
		validationTestHelper.assertNoIssues(richString);
	}
}
