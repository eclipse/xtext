/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.tests.file

import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.xbase.tests.file.JavaIoFileSystemTest
import org.eclipse.xtext.xbase.ui.file.EclipseFileSystemSupportImpl
import org.junit.Before
import org.junit.Test

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class EclipseFileSystemTest extends JavaIoFileSystemTest {
	
	@Before override void setUp() {
		val root = ResourcesPlugin.workspace.root
		val project = root.getProject('foo')
		if (project.exists) {
			project.delete(true, null)
		}
		project.create(null)
		project.open(null)
		fs = new EclipseFileSystemSupportImpl => [
			workspaceRoot = root
			encodingProvider = new IEncodingProvider.Runtime()
		]
	}
	
	// overridden to make the launch config work.
	@Test override testMakeandDeleteFile() {
		super.testMakeandDeleteFile()
	}
	
}