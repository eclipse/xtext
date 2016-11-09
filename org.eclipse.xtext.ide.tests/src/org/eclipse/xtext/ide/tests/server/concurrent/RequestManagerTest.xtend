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
import java.util.concurrent.CancellationException
import java.util.concurrent.ExecutionException
import java.util.concurrent.atomic.AtomicInteger
import org.eclipse.xtext.ide.server.ServerModule
import org.eclipse.xtext.ide.server.concurrent.RequestManager
import org.junit.After
import org.junit.Assert
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

	@Test(timeout = 1000)
	def void testRunRead() {
		val future = requestManager.runRead [
			'Foo'
		]
		assertEquals('Foo', future.get)
	}

	@Test(timeout = 1000)
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

	@Test(timeout = 1000)
	def void testRunReadAfterWrite() {
		requestManager.runWrite [
    		sharedState.incrementAndGet
		]
		val future = requestManager.runRead [
			sharedState.get
		]
		assertEquals(1, future.get)
	}

	@Test(timeout = 1000)
	def void testRunWrite() {
		requestManager.runWrite [
			sharedState.incrementAndGet
		].join
		assertEquals(1, sharedState.get)
	}

	@Test(timeout = 1000)
	def void testRunWriteAfterWrite() {
		requestManager.runWrite [
			sharedState.incrementAndGet
		]
		requestManager.runWrite [
			if (sharedState.get != 0)
				sharedState.incrementAndGet as Integer
		].join
		assertEquals(2, sharedState.get)
	}

	@Test(timeout = 1000)
	def void testRunWriteAfterRead() {
		requestManager.runRead [
			sharedState.incrementAndGet
		]
		requestManager.runWrite [
			assertEquals(1, sharedState.get)
			sharedState.incrementAndGet
		].join
		assertEquals(2, sharedState.get)
	}

	@Test(timeout = 1000)
	def void testCancelWrite() {
		val future = requestManager.runWrite [ cancelIndicator |
			try {
				sharedState.incrementAndGet
				while (!cancelIndicator.isCanceled) {
				}
				return sharedState.get
			} catch (CancellationException e) {
				return sharedState.incrementAndGet
			}
		]
		while (sharedState.get == 0) {
			Thread.sleep(10)
		}
		future.cancel(true)
		try {
			future.get
			Assert.fail("cancellation exception expected")
		} catch (CancellationException e) {
			// expected
			Assert.assertEquals(1, sharedState.get)
		}
	}

	@Test(timeout = 1000)
	def void testCancelRead() {
		val future = requestManager.runRead [ cancelIndicator |
			try {
				sharedState.incrementAndGet
				while (!cancelIndicator.isCanceled) {
				}
				return sharedState.get
			} catch (CancellationException e) {
				return sharedState.incrementAndGet
			}
		]
		while (sharedState.get == 0) {
			Thread.sleep(10)
		}
		future.cancel(true)
		try {
			future.get
			Assert.fail("cancellation exception expected")
		} catch (CancellationException e) {
			// expected
			Assert.assertEquals(1, sharedState.get)
		}
	}

}
