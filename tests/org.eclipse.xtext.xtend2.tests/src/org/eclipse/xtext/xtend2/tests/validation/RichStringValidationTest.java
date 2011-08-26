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
	
	protected void assertValidRichString(String input) throws Exception {
		RichString richString = richString(input);
		validationTestHelper.assertNoIssues(richString);
	}
	
	public void testRichStringValidation_01() throws Exception {
		String input = "'''\n"
				+ "\tindentedLine\n"
				+ "'''";
		assertValidRichString(input);
	}

	public void testRichStringValidation_02() throws Exception {
		String input = "'''  \n"
				+ "\t\tindentedLine\n"
				+ "\t\tindentedLine\n"
				+ "  '''";
		assertValidRichString(input);
	}
	
	public void testRichStringValidation_03() throws Exception {
		String input = "'''  \n"
				+ "  \tindentedLine\n"
				+ "  \tindentedLine\n"
				+ "  '''";
		assertValidRichString(input);
	}
	
	public void testRichStringValidation_04() throws Exception {
		String input = "'''  \n"
				+ "\t\tindentedLine\n"
				+ "  \tindentedLine\n"
				+ "  '''";
		RichString richString = richString(input);
		validationTestHelper.assertWarning(richString, Xtend2Package.Literals.RICH_STRING_LITERAL, IssueCodes.INCONSISTENT_INDENTATION, "inconsistent", "indentation");
	}
	
	public void testRichStringValidation_05() throws Exception {
		String input = "'''    \n"
				+ "\t\tindentedLine\n"
				+ "\t\tindentedLine\n"
				+ "  last line'''";
		RichString richString = richString(input);
		validationTestHelper.assertWarning(richString, Xtend2Package.Literals.RICH_STRING_LITERAL, IssueCodes.INCONSISTENT_INDENTATION, "inconsistent", "indentation");
	}
	
	public void testRichStringValidation_06() throws Exception {
		String input = "'''        \n"
				+ "  \tindentedLine\n"
				+ "  \tindentedLine\n"
				+ "  last line '''";
		assertValidRichString(input);
	}
	
	public void testRichStringValidation_07() throws Exception {
		String input = "'''  content  '''";
		assertValidRichString(input);
	}
	
	public void testRichStringValidation_08() throws Exception {
		String input = "'''  \n"
				+ "\t\tindentedLine\n"
				+ "\t\tindentedLine\n"
				+ "'''";
		assertValidRichString(input);
	}
	
	public void testRichStringValidation_09() throws Exception {
		String input = "'''\n" + 
				"  text\n" + 
				"\n" + 
				"  text\n" + 
				"'''";
		assertValidRichString(input);
	}
	
	public void testNoException_01() throws Exception {
		String input = 
				"'''«'start'»\n" + 
				"		  first line\n'''";
		assertValidRichString(input);
	}
	
	public void testNoException_02() throws Exception {
		String input = 
				"'''«'start'»\n" + 
				"		  first line\n" +
				"\n" +
				"'''";
		assertValidRichString(input);
	}
	
	public void testNoException_03() throws Exception {
		String input = 
				"'''«'start'»\n" + 
				"		  first line\n" +
				"  \n" +
				"'''";
		assertValidRichString(input);
	}
	
	public void testNoException_04() throws Exception {
		String input = 
				"'''«'start'»\n" +
				"  '''";
		assertValidRichString(input);
	}
	
	public void testNoException_05() throws Exception {
		String input = 
				"'''«'start'»\n" +
				"'''";
		assertValidRichString(input);
	}
	
	public void testNoException_06() throws Exception {
		String input = 
				"'''\n" +
				"'''";
		assertValidRichString(input);
	}
	
	public void testNoException_07() throws Exception {
		String input = 
				"''''''";
		assertValidRichString(input);
	}
	
	public void testNoException_08() throws Exception {
		String input = 
				"'''«'start'»\n" + 
				"		  first line\n" +
				"«'end'»'''";
		assertValidRichString(input);
	}
	
	public void testNoException_09() throws Exception {
		String input = 
		"'''«'start'»'''";
		assertValidRichString(input);
	}
	
	public void testNoException_10() throws Exception {
		String input = 
				"'''  «'test'»'''";
		assertValidRichString(input);
	}
	
	public void testBug342438_01() throws Exception {
		String input = 
				"'''\n" + 
				"  «FOR c : 'test'.bytes»«'test123'»\n" + 
				"  «ENDFOR»\n" + 
				"  «FOR c : 'test'.bytes»«'test123'»\n" + 
				"  «ENDFOR»\n" + 
				"  «FOR c : 'test'.bytes»«'test123'»\n" + 
				"  «ENDFOR»\n" + 
				"'''";
		assertValidRichString(input);
	}
	
	public void testBug342438_02() throws Exception {
		String input = 
				"'''\n" + 
				"  «FOR c : 'test'.bytes»«'test123'»«ENDFOR»\n" + 
				"  «FOR c : 'test'.bytes»«'test123'»«ENDFOR»\n" + 
				"  «FOR c : 'test'.bytes»«'test123'»«ENDFOR»\n" + 
				"'''";
		assertValidRichString(input);
	}
	
	public void testBug342438_03() throws Exception {
		String input = 
				"'''\n" + 
				"  «FOR c : 'test'.bytes»\n" +
				"    «'test123'»«ENDFOR»\n" + 
				"  «FOR c : 'test'.bytes»\n" +
				"    «'test123'»«ENDFOR»\n" + 
				"  «FOR c : 'test'.bytes»\n" +
				"    «'test123'»«ENDFOR»\n" + 
				"'''";
		assertValidRichString(input);
	}
	
	public void testBug342438_04() throws Exception {
		String input = 
				"'''\n" + 
				"  «FOR c : 'test'.bytes»«FOR c1 : 'test'.bytes»«'test123'»«ENDFOR»\n" + 
				"  «ENDFOR»\n" + 
				"  «FOR c : 'test'.bytes»«FOR c1 : 'test'.bytes»«'test123'»\n" + 
				"  «ENDFOR»«ENDFOR»\n" + 
				"  «FOR c : 'test'.bytes»«FOR c1 : 'test'.bytes»«FOR c2 : 'test'.bytes»«'test123'»«ENDFOR»\n" + 
				"  «ENDFOR»«ENDFOR»\n" + 
				"'''";
		assertValidRichString(input);
	}
	
	public void testBug342438_05() throws Exception {
		String input = 
				"'''«FOR a: 'test'.bytes»\n" +
				"   foo\n" +
				"«ENDFOR»'''";
		assertValidRichString(input);
	}
	
	public void testBug342438_06() throws Exception {
		String input = 
				"'''«FOR a: ''.bytes»foobar«ENDFOR»'''";
		assertValidRichString(input);
	}
	
	public void testBug342438_07() throws Exception {
		String input = 
				"'''«FOR a:'1'.bytes»«FOR a1:''.bytes»foobar«ENDFOR»«ENDFOR»'''";
		assertValidRichString(input);
	}
	
	public void testBug342438_08() throws Exception {
		String input = 
				"'''  «FOR a:'1'.bytes»«FOR a1:'1'.toCharArray»foobar«ENDFOR»«ENDFOR»'''";
		assertValidRichString(input);
	}
	
	public void testBug342438_09() throws Exception {
		String input = 
				"'''  «FOR a: '123'.toCharArray»\n" +
				"      a,\n" +
				"  «ENDFOR»'''";
		assertValidRichString(input);
	}

	public void testBug342724_01() throws Exception {
		String input = 
				"'''\n" + 
				"	«IF true»\n" + 
				"		test\n" + 
				"	«ENDIF»\n" + 
				"	test\n" + 
				"'''";
		assertValidRichString(input);
	}
	
	public void testBug342724_02() throws Exception {
		String input = 
				"'''\n" + 
				"	«IF true»\n" + 
				"	test\n" + 
				"	«ELSEIF true»\n" + 
				"	test\n" + 
				"	«ENDIF»\n" + 
				"	test\n" + 
				"'''";
		assertValidRichString(input);
	}
	
	public void testBug342724_03() throws Exception {
		String input = 
				"'''\n" + 
				"	«IF true»\n" + 
				"			test\n" + 
				"		«ELSEIF true»\n" + 
				"			test\n" + 
				"	«ENDIF»\n" + 
				"	test\n" + 
				"'''";
		assertValidRichString(input);
	}
}
