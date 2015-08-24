/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl

import java.io.File
import java.io.FileOutputStream
import org.eclipse.core.resources.IContainer
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.IPath
import org.eclipse.core.runtime.Path
import org.eclipse.xtext.ui.XtextProjectHelper
import org.junit.Test

import static extension org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*
import static extension org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.*

/**
 * @author kosyakov - Initial contribution and API
 */
abstract class AbstractFSSynchronizationTest extends AbstractBuilderParticipantTest {

	static val PROJECT_NAME = 'myProject'

	IProject project

	override setUp() throws Exception {
		super.setUp()
		project = PROJECT_NAME.createJavaProject.project
		project.addNature(XtextProjectHelper.NATURE_ID)
		reallyWaitForAutoBuild
	}

	override tearDown() throws Exception {
		project = null
		super.tearDown()
	}

	@Test
	def void testUpdateFileContent() {
		testUpdateFileContent(project.getFolder('src-gen'))
	}
	
	@Test
	def void testUpdateFileContentWithProjectAsOutput() {
		withOutputConfiguration([
			outputDirectory = './'
		]) [
			testUpdateFileContent(project)		
		]
	}
	
	protected def void testUpdateFileContent(IContainer output) {
		output.getFile(new Path('Foo.txt')).location.createJavaIoFile('object Bar')

		project.getFile('src/Foo' + F_EXT).fullPath.createFile('object Foo')
		reallyWaitForAutoBuild
		assertEquals('object Foo', output.getFile(new Path('Foo.txt')).fileToString)
	}

	@Test
	def void testTouchFile() {
		testTouchFile(project.getFolder('src-gen'))
	}

	@Test
	def void testTouchFileWithProjectAsOutput() {
		withOutputConfiguration([
			outputDirectory = './'
		]) [
			testTouchFile(project)		
		]
	}
	
	protected def void testTouchFile(IContainer output) {
		output.getFile(new Path('Foo.txt')).location.createJavaIoFile('object Foo')

		project.getFile('src/Foo' + F_EXT).fullPath.createFile('object Foo')
		reallyWaitForAutoBuild
		assertEquals('object Foo', output.getFile(new Path('Foo.txt')).fileToString)
	}

	@Test
	def void testCreateFile() {
		testCreateFile(project.getFolder('src-gen'))
	}

	@Test
	def void testCreateFileWithProjectAsOutput() {
		withOutputConfiguration([
			outputDirectory = './'
		]) [
			testCreateFile(project)		
		]
	}

	protected def void testCreateFile(IContainer output) {
		val file = project.getFile('src/Foo' + F_EXT).fullPath.createFile('object Foo')
		reallyWaitForAutoBuild
		assertEquals('object Foo', output.getFile(new Path('Foo.txt')).fileToString)

		val javaIoFile = output.getFile(new Path('Foo.txt')).location.toFile
		javaIoFile.delete
		javaIoFile.parentFile.delete

		file.touch(monitor)
		reallyWaitForAutoBuild
		assertEquals('object Foo', output.getFile(new Path('Foo.txt')).fileToString)
	}

	@Test
	def void testDeleteTraceFile() {
		testDeleteTraceFile(project.getFolder('src-gen'))
	}

	@Test
	def void testDeleteTraceFileWithProjectAsOutput() {
		withOutputConfiguration([
			outputDirectory = './'
		]) [
			testDeleteTraceFile(project)		
		]
	}

	protected def void testDeleteTraceFile(IContainer output) {
		val javaIoFile = output.getFile(new Path('.Foo.txt._trace')).location.createJavaIoFile

		project.getFile('src/Foo' + F_EXT).fullPath.createFile('object Foo')
		reallyWaitForAutoBuild
		assertFalse(javaIoFile.exists)
		assertFalse(output.getFile(new Path('.Foo.txt._trace')).exists)
	}

	@Test
	def void testCleanOutput_01() {
		withOutputConfiguration([
			canClearOutputDirectory = true
			cleanUpDerivedResources = false
		]) [
			val srcGenDirectory = project.getFile('src-gen/Lalala.txt').location.createJavaIoFile.parentFile
			assertFalse(srcGenDirectory.listFiles.empty)

			project.getFile('src/Foo' + F_EXT).fullPath.createFile('object Foo')
			reallyWaitForAutoBuild
			assertFalse(srcGenDirectory.listFiles.empty)

			cleanBuild
			assertTrue(srcGenDirectory.listFiles.empty)
		]
	}

