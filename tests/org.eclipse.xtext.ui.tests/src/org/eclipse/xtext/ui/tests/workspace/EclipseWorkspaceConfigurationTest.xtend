/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.workspace

import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil
import org.eclipse.xtext.ui.workspace.EclipseWorkspaceConfigProvider
import org.junit.After
import org.junit.Test

import static org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.*
import static org.junit.Assert.*

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
			workspace = ResourcesPlugin.workspace
		]
		val project = provider.getWorkspaceConfig(null).findProjectByName("projectA")
		assertNotNull(project)
		
	}
}
