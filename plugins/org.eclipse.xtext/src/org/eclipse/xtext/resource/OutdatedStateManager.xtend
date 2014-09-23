/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource

import com.google.inject.Inject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.service.OperationCanceledError
import org.eclipse.xtext.service.OperationCanceledManager
import org.eclipse.xtext.util.CancelIndicator

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.8
 */
class OutdatedStateManager {
	
	@Inject OperationCanceledManager canceledManager
	
	/**
	 * Created a fresh CancelIndicator
	 */
	def CancelIndicator newCancelIndiciator(ResourceSet rs) {
		if (rs instanceof XtextResourceSet) {
			val current = rs.modificationStamp
			return [ rs.isOutdated || current != rs.modificationStamp]
		} else {
			CancelIndicator.NullImpl
		}
	}
	
	/**
	 * Checks whether the given ResourceSet is in an outdated state and
	 * throws an {@link OperationCanceledError} if so.
	 */ 
	def void checkCanceled(ResourceSet rs) {
		if (rs instanceof XtextResourceSet) {
			if (rs.outdated)
				canceledManager.throwOperationCanceledException()
		}
	}
}