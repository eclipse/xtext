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
import org.eclipse.xtext.xtend2.xtend2.RichString;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class RichStringValidationTest extends AbstractRichStringTest {

	@Inject
	private ValidationTestHelper validationTestHelper;
	
	public void testRichStringValidation() throws Exception {
		RichString richString = richString("'''\n"
				+ "\tindentedLine\n"
				+ "'''");
		validationTestHelper.assertNoIssues(richString);
	}
}
