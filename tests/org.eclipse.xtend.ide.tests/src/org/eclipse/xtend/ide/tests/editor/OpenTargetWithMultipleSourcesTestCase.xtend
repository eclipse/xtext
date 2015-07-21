/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.editor

import com.google.inject.Inject
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.Path
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.junit.After
import org.junit.Before
import org.junit.Test

import static org.eclipse.xtend.ide.tests.WorkbenchTestHelper.*
import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class OpenTargetWithMultipleSourcesTestCase extends AbstractXtendUITestCase {

	@Inject
	extension WorkbenchTestHelper
	
	IProject testProject

	@Test def void testOpenTargetSourceTwice() {
		val childFile = file('testProject/xtend-gen/mypackage/B.java') as IFile
		assertEquals(childFile.openEditor, childFile.openEditor)
	}

	@Test def void testOpenTargetSourceWithOpenedParentSource() {
		val parenFile = file('testProject/xtend-gen/mypackage/A.java') as IFile
		val childFile = file('testProject/xtend-gen/mypackage/B.java') as IFile
		assertNotSame(parenFile.openEditor, childFile.openEditor)
	}
	
	@Before override setUp() throws Exception {
		super.setUp()
		testProject = createPluginProject('testProject')
		createFile(new Path('testProject/src/mypackage/A.xtend'),
			'''
				package mypackage; 
				class A {
				
					def dispatch foo(Object it) {}
				
					def dispatch foo(Void it) {}
				
				}
			''')
		createFile(new Path('testProject/src/mypackage/B.xtend'),
			'''
				package mypackage; 
				class B extends A {
				
					def dispatch foo(String it) {}
				
				}
			''')
		waitForBuild
	}

	@After override tearDown() throws Exception {
		deleteProject(testProject)
		testProject = null
	}
	
}
