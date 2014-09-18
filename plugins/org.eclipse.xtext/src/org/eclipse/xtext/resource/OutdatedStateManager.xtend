/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource

import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.util.CancelIndicator
import com.google.inject.Inject
import org.eclipse.xtext.service.OperationCanceledManager

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @version 2.8
 */
class OutdatedStateManager {
	
	@Inject OperationCanceledManager canceledManager
	
	/**
	 * Created a fresh CancelIndicator
	 */
	def CancelIndicator newCancelIndiciator(ResourceSet rs) {
		if (rs instanceof XtextResourceSet) {
			[ rs.isOutdated ]
		} else {
			CancelIndicator.NullImpl
		}
	}
	
	/**
	 * 
	 */ 
	def void checkCanceled(ResourceSet rs) {
		if (rs instanceof XtextResourceSet) {
			if (rs.outdated)
				canceledManager.throwOperationCanceledException()
		}
	}
}