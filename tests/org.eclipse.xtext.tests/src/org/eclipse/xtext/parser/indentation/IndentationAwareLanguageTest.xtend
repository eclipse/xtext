/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.indentation

import org.eclipse.xtext.junit4.AbstractXtextTests
import org.junit.Before
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.Tree
import org.junit.Test
import com.google.inject.Inject
import org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.TreeNode
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtend2.lib.StringConcatenation
import org.eclipse.xtext.nodemodel.impl.InvariantChecker
import org.eclipse.xtext.resource.XtextResource

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class IndentationAwareLanguageTest extends AbstractXtextTests {

	@Inject
	extension ParseHelper<Tree> parseHelper
	
	@Inject
	extension ValidationTestHelper validationTestHelper
	
	@Inject
	extension InvariantChecker invariantChecker
	
	@Before
	override setUp() throws Exception {
		super.setUp()
		with(IndentationAwareTestLanguageStandaloneSetup)
		injector.injectMembers(this)
	}

	@Test
	def void testEmptyTree() {
		val tree = ''.parse
		assertNotNull(tree)
		assertTrue(tree.nodes.empty)
	}
	
	@Test
	def void testSingleRootNode() {
		val tree = 'root'.parse
		assertNotNull(tree)
		assertEquals(1, tree.nodes.size)
		assertEquals('root', tree.nodes.head.name)
	}
	
	@Test
	def void testTwoRootNodes() {
		val tree = '''
			first
			second
		'''.parse
		assertNotNull(tree)
		assertEquals(2, tree.nodes.size)
		assertEquals('first', tree.nodes.head.name)
		assertEquals('second', tree.nodes.last.name)
	}
	
	@Test
	def void testParentChild() {
		val tree = '''
			parent
				child
		'''.parse
		assertNotNull(tree)
		assertEquals(1, tree.nodes.size)
		assertEquals('parent', tree.nodes.head.name)
		assertEquals('child', tree.nodes.head.children.head.name)
		'''
			parent
				child
		'''.toString.assertEquals(tree.asText)
	}
	
	@Test
	def void testParentChildren() {
		val tree = '''
			parent
				child
				child
		'''.parse
		'''
			parent
				child
				child
		'''.toString.assertEquals(tree.asText)
	}
	
	@Test
	def void testTree_01() {
		val tree = '''
			a
				b
				 c
				d
		'''.parseAndValidate
		'''
			a
				b
					c
				d
		'''.toString.assertEquals(tree.asText)
	}
	
	@Test
	def void testTree_02() {
		val tree = '''
			a
				b
				 c
				d
				e
					  f
					  g
			h
		'''.parseAndValidate
		'''
			a
				b
					c
				d
				e
					f
					g
			h
		'''.toString.assertEquals(tree.asText)
	}
	
	@Test
	def void testTree_03() {
		val tree = '''
			a
				b // single tab
			        c // 8 spaces eq 1 tab
			d
		'''.parseAndValidate
		'''
			a
				b
				c
			d
		'''.toString.assertEquals(tree.asText)
	}
	
	private def parseAndValidate(CharSequence s) {
		val result = s.parse
		result.assertNoIssues
		val resource = result.eResource as XtextResource
		val node = resource.parseResult.rootNode
		node.checkInvariant
		return result
	}
	
	private def String asText(Tree tree) '''
		«FOR node: tree.nodes»
			«node.asText»
		«ENDFOR»
	'''
	
	private def StringConcatenation asText(TreeNode treeNode) '''
		«treeNode.name»
			«FOR node: treeNode.children»
				«node.asText»
			«ENDFOR»
	'''
	
}