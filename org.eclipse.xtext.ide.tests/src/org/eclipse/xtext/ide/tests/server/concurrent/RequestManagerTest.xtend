/*******************************************************************************
 * Copyright (c) 2016, 2017, 2018 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server.concurrent

import com.google.common.util.concurrent.Uninterruptibles
import com.google.inject.Guice
import com.google.inject.Inject
import com.google.inject.Provider
import java.util.concurrent.CancellationException
import java.util.concurrent.CountDownLatch
import java.util.concurrent.ExecutionException
import java.util.concurrent.ExecutorService
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicReference
import org.apache.log4j.Level
import org.eclipse.xtext.ide.server.ServerModule
import org.eclipse.xtext.ide.server.concurrent.AbstractRequest
import org.eclipse.xtext.ide.server.concurrent.ReadRequest
import org.eclipse.xtext.ide.server.concurrent.RequestManager
import org.eclipse.xtext.ide.server.concurrent.WriteRequest
import org.eclipse.xtext.service.OperationCanceledManager
import org.eclipse.xtext.testing.RepeatedTest
import org.eclipse.xtext.testing.logging.LoggingTester
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

import static org.junit.Assert.*

/**
 * @author kosyakov - Initial contribution and API
 */
class RequestManagerTest {

	@Rule public RepeatedTest.Rule rule = new RepeatedTest.Rule(false)

	@Inject
	RequestManager requestManager
	
	@Inject
	Provider<ExecutorService> executorServiceProvider

	@Inject
	Provider<OperationCanceledManager> cancelManagerProvider

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
	def void testRunWriteLogExceptionNonCancellable() {
		val logResult = LoggingTester.captureLogging(Level.ALL, WriteRequest, [
			val future = requestManager.runWrite([], [
				throw new RuntimeException();
			])
			
			// join future to assert log later
			try {
				future.join
			} catch (Exception e) {}
		])
		
		logResult.assertLogEntry("Error during request:")
	}

	@Test(timeout = 1000)
	def void testRunWriteLogExceptionCancellable() {
		val logResult = LoggingTester.captureLogging(Level.ALL, WriteRequest, [
			val future = requestManager.runWrite([
				throw new RuntimeException();
			], [])
			
			// join future to assert log later
			try {
				future.join
			} catch (Exception e) {}
		])
		
		logResult.assertLogEntry("Error during request:")
	}

	@Test(timeout = 1000, expected = ExecutionException)
	def void testRunWriteCatchException() {
		LoggingTester.captureLogging(Level.ALL, WriteRequest, [
			val future = requestManager.runWrite([
				throw new RuntimeException()
			], [])

			assertEquals('Foo', future.get)
		])
		
		Assert.fail("unreachable")
	}

	@Test(timeout = 1000)
	def void testRunReadLogException() {
		val logResult = LoggingTester.captureLogging(Level.ALL, ReadRequest, [
			val future = requestManager.runRead([
				throw new RuntimeException();
			])
			
			// join future to assert log later
			try {
				future.join
			} catch (Exception e) {}
		])
		
		logResult.assertLogEntry("Error during request:")
	}

	@Test(timeout = 1000, expected = ExecutionException)
	def void testRunReadCatchException() {
		LoggingTester.captureLogging(Level.ALL, ReadRequest, [
			val future = requestManager.runRead([
				throw new RuntimeException()
			])

			assertEquals('Foo', future.get)
		])
		
		Assert.fail
	}
	
	@Test
	def void testWriteWaitsForReadToFinish_01() throws Exception {
		val marked = new AtomicBoolean(false)
		val countDownInRead = new CountDownLatch(1)
		val countDownInWrite = new CountDownLatch(1)
		val proceedWithWrite = new CountDownLatch(1)
		val reader = requestManager.runRead [ cancelIndicator |
			countDownInRead.countDown
			Uninterruptibles.awaitUninterruptibly(countDownInWrite)
			marked.set(true)
			proceedWithWrite.countDown
			return null
		]
		Uninterruptibles.awaitUninterruptibly(countDownInRead)
		val writer = requestManager.runWrite([], [ cancelIndicator, ignored |
			countDownInWrite.countDown
			Uninterruptibles.awaitUninterruptibly(proceedWithWrite)
			assertTrue(marked.get)
			null
		])
		try {
			Uninterruptibles.getUninterruptibly(writer, 100, TimeUnit.MILLISECONDS)
			fail("Expected timeout")
		} catch(TimeoutException e) {
			assertFalse(marked.get()) // this should not be the case
		}
		countDownInWrite.countDown;
		Uninterruptibles.getUninterruptibly(writer, 100, TimeUnit.MILLISECONDS)
		assertTrue(reader.isDone)
		assertFalse(reader.isCancelled)
	}
	
	
	@Test
	def void testWriteWaitsForReadToFinish_02() throws Exception {
		val marked = new AtomicBoolean(false)
		val countDownInRead = new CountDownLatch(1)
		val countDownInWrite = new CountDownLatch(1)
		val proceedWithWrite = new CountDownLatch(1)
		val reader = requestManager.runRead [ cancelIndicator |
			countDownInRead.countDown
			Uninterruptibles.awaitUninterruptibly(countDownInWrite)
			marked.set(true)
			proceedWithWrite.countDown
			throw new CancellationException
		]
		Uninterruptibles.awaitUninterruptibly(countDownInRead)
		val writer = requestManager.runWrite([], [ cancelIndicator, ignored |
			countDownInWrite.countDown
			Uninterruptibles.awaitUninterruptibly(proceedWithWrite)
			assertTrue(marked.get)
			null
		])
		try {
			Uninterruptibles.getUninterruptibly(writer, 100, TimeUnit.MILLISECONDS)
			fail("Expected timeout")
		} catch(TimeoutException e) {
			assertFalse(marked.get()) // this should not be the case
		}
		countDownInWrite.countDown;
		Uninterruptibles.getUninterruptibly(writer, 100, TimeUnit.MILLISECONDS)
		assertTrue(reader.isDone)
		assertTrue(reader.isCancelled)
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
				Thread.sleep(10)
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
		requestManager.runWrite([], [
			sharedState.incrementAndGet
		])
		val future = requestManager.runRead [
			sharedState.get
		]
		assertEquals(1, future.get)
	}

