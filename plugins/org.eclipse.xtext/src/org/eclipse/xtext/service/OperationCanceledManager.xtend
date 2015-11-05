/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.service

import org.eclipse.xtext.util.CancelIndicator

/**
 * A facade for managing and working with cancellation exceptions of different platforms.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.8
 */
class OperationCanceledManager {
	
	protected def RuntimeException getPlatformOperationCanceledException(Throwable t) {
		switch t {
			RuntimeException case t.class.name == 'org.eclipse.core.runtime.OperationCanceledException' : t
			RuntimeException case t.class.name == 'com.intellij.openapi.progress.ProcessCanceledException' : t
			OperationCanceledError : t.wrapped
			default : null
		}
	}
	
	def isOperationCanceledException(Throwable t) {
		t.platformOperationCanceledException != null
	}
	
	/**
	 * Rethrows OperationCanceledErrors and wraps platform specific OperationCanceledExceptions. Does nothing for any other type of Throwable.
	 */
	def void propagateAsErrorIfCancelException(Throwable t) {
		if (t instanceof OperationCanceledError) {
			throw t;
		}
		val opCanceledException = getPlatformOperationCanceledException(t);
		if (opCanceledException !== null)
			throw new OperationCanceledError(opCanceledException);
	}
	
	/**
	 * Rethrows platform specific OperationCanceledExceptions and unwraps OperationCanceledErrors. Does nothing for any other type of Throwable.
	 */
	def void propagateIfCancelException(Throwable t) {
		val cancelException = t.platformOperationCanceledException
		if (cancelException !== null) 
			throw cancelException
	}
	
	protected def Error asWrappingOperationCanceledException(Throwable throwable) {
		if (throwable instanceof OperationCanceledError) {
			return throwable
		}
		val platform = getPlatformOperationCanceledException(throwable)
		if (platform != null) {
			return new OperationCanceledError(platform)
		}
		return null
	}
	
	def void throwOperationCanceledException() {
		throw asWrappingOperationCanceledException(platformSpecificOperationCanceledException)
	}
	
	/**
	 * @since 2.9
	 */
	protected def Throwable getPlatformSpecificOperationCanceledException() {
		return new OperationCanceledError(null)
	}
	
	def void checkCanceled(CancelIndicator indicator) {
		if (indicator != null && indicator.isCanceled) {
			throwOperationCanceledException
		}
	}
	
}

/**
 * @since 2.8
 */
class OperationCanceledError extends Error {
	/**
	 * @since 2.9
	 */
 	new() {
		super()
	}
	new(RuntimeException cause) {
		super(cause)
	}
	def RuntimeException getWrapped() {
		return cause as RuntimeException
	}
}