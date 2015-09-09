/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.macro

import com.google.inject.Inject
import com.google.inject.Provider
import com.intellij.testFramework.PsiTestCase
import java.io.IOException
import org.eclipse.xtend.core.idea.lang.XtendLanguage
import org.eclipse.xtend.core.idea.macro.IdeaFileSystemSupport
import org.eclipse.xtend.core.tests.macro.JavaIoFileSystemTest
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport
import org.eclipse.xtend.lib.macro.file.Path
import org.eclipse.xtext.idea.resource.IdeaResourceSetProvider
import org.eclipse.xtext.idea.resource.IdeaResourceSetProvider.VirtualFileBasedUriHandler
import org.eclipse.xtext.idea.tests.TestDecorator
import org.eclipse.xtext.resource.XtextResourceSet

import static extension com.intellij.openapi.roots.ModuleRootModificationUtil.*

/**
 * @author kosyakov - Initial contribution and API
 */
@TestDecorator
class IdeaFileSystemTest extends PsiTestCase {

	@Inject IdeaResourceSetProvider ideaResourceSetProvider
	
	@Inject Provider<IdeaFileSystemSupport> fileSystemSupportProvider

	val Delegate delegate = new Delegate(this)
	
	XtextResourceSet resourceSet

	override protected setUp() throws Exception {
		super.setUp()
		XtendLanguage.INSTANCE.injectMembers(this)
		resourceSet = ideaResourceSetProvider.get(module)
		val fileSystemSupport = fileSystemSupportProvider.get
		fileSystemSupport.context = resourceSet
		delegate.fileSystemSupport = fileSystemSupport
	}

	override protected createMainModule() throws IOException {
		createModule('foo')
	}

	override protected createModule(String moduleName) {
		val module = super.createModule(moduleName)
		val moduleDir = createChildDirectory(project.baseDir, moduleName)
		val srcDir = createChildDirectory(moduleDir, 'src')
		module.updateModel [ rootModel |
			val contentEntry = rootModel.addContentEntry(moduleDir)
			contentEntry.addSourceFolder(srcDir, false)
		]
		module
	}

	@FinalFieldsConstructor
	private static class Delegate extends JavaIoFileSystemTest {
		
		val extension IdeaFileSystemTest

		def void setFileSystemSupport(MutableFileSystemSupport fileSystemSupport) {
			fs = fileSystemSupport
		}
		
		override protected createProject(String name) {
			createModule(name)
		}
		
		override assertToURI(Path file, String expectedContent) {
			VirtualFileBasedUriHandler.find(resourceSet).flushToDisk
			super.assertToURI(file, expectedContent)
		}

	}

}