/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.resource

import org.eclipse.emf.common.notify.impl.AdapterImpl
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.XtextResource

@FinalFieldsConstructor
class ResourceDescriptionAdapter extends AdapterImpl implements IResourceDescription {
	
	val IResourceDescription delegate
	
	override getExportedObjects() {
		delegate.exportedObjects
	}
	
	override getImportedNames() {
		delegate.importedNames
	}
	
	override getReferenceDescriptions() {
		delegate.referenceDescriptions
	}
	
	override getURI() {
		delegate.URI
	}
	
	override getExportedObjects(EClass type, QualifiedName name, boolean ignoreCase) {
		delegate.getExportedObjects(type, name, ignoreCase)
	}
	
	override getExportedObjectsByObject(EObject object) {
		delegate.getExportedObjectsByObject(object)
	}
	
	override getExportedObjectsByType(EClass type) {
		delegate.getExportedObjectsByType(type)
	}
	
	override isEmpty() {
		delegate.empty
	}
	
	def static install(Resource it) {
		get ?: if (it instanceof XtextResource) {
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