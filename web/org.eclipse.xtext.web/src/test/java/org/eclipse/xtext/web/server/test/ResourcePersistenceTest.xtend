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
		val resourceContent = 'state foo end'
		val file = createFile(resourceContent)
		
		val load = getService(#{'serviceType' -> 'load', 'resource' -> file.name})
		assertFalse(load.hasSideEffects)
		
		val result = load.service.apply() as ResourceContentResult
		assertEquals(resourceContent, result.fullText)
		assertFalse(result.dirty)
	}
	
	@Test def testLoadDummy() {
		val session = new HashMapSession
		val resourceContent = 'state foo end'
		var update = getService(#{
				'serviceType' -> 'update',
				'resource' -> 'dummy.statemachine',
				'fullText' -> resourceContent
			}, session)
		update.service.apply()
		var load = getService(#{'serviceType' -> 'load', 'resource' -> 'dummy.statemachine'}, session)
		var result = load.service.apply() as ResourceContentResult
		assertEquals(resourceContent, result.fullText)
		
		update = getService(#{
				'serviceType' -> 'update',
				'resource' -> 'dummy.statemachine',
				'deltaText' -> 'bar',
				'deltaOffset' -> '6',
				'deltaReplaceLength' -> '3'
			}, session)
		update.service.apply()
		load = getService(#{'serviceType' -> 'load', 'resource' -> 'dummy.statemachine'}, session)
		result = load.service.apply() as ResourceContentResult
		assertEquals('state bar end', result.fullText)
	}
	
	@Test def testRevertFile() {
		val resourceContent = 'state foo end'
		val file = createFile(resourceContent)
		
		val session = new HashMapSession
		val load = getService(#{'serviceType' -> 'load', 'resource' -> file.name}, session)
		load.service.apply()
		val update = getService(#{
				'serviceType' -> 'update',
				'resource' -> file.name,
				'deltaText' -> 'bar',
				'deltaOffset' -> '6',
				'deltaReplaceLength' -> '3'
			}, session)
		update.service.apply()
		
		val revert = getService(#{'serviceType' -> 'revert', 'resource' -> file.name}, session)
		assertTrue(revert.hasSideEffects)
		val result = revert.service.apply() as ResourceContentResult
		assertEquals(resourceContent, result.fullText)
	}
	
	@Test def testSaveFile() {
		val file = createFile('state foo end')
		
		val session = new HashMapSession
		val load = getService(#{'serviceType' -> 'load', 'resource' -> file.name}, session)
		load.service.apply()
		val update = getService(#{
				'serviceType' -> 'update',
				'resource' -> file.name,
				'deltaText' -> 'bar',
				'deltaOffset' -> '6',
				'deltaReplaceLength' -> '3'
			}, session)
		update.service.apply()
		
		val save = getService(#{'serviceType' -> 'save', 'resource' -> file.name}, session)
		assertTrue(save.hasSideEffects)
		save.service.apply()
		val resourceContent = Files.toString(file, Charsets.UTF_8)
		assertEquals('state bar end', resourceContent)
	}
	
}
