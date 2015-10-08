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

@Accessors
class XtextProjectConfig implements IGuiceAwareGeneratorComponent {
	RuntimeProjectConfig runtime = new RuntimeProjectConfig
	BundleProjectConfig runtimeTest = new BundleProjectConfig
	BundleProjectConfig genericIde = new BundleProjectConfig
	BundleProjectConfig eclipsePlugin = new BundleProjectConfig
	BundleProjectConfig eclipsePluginTest = new BundleProjectConfig
	SubProjectConfig ideaPlugin = new SubProjectConfig
	WebProjectConfig web = new WebProjectConfig
	
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

}