/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.indentation

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.Action
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.ide.editor.contentassist.CompletionPrefixProvider
import org.eclipse.xtext.ide.tests.testlanguage.indentationAwareUiTestLanguage.Tree
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Test

import static org.junit.Assert.*

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
abstract class AbstractCompletePrefixProviderTest {
	
	def CompletionPrefixProvider getTestee();
	
	@Inject ParseHelper<Tree> parseHelper;
	
	@Test def void testInputToParse_01() {
		assertEquals("abc", testee.getInputToParse("abcdefg", 3, 7 /* do not care about this */))
	}
	
	@Test def void testInputToParse_02() {
		assertEquals("abc", testee.getInputToParse("abc   defg", 3, 7 /* do not care about this */))
	}
	
	@Test def void testWholeNodeModel() {
		'''
			parent1
				child1
					grandChild1
					grandChild2
				child1
						grandChild3
						
						grandChild4
					
				child2
					
					grandChild5
			parent2
			
		'''.assertLastCompleteNode('''
			[ID:parent1]
			[INDENT:]
			[ID:child1]
			[INDENT:]
			[ID:grandChild1]
			[ID:grandChild2]
			[DEDENT:]
			[ID:child1]
			[INDENT:]
			[ID:grandChild3]
			[ID:grandChild4]
			[DEDENT:]
			[ID:child2]
			[INDENT:]
			[ID:grandChild5]
			[DEDENT:]
			[DEDENT:]
			[ID:parent2]
		''')
	}
	
	@Test def void testLastCompleteNode_0_0() {
		'''
			<|>parent1
				child1
			
		'''.assertLastCompleteNode('''
			[ID:parent1]
			[INDENT:]
			[ID:child1]
			[DEDENT:]
		''')
	}
	
	@Test def void testLastCompleteNode_0_2() {
		'''
			pa<|>rent1
				child1
		'''.assertLastCompleteNode('''
			[ID:parent1]
		''')
	}
	
	@Test def void testLastCompleteNode_1_0() {
		'''
			parent1
			<|>	child1
		'''.assertLastCompleteNode('''
			[ID:parent1]
		''')
	}
	
	@Test def void testLastCompleteNode_1_1() {
		'''
			parent1
				<|>child1
		'''.assertLastCompleteNode('''
			[ID:parent1]
		''')
	}
	
	@Test def void testLastCompleteNode_1_2() {
		'''
			parent1
				c<|>hild1
		'''.assertLastCompleteNode('''
			[ID:parent1]
			[INDENT:]
			[ID:child1]
		''')
	}
	
	@Test def void testLastCompleteNode_2_0() {
		'''
			parent1
				child1
			<|>		grandChild1
		'''.assertLastCompleteNode('''
			[ID:parent1]
			[INDENT:]
			[ID:child1]
		''')
	}
	
	@Test def void testLastCompleteNode_2_1() {
		'''
			parent1
				child1
				<|>	grandChild1
		'''.assertLastCompleteNode('''
			[ID:parent1]
			[INDENT:]
			[ID:child1]
		''')
	}
	
	@Test def void testLastCompleteNode_2_2() {
		'''
			parent1
				child1
					<|>grandChild1
		'''.assertLastCompleteNode('''
			[ID:parent1]
			[INDENT:]
			[ID:child1]
		''')
	}
	
	@Test def void testLastCompleteNode_3_1() {
		'''
			c
				d
				g
				<|>
		'''.assertLastCompleteNode('''
			[ID:c]
			[INDENT:]
			[ID:d]
			[ID:g]
			[DEDENT:]
		''')
	}
	
	@Test def void testLastCompleteNode_3_2() {
		'''
			parent1
				child1
					grandChild1
					<|>grandChild2
		'''.assertLastCompleteNode('''
			[ID:parent1]
			[INDENT:]
			[ID:child1]
			[INDENT:]
			[ID:grandChild1]
		''')
	}
	
	@Test def void testLastCompleteNode_4_2() {
		'''
			parent1
				child1
					grandChild1
					<|>
		'''.assertLastCompleteNode('''
			[ID:parent1]
			[INDENT:]
			[ID:child1]
			[INDENT:]
			[ID:grandChild1]
			[DEDENT:]
			[DEDENT:]
		''')
	}
	
	@Test def void testLastCompleteNode_4_1() {
		'''
			parent1
				child1
					grandChild1
				<|>
		'''.assertLastCompleteNode('''
			[ID:parent1]
			[INDENT:]
			[ID:child1]
			[INDENT:]
			[ID:grandChild1]
			[DEDENT:]
			[DEDENT:]
		''')
	}
	
