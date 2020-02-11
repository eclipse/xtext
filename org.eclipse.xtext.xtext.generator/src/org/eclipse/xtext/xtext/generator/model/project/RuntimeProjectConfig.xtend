/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model.project

import com.google.common.base.CharMatcher
import com.google.inject.Injector
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess

/**
 * Configuration of the runtime project, i.e. the main subproject containing the language definition.
 * 
 * @noextend This class should not be extended by clients.
 */
class RuntimeProjectConfig extends BundleProjectConfig implements IRuntimeProjectConfig {
	@Accessors(PUBLIC_GETTER)
	String ecoreModelPath
	@Accessors(PUBLIC_GETTER)
	IXtextGeneratorFileSystemAccess ecoreModel
	
	def void setEcoreModel(String path) {
		ecoreModelPath = path
	}
	
	/**
	 * Returns the root-relative path of the folder where the generated .ecore and .genmodel can be found.
	 * The path is delimited by '/', but does not begin or end with a separator.
	 */
	override String getEcoreModelFolder() {
		if (ecoreModel.path.startsWith(root.path)) {
			val relativePath = ecoreModel.path.substring(root.path.length).replace('\\', '/')
			return CharMatcher.is('/').trimFrom(relativePath)
		}
		throw new RuntimeException('''
			Could not derive the Ecore model folder from the project configuration. 
			Please make sure that 'root' is a prefix of 'ecoreModel'.
			was (root='«root.path»', ecoreModel='«ecoreModel.path»')
			
		''')
	}
	
	override initialize(Injector injector) {
		super.initialize(injector)
		if (ecoreModelPath !== null) {
			ecoreModel = owner.newFileSystemAccess(ecoreModelPath, true)
			ecoreModel.initialize(injector)
		}
	}
	
	override getXbaseLibVersionLowerBound() {
		"2.14.0"
	}

	override getXtendLibVersionLowerBound() {
		return getXbaseLibVersionLowerBound()
	}

}
