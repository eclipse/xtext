/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.sdomain.idea.tests.parsing;

import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainFileType;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;

public class SDomainParsingTest extends AbstractLanguageParsingTestCase {
	
	public SDomainParsingTest() {
		super(SDomainFileType.INSTANCE);
	}
	
	@Override
	protected String getTestDataPath() {
		return "./testData/parsing";
	}
	
	public void testEmpty() {
		doTest(true);
	}
	
	public void testNamespaces() {
		doTest(true);
	}
	
	public void testEntities() {
		doTest(true);
	}
	
	public void testDatatypes() {
		doTest(true);
	}
	
	public void testQualifiedNamespace() {
		doTest(true);
	}
	
	public void testQualifiedNamespace2() {
		doTest(true);
	}
	
	public void testCrossReferences() {
		doTest(true);
	}
	
	public void testSyntaxErrors() {
		doTest(true);
	}
	
	public void testSyntaxErrors2() {
		doTest(true);
	}
	
	public void testMissingTokenErrorRecovery() {
		doTest(true);
	}
	
	public void testUnwantedTokenErrorRecovery() {
		doTest(true);
	}
	
	public void testUnwantedTokenErrorRecovery2() {
		doTest(true);
	}
	
}
