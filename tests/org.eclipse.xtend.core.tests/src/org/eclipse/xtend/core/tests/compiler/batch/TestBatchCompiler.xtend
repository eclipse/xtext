/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler.batch

import com.google.inject.Inject
import java.io.File
import org.eclipse.xtend.core.compiler.batch.XtendBatchCompiler
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.file.RuntimeWorkspaceConfigProvider
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import static org.eclipse.xtext.util.Files.*
import static org.junit.Assert.*

/**
 * Batch compiler tests.
 * @see org.eclipse.xtend.core.compiler.batch.XtendBatchCompiler
 */
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(RuntimeInjectorProvider))
class TestBatchCompiler {

	@Inject
	XtendBatchCompiler batchCompiler
	
	@Inject RuntimeWorkspaceConfigProvider workspaceConfigProvider
	
    static String OUTPUT_DIRECTORY_WITH_SPACES = "./test result"
    static String OUTPUT_DIRECTORY = "./test-result"
    static String XTEND_SRC_DIRECTORY = "./batch-compiler-data/test data"
    static String BUG396747_SRC_DIRECTORY = "./batch-compiler-data/bug396747"
    static String BUG410594_SRC_DIRECTORY = "./batch-compiler-data/bug410594"
    static String BUG416262_SRC_DIRECTORY = "./batch-compiler-data/bug416262"
    static String BUG417177_SRC_DIRECTORY_1 = "./batch-compiler-data/bug417177/dir1/src1/"
    static String BUG417177_SRC_DIRECTORY_2 = "./batch-compiler-data/bug417177/dir2/dir2a/src2"
    static String BUG417177_OUTPUT_DIRECTORY = "./batch-compiler-data/bug417177/dir3/bin"
    static String TEMP_DIRECTORY = "./test-temp-dir"
    static String TEMP_DIRECTORY_WITH_SPACES = "./test temp dir"

	@Before
	def void onSetup () {
        batchCompiler.sourcePath = XTEND_SRC_DIRECTORY
        batchCompiler.outputPath = OUTPUT_DIRECTORY
        batchCompiler.deleteTempDirectory = true
        batchCompiler.useCurrentClassLoaderAsParent = true
        new File(OUTPUT_DIRECTORY).mkdir
        cleanFolder(new File(OUTPUT_DIRECTORY), null, true, false)
        new File(OUTPUT_DIRECTORY_WITH_SPACES).mkdir
        cleanFolder(new File(OUTPUT_DIRECTORY_WITH_SPACES), null, true, false)
	}

	@After
	def void onTearDown() {
       cleanFolder(new File(OUTPUT_DIRECTORY), null, true, true)
       cleanFolder(new File(OUTPUT_DIRECTORY_WITH_SPACES), null, true, true)
       if (new File(TEMP_DIRECTORY).exists) {
           cleanFolder(new File(TEMP_DIRECTORY), null, true, true)
       }
       if (new File(TEMP_DIRECTORY_WITH_SPACES).exists) {
           cleanFolder(new File(TEMP_DIRECTORY_WITH_SPACES), null, true, true)
       }
	}
	
	@Test def void testWorkspaceConfig() {
		assertTrue(batchCompiler.configureWorkspace());
		val config = workspaceConfigProvider.get
		assertEquals(new File('..').canonicalPath, config.absoluteFileSystemPath)
		val project = config.projects.values.head
		val projectPath = "/"+new File(".").canonicalFile.name
		assertEquals(projectPath, project.rootPath.toString)
		val src = project.sourceFolderMappings.keySet.head
		assertEquals(projectPath+"/batch-compiler-data/test data",src.toString)
		val target = project.sourceFolderMappings.get(src)
		assertEquals(projectPath+"/test-result",target.toString)
	}

	@Test def void testWorkspaceConfigMultipleSourceDirs1() {
		batchCompiler.sourcePath = '''ws/prj1/src«File.pathSeparator»ws/prj1/src-gen'''
		batchCompiler.outputPath = '''ws/prj1/bin'''

		assertTrue(batchCompiler.configureWorkspace());

		val config = workspaceConfigProvider.get
		assertEquals(new File('ws').canonicalPath, config.absoluteFileSystemPath)
		val project = config.projects.values.head
		assertEquals("/prj1", project.rootPath.toString)
		assertEquals(2, project.sourceFolderMappings.size)
		val keyPaths = project.sourceFolderMappings.keySet.sortBy[lastSegment]
		keyPaths.get(0) => [
			assertEquals("/prj1/src", toString)
			assertEquals("/prj1/bin", project.sourceFolderMappings.get(it).toString)
		]
		keyPaths.get(1) => [
			assertEquals("/prj1/src-gen", toString)
			assertEquals("/prj1/bin", project.sourceFolderMappings.get(it).toString)
		]
	}

