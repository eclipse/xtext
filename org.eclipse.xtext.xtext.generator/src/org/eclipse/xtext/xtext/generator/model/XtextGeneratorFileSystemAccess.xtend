/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model

import com.google.inject.Injector
import org.eclipse.xtext.generator.JavaIoFileSystemAccess

class XtextGeneratorFileSystemAccess extends JavaIoFileSystemAccess implements IXtextGeneratorFileSystemAccess {

	new(String path, boolean overwrite) {
		outputPath = path.removeTrailingPathSeparator
		defaultOutput.overrideExistingResources = overwrite
	}
	
	private def String removeTrailingPathSeparator(String s) {
		if (s.endsWith('/')) s.substring(0, s.length - 1) else s
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