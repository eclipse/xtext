/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server.concurrent

import com.google.inject.Guice
import com.google.inject.Inject
import java.util.concurrent.atomic.AtomicInteger
import org.eclipse.xtext.ide.server.ServerModule
import org.eclipse.xtext.ide.server.concurrent.RequestManager
import org.junit.After
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.*

/**
 * @author kosyakov - Initial contribution and API
 */
class RequestManagerTest {

	@Inject
	RequestManager requestManager

	AtomicInteger sharedState

	@Before
	def void setUp() {
		sharedState = new AtomicInteger
		Guice.createInjector(new ServerModule).injectMembers(this)
	}

	@After
	def void tearDown() {
		requestManager.shutdown
		sharedState = null
	}

	@Test
	def void testRunRead() {
		val future = requestManager.runRead [
			'Foo'
		]
		assertEquals('Foo', future.get)
	}

	@Test
	def void testRunReadConcurrent() {
		val future = requestManager.runRead [
			while (sharedState.get == 0) {
			}
			sharedState.incrementAndGet
		]
		requestManager.runRead [
			sharedState.incrementAndGet
		]
		future.join
		assertEquals(2, sharedState.get)
	}

	@Test
	def void testRunReadAfterWrite() {
		requestManager.runWrite [
			while (sharedState.get == 0) {
			}
			sharedState.incrementAndGet
		]
		val future = requestManager.runRead [
			sharedState.get
		]
		sharedState.incrementAndGet
		assertEquals(2, future.get)
	}

	@Test
	def void testRunWrite() {
		requestManager.runWrite [
			sharedState.incrementAndGet
		].join
		assertEquals(1, sharedState.get)
	}

	@Test
	def void testRunWriteAfterWrite() {
		requestManager.runWrite [
			sharedState.incrementAndGet
		]
		requestManager.runWrite [
			if (sharedState.get != 0)
				sharedState.incrementAndGet
		].join
		assertEquals(2, sharedState.get)
	}

	@Test
	def void testRunWriteAfterRead() {
		requestManager.runRead [
			sharedState.incrementAndGet
		]
		requestManager.runWrite [
			while (sharedState.get == 0) {
			}
			sharedState.incrementAndGet
		].join
		assertEquals(2, sharedState.get)
	}

	@Test
	def void testCancelWrite() {
		requestManager.runWrite [ cancelIndicator |
			while (!cancelIndicator.canceled) {
			}
			sharedState.incrementAndGet
		]
		requestManager.runWrite [
			sharedState.incrementAndGet
		].join
		assertEquals(2, sharedState.get)
	}

	@Test
	def void testCancelRead() {
		sharedState.incrementAndGet
		val future = requestManager.runRead [ cancelIndicator |
			while (!cancelIndicator.canceled) {
			}
			sharedState.get
		]
		requestManager.runWrite [
			sharedState.set(0)
		].join
		assertEquals(1, future.get)
	}

}
