package org.eclipse.xtext.xbase.ui.tests.editor

import com.google.inject.Inject
import org.eclipse.core.resources.IStorage
import org.eclipse.jdt.core.JavaCore
import org.eclipse.xtext.xbase.ui.editor.XbaseResourceForEditorInputFactory
import org.eclipse.xtext.xbase.ui.tests.AbstractXbaseUITestCase
import org.junit.Test

class XbaseResourceForEditorInputFactoryTest extends AbstractXbaseUITestCase {

	@Inject
	XbaseResourceForEditorInputFactory editorInputFactory

	@Test def void testValidationIsDisabled_01() {
		val project = workspace.root.getProject("simpleProject")
		project.create(null)
		project.open(null)
		val file = project.getFile("Hello.xtext")
		file.create([|-1], true, null)
		assertTrue(isValidationDisabled(file))
	}

	@Test def void testValidationIsDisabled_02() {
		val project = createPluginProject("my.plugin.project")
		val file = project.getFile("Hello.xtext")
		file.create([|-1], true, null)
		assertFalse(isValidationDisabled(file))
	}

	@Test def void testValidationIsDisabled_03() {
		val project = createPluginProject("my.plugin.project")
		val jp = JavaCore::create(project)
		var wasTested = false
		for (pfr : jp.allPackageFragmentRoots) {
			if (pfr.archive) {
				for (r : pfr.nonJavaResources.filter(typeof(IStorage))) {
					assertTrue(isValidationDisabled(r))
					wasTested = true
				}
			}
		}
		assertTrue(wasTested)
	}
	
	def boolean isValidationDisabled(IStorage storage) {
		val method = editorInputFactory.class.getDeclaredMethod("isValidationDisabled", typeof(IStorage))
		method.accessible = true
		return method.invoke(editorInputFactory, storage) as Boolean
	}
}
