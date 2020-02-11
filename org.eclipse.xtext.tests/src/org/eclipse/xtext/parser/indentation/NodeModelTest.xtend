/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.indentation

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.Action
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.nodemodel.impl.InvariantChecker
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.Tree
import org.eclipse.xtext.parser.indentation.tests.IndentationAwareTestLanguageInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(IndentationAwareTestLanguageInjectorProvider)
class NodeModelTest {
	
	def static void assertEquals(Object expected, Object actual) {
		Assert.assertEquals(expected.toString.replaceAll("\r\n","\n"), actual.toString.replaceAll("\r\n","\n"))
	}

	@Inject	ParseHelper<Tree> parseHelper
	
	@Inject
	extension InvariantChecker invariantChecker
	
	@Test
	def void testEmptyTree() {
		val tree = ''.rootNode
		''.assertEquals(tree.asText)
	}
	
	@Test
	def void testSingleRootNode() {
		val tree = 'root'.rootNode
		'''
			[ID:root]
		'''.toString.trim.assertEquals(tree.asText)
	}
	
	@Test
	def void testTwoRootNodes() {
		val tree = '''
			first
			second
		'''.rootNode
		'''
			[ID:first][-WS:
			][ID:second][-WS:
			]
		'''.toString.trim.assertEquals(tree.asText)
	}
	
	@Test
	def void testParentChild() {
		val tree = '''
			parent
				child
		'''.rootNode
		'''
			[ID:parent][-WS:
			\t][INDENT:][ID:child][-WS:
			][DEDENT:]
		'''.toString.trim.assertEquals(tree.asText)
	}
	
	@Test
	def void testParentChildWithEof() {
		val tree = '''
			parent
				child
		'''.toString.trim.rootNode
		'''
			[ID:parent][-WS:
			\t][INDENT:][ID:child][DEDENT:]
		'''.toString.trim.assertEquals(tree.asText)
	}
	
	@Test
	def void testParentChildren() {
		val tree = '''
			parent
				child
				child
		'''.rootNode
		'''
			[ID:parent][-WS:
			\t][INDENT:][ID:child][-WS:
			\t][ID:child][-WS:
			][DEDENT:]
		'''.toString.trim.assertEquals(tree.asText)
	}
	
	@Test
	def void testTree_01() {
		val tree = '''
			a
				b
				 c
				d
		'''.rootNode
		'''
			[ID:a][-WS:
			\t][INDENT:][ID:b][-WS:
			\t ][INDENT:][ID:c][-WS:
			][DEDENT:][-WS:\t][ID:d][-WS:
			][DEDENT:]
		'''.toString.trim.assertEquals(tree.asText)
	}
	
	@Test
	def void testWeirdTree() {
		val tree = '''
			root
			    s4
			        s8
			      s6
		'''.rootNode
		'''
			[ID:root][-WS:
			    ][INDENT:][ID:s4][-WS:
			        ][INDENT:][ID:s8][-WS:
			][DEDENT:][-WS:      ][INDENT:][ID:s6][-WS:
			][DEDENT:][DEDENT:]
		'''.toString.trim.assertEquals(tree.asText)
	}
	
	@Test
	def void testWeirdTreeEof() {
		val tree = '''
			root
			    s4
			        s8
			      s6
		'''.toString.trim.rootNode
		'''
			[ID:root][-WS:
			    ][INDENT:][ID:s4][-WS:
			        ][INDENT:][ID:s8][-WS:
			][DEDENT:][-WS:      ][INDENT:][ID:s6][DEDENT:][DEDENT:]
		'''.toString.trim.assertEquals(tree.asText)
	}
	
	@Test
	def void testIgnoreEmptyLines_1() {
		val tree = '''
			first
				
			second
		'''.rootNode
		'''
			[ID:first][-WS:
			\t
			][ID:second][-WS:
			]
		'''.toString.trim.assertEquals(tree.asText)
	}
	
	@Test
	def void testIgnoreEmptyLines_2() {
		val tree = '''
			"first"
				
			"second"
		'''.rootNode
		'''
			[STRING:"first"][-WS:
			\t
			][STRING:"second"][-WS:
			]
		'''.toString.trim.assertEquals(tree.asText)
	}
	
	@Test
	def void testIgnoreEmptyLines_3() {
		val tree = 'first\n\t'.rootNode
		'''
			[ID:first][-WS:
			\t]
		'''.toString.trim.assertEquals(tree.asText)
	}
	
	@Test
	def void testIgnoreEmptyLines_4() {
		// first<LB>
		//                 abc<LB>
		//         <EOF>
		val tree = 'first\n\t\tabc\n\t'.rootNode
		'''
			[ID:first][-WS:
			\t\t][INDENT:][ID:abc][-WS:
			][DEDENT:][-WS:\t]
		'''.toString.trim.assertEquals(tree.asText)
	}
	
