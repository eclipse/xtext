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
		''.assertContentAssistResult(0, '''
			ContentAssistResult [
			  stateId = "-80000000"
			  entries = ArrayList (
			    Entry [
			      prefix = ""
			      proposal = "state"
			      textReplacements = ArrayList ()
			      editPositions = ArrayList ()
			    ]
			  )
			]''')
	}
	
	@Test def testKeywordWithPrefix() {
		'sta'.assertContentAssistResult(3, '''
			ContentAssistResult [
			  stateId = "-80000000"
			  entries = ArrayList (
			    Entry [
			      prefix = "sta"
			      proposal = "state"
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
