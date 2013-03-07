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
		val jp = JavaCore::create(project)
		val root = jp.addJarToClassPath('smap-all.jar', null)
		assertNotNull(root)
		val type = jp.findType('de.itemis.HelloXtend')
		assertNotNull(type)
		val result = getEditorContents(type)
		assertTrue(result.contains("println('Hello Xtend!')"))
	}
	
	@Test def void testOpenFileFromSmapJarWithAttachedSource() {
		val jp = JavaCore::create(project)
		val root = jp.addJarToClassPath('smap-binary.jar', 'smap-sources.jar')
		assertNotNull(root)
		val type = jp.findType('de.itemis.HelloXtend')
		assertNotNull(type)
		val result = getEditorContents(type)
		assertTrue(result.contains("println('Hello Xtend!')"))
	}
	
	@Test def void testOpenFileFromJarWithAttachedSource() {
		val jp = JavaCore::create(project)
		val root = jp.addJarToClassPath('primary-debug-binary.jar', 'primary-debug-sources.jar')
		assertNotNull(root)
		val type = jp.findType('de.itemis.HelloXtend')
		assertNotNull(type)
		val result = getEditorContents(type)
		assertTrue(result.contains("println('Hello Xtend!')"))
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
	
}