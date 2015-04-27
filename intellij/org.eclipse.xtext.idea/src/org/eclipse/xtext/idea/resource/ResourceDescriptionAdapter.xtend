/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.resource

import org.eclipse.emf.common.notify.impl.AdapterImpl
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.lib.annotations.Delegate
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.XtextResource

@FinalFieldsConstructor
class ResourceDescriptionAdapter extends AdapterImpl implements IResourceDescription {
	
	@Delegate
	val IResourceDescription delegate
	
	def static install(Resource it) {
		remove
		if (it instanceof XtextResource) {
			val extension resourceDescriptionManager = resourceServiceProvider.resourceDescriptionManager
			new ResourceDescriptionAdapter(resourceDescription) => [ adapter |
				eAdapters += adapter
			]
		}
	}
	
	def static remove(Resource it) {
		val adapter = get
		if (adapter != null) {
			eAdapters -= adapter
		}
	}
	
	def static get(Resource it) {
		eAdapters.filter(ResourceDescriptionAdapter).head
	}
	
	override toString() {
		class.name + ':' + delegate.toString
	}
	
}