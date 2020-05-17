/*******************************************************************************
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model.project

import com.google.inject.Injector
import java.util.List
import javax.inject.Inject
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.xtext.generator.CodeConfig
import org.eclipse.xtext.xtext.generator.Issues
import org.eclipse.xtext.xtext.generator.model.ManifestAccess
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess
import org.eclipse.xtext.xtext.generator.model.XtextGeneratorFileSystemAccess

/**
 * Configuration of the subprojects for one or more Xtext languages. If the standard project names
 * and layout is sufficient, use {@link StandardProjectConfig}.
 * 
 * @noextend This class should not be extended by clients.
 */
@Accessors
class XtextProjectConfig implements IXtextProjectConfig {
	
	RuntimeProjectConfig runtime = new RuntimeProjectConfig
	
	BundleProjectConfig runtimeTest = new BundleProjectConfig
	
	BundleProjectConfig genericIde = new BundleProjectConfig
	
	BundleProjectConfig eclipsePlugin = new BundleProjectConfig
	
	BundleProjectConfig eclipsePluginTest = new BundleProjectConfig
	
	WebProjectConfig web = new WebProjectConfig
	
	@Inject CodeConfig codeConfig
	
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
			web
		]
		allProjects
	}

	override List<? extends SubProjectConfig> getTestProjects() {
		val testProjects = newArrayList
		testProjects += #[
			runtimeTest,
			eclipsePluginTest
		]
		testProjects
	}

	override List<? extends SubProjectConfig> getEnabledProjects() {
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
		if (#[eclipsePlugin, web].exists[enabled])
			genericIde.enabled = true
	}
	
	protected def newManifestAccess() {
		new ManifestAccess => [lineDelimiter = codeConfig.lineDelimiter]
	}
	
	protected def newPluginXmlAccess() {
		new PluginXmlAccess
	}
	
	protected def newFileSystemAccess(String path, boolean overWrite) {
		new XtextGeneratorFileSystemAccess(path, overWrite)
	}

}
