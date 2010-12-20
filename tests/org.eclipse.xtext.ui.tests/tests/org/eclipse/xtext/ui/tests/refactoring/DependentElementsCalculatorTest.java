/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring;

import static com.google.common.collect.Iterables.*;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.refactoring.ElementRenameInfo;
import org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator;
import org.eclipse.xtext.ui.refactoring.IRefactoringDocument;
import org.eclipse.xtext.ui.refactoring.impl.DefaultDependentElementsCalculator;
import org.eclipse.xtext.ui.tests.refactoring.refactoring.Element;

import com.google.common.base.Predicate;

/**
 * @author koehnlein - Initial contribution and API
 */
public class DependentElementsCalculatorTest extends AbstractXtextTests {

	private ElementRenameInfo baseRenameInfo;

	private XtextResource resource;

	private IRefactoringDocument mockDocument;

	private EObject baseElement;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(RefactoringTestLanguageStandaloneSetup.class);
		resource = getResourceFromString("A { B { C } } D");
		baseElement = resource.getContents().get(0).eContents().get(0);
		URI baseElementURI = EcoreUtil.getURI(baseElement);
		assertNotNull(baseElement);
		assertTrue(baseElement instanceof Element);
		assertEquals("A", ((Element) baseElement).getName());
		mockDocument = new MockRefactoringDocument(resource.getURI(), null);
		baseRenameInfo = new ElementRenameInfo(mockDocument, baseElementURI, -1);
	}

	public void testContentDependentElements() throws Exception {
		Iterable<ElementRenameInfo> dependentElementRenameInfos = get(DefaultDependentElementsCalculator.class)
				.getDependentElementRenameInfos(baseElement, baseRenameInfo);
		assertEquals(2, size(dependentElementRenameInfos));
		assertContainsElement(dependentElementRenameInfos, "B");
		assertContainsElement(dependentElementRenameInfos, "C");
	}

	public void testNullDependentElements() throws Exception {
		Iterable<ElementRenameInfo> dependentElementRenameInfos = get(IDependentElementsCalculator.Null.class)
				.getDependentElementRenameInfos(baseElement, baseRenameInfo);
		assertTrue(isEmpty(dependentElementRenameInfos));
	}

	protected void assertContainsElement(Iterable<ElementRenameInfo> dependentElementRenameInfos,
			final String elementName) {
		assertTrue(any(dependentElementRenameInfos, new Predicate<ElementRenameInfo>() {
			public boolean apply(ElementRenameInfo info) {
				EObject dependentElement = resource.getEObject(info.getElementURI().fragment());
				return dependentElement instanceof Element
						&& ((Element) dependentElement).getName().equals(elementName)
						&& info.getOffset() == NodeModelUtils.getNode(dependentElement).getOffset()
						&& info.getDocument() == mockDocument;
			}
		}));
	}

}
