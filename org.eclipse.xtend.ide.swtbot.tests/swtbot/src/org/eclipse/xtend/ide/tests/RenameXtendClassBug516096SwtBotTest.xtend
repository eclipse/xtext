/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
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
 * @author Christian Dietrich - Initial contribution and API
 */
 @RunWith(ParameterizedSWTBotRunner)
class RenameXtendClassBug516096SwtBotTest extends AbstractRefactoringSwtBotTest {
	
	@Parameters(name="{0}")
	def static Collection<Object[]> data() {
		#[ 
			#[ new RefactoringTestParameters => [
				useInlineRefactoring = false
		  		usePreview = false
			]]
	  	]
	}
	
	new(RefactoringTestParameters testParams) {
		super(testParams)
	}
	
	@Test
	def void testBug516096() {
		val projectName = 'this is a test'
		bot.newXtendProject(projectName)
		val fooEditor = bot.newXtendEditor('Foo', '', projectName + '/src') => [
			it.content = '''
			class ?Foo? {}
			'''
		]
		fooEditor.renameInXtendEditor('Bar', 'Rename Element')
		assertEquals('''
			class Bar {}
		''', fooEditor.text)
		assertEquals('Bar.xtend', fooEditor.title)
	}
	
}