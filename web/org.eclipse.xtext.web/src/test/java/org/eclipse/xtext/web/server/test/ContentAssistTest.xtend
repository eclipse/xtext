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
		'entity foo {} '.assertContentAssistResult(14, '''
			ContentAssistResult [
			  entries = ArrayList (
			    Entry [
			      prefix = ""
			      proposal = "entity"
			      textReplacements = ArrayList ()
			      editPositions = ArrayList ()
			    ],
			    Entry [
			      prefix = ""
			      proposal = "package"
			      textReplacements = ArrayList ()
			      editPositions = ArrayList ()
			    ]
			  )
			]''')
	}
	
	@Test def testKeywordWithPrefix() {
		'entity foo {}'.assertContentAssistResult(3, '''
			ContentAssistResult [
			  entries = ArrayList (
			    Entry [
			      prefix = "ent"
			      proposal = "entity"
			      textReplacements = ArrayList ()
			      editPositions = ArrayList ()
			    ]
			  )
			]''')
	}
	
	@Test def testIncorrectStateId() {
		val sessionStore = new HashMapSessionStore
		val contentAssist = dispatcher.getService('/content-assist', #{
				'fullText' -> 'entity foo {}',
				'caretOffset' -> '3',
				'requiredStateId' -> 'totalerquatsch'
			}, sessionStore)
		assertTrue(contentAssist.hasConflict)
		val result = contentAssist.service.apply()
		assertThat(result, instanceOf(ServiceConflictResult))
		assertEquals((result as ServiceConflictResult).conflict, 'invalidStateId')
	}
	
}
