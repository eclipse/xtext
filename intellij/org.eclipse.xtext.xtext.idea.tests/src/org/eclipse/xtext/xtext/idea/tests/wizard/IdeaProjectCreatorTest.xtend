package org.eclipse.xtext.xtext.idea.tests.wizard

import com.intellij.openapi.module.ModuleManager
import com.intellij.testFramework.PsiTestCase
import java.io.IOException
import org.eclipse.xtext.idea.wizard.XtextModuleBuilder
import org.eclipse.xtext.xtext.wizard.BuildSystem
import org.eclipse.xtext.xtext.wizard.ProjectLayout
import org.junit.Test

class IdeaProjectCreatorTest extends PsiTestCase {

	XtextModuleBuilder builder

	override protected setUp() throws Exception {
		super.setUp()
		builder = new XtextModuleBuilder()
		builder.name = "mydsl"
		builder.wizardConfiguration.language.name = "org.xtext.MyDsl"
	}

	override protected createMainModule() throws IOException {
		// skip
	}

	@Test
	def void testCreateProject() {
		val modules = executeModuleBuilder
		assertEquals(1, modules.size)
		assertEquals("mydsl", modules.get(0).name)
		assertTrue(modules.get(0).moduleFilePath.endsWith('/mydsl/mydsl.iml'))
	}

	def executeModuleBuilder() {
		val modules = builder.commit(project)
		return modules
	}

	@Test
	def void testCreateGradleProject() {
		builder.wizardConfiguration.preferredBuildSystem = BuildSystem.GRADLE
		val modules = executeModuleBuilder

		assertEquals(2, modules.size)
		assertEquals("mydsl.parent", modules.get(0).name)
		assertTrue(modules.get(0).moduleFilePath.endsWith('/mydsl.parent/mydsl.parent.iml'))

		assertEquals("mydsl", modules.get(1).name)
		assertTrue(modules.get(1).moduleFilePath.endsWith('/mydsl/mydsl.iml'))
	}

	@Test
	def void testCreateGradleHirachicalProject() {
		builder.wizardConfiguration.preferredBuildSystem = BuildSystem.GRADLE
		builder.wizardConfiguration.projectLayout = ProjectLayout.HIERARCHICAL
		val modules = executeModuleBuilder

		assertEquals(2, modules.size)
		assertEquals("mydsl.parent", modules.get(0).name)
		assertTrue(modules.get(0).moduleFilePath.endsWith('/mydsl.parent/mydsl.parent.iml'))

		assertEquals("mydsl", modules.get(1).name)
		assertTrue(modules.get(1).moduleFilePath.endsWith('/mydsl.parent/mydsl/mydsl.iml'))
		val allModules = ModuleManager.getInstance(project).modules
		assertEquals(2, allModules.size)
	}

	@Test
	def void testCreateTwoLanguagesProject() {
		val allModules = ModuleManager.getInstance(project).modules
		assertEquals(0, allModules.size)
		builder.wizardConfiguration.preferredBuildSystem = BuildSystem.MAVEN
		builder.wizardConfiguration.projectLayout = ProjectLayout.HIERARCHICAL
		builder.name = "mydsl"

		val modules = executeModuleBuilder
		assertEquals(2, modules.size)
		assertEquals("mydsl.parent", modules.get(0).name)
		assertTrue(modules.get(0).moduleFilePath.endsWith('/mydsl.parent/mydsl.parent.iml'))

		assertEquals("mydsl", modules.get(1).name)
		assertTrue(modules.get(1).moduleFilePath.endsWith('/mydsl.parent/mydsl/mydsl.iml'))

		builder.name = "mydsl2"

		val rootModule = builder.commitModule(project, null)
		assertEquals("mydsl2.parent", rootModule.name)
		assertEquals('''Wrong .iml path  «rootModule.moduleFilePath»''',
			project.basePath + '/mydsl2.parent/mydsl2.parent.iml', rootModule.moduleFilePath)

	}

	override protected tearDown() throws Exception {
		if (project !== null)
			myModulesToDispose.addAll(ModuleManager.getInstance(project).modules)
		super.tearDown()
	}

}