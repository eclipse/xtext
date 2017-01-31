/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server.concurrent

import com.google.inject.Inject
import java.util.concurrent.CancellationException
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionException
import java.util.concurrent.ExecutorService
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.Semaphore
import org.apache.log4j.Logger
import org.eclipse.lsp4j.jsonrpc.CompletableFutures
import org.eclipse.xtext.service.OperationCanceledManager
import org.eclipse.xtext.util.CancelIndicator

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
class RequestManager {
    
    static val LOGGER = Logger.getLogger(RequestManager)

	val final MAX_PERMITS = Integer.MAX_VALUE

	@Inject
	ExecutorService executorService

	@Inject
	OperationCanceledManager operationCanceledManager

	val cancelIndicators = new LinkedBlockingQueue<Cancellable>

	val semaphore = new Semaphore(MAX_PERMITS)

	def void shutdown() {
		executorService.shutdown()
	}


	/**
	 * <p>
	 * The given <i>write request</i> will be run first when <i>all running requests</i> completed.
	 * </p>
	 * <p>
	 * Currently <i>running requests</i> will be cancelled.
	 * </p>
	 * <p>
	 * A provided cancel indicator should implement {@link CancelIndicator} 
	 * to let the given request to be cancelled by a write request.
	 * </p>
	 */
	def <V> CompletableFuture<V> runWrite((CancelIndicator)=>V writeRequest) {
		semaphore.acquire(MAX_PERMITS)
		return CompletableFutures.computeAsync(executorService) [
			val cancelIndicator = new RequestCancelIndicator(it)
			cancelIndicators += cancelIndicator
	
			try {
				return writeRequest.apply([
					cancelIndicator.checkCanceled
					return false
				])
			} catch (Throwable t) {
	            if (isCancelException(t)) {
	            	LOGGER.info("request cancelled.")
	            	throw new CancellationException()
	            }
	            throw t
			} finally {
				cancelIndicators -= cancelIndicator
				semaphore.release(MAX_PERMITS)
			}
		]
	}


	/**
	 * <p>
	 * The given <i>read request</i> will be run:
	 * <ul>
	 * 	<li>concurrent with <i>running read requests</i>;</li>
	 * 	<li>first when <i>running write requests</i> completed.</li>
	 * </ul>
	 * </p>
	 * <p>
	 * </p>
	 */
	def <V> CompletableFuture<V> runRead((CancelIndicator)=>V readRequest) {
		return CompletableFutures.computeAsync(executorService) [
			val cancelIndicator = new RequestCancelIndicator(it)
			cancelIndicators += cancelIndicator
			semaphore.acquire(1)
			try {
    			cancelIndicator.checkCanceled
				return readRequest.apply [
					cancelIndicator.checkCanceled
					return false
				]
			} catch (Throwable t) {
	            if (isCancelException(t)) {
	            	LOGGER.info("request cancelled.")
	            	throw new CancellationException()
	            }
	            throw t
			} finally {
				cancelIndicators -= cancelIndicator
				semaphore.release(1)
			}
		]
	}
	
	protected def boolean isCancelException(Throwable t) {
        if(t === null) return false;
        val cause = if (t instanceof CompletionException) t.cause else t
        return operationCanceledManager.isOperationCanceledException(cause);
    }

}