	@Test def void testWorkspaceConfigMultipleSourceDirs2AbsPaths() {
		batchCompiler.sourcePath = '''/tmp/ws/prj1/src«File.pathSeparator»/tmp/ws/prj1/src-gen'''
		batchCompiler.outputPath = '''/tmp/ws/prj1/bin'''

		assertTrue(batchCompiler.configureWorkspace());

		val config = workspaceConfigProvider.get
		assertEquals(new File('/tmp/ws').canonicalPath, config.absoluteFileSystemPath)
		val project = config.projects.values.head
		assertEquals("/prj1", project.rootPath.toString)
		assertEquals(2, project.sourceFolderMappings.size)
		val keyPaths = project.sourceFolderMappings.keySet.sortBy[lastSegment]
		keyPaths.get(0) => [
			assertEquals("/prj1/src", toString)
			assertEquals("/prj1/bin", project.sourceFolderMappings.get(it).toString)
		]
		keyPaths.get(1) => [
			assertEquals("/prj1/src-gen", toString)
			assertEquals("/prj1/bin", project.sourceFolderMappings.get(it).toString)
		]
	}

	@Test def void testWorkspaceConfigMultipleSourceDirs3() {
		batchCompiler.sourcePath = '''ws/prj1/dir1/src«File.pathSeparator»ws/prj1/src-gen'''
		batchCompiler.outputPath = '''ws/prj1/dir2/bin'''

		assertTrue(batchCompiler.configureWorkspace());

		val config = workspaceConfigProvider.get
		assertEquals(new File('ws').canonicalPath, config.absoluteFileSystemPath)
		val project = config.projects.values.head
		assertEquals("/prj1", project.rootPath.toString)
		assertEquals(2, project.sourceFolderMappings.size)
		val keyPaths = project.sourceFolderMappings.keySet.sortBy[lastSegment]
		keyPaths.get(0) => [
			assertEquals("/prj1/dir1/src", toString)
			assertEquals("/prj1/dir2/bin", project.sourceFolderMappings.get(it).toString)
		]
		keyPaths.get(1) => [
			assertEquals("/prj1/src-gen", toString)
			assertEquals("/prj1/dir2/bin", project.sourceFolderMappings.get(it).toString)
		]
	}

	@Test def void testWorkspaceConfigMultipleSourceDirs4() {
		batchCompiler.sourcePath = '''ws/prj1/src«File.pathSeparator»ws/prj1/dir1/src-gen'''
		batchCompiler.outputPath = '''ws/prj1/bin'''

		assertTrue(batchCompiler.configureWorkspace());

		val config = workspaceConfigProvider.get
		assertEquals(new File('ws').canonicalPath, config.absoluteFileSystemPath)
		val project = config.projects.values.head
		assertEquals("/prj1", project.rootPath.toString)
		assertEquals(2, project.sourceFolderMappings.size)
		val keyPaths = project.sourceFolderMappings.keySet.sortBy[lastSegment]
		keyPaths.get(0) => [
			assertEquals("/prj1/src", toString)
			assertEquals("/prj1/bin", project.sourceFolderMappings.get(it).toString)
		]
		keyPaths.get(1) => [
			assertEquals("/prj1/dir1/src-gen", toString)
			assertEquals("/prj1/bin", project.sourceFolderMappings.get(it).toString)
		]
	}

	@Test def void testWorkspaceConfigMultipleSourceDirs5() {
		batchCompiler.sourcePath = '''ws/prj1/dir1/dir1a/src«File.pathSeparator»ws/prj1/dir3/dir3a/src-gen'''
		batchCompiler.outputPath = '''ws/prj1/dir2/dir2a/bin'''

		assertTrue(batchCompiler.configureWorkspace());

		val config = workspaceConfigProvider.get
		assertEquals(new File('ws').canonicalPath, config.absoluteFileSystemPath)
		val project = config.projects.values.head
		assertEquals("/prj1", project.rootPath.toString)
		assertEquals(2, project.sourceFolderMappings.size)
		val keyPaths = project.sourceFolderMappings.keySet.sortBy[lastSegment]
		keyPaths.get(0) => [
			assertEquals("/prj1/dir1/dir1a/src", toString)
			assertEquals("/prj1/dir2/dir2a/bin", project.sourceFolderMappings.get(it).toString)
		]
		keyPaths.get(1) => [
			assertEquals("/prj1/dir3/dir3a/src-gen", toString)
			assertEquals("/prj1/dir2/dir2a/bin", project.sourceFolderMappings.get(it).toString)
		]
	}

