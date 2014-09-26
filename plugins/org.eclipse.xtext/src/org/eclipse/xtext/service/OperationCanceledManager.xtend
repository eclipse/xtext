/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.service

import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.util.CancelIndicator

/**
 * A facade for managing and working with cancellation exceptions of different platforms.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.8
 */
class OperationCanceledManager {
	
	/**
	 * @since 2.8
	 */
	protected def RuntimeException getPlatformOperationCanceledException(Throwable t) {
		switch t {
			OperationCanceledException : t
			RuntimeException case t.class.name == 'com.intellij.openapi.progress.ProcessCanceledException' : t
			OperationCanceledError : t.wrapped
			default : null
		}
	}
	
	def isOperationCanceledException(Throwable t) {
		t.platformOperationCanceledException != null
	}
	
	/**
	 * @since 2.8
	 */
	def void throwIfOperationCanceledException(Throwable t) {
		val opCanceledException = getPlatformOperationCanceledException(t);
		if (opCanceledException != null)
			throw new OperationCanceledError(opCanceledException);
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
	
	protected def RuntimeException getPlatformSpecificOperationCanceledException() {
		return new OperationCanceledException()
	}
	
	def void checkCanceled(CancelIndicator indicator) {
		if (indicator != null && indicator.isCanceled) {
			throwOperationCanceledException
		}
	}
	
	def void checkCanceled(IProgressMonitor indicator) {
		if (indicator != null && indicator.isCanceled) {
			throwOperationCanceledException
		}
	}
	
}

/**
 * @since 2.8
 */
@FinalFieldsConstructor class OperationCanceledError extends Error {
	@Accessors final RuntimeException wrapped
	
	override fillInStackTrace() {
		super.fillInStackTrace
	}

	override getCause() {
		wrapped
	}
	
	override getLocalizedMessage() {
		wrapped.localizedMessage
	}
	
	override getMessage() {
		wrapped.message
	}
	
	override getStackTrace() {
		wrapped.stackTrace
	}
	
}