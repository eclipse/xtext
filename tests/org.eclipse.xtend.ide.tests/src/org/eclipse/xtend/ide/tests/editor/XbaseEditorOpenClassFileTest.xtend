package org.eclipse.xtend.ide.tests.editor

import com.google.common.io.ByteStreams
import com.google.inject.Inject
import java.io.ByteArrayInputStream
import java.io.InputStream
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResourceVisitor
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

import static extension org.eclipse.xtend.ide.tests.WorkbenchTestHelper.*
import static extension org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*
import static extension org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.*
import org.eclipse.xtext.util.internal.Log
import org.junit.Before

@Log class XbaseEditorOpenClassFileTest extends AbstractXtendUITestCase {
	
	@Inject extension WorkbenchTestHelper helper
	IProject project
	
	@Before override void setUp() {
		super.setUp
		project = createPluginProject("my.example.project")
	}

	@After override void tearDown() {
		helper.tearDown
		project.delete(true, null)
	}

	@Test def void testOpenFileFromSmapJarWithIncludedSource() {
		
		if(!supportsEditorOverride)
			return
		
		val jp = JavaCore.create(project)
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
		val project = createPluginProject("my.example.project")
		val jp = JavaCore.create(project)
		val root = jp.addJarToClassPath('smap-binary.jar', 'smap-sources.jar')
		assertNotNull(root)
		val type = jp.findType('de.itemis.HelloXtend')
		assertNotNull(type)
		val result = getEditorContents(type)
		assertContains("println('Hello Xtend!')", result)
	}

	@Test def void testOpenFileFromJarWithAttachedSource() {
		val jp = JavaCore.create(project)
		val root = jp.addJarToClassPath('primary-debug-binary.jar', 'primary-debug-sources.jar')
		assertNotNull(root)
		val type = jp.findType('de.itemis.HelloXtend')
		assertNotNull(type)
		val result = getEditorContents(type)
		assertContains("println('Hello Xtend!')", result)
	}

	@Test def void testOpenFileFromJarWithNameConflictingLocalFile() {
		if(!supportsEditorOverride)
			return
		val jp = JavaCore.create(project)
		createFile("foo/HelloXtend.xtend",'''
			package foo
			class HelloXtend {
				// wrong class
			}
		''')
		val root = jp.addJarToClassPath('primary-debug-binary.jar', 'primary-debug-sources.jar')
		assertNotNull(root)
		val type = jp.findType('de.itemis.HelloXtend')
		assertNotNull(type)
		val result = getEditorContents(type)
		assertContains("println('Hello Xtend!')", result)
	}
	
	@Test def void testOpenEditor_NameConflict() {
		if(!supportsEditorOverride)
			return
		val jp = JavaCore.create(project)
		project.addJarToProject(createJar(
			'myPackage/Foo.xtend' -> '''
				// Xtend
				package myPackage
				class Foo {}
			''',
			'otherPackage/Foo.java' -> '''
				// Java
				package otherPackage;
				public class Foo {}
			'''
		))
		waitForBuild
		val type = jp.findType('otherPackage.Foo')
		assertNotNull(type)
		val result = getEditorContents(type)
		assertContains("// Java", result)
	}
	
	@Test def void testOpenEditor_NameConflict02() {
		if(!supportsEditorOverride)
			return
		val jp = JavaCore.create(project)
		project.addJarToProject(createJar(
			'myPackage/Foo.xtend' -> '''
				// Xtend
				package myPackage
				class Foo {}
			''',
			'otherPackage/Foo.java' -> '''
				// Java
				package otherPackage;
				public class Foo {}
			'''
		))
		waitForBuild
		val type = jp.findType('myPackage.Foo')
		assertNotNull(type)
		val result = getEditorContents(type)
		// it must be the Java version
		assertContains("package myPackage;", result)
	}
	
	@Test def void testOpenEditor_NameConflict03() {
		if(!supportsEditorOverride)
			return
		val jp = JavaCore.create(project)
		project.addJarToProject(createJar(
			'myPackage/Foo.xtend' -> '''
				// Xtend
				package myPackage
				class Foo2 {}
			''',
			'otherPackage/Foo.java' -> '''
				// Java
				package otherPackage;
				public class Foo {}
			'''
		))
		waitForBuild
		val type = jp.findType('myPackage.Foo2')
		assertNotNull(type)
		val result = getEditorContents(type)
		// it must be the Xtend version
		assertContains('''
				// Xtend
				package myPackage
				class Foo2 {}
			'''.toString, result)
	}
	
