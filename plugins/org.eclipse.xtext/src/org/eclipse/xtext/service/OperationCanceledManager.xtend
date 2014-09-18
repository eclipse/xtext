/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.service

import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

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
	def RuntimeException getOperationCanceledException(Throwable t) {
		switch t {
			OperationCanceledException : t
			RuntimeException case t.class.name == 'com.intellij.openapi.progress.ProcessCanceledException' : t
			OperationCanceledError : t.wrapped
			default : null
		}
	}
	
	/**
	 * @since 2.8
	 */
	def void throwIfOperationCanceledException(Throwable t) {
		val opCanceledException = getOperationCanceledException(t);
		if (opCanceledException != null) {
			throw opCanceledException;
		}
	}
	
	/**
	 * @since 2.8
	 */
	def void throwAsErrorIfOperationCanceledException(Throwable t) {
		val opCanceledException = getOperationCanceledException(t);
		if (opCanceledException != null) {
			throw getCheckedOperationCanceledException(opCanceledException)
		}
	}
	
	def getCheckedOperationCanceledException(RuntimeException opCanceledException) {
		new OperationCanceledError(opCanceledException)
	}
	
	@FinalFieldsConstructor private final static class OperationCanceledError extends Error {
		@Accessors final RuntimeException wrapped
	}
}