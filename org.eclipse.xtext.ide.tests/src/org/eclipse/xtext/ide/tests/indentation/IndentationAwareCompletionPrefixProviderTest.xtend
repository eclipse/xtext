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
import org.eclipse.xtext.ide.editor.contentassist.IndentationAwareCompletionPrefixProvider
import org.eclipse.xtext.ide.tests.testlanguage.tests.IndentationAwareUiTestLanguageInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(IndentationAwareUiTestLanguageInjectorProvider)
class IndentationAwareCompletionPrefixProviderTest extends AbstractCompletePrefixProviderTest {
	
	@Inject IndentationAwareCompletionPrefixProvider testee
	
	override getTestee() {
		return testee
	}
	
	@Test override void testInputToParse_02() {
		assertEquals("abc  ", testee.getInputToParse("abc   defg", 3, 5))
	}
	
	@Test override void testLastCompleteNode_1_1() {
		'''
			parent1
				<|>child1
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
		''')
	}
	
	@Test override void testLastCompleteNode_2_2() {
		'''
			parent1
				child1
					<|>grandChild1
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
		''')
	}
	
	@Test override void testLastCompleteNode_3_1() {
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
		''')
	}
	
	@Test override void testLastCompleteNode_4_2() {
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
	
	@Test override void testLastCompleteNode_4_1() {
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
		''')
	}
	
	@Test override void testLastCompleteNode_4_1b() {
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
			[ID:grandChild2]
			[DEDENT:]
		''')
	}
	
	@Test override void testLastCompleteNode_4_0() {
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
	
	@Test override void testLastCompleteNode_4_0c() {
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
	
	@Test override void testLastCompleteNode_4_0d() {
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
	
	@Test override void testLastCompleteNode_4_1d() {
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
		''')
	}
	
	@Test override void testLastCompleteNode_4_2c() {
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
	
	@Test override void testLastCompleteNode_4_2d() {
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
	
	@Test override void testLastCompleteNode_6_0() {
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
			[DEDENT:]
			[DEDENT:]
			[DEDENT:]
		''')
	}
	
	@Test override void testLastCompleteNode_6_0b() {
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
	
	@Test override void testLastCompleteNode_5_1() {
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
			[ID:e]
			[DEDENT:]
			[DEDENT:]
		''')
	}
	
	@Test override void testLastCompleteNode_7_0() {
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
	
	@Test override void testLastCompleteNode_7_1() {
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
	
	@Test override void testLastCompleteNode_8_1() {
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
		''')
	}
	
	@Test override void testLastCompleteNode_8_2() {
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
		''')
	}
	
	@Test override void testLastCompleteNode_8_2b() {
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
	
	@Test override void testLastCompleteNode_8_2c() {
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
	
	@Test override void testLastCompleteNode_8_3() {
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
		''')
	}
	
	@Test override void testLastCompleteNode_8_3b() {
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
	
	@Test override void testLastCompleteNode_8_3c() {
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
	
	@Test override void testLastCompleteNode_8_4() {
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
		''')
	}
	
	@Test override void testLastCompleteNode_8_4b() {
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
	
	@Test override void testLastCompleteNode_8_4c() {
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
	
}
