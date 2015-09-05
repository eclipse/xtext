/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.macro

import com.google.inject.Inject
import com.intellij.testFramework.PsiTestCase
import java.io.IOException
import org.eclipse.xtend.core.idea.lang.XtendLanguage
import org.eclipse.xtend.core.idea.macro.IdeaFileSystemSupport
import org.eclipse.xtend.core.tests.macro.JavaIoFileSystemTest
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport
import org.eclipse.xtend.lib.macro.file.Path
import org.eclipse.xtext.idea.resource.IdeaResourceSetProvider
import org.eclipse.xtext.idea.tests.TestDecorator

import static extension com.intellij.openapi.roots.ModuleRootModificationUtil.*
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

/**
 * @author kosyakov - Initial contribution and API
 */
@TestDecorator
class IdeaFileSystemTest extends PsiTestCase {

	@Inject IdeaResourceSetProvider ideaResourceSetProvider

	val Delegate delegate = new Delegate(this)

	override protected setUp() throws Exception {
		super.setUp()
		XtendLanguage.INSTANCE.injectMembers(this)
		delegate.fileSystemSupport = new IdeaFileSystemSupport => [
			context = ideaResourceSetProvider.get(module)
		]
	}

	override protected createMainModule() throws IOException {
		createModule('foo')
	}

	override protected createModule(String moduleName) {
		val moduleDir = project.baseDir.createChildDirectory(moduleName)
		val srcDir = moduleDir.createChildDirectory('src')

		val module = super.createModule(moduleName)
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

		override testGetWorkspaceChildren() {
			assertEquals(Path.ROOT.children.join('[', ', ', ']')[it.segments.join('.')], 1, Path.ROOT.children.size)

			createModule('bar')

			assertEquals(Path.ROOT.children.join('[', ', ', ']')[it.segments.join('.')], 2, Path.ROOT.children.size)
		}

	}

}