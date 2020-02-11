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

/**
 * Abstract base type for read and write requests.
 * 
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
public abstract class AbstractRequest<V> implements Runnable, Cancellable {
	/**
	 * The underyling future.
	 */
	protected final CompletableFuture<V> result;

	/**
	 * The current cancel indicator.
	 */
	protected final RequestCancelIndicator cancelIndicator;

	/**
	 * The request manager that is handling this request.
	 */
	protected final RequestManager requestManager;

	protected AbstractRequest(RequestManager requestManager) {
		this.requestManager = requestManager;
		this.result = new CompletableFuture<>();
		this.cancelIndicator = new RequestCancelIndicator(this.result);
	}

	@Override
	public void cancel() {
		cancelIndicator.cancel();
	}

	/**
	 * Return the underlying future.
	 */
	public CompletableFuture<V> get() {
		return result;
	}
}