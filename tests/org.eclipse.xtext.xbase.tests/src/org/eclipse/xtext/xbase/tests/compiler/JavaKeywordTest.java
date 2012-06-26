/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.compiler;

import org.eclipse.xtext.xbase.compiler.JavaKeywords;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JavaKeywordTest extends AbstractXbaseTestCase {

	@Inject 
	private JavaKeywords javaKeywords;
	
	@Test public void testAssert() {
		assertTrue(javaKeywords.isJavaKeyword("assert"));
	}

	@Test public void testNull() {
		assertTrue(javaKeywords.isJavaKeyword("null"));
	}
	
	@Test public void testTrue() {
		assertTrue(javaKeywords.isJavaKeyword("true"));
	}

	@Test public void testFalse() {
		assertTrue(javaKeywords.isJavaKeyword("false"));
	}

}
