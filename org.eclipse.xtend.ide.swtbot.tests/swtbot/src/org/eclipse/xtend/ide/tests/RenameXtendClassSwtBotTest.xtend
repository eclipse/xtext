/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests

import java.util.Collection
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized.Parameters

import static extension org.eclipse.xtend.ide.tests.SwtBotProjectHelper.*

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@RunWith(ParameterizedSWTBotRunner)
class RenameXtendClassSwtBotTest extends AbstractRefactoringSwtBotTest {
	
	@Parameters(name="{0}")
	def static Collection<Object[]> data() {
		#[ 
			#[ new RefactoringTestParameters => [
				useInlineRefactoring = true
		  		usePreview = false
			]], 
			#[ new RefactoringTestParameters => [
				useInlineRefactoring = false
		  		usePreview = false
		  	]],
		  	#[ new RefactoringTestParameters => [
				useInlineRefactoring = true
		  		usePreview = true
			]], 
			#[ new RefactoringTestParameters => [
				useInlineRefactoring = false
		  		usePreview = true
		  	]]
	  	]
	}

	new(RefactoringTestParameters testParams) {
		super(testParams)
	}

	@Test 
	def void renameXtendClass() {
		val fooEditor = bot.newXtendEditor('Foo', '''
			class Foo extends Bar {
			}
		''')
		val barEditor = bot.newXtendEditor('Bar', '''
			class ?Bar? {}
		''')
		barEditor.renameInXtendEditor('NewBar', 'Rename Element')
		assertEquals('''
			class Foo extends NewBar {
			}
		''', fooEditor.text)
		assertEquals('''
			class NewBar {}
		''', barEditor.text)
		assertEquals('NewBar.xtend', barEditor.title)
	}
	
	@Test
	def void renameXtendClassReference() {
		val barEditor = bot.newXtendEditor('Bar', '''
			class Bar {}
		''')
		val fooEditor = bot.newXtendEditor('Foo', '''
			class Foo extends ?Bar? {
			}
		''')
		fooEditor.renameInXtendEditor('NewBar', 'Rename Element')
		assertEquals('''
			class Foo extends NewBar {
			}
		''', fooEditor.text)
		assertEquals('''
			class NewBar {}
		''', barEditor.text)
		assertEquals('NewBar.xtend', barEditor.title)		
	}
	
	@Test 
	def void renameXtendClassWithAA() {
		val barEditor = bot.newXtendEditor('Fonk', '''
			import org.eclipse.xtend.lib.annotations.Data
			@Data
			class ?Fonk? {}
		''')
		barEditor.renameInXtendEditor('NewFonk', 'Rename Element')
		assertEquals('''
			import org.eclipse.xtend.lib.annotations.Data
			@Data
			class NewFonk {}
		''', barEditor.text)
		assertEquals('NewFonk.xtend', barEditor.title)
	}
}