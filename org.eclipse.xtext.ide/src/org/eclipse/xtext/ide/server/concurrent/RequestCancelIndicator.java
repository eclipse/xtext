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

import org.eclipse.lsp4j.jsonrpc.CancelChecker;
import org.eclipse.xtext.util.CancelIndicator;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
class RequestCancelIndicator implements CancelIndicator, CancelChecker, Cancellable {
	private volatile boolean cancelled = false;
	private final AbstractRequest<?> request;

	RequestCancelIndicator(AbstractRequest<?> request) {
		this.request = request;
	}

	@Override
	public void cancel() {
		request.cancel();
	}

	protected void doCancel() {
		this.cancelled = true;
	}

	@Override
	public boolean isCanceled() {
		return cancelled;
	}

	@Override
	public void checkCanceled() {
		if (cancelled) {
			throw new CancellationException();
		}
	}

}
