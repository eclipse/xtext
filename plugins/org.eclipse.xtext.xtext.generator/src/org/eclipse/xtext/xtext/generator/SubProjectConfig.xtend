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
import com.google.inject.Inject

interface ISubProjectConfig extends IGuiceAwareGeneratorComponent {
	def String getName()
	def IXtextGeneratorFileSystemAccess getRoot()
	def IXtextGeneratorFileSystemAccess getMetaInf()
	def IXtextGeneratorFileSystemAccess getSrc()
	def IXtextGeneratorFileSystemAccess getSrcGen()
}

interface IBundleProjectConfig extends ISubProjectConfig {
	def ManifestAccess getManifest()
	def PluginXmlAccess getPluginXml()
}

interface IRuntimeProjectConfig extends IBundleProjectConfig {
	def IXtextGeneratorFileSystemAccess getEcoreModel()
	def String getEcoreModelFolder()
}

interface IWebProjectConfig extends ISubProjectConfig {
	def IXtextGeneratorFileSystemAccess getAssets()
}

class SubProjectConfig implements ISubProjectConfig {
	@Inject
	@Accessors(PUBLIC_GETTER)
	XtextProjectConfig owner
	
	@Accessors
	boolean enabled
	
	@Accessors
	String name
	
	@Accessors(PUBLIC_GETTER)
	String rootPath
	
	@Accessors(PUBLIC_GETTER)
	IXtextGeneratorFileSystemAccess root
	
	@Accessors(PUBLIC_GETTER)
	String metaInfPath
	
	@Accessors(PUBLIC_GETTER)
	IXtextGeneratorFileSystemAccess metaInf
	
	@Accessors(PUBLIC_GETTER)
	String srcPath
	
	@Accessors(PUBLIC_GETTER)
	IXtextGeneratorFileSystemAccess src
	
	@Accessors(PUBLIC_GETTER)
	String srcGenPath
	
	@Accessors(PUBLIC_GETTER)
	IXtextGeneratorFileSystemAccess srcGen
	
	def void setRoot(String path) {
		rootPath = path
	}

	def void setMetaInf(String path) {
		metaInfPath = path
	}

	def void setSrc(String path) {
		srcPath = path
	}

	def void setSrcGen(String path) {
		srcGenPath = path
	}
	
	def void checkConfiguration(Issues issues) {
	}
	
	override initialize(Injector injector) {
		injector.injectMembers(this)
		if (rootPath !== null) {
			root = owner.newFileSystemAccess(rootPath, true)
			root.initialize(injector)
		}
		if (metaInfPath !== null) {
			metaInf = owner.newFileSystemAccess(metaInfPath, true)
			metaInf.initialize(injector)
		}
		if (srcPath !== null) {
			src = owner.newFileSystemAccess(srcPath, false)
			src.initialize(injector)
		}
		if (srcGenPath !== null) {
			srcGen = owner.newFileSystemAccess(srcGenPath, true)
			srcGen.initialize(injector)
		}
	}
	
}



@Accessors
class BundleProjectConfig extends SubProjectConfig implements IBundleProjectConfig{
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

class WebProjectConfig extends SubProjectConfig implements IWebProjectConfig {
	@Accessors(PUBLIC_GETTER)
	String assetsPath
	@Accessors(PUBLIC_GETTER)
	IXtextGeneratorFileSystemAccess assets
	
	def void setAssets(String path) {
		assetsPath = path
	}
	
	override initialize(Injector injector) {
		super.initialize(injector)
		if (assetsPath !== null) {
			assets = owner.newFileSystemAccess(assetsPath, true)
			assets.initialize(injector)
		}
	}
}