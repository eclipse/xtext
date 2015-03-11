/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.conversion;

import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DatatypeRuleConverterTest extends AbstractXtendTestCase {

	@Inject 
	private IValueConverterService converter;
	
	@Test public void testValidID() {
		doTestConverter("doStuff", "doStuff", "ValidID");
		doTestConverter("create", "create", "ValidID");
		doTestConverter("annotation", "annotation", "ValidID");
		
		doTestConverter("^extends", "extends", "ValidID");
		doTestConverter("^import", "import", "ValidID");
		doTestConverter("^extension", "extension", "ValidID");
		doTestConverter("^class", "class", "ValidID");
		doTestConverter("^interface", "interface", "ValidID");
		doTestConverter("^public", "public", "ValidID");
		doTestConverter("^package", "package", "ValidID");
		doTestConverter("^protected", "protected", "ValidID");
		doTestConverter("^private", "private", "ValidID");
		doTestConverter("^abstract", "abstract", "ValidID");
		doTestConverter("^static", "static", "ValidID");
		doTestConverter("^final", "final", "ValidID");
		doTestConverter("^dispatch", "dispatch", "ValidID");
		doTestConverter("^def", "def", "ValidID");
		doTestConverter("^override", "override", "ValidID");
		doTestConverter("^implements", "implements", "ValidID");
		doTestConverter("^throws", "throws", "ValidID");
	}
	
	@Test public void testFeatureCallID() {
		doTestConverter("doStuff", "doStuff", "FeatureCallID");
		doTestConverter("create", "create", "FeatureCallID");
		doTestConverter("annotation", "annotation", "FeatureCallID");
		doTestConverter("extends", "extends", "FeatureCallID");
		doTestConverter("import", "import", "FeatureCallID");
		doTestConverter("extension", "extension", "FeatureCallID");
		doTestConverter("class", "class", "FeatureCallID");
		doTestConverter("interface", "interface", "FeatureCallID");
		doTestConverter("public", "public", "FeatureCallID");
		doTestConverter("package", "package", "FeatureCallID");
		doTestConverter("protected", "protected", "FeatureCallID");
		doTestConverter("private", "private", "FeatureCallID");
		doTestConverter("abstract", "abstract", "FeatureCallID");
		doTestConverter("static", "static", "FeatureCallID");
		doTestConverter("final", "final", "FeatureCallID");
		doTestConverter("dispatch", "dispatch", "FeatureCallID");
		doTestConverter("def", "def", "FeatureCallID");
		doTestConverter("override", "override", "FeatureCallID");
		doTestConverter("implements", "implements", "FeatureCallID");
		doTestConverter("throws", "throws", "FeatureCallID");
		
		doTestConverter("^super", "super", "FeatureCallID");
	}

	@Test public void testIdOrSuper() {
		doTestConverter("doStuff", "doStuff", "IdOrSuper");
		doTestConverter("create", "create", "IdOrSuper");
		doTestConverter("annotation", "annotation", "IdOrSuper");
		doTestConverter("extends", "extends", "IdOrSuper");
		doTestConverter("import", "import", "IdOrSuper");
		doTestConverter("extension", "extension", "IdOrSuper");
		doTestConverter("class", "class", "IdOrSuper");
		doTestConverter("interface", "interface", "IdOrSuper");
		doTestConverter("public", "public", "IdOrSuper");
		doTestConverter("package", "package", "IdOrSuper");
		doTestConverter("protected", "protected", "IdOrSuper");
		doTestConverter("private", "private", "IdOrSuper");
		doTestConverter("abstract", "abstract", "IdOrSuper");
		doTestConverter("static", "static", "IdOrSuper");
		doTestConverter("final", "final", "IdOrSuper");
		doTestConverter("dispatch", "dispatch", "IdOrSuper");
		doTestConverter("def", "def", "IdOrSuper");
		doTestConverter("override", "override", "IdOrSuper");
		doTestConverter("implements", "implements", "IdOrSuper");
		doTestConverter("throws", "throws", "IdOrSuper");		
		doTestConverter("super", "super", "IdOrSuper");
	}

	protected void doTestConverter(String text, String expectation, String ruleName) {
		String actual = (String) converter.toValue(text, ruleName, null);
		assertEquals(expectation, actual);
		String reverse = converter.toString(actual, ruleName);
		assertEquals(text, reverse);
	}
}
