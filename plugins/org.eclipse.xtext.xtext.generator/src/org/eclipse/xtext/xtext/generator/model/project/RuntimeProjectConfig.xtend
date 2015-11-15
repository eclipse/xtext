/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model.project

import com.google.common.base.CharMatcher
import com.google.inject.Injector
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess

/**
 * @noextend
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
		throw new RuntimeException('Could not derive the Ecore model folder from the project configuration. Please make sure that \'root\' is a prefix of \'ecoreModel\'.')
	}
	
	override initialize(Injector injector) {
		super.initialize(injector)
		if (ecoreModelPath !== null) {
			ecoreModel = owner.newFileSystemAccess(ecoreModelPath, true)
			ecoreModel.initialize(injector)
		}
	}

}
