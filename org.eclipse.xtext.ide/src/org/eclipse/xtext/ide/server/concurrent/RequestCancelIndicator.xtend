/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server.concurrent

import java.util.concurrent.CancellationException
import org.eclipse.lsp4j.jsonrpc.CancelIndicator
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
class RequestCancelIndicator implements CancelIndicator, Cancellable {

	@Accessors(PUBLIC_GETTER)
	volatile boolean canceled
	
	CancelIndicator delegate
	
	new () {}
	new (CancelIndicator delegate) {
		this.delegate = delegate
	}

	override cancel() {
		canceled = true
	}
	
	override checkCanceled() {
		if (delegate !== null) {
			delegate.checkCanceled
		}
		if (canceled) {
			throw new CancellationException("process canceled")
		}
	}

}
