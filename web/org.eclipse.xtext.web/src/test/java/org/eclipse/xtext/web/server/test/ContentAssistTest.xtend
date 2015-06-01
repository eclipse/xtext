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
	
	protected def assertContentAssistResult(String resourceContent, String expectedResult) {
		val cursorOffset = resourceContent.indexOf('|')
		if (cursorOffset >= 0)
			assertContentAssistResult(resourceContent, cursorOffset, expectedResult)
		else
			assertContentAssistResult(resourceContent, 0, expectedResult)
	}
	
	protected def assertContentAssistResult(String resourceContent, int offset, String expectedResult) {
		val sessionStore = new HashMapSessionStore
		val contentAssist = dispatcher.getService('/content-assist', #{
				'fullText' -> resourceContent,
				'caretOffset' -> offset.toString
			}, sessionStore)
		assertFalse(contentAssist.hasSideEffects)
		assertTrue(contentAssist.hasTextInput)
		val result = contentAssist.service.apply() as ContentAssistResult
		assertEquals(expectedResult, result.toString)
	}
	
	@Test def testKeywords() {
		''.assertContentAssistResult('''
			ContentAssistResult [
			  stateId = "-80000000"
			  entries = ArrayList (
			    Entry [
			      prefix = ""
			      proposal = "input"
			      escapePosition = 0
			      textReplacements = ArrayList ()
			      editPositions = ArrayList ()
			    ],
			    Entry [
			      prefix = ""
			      proposal = "output"
			      escapePosition = 0
			      textReplacements = ArrayList ()
			      editPositions = ArrayList ()
			    ],
			    Entry [
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
			    Entry [
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
			    Entry [
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
			    Entry [
			      prefix = ""
			      proposal = "false"
			      escapePosition = 0
			      textReplacements = ArrayList ()
			      editPositions = ArrayList ()
			    ],
			    Entry [
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
			    Entry [
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
		val sessionStore = new HashMapSessionStore
		val contentAssist = dispatcher.getService('/content-assist', #{
				'resource' -> file.name,
				'caretOffset' -> '3',
				'requiredStateId' -> 'totalerquatsch'
			}, sessionStore)
		assertTrue(contentAssist.hasConflict)
		val result = contentAssist.service.apply()
		assertThat(result, instanceOf(ServiceConflictResult))
		assertEquals((result as ServiceConflictResult).conflict, 'invalidStateId')
	}
	
}