	@Test def void testWorkspaceConfigMultipleSourceDirs6() {
		batchCompiler.sourcePath = '''dir1/ws/prj1/dir2/dir3/dir4/src1«File.pathSeparator
								     »dir1/ws/prj1/dir2/dir3/src2«File.pathSeparator
								     »dir1/ws/prj1/dir2/src3«File.pathSeparator
								     »dir1/ws/prj1/src4'''
		batchCompiler.outputPath = '''dir1/ws/prj1/dir2/dir3/dir4/dir5/bin'''

		assertTrue(batchCompiler.configureWorkspace());

		val config = workspaceConfigProvider.get
		assertEquals(new File('dir1/ws').canonicalPath, config.absoluteFileSystemPath)
		val project = config.projects.values.head
		assertEquals("/prj1", project.rootPath.toString)
		assertEquals(4, project.sourceFolderMappings.size)
		val keyPaths = project.sourceFolderMappings.keySet.sortBy[lastSegment]
		keyPaths.get(0) => [
			assertEquals("/prj1/dir2/dir3/dir4/src1", toString)
			assertEquals("/prj1/dir2/dir3/dir4/dir5/bin", project.sourceFolderMappings.get(it).toString)
		]
		keyPaths.get(1) => [
			assertEquals("/prj1/dir2/dir3/src2", toString)
			assertEquals("/prj1/dir2/dir3/dir4/dir5/bin", project.sourceFolderMappings.get(it).toString)
		]
		keyPaths.get(2) => [
			assertEquals("/prj1/dir2/src3", toString)
			assertEquals("/prj1/dir2/dir3/dir4/dir5/bin", project.sourceFolderMappings.get(it).toString)
		]
		keyPaths.get(3) => [
			assertEquals("/prj1/src4", toString)
			assertEquals("/prj1/dir2/dir3/dir4/dir5/bin", project.sourceFolderMappings.get(it).toString)
		]
	}

	@Test def void testWorkspaceConfigSameDir() {
		batchCompiler.sourcePath = "ws/prj1"
		batchCompiler.outputPath = "ws/prj1"

		assertTrue(batchCompiler.configureWorkspace());

		val config = workspaceConfigProvider.get
		assertEquals(new File('ws').canonicalPath, config.absoluteFileSystemPath)
		val project = config.projects.values.head
		assertEquals("/prj1", project.rootPath.toString)
		assertEquals(1, project.sourceFolderMappings.size)
		val keyPaths = project.sourceFolderMappings.keySet.sortBy[lastSegment]
		keyPaths.get(0) => [
			assertEquals("/prj1", toString)
			assertEquals("/prj1", project.sourceFolderMappings.get(it).toString)
		]
	}

	@Test def void testWorkspaceConfigWithoutCommonProjectDir() {
		batchCompiler.sourcePath = '''/tmp/ws/prj1/src'''
		batchCompiler.outputPath = '''/usr/local/tmp/ws/prj1/bin'''

		assertFalse(batchCompiler.configureWorkspace());
	}

	@Test def void testWorkspaceConfigWithoutCommonWorkspaceDir() {
		batchCompiler.sourcePath = '''/tmp/src'''
		batchCompiler.outputPath = '''/tmp/bin'''

		assertFalse(batchCompiler.configureWorkspace());
	}

	@Test def void testWorkspaceConfigWithTopLevelCommonWorkspaceDir() {
		batchCompiler.sourcePath = '''/tmp/prj/src'''
		batchCompiler.outputPath = '''/tmp/prj/bin'''

		assertTrue(batchCompiler.configureWorkspace());
	}


    @Test
	def void bug368551() {
		batchCompiler.tempDirectory = TEMP_DIRECTORY_WITH_SPACES
		batchCompiler.sourcePath = XTEND_SRC_DIRECTORY
		batchCompiler.outputPath = OUTPUT_DIRECTORY_WITH_SPACES
		batchCompiler.compile
		assertEquals(14, new File(OUTPUT_DIRECTORY_WITH_SPACES + "/test").list.size)
	}
	
