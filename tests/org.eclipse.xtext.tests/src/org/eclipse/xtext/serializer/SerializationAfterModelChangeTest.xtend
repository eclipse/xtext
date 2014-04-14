/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer

import org.eclipse.xtext.junit4.AbstractXtextTests
import org.eclipse.xtext.testlanguages.FowlerDslTestLanguageStandaloneSetup
import org.junit.Before
import org.junit.Test
import org.eclipse.xtext.testlanguages.fowlerdsl.Statemachine
import org.eclipse.xtext.testlanguages.fowlerdsl.FowlerdslFactory
import org.junit.Ignore

/**
 * @author Stefan Oehme - Initial contribution and API
 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=424027
 */
class SerializationAfterModelChangeTest extends AbstractXtextTests {
	
	@Before
	def void setup() {
		with(FowlerDslTestLanguageStandaloneSetup)
		injectMembers(this)
	}
	
	@Test
	def void smokeTest() {
		val model = getModel('''
			events
				//before existing element
				Foo /* within existing element */ Bar /* after existing element*/
				
				//unrelated comment
				
				//before deleted element
				Baz Fizzle /* after deleted element */
				
				//between deleted elements
				
				//another deleted element
				Blurb /* a comment within a deleted element */ Bla
				
				//before inserted element
			end
			commands
			end
		''') as Statemachine

		val event = FowlerdslFactory.eINSTANCE.createEvent => [
			name = "AAA"
			code = "BBB"
		]
		model.events.remove(1)
		model.events.remove(1)
		model.events.add(event)
		
		model.assertSerializesTo('''
			events
				//before existing element
				Foo /* within existing element */ Bar /* after existing element*/
				
				//unrelated comment
				
				
				
				//between deleted elements
				
				
				
				//before inserted element
			AAA BBB end
			commands
			end
		''')
	}
	
	/*
	 * TODO does not work yet, because HiddenTokenSequencer 
	 * always searches in one direction, 
	 * but the order of the elements has changed here.
	*/
	@Test
	@Ignore
	def void testMoveElement() {
		val model = getModel('''
			events
				Foo Bar
			
				//comment between elements
				
				Baz Fizzle
			end
			commands
			end
		''') as Statemachine
		
		val head = model.events.head
		
		model.events.move(1, head)
		
		model.assertSerializesTo('''
			events
				Baz Fizzle
			
				//comment between elements
				
				Foo Bar
			end
			commands
			end
		''')
	}
	
	@Test
	def void testWhiteSpaceOnly() {
		val model = getModel('''
			events
				Foo Bar
			end
			commands
			end
		''') as Statemachine

		val event = FowlerdslFactory.eINSTANCE.createEvent => [
			name = "Baz"
			code = "Fizzle"
		]
		model.events.add(event)
		
		model.assertSerializesTo('''
			events
				Foo Bar
			Baz Fizzle end
			commands
			end
		''')
	}
	
	@Test
	def void testCommentBeforeInsertedElement() {
		val model = getModel('''
			events
				Foo Bar
				
				//comment before inserted element
			end
			commands
			end
		''') as Statemachine
		
		val event = FowlerdslFactory.eINSTANCE.createEvent => [
			name = "Baz"
			code = "Fizzle"
		]
		model.events.add(event)
		
		model.assertSerializesTo('''
			events
				Foo Bar
				
				//comment before inserted element
			Baz Fizzle end
			commands
			end
		''')
	}
	
	@Test
	def void testAddElementAfterInlineComment() {
		val model = getModel('''
			events
				Foo Bar	//inline comment before inserted element
			end
			commands
			end
		''') as Statemachine
		
		val event = FowlerdslFactory.eINSTANCE.createEvent => [
			name = "Baz"
			code = "Fizzle"
		]
		model.events.add(event)
		
		model.assertSerializesTo('''
			events
				Foo Bar	//inline comment before inserted element
			Baz Fizzle end
			commands
			end
		''')
	}
	
	@Test
	def void testCommentOnRemovedElement() {
		val model = getModel('''
			events
				Foo Bar
			
				//comment on deleted element
				/**
				 * another comment on the deleted element
				 */
				Baz Fizzle
			end
			commands
			end
		''') as Statemachine
		
		model.events.remove(1)
		
		model.assertSerializesTo('''
			events
				Foo Bar
			
				
			end
			commands
			end
		''')
	}
	
	@Test
	def void testUnrelatedCommentBeforeRemovedElement() {
		val model = getModel('''
			events
				Foo Bar
				
				//unrelated comment before deleted element
				
				Baz Fizzle
			end
			commands
			end
		''') as Statemachine
		
		model.events.remove(1)
		
		model.assertSerializesTo('''
			events
				Foo Bar
				
				//unrelated comment before deleted element
				
				
			end
			commands
			end
		''')
	}
	
	@Test
	def void testRemoveElementAfterInlineComment() {
		val model = getModel('''
			events
				Foo Bar //inline comment before deleted element
				
				Baz Fizzle
			end
			commands
			end
		''') as Statemachine
		
		model.events.remove(1)
		
		model.assertSerializesTo('''
			events
				Foo Bar //inline comment before deleted element
				
				
			end
			commands
			end
		''')
		
	}
	
	@Test
	def void testRemoveElementWithInlineComment() {
		val model = getModel('''
			events
				Foo Bar
				
				Baz Fizzle //inline comment after deleted element
			end
			commands
			end
		''') as Statemachine
		model.events.remove(1)
		
		model.assertSerializesTo('''
			events
				Foo Bar
				
				end
			commands
			end
		''')
	}
	
	@Test
	def void testRemoveElementInSameLine() {
		val model = getModel('''
			events
				Foo Bar /* the foo */ Baz Fizzle
			end
			commands
			end
		''') as Statemachine
		model.events.remove(1)
		
		model.assertSerializesTo('''
			events
				Foo Bar /* the foo */
			end
			commands
			end
		''')
	}
	
	@Test
	def void testAddElementBeforeCommentedElement() {
		val model = getModel('''
			events
				//the comment
				Foo Bar
			end
			commands
			end
		''') as Statemachine
		
		val event = FowlerdslFactory.eINSTANCE.createEvent => [
			name = "Baz"
			code = "Fizzle"
		]
		model.events.add(0, event)
		
		model.assertSerializesTo('''
			events Baz Fizzle
				//the comment
				Foo Bar
			end
			commands
			end
		''')
	}
	
	private def assertSerializesTo(Statemachine model, CharSequence expectation) {
		assertEquals(expectation.toString, serialize(model))
	}
}