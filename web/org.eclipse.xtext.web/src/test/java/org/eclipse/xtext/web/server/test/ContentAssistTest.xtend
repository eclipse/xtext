/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.test

import org.eclipse.xtext.web.server.ServiceConflictResult
import org.eclipse.xtext.web.server.contentassist.ContentAssistResult
import org.junit.Test

import static org.hamcrest.core.IsInstanceOf.*

class ContentAssistTest extends AbstractWebServerTest {
	
	protected def assertContentAssistResult(CharSequence resourceContent, CharSequence expectedResult) {
		var contentString = resourceContent.toString
		val cursorOffset = contentString.indexOf('|')
		if (cursorOffset >= 0) {
			contentString = contentString.substring(0, cursorOffset) + contentString.substring(cursorOffset + 1)
			assertContentAssistResult(contentString, cursorOffset, expectedResult)
		} else
			assertContentAssistResult(resourceContent, 0, expectedResult)
	}
	
	protected def assertContentAssistResult(CharSequence resourceContent, int offset, CharSequence expectedResult) {
		val contentAssist = getService(#{
				'serviceType' -> 'assist',
				'fullText' -> resourceContent.toString,
				'caretOffset' -> offset.toString
			})
		assertFalse(contentAssist.hasSideEffects)
		assertTrue(contentAssist.hasTextInput)
		val result = contentAssist.service.apply() as ContentAssistResult
		assertEquals(expectedResult.toString, result.toString)
	}
	
	@Test def testKeywords() {
		''.assertContentAssistResult('''
			ContentAssistResult [
			  stateId = "-80000000"
			  entries = ArrayList (
			    ContentAssistEntry [
			      prefix = ""
			      proposal = "input"
			      escapePosition = 0
			      textReplacements = ArrayList ()
			      editPositions = ArrayList ()
			    ],
			    ContentAssistEntry [
			      prefix = ""
			      proposal = "output"
			      escapePosition = 0
			      textReplacements = ArrayList ()
			      editPositions = ArrayList ()
			    ],
			    ContentAssistEntry [
			      prefix = ""
			      proposal = "state"
			      escapePosition = 0
			      textReplacements = ArrayList ()
			      editPositions = ArrayList ()
			    ]
			  )
			]''')
	}
	
	@Test def testKeywordWithPrefix() {
		'sta|'.assertContentAssistResult('''
			ContentAssistResult [
			  stateId = "-80000000"
			  entries = ArrayList (
			    ContentAssistEntry [
			      prefix = "sta"
			      proposal = "state"
			      escapePosition = 0
			      textReplacements = ArrayList ()
			      editPositions = ArrayList ()
			    ]
			  )
			]''')
	}
	
	@Test def testTerminal() {
		'state | end'.assertContentAssistResult('''
			ContentAssistResult [
			  stateId = "-80000000"
			  entries = ArrayList (
			    ContentAssistEntry [
			      prefix = ""
			      proposal = "name"
			      description = "ID"
			      escapePosition = 0
			      textReplacements = ArrayList ()
			      editPositions = ArrayList (
			        [6:4]
			      )
			    ]
			  )
			]''')
	}
	
	@Test def testCustomTerminal() {
		'output signal x state foo set x = | end'.assertContentAssistResult('''
			ContentAssistResult [
			  stateId = "-80000000"
			  entries = ArrayList (
			    ContentAssistEntry [
			      prefix = ""
			      proposal = "false"
			      escapePosition = 0
			      textReplacements = ArrayList ()
			      editPositions = ArrayList ()
			    ],
			    ContentAssistEntry [
			      prefix = ""
			      proposal = "true"
			      escapePosition = 0
			      textReplacements = ArrayList ()
			      editPositions = ArrayList ()
			    ]
			  )
			]''')
	}
	
	@Test def testCustomCrossref() {
		'input signal x state foo if | == true goto foo end'.assertContentAssistResult('''
			ContentAssistResult [
			  stateId = "-80000000"
			  entries = ArrayList (
			    ContentAssistEntry [
			      prefix = ""
			      proposal = "x"
			      description = "input signal"
			      escapePosition = 0
			      textReplacements = ArrayList ()
			      editPositions = ArrayList ()
			    ]
			  )
			]''')
	}
	
	@Test def testIncorrectStateId() {
		val file = createFile('state foo end')
		val contentAssist = getService(#{
				'serviceType' -> 'assist',
				'resource' -> file.name,
				'caretOffset' -> '3',
				'requiredStateId' -> 'totalerquatsch'
			})
		assertTrue(contentAssist.hasConflict)
		val result = contentAssist.service.apply()
		assertThat(result, instanceOf(ServiceConflictResult))
		assertEquals((result as ServiceConflictResult).conflict, 'invalidStateId')
	}
	
}
