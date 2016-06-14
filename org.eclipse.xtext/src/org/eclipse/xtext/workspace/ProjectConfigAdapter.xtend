/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.workspace

import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.util.internal.EmfAdaptable

@EmfAdaptable
@Accessors
class ProjectConfigAdapter {
	val IProjectConfig projectConfig
	
	protected new (IProjectConfig projectConfig) {
		this.projectConfig = projectConfig
	}
	
	def static void install(ResourceSet resourceSet, IProjectConfig config) {
		new ProjectConfigAdapter(config).attachToEmfObject(resourceSet)
	}
}
