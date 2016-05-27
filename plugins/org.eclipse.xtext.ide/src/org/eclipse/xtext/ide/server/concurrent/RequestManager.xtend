/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server.concurrent

import com.google.inject.Inject
import com.google.inject.Singleton
import com.google.inject.name.Named
import java.util.concurrent.ExecutorService
import java.util.concurrent.Future
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.Semaphore
import org.eclipse.xtext.util.CancelIndicator

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
class RequestManager {

	public static val READ_EXECUTOR_SERVICE = 'org.eclipse.xtext.ide.server.concurrent.RequestManager.readExecutorService'
	public static val WRITE_EXECUTOR_SERVICE = 'org.eclipse.xtext.ide.server.concurrent.RequestManager.writeExecutorService'

	val final MAX_PERMITS = Integer.MAX_VALUE

	@Inject
	@Named(READ_EXECUTOR_SERVICE)
	ExecutorService readExecutorService

	@Inject
	@Named(WRITE_EXECUTOR_SERVICE)
	ExecutorService writeExecutorService

	val cancelIndicators = new LinkedBlockingQueue<CancellableIndicator>

	val semaphore = new Semaphore(MAX_PERMITS)

	def Future<Void> runWrite((CancelIndicator)=>void writeRequest) {
		runWrite(writeRequest, new RequestCancelIndicator)
	}

	def Future<Void> runWrite((CancelIndicator)=>void writeRequest, CancelIndicator cancelIndicator) {
		cancelIndicators.forEach[cancel]
		writeExecutorService.run([
			writeRequest.apply(it)
			return null
		], MAX_PERMITS, cancelIndicator)
	}

	def <V> Future<V> runRead((CancelIndicator)=>V readRequest) {
		runRead(readRequest, new RequestCancelIndicator)
	}

	def <V> Future<V> runRead((CancelIndicator)=>V readRequest, CancelIndicator cancelIndicator) {
		readExecutorService.run(readRequest, 1, cancelIndicator)
	}

	protected def <V> Future<V> run(
		ExecutorService executorService,
		(CancelIndicator)=>V request,
		int permits,
		CancelIndicator cancelIndicator
	) {
		return executorService.submit [
			semaphore.acquire(permits)
			try {
				if (cancelIndicator instanceof CancellableIndicator)
					cancelIndicators += cancelIndicator

				return request.apply(cancelIndicator)
			} finally {
				if (cancelIndicator instanceof CancellableIndicator)
					cancelIndicators -= cancelIndicator

				semaphore.release(permits)
			}
		]
	}

}
