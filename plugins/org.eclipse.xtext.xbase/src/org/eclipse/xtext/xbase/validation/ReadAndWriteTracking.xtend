/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation

import org.eclipse.emf.common.notify.impl.AdapterImpl
import org.eclipse.emf.ecore.EObject

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class ReadAndWriteTracking {
	
	def markReadAccess(EObject object) {
		if (!isRead(object)) {
			object.eAdapters.add(READ_MARKER)
		}
	}
	
	def isRead(EObject object) {
		object.eAdapters.contains(READ_MARKER)
	}
	
	def markInitialized(EObject object) {
		if (!isInitialized(object)) {
			object.eAdapters.add(INITIALIZED_MARKER)
		}
	}
	
	def isInitialized(EObject object) {
		object.eAdapters.contains(INITIALIZED_MARKER)
	}
	
	
	static final AdapterImpl READ_MARKER = new AdapterImpl() {} 
	static final AdapterImpl INITIALIZED_MARKER = new AdapterImpl() {} 
	
}
