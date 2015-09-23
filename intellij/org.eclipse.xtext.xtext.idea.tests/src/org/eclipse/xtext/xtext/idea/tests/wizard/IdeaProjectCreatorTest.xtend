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
		val modules = builder.commit(project)
		assertEquals(1, modules.size)
		assertEquals("mydsl.core", modules.get(0).name)
		assertTrue(modules.get(0).moduleFilePath.endsWith('/mydsl.core/mydsl.core.iml'))
	}

	@Test
	def void testCreateGradleProject() {
		builder.wizardConfiguration.preferredBuildSystem = BuildSystem.GRADLE
		val modules = builder.commit(project)

		assertEquals(2, modules.size)
		assertEquals("mydsl", modules.get(0).name)
		assertTrue(modules.get(0).moduleFilePath.endsWith('/mydsl/mydsl.iml'))

		assertEquals("mydsl.core", modules.get(1).name)
		assertTrue(modules.get(1).moduleFilePath.endsWith('/mydsl.core/mydsl.core.iml'))
	}

	@Test
	def void testCreateGradleHirachicalProject() {
		builder.wizardConfiguration.preferredBuildSystem = BuildSystem.GRADLE
		builder.wizardConfiguration.projectLayout = ProjectLayout.HIERARCHICAL
		val modules = builder.commit(project)

		assertEquals(2, modules.size)
		assertEquals("mydsl", modules.get(0).name)
		assertTrue(modules.get(0).moduleFilePath.endsWith('/mydsl/mydsl.iml'))

		assertEquals("mydsl.core", modules.get(1).name)
		assertTrue(modules.get(1).moduleFilePath.endsWith('/mydsl/mydsl.core/mydsl.core.iml'))
		val allModules = ModuleManager.getInstance(project).modules
		assertEquals(3, allModules.size)
	}

	@Test
	def void testCreateTwoLanguagesProject() {
		val allModules = ModuleManager.getInstance(project).modules
		assertEquals(0, allModules.size)
		builder.wizardConfiguration.preferredBuildSystem = BuildSystem.GRADLE
		builder.wizardConfiguration.projectLayout = ProjectLayout.HIERARCHICAL
		builder.name = "mydsl"

		val modules = builder.commit(project)
		assertEquals(2, modules.size)
		assertEquals("mydsl", modules.get(0).name)
		assertTrue(modules.get(0).moduleFilePath.endsWith('/mydsl/mydsl.iml'))

		assertEquals("mydsl.core", modules.get(1).name)
		assertTrue(modules.get(1).moduleFilePath.endsWith('/mydsl/mydsl.core/mydsl.core.iml'))

		builder.name = "mydsl2"

		val rootModule = builder.commitModule(project, null)
		assertEquals("mydsl2", rootModule.name)
		assertTrue(rootModule.moduleFilePath.endsWith('/mydsl2/mydsl2.iml'))
		assertFalse(rootModule.moduleFilePath.endsWith('/mydsl/mydsl2/mydsl2.iml'))

	}
}