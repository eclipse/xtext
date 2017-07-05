/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server.concurrent

import java.util.concurrent.CancellationException
import java.util.concurrent.CompletableFuture
import org.eclipse.lsp4j.jsonrpc.CancelChecker
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.util.CancelIndicator

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
@FinalFieldsConstructor
class RequestCancelIndicator implements CancelIndicator, CancelChecker, Cancellable {

	val CompletableFuture<?> requestFuture

	override cancel() {
		requestFuture.cancel(true)
	}
	
	override isCanceled() {
		checkCanceled
		return false
	}

	override void checkCanceled() {
		if (requestFuture.cancelled) {
			throw new CancellationException()
		}
	}

}
