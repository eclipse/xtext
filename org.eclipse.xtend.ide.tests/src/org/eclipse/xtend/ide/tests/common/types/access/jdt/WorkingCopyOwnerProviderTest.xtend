/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.common.types.access.jdt

import com.google.inject.Inject
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.eclipse.xtext.common.types.access.jdt.WorkingCopyOwnerProvider
import org.eclipse.core.resources.IProject
import static org.eclipse.xtend.ide.tests.WorkbenchTestHelper.*
import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*
import org.eclipse.jdt.core.JavaCore

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class WorkingCopyOwnerProviderTest extends AbstractXtendUITestCase {

	@Inject WorkingCopyOwnerProvider workingCopyOwnerProvider
	@Inject WorkbenchTestHelper workbenchTestHelper
	
	IProject unrelatedProject
	
	@After def void cleanUp() {
		unrelatedProject.delete(true, true, null)
		workbenchTestHelper.tearDown
	}
	
	@Before override void setUp() {
		super.setUp
		unrelatedProject = createPluginProject("unrelated")
	}
	
	@Test def void testWorkingCopyOwner_01() {
		val file = unrelatedProject.getFile("src/foo/MyClass.xtend")
		createFile(file.fullPath, '''
			package foo
			class MyClass {
				
			}
		''')
		waitForBuild
		assertNull("no source expected as, xtend file is in unrelated project", newWorkingCopyOwner.findSource('MyClass','foo'))
	}
	
	@Test def void testWorkingCopyOwner_02() {
		workbenchTestHelper.createFile("foo/MyClass.xtend", '''
			package foo
			class MyClass {
				
			}
		''')
		waitForBuild
		assertEquals('''
			package foo;
			public class MyClass{
			}'''.toString,newWorkingCopyOwner.findSource('MyClass','foo'))
	}
	
	protected def newWorkingCopyOwner() {
		workingCopyOwnerProvider.getWorkingCopyOwner(JavaCore.create(workbenchTestHelper.project), workbenchTestHelper.resourceSet)
	} 
}