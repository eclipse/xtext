/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.DefaultReferenceDescription;
import org.eclipse.xtext.ui.refactoring.ElementRenameInfo;
import org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator;
import org.eclipse.xtext.ui.refactoring.impl.OffsetCorrector;
import org.eclipse.xtext.ui.refactoring.impl.RenamedElementResolver;
import org.eclipse.xtext.ui.tests.refactoring.refactoring.Element;
import org.eclipse.xtext.ui.tests.refactoring.refactoring.RefactoringPackage;
import org.eclipse.xtext.util.ReplaceRegion;

/**
 * @author koehnlein - Initial contribution and API
 */
public class RenamedElementResolverTest extends AbstractXtextTests {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(RefactoringTestLanguageStandaloneSetup.class);
	}
	
	public void testResolveElements() throws Exception {
		URI resourceURI = URI.createFileURI("testresource.refactoringtestlanguage");
		String textualModel = "A { B { C { ref A.B } } ref B }";
		XtextResource resource = getResource(textualModel, resourceURI.toString());
		Element elementA = (Element) resource.getContents().get(0).eContents().get(0);
		Element elementB = elementA.getContained().get(0);
		Element elementC = elementB.getContained().get(0);

		int offsetB = textualModel.indexOf("B");
		URI uriA = EcoreUtil.getURI(elementA);
		URI uriB = EcoreUtil.getURI(elementB);
		URI uriC = EcoreUtil.getURI(elementC);
		
		IReferenceDescription refA2B = new DefaultReferenceDescription(elementA, elementB, RefactoringPackage.Literals.ELEMENT__REFERENCED, 0, uriA);
		IReferenceDescription refC2B = new DefaultReferenceDescription(elementC, elementB, RefactoringPackage.Literals.ELEMENT__REFERENCED, 0, uriC);
		String newName = "newB";
		
		RenamedElementResolver renamedElementResolver = get(RenamedElementResolver.class);
		MockRefactoringDocument document = new MockRefactoringDocument(resourceURI, textualModel);
		ElementRenameInfo baseRenameInfo = new ElementRenameInfo(document, uriB, offsetB);
		IDependentElementsCalculator dependentElementsCalculator = get(IDependentElementsCalculator.class);
		Iterable<ElementRenameInfo> dependentElementRenameInfos = dependentElementsCalculator.getDependentElementRenameInfos(elementB, baseRenameInfo, null);
		assertEquals(1, size(dependentElementRenameInfos));
		List<ElementRenameInfo> elementRenameInfos = newArrayList(baseRenameInfo, dependentElementRenameInfos.iterator().next());
		resource.update(offsetB, 1, newName);
		OffsetCorrector offsetCorrector = new OffsetCorrector(document, new ReplaceRegion(offsetB, 1, newName));
		
		Map<URI, EObject> renamedElements = renamedElementResolver.resolveRenamedElements(elementRenameInfos, resource.getResourceSet(), offsetCorrector);
		assertEquals(2, renamedElements.size());
		assertTrue(renamedElements.get(uriB) instanceof Element);
		assertEquals(newName, ((Element) renamedElements.get(uriB)).getName());
		assertTrue(renamedElements.get(uriC) instanceof Element);
		assertEquals("C", ((Element) renamedElements.get(uriC)).getName());
		
		EObject referringElement = renamedElementResolver.resolveReferringElement(resource, refA2B, renamedElements);
		assertTrue(referringElement instanceof Element);
		assertEquals("A", ((Element) referringElement).getName());

		EObject referringElement1 = renamedElementResolver.resolveReferringElement(resource, refC2B, renamedElements);
		assertTrue(referringElement1 instanceof Element);
		assertEquals("C", ((Element) referringElement1).getName());
	}
}
