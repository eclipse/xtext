/*******************************************************************************
 * Copyright (c) 2016, 2019 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server.concurrent;

import java.util.concurrent.ExecutorService;

import org.apache.log4j.Logger;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
public class ReadRequest<V> extends AbstractRequest<V> {
	private static final Logger LOG = Logger.getLogger(ReadRequest.class);

	private final Function1<? super CancelIndicator, ? extends V> cancellable;

	private final ExecutorService executor;

	public ReadRequest(RequestManager requestManager, Function1<? super CancelIndicator, ? extends V> cancellable,
			ExecutorService executor) {
		super(requestManager);
		this.cancellable = cancellable;
		this.executor = executor;
	}

	@Override
	public void run() {
		if (result.isCancelled()) {
			return;
		}
		this.executor.submit(() -> {
			try {
				cancelIndicator.checkCanceled();
				result.complete(cancellable.apply(cancelIndicator));
			} catch (Throwable t) {
				if (!requestManager.isCancelException(t)) {
					LOG.error("Error during request: ", t);
				}
				result.completeExceptionally(t);
			}
		});
	}

}
