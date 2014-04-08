/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.syntaxcoloring

import com.google.inject.Inject
import org.eclipse.jface.text.TypedRegion
import org.eclipse.xtext.junit4.AbstractXtextTests
import org.eclipse.xtext.testlanguages.noJdt.NoJdtTestLanguageStandaloneSetup
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.junit.Before
import org.junit.Test
import static org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration.*
/**
 * @author Stefan Oehme - Initial contribution and API
 */
class TaskHighlightingTest extends AbstractXtextTests implements IHighlightedPositionAcceptor{

	@Inject
	DefaultSemanticHighlightingCalculator highlighter
	
	val expectedRegions = newHashSet

	@Before
	def void setup() {
		with(NoJdtTestLanguageStandaloneSetup)
		injectMembers(this)
		expectedRegions.clear
	}
	
	@Test
	def void test() {
		val resource = getResourceFromString(
		'''
			//TODO foo
			/*
			 * FIXME bar
			 * Fixme no match
			 * FOO also no match
			 */
			Hello notATODO!
		''')
		expect(2, 4, TASK_ID)
		expect(19, 5, TASK_ID)
		highlighter.provideHighlightingFor(resource, this)
	}
	
	protected def expect(int offset, int length, String type) {
		expectedRegions.add(new TypedRegion(offset, length, type));
	}

	override addPosition(int offset, int length, String... id) {
		assertEquals(1, id.length);
		val region = new TypedRegion(offset, length, id.get(0));
		assertFalse(region.toString(), expectedRegions.isEmpty());
		assertTrue("expected: " + expectedRegions.toString() + " but was: " + region, expectedRegions.remove(region));
	}
	
}