	@Test(timeout = 1000)
	def void testRunWrite() {
		requestManager.runWrite([], [
			sharedState.incrementAndGet
		]).join
		assertEquals(1, sharedState.get)
	}

	@Test(timeout = 1000)
	def void testRunWriteAfterWrite() {
		requestManager.runWrite([], [
			sharedState.incrementAndGet
		]).join
		requestManager.runWrite([], [
			if (sharedState.get != 0)
				sharedState.incrementAndGet as Integer
		]).join
		assertEquals(2, sharedState.get)
	}

	@Test(timeout = 1000)
	@RepeatedTest(times=50)
	def void testRunWriteAfterReadStarted() {
		val readStarted = new CountDownLatch(1)
		requestManager.runRead [
			readStarted.countDown
			sharedState.incrementAndGet
		]
		Uninterruptibles.awaitUninterruptibly(readStarted)
		requestManager.runWrite([], [
			assertEquals (1, sharedState.get)
			sharedState.incrementAndGet
		]).join
		assertEquals(2, sharedState.get)
	}
	
	@Test(timeout = 1000)
	@RepeatedTest(times=50)
	def void testRunWriteBeforeReadStarted() {
		val writeSubmitted = new CountDownLatch(1)
		val firstWriteDone = new AtomicBoolean
		requestManager.runWrite([
			Uninterruptibles.awaitUninterruptibly(writeSubmitted)
			firstWriteDone.set(true)
			null
		], [
			sharedState.incrementAndGet
		])
		requestManager.runRead [
			sharedState.incrementAndGet
		]
		val joinMe = requestManager.runWrite([], [
			assertEquals (0, sharedState.get)
			assertTrue(firstWriteDone.get)
			sharedState.incrementAndGet
		])
		writeSubmitted.countDown
		joinMe.join
		assertTrue(firstWriteDone.get)
		assertEquals(1, sharedState.get)
	}

	@Test(timeout = 1000)
	def void testCancelRead() {
		val isCanceled = new AtomicBoolean(false)
		val future = requestManager.runRead [ cancelIndicator |
			try {
				sharedState.incrementAndGet
				while (!cancelIndicator.isCanceled) {
					Thread.sleep(10)
				}
			} finally {
				isCanceled.set(true)
			}
			return null
		]
		while (sharedState.get === 0) {
			Thread.sleep(10)
		}
		future.cancel(true)
		while (!isCanceled.get) {
			Thread.sleep(10)
		}
	}
	
	/*
	 * The tests assumes an implementation of a Command that has access to the request manager
	 * 
	 */
	@Test(timeout = 5000)
	@RepeatedTest(times=50)
	def void testReadCommandSubmitsWriteCommand() {
		val mainThread = Thread.currentThread
		val submittedFromMain = new CountDownLatch(1)
		val addedFromReader = new CountDownLatch(1)
		val AtomicReference<Thread> readerThreadRef = new AtomicReference 
		val myRequestManager = new RequestManager(executorServiceProvider.get, cancelManagerProvider.get) {
			
			override protected addRequest(AbstractRequest<?> request) {
				if (request instanceof WriteRequest && Thread.currentThread == readerThreadRef.get) {
					super.addRequest(request)
					addedFromReader.countDown
					Uninterruptibles.awaitUninterruptibly(submittedFromMain, 100, TimeUnit.MILLISECONDS)						
				} else {
					super.addRequest(request)
				}
			}
			
			override protected submitRequest(AbstractRequest<?> request) {
				if (request instanceof WriteRequest && Thread.currentThread == mainThread) {
					super.submitRequest(request)
					submittedFromMain.countDown
				} else {
					super.submitRequest(request)
				}
			}
			
			override protected cancel() {
				if (Thread.currentThread == mainThread) {
					Uninterruptibles.awaitUninterruptibly(addedFromReader, 100, TimeUnit.MILLISECONDS)
				}
				super.cancel()
			}
			
		}
		val threadSet = new CountDownLatch(1)
		val readResult = myRequestManager.runRead [
			readerThreadRef.set(Thread.currentThread)
			threadSet.countDown
			return myRequestManager.runWrite([], [])
		]
		Uninterruptibles.awaitUninterruptibly(threadSet)
		assertNotNull(readerThreadRef.get)
		val writeResult = myRequestManager.runWrite([], [])
		
		val writeFromReader = readResult.get
		try {
			writeFromReader.get
			try {
				writeResult.get
			} catch(CancellationException ce) {
				// one of both will be cancelled
				assertTrue(writeFromReader.isDone)
				assertTrue(writeResult.isDone)
				assertTrue(writeFromReader.isCancelled != writeResult.isCancelled)
			}
		} catch(CancellationException ce) {
			writeResult.get
			// one of both will be cancelled
			assertTrue(writeFromReader.isDone)
			assertTrue(writeResult.isDone)
			assertTrue(writeFromReader.isCancelled != writeResult.isCancelled)
		}
	}
}
