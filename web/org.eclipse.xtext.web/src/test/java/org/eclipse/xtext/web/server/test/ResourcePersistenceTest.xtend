/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.test

import com.google.common.base.Charsets
import com.google.common.io.Files
import org.eclipse.xtext.web.server.persistence.ResourceContentResult
import org.junit.Test

class ResourcePersistenceTest extends AbstractWebServerTest {
	
	@Test def testLoadFile() {
		val resourceContent = 'entity foo {}'
		val file = createFile(resourceContent)
		
		val sessionStore = new HashMapSessionStore
		val load = dispatcher.getService('/load', #{'resource' -> file.name}, sessionStore)
		assertFalse(load.hasSideEffects)
		assertFalse(load.hasTextInput)
		
		val result = load.service.apply() as ResourceContentResult
		assertEquals(resourceContent, result.fullText)
		assertFalse(result.dirty)
	}
	
	@Test def testLoadDummy() {
		val sessionStore = new HashMapSessionStore
		val resourceContent = 'entity foo {}'
		var update = dispatcher.getService('/update', #{'resource' -> 'dummy.entities', 'fullText' -> resourceContent}, sessionStore)
		update.service.apply()
		var load = dispatcher.getService('/load', #{'resource' -> 'dummy.entities'}, sessionStore)
		var result = load.service.apply() as ResourceContentResult
		assertEquals(resourceContent, result.fullText)
		
		update = dispatcher.getService('/update', #{
				'resource' -> 'dummy.entities',
				'deltaText' -> 'bar',
				'deltaOffset' -> '7',
				'deltaReplaceLength' -> '3'
			}, sessionStore)
		update.service.apply()
		load = dispatcher.getService('/load', #{'resource' -> 'dummy.entities'}, sessionStore)
		result = load.service.apply() as ResourceContentResult
		assertEquals('entity bar {}', result.fullText)
	}
	
	@Test def testRevertFile() {
		val resourceContent = 'entity foo {}'
		val file = createFile(resourceContent)
		
		val sessionStore = new HashMapSessionStore
		val load = dispatcher.getService('/load', #{'resource' -> file.name}, sessionStore)
		load.service.apply()
		val update = dispatcher.getService('/update', #{
				'resource' -> file.name,
				'deltaText' -> 'bar',
				'deltaOffset' -> '7',
				'deltaReplaceLength' -> '3'
			}, sessionStore)
		update.service.apply()
		
		val revert = dispatcher.getService('/revert', #{'resource' -> file.name}, sessionStore)
		assertTrue(revert.hasSideEffects)
		assertFalse(revert.hasTextInput)
		val result = revert.service.apply() as ResourceContentResult
		assertEquals(resourceContent, result.fullText)
	}
	
	@Test def testSaveFile() {
		val file = createFile('entity foo {}')
		
		val sessionStore = new HashMapSessionStore
		val load = dispatcher.getService('/load', #{'resource' -> file.name}, sessionStore)
		load.service.apply()
		val update = dispatcher.getService('/update', #{
				'resource' -> file.name,
				'deltaText' -> 'bar',
				'deltaOffset' -> '7',
				'deltaReplaceLength' -> '3'
			}, sessionStore)
		update.service.apply()
		
		val save = dispatcher.getService('/save', #{'resource' -> file.name}, sessionStore)
		assertTrue(save.hasSideEffects)
		assertFalse(save.hasTextInput)
		save.service.apply()
		val resourceContent = Files.toString(file, Charsets.UTF_8)
		assertEquals('entity bar {}', resourceContent)
	}
	
}
