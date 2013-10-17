/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.bug419429;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.AbstractPartialParserTest;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.antlr.IReferableElementsUnloader;
import org.eclipse.xtext.parser.impl.PartialParsingPointers;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.Wrapper;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug419429Test extends AbstractPartialParserTest {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(Bug419429StandaloneSetup.class);
	}
	
	@Test public void test_01() throws Exception {
		String model = "SomeID";
		replaceAndReparse(model, 4, 0, "Unused", "SomeUnusedID");
	}
	
	@Test public void test_02() throws Exception {
		String model = "";
		replaceAndReparse(model, 0, 0, "SomeID", "SomeID");
	}
	
	@Test public void test_03() throws Exception {
		String model = "SomeID";
		replaceAndReparse(model, 0, 6, "", "");
	}
	
	protected void replaceAndReparse(String model, int offset, int length, String change, String expectedReparseRegion)
			throws Exception {
		IParseResult parseResult = getParseResultAndExpect(model, UNKNOWN_EXPECTATION);
		PartialParsingPointers parsingPointers = getPartialParser().calculatePartialParsingPointers(parseResult, offset,
				length);
		String reparseRegion = getPartialParser().insertChangeIntoReplaceRegion(parsingPointers
				.getDefaultReplaceRootNode(), new ReplaceRegion(offset, length, change));
		assertEquals(expectedReparseRegion, reparseRegion);
		final Wrapper<Boolean> unloaded = Wrapper.wrap(Boolean.FALSE);
		getPartialParser().setUnloader(new IReferableElementsUnloader() {
			public void unloadRoot(EObject root) {
				unloaded.set(Boolean.TRUE);
			}
		});
		IParseResult partiallyReparse = reparse(parseResult, offset, length, change);
		assertTrue("unloaded", unloaded.get());
		String expectedReparseModel = model.substring(0, offset) + change + model.substring(offset + length);
		assertEquals(expectedReparseModel, partiallyReparse.getRootNode().getText());
	}
	
}