	@Test
	def void bug387829() {
		batchCompiler.tempDirectory = TEMP_DIRECTORY_WITH_SPACES
		batchCompiler.sourcePath = XTEND_SRC_DIRECTORY
		batchCompiler.outputPath = OUTPUT_DIRECTORY_WITH_SPACES
		batchCompiler.setClassPath(XTEND_SRC_DIRECTORY) //Tests Bug 387829
		batchCompiler.compile
		val compilerOutputDir = new File(OUTPUT_DIRECTORY_WITH_SPACES + "/test")
		assertTrue("Compiler output exists", compilerOutputDir.exists)
		assertEquals(14, compilerOutputDir.list.size)
	}

	@Test
	def void bug396747() {
		batchCompiler.sourcePath = BUG396747_SRC_DIRECTORY
		assertTrue("Compiling empty file pass", batchCompiler.compile)
	}
	
	@Test
	def void bug410594() {
		batchCompiler.sourcePath = BUG410594_SRC_DIRECTORY
		assertTrue("Compiling empty file pass", batchCompiler.compile)
	}
	
	@Test
	def void bug416262() {
		batchCompiler.sourcePath = BUG416262_SRC_DIRECTORY
		assertTrue("Compiling funny file pass", batchCompiler.compile)
	}

	@Test
	def void bug417177() {
		val outputDir = new File(BUG417177_OUTPUT_DIRECTORY)
		outputDir.mkdirs();
		new File(outputDir, "mypackage/Bug417177_1.java").delete
		new File(outputDir, "mypackage/Bug417177_2.java").delete
		batchCompiler.sourcePath = '''«BUG417177_SRC_DIRECTORY_1»«File.pathSeparator»«BUG417177_SRC_DIRECTORY_2»'''
		batchCompiler.outputPath = BUG417177_OUTPUT_DIRECTORY
		assertTrue("Compiling files from multiple source directories", batchCompiler.compile)
		assertTrue(new File(outputDir, "mypackage/Bug417177_1.java").exists)
		assertTrue(new File(outputDir, "mypackage/Bug417177_2.java").exists)
	}
	
	@Test
	def void testActiveAnnotatons1() {
		batchCompiler.sourcePath = "./batch-compiler-data/activeAnnotations1"
		assertTrue("Compiling empty file pass", batchCompiler.compile)
		assertEquals(3, new File(OUTPUT_DIRECTORY + "/mypackage").list[dir, name|name.endsWith(".java")].size)
	}
	
	@Test
	def void testClassPath() {
		batchCompiler.sourcePath = './batch-compiler-data/classpathTest/src'
		batchCompiler.setClassPath('./batch-compiler-data/classpathTest/dependency')
		assertTrue("Compiling with correct dependency resolution", batchCompiler.compile)
	}

	@Test
	def void testCompileTestDataWithTrace() {
		batchCompiler.writeTraceFiles = true
		batchCompiler.compile
		assertEquals(7, new File(OUTPUT_DIRECTORY + "/test").list[dir, name|name.endsWith(".java")].size)
		assertEquals(7, new File(OUTPUT_DIRECTORY + "/test").list[dir, name|name.endsWith("._trace")].size)
	}

	@Test
	def void testCompileTestDataWithoutTrace() {
		batchCompiler.writeTraceFiles = false
		batchCompiler.compile
		assertEquals(7, new File(OUTPUT_DIRECTORY + "/test").list[dir, name|name.endsWith(".java")].size)
		assertEquals(0, new File(OUTPUT_DIRECTORY + "/test").list[dir, name|name.endsWith("._trace")].size)
	}

	@Test
	def void tempDirectory() {
        batchCompiler.deleteTempDirectory = false
        batchCompiler.tempDirectory = TEMP_DIRECTORY
        assertTrue(batchCompiler.compile)
        assertEquals(2, new File(batchCompiler.getTempDirectory).list.size)
        assertTrue(batchCompiler.compile)
        assertEquals(4, new File(batchCompiler.getTempDirectory).list.size)
	}

	@Test
    def void deleteTempDirectory() {
        batchCompiler.deleteTempDirectory = true
        batchCompiler.tempDirectory = TEMP_DIRECTORY
        assertTrue(batchCompiler.compile)
        assertEquals(0, new File(TEMP_DIRECTORY).list.size)
    }
}