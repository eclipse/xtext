/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.resource

import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.LibraryOrderEntry
import com.intellij.openapi.roots.ModuleOrderEntry
import com.intellij.openapi.roots.ModuleRootManager
import org.eclipse.xtext.builder.standalone.incremental.ProjectDescription

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class ProjectDescriptionProvider {
	
	def ProjectDescription getProjectDescription(Object module) {
		if (module instanceof Module) {
			return new ProjectDescription => [
				name = module.name
				val enumerator = ModuleRootManager.getInstance(module).getOrderEntries;
				val dependencyNames = newArrayList
				enumerator.forEach[
					switch it {
						LibraryOrderEntry : {
							dependencyNames += libraryName
						}
						ModuleOrderEntry : {
							dependencyNames += moduleName
						}
					}
				]
				dependencies = dependencyNames
			]
		}
		throw new IllegalArgumentException("Cannot create project description from "+module)
	}
}