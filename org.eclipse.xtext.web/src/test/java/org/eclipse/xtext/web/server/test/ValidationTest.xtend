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
import static org.junit.Assert.*

class ValidationTest extends AbstractWebServerTest {
	
	protected def assertValidationResult(String resourceContent, String expectedResult) {
		val validate = getService(#{'serviceType' -> 'validate', 'fullText' -> resourceContent})
		assertFalse(validate.hasSideEffects)
		val result = validate.service.apply() as ValidationResult
		assertEquals(expectedResult, result.toString)
	}
	
	@Test def testSyntaxError() {
		'stat foo end'.assertValidationResult('''
			ValidationResult [
			  issues = ArrayList (
			    Issue [
			      description = "missing EOF at 'stat'"
			      severity = "error"
			      line = 1
			      column = 1
			      offset = 0
			      length = 4
			    ]
			  )
			]''')
	}
	
	@Test def testCrossRefError() {
		'state foo set x = true end'.assertValidationResult('''
			ValidationResult [
			  issues = ArrayList (
			    Issue [
			      description = "Couldn't resolve reference to Signal 'x'."
			      severity = "error"
			      line = 1
			      column = 15
			      offset = 14
			      length = 1
			    ]
			  )
			]''')
	}
	
	@Test def testCustomValidationError() {
		'input signal x state foo set x = true end'.assertValidationResult('''
			ValidationResult [
			  issues = ArrayList (
			    Issue [
			      description = "Only output signals are allowed for write access."
			      severity = "error"
			      line = 1
			      column = 30
			      offset = 29
			      length = 1
			    ]
			  )
			]''')
	}
	
	@Test def testValidateFile() {
		val file = createFile('stat foo end')
		val validate = getService(#{'serviceType' -> 'validate', 'resource' -> file.name})
		assertFalse(validate.hasSideEffects)
		val result = validate.service.apply() as ValidationResult
		val String expectedResult = '''
			ValidationResult [
			  issues = ArrayList (
			    Issue [
			      description = "missing EOF at 'stat'"
			      severity = "error"
			      line = 1
			      column = 1
			      offset = 0
			      length = 4
			    ]
			  )
			]'''
		assertEquals(expectedResult, result.toString)
	}
	
	@Test def testIncorrectStateId() {
		val file = createFile('state foo end')
		val validate = getService(#{
				'serviceType' -> 'validate', 
				'resource' -> file.name,
				'requiredStateId' -> 'totalerquatsch'
			})
		assertTrue(validate.hasConflict)
		val result = validate.service.apply()
		assertThat(result, instanceOf(ServiceConflictResult))
		assertEquals((result as ServiceConflictResult).conflict, 'invalidStateId')
	}
	
}
