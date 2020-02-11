/*******************************************************************************
 * Copyright (c) 2016, 2019 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.server.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
@Singleton
public class RequestManager {

	@Inject
	private ExecutorService parallel;

	@Inject
	private OperationCanceledManager operationCanceledManager;

	private final ExecutorService queue = Executors.newSingleThreadExecutor(
			new ThreadFactoryBuilder().setDaemon(true).setNameFormat("RequestManager-Queue-%d").build());

	private List<AbstractRequest<?>> requests = new ArrayList<>();

	/**
	 * An orderly shutdown of this request manager.
	 */
	public void shutdown() {
		queue.shutdown();
		parallel.shutdown();
		cancel();
	}

	/**
	 * Run the given cancellable logic as a read request.
	 */
	public <V> CompletableFuture<V> runRead(Function1<? super CancelIndicator, ? extends V> cancellable) {
		return submit(new ReadRequest<>(this, cancellable, parallel));
	}

	/**
	 * Perform the given write and run the cancellable logic afterwards.
	 */
	public <U, V> CompletableFuture<V> runWrite(
			Function0<? extends U> nonCancellable,
			Function2<? super CancelIndicator, ? super U, ? extends V> cancellable) {
		return submit(new WriteRequest<>(this, nonCancellable, cancellable, cancel()));
	}

	/**
	 * Submit the given request.
	 */
	protected <V> CompletableFuture<V> submit(AbstractRequest<V> request) {
		requests.add(request);
		queue.submit(request);
		return request.get();
	}

	/**
	 * Cancel all requests in the queue.
	 */
	protected CompletableFuture<Void> cancel() {
		List<AbstractRequest<?>> localRequests = requests;
		requests = new ArrayList<>();
		CompletableFuture<?>[] cfs = new CompletableFuture<?>[localRequests.size()];
		for (int i = 0, max = localRequests.size(); i < max; i++) {
			AbstractRequest<?> request = localRequests.get(i);
			request.cancel();
			cfs[i] = request.get();
		}
		return CompletableFuture.allOf(cfs);
	}

	/**
	 * Check if the given throwable is an indicator for a cancellation.
	 */
	protected boolean isCancelException(Throwable t) {
		if (t == null) {
			return false;
		}
		Throwable cause = t;
		if (t instanceof CompletionException) {
			cause = ((CompletionException) t).getCause();
		}
		return operationCanceledManager.isOperationCanceledException(cause);
	}
}
