/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.parser

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.nodemodel.ILeafNode
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.nodemodel.impl.InvariantChecker
import org.eclipse.xtext.parser.IParseResult
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.EmfFormatter
import org.eclipse.xtext.xbase.testlanguages.ContentAssistFragmentTestLangInjectorProvider
import org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.ContentAssistFragmentTestLanguageRoot
import org.junit.Assert
import org.junit.ComparisonFailure
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(ContentAssistFragmentTestLangInjectorProvider)
class Bug480686Test {
	@Inject
	ParseHelper<ContentAssistFragmentTestLanguageRoot> parseHelper;

	@Test 
	def void testUpdateTwice() {
		val result = parseHelper.parse("")
		val res = result.eResource as XtextResource
		new InvariantChecker().checkInvariant(res.parseResult.rootNode)
		res.update(0, 0, "newArrayList()")
		val first = res.contents.head
		Assert.assertTrue(first.eClass.name, first instanceof ContentAssistFragmentTestLanguageRoot)
		res.update("newArrayList(".length, 0, "1")
		val second = res.contents.head
		Assert.assertTrue(second.eClass.name, second instanceof ContentAssistFragmentTestLanguageRoot)
	}

	@Test 
	def void testBrokenInput_01() {
		val result = parseHelper.parse("}")
		val res = result.eResource as XtextResource
		val invariantChecker = new InvariantChecker()
		invariantChecker.checkInvariant(res.parseResult.rootNode)
		res.update(0, 0, "newArrayList()")
		invariantChecker.checkInvariant(res.parseResult.rootNode)
		val first = res.contents.head
		Assert.assertTrue(first.eClass.name, first instanceof ContentAssistFragmentTestLanguageRoot)
		res.update("newArrayList(".length, 0, "1")
		invariantChecker.checkInvariant(res.parseResult.rootNode)
		val second = res.contents.head
		Assert.assertTrue(second.eClass.name, second instanceof ContentAssistFragmentTestLanguageRoot)
	}

	@Test 
	def void testBrokenInput_02() {
		val result = parseHelper.parse("}} abc")
		val res = result.eResource as XtextResource
		val invariantChecker = new InvariantChecker()
		invariantChecker.checkInvariant(res.parseResult.rootNode)
		res.update(0, 0, "newArrayList()")
		invariantChecker.checkInvariant(res.parseResult.rootNode)
		val first = res.contents.head
		Assert.assertTrue(first.eClass.name, first instanceof ContentAssistFragmentTestLanguageRoot)
		res.update("newArrayList(".length, 0, "1")
		invariantChecker.checkInvariant(res.parseResult.rootNode)
		val second = res.contents.head
		Assert.assertTrue(second.eClass.name, second instanceof ContentAssistFragmentTestLanguageRoot)
	}
		
	@Test 
	def void testAllGrammarElementsUnique() {
		val result = parseHelper.parse("newArrayList()")
		val res = result.eResource as XtextResource
		val root = res.parseResult.rootNode
		new InvariantChecker().checkInvariant(root)
		val set = newHashSet
		for(node: root.asTreeIterable) {
			if (node instanceof ICompositeNode) {
				if (node.grammarElement !== null) {
					Assert.assertTrue(node.grammarElement.toString, set.add(node.grammarElement))
				} else {
					Assert.fail("node without grammar element")
				}
			}
		}
	}

	@Test 
	def void testAllGrammarElementsUniqueAfterReparse() {
		val result = parseHelper.parse("")
		val res = result.eResource as XtextResource
		res.update(0, 0, "newArrayList()")
		val root = res.parseResult.rootNode
		val set = newHashSet
		for(node: root.asTreeIterable) {
			if (node instanceof ICompositeNode) {
				if (node.grammarElement !== null) {
					Assert.assertTrue(node.grammarElement.toString, set.add(node.grammarElement))
				} else {
					Assert.fail("node without grammar element")
				}
			}
		}
	}

	@Test 
	def void testCompareNodeModel() {
		val result = parseHelper.parse("")
		val res = result.eResource as XtextResource
		res.update(0, 0, "newArrayList()")
		val fresh = parseHelper.parse("newArrayList()")
		res.parseResult.assertEqual((fresh.eResource as XtextResource).parseResult)
	}


	def private void assertEqual(IParseResult parsedFromScratch, IParseResult reparsed) {
		var rootFromScratch=parsedFromScratch.getRootASTElement() 
		var rootReparsed=reparsed.getRootASTElement() 
		assertEqual(EmfFormatter.objToStr(rootFromScratch), EmfFormatter.objToStr(rootReparsed)) 
		assertEqual(parsedFromScratch.getRootNode(), reparsed.getRootNode()) 
	}
	def private void assertEqual(ICompositeNode fromScratch, ICompositeNode reparsed) {
		var scratchIterator=fromScratch.getAsTreeIterable().iterator() 
		var reparsedIterator=reparsed.getAsTreeIterable().iterator() 
		while (scratchIterator.hasNext()) {
			Assert.assertTrue(reparsedIterator.hasNext()) 
			assertEqualNodes(scratchIterator.next(), reparsedIterator.next()) 
		}
		Assert.assertFalse(scratchIterator.hasNext()) 
		Assert.assertFalse(reparsedIterator.hasNext()) 
	}
	def private void assertEqualNodes(INode node, INode other) {
		Assert.assertEquals(node.getClass(), other.getClass()) 
		if (node instanceof ILeafNode) {
			Assert.assertEquals(node.getTotalOffset(), other.getTotalOffset()) 
			Assert.assertEquals(node.getTotalLength(), other.getTotalLength()) 
		}
		Assert.assertEquals(node.getGrammarElement(), other.getGrammarElement()) 
		Assert.assertEquals(node.hasDirectSemanticElement(), other.hasDirectSemanticElement()) 
		Assert.assertEquals(node.getSyntaxErrorMessage(), other.getSyntaxErrorMessage()) 
		if (node instanceof ICompositeNode) {
			Assert.assertEquals(node.getLookAhead(), ((other as ICompositeNode)).getLookAhead()) 
		}
	}
	def private void assertEqual(String parsedFromScratch, String reparsed) {
		if (!parsedFromScratch.equals(reparsed)) {
			throw new ComparisonFailure("Parsed EObjects are not equal", parsedFromScratch, reparsed)
		}
	}

	@Test 
	def void testReparse() {
		val result = parseHelper.parse(" newArrayList(1) ")
		val res = result.eResource as XtextResource
		res.reparse(" newArrayList(2) ")
		val first = res.contents.head
		Assert.assertTrue(first instanceof ContentAssistFragmentTestLanguageRoot)
	}
	
	@Test 
	def void testAddComment() {
		val result = parseHelper.parse(" newArrayList(1) ")
		val res = result.eResource as XtextResource
		res.update(0, 0, ' /* abc */ ')
		val first = res.contents.head
		Assert.assertTrue(first instanceof ContentAssistFragmentTestLanguageRoot)
	}
	
	@Test 
	def void testRemoveSpace() {
		val result = parseHelper.parse(" newArrayList(1) ")
		val res = result.eResource as XtextResource
		res.update(0, 1, '')
		val first = res.contents.head
		Assert.assertTrue(first instanceof ContentAssistFragmentTestLanguageRoot)
	}
}