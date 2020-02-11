/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation

import java.util.Set
import org.eclipse.emf.common.notify.impl.AdapterImpl
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmConstructor
import org.eclipse.emf.common.notify.Adapter
import org.eclipse.emf.common.notify.Notification
import org.eclipse.emf.common.notify.Notifier

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class ReadAndWriteTracking {
	
	def markReadAccess(EObject object) {
		if (!isRead(object)) {
			object.eAdapters.add(READMARKER)
		}
	}
	
	def isRead(EObject object) {
		object.eAdapters.contains(READMARKER)
	}
	
	static val READMARKER = new Adapter() {
		
		override getTarget() {
			null
		}
		
		override isAdapterForType(Object type) {
			false
		}
		
		override notifyChanged(Notification notification) {
			
		}
		
		override setTarget(Notifier newTarget) {
			
		}
		
	}
	
	def markInitialized(EObject it, JvmConstructor constructor) {
		var initializedMarker = initializedMarker ?: newInitalizedMarker
		initializedMarker.markInitialized(constructor)
	}
	
	def isInitialized(EObject it, JvmConstructor constructor) {
		initializedMarker?.isInitialized(constructor)
	}
	
	protected def newInitalizedMarker(EObject it) {
		val initializedMarker = new ReadAndWriteTracking.InitializedMarker
		eAdapters.add(initializedMarker)
		initializedMarker
	} 
	
	protected def getInitializedMarker(EObject object) {
		object.eAdapters.filter(ReadAndWriteTracking.InitializedMarker).head
	}
	
	
	
	protected static class InitializedMarker extends AdapterImpl {
	
		Set<JvmConstructor> byConstructors = newHashSet
		
		def isInitialized(JvmConstructor constructor) {
			byConstructors.contains(constructor)
		}
		
		def markInitialized(JvmConstructor constructor) {
			byConstructors.add(constructor)
		}
	
	}
	
}

 