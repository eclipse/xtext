/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.compiler

import com.google.common.base.Charsets
import com.google.common.io.CharStreams
import com.google.inject.Inject
import java.io.InputStreamReader
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResource
import org.eclipse.ui.texteditor.MarkerUtilities
import org.eclipse.xtend.ide.internal.XtendActivator
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil
import org.eclipse.xtext.util.JavaVersion
import org.junit.After
import org.junit.AfterClass
import org.junit.Assert
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*

/**
 * @author Miro Spoenemann - Initial contribution and API
 */
class JavaVersionSettingTest extends Assert {
	
	@Inject 
	private WorkbenchTestHelper workbenchTestHelper;
	
	@Before
	def setUp() throws Exception {
		XtendActivator.getInstance().getInjector("org.eclipse.xtend.core.Xtend").injectMembers(this)
	}
	
	@BeforeClass
	static def setUpProject() throws Exception {
		IResourcesSetupUtil.cleanWorkspace();
	}

	@AfterClass
	static def tearDownProject() throws Exception {
		IResourcesSetupUtil.cleanWorkspace();
	}
	
	@After
	def void tearDown() {
		workbenchTestHelper.tearDown
	}
	
	@Test def void testCompileWithJava5() {
		workbenchTestHelper.tearDown
		WorkbenchTestHelper.createPluginProject(WorkbenchTestHelper.TESTPROJECT_NAME, JavaVersion.JAVA5)
		val xtendFile = workbenchTestHelper.createFile('mypackage/OverrideTest.xtend', '''
			package mypackage
			class B implements A {
				override a() {
				}
			}
			interface A {
				def void a()
			}
		''')
		waitForBuild()
		assertNoErrors(xtendFile)
		val content = getJavaFileContent('xtend-gen/mypackage/B.java', xtendFile.project)
		assertFalse("@Override annotation was generated, but it shouldn't.", content.contains('@Override'))
	}
	
	@Test def void testCompileWithJava6() {
		workbenchTestHelper.tearDown
		WorkbenchTestHelper.createPluginProject(WorkbenchTestHelper.TESTPROJECT_NAME, JavaVersion.JAVA6)
		val xtendFile = workbenchTestHelper.createFile('mypackage/OverrideTest.xtend', '''
			package mypackage
			class B implements A {
				override a() {
				}
			}
			interface A {
				def void a()
			}
		''')
		waitForBuild()
		assertNoErrors(xtendFile)
		val content = getJavaFileContent('xtend-gen/mypackage/B.java', xtendFile.project)
		assertTrue("@Override annotation was not generated.", content.contains('@Override'))
	}
	
	private def getJavaFileContent(String fileName, IProject project) {
		val javaFile = project.getFile(fileName)
		assertTrue("Generated Java file does not exist.", javaFile.exists)
		assertNoErrors(javaFile)
		val javaFileStream = javaFile.contents
		val content = CharStreams.toString(new InputStreamReader(javaFileStream, Charsets.UTF_8))
		javaFileStream.close
		return content
	}
	
	private def void assertNoErrors(IFile file) {
		val findMarkers = file.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE)
		for (iMarker : findMarkers) {
			assertFalse(MarkerUtilities.getMessage(iMarker), MarkerUtilities.getSeverity(iMarker) == IMarker::SEVERITY_ERROR)
		}
	}
	
}