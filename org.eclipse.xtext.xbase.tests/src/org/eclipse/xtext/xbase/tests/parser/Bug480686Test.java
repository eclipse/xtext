/**
 * Copyright (c) 2015, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.parser;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.InvariantChecker;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.ContentAssistFragmentTestLanguageRoot;
import org.eclipse.xtext.xbase.testlanguages.tests.ContentAssistFragmentTestLangInjectorProvider;
import org.junit.Assert;
import org.junit.ComparisonFailure;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(ContentAssistFragmentTestLangInjectorProvider.class)
public class Bug480686Test {
	@Inject
	private ParseHelper<ContentAssistFragmentTestLanguageRoot> parseHelper;

	@Test
	public void testUpdateTwice() throws Exception {
		ContentAssistFragmentTestLanguageRoot result = parseHelper.parse("");
		XtextResource res = (XtextResource) result.eResource();
		new InvariantChecker().checkInvariant(res.getParseResult().getRootNode());
		res.update(0, 0, "newArrayList()");
		EObject first = Iterables.getFirst(res.getContents(), null);
		Assert.assertNotNull(first);
		Assert.assertTrue(first.eClass().getName(), first instanceof ContentAssistFragmentTestLanguageRoot);
		res.update("newArrayList(".length(), 0, "1");
		EObject second = Iterables.getFirst(res.getContents(), null);
		Assert.assertNotNull(second);
		Assert.assertTrue(second.eClass().getName(), second instanceof ContentAssistFragmentTestLanguageRoot);
	}

	@Test
	public void testBrokenInput_01() throws Exception {
		ContentAssistFragmentTestLanguageRoot result = parseHelper.parse("}");
		XtextResource res = (XtextResource) result.eResource();
		InvariantChecker invariantChecker = new InvariantChecker();
		invariantChecker.checkInvariant(res.getParseResult().getRootNode());
		res.update(0, 0, "newArrayList()");
		invariantChecker.checkInvariant(res.getParseResult().getRootNode());
		EObject first = Iterables.getFirst(res.getContents(), null);
		Assert.assertNotNull(first);
		Assert.assertTrue(first.eClass().getName(), first instanceof ContentAssistFragmentTestLanguageRoot);
		res.update("newArrayList(".length(), 0, "1");
		invariantChecker.checkInvariant(res.getParseResult().getRootNode());
		EObject second = Iterables.getFirst(res.getContents(), null);
		Assert.assertNotNull(second);
		Assert.assertTrue(second.eClass().getName(), second instanceof ContentAssistFragmentTestLanguageRoot);
	}

	@Test
	public void testBrokenInput_02() throws Exception {
		ContentAssistFragmentTestLanguageRoot result = parseHelper.parse("}} abc");
		XtextResource res = (XtextResource) result.eResource();
		InvariantChecker invariantChecker = new InvariantChecker();
		invariantChecker.checkInvariant(res.getParseResult().getRootNode());
		res.update(0, 0, "newArrayList()");
		invariantChecker.checkInvariant(res.getParseResult().getRootNode());
		EObject first = Iterables.getFirst(res.getContents(), null);
		Assert.assertNotNull(first);
		Assert.assertTrue(first.eClass().getName(), first instanceof ContentAssistFragmentTestLanguageRoot);
		res.update("newArrayList(".length(), 0, "1");
		invariantChecker.checkInvariant(res.getParseResult().getRootNode());
		EObject second = Iterables.getFirst(res.getContents(), null);
		Assert.assertNotNull(second);
		Assert.assertTrue(second.eClass().getName(), second instanceof ContentAssistFragmentTestLanguageRoot);
	}

	@Test
	public void testAllGrammarElementsUnique() throws Exception {
		ContentAssistFragmentTestLanguageRoot result = parseHelper.parse("newArrayList()");
		XtextResource res = (XtextResource) result.eResource();
		ICompositeNode root = res.getParseResult().getRootNode();
		new InvariantChecker().checkInvariant(root);
		Set<EObject> set = new HashSet<>();
		for (INode node : root.getAsTreeIterable()) {
			if (node instanceof ICompositeNode) {
				ICompositeNode compositeNode = (ICompositeNode) node;
				if (compositeNode.getGrammarElement() != null) {
					Assert.assertTrue(compositeNode.getGrammarElement().toString(),
							set.add(compositeNode.getGrammarElement()));
				} else {
					Assert.fail("node without grammar element");
				}
			}
		}
	}

	@Test
	public void testAllGrammarElementsUniqueAfterReparse() throws Exception {
		ContentAssistFragmentTestLanguageRoot result = parseHelper.parse("");
		XtextResource res = (XtextResource) result.eResource();
		res.update(0, 0, "newArrayList()");
		ICompositeNode root = res.getParseResult().getRootNode();
		Set<EObject> set = new HashSet<>();
		for (INode node : root.getAsTreeIterable()) {
			if (node instanceof ICompositeNode) {
				ICompositeNode compositeNode = (ICompositeNode) node;
				if (compositeNode.getGrammarElement() != null) {
					Assert.assertTrue(compositeNode.getGrammarElement().toString(),
							set.add(compositeNode.getGrammarElement()));
				} else {
					Assert.fail("node without grammar element");
				}
			}
		}
	}

	@Test
	public void testCompareNodeModel_01() throws Exception {
		ContentAssistFragmentTestLanguageRoot result = parseHelper.parse("");
		XtextResource res = (XtextResource) result.eResource();
		res.update(0, 0, "newArrayList()");
		ContentAssistFragmentTestLanguageRoot fresh = parseHelper.parse("newArrayList()");
		assertEqual(res.getParseResult(), ((XtextResource) fresh.eResource()).getParseResult());
	}

	@Test
	public void testCompareNodeModel_02() throws Exception {
		ContentAssistFragmentTestLanguageRoot result = parseHelper.parse("{vjava.beans.VetoableChangeListener x = []}");
		XtextResource res = (XtextResource) result.eResource();
		res.update(2, 1, "a");
		ContentAssistFragmentTestLanguageRoot fresh = parseHelper.parse("{ajava.beans.VetoableChangeListener x = []}");
		assertEqual(res.getParseResult(), ((XtextResource) fresh.eResource()).getParseResult());
	}

	@Test
	public void testCompareNodeModel_03() throws Exception {
		ContentAssistFragmentTestLanguageRoot result = parseHelper.parse(
				"{  val Object o = \'foo\'    switch(o) {\n" + 
				"        String: \"\".oString\n" + 
				"    }\n" + 
				"    switch(o) {\n" + 
				"        String: \"\"\n" + 
				"    }}");
		XtextResource res = (XtextResource) result.eResource();
		res.update(58, 1, "t");
		ContentAssistFragmentTestLanguageRoot fresh = parseHelper.parse(
				"{  val Object o = \'foo\'    switch(o) {\n" + 
				"        String: \"\".tString\n" + 
				"    }\n" + 
				"    switch(o) {\n" + 
				"        String: \"\"\n" + 
				"    }}");
		assertEqual(res.getParseResult(), ((XtextResource) fresh.eResource()).getParseResult());
	}

	@Test
	public void testCompareNodeModel_04() throws Exception {
		ContentAssistFragmentTestLanguageRoot result = parseHelper.parse(
				"{  val Object o = \'foo\'    switch(o) {\n" + 
				"        String: \"\".  oString\n" + 
				"    }\n" + 
				"    switch(o) {\n" + 
				"        String: \"\"\n" + 
				"    }}");
		XtextResource res = (XtextResource) result.eResource();
		res.update(60, 1, "t");
		ContentAssistFragmentTestLanguageRoot fresh = parseHelper.parse(
				"{  val Object o = \'foo\'    switch(o) {\n" + 
				"        String: \"\".  tString\n" + 
				"    }\n" + 
				"    switch(o) {\n" + 
				"        String: \"\"\n" + 
				"    }}");
		assertEqual(res.getParseResult(), ((XtextResource) fresh.eResource()).getParseResult());
	}

	private void assertEqual(IParseResult parsedFromScratch, IParseResult reparsed) {
		EObject rootFromScratch = parsedFromScratch.getRootASTElement();
		EObject rootReparsed = reparsed.getRootASTElement();
		assertEqual(EmfFormatter.objToStr(rootFromScratch), EmfFormatter.objToStr(rootReparsed));
		assertEqual(parsedFromScratch.getRootNode(), reparsed.getRootNode());
	}

	private void assertEqual(ICompositeNode fromScratch, ICompositeNode reparsed) {
		BidiTreeIterator<INode> scratchIterator = fromScratch.getAsTreeIterable().iterator();
		BidiTreeIterator<INode> reparsedIterator = reparsed.getAsTreeIterable().iterator();
		while (scratchIterator.hasNext()) {
			Assert.assertTrue(reparsedIterator.hasNext());
			assertEqualNodes(scratchIterator.next(), reparsedIterator.next());
		}
		Assert.assertFalse(scratchIterator.hasNext());
		Assert.assertFalse(reparsedIterator.hasNext());
	}

	private void assertEqualNodes(INode node, INode other) {
		Assert.assertEquals(node.getClass(), other.getClass());
		if (node instanceof ILeafNode) {
			ILeafNode leafNode = (ILeafNode) node;
			Assert.assertEquals(leafNode.getTotalOffset(), other.getTotalOffset());
			Assert.assertEquals(leafNode.getTotalLength(), other.getTotalLength());
		}
		Assert.assertEquals(node.getGrammarElement(), other.getGrammarElement());
		Assert.assertEquals(Boolean.valueOf(node.hasDirectSemanticElement()), other.hasDirectSemanticElement());
		Assert.assertEquals(node.getSyntaxErrorMessage(), other.getSyntaxErrorMessage());
		if (node instanceof ICompositeNode) {
			ICompositeNode compositeNode = (ICompositeNode) node;
			Assert.assertEquals(compositeNode.getText(), compositeNode.getLookAhead(), ((ICompositeNode) other).getLookAhead());
		}
	}

	private void assertEqual(String parsedFromScratch, String reparsed) {
		if (!parsedFromScratch.equals(reparsed)) {
			throw new ComparisonFailure("Parsed EObjects are not equal", parsedFromScratch, reparsed);
		}
	}

	@Test
	public void testReparse() throws Exception {
		ContentAssistFragmentTestLanguageRoot result = parseHelper.parse(" newArrayList(1) ");
		XtextResource res = (XtextResource) result.eResource();
		res.reparse(" newArrayList(2) ");
		EObject first = Iterables.getFirst(res.getContents(), null);
		Assert.assertTrue(first instanceof ContentAssistFragmentTestLanguageRoot);
	}

	@Test
	public void testAddComment() throws Exception {
		ContentAssistFragmentTestLanguageRoot result = parseHelper.parse(" newArrayList(1) ");
		XtextResource res = (XtextResource) result.eResource();
		res.update(0, 0, " /* abc */ ");
		EObject first = Iterables.getFirst(res.getContents(), null);
		Assert.assertTrue(first instanceof ContentAssistFragmentTestLanguageRoot);
	}

	@Test
	public void testRemoveSpace() throws Exception {
		ContentAssistFragmentTestLanguageRoot result = parseHelper.parse(" newArrayList(1) ");
		XtextResource res = (XtextResource) result.eResource();
		res.update(0, 1, "");
		EObject first = Iterables.getFirst(res.getContents(), null);
		Assert.assertTrue(first instanceof ContentAssistFragmentTestLanguageRoot);
	}
}
