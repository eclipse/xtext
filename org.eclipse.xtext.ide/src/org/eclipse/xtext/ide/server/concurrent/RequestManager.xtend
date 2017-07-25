/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server.concurrent

import com.google.inject.Inject
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionException
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.ExecutorService
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantReadWriteLock
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

	private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	private final Lock r = rwl.readLock();
	private final Lock w = rwl.writeLock();

	@Inject ExecutorService parallel

	@Inject
	OperationCanceledManager operationCanceledManager

	val toCancel = new CopyOnWriteArrayList<Cancellable>

	def void shutdown() {
		parallel.shutdown()
		cancel()
	}

	def <V> CompletableFuture<V> runRead((CancelIndicator)=>V request) {
		val result = new CompletableFuture<V>()
		writePending.thenRun [			
			parallel.submit[
				val cancelIndicator = new RequestCancelIndicator(result)
				try {
					r.lock
					toCancel += cancelIndicator
					cancelIndicator.checkCanceled
					result.complete(request.apply(cancelIndicator))
				} catch (Exception e) {
					result.completeExceptionally(e)
				} finally {
					toCancel -= cancelIndicator
					r.unlock()
				}
			]
		]
		return result
	}
	
	var CompletableFuture<Void> writePending = CompletableFuture.completedFuture(null)

	def <U, V> CompletableFuture<V> runWrite(()=>U nonCancellable, (CancelIndicator, U)=>V request) {
		val result = new CompletableFuture<V>()
		val localWritePending = new CompletableFuture<Void>()
		this.writePending = localWritePending
		parallel.submit[
			val cancelIndicator = new RequestCancelIndicator(result)
			try {
				cancel()
				w.lock
				localWritePending.complete(null)
				// run the non-cancelable work
				val intermediateResult = nonCancellable.apply()
				
				// run the cancelable work
				toCancel += cancelIndicator
				cancelIndicator.checkCanceled
				result.complete(request.apply(cancelIndicator, intermediateResult))
			} catch (Exception e) {
				result.completeExceptionally(e)
			} finally {
				toCancel -= cancelIndicator
				w.unlock
			}
		]
		return result
	}

	protected def void cancel() {
		for (cancellable : toCancel) {
			cancellable.cancel
			toCancel -= cancellable
		}
	}

	protected def boolean isCancelException(Throwable t) {
		if(t === null) return false;
		val cause = if(t instanceof CompletionException) t.cause else t
		return operationCanceledManager.isOperationCanceledException(cause);
	}

}
