/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import com.google.inject.Injector
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.xtext.generator.model.ManifestAccess
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess
import org.eclipse.xtext.xtext.generator.model.XtextGeneratorFileSystemAccess

@Accessors(PUBLIC_GETTER)
class XtextProjectConfig implements IGuiceAwareGeneratorComponent {
	RuntimeProjectConfig runtime
	BundleProjectConfig runtimeTest
	BundleProjectConfig genericIde
	BundleProjectConfig eclipsePlugin
	BundleProjectConfig eclipsePluginTest
	SubProjectConfig ideaPlugin
	WebProjectConfig web
	
	new() {
		setRuntime(new RuntimeProjectConfig)
		setRuntimeTest(new BundleProjectConfig)
		setGenericIde(new BundleProjectConfig)
		setEclipsePlugin(new BundleProjectConfig)
		setEclipsePluginTest(new BundleProjectConfig)
		setIdeaPlugin(new SubProjectConfig)
		setWeb(new WebProjectConfig)
	}
	
	def void setRuntime(RuntimeProjectConfig config) {
		this.runtime = config
		config.owner = this
	}
	
	def void setRuntimeTest(BundleProjectConfig config) {
		this.runtimeTest = config
		config.owner = this
	}
	
	def void setGenericIde(BundleProjectConfig config) {
		this.genericIde = config
		config.owner = this
	}
	
	def void setEclipsePlugin(BundleProjectConfig config) {
		this.eclipsePlugin = config
		config.owner = this
	}
	
	def void setEclipsePluginTest(BundleProjectConfig config) {
		this.eclipsePluginTest = config
		config.owner = this
	}
	
	def void setIdeaPlugin(SubProjectConfig config) {
		this.ideaPlugin = config
		config.owner = this
	}
	
	def void setWeb(WebProjectConfig config) {
		this.web = config
		config.owner = this
	}
	
	def void checkConfiguration(Issues issues) {
		enabledProjects.forEach[checkConfiguration(issues)]
	}

	def List<? extends SubProjectConfig> getAllProjects() {
		val allProjects = newArrayList
		allProjects += #[
			runtime,
			runtimeTest,
			genericIde,
			eclipsePlugin,
			eclipsePluginTest,
			ideaPlugin,
			web
		]
		allProjects
	}

	def List<? extends SubProjectConfig> getTestProjects() {
		val testProjects = newArrayList
		testProjects += #[
			runtimeTest,
			eclipsePluginTest
		]
		testProjects
	}

	def List<? extends SubProjectConfig> getEnabledProjects() {
		val enabledProjects = newArrayList
		enabledProjects += allProjects.filter[enabled]
		enabledProjects
	}

	override initialize(Injector injector) {
		setDefaults
		injector.injectMembers(this)
		enabledProjects.forEach[initialize(injector)]
	}
	
	def setDefaults() {
		runtime.enabled = true
		if (#[eclipsePlugin, ideaPlugin, web].exists[enabled])
			genericIde.enabled = true
	}
	
	protected def newManifestAccess() {
		new ManifestAccess
	}
	
	protected def newPluginXmlAccess() {
		new PluginXmlAccess
	}
	
	protected def newFileSystemAccess(String path, boolean overWrite) {
		new XtextGeneratorFileSystemAccess(path, overWrite)
	}

}