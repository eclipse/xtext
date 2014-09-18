/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource

import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.emf.ecore.resource.ResourceSet

/**
 * A facade for managing the outdated state of an XtextResourceSet.
 * 
 * A XtextResourceSet is considered outdated if new external changes are pending and processed
 * working on the current state should be canceled.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.8
 */
class ProcessCanceledManager {
	
	/**
	 * Marks the given XtextResourceSet as outdated.
	 * As a result any previously created CancelIndicators will be set to canceled.
	 */
	def void markOutdated(ResourceSet rs) {
		if (rs instanceof XtextResourceSet) {
			rs.incrementOutdatedStamp
		}
	}
	
	/**
	 * Created a fresh CancelIndicator
	 */
	def CancelIndicator newCancelIndiciator(ResourceSet rs) {
		if (rs instanceof XtextResourceSet) {
			val current = rs.outdatedStamp
			return [
				current != rs.outdatedStamp
			]
		} else {
			return [
				false
			]
		}
	}
	
	/**
	 *  
	 */
	def RuntimeException newOperationCanceledException() {
		return new OperationCanceledException()
	}
	
	/**
	 * @since 2.8
	 */
	def RuntimeException getOperationCanceledException(Throwable t) {
		switch t {
			OperationCanceledException : t
			RuntimeException case t.class.name == 'com.intellij.openapi.progress.ProcessCanceledException' : t
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
}