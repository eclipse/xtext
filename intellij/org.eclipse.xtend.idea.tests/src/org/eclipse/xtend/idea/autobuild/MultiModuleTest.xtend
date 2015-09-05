/*******************************************************************************

 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.autobuild

import com.google.common.io.CharStreams
import com.google.inject.Provider
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleManager
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.openapi.roots.ModuleRootModificationUtil
import com.intellij.openapi.roots.impl.ModifiableModelCommitter
import com.intellij.openapi.roots.ui.configuration.actions.ModuleDeleteProvider
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.testFramework.PsiTestCase
import java.io.InputStreamReader
import org.eclipse.xtend.core.idea.lang.XtendLanguage
import org.eclipse.xtext.idea.build.XtextAutoBuilderComponent
import org.eclipse.xtext.idea.tests.LightToolingTest
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class MultiModuleTest extends PsiTestCase {

	def void testTwoModulesWithDependency() {
		val moduleA = createModule('moduleA')
		val moduleB = createModule('moduleB')
		ModuleRootModificationUtil.addDependency(moduleB, moduleA)

		val referencing = createFile(moduleB, "OtherClass.xtend", '''
			class OtherClass extends MyClass {
			}
		''')

		val referenced = createFile(moduleA, "MyClass.xtend", '''
			class MyClass {
			}
		''')
		val generatedReferencing = referencing.virtualFile?.parent?.findChild('xtend-gen')?.findChild('OtherClass.java')
		val generatedReferenced = referenced.virtualFile?.parent?.findChild('xtend-gen')?.findChild('MyClass.java')
		assertNotNull(generatedReferencing)
		assertNotNull(generatedReferenced)
		assertNull(referenced.virtualFile.parent.findChild('xtend-gen').findChild('OtherClass.java'))

		assertFileContains(generatedReferencing, '''
			public class OtherClass extends MyClass {
			}
		''')

		assertFileContains(generatedReferenced, '''
			public class MyClass {
			}
		''')
	}

	def void testTwoModulesWithoutDependency() {
		val moduleA = createModule('moduleA')
		val moduleB = createModule('moduleB')
		println("Module basedir" + project.baseDir)

		val referencing = createFile(moduleB, "OtherClass.xtend", '''
			class OtherClass extends MyClass {
			}
		''')

		val referenced = createFile(moduleA, "MyClass.xtend", '''
			class MyClass {
			}
		''')
		val Provider<VirtualFile> generatedReferencing = [
			referencing.virtualFile.parent.findChild('xtend-gen').findChild('OtherClass.java')
		]
		val Provider<VirtualFile> generatedReferenced = [
			referenced.virtualFile.parent.findChild('xtend-gen').findChild('MyClass.java')
		]
		assertNotNull(generatedReferencing.get)
		assertNotNull(generatedReferenced.get)
		assertNull(referenced.virtualFile.parent.findChild('xtend-gen').findChild('OtherClass.java'))

		assertFileContains(generatedReferencing.get, '''
			public class OtherClass /* implements MyClass  */{
			}
		''')

		assertFileContains(generatedReferenced.get, '''
			public class MyClass {
			}
		''')

		ModuleRootModificationUtil.addDependency(moduleB, moduleA)

		assertFileContains(generatedReferencing.get, '''
			public class OtherClass extends MyClass {
			}
		''')

		assertFileContains(generatedReferenced.get, '''
			public class MyClass {
			}
		''')
	}

	def void testDeleteModuleWithDependency() {
		val moduleA = createModule('moduleA')
		val moduleB = createModule('moduleB')
		ModuleRootModificationUtil.addDependency(moduleB, moduleA)

		val referencing = createFile(moduleB, "OtherClass.xtend", '''
			class OtherClass extends MyClass {
			}
		''')

		val referenced = createFile(moduleA, "MyClass.xtend", '''
			class MyClass {
			}
		''')
		val generatedReferencing = referencing.virtualFile?.parent?.findChild('xtend-gen')?.findChild('OtherClass.java')
		val generatedReferenced = referenced.virtualFile?.parent?.findChild('xtend-gen')?.findChild('MyClass.java')
		assertNotNull(generatedReferencing)
		assertNotNull(generatedReferenced)

		ApplicationManager.application.runWriteAction [
			val modifiableModel = ModuleRootManager.getInstance(moduleA).getModifiableModel()
			val moduleManager = ModuleManager.getInstance(project)
			val modifiableModuleModel = moduleManager.getModifiableModel()
			val otherModules = #[]
			ModuleDeleteProvider.removeModule(moduleA, modifiableModel, otherModules, modifiableModuleModel)
			ModifiableModelCommitter.multiCommit(otherModules, modifiableModuleModel)
			return
		]

		assertTrue(index.allResourceDescriptions.exists[it.URI.toFileString.endsWith("OtherClass.xtend")])
		assertFalse("Deleted module file removed from index", index.allResourceDescriptions.exists [
			it.URI.toFileString.endsWith("MyClass.xtend")
		])
	}

	def assertFileContains(VirtualFile file, String string) {
		val result = CharStreams.toString(new InputStreamReader(file.inputStream))
		assertEquals(string, result)
	}

	override protected Module createModule(String moduleName) {
		val module = super.createModule(moduleName)
		LightToolingTest.addFacetToModule(module, XtendLanguage.INSTANCE.ID)
		return module;
	}

	protected def getIndex() {
		val rs = new XtextResourceSet()
		builder.installCopyOfResourceDescriptions(rs)
		val index = ChunkedResourceDescriptions.findInEmfObject(rs)
		return index
	}

	protected def getBuilder() {
		project.getComponent(XtextAutoBuilderComponent)
	}
}