/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.parsing;

import java.io.IOException;
import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.InvariantChecker;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PartialParserTest extends AbstractXtend2TestCase {
	
	@Inject
	private InvariantChecker invariantChecker;
	
	public void testNoClassCastException() throws Exception {
		String model =
				"package org.eclipse.xtext.xtend2.tests.parsing\n" + 
				"\n" + 
				"class NoClassCastException {\n" + 
				"\n" + 
				"	String foo(String a, String b) {\n" + 
				"		if (isUpper(a)) {\n" + 
				"			another(a,b+'holla')";
		doTestUpdateAtEnd(model, '\n', "NoClassCastException.xtend");
	}
	
	public void testSyntaxErrorOnLeafNode_01() throws Exception {
		String model =
			"package org.eclipse.xtext.xtend2.tests.parsing\n" + 
			"\n" + 
			"class SyntaxErrorOnLeafNode {\n" + 
			"\n" + 
			"	String foo(String a, String b) {\n" + 
			"		if (isUpper(a)) {\n" + 
			"			another(a,b+'holla')\n" + 
			"		} else {\n" + 
			"			val x = a;\n" + 
			"			for (y : b.toCharArray) {\n" + 
			"				x = x+";
		doTestUpdateAtEnd(model, 'y', "SyntaxErrorOnLeafNode.xtend");
	}
	
	public void testSyntaxErrorOnLeafNode_02() throws Exception {
		String model =
			"package org.eclipse.xtext.xtend2.tests.linking\n" + 
			"\n" + 
			"class SyntaxErrorOnLeafNode {\n" + 
			"\n" + 
			"	String foo(String a, String b) {\n" + 
			"		if (isUpper(a)) {\n" + 
			"			another(a,b+'holla')\n" + 
			"		} else {\n" + 
			"			val x = a;\n" + 
			"			for (y : b.toCharArray) {\n" + 
			"				x = x+y\n" + 
			"			}\n" + 
			"			x\n" + 
			"		}\n" + 
			"	}\n" + 
			"	\n" + 
			"	private isUpper(String s) \n" + 
			"		s.";
		doTestUpdateAtEnd(model, 't', "SyntaxErrorOnLeafNode.xtend");
	}

	public void testErroneousModelRemoved() throws Exception {
		String model =
				"\n" + 
				"\n" + 
				"class ErroneousModelRemoved {\n" + 
				"\n" + 
				"	String foo(String a, String b) {\n" + 
				"		if (isUpper(a)) {\n" + 
				"			another(a,b+'holla')\n" + 
				"		} else {\n" + 
				"			val x = a;\n" + 
				"			for (y : b.toCharArray) {\n" + 
				"				x = x+y\n" + 
				"			}\n" + 
				"			x\n" + 
				"		}\n" + 
				"	}\n" + 
				"	\n" + 
				"	private isUpper(String s) \n" + 
				"		s.toUpperCase == s\n" + 
				"		\n" + 
				"	private another(String x, String y) \n" + 
				"		y+x\n" + 
				"	\n" + 
				"\n" + 
				"}";
		XtextResource resource = doTestUpdateAtOffset(model, 0, 0, "g", "ErroneousModelRemoved.xtend");
		assertTrue(resource.getContents().isEmpty());
	}
	
	public void testEqualNodeModels() throws Exception {
		String model =
				"package org.eclipse.xtext.xtend2.tests.parsing\n" + 
				"\n" + 
				"class EqualNodeModels {\n" + 
				"\n" + 
				"	String foo(String a, String b) {\n" + 
				"		if (isUpper(a)) {\n" + 
				"			another(a,b+'holla')";
		doTestUpdateAtEnd(model, '\n', "EqualNodeModels.xtend");
	}
	
	public void testEqualNodeModels_02() throws Exception {
		String model = "package org.eclipse.xtext.xtend2.tests.linking\n" + 
				"\n" + 
				"class EqualNodeModels {\n" + 
				"\n" + 
				"	String foo(String a, Stringb) {\n" + 
				"		if (isUpper(a)) {\n" + 
				"			another(a,b+'holla')\n" + 
				"		} else {\n" + 
				"			val x = a;\n" + 
				"			for (y : b.toCharArray) {\n" + 
				"				x = x+y\n" + 
				"			}\n" + 
				"			x\n" + 
				"		}\n" + 
				"	}\n" + 
				"	\n" + 
				"	private isUpper(String s) \n" + 
				"		s.toUpperCase == s\n" + 
				"		\n" + 
				"	private another(String x, String y) \n" + 
				"		y+x\n" + 
				"	\n" + 
				"\n" + 
				"}";
		// offset's origin is the smoke test
		doTestUpdateAtOffset(model, 101, 1, " ", "EqualNodeModels.xtend");
	}
	
	public void testEqualNodeModels_03() throws Exception {
		String model = "package org.eclipse.xtext.xtend2.tests.linking\n" + 
				"\n" + 
				"class EqualNodeModels {\n" + 
				"\n" + 
				"	String foo(String a, String b) {\n" + 
				"		if (isUpper(a)) {\n" + 
				"			another(a,b+'olla')\n" + 
				"		} else {\n" + 
				"			val x = a;\n" + 
				"			for (y : b.toCharArray) {\n" + 
				"				x = x+y\n" + 
				"			}\n" + 
				"			x\n" + 
				"		}\n" + 
				"	}\n" + 
				"	\n" + 
				"	private isUpper(String s) \n" + 
				"		s.toUpperCase == s\n" + 
				"		\n" + 
				"	private another(String x, String y) \n" + 
				"		y+x\n" + 
				"	\n" + 
				"\n" + 
				"}";
		
		doTestUpdateAtOffset(model, 143, 1, "h", "EqualNodeModels.xtend");
	}
	
	public void testEqualNodeModels_04() throws Exception {
		String model = "package org.eclipse.xtext.xtend2.tests.linking\n" + 
				"\n" + 
				"class EqualNodeModels {\n" + 
				"\n" + 
				"	String foo(String a, String b) {\n" + 
				"		if (isUpper(a)) {\n" + 
				"			another(a,b+'holla')\n" + 
				"		} else {\n" + 
				"			val x = a;\n" + 
				"			for (y : b.toCharArray) {\n" + 
				"				x = x+y\n" + 
				"			}\n" + 
				"			x\n" + 
				"		}\n" + 
				"	}\n" + 
				"	\n" + 
				"	private isUpper(String s) \n" + 
				"		s.toUpperCase== s\n" + 
				"		\n" + 
				"	private another(String x, String y) \n" + 
				"		y+x\n" + 
				"	\n" + 
				"\n" + 
				"}";
		doTestUpdateAtOffset(model, 279, 1, " ", "EqualNodeModels.xtend");
	}
	
	protected XtextResource doTestUpdateAtEnd(String model, char character, String fileName) throws IOException {
		return doTestUpdateAtOffset(model, model.length(), 0, String.valueOf(character), fileName);
	}

	protected XtextResource doTestUpdateAtOffset(String model, int offset, int length, String newText, String fileName) throws IOException {
		XtextResourceSet resourceSet = get(XtextResourceSet.class);
		XtextResource resource = (XtextResource) resourceSet.createResource(URI.createURI(fileName));
		resource.load(new StringInputStream(model), null);
		resource.update(offset, length, newText);
		XtextResourceSet secondResourceSet = get(XtextResourceSet.class);
		XtextResource newResource = (XtextResource) secondResourceSet.createResource(URI.createURI(fileName));
		newResource.load(new StringInputStream(new StringBuilder(model).replace(offset, offset + length, newText).toString()), null);
		assertEqualNodes(newResource, resource);
		return resource;
	}
	
	protected void assertEqualNodes(XtextResource expected, XtextResource actual) throws IOException {
		ICompositeNode expectedRoot = expected.getParseResult().getRootNode();
		invariantChecker.checkInvariant(expectedRoot);
		ICompositeNode actualRoot = actual.getParseResult().getRootNode();
		invariantChecker.checkInvariant(actualRoot);
		Iterator<INode> expectedIter = expectedRoot.getAsTreeIterable().iterator();
		Iterator<INode> actualIter = actualRoot.getAsTreeIterable().iterator();
		while(expectedIter.hasNext()) {
			assertTrue(actualIter.hasNext());
			assertEqualNodes(expectedIter.next(), actualIter.next());
		}
		assertFalse(actualIter.hasNext());
	}

	protected void assertEqualNodes(INode expected, INode actual) {
		assertEquals("class", expected.getClass(), actual.getClass());
		assertEquals("text", expected.getText(), actual.getText());
		assertEquals("total offset", expected.getTotalOffset(), actual.getTotalOffset());
		assertEquals("total length", expected.getTotalLength(), actual.getTotalLength());
		assertEquals("grammar element", expected.getGrammarElement(), actual.getGrammarElement());
		assertEquals("direct semantic element", expected.hasDirectSemanticElement(), actual.hasDirectSemanticElement());
//		assertTrue(EcoreUtil.equals(expected.getSemanticElement(), actual.getSemanticElement()));
		assertEquals("syntax error message", expected.getSyntaxErrorMessage(), actual.getSyntaxErrorMessage());
		if (expected instanceof ICompositeNode) {
			assertEquals("lookAhead", ((ICompositeNode) expected).getLookAhead(), ((ICompositeNode) actual).getLookAhead());
		}
	}
}
