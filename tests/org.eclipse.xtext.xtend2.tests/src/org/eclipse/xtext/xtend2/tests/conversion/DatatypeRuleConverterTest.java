/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.conversion;

import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DatatypeRuleConverterTest extends AbstractXtend2TestCase {

	public void testValidID() {
		doTestConverter("create", "create", "ValidID");
		doTestConverter("doStuff", "doStuff", "ValidID");
		doTestConverter("^super", "super", "ValidID");
		doTestConverter("^class", "class", "ValidID");
		doTestConverter("^import", "import", "ValidID");
	}
	
	public void testIdOrSuper() {
		doTestConverter("create", "create", "IdOrSuper");
		doTestConverter("doStuff", "doStuff", "IdOrSuper");
		doTestConverter("super", "super", "IdOrSuper");
		doTestConverter("^class", "class", "IdOrSuper");
		doTestConverter("^import", "import", "IdOrSuper");
	}

	protected void doTestConverter(String text, String expectation, String ruleName) {
		IValueConverterService converter = get(IValueConverterService.class);
		String actual = (String) converter.toValue(text, ruleName, null);
		assertEquals(expectation, actual);
		String reverse = converter.toString(actual, ruleName);
		assertEquals(text, reverse);
	}
}