	@Test
	def void testCleanOutput_02() {
		withOutputConfiguration([
			canClearOutputDirectory = true
			cleanUpDerivedResources = false
		]) [
			val srcGenDirectory = project.getFolder('src-gen').location.toFile
			assertFalse(srcGenDirectory.exists)

			project.getFile('src/Foo' + F_EXT).fullPath.createFile('object Foo')
			reallyWaitForAutoBuild
			assertTrue(srcGenDirectory.exists)
			assertFalse(srcGenDirectory.listFiles.empty)

			project.getFile('src-gen/Lalala.txt').location.createJavaIoFile

			cleanBuild
			assertTrue(srcGenDirectory.exists)
			assertTrue(srcGenDirectory.listFiles.empty)
		]
	}

	@Test
	def void testCleanProjectAsOutput() {
		withOutputConfiguration([
			outputDirectory = './'
			canClearOutputDirectory = true
			cleanUpDerivedResources = false
		]) [
			val projectDirectory = project.location.toFile
			val initialSize = projectDirectory.listFiles.size
			assertNotEquals(0, initialSize)

			project.getFile('src/Foo' + F_EXT).fullPath.createFile('object Foo')
			reallyWaitForAutoBuild
			val expectedSize = projectDirectory.listFiles.size
			assertNotEquals(initialSize, expectedSize)

			cleanBuild
			assertEquals(expectedSize, projectDirectory.listFiles.size)
		]
	}

	@Test
	def void testCleanUpDerivedResourcesWithCreateBefore() {
		testCleanUpDerivedResourcesWithCreateBefore(project.getFolder('src-gen'))
	}

	@Test
	def void testCleanUpDerivedResourcesWithCreateBetween() {
		testCleanUpDerivedResourcesWithCreateBetween(project.getFolder('src-gen'))
	}

	@Test
	def void testCleanUpDerivedResourcesWithUpdateDerived() {
		testCleanUpDerivedResourcesWithUpdateDerived(project.getFolder('src-gen'))
	}

	@Test
	def void testCleanUpDerivedResourcesWithDeleteDerived() {
		testCleanUpDerivedResourcesWithDeleteDerived(project.getFolder('src-gen'))
	}

	@Test
	def void testCleanUpProjectDerivedResourcesWithCreateBefore() {
		withOutputConfiguration([
			outputDirectory = './'
		]) [
			testCleanUpDerivedResourcesWithCreateBefore(project);
		]
	}

	@Test
	def void testCleanUpProjectDerivedResourcesWithCreateBetween() {
		withOutputConfiguration([
			outputDirectory = './'
		]) [
			testCleanUpDerivedResourcesWithCreateBetween(project);
		]
	}

	@Test
	def void testCleanUpProjectDerivedResourcesWithUpdateDerived() {
		withOutputConfiguration([
			outputDirectory = './'
		]) [
			testCleanUpDerivedResourcesWithUpdateDerived(project);
		]
	}

	@Test
	def void testCleanUpProjectDerivedResourcesWithDeleteDerived() {
		withOutputConfiguration([
			outputDirectory = './'
		]) [
			testCleanUpDerivedResourcesWithDeleteDerived(project);
		]
	}

	protected def void testCleanUpDerivedResourcesWithCreateBefore(IContainer output) {
		val ouputDirectory = output.getFile(new Path('Lalala.txt')).location.createJavaIoFile.parentFile
		val expectedSize = ouputDirectory.list.size

		project.getFile('src/Foo' + F_EXT).fullPath.createFile('object Foo')
		reallyWaitForAutoBuild
		assertNotEquals(expectedSize, ouputDirectory.list.size)

		cleanBuild
		assertEquals(expectedSize, ouputDirectory.list.size)
		assertTrue(ouputDirectory.list.contains('Lalala.txt'))
	}

	protected def void testCleanUpDerivedResourcesWithCreateBetween(IContainer output) {
		val outputDirectory = output.location.toFile
		val initialSize = if(outputDirectory.exists) outputDirectory.list.size else 0

		project.getFile('src/Foo' + F_EXT).fullPath.createFile('object Foo')
		reallyWaitForAutoBuild
		assertNotEquals(initialSize, outputDirectory.list.size)

		output.getFile(new Path('Lalala.txt')).location.createJavaIoFile
		val expectedSize = initialSize + 1

		cleanBuild
		assertEquals(expectedSize, outputDirectory.list.size)
		assertTrue(outputDirectory.list.contains('Lalala.txt'))
	}

