/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.tests.file

import java.util.Set
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.xtext.builder.EclipseOutputConfigurationProvider
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.OutputConfiguration
import org.eclipse.xtext.xbase.ui.file.EclipseWorkspaceConfigProvider
import org.junit.Test

import static org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.*
import static org.junit.Assert.*
import org.eclipse.xtend.lib.macro.file.Path
import org.junit.After
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class EclipseWorkspaceConfigurationTest {
	
	@After
	def void tearDown() {
		IResourcesSetupUtil.cleanWorkspace
	}
	
	@Test def void testConfig() {
		val wsroot = ResourcesPlugin.workspace.root
		for (p : wsroot.projects) {
			p.delete(true, true, null)
		}
		assertEquals(0, wsroot.projects.length)
		
		createJavaProject("projectA")
		
		val provider = new EclipseWorkspaceConfigProvider => [
			workspaceRoot = wsroot
			configurationProvider = new MockEclipseOutputConfiguration([
				#{new OutputConfiguration(IFileSystemAccess.DEFAULT_OUTPUT) => [
					setOutputDirectory("xtend-gen");
					setOverrideExistingResources(true);
					setCreateOutputDirectory(true);
					setCanClearOutputDirectory(false);
					setCleanUpDerivedResources(true);
					setSetDerivedProperty(true);
				]}
			])
		]
		val projectAConfig = provider.get.projects.get("projectA")
		assertEquals(1, projectAConfig.sourceFolderMappings.size)
		val target = projectAConfig.sourceFolderMappings.get(new Path("/projectA/src"))
		assertEquals("/projectA/xtend-gen", target.toString)
	}
}

class MockEclipseOutputConfiguration extends EclipseOutputConfigurationProvider {
	
	var (IProject)=>Set<OutputConfiguration> function
	
	new((IProject)=>Set<OutputConfiguration> function) {
		super(null)
		this.function = function
	}
	
	override getOutputConfigurations(IProject project) {
		return function.apply(project)
	}
	
}