	@Test def void testOpenEditor4NestedType_NameConflict() {
		if(!supportsEditorOverride)
			return
		val jp = JavaCore.create(project)
		project.addJarToProject(createJar(
			'myPackage/Foo.xtend' -> '''
				// Xtend
				package myPackage
				class Foo {
					static class MyInnerClass {}
				}
			''',
			'otherPackage/Foo.java' -> '''
				// Java
				package otherPackage;
				public class Foo {
					static class MyInnerClass {}
				}
			'''
		))
		waitForBuild
		val type = jp.findType('myPackage.Foo.MyInnerClass')
		assertNotNull(type)
		val result = getEditorContents(type)
		assertEquals('''
			package myPackage;
			
			@SuppressWarnings("all")
			public class Foo {
			  public static class MyInnerClass {
			  }
			}
		'''.toString, result)
	}
	
	@Test def void testOpenEditor4NestedType_NoNameConflict() {
		if(!supportsEditorOverride)
			return
		val jp = JavaCore.create(project)
		project.addJarToProject(createJar(
			'myPackage/Foo.xtend' -> '''
				// Xtend
				package myPackage
				class Foo {
					static class MyInnerClass {}
				}
			''',
			'otherPackage/Bar.java' -> '''
				// Java
				package otherPackage;
				public class Bar {
					static class MyInnerClass2 {}
				}
			'''
		))
		waitForBuild
		val type = jp.findType('myPackage.Foo.MyInnerClass')
		assertNotNull(type)
		val result = getEditorContents(type)
		assertContains('''
				// Xtend
				package myPackage
				class Foo {
					static class MyInnerClass {}
				}
			''', result)
	}
	
	protected def addJarToProject(IProject project, byte[] jarData) {
		val jarFile = project.getFile("mydependency.jar")
		jarFile.create(new ByteArrayInputStream(jarData), true, null)
		JavaCore.create(project).addJarToClasspath(jarFile)
	}
	
	def byte[] createJar(Pair<? extends String, ? extends String> ... sourceFiles) {
		val project = "my.temporary.data.project".createPluginProject('org.eclipse.xtext.xbase.lib', 'org.eclipse.xtend.lib')
		val listOfContents = <String,InputStream>newHashMap
		try {
			val folder = JavaCore.create(project).addSourceFolder("src")
			JavaCore.create(project).addSourceFolder("xtend-gen")
			for (sourceFile : sourceFiles) {
				(folder.fullPath.append(sourceFile.key)).createFile(sourceFile.value)
			}
			waitForBuild
			
			
			val IResourceVisitor visitor = [
				if (it instanceof IFile) {
					val path = it.projectRelativePath.removeFirstSegments(1).toString
					listOfContents.put(path , contents)
				}
				return true
			]
			
			project.getFolder('src').accept(visitor)
			project.getFolder('xtend-gen').accept(visitor)
			project.getFolder('bin').accept(visitor)
			
			val jarin = jarInputStream(listOfContents.entrySet.map[key->value].toList)
			return ByteStreams.toByteArray(jarin)
		} finally {
			for (it : listOfContents.values) {
				close
			}
			project.delete(true, true, null)
		}
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
		val cp = JavaCore.newLibraryEntry(jarFile.fullPath, sourceFile?.fullPath, null)
		jp.addToClasspath(cp)
		return JavaCore.createJarPackageFragmentRootFrom(jarFile)
	}

	def getEditorContents(IJavaElement javaElement) {
		val editor = JavaUI.openInEditor(javaElement)
		val text = (editor.getAdapter(IRewriteTarget) as IRewriteTarget).document.get
		editor.closeEditor(false)
		return text
	}

	def supportsEditorOverride() {
		try {
			if (Class.forName("org.eclipse.ui.ide.IEditorAssociationOverride") != null) {
				return true;
			}
		} catch (ClassNotFoundException e) {
		}
		LOG.warn("Ignoring "+Thread.currentThread.stackTrace.get(1).methodName+" , since editor everride is not supported.")
		return false
	}

}
