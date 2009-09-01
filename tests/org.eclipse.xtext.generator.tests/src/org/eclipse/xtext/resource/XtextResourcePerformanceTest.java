/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageStandaloneSetup;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextResourcePerformanceTest extends AbstractGeneratorTest {

	private static final int NUM_ELEMENTS = 190;
	private String model;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(ReferenceGrammarTestLanguageStandaloneSetup.class);
		StringBuilder modelBuilder = new StringBuilder(NUM_ELEMENTS * 64);
		modelBuilder.append("spielplatz " + NUM_ELEMENTS + " {\n");
		for (int i = 1; i <= NUM_ELEMENTS; i++) {
			modelBuilder.append("  kind (Bob" + i + " " + i + ")\n");
			modelBuilder.append("  kind (Joe" + i + " " + i + ")\n");
			modelBuilder.append("  erwachsener (Mutter" + i + " " + i + ")\n");
			modelBuilder.append("  erwachsener (Vater" + i + " " + i + ")\n");
			modelBuilder.append("  familie(Familie" + i + " Vater" + i + " Mutter" + i + " Bob" + i + ", Joe" + i
					+ ")\n");
		}
		modelBuilder.append('}');
		model = modelBuilder.toString();
	}

	public void testLoad() throws Exception {
		XtextResource resource = getResourceFromString(model);
		assertNotNull(resource);
		assertTrue(resource.getParseResult().getParseErrors().isEmpty());
		assertTrue(resource.getErrors().isEmpty());
	}

	public void testLoadModelWithLinkingErrors() throws Exception {
		StringBuilder modelBuilder = new StringBuilder(NUM_ELEMENTS * 64);
		modelBuilder.append("spielplatz " + NUM_ELEMENTS + " {\n");
		for (int i = 1; i <= NUM_ELEMENTS; i++) {
			modelBuilder.append("  kind (Bob " + i + ")\n");
			modelBuilder.append("  kind (Joe " + i + ")\n");
			modelBuilder.append("  erwachsener (Mutter " + i + ")\n");
			modelBuilder.append("  erwachsener (Vater " + i + ")\n");
			modelBuilder.append("  familie(Familie" + i + " Vater Mutter Bob, Joe)\n");
		}
		modelBuilder.append('}');
		model = modelBuilder.toString();
		XtextResource resource = getResourceFromStringAndExpect(model, 4 * NUM_ELEMENTS);
		assertNotNull(resource);
		assertTrue(resource.getParseResult().getParseErrors().isEmpty());
		assertEquals(4 * NUM_ELEMENTS, resource.getErrors().size());
	}

}