	protected def void testCleanUpDerivedResourcesWithUpdateDerived(IContainer output) {
		val outputDirectory = output.location.toFile
		val expectedSize = if(outputDirectory.exists) outputDirectory.list.size else 0

		project.getFile('src/Foo' + F_EXT).fullPath.createFile('object Foo')
		reallyWaitForAutoBuild
		assertNotEquals(expectedSize, outputDirectory.list.size)
		
		Thread.sleep(1000)

		val file = output.getFile(new Path('Foo.txt'))
		file.location.toFile.content = 'Lalala'
		assertFalse(file.synchronized)

		cleanBuild
		assertEquals(expectedSize, outputDirectory.list.size)
	}

	protected def void testCleanUpDerivedResourcesWithDeleteDerived(IContainer output) {
		val outputDirectory = output.location.toFile
		val expectedSize = if(outputDirectory.exists) outputDirectory.list.size else 0

		project.getFile('src/Foo' + F_EXT).fullPath.createFile('object Foo')
		reallyWaitForAutoBuild
		assertNotEquals(expectedSize, outputDirectory.list.size)
		
		Thread.sleep(1000)

		val file = output.getFile(new Path('Foo.txt'))
		assertTrue(file.location.toFile.delete)
		assertFalse(file.synchronized)

		cleanBuild
		assertEquals(expectedSize, outputDirectory.list.size)
	}
	
	@Test
	def void testDeleteUpdatedDerivedResource() {
		testDeleteUpdatedDerivedResource(project.getFolder('src-gen'))
	}
	
	@Test
	def void testDeleteUpdatedDerivedResourceWithProjectAsOutput() {
		withOutputConfiguration([
			outputDirectory = './'
		]) [
			testDeleteUpdatedDerivedResource(project)	
		]
	}
	
	protected def void testDeleteUpdatedDerivedResource(IContainer output) {
		val outputDirectory = output.location.toFile
		val expectedSize = if(outputDirectory.exists) outputDirectory.list.size else 0

		val sourceFile = project.getFile('src/Foo' + F_EXT).fullPath.createFile('object Foo')
		reallyWaitForAutoBuild
		assertNotEquals(expectedSize, outputDirectory.list.size)
		
		Thread.sleep(1000)

		val file = output.getFile(new Path('Foo.txt'))
		file.location.toFile.content = 'Lalala'
		assertFalse(file.synchronized)

		sourceFile.delete(false, monitor)
		reallyWaitForAutoBuild
		assertEquals(expectedSize, outputDirectory.list.size)
	}
	
	@Test
	def void testDeleteDeletedDerivedResource() {
		testDeleteDeletedDerivedResource(project.getFolder('src-gen'))
	}
	
	@Test
	def void testDeleteDeletedDerivedResourceWithProjectAsOutput() {
		withOutputConfiguration([
			outputDirectory = './'
		]) [
			testDeleteDeletedDerivedResource(project)	
		]
	}
	
	protected def void testDeleteDeletedDerivedResource(IContainer output) {
		val outputDirectory = output.location.toFile
		val expectedSize = if(outputDirectory.exists) outputDirectory.list.size else 0

		val sourceFile = project.getFile('src/Foo' + F_EXT).fullPath.createFile('object Foo')
		reallyWaitForAutoBuild
		assertNotEquals(expectedSize, outputDirectory.list.size)
		
		Thread.sleep(1000)

		val file = output.getFile(new Path('Foo.txt'))
		assertTrue(file.location.toFile.delete)
		assertFalse(file.synchronized)

		sourceFile.delete(false, monitor)
		reallyWaitForAutoBuild
		assertEquals(expectedSize, outputDirectory.list.size)
	}

	protected def createJavaIoFile(IPath location, String content) {
		val javaIoFile = location.createJavaIoFile
		javaIoFile.content = content
		return javaIoFile
	}

	protected def createJavaIoFile(IPath location) {
		val javaIoFile = location.toFile
		javaIoFile.parentFile.mkdirs
		assertTrue(javaIoFile.createNewFile)
		return javaIoFile
	}

	protected def void setContent(File javaIoFile, String content) {
		val fos = new FileOutputStream(javaIoFile)
		fos.write(content.bytes)
		fos.flush
		fos.close
	}

	protected def isSynchronized(IFile file) {
		val target = file as org.eclipse.core.internal.resources.File
		target.localManager.fastIsSynchronized(target)
	}

}