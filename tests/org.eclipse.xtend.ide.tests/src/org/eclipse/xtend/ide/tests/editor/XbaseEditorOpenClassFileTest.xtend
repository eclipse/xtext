package org.eclipse.xtend.ide.tests.editor

import com.google.inject.Inject
import org.eclipse.core.runtime.Path
import org.eclipse.jdt.core.IJavaElement
import org.eclipse.jdt.core.IJavaProject
import org.eclipse.jdt.core.JavaCore
import org.eclipse.jdt.ui.JavaUI
import org.eclipse.jface.text.IRewriteTarget
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.junit.After
import org.junit.Test

import static extension org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.*

class XbaseEditorOpenClassFileTest extends AbstractXtendUITestCase {
	@Inject extension WorkbenchTestHelper helper

	@After override void tearDown() {
		helper.tearDown
	}

	@Test def void testOpenFileFromSmapJarWithIncludedSource() {
		
		if(!supportsEditorOverride)
			return
		
		val jp = JavaCore::create(project)
		val root = jp.addJarToClassPath('smap-all.jar', null)
		assertNotNull(root)
		val type = jp.findType('de.itemis.HelloXtend')
		assertNotNull(type)
		val result = getEditorContents(type)
		assertContains("println('Hello Xtend!')", result)
	}

	@Test def void testOpenFileFromSmapJarWithAttachedSource() {
		
		if(!supportsEditorOverride)
			return
		
		val jp = JavaCore::create(project)
		val root = jp.addJarToClassPath('smap-binary.jar', 'smap-sources.jar')
		assertNotNull(root)
		val type = jp.findType('de.itemis.HelloXtend')
		assertNotNull(type)
		val result = getEditorContents(type)
		assertContains("println('Hello Xtend!')", result)
	}

	@Test def void testOpenFileFromJarWithAttachedSource() {
		val jp = JavaCore::create(project)
		val root = jp.addJarToClassPath('primary-debug-binary.jar', 'primary-debug-sources.jar')
		assertNotNull(root)
		val type = jp.findType('de.itemis.HelloXtend')
		assertNotNull(type)
		val result = getEditorContents(type)
		assertContains("println('Hello Xtend!')", result)
	}

	def assertContains(String substring, String container) {
		if (!container.contains(substring))
			fail(
				'''
					Substring '«substring»' not found in
					-----------
					«container»
					-----------
				''')
	}

	def addJarToClassPath(IJavaProject jp, String fileName, String fileNameOfSource) {
		val jarFile = jp.project.getFile(new Path(fileName))
		jarFile.create(class.getResourceAsStream(fileName), true, null)

		val sourceFile = if (fileNameOfSource != null) {
				val source = jp.project.getFile(new Path(fileNameOfSource))
				source.create(class.getResourceAsStream(fileNameOfSource), true, null)
				source
			}
		val cp = JavaCore::newLibraryEntry(jarFile.fullPath, sourceFile?.fullPath, null)
		jp.addToClasspath(cp)
		return JavaCore::createJarPackageFragmentRootFrom(jarFile)
	}

	def getEditorContents(IJavaElement javaElement) {
		val editor = JavaUI::openInEditor(javaElement)
		val text = (editor.getAdapter(typeof(IRewriteTarget)) as IRewriteTarget).document.get
		editor.closeEditor(false)
		return text
	}

	def supportsEditorOverride() {
		try {
			Class::forName("org.eclipse.ui.ide.IEditorAssociationOverride") != null
		} catch (ClassNotFoundException e) {
			false
		}
	}

}