	@Test def void testLastCompleteNode_4_0() {
		'''
			parent1
				child1
					grandChild1
			<|>
		'''.assertLastCompleteNode('''
			[ID:parent1]
			[INDENT:]
			[ID:child1]
			[INDENT:]
			[ID:grandChild1]
		''')
	}
	
	@Test def void testLastCompleteNode_4_2b() {
		'''
			parent1
				child1
					grandChild1
					<|>
					grandChild2
		'''.assertLastCompleteNode('''
			[ID:parent1]
			[INDENT:]
			[ID:child1]
			[INDENT:]
			[ID:grandChild1]
		''')
	}
	
	@Test def void testLastCompleteNode_4_1b() {
		'''
			parent1
				child1
					grandChild1
				<|>
					grandChild2
		'''.assertLastCompleteNode('''
			[ID:parent1]
			[INDENT:]
			[ID:child1]
			[INDENT:]
			[ID:grandChild1]
		''')
	}
	
	@Test def void testLastCompleteNode_4_0b() {
		'''
			parent1
				child1
					grandChild1
			<|>
					grandChild2
		'''.assertLastCompleteNode('''
			[ID:parent1]
			[INDENT:]
			[ID:child1]
			[INDENT:]
			[ID:grandChild1]
		''')
	}
	
	@Test def void testLastCompleteNode_4_2c() {
		'''
			parent1
				child1
					grandChild1
					<|>
				child2
		'''.assertLastCompleteNode('''
			[ID:parent1]
			[INDENT:]
			[ID:child1]
			[INDENT:]
			[ID:grandChild1]
			[DEDENT:]
		''')
	}
	
	@Test def void testLastCompleteNode_4_1c() {
		'''
			parent1
				child1
					grandChild1
				<|>
				child2
		'''.assertLastCompleteNode('''
			[ID:parent1]
			[INDENT:]
			[ID:child1]
			[INDENT:]
			[ID:grandChild1]
			[DEDENT:]
		''')
	}
	
	@Test def void testLastCompleteNode_4_0c() {
		'''
			parent1
				child1
					grandChild1
			<|>
				child2
		'''.assertLastCompleteNode('''
			[ID:parent1]
			[INDENT:]
			[ID:child1]
			[INDENT:]
			[ID:grandChild1]
		''')
	}
	
	@Test def void testLastCompleteNode_4_2d() {
		'''
			parent1
				child1
					grandChild1
					<|>
			parent2
		'''.assertLastCompleteNode('''
			[ID:parent1]
			[INDENT:]
			[ID:child1]
			[INDENT:]
			[ID:grandChild1]
			[DEDENT:]
			[DEDENT:]
		''')
	}
	
	@Test def void testLastCompleteNode_4_1d() {
		'''
			parent1
				child1
					grandChild1
				<|>
			parent2
		'''.assertLastCompleteNode('''
			[ID:parent1]
			[INDENT:]
			[ID:child1]
			[INDENT:]
			[ID:grandChild1]
			[DEDENT:]
			[DEDENT:]
		''')
	}
	
	@Test def void testLastCompleteNode_4_0d() {
		'''
			parent1
				child1
					grandChild1
			<|>
			parent2
		'''.assertLastCompleteNode('''
			[ID:parent1]
			[INDENT:]
			[ID:child1]
			[INDENT:]
			[ID:grandChild1]
		''')
	}
	
	@Test def void testLastCompleteNode_6_0() {
		'''
			a
			b
				c
					d
						e
			<|>
		'''.assertLastCompleteNode('''
			[ID:a]
			[ID:b]
			[INDENT:]
			[ID:c]
			[INDENT:]
			[ID:d]
			[INDENT:]
			[ID:e]
		''')
	}
	
	@Test def void testLastCompleteNode_6_0b() {
		'''
			a
			b
				c
					d
						e
			<|>
				f
		'''.assertLastCompleteNode('''
			[ID:a]
			[ID:b]
			[INDENT:]
			[ID:c]
			[INDENT:]
			[ID:d]
			[INDENT:]
			[ID:e]
		''')
	}
	
	@Test def void testLastCompleteNode_6_1b() {
		'''
			a
			b
				c
					d
						e
				<|>
				f
		'''.assertLastCompleteNode('''
			[ID:a]
			[ID:b]
			[INDENT:]
			[ID:c]
			[INDENT:]
			[ID:d]
			[INDENT:]
			[ID:e]
			[DEDENT:]
			[DEDENT:]
		''')
	}
	
	@Test def void testLastCompleteNode_5_1() {
		'''
			a
				b
					c
						d
				<|>
						e
		'''.assertLastCompleteNode('''
			[ID:a]
			[INDENT:]
			[ID:b]
			[INDENT:]
			[ID:c]
			[INDENT:]
			[ID:d]
		''')
	}
	
