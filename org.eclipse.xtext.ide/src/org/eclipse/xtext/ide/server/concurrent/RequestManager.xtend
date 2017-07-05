/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server.concurrent

import com.google.common.util.concurrent.ThreadFactoryBuilder
import com.google.inject.Inject
import java.util.concurrent.CancellationException
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionException
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Semaphore
import org.apache.log4j.Logger
import org.eclipse.xtext.service.OperationCanceledManager
import org.eclipse.xtext.util.CancelIndicator

/**
 * <p>
 * The request manager run read/write requests.
 * </p>
 * <p>
 * <b>Execution:</b>
 * <ul>
 *  <li>requests are processed in an insertion order;</li>
 * 	<li>write requests are executed exclusive;</li>
 *  <li>read requests are executed in parallel.</li>
 * </ul>
 * </p>
 * 
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
class RequestManager {

	static val LOGGER = Logger.getLogger(RequestManager)

	val final MAX_PERMITS = Integer.MAX_VALUE
	val final WRITE_PERMITS = MAX_PERMITS
	val final READ_PERMITS = 1

	val sequential = Executors.newSingleThreadExecutor(
		new ThreadFactoryBuilder().setDaemon(true).setNameFormat("RequestManager-Queue-%d").build
	)
	@Inject ExecutorService parallel

	@Inject
	OperationCanceledManager operationCanceledManager

	val toCancel = new CopyOnWriteArrayList<Cancellable>

	val semaphore = new Semaphore(MAX_PERMITS)

	def void shutdown() {
		sequential.shutdown()
		parallel.shutdown()
		cancel()
	}

	def <V> V lockRead(()=>V request) {
		lock(READ_PERMITS, request)
	}

	def <V> V lockWrite(()=>V request) {
		lock(WRITE_PERMITS, request)
	}

	def void cancel() {
		for (cancellable : toCancel) {
			cancellable.cancel
			toCancel -= cancellable
		}
	}

	def <V> CompletableFuture<V> runWrite((CancelIndicator)=>V request) {
		queue(request) [
			thenApply[lockWrite]
		]
	}

	def <V> CompletableFuture<V> runRead((CancelIndicator)=>V request) {
		queue(request) [
			thenApplyAsync([lockRead], parallel)
		]
	}

	protected def <V> CompletableFuture<V> queue(
		(CancelIndicator)=>V request,
		(CompletableFuture<()=>V>)=>CompletableFuture<V> requestExecutor
	) {
		val origin = new CompletableFuture<RequestCancelIndicator>
		val requestFuture = requestExecutor.apply(
			origin.thenApplyAsync([bind(request)], sequential)
		)

		val cancelIndicator = new RequestCancelIndicator(requestFuture)
		toCancel += cancelIndicator
		val result = requestFuture.whenComplete [
			toCancel -= cancelIndicator
		]

		origin.complete(cancelIndicator)
		return result
	}

	protected def <V> ()=>V bind(RequestCancelIndicator cancelIndicator, (CancelIndicator)=>V request) {
		cancelIndicator.checkCanceled
		return [
			cancelIndicator.checkCanceled
			request.apply(cancelIndicator)
		]
	}

	protected def <V> V lock(int permits, ()=>V request) {
		semaphore.acquire(permits)
		try {
			return request.apply()
		} catch (Throwable t) {
			if (isCancelException(t)) {
				LOGGER.info("request cancelled.")
				throw new CancellationException()
			}
			throw t
		} finally {
			semaphore.release(permits)
		}
	}

	protected def boolean isCancelException(Throwable t) {
		if(t === null) return false;
		val cause = if(t instanceof CompletionException) t.cause else t
		return operationCanceledManager.isOperationCanceledException(cause);
	}

}
