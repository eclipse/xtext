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
import com.intellij.facet.FacetManager
import com.intellij.facet.FacetType
import com.intellij.facet.FacetTypeRegistry
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleManager
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.openapi.roots.ModuleRootModificationUtil
import com.intellij.openapi.roots.impl.ModifiableModelCommitter
import com.intellij.openapi.roots.ui.configuration.actions.ModuleDeleteProvider
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.pom.java.LanguageLevel
import com.intellij.testFramework.PsiTestCase
import java.io.InputStreamReader
import org.eclipse.xtend.core.idea.facet.XtendFacetConfiguration
import org.eclipse.xtend.core.idea.lang.XtendLanguage
import org.eclipse.xtext.idea.build.XtextAutoBuilderComponent
import org.eclipse.xtext.idea.tests.LightToolingTest
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions
import org.eclipse.xtext.util.Files
import static extension org.eclipse.xtext.idea.tests.LibraryUtil.*

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
	
	def testTwoModulesDifferentLanguageVersion() {
		val moduleA = createModule('moduleA') => [
			javaTargetVersion = LanguageLevel.JDK_1_7
			addXtendLibrary	
		]
		val moduleB = createModule('moduleB') => [
			javaTargetVersion = LanguageLevel.JDK_1_8
			addXtendLibrary	
		]
		val classA= createFile(moduleA, "ClassA.xtend", '''
			class ClassA {
				val f = [boolean it | 42]
			}
		''')
		val classB= createFile(moduleB, "ClassB.xtend", '''
			class ClassB {
				val f = [boolean it | 42]
			}
		''')
		val generatedA= classA.virtualFile?.parent?.findChild('xtend-gen')?.findChild('ClassA.java')
		val generatedB = classB.virtualFile?.parent?.findChild('xtend-gen')?.findChild('ClassB.java')
		assertNotNull(generatedA)
		assertNotNull(generatedB)
		val aString = Files.readStreamIntoString(generatedA.inputStream)
		assertFalse(aString, aString.contains('->'))
		val bString = Files.readStreamIntoString(generatedB.inputStream)
		assertTrue(bString, bString.contains('->'))
	}

	def assertFileContains(VirtualFile file, String string) {
		val result = CharStreams.toString(new InputStreamReader(file.inputStream))
		assertEquals(string, result)
	}

	protected def setJavaTargetVersion(Module module, LanguageLevel level) {
		val facetType = FacetTypeRegistry.getInstance().facetTypes.findFirst [FacetType<?,?> it|
			it.stringId == XtendLanguage.INSTANCE.ID
		]
		val facet = FacetManager.getInstance(module).getFacetByType(facetType.id)
		(facet.configuration as XtendFacetConfiguration).state.targetJavaVersion = level.presentableText
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