/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.resource

import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.idea.build.XtextCompilerComponent

/**
 * 
 */
class IdeaResourceDescriptionsProvider extends ResourceDescriptionsProvider {
	
	override getResourceDescriptions(Resource resource) {
		getResourceDescriptions(resource.resourceSet)
	}
	
	override getResourceDescriptions(ResourceSet resourceSet) {
		val module = ModuleProvider.findModule(resourceSet)
		val compiler = module.project.getComponent(XtextCompilerComponent)
		return compiler.getResourceDescriptions()
	}
	
}