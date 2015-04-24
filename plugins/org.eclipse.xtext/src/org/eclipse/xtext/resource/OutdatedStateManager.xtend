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
import org.eclipse.xtext.util.concurrent.IUnitOfWork
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork
import org.eclipse.emf.ecore.resource.Resource

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.8
 */
class OutdatedStateManager {
	
	@Inject OperationCanceledManager canceledManager
	
	val cancelationAllowed = new ThreadLocal<Boolean> {
		override initialValue() {
			true
		}
	}
	
	/**
	 * Created a fresh CancelIndicator
	 */
	def CancelIndicator newCancelIndicator(ResourceSet rs) {
		if (rs instanceof XtextResourceSet) {
			val boolean cancelationAllowed = this.cancelationAllowed.get 
			val current = rs.modificationStamp
			return [ 
				cancelationAllowed && (rs.isOutdated || current != rs.modificationStamp)
			]
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
			if (rs.outdated && cancelationAllowed.get)
				canceledManager.throwOperationCanceledException()
		}
	}
	
	def <R, P extends Resource> R exec(IUnitOfWork<R, P> work, P param) {
		val wasCancelationAllowed = cancelationAllowed.get
		try {
			if (work instanceof CancelableUnitOfWork<?,?>) {
				work.cancelIndicator = if (param === null)
					[ true ]
				else
					param.resourceSet.newCancelIndicator
			} else {
				cancelationAllowed.set(false)
			}
			work.exec(param)
		} finally {
			cancelationAllowed.set(wasCancelationAllowed)
		}
	}
}