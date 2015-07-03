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
		val file = createFile('output signal x state foo set x = true end')
		val format = getService(#{'requestType' -> 'format', 'resource' -> file.name})
		assertFalse(format.hasSideEffects)
		assertFalse(format.hasTextInput)
		val result = format.service.apply() as FormattingResult
		val String expectedResult = '''
			FormattingResult [
			  stateId = "-7fffffff"
			  formattedText = "output signal x\nstate foo\n	set x = true\nend"
			  replaceRegion = null
			]'''
		assertEquals(expectedResult, result.toString)
	}
	
	@Test def testFormatSelection() {
		val file = createFile('output signal x state foo set x = true end')
		val format = getService(#{
				'requestType' -> 'format',
				'selectionStart' -> '16',
				'selectionEnd' -> '42',
				'resource' -> file.name
			})
		assertFalse(format.hasSideEffects)
		assertFalse(format.hasTextInput)
		val result = format.service.apply() as FormattingResult
		val String expectedResult = '''
			FormattingResult [
			  stateId = "-7fffffff"
			  formattedText = "state foo\n	set x = true\nend"
			  replaceRegion = [16:26]
			]'''
		assertEquals(expectedResult, result.toString)
	}
	
}
