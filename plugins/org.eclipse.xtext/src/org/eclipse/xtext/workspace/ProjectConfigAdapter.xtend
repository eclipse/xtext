/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.workspace

import org.eclipse.xtext.util.internal.EmfAdaptable
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.emf.ecore.resource.ResourceSet

@EmfAdaptable
@Data
class ProjectConfigAdapter {
	IProjectConfig projectConfig
	
	def static void install(ResourceSet resourceSet, IProjectConfig config) {
		new ProjectConfigAdapter(config).attachToEmfObject(resourceSet)
	}
}
