/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.FooBar;
import org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.Model;

/**
 * @author koehnlein - Initial contribution and API
 */
public class EObjectAtOffsetTest extends AbstractXtextTests {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(EObjectAtOffsetTestLanguageStandaloneSetup.class);
	}

	public void testElements() throws Exception {
		String modelAsString = "foo foo0 bar bar0 foo0 bar bar1 foo0";
		XtextResource resource = getResourceFromString(modelAsString);
		Model model = (Model) resource.getContents().get(0);
		checkContainedElementAt(resource, modelAsString, "foo foo0", model.getFoos().get(0));
		checkContainedElementAt(resource, modelAsString, "bar bar0", model.getBars().get(0));
		checkContainedElementAt(resource, modelAsString, "bar bar1", model.getBars().get(1));
	}

	public void testCrossRefs() throws Exception {
		String modelAsString = "bar bar0 foo0 bar bar1 foo1,foo2 foo foo0 foo foo1 foo foo2";
		XtextResource resource = getResourceFromString(modelAsString);
		Model model = (Model) resource.getContents().get(0);
		checkCrossReferencedElementAt(resource, modelAsString, "foo0", model.getFoos().get(0));
		checkCrossReferencedElementAt(resource, modelAsString, "foo1", model.getFoos().get(1));
		checkCrossReferencedElementAt(resource, modelAsString, "foo2", model.getFoos().get(2));
	}

	public void testAction() throws Exception {
		String modelAsString = "bar bar0 foo0 foobar foo1 foo foo0 foo foo1";
		XtextResource resource = getResourceFromString(modelAsString);
		Model model = (Model) resource.getContents().get(0);
		checkContainedElementAt(resource, modelAsString, "foobar", model.getBars().get(0));
		checkCrossReferencedElementAt(resource, modelAsString, "foo0", model.getFoos().get(0));
		checkCrossReferencedElementAt(resource, modelAsString, "foo1", model.getFoos().get(1));
		checkContainedElementAt(resource, modelAsString, "bar bar0", ((FooBar) model.getBars().get(0)).getBar());
	}

	private void checkContainedElementAt(XtextResource resource, String model, String substring, EObject expectedElement) {
		int index = model.indexOf(substring);
		for (int i = index; i < index + substring.length(); ++i) {
			EObject foundElement = EObjectAtOffsetHelper.resolveContainedElementAt(resource, i);
			assertEquals(expectedElement, foundElement);
			foundElement = EObjectAtOffsetHelper.resolveElementAt(resource, i);
			assertEquals(expectedElement, foundElement);
			foundElement = EObjectAtOffsetHelper.resolveCrossReferencedElementAt(resource, i);
			assertNotSame(expectedElement, foundElement);
		}
	}

	private void checkCrossReferencedElementAt(XtextResource resource, String model, String substring,
			EObject expectedElement) {
		int index = model.indexOf(substring);
		for (int i = index; i < index + substring.length(); ++i) {
			EObject foundElement = EObjectAtOffsetHelper.resolveCrossReferencedElementAt(resource, i);
			assertEquals(expectedElement, foundElement);
			foundElement = EObjectAtOffsetHelper.resolveElementAt(resource, i);
			assertEquals(expectedElement, foundElement);
			foundElement = EObjectAtOffsetHelper.resolveContainedElementAt(resource, i);
			assertNotSame(expectedElement, foundElement);
		}
	}
}
