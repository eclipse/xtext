/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.test

import org.eclipse.xtext.web.server.ServiceConflictResult
import org.eclipse.xtext.web.server.validation.ValidationResult
import org.junit.Test

import static org.hamcrest.core.IsInstanceOf.*

class ValidationTest extends AbstractWebServerTest {
	
	protected def assertValidationResult(String resourceContent, String expectedResult) {
		val sessionStore = new HashMapSessionStore
		val validate = dispatcher.getService('/validation', #{'fullText' -> resourceContent}, sessionStore)
		assertFalse(validate.hasSideEffects)
		assertTrue(validate.hasTextInput)
		val result = validate.service.apply() as ValidationResult
		assertEquals(expectedResult, result.toString)
	}
	
	@Test def testSyntaxError() {
		'stat foo end'.assertValidationResult('''
			ValidationResult [
			  entries = ArrayList (
			    Entry [
			      description = "missing EOF at 'stat'"
			      severity = "error"
			      line = 1
			      startOffset = 0
			      endOffset = 4
			    ]
			  )
			]''')
	}
	
	@Test def testCrossRefError() {
		'state foo set x = true end'.assertValidationResult('''
			ValidationResult [
			  entries = ArrayList (
			    Entry [
			      description = "Couldn't resolve reference to Signal 'x'."
			      severity = "error"
			      line = 1
			      startOffset = 14
			      endOffset = 15
			    ]
			  )
			]''')
	}
	
	@Test def testCustomValidationError() {
		'input signal x state foo set x = true end'.assertValidationResult('''
			ValidationResult [
			  entries = ArrayList (
			    Entry [
			      description = "Only output signals are allowed for write access."
			      severity = "error"
			      line = 1
			      startOffset = 29
			      endOffset = 30
			    ]
			  )
			]''')
	}
	
	@Test def testValidateFile() {
		val file = createFile('stat foo end')
		val sessionStore = new HashMapSessionStore
		val validate = dispatcher.getService('/validation', #{'resource' -> file.name}, sessionStore)
		assertFalse(validate.hasSideEffects)
		assertFalse(validate.hasTextInput)
		val result = validate.service.apply() as ValidationResult
		val String expectedResult = '''
			ValidationResult [
			  entries = ArrayList (
			    Entry [
			      description = "missing EOF at 'stat'"
			      severity = "error"
			      line = 1
			      startOffset = 0
			      endOffset = 4
			    ]
			  )
			]'''
		assertEquals(expectedResult, result.toString)
	}
	
	@Test def testIncorrectStateId() {
		val file = createFile('state foo end')
		val sessionStore = new HashMapSessionStore
		val validate = dispatcher.getService('/validation', #{
				'resource' -> file.name,
				'requiredStateId' -> 'totalerquatsch'
			}, sessionStore)
		assertTrue(validate.hasConflict)
		val result = validate.service.apply()
		assertThat(result, instanceOf(ServiceConflictResult))
		assertEquals((result as ServiceConflictResult).conflict, 'invalidStateId')
	}
	
}
