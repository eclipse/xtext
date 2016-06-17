/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer

import com.google.inject.Inject
import org.eclipse.xtext.serializer.hiddentokensequencertest.HiddentokensequencertestFactory
import org.eclipse.xtext.serializer.hiddentokensequencertest.Model
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

/**
 * @author Stefan Oehme - Initial contribution and API
 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=424027
 */
@RunWith(XtextRunner)
@InjectWith(HiddenTokenSequencerTestLanguageInjectorProvider)
class SerializationAfterModelChangeTest {
	@Inject extension ParseHelper<Model>
	@Inject extension ISerializer

	@Test
	def void smokeTest() {
		val model = '''
			entities
				//before existing element
				Foo /* within existing element */ "Bar" /* after existing element*/
				
				//unrelated comment
				
				//before deleted element
				Baz "Fizzle" /* after deleted element */
				
				//between deleted elements
				
				//another deleted element
				Blurb /* a comment within a deleted element */ "Bla"
				
				//before inserted element
			end
		'''.parse

		val event = HiddentokensequencertestFactory.eINSTANCE.createEntity => [
			name = "AAA"
			description = "BBB"
		]
		model.domainModel.entities.remove(1)
		model.domainModel.entities.remove(1)
		model.domainModel.entities.add(event)

		model.assertSerializesTo(
			'''
			entities
				//before existing element
				Foo /* within existing element */ "Bar" /* after existing element*/
				
				//unrelated comment
				
				
				
				//between deleted elements
				
				
				
				//before inserted element
			AAA "BBB" end''')
	}

	/*
	 * TODO does not work yet, because HiddenTokenSequencer 
	 * always searches in one direction, 
	 * but the order of the elements has changed here.
	*/
	@Test
	@Ignore
	def void testMoveElement() {
		val model = '''
			entities
				Foo "Bar"
			
				//comment between elements
				
				Baz "Fizzle"
			end
		'''.parse

		val head = model.domainModel.entities.head

		model.domainModel.entities.move(1, head)

		model.assertSerializesTo(
			'''
				entities
					Baz "Fizzle"
				
					//comment between elements
					
					Foo "Bar"
				end
			''')
	}

	@Test
	def void testWhiteSpaceOnly() {
		val model = '''
			entities
				Foo "Bar"
			end
		'''.parse

		val event = HiddentokensequencertestFactory.eINSTANCE.createEntity => [
			name = "Baz"
			description = "Fizzle"
		]
		model.domainModel.entities.add(event)

		model.assertSerializesTo(
			'''
			entities
				Foo "Bar"
			Baz "Fizzle" end''')
	}

	@Test
	def void testCommentBeforeInsertedElement() {
		val model = '''
			entities
				Foo "Bar"
				
				//comment before inserted element
			end
		'''.parse

		val event = HiddentokensequencertestFactory.eINSTANCE.createEntity => [
			name = "Baz"
			description = "Fizzle"
		]
		model.domainModel.entities.add(event)

		model.assertSerializesTo(
			'''
			entities
				Foo "Bar"
				
				//comment before inserted element
			Baz "Fizzle" end''')
	}

	@Test
	def void testAddElementAfterInlineComment() {
		val model = '''
			entities
				Foo "Bar"	//inline comment before inserted element
			end
		'''.parse

		val event = HiddentokensequencertestFactory.eINSTANCE.createEntity => [
			name = "Baz"
			description = "Fizzle"
		]
		model.domainModel.entities.add(event)

		model.assertSerializesTo(
			'''
			entities
				Foo "Bar"	//inline comment before inserted element
			Baz "Fizzle" end''')
	}

	@Test
	def void testCommentOnRemovedElement() {
		val model = '''
			entities
				Foo "Bar" //inline comment before deleted element
				//comment on deleted element
				/**
				 * another comment on the deleted element
				 */
				Baz "Fizzle"
			end
		'''.parse

		model.domainModel.entities.remove(1)

		model.assertSerializesTo(
			'''
			entities
				Foo "Bar" //inline comment before deleted element
			
			end''')
	}

	@Test
	def void testUnrelatedCommentBeforeRemovedElement() {
		val model = '''
			entities
				Foo "Bar"
				
				//unrelated comment before deleted element
				
				Baz "Fizzle"
			end
		'''.parse

		model.domainModel.entities.remove(1)

		model.assertSerializesTo(
			'''
			entities
				Foo "Bar"
				
				//unrelated comment before deleted element
				
				
			end''')
	}

	@Test
	def void testRemoveElementAfterInlineComment() {
		val model = '''
			entities
				Foo "Bar" //inline comment before deleted element
				
				Baz "Fizzle"
			end
		'''.parse

		model.domainModel.entities.remove(1)

		model.assertSerializesTo(
			'''
			entities
				Foo "Bar" //inline comment before deleted element
				
				
			end''')

	}

	@Test
	def void testRemoveElementWithInlineComment() {
		val model = '''
			entities
				Foo "Bar"
				
				Baz "Fizzle" //inline comment after deleted element
			end
		'''.parse
		model.domainModel.entities.remove(1)

		model.assertSerializesTo(
			'''
			entities
				Foo "Bar"
				
				end''')
	}

	@Test
	def void testRemoveElementInSameLine() {
		val model = '''
			entities
				Foo "Bar" /* the foo */ Baz "Fizzle"
			end
		'''.parse
		model.domainModel.entities.remove(1)

		model.assertSerializesTo(
			'''
			entities
				Foo "Bar" /* the foo */
			end''')
	}

	@Test
	def void testAddElementBeforeCommentedElement() {
		val model = '''
			entities
				//the comment
				Foo "Bar"
			end
		'''.parse

		val event = HiddentokensequencertestFactory.eINSTANCE.createEntity => [
			name = "Baz"
			description = "Fizzle"
		]
		model.domainModel.entities.add(0, event)

		model.assertSerializesTo(
			'''
				entities Baz "Fizzle"
					//the comment
					Foo "Bar"
				end
			''')
	}

	private def assertSerializesTo(Model model, CharSequence expectation) {
		assertEquals(expectation.toString, model.serialize)
	}
}
