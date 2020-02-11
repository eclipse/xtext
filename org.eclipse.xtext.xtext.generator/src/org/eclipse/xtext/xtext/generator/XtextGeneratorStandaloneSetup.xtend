/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import com.google.inject.Inject
import com.google.inject.Injector
import org.eclipse.emf.mwe.utils.ProjectMapping
import org.eclipse.emf.mwe.utils.StandaloneSetup
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.util.internal.Log
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig

/**
 * Standalone setup for resolving EMF URIs in the context of the {@link XtextGenerator}. The actual
 * setup is done by {@link StandaloneSetup}.
 */
@Log
class XtextGeneratorStandaloneSetup implements IGuiceAwareGeneratorComponent {
	
	@Inject IXtextProjectConfig projectConfig

	@Accessors boolean scanClasspath = true

	override initialize(Injector injector) {
		injector.injectMembers(this)
		setup()
	}

	private def void setup() {
		val delegate = new StandaloneSetup
		delegate.scanClassPath = scanClasspath
		projectMappings.forEach [ mapping |
			delegate.addProjectMapping(new ProjectMapping => [
				projectName = mapping.key
				path = mapping.value
			])
		]
	}

	private def getProjectMappings() {
		projectConfig.enabledProjects.filter[name !== null && root !== null].map[name -> root.path]
	}
}	
