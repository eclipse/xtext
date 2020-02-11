/**
 * Copyright (c) 2014, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.service;

import java.util.concurrent.CancellationException;

import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.xtext.util.CancelIndicator;

/**
 * A facade for managing and working with cancellation exceptions of different platforms.
 *
 * @author Sven Efftinge - Initial contribution and API
 *
 * @since 2.8
 */
public class OperationCanceledManager {
	protected RuntimeException getPlatformOperationCanceledException(Throwable t) {
		if (t instanceof CancellationException) {
			return (RuntimeException) t;
		}
		if (t instanceof OperationCanceledException) {
			return (RuntimeException) t;
		}
		if (t instanceof OperationCanceledError) {
			return ((OperationCanceledError) t).getWrapped();
		}
		return null;
	}

	public boolean isOperationCanceledException(Throwable t) {
		return getPlatformOperationCanceledException(t) != null;
	}

	/**
	 * Rethrows OperationCanceledErrors and wraps platform specific OperationCanceledExceptions. Does nothing for any
	 * other type of Throwable.
	 */
	public void propagateAsErrorIfCancelException(Throwable t) {
		if (t instanceof OperationCanceledError) {
			throw (OperationCanceledError) t;
		}
		RuntimeException opCanceledException = getPlatformOperationCanceledException(t);
		if (opCanceledException != null) {
			throw new OperationCanceledError(opCanceledException);
		}
	}

	/**
	 * Re-throws platform specific OperationCanceledExceptions and unwraps OperationCanceledErrors. Does nothing for any
	 * other type of Throwable.
	 */
	public void propagateIfCancelException(final Throwable t) {
		RuntimeException cancelException = getPlatformOperationCanceledException(t);
		if (cancelException != null) {
			throw cancelException;
		}
	}

	protected Error asWrappingOperationCanceledException(Throwable throwable) {
		if (throwable instanceof OperationCanceledError) {
			return (Error) throwable;
		}
		final RuntimeException platform = getPlatformOperationCanceledException(throwable);
		if (platform != null) {
			return new OperationCanceledError(platform);
		}
		return null;
	}

	public void throwOperationCanceledException() {
		throw asWrappingOperationCanceledException(getPlatformSpecificOperationCanceledException());
	}

	protected RuntimeException getPlatformSpecificOperationCanceledException() {
		return new OperationCanceledException();
	}

	public void checkCanceled(final CancelIndicator indicator) {
		if (indicator != null && indicator.isCanceled()) {
			throwOperationCanceledException();
		}
	}
}