	@Test
	def void testIgnoreEmptyLines_5() {
		// first<LB>
		//   abc<LB>
		// <LB>
		// <EOF>
		val tree = 'first\n\t\tabc\n\n'.rootNode
		'''
			[ID:first][-WS:
			\t\t][INDENT:][ID:abc][-WS:
			][DEDENT:][-WS:
			]
		'''.toString.trim.assertEquals(tree.asText)
	}
	
	@Test
	def void testIgnoreEmptyLines_6() {
		// first<LB>
		//   abc<LB>
		//   <LB>
		// <EOF>
		val tree = 'first\n\t\tabc\n\t\n'.rootNode
		'''
			[ID:first][-WS:
			\t\t][INDENT:][ID:abc][-WS:
			][DEDENT:][-WS:\t
			]
		'''.toString.trim.assertEquals(tree.asText)
	}
	
	@Test
	def void testIgnoreEmptyLines_7() {
		// a<LB>
		//   b<LB>
		//     <EOF>
		val tree = 'a\n\tb\n\t '.rootNode
		'''
			[ID:a][-WS:
			\t][INDENT:][ID:b][-WS:
			\t ][DEDENT:]
		'''.toString.trim.assertEquals(tree.asText)
	}
	
//	@Test
//	def void testTree_02() {
//		val tree = '''
//			a
//				b
//				 c
//				d
//				e
//					  f
//					  g
//			h
//		'''.parseAndValidate
//		'''
//			a
//				b
//					c
//				d
//				e
//					f
//					g
//			h
//		'''.toString.assertEquals(tree.asText)
//	}
//	
//	@Test
//	def void testTree_03() {
//		val tree = '''
//			a
//				b // single tab
//			        c // 8 spaces eq 1 tab
//			d
//		'''.parseAndValidate
//		'''
//			a
//				b
//				c
//			d
//		'''.toString.assertEquals(tree.asText)
//	}
//	
//	@Test
//	def void testTree_04() {
//		val tree = '''
//			level0_1
//				level1_1
//				level1_2
//					level2_1
//					level2_2
//				level1_3
//					level2_3
//					level2_4
//						level3_1
//						level3_2
//					level2_5
//				level1_4
//					level2_6
//			level0_2
//					level1_5
//							level2_7
//									level3_8
//											level4_9
//		'''.parseAndValidate
//		'''
//			level0_1
//				level1_1
//				level1_2
//					level2_1
//					level2_2
//				level1_3
//					level2_3
//					level2_4
//						level3_1
//						level3_2
//					level2_5
//				level1_4
//					level2_6
//			level0_2
//				level1_5
//					level2_7
//						level3_8
//							level4_9
//		'''.toString.assertEquals(tree.asText)
//	}
//	
//	@Test
//	def void testTree_05() {
//		val tree = '''
//			a
//				x
//					b // two tabs
//				        c // tab and 8 spaces (eq 2 tabs)
//				y
//		'''.parseAndValidate
//		'''
//			a
//				x
//					b
//					c
//				y
//		'''.toString.assertEquals(tree.asText)
//	}
//	
//	@Test
//	def void testTree_06() {
//		val tree = '''
//			"a"
//			"b"
//		'''.parseAndValidate
//		'''
//			a
//			b
//		'''.toString.assertEquals(tree.asText)
//	}
//	
//	@Test
//	def void testTree_07() {
//		val tree = '''
//			"a"
//				
//			"b"
//					
//		'''.parseAndValidate
//		'''
//			a
//				>
//			b
//				>
//		'''.toString.assertEquals(tree.asText)
//	}
//	
//	@Test
//	def void testTree_08() {
//		val tree = '''
//			"a"
//				"1"
//				"2"
//			"b"
//					"3"
//		'''.parseAndValidate
//		'''
//			a
//				>
//					1
//					2
//			b
//				>
//					3
//		'''.toString.assertEquals(tree.asText)
//	}
	
	private def getRootNode(CharSequence seq) {
		val model = parseHelper.parse(seq.toString.replaceAll("\r\n","\n"));
		val result = NodeModelUtils.getNode(model).rootNode
		result.checkInvariant
		return result
	}
	
	private def String asText(INode node) {
		node.leafNodes.filter[!(grammarElement instanceof Action)].join('[', '][', ']') [
			(if (isHidden) '-' else '') + grammarElement.tokenType + ':' + text.replace('\t', '\\t')
		]
	}
	
	private def String tokenType(EObject obj) {
		switch(obj) {
			RuleCall: obj.rule.name
			Keyword: obj.value
			AbstractRule: obj.name
		}
	}
	
}