/*******************************************************************************
 * Copyright (c) 2013, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.macros

import com.google.inject.Inject
import com.google.inject.Provider
import java.util.Set
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.core.macro.AbstractFileSystemSupport
import org.eclipse.xtend.ide.macro.EclipseFileSystemSupportImpl
import org.eclipse.xtend.ide.tests.XtendIDEInjectorProvider
import org.eclipse.xtend.lib.macro.file.Path
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.resource.IResourceSetProvider
import org.junit.After
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(XtendIDEInjectorProvider)
class EclipseFileSystemTest extends JavaIoFileSystemTest {

	Set<String> knownProjects = newHashSet
	
	@Inject IResourceSetProvider resourceSetProvider
	
	@Inject Provider<EclipseFileSystemSupportImpl> fileSystemSupportProvider

	@Before override void setUp() {
		for(p: ResourcesPlugin.workspace.root.projects) {
			knownProjects.add(p.name)
		}
		
		val project = createProject('foo')
		val fileSystemSupport = fileSystemSupportProvider.get
		fileSystemSupport.context = resourceSetProvider.get(project)  
		fs = fileSystemSupport
	}
	
	override IProject createProject(String name) {
		val root = ResourcesPlugin.workspace.root
		val project = root.getProject(name)
		if (project.exists) {
			fail("Project 'foo' should not exist yet")
		}
		project.create(null)
		project.open(null)
		project
	}
	
	@After def void tearDown() {
		val root = ResourcesPlugin.workspace.root
		for(p: root.projects) {
			if (!knownProjects.remove(p.name)) {
				p.delete(true, null)
			}
		}
		assertTrue(knownProjects.empty)
	}
	
	@Test
	@Ignore('PlatformResourceURIHandlerImpl does not allow to delete folders')
	override testMakeAndDeleteFolder() {
		super.testMakeAndDeleteFolder()
	}

	// overridden to make the launch config work.
	@Test override testMakeAndDeleteFile() {
		super.testMakeAndDeleteFile()
	}

	@Test def void testGetURIForImportedProject() {
		val ws = ResourcesPlugin.workspace
		val root = ws.root

		val description = ws.newProjectDescription("bar")
		description.location = root.location.append('foo/bar')

		val project = root.getProject('bar')
		project.create(description, null)
		project.open(null)

		val file = new Path("/bar/Foo.text")
		assertFalse(file.exists)
		assertNull(file.toURI)
		
		try {
			file.contents = "Hello Foo"
			fail()
		} catch (IllegalArgumentException e) {
			// expected
		}
		assertFalse(file.exists)
	}
	
	@Test def void testIssue383() {
		if (fs instanceof AbstractFileSystemSupport) {
			val afs = fs
			val px = createProject("px")
			createProject("py")
			val rs = resourceSetProvider.get(px)
			val rx = rs.createResource(URI.createPlatformResourceURI("px/foo/xxxx", true))
			val rxb = rs.createResource(URI.createPlatformResourceURI("px/bar/yyyy", true))
			val ry = rs.createResource(URI.createPlatformResourceURI("py/bar/xxxx", true))
			var pathx = afs.getPath(rx)
			assertEquals("/px/foo/xxxx", pathx.toString)
			var pathxb = afs.getPath(rxb)
			assertEquals("/px/bar/yyyy", pathxb.toString)
			var pathy = afs.getPath(ry)
			assertEquals("/py/bar/xxxx", pathy.toString)
			
		} else {
			fail("fs is no AbstractFileSystemSupport")
		}
	}

}
