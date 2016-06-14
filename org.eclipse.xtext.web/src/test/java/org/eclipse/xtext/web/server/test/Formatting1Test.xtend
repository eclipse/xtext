/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.test

import org.eclipse.xtext.web.example.statemachine.StatemachineRuntimeModule
import org.eclipse.xtext.web.server.formatting.FormattingResult
import org.eclipse.xtext.web.server.test.languages.formatting.StatemachineFormatter
import org.junit.Test

class Formatting1Test extends AbstractWebServerTest {
	
	override protected getRuntimeModule() {
		new StatemachineRuntimeModule {
			override bindIFormatter2() {
				null
			}
			override bindIFormatter() {
				StatemachineFormatter
			}
		}
	}
	
	@Test def testFormatFile() {
		val file = createFile('/* bla */ output signal x state foo set x = true end')
		val format = getService(#{'serviceType' -> 'format', 'resource' -> file.name})
		assertTrue(format.hasSideEffects)
		val result = format.service.apply() as FormattingResult
		val String expectedResult = '''
			FormattingResult [
			  stateId = "-7fffffff"
			  formattedText = "output signal x\nstate foo\n	set x = true\nend"
			  replaceRegion = [10:42]
			]'''
		assertEquals(expectedResult, result.toString)
	}
	
	@Test def testFormatSelection() {
		val file = createFile('/* bla */ output signal x state foo set x = true end')
		val format = getService(#{
				'serviceType' -> 'format',
				'selectionStart' -> '26',
				'selectionEnd' -> '52',
				'resource' -> file.name
			})
		assertTrue(format.hasSideEffects)
		val result = format.service.apply() as FormattingResult
		val String expectedResult = '''
			FormattingResult [
			  stateId = "-7fffffff"
			  formattedText = "state foo\n	set x = true\nend"
			  replaceRegion = [26:26]
			]'''
		assertEquals(expectedResult, result.toString)
	}
	
}
