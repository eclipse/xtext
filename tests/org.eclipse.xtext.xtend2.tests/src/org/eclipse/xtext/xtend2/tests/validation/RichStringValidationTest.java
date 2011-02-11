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
}
