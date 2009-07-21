/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.lexer;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.lexer.backtrackingTestLanguage.Model;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug282355Test extends AbstractXtextTests {
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(BacktrackingLexerTestLanguageStandaloneSetup.class);
	}

	public void testBug282355_01() throws Exception {
		Resource resource = getResourceFromString("Abc Efg Xb");
		assertTrue(resource.getErrors().isEmpty());
		Model model = (Model) resource.getContents().get(0);
		assertEquals(2, model.getEnums().size());
		assertEquals(0, model.getAbs().size());
		assertEquals(1, model.getXbs().size());
	}

	public void testBug282355_02() throws Exception {
		Resource resource = getResourceFromString("Xb");
		assertTrue(resource.getErrors().isEmpty());
		Model model = (Model) resource.getContents().get(0);
		assertEquals(0, model.getEnums().size());
		assertEquals(0, model.getAbs().size());
		assertEquals(1, model.getXbs().size());
	}
	
	public void testBug282355_03() throws Exception {
		Resource resource = getResourceFromString("Ab");
		assertTrue(resource.getErrors().isEmpty());
		Model model = (Model) resource.getContents().get(0);
		assertEquals(0, model.getEnums().size());
		assertEquals(1, model.getAbs().size());
		assertEquals(0, model.getXbs().size());
	}
	
	public void testBug282355_04() throws Exception {
		Resource resource = getResourceFromString("Abc Efg Ab Xb");
		assertTrue(resource.getErrors().isEmpty());
		Model model = (Model) resource.getContents().get(0);
		assertEquals(2, model.getEnums().size());
		assertEquals(1, model.getAbs().size());
		assertEquals(1, model.getXbs().size());
	}
	
	public void testBug282355_05() throws Exception {
		Resource resource = getResourceFromString("AbcEfgAbXb");
		assertTrue(resource.getErrors().isEmpty());
		Model model = (Model) resource.getContents().get(0);
		assertEquals(2, model.getEnums().size());
		assertEquals(1, model.getAbs().size());
		assertEquals(1, model.getXbs().size());
	}
}
