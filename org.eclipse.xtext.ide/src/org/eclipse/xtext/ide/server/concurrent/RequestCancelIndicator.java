/*******************************************************************************
 * Copyright (c) 2016, 2019 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.server.concurrent;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;

import org.eclipse.lsp4j.jsonrpc.CancelChecker;
import org.eclipse.xtext.util.CancelIndicator;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
public class RequestCancelIndicator implements CancelIndicator, CancelChecker, Cancellable {
	private final CompletableFuture<?> requestFuture;

	public RequestCancelIndicator(CompletableFuture<?> requestFuture) {
		this.requestFuture = requestFuture;
	}

	@Override
	public void cancel() {
		this.requestFuture.cancel(true);
	}

	/**
	 * Not really boolean guard but will throw a {@link CancellationException} instead of returning
	 * <code>true</code>. Otherwise returns <code>false</code>.
	 */
	@Override
	public boolean isCanceled() {
		this.checkCanceled();
		return false;
	}

	@Override
	public void checkCanceled() {
		if (this.requestFuture.isCancelled()) {
			throw new CancellationException();
		}
	}

}
