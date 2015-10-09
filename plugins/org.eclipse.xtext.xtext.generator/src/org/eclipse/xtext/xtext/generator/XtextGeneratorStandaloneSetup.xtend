/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import com.google.inject.Inject
import com.google.inject.Injector
import org.eclipse.emf.mwe.utils.ProjectMapping
import org.eclipse.emf.mwe.utils.StandaloneSetup
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.util.internal.Log

@Log
class XtextGeneratorStandaloneSetup implements IGuiceAwareGeneratorComponent {
	@Inject XtextProjectConfig projectConfig

	@Accessors boolean scanClasspath = true

	override initialize(Injector injector) {
		injector.injectMembers(this)
		setup
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
		projectConfig.enabledProjects.filter[name != null && root != null].map[name -> root.path]
	}
}	
