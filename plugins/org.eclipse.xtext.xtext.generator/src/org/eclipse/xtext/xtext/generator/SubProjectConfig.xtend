/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import com.google.common.base.CharMatcher
import com.google.inject.Injector
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess
import org.eclipse.xtext.xtext.generator.model.ManifestAccess
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess

class SubProjectConfig implements IGuiceAwareGeneratorComponent {
	@Accessors(PUBLIC_GETTER, PACKAGE_SETTER)
	XtextProjectConfig owner
	@Accessors
	boolean enabled
	@Accessors
	String name
	@Accessors(PUBLIC_GETTER)
	IXtextGeneratorFileSystemAccess root
	@Accessors(PUBLIC_GETTER)
	IXtextGeneratorFileSystemAccess metaInf
	@Accessors(PUBLIC_GETTER)
	IXtextGeneratorFileSystemAccess src
	@Accessors(PUBLIC_GETTER)
	IXtextGeneratorFileSystemAccess srcGen
	
	def void setRoot(String path) {
		root = owner.newFileSystemAccess(path, true)
	}

	def void setMetaInf(String path) {
		metaInf = owner.newFileSystemAccess(path, true)
	}

	def void setSrc(String path) {
		src = owner.newFileSystemAccess(path, false)
	}

	def void setSrcGen(String path) {
		srcGen = owner.newFileSystemAccess(path, true)
	}
	
	def void checkConfiguration(Issues issues) {
	}
	
	override initialize(Injector injector) {
		injector.injectMembers(this)
		root?.initialize(injector)
		metaInf?.initialize(injector)
		src?.initialize(injector)
		srcGen?.initialize(injector)
	}
	
}



@Accessors
class BundleProjectConfig extends SubProjectConfig {
	ManifestAccess manifest
	PluginXmlAccess pluginXml
	
	override initialize(Injector injector) {
		super.initialize(injector)
		manifest?.initialize(injector)
		pluginXml?.initialize(injector)
	}
	
	override checkConfiguration(Issues issues) {
		super.checkConfiguration(issues)
		if (manifest !== null && metaInf === null) {
			issues.addError("The 'metaInf' outlet must be configured for projects with a manifest", this)
		}
		if (pluginXml !== null && root === null) {
			issues.addError("The 'root' outlet must be configured for projects with a plugin.xml", this)
		}
	}
	
}


class RuntimeProjectConfig extends BundleProjectConfig {
	@Accessors(PUBLIC_GETTER)
	IXtextGeneratorFileSystemAccess ecoreModel
	
	def void setEcoreModel(String path) {
		ecoreModel = owner.newFileSystemAccess(path, true)
	}
	
	/**
	 * Returns the root-relative path of the folder where the generated .ecore and .genmodel can be found.
	 * The path is delimited by and ends with '/'
	 */
	def String getEcoreModelFolder() {
		val ecoreModelFolder = ecoreModel.path.replace(root.path, "").replace('\\', '/')
		val slashes = CharMatcher.is('/')
		slashes.trimFrom(ecoreModelFolder) + "/"
	}
	
	override initialize(Injector injector) {
		super.initialize(injector)
		ecoreModel?.initialize(injector)
	}

}

class WebProjectConfig extends SubProjectConfig {
	@Accessors(PUBLIC_GETTER)
	IXtextGeneratorFileSystemAccess assets
	
	def void setAssets(String path) {
		assets = owner.newFileSystemAccess(path, true)
	}
	
	override initialize(Injector injector) {
		super.initialize(injector)
		assets?.initialize(injector)
	}
	
}