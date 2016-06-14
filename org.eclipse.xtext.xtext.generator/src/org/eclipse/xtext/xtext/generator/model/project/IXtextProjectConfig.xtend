/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model.project

import java.util.List
import org.eclipse.xtext.xtext.generator.IGuiceAwareGeneratorComponent

/**
 * @noimplement
 */
interface IXtextProjectConfig extends IGuiceAwareGeneratorComponent {
	def IRuntimeProjectConfig getRuntime()
	def IBundleProjectConfig getRuntimeTest()
	def IBundleProjectConfig getGenericIde()
	def IBundleProjectConfig getEclipsePlugin()
	def IBundleProjectConfig getEclipsePluginTest()
	def ISubProjectConfig getIdeaPlugin()
	def IWebProjectConfig getWeb()
	def List<? extends ISubProjectConfig> getEnabledProjects()
	def List<? extends ISubProjectConfig> getTestProjects()
}