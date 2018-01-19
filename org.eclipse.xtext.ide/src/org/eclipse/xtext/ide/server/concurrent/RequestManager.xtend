/*******************************************************************************
 * Copyright (c) 2016, 2017, 2018 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server.concurrent

import com.google.common.util.concurrent.ThreadFactoryBuilder
import com.google.inject.Inject
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionException
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.service.OperationCanceledManager
import org.eclipse.xtext.util.CancelIndicator

/**
 * 
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
class RequestManager {

	@Inject ExecutorService parallel

	@Inject
	OperationCanceledManager operationCanceledManager

	val queue = Executors.newSingleThreadExecutor(
		new ThreadFactoryBuilder().setDaemon(true).setNameFormat("RequestManager-Queue-%d").build
	)
	var requests = <AbstractRequest<?>>newArrayList

	def void shutdown() {
		queue.shutdown()
		parallel.shutdown()
		cancel()
	}

	def <V> CompletableFuture<V> runRead((CancelIndicator)=>V cancellable) {
		return submit(
			new ReadRequest(cancellable, parallel)
		)
	}

	def <U, V> CompletableFuture<V> runWrite(()=>U nonCancellable, (CancelIndicator, U)=>V cancellable) {
		val cancelFuture = cancel()
		return submit(
			new WriteRequest(nonCancellable, cancellable, cancelFuture)
		)
	}

	protected def <V> CompletableFuture<V> submit(AbstractRequest<V> request) {
		requests += request
		queue.submit(request)
		return request.get
	}

	protected def CompletableFuture<Void> cancel() {
		val localRequests = requests
		requests = newArrayList

		val cfs = newArrayList
		for (request : localRequests) {
			request.cancel
			cfs += request.get
		}
		return CompletableFuture.allOf(cfs)
	}

	protected def boolean isCancelException(Throwable t) {
		if(t === null) return false;
		val cause = if(t instanceof CompletionException) t.cause else t
		return operationCanceledManager.isOperationCanceledException(cause);
	}

}

@FinalFieldsConstructor
class ReadRequest<V> extends AbstractRequest<V> {

	val (CancelIndicator)=>V cancellable
	val ExecutorService executor

	override void run() {
		if(result.cancelled) return;
		executor.submit [
			try {
				cancelIndicator.checkCanceled
				result.complete(cancellable.apply(cancelIndicator))
			} catch(Throwable e) {
				result.completeExceptionally(e)
			}
		]
	}

}

@FinalFieldsConstructor
class WriteRequest<U, V> extends AbstractRequest<V> {

	val ()=>U nonCancellable
	val (CancelIndicator, U)=>V cancellable
	val CompletableFuture<Void> previous

	override void run() {
		try {
			previous.join
		} catch(Throwable e) {
			// We are not interested in results, only to make sure that all previous requests are finished before running next write request.
		}
		try {
			val intermediateResult = nonCancellable.apply

			cancelIndicator.checkCanceled
			result.complete(cancellable.apply(cancelIndicator, intermediateResult))
		} catch(Throwable e) {
			result.completeExceptionally(e)
		}
	}

}

abstract class AbstractRequest<V> implements Runnable, Cancellable {

	protected val result = new CompletableFuture<V>()
	protected val cancelIndicator = new RequestCancelIndicator(result)

	override cancel() {
		cancelIndicator.cancel
	}

	def CompletableFuture<V> get() {
		return result
	}

}