	@Test def void testLastCompleteNode_6_3() {
		'''
			a
			b
			c
				d
					e
				g <|>
		'''.assertLastCompleteNode('''
			[ID:a]
			[ID:b]
			[ID:c]
			[INDENT:]
			[ID:d]
			[INDENT:]
			[ID:e]
			[DEDENT:]
			[ID:g]
		''')
	}
	
	@Test def void testLastCompleteNode_6_3b() {
		'''
			a
			b
			c
				d
					e
				g <|>'''.assertLastCompleteNode('''
			[ID:a]
			[ID:b]
			[ID:c]
			[INDENT:]
			[ID:d]
			[INDENT:]
			[ID:e]
			[DEDENT:]
			[ID:g]
		''')
	}
	
	@Test def void testLastCompleteNode_6_3c() {
		'''
			a
			b
			c
				d
					e
				g <|> '''.assertLastCompleteNode('''
			[ID:a]
			[ID:b]
			[ID:c]
			[INDENT:]
			[ID:d]
			[INDENT:]
			[ID:e]
			[DEDENT:]
			[ID:g]
		''')
	}
	
	@Test def void testLastCompleteNode_6_3d() {
		'''
			a
			b
			c
				d
					e
				g <|> // comment'''.assertLastCompleteNode('''
			[ID:a]
			[ID:b]
			[ID:c]
			[INDENT:]
			[ID:d]
			[INDENT:]
			[ID:e]
			[DEDENT:]
			[ID:g]
		''')
	}
	
	@Test def void testLastCompleteNode_7_0() {
		'''
			a
			b
			c
				d
					e
				g
			<|>
		'''.assertLastCompleteNode('''
			[ID:a]
			[ID:b]
			[ID:c]
			[INDENT:]
			[ID:d]
			[INDENT:]
			[ID:e]
			[DEDENT:]
			[ID:g]
		''')
	}
	
	@Test def void testLastCompleteNode_7_1() {
		'''
			a
			b
			c
				d
					e
				g
				<|>
		'''.assertLastCompleteNode('''
			[ID:a]
			[ID:b]
			[ID:c]
			[INDENT:]
			[ID:d]
			[INDENT:]
			[ID:e]
			[DEDENT:]
			[ID:g]
			[DEDENT:]
		''')
	}
	
	@Test def void testLastCompleteNode_8_1() {
		'''
			a
			b
			c
				d
					e
						f
				g
				<|>
		'''.assertLastCompleteNode('''
			[ID:a]
			[ID:b]
			[ID:c]
			[INDENT:]
			[ID:d]
			[INDENT:]
			[ID:e]
			[INDENT:]
			[ID:f]
			[DEDENT:]
			[DEDENT:]
			[ID:g]
			[DEDENT:]
		''')
	}
	
	@Test def void testLastCompleteNode_8_2() {
		'''
			a
			b
				c
					d
						e
							f
					g
					<|>
		'''.assertLastCompleteNode('''
			[ID:a]
			[ID:b]
			[INDENT:]
			[ID:c]
			[INDENT:]
			[ID:d]
			[INDENT:]
			[ID:e]
			[INDENT:]
			[ID:f]
			[DEDENT:]
			[DEDENT:]
			[ID:g]
			[DEDENT:]
			[DEDENT:]
		''')
	}
	
	@Test def void testLastCompleteNode_8_2b() {
		'''
			a
			b
				c
					d
						e
							f
					g
					<|>
					h
		'''.assertLastCompleteNode('''
			[ID:a]
			[ID:b]
			[INDENT:]
			[ID:c]
			[INDENT:]
			[ID:d]
			[INDENT:]
			[ID:e]
			[INDENT:]
			[ID:f]
			[DEDENT:]
			[DEDENT:]
			[ID:g]
		''')
	}
	
	@Test def void testLastCompleteNode_8_2c() {
		'''
			a
			b
				c
					d
						e
							f
					g
					<|>
				h
		'''.assertLastCompleteNode('''
			[ID:a]
			[ID:b]
			[INDENT:]
			[ID:c]
			[INDENT:]
			[ID:d]
			[INDENT:]
			[ID:e]
			[INDENT:]
			[ID:f]
			[DEDENT:]
			[DEDENT:]
			[ID:g]
			[DEDENT:]
		''')
	}
	
	@Test def void testLastCompleteNode_8_3() {
		'''
			a
			b
				c
					d
						e
							f
					g
						<|>
		'''.assertLastCompleteNode('''
			[ID:a]
			[ID:b]
			[INDENT:]
			[ID:c]
			[INDENT:]
			[ID:d]
			[INDENT:]
			[ID:e]
			[INDENT:]
			[ID:f]
			[DEDENT:]
			[DEDENT:]
			[ID:g]
			[DEDENT:]
			[DEDENT:]
		''')
	}
	
