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
		batchCompiler.configureWorkspace();
		val config = workspaceConfigProvider.get
		assertEquals(new File('..').canonicalFile.absoluteFile, new File(config.absoluteFileSystemPath))
		val project = config.projects.values.head
		val projectPath = "/"+new File(".").canonicalFile.name
		assertEquals(projectPath, project.rootPath.toString)
		val src = project.sourceFolderMappings.keySet.head
		assertEquals(projectPath+"/batch-compiler-data/test data",src.toString)
		val target = project.sourceFolderMappings.get(src)
		assertEquals(projectPath+"/test-result",target.toString)
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