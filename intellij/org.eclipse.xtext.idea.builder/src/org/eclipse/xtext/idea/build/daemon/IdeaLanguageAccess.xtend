/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.build.daemon

import java.io.File
import java.util.Set
import org.eclipse.xtext.builder.standalone.LanguageAccess
import org.eclipse.xtext.generator.OutputConfiguration
import org.eclipse.xtext.resource.IResourceServiceProvider

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class IdeaLanguageAccess extends LanguageAccess {

	new(Set<OutputConfiguration> outputConfigurations, IResourceServiceProvider resourceServiceProvider) {
		super(outputConfigurations, resourceServiceProvider, false)
	}

	new(Set<OutputConfiguration> outputConfigurations, IResourceServiceProvider resourceServiceProvider,
		boolean linksAgainstJavaTypes) {
		super(outputConfigurations, resourceServiceProvider, linksAgainstJavaTypes)
	}

	override createFileSystemAccess(File baseDir) {
		resourceServiceProvider.get(BuildDaemonFileSystemAccess) => [
			outputConfigurations = super.createFileSystemAccess(baseDir).outputConfigurations
		]
	}

}