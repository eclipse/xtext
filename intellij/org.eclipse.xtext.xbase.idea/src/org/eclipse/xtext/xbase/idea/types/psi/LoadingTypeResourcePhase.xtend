/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.types.psi

import org.eclipse.emf.common.notify.Notifier
import org.eclipse.emf.common.notify.impl.AdapterImpl

import static extension org.eclipse.emf.ecore.util.EcoreUtil.*
import static extension org.eclipse.xtext.EcoreUtil2.*

/**
 * @author kosyakov - Initial contribution and API
 */
class LoadingTypeResourcePhase extends AdapterImpl {

	override isAdapterForType(Object type) {
		LoadingTypeResourcePhase == type
	}

	static def isLoadingTypeResource(Notifier ctx) {
		val resourceSet = ctx.resourceSet
		if (resourceSet == null) {
			return false
		} 
		resourceSet.eAdapters.getAdapter(LoadingTypeResourcePhase) != null
	}

	static def void setLoadingTypeResource(Notifier ctx, boolean loadingTypeResource) {
		val resourceSet = ctx.resourceSet
		if (loadingTypeResource) {
			resourceSet.eAdapters += new LoadingTypeResourcePhase
		} else {
			val i = resourceSet.eAdapters.iterator
			while (i.hasNext) {
				if (i.next.isAdapterForType(LoadingTypeResourcePhase)) {
					i.remove
					return
				}
			}
		}
	}

}