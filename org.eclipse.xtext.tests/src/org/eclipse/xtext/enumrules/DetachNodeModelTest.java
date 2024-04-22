/*******************************************************************************
 * Copyright (c) 2024 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.enumrules;

import java.io.IOException;
import java.util.Iterator;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.EntityWithEnumAndReference;
import org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.EnumAndReferenceTestLanguagePackage;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.detachable.DetachableParseResult;
import org.eclipse.xtext.nodemodel.impl.RootNode;
import org.eclipse.xtext.parser.ParserTestHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.junit.Test;

/**
 * @author Sebastian - Initial contribution and API
 */
public class DetachNodeModelTest extends AbstractEnumRulesTest {
	private ParserTestHelper helper;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(EnumAndReferenceTestLanguageStandaloneSetup.class);
		helper = new ParserTestHelper(getResourceFactory(), getParser(), get(Keys.RESOURCE_SET_KEY),getCurrentFileExtension());
	}
	
	@Test public void testNodeModelIsSameWhenAccessedWithoutRelease() throws Exception {
		String modelAsString = "kindOfKeyword Hoo reference Hoo";
		XtextResource resource = parse(modelAsString);
		DetachableParseResult parseResult = (DetachableParseResult) resource.getParseResult();
		ICompositeNode rootNode = parseResult.getRootNode();
		assertSame(rootNode, parseResult.getRootNode());
		
		EntityWithEnumAndReference model = (EntityWithEnumAndReference) resource.getContents().get(0);
		assertEquals("Hoo", model.getName());
		EntityWithEnumAndReference proxy = (EntityWithEnumAndReference) model.eGet(EnumAndReferenceTestLanguagePackage.Literals.ENTITY_WITH_ENUM_AND_REFERENCE__REF, false);
		assertTrue(proxy.eIsProxy());
		
		EcoreUtil.resolveAll(resource);
		assertTrue(resource.getErrors().isEmpty());
	}
	
	@Test public void testNodeModelCanBeReleased() throws Exception {
		String modelAsString = "kindOfKeyword Hoo reference Hoo";
		XtextResource resource = parse(modelAsString);
		DetachableParseResult parseResult = (DetachableParseResult) resource.getParseResult();
		RootNode rootNode = (RootNode) parseResult.getRootNode();
		
		parseResult.releaseNodeModel(true);
		
		assertNotSame(rootNode, parseResult.getRootNode());
		assertSame(parseResult.getRootNode(), parseResult.getRootNode());
		assertEqualNodes(rootNode, (RootNode) parseResult.getRootNode());
		
		EntityWithEnumAndReference model = (EntityWithEnumAndReference) resource.getContents().get(0);
		assertEquals("Hoo", model.getName());
		EntityWithEnumAndReference proxy = (EntityWithEnumAndReference) model.eGet(EnumAndReferenceTestLanguagePackage.Literals.ENTITY_WITH_ENUM_AND_REFERENCE__REF, false);
		assertTrue(proxy.eIsProxy());
		
		EcoreUtil.resolveAll(resource);
		assertTrue(resource.getErrors().isEmpty());
	}
	
	@Test public void testNoExceptionWhenRemovedFromResourceSet() throws Exception {
		String modelAsString = "kindOfKeyword Hoo reference Hoo";
		XtextResource resource = parse(modelAsString);
		ResourceSet rs = resource.getResourceSet();
		rs.getResources().remove(resource);
	}
	
	protected void assertEqualNodes(RootNode expected, RootNode actual) throws IOException {
		Iterator<INode> expectedIter = expected.getAsTreeIterable().iterator();
		Iterator<INode> actualIter = actual.getAsTreeIterable().iterator();
		while(expectedIter.hasNext()) {
			assertTrue(actualIter.hasNext());
			doAssertEqualNodes(expectedIter.next(), actualIter.next());
		}
		assertFalse(actualIter.hasNext());
	}

	protected void doAssertEqualNodes(INode expected, INode actual) {
		assertEquals("class", expected.getClass(), actual.getClass());
		assertEquals("text", expected.getText(), actual.getText());
		assertEquals("total offset", expected.getTotalOffset(), actual.getTotalOffset());
		assertEquals("total length", expected.getTotalLength(), actual.getTotalLength());
		assertEquals("grammar element", expected.getGrammarElement(), actual.getGrammarElement());
		assertEquals("direct semantic element", expected.hasDirectSemanticElement(), actual.hasDirectSemanticElement());
		assertSame(expected.getSemanticElement(), actual.getSemanticElement());
		assertEquals("syntax error message", expected.getSyntaxErrorMessage(), actual.getSyntaxErrorMessage());
		if (expected instanceof ICompositeNode) {
			assertEquals("lookAhead", ((ICompositeNode) expected).getLookAhead(), ((ICompositeNode) actual).getLookAhead());
		}
	}
	
	protected XtextResource parse(String modelAsString) throws IOException {
		return helper.getResourceFromString(modelAsString);
	}
}
