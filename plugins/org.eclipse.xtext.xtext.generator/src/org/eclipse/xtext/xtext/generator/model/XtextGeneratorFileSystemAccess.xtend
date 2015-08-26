/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model

import com.google.inject.Injector
import org.eclipse.xtext.generator.JavaIoFileSystemAccess

class XtextGeneratorFileSystemAccess extends JavaIoFileSystemAccess implements IXtextGeneratorFileSystemAccess {

	new(String path, boolean overwrite) {
		outputPath = path
		defaultOutput.overrideExistingResources = overwrite
	}

	private def getDefaultOutput() {
		outputConfigurations.values.head
	}

	override initialize(Injector injector) {
		injector.injectMembers(this)
	}

	override getPath() {
		defaultOutput.outputDirectory
	}

	override isOverwrite() {
		defaultOutput.overrideExistingResources
	}

}