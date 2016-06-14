/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.test

import org.eclipse.xtext.web.server.formatting.FormattingResult
import org.junit.Test

class Formatting2Test extends AbstractWebServerTest {
	
	@Test def testFormatFile() {
		val file = createFile('/* bla */ output signal x state foo set x = true end')
		val format = getService(#{'serviceType' -> 'format', 'resource' -> file.name})
		assertTrue(format.hasSideEffects)
		val result = format.service.apply() as FormattingResult
		val String expectedResult = '''
			FormattingResult [
			  stateId = "-7fffffff"
			  formattedText = "/* bla */ output signal x\nstate foo\n	set x = true\nend\n"
			]'''
		assertEquals(expectedResult, result.toString)
	}
	
	@Test def testFormatSelection() {
		val file = createFile('/* bla */ output signal x state foo set x = true end ')
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
