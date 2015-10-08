/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import org.eclipse.emf.mwe2.runtime.Mandatory
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.xtext.generator.model.ManifestAccess
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess

@Accessors
class WizardConfig extends XtextProjectConfig {

	boolean mavenLayout
	boolean createEclipseMetaData
	String rootPath
	String baseName

	@Mandatory
	def setBaseName(String baseName) {
		this.baseName = baseName
	}

	@Mandatory
	def setRootPath(String rootPath) {
		this.rootPath = rootPath
	}
	
	override checkConfiguration(Issues issues) {
		super.checkConfiguration(issues)
		if (rootPath === null)
			issues.addError("The property 'rootPath' must be set", this)
		if (baseName === null)
			issues.addError("The property 'baseName' must be set", this)
	}

	override setDefaults() {
		super.setDefaults
		enabledProjects.forEach [
			if (name === null)
				name = computeName
			if (root === null)
				root = computeRoot
			if (metaInf === null)
				metaInf = computeMetaInf
			if (src === null)
				src = computeSrc
			if (srcGen === null)
				srcGen = computeSrcGen
			if (it instanceof BundleProjectConfig) {
				if (createEclipseMetaData) {
					if (manifest === null)
						manifest = new ManifestAccess
					if (pluginXml === null)
						pluginXml = new PluginXmlAccess
				}
			}
			if (it instanceof RuntimeProjectConfig) {
				if (ecoreModel === null)
					ecoreModel = computeEcoreModel
			}
			if (it instanceof WebProjectConfig) {
				if (assets === null)
					assets = computeAssets
			}
		]
	}

	protected def computeName(SubProjectConfig project) {
		switch project {
			case runtime: baseName
			case runtimeTest: baseName + '.tests'
			case genericIde: baseName + '.ide'
			case eclipsePlugin: baseName + '.ui'
			case eclipsePluginTest: baseName + '.ui.tests'
			case ideaPlugin: baseName + '.idea'
			case web: baseName + '.web'
		}
	}

	protected def computeRoot(SubProjectConfig project) {
		rootPath + '/' + project.name
	}

	protected def computeSrc(SubProjectConfig project) {
		project.root.path + '/' + if(mavenLayout) 'src/' + project.computeSourceSet + '/java' else 'src'
	}

	protected def computeSrcGen(SubProjectConfig project) {
		project.root.path + '/' + if(mavenLayout) 'src/' + project.computeSourceSet + '/xtext-gen' else 'src-gen'
	}

	protected def computeMetaInf(SubProjectConfig project) {
		project.root.path + '/' + if(mavenLayout) 'src/' + project.computeSourceSet + '/resources/META-INF' else 'META-INF'
	}

	protected def computeEcoreModel(RuntimeProjectConfig project) {
		project.root.path + '/' + if(mavenLayout) 'src/' + project.computeSourceSet + '/ecore/generated' else 'model/generated'
	}

	protected def computeAssets(WebProjectConfig project) {
		project.root.path + '/' + if(mavenLayout) 'src/' + project.computeSourceSet + '/webapp' else 'WebRoot'
	}

	protected def computeSourceSet(SubProjectConfig project) {
		if(testProjects.contains(project)) 'test' else 'main'
	}

}