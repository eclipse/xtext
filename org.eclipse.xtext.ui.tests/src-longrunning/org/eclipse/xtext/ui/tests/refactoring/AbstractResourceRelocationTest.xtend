/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring

import java.io.ByteArrayOutputStream
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.IncrementalProjectBuilder
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.ltk.core.refactoring.RefactoringDescriptor
import org.eclipse.ltk.core.refactoring.RefactoringStatus
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testlanguages.fileAware.ui.tests.FileAwareTestLanguageUiInjectorProvider
import org.eclipse.xtext.ui.XtextProjectHelper
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith

import static org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.*
import static org.junit.Assert.*

/**
 * @author koehnlein - Initial contribution and API
 */
@InjectWith(FileAwareTestLanguageUiInjectorProvider)
@RunWith(XtextRunner)
abstract class AbstractResourceRelocationTest {
	
	protected IProject project
	
	@Before
	def void setup() {
		autobuild = false
		project = createProject('test')
		addNature(project, XtextProjectHelper.NATURE_ID)
		addBuilder(project, XtextProjectHelper.BUILDER_ID)
	}
	
	@After
	def void teardown() {
		project.delete(true, true, new NullProgressMonitor)
		autobuild = true
	}
	
	protected def file(String name, CharSequence content) {
		createFile(project.name + '/' + name, content.toString)
	}
	
	protected def folder(String name) {
		createFolder(project.name + '/' + name)
	}
	
	protected def assertFileContents(String filePath, String expected) {
		val file = project.findMember(filePath) as IFile
		assertTrue(file.exists)
		val buffer = new ByteArrayOutputStream
		val array = newByteArrayOfSize(2048)
		var bytesRead = 0
		val inp = file.contents
		while((bytesRead = inp.read(array)) !== -1) {
			buffer.write(array, 0, bytesRead)
		}
		inp.close
		val text = new String(buffer.toByteArray, file.charset)
		assertEquals(expected, text)
	}
	
	protected def performRefactoring(RefactoringDescriptor descriptor) {
		performRefactoring(descriptor, new NullProgressMonitor)
	}
	
	protected def performRefactoring(RefactoringDescriptor descriptor, IProgressMonitor monitor) {
		project.refreshLocal(IResource.DEPTH_INFINITE, null)
		project.build(IncrementalProjectBuilder.FULL_BUILD, null)
		val status = new RefactoringStatus
		val refactoring = descriptor.createRefactoring(status)
		refactoring.checkAllConditions(monitor)
		assertTrue(status.OK)
		val change = refactoring.createChange(monitor)
		change.perform(monitor)
		project.refreshLocal(IResource.DEPTH_INFINITE, null)
		project.build(IncrementalProjectBuilder.FULL_BUILD, null)
	}
	
}