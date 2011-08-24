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
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.Foo;
import org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.FooBar;
import org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.Model;
import org.eclipse.xtext.util.TextRegion;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class EObjectAtOffsetTest extends AbstractXtextTests {

	private EObjectAtOffsetHelper eObjectAtOffsetHelper;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(EObjectAtOffsetTestLanguageStandaloneSetup.class);
		eObjectAtOffsetHelper = new EObjectAtOffsetHelper();
	}

	public void testBug349626() throws Exception {
		String modelAsString = "foo foo0";
		XtextResource resource = getResourceFromString(modelAsString);
		assertNull(eObjectAtOffsetHelper.resolveCrossReferencedElementAt(resource, modelAsString.length()));
	}

	public void testElements() throws Exception {
		String modelAsString = "foo foo0 bar bar0 foo0 bar bar1 foo0";
		XtextResource resource = getResourceFromString(modelAsString);
		Model model = (Model) resource.getContents().get(0);
		checkContainedElementAt(resource, modelAsString, "foo foo0 ", model.getFoos().get(0));
		checkContainedElementAt(resource, modelAsString, "bar bar0 ", model.getBars().get(0));
		checkContainedElementAt(resource, modelAsString, "bar bar1 ", model.getBars().get(1));
	}

	public void testCrossRefs_01() throws Exception {
		String modelAsString = "bar bar0 foo0 bar bar1 foo1,foo2 foo foo0 foo foo1 foo foo2";
		XtextResource resource = getResourceFromString(modelAsString);
		Model model = (Model) resource.getContents().get(0);
		checkCrossReferencedElementAt(resource, modelAsString, "foo0 ", model.getFoos().get(0));
		checkCrossReferencedElementAt(resource, modelAsString, "foo1", model.getFoos().get(1));
		checkCrossReferencedElementAt(resource, modelAsString, "foo2 ", model.getFoos().get(2));
	}
	
	public void testCrossRefs_02() throws Exception {
		String modelAsString = "zonk bar bar0 foo0 bar bar1 foo1,foo2 foo foo0 foo foo1 foo foo2";
		XtextResource resource = getResourceFromString(modelAsString);
		Model model = (Model) resource.getContents().get(0);
		checkCrossReferencedElementAt(resource, modelAsString, "foo0 ", model.getFoos().get(0));
		checkCrossReferencedElementAt(resource, modelAsString, "foo1", model.getFoos().get(1));
		checkCrossReferencedElementAt(resource, modelAsString, "foo2 ", model.getFoos().get(2));
	}
	
	public void testCrossRefsAfterUnassignedRuleCall_01() throws Exception {
		String modelAsString = "bar bar0 foo0 foo1 foo foo0 foo foo1";
		XtextResource resource = getResourceFromString(modelAsString);
		Model model = (Model) resource.getContents().get(0);
		checkCrossReferencedElementAt(resource, modelAsString, "foo0", model.getFoos().get(0));
		checkCrossReferencedElementAt(resource, modelAsString, "foo1", model.getFoos().get(1));
	}
	
	public void testCrossRefsAfterUnassignedRuleCall_02() throws Exception {
		String modelAsString = "zonk 1 bar bar0 foo0 foo1 foo foo0 foo foo1";
		XtextResource resource = getResourceFromString(modelAsString);
		Model model = (Model) resource.getContents().get(0);
		checkCrossReferencedElementAt(resource, modelAsString, "foo0", model.getFoos().get(0));
		checkCrossReferencedElementAt(resource, modelAsString, "foo1", model.getFoos().get(1));
	}
	
	public void testCrossRefsAfterAction_01() throws Exception {
		String modelAsString = "bar bar0 foo0 foobar foo1 foo2 foo foo0 foo foo1 foo foo2";
		XtextResource resource = getResourceFromString(modelAsString);
		Model model = (Model) resource.getContents().get(0);
		checkCrossReferencedElementAt(resource, modelAsString, "foo0", model.getFoos().get(0));
		checkCrossReferencedElementAt(resource, modelAsString, "foo1", model.getFoos().get(1));
		checkCrossReferencedElementAt(resource, modelAsString, "foo2", model.getFoos().get(2));
	}
	
	public void testCrossRefsAfterAction_02() throws Exception {
		String modelAsString = "zonk 1 bar bar0 foo0 foobar foo1 foo2 foo foo0 foo foo1 foo foo2";
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
		checkContainedElementAt(resource, modelAsString, "foobar ", model.getBars().get(0));
		checkCrossReferencedElementAt(resource, modelAsString, "foo0 ", model.getFoos().get(0));
		checkCrossReferencedElementAt(resource, modelAsString, "foo1 ", model.getFoos().get(1));
		checkContainedElementAt(resource, modelAsString, "bar bar0 ", ((FooBar) model.getBars().get(0)).getBar());
	}
	
	public void testAction_02() throws Exception {
		String modelAsString = "zonk 1 bar bar0 foo0 foobar foo1 foo foo0 foo foo1";
		XtextResource resource = getResourceFromString(modelAsString);
		Model model = (Model) resource.getContents().get(0);
		checkContainedElementAt(resource, modelAsString, "foobar ", model.getBars().get(0));
		checkCrossReferencedElementAt(resource, modelAsString, "foo0 ", model.getFoos().get(0));
		checkCrossReferencedElementAt(resource, modelAsString, "foo1 ", model.getFoos().get(1));
		checkContainedElementAt(resource, modelAsString, "bar bar0 ", ((FooBar) model.getBars().get(0)).getBar());
	}
	
	public void testFindCrossReferencedElementAt() throws Exception {
		String firstPart = "foo Foo1 foo Foo2 zonk bar Bar1 Foo1";
		String modelAsString = firstPart+",Foo2";
		XtextResource resource = getResourceFromString(modelAsString);
		Foo foo2 = (Foo) eObjectAtOffsetHelper.resolveCrossReferencedElementAt(resource, firstPart.length()+1);
		assertEquals("Foo2", foo2.getName());
		Foo foo1 = (Foo) eObjectAtOffsetHelper.resolveCrossReferencedElementAt(resource, firstPart.length());
		assertEquals("Foo1", foo1.getName());
	}
	
	public void testFindCrossReferencedElementAt_1() throws Exception {
		String firstPart = "foo Foo1=X.Y foo Foo2=X.Y zonk bar Bar1 Foo1=X.Y";
		String modelAsString = firstPart+",Foo2=X.Y";
		XtextResource resource = getResourceFromString(modelAsString);
		Foo foo2 = (Foo) eObjectAtOffsetHelper.resolveCrossReferencedElementAt(resource, firstPart.length()+1);
		assertEquals("Foo2=X.Y", foo2.getName());
		Foo foo1 = (Foo) eObjectAtOffsetHelper.resolveCrossReferencedElementAt(resource, firstPart.length());
		assertEquals("Foo1=X.Y", foo1.getName());
	}
	
	public void testGetCrossReferenceNode() throws Exception {
		String firstPart = "foo Foo1=X.Y foo Foo2=X.Y zonk bar Bar1 Foo1=X.Y";
		String modelAsString = firstPart+",Foo2=X.Y";
		XtextResource resource = getResourceFromString(modelAsString);
		
		INode node = eObjectAtOffsetHelper.getCrossReferenceNode(resource, new TextRegion(firstPart.length(), 0));
		assertEquals(firstPart.length()-8, node.getOffset());
		assertEquals(8, node.getLength());
		
		assertNull(eObjectAtOffsetHelper.getCrossReferenceNode(resource, new TextRegion(firstPart.length(), 1)));
		
		node = eObjectAtOffsetHelper.getCrossReferenceNode(resource, new TextRegion(firstPart.length()+1, 0));
		assertEquals(firstPart.length()+1, node.getOffset());
		assertEquals(8, node.getLength());
		
		node = eObjectAtOffsetHelper.getCrossReferenceNode(resource, new TextRegion(firstPart.length()+1, 5));
		assertEquals(firstPart.length()+1, node.getOffset());
		assertEquals(8, node.getLength());
		
		node = eObjectAtOffsetHelper.getCrossReferenceNode(resource, new TextRegion(firstPart.length()+1, 8));
		assertEquals(firstPart.length()+1, node.getOffset());
		assertEquals(8, node.getLength());
		
		assertNull(eObjectAtOffsetHelper.getCrossReferenceNode(resource, new TextRegion(firstPart.length()+1, 9)));
	}

	private void checkContainedElementAt(XtextResource resource, String model, String substring, EObject expectedElement) {
		int index = model.indexOf(substring);
		for (int i = index; i < index + substring.length(); ++i) {
			EObject foundElement = eObjectAtOffsetHelper.resolveElementAt(resource, i);
			assertEquals(expectedElement, foundElement);
			foundElement = eObjectAtOffsetHelper.resolveCrossReferencedElementAt(resource, i);
			assertNotSame(expectedElement, foundElement);
		}
	}

	private void checkCrossReferencedElementAt(XtextResource resource, String model, String substring,
			EObject expectedElement) {
		int index = model.indexOf(substring);
		for (int i = index; i < index + substring.length(); ++i) {
			EObject foundElement = eObjectAtOffsetHelper.resolveCrossReferencedElementAt(resource, i);
			assertEquals(expectedElement, foundElement);
			foundElement = eObjectAtOffsetHelper.resolveElementAt(resource, i);
			assertEquals(expectedElement, foundElement);
		}
	}
}
