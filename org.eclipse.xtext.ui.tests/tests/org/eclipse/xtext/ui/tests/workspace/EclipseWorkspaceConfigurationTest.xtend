/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.workspace

import com.google.inject.Inject
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil
import org.eclipse.xtext.ui.tests.Activator
import org.eclipse.xtext.ui.workspace.EclipseProjectConfigProvider
import org.junit.After
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.*
import static org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.*

class EclipseWorkspaceConfigurationTest {
	
	@Inject EclipseProjectConfigProvider projectConfigProvider 
	
	@Before
	def void setup() {
		val injector = Activator.getInstance.getInjector(
			Activator.ORG_ECLIPSE_XTEXT_UI_TESTS_EDITOR_CONTENTASSIST_DOMAINMODELTESTLANGUAGE)
		injector.injectMembers(this)
	}
	
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
		
		val project = createJavaProject("projectA")
		createJavaProject("projectB")
		
		val projectConfig = projectConfigProvider.createProjectConfig(project.project)
		assertNotNull(projectConfig)
		assertNotNull(projectConfig.workspaceConfig.findProjectByName('projectB'))
	}
}