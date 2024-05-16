/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring;

import static com.google.common.collect.Iterables.*;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.refactoring.impl.DefaultDependentElementsCalculator;
import org.eclipse.xtext.ui.tests.refactoring.refactoring.Element;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DependentElementsCalculatorTest extends AbstractXtextTests {

	private XtextResource resource;

	private Element elementA;

	private Element elementB;

	private Element elementC;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(RefactoringTestLanguageStandaloneSetup.class);
		resource = getResourceFromString("A { B { C } } D");
		elementA = (Element) resource.getContents().get(0).eContents().get(0);
		elementB = elementA.getContained().get(0);
		elementC = elementB.getContained().get(0);
	}

	@Test public void testContentDependentElements() throws Exception {
		Iterable<URI> dependentElementURIs = get(DefaultDependentElementsCalculator.class)
				.getDependentElementURIs(elementA, null);
		assertEquals(2, size(dependentElementURIs));
		assertTrue(contains(dependentElementURIs, EcoreUtil.getURI(elementB)));
		assertTrue(contains(dependentElementURIs, EcoreUtil.getURI(elementC)));
	}

}
