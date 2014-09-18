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

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @version 2.8
 */
class OutdatedStateManager {
	
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
}