/*******************************************************************************
 * Copyright (c) 2016, 2019 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.server.concurrent;

import java.util.concurrent.CompletableFuture;

import org.apache.log4j.Logger;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function2;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
public class WriteRequest<U, V> extends AbstractRequest<V> {
	private static final Logger LOG = Logger.getLogger(WriteRequest.class);

	private final Function0<? extends U> nonCancellable;

	private final Function2<? super CancelIndicator, ? super U, ? extends V> cancellable;

	private final CompletableFuture<Void> previous;

	public WriteRequest(RequestManager requestManager, Function0<? extends U> nonCancellable,
			Function2<? super CancelIndicator, ? super U, ? extends V> cancellable,
			CompletableFuture<Void> previous) {
		super(requestManager);
		this.nonCancellable = nonCancellable;
		this.cancellable = cancellable;
		this.previous = previous;
	}

	@Override
	public void run() {
		try {
			previous.join();
		} catch (Throwable t) {
			// We are not interested in results, only to make sure that all previous requests are finished before running next write request.
		}
		try {
			U intermediateResult = this.nonCancellable.apply();
			cancelIndicator.checkCanceled();
			result.complete(cancellable.apply(cancelIndicator, intermediateResult));
		} catch (Throwable t) {
			if (!requestManager.isCancelException(t)) {
				LOG.error("Error during request: ", t);
			}
			result.completeExceptionally(t);
		}
	}

}