	@Test def void testLastCompleteNode_8_3b() {
		'''
			a
			b
				c
					d
						e
							f
					g
						<|>
					h
		'''.assertLastCompleteNode('''
			[ID:a]
			[ID:b]
			[INDENT:]
			[ID:c]
			[INDENT:]
			[ID:d]
			[INDENT:]
			[ID:e]
			[INDENT:]
			[ID:f]
			[DEDENT:]
			[DEDENT:]
			[ID:g]
		''')
	}
	
	@Test def void testLastCompleteNode_8_3c() {
		'''
			a
			b
				c
					d
						e
							f
					g
						<|>
				h
		'''.assertLastCompleteNode('''
			[ID:a]
			[ID:b]
			[INDENT:]
			[ID:c]
			[INDENT:]
			[ID:d]
			[INDENT:]
			[ID:e]
			[INDENT:]
			[ID:f]
			[DEDENT:]
			[DEDENT:]
			[ID:g]
			[DEDENT:]
		''')
	}
	
	@Test def void testLastCompleteNode_8_4() {
		'''
			a
			b
				c
					d
						e
							f
					g
							<|>
		'''.assertLastCompleteNode('''
			[ID:a]
			[ID:b]
			[INDENT:]
			[ID:c]
			[INDENT:]
			[ID:d]
			[INDENT:]
			[ID:e]
			[INDENT:]
			[ID:f]
			[DEDENT:]
			[DEDENT:]
			[ID:g]
			[DEDENT:]
			[DEDENT:]
		''')
	}
	
	@Test def void testLastCompleteNode_8_4b() {
		'''
			a
			b
				c
					d
						e
							f
					g
							<|>
					h
		'''.assertLastCompleteNode('''
			[ID:a]
			[ID:b]
			[INDENT:]
			[ID:c]
			[INDENT:]
			[ID:d]
			[INDENT:]
			[ID:e]
			[INDENT:]
			[ID:f]
			[DEDENT:]
			[DEDENT:]
			[ID:g]
		''')
	}
	
	@Test def void testLastCompleteNode_8_4c() {
		'''
			a
			b
				c
					d
						e
							f
					g
							<|>
				h
		'''.assertLastCompleteNode('''
			[ID:a]
			[ID:b]
			[INDENT:]
			[ID:c]
			[INDENT:]
			[ID:d]
			[INDENT:]
			[ID:e]
			[INDENT:]
			[ID:f]
			[DEDENT:]
			[DEDENT:]
			[ID:g]
			[DEDENT:]
		''')
	}
	
	protected def void assertLastCompleteNode(CharSequence model, String expectation) {
		val modelAsString = model.toString.replaceAll("\r\n","\n")
		modelAsString.assertLastCompleteNode(expectation);
		val withStringLiterals = modelAsString.replaceAll("(\\w+(<\\|>\\w+)?)", "\"$1\"")
		val expectationWithLiterals = expectation.replaceAll("ID:(\\w+)", "STRING:\"$1\"");
		withStringLiterals.assertLastCompleteNode(expectationWithLiterals);
	}
	
	private def void assertLastCompleteNode(String model, String expectation) {
		var offset = model.indexOf('<|>')
		if (offset === -1) {
			offset = model.length
			
		}
		var completionOffset = model.indexOf('<|>', offset);
		if (completionOffset === -1) {
			completionOffset = offset;
		}
		val tree = parseHelper.parse(model.replace('<|>', ''))
		val nodeModel = NodeModelUtils.findActualNodeFor(tree)
		val completeNode = testee.getLastCompleteNodeByOffset(nodeModel, offset, completionOffset)
		assertNodeModel(expectation, completeNode);
	}
	
	def private void assertNodeModel(String expectation, INode node) {
		assertEquals(expectation, node.rootNode.asText(node))
	}
	
	private def String asText(INode node, INode stop) '''
		«FOR leaf : node.leafNodes.filter[!(grammarElement instanceof Action)].filter[!isHidden].upTo(stop)»
			[«leaf.grammarElement.tokenType»:«leaf.text.replace('\t', '\\t')»]
		«ENDFOR»
	'''
	
	private def <T> upTo(Iterable<T> iter, Object element) {
		return iter.filter(new Functions.Function1<T, Boolean>() {
			var found = false;
			override apply(T t) {
				if (found) return false;
				try {
					return true;
				} finally {
					found = t == element; 
				}
			}
		})
	}
	
	private def String tokenType(EObject obj) {
		switch(obj) {
			RuleCall: obj.rule.name
			Keyword: obj.value
			AbstractRule: obj.name
		}
	}
}