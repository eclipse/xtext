/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler.batch

import com.google.common.base.Charsets
import com.google.common.io.Files
import com.google.inject.Inject
import java.io.File
import java.io.IOException
import java.util.Set
import org.apache.log4j.Level
import org.eclipse.xtend.core.compiler.batch.XtendBatchCompiler
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.logging.LoggingTester
import org.eclipse.xtext.junit4.smoketest.IgnoredBySmokeTest
import org.junit.After
import org.junit.AfterClass
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith

import static org.eclipse.xtext.util.Files.*
import static org.junit.Assert.*

/**
 * Batch compiler tests.
 * @see XtendBatchCompiler
 */
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(RuntimeInjectorProvider))
@IgnoredBySmokeTest
class TestBatchCompiler {

	@Inject
	XtendBatchCompiler batchCompiler

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
	static final Set<File> abfalleimer = newHashSet()

	@Before
	def void onSetup() {
		batchCompiler.sourcePath = XTEND_SRC_DIRECTORY
		batchCompiler.outputPath = OUTPUT_DIRECTORY
		batchCompiler.deleteTempDirectory = true
		batchCompiler.useCurrentClassLoaderAsParent = true
		batchCompiler.currentClassLoader = class.classLoader
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

	@AfterClass
	def static void afterClass() {
		try {
			abfalleimer.forEach[if(exists) delete]
		} catch (Exception e) {
		} finally {
			abfalleimer.clear
		}
	}
	
	@Test def void testInvalidConfiguration() {
		val log = LoggingTester.captureLogging(Level.ERROR, XtendBatchCompiler) [
			batchCompiler.sourcePath = XTEND_SRC_DIRECTORY
			batchCompiler.outputPath = XTEND_SRC_DIRECTORY+"/xtend-gen"
			batchCompiler.compile	
		]
		log.assertLogEntry("xtend", "cannot be a child")
	}
	
	@Test def void testInvalidConfiguration_2() {
		if (System.getProperty("os.name").startsWith("Windows")) {
			val log = LoggingTester.captureLogging(Level.ERROR, XtendBatchCompiler) [
				batchCompiler.sourcePath = XTEND_SRC_DIRECTORY
				batchCompiler.outputPath = XTEND_SRC_DIRECTORY.toUpperCase+"/xtend-gen"
				batchCompiler.compile	
			]
			log.assertLogEntry("xtend", "cannot be a child")
		}
	}
	
	@Test def void testBug462723() {
		batchCompiler.sourcePath = XTEND_SRC_DIRECTORY
		batchCompiler.outputPath = XTEND_SRC_DIRECTORY+"-gen"
		assertTrue(batchCompiler.compile)	
	}

	@Test def void testProjectConfig() {
		batchCompiler.compile
		val project = batchCompiler.projectConfig
		val projectPath = new File(".").canonicalFile.name
		assertEquals(projectPath, project.name)
		val output = batchCompiler.outputConfiguration
		val src = project.sourceFolders.head.name
		assertEquals("batch-compiler-data/test data", src.toString)
		val target = output.getOutputDirectory(src)
		assertEquals("test-result", target.toString)
	}

	@Test def void testprojectConfigMultipleSourceDirs1() {
		batchCompiler.sourcePath = '''ws/prj1/src«File.pathSeparator»ws/prj1/src-gen'''
		batchCompiler.outputPath = '''ws/prj1/bin'''
		batchCompiler.compile
		val project = batchCompiler.projectConfig
		assertEquals("prj1", project.name)
		val output = batchCompiler.outputConfiguration
		assertEquals(2, project.sourceFolders.size)
		val keyPaths = project.sourceFolders.map[name].sort
		keyPaths.get(0) => [
			assertEquals("src", it)
			assertEquals("bin", output.getOutputDirectory(it).toString)
		]
		keyPaths.get(1) => [
			assertEquals("src-gen", it)
			assertEquals("bin", output.getOutputDirectory(it).toString)
		]
	}

	@Test def void testprojectConfigMultipleSourceDirs2AbsPaths() {
		batchCompiler.sourcePath = '''/tmp/ws/prj1/src«File.pathSeparator»/tmp/ws/prj1/src-gen'''
		batchCompiler.outputPath = '''/tmp/ws/prj1/bin'''

		batchCompiler.compile
		val project = batchCompiler.projectConfig
		assertEquals("prj1", project.name)
		val output = batchCompiler.outputConfiguration
		assertEquals(2, project.sourceFolders.size)
		val keyPaths = project.sourceFolders.map[name].sort
		keyPaths.get(0) => [
			assertEquals("src", it)
			assertEquals("bin", output.getOutputDirectory(it))
		]
		keyPaths.get(1) => [
			assertEquals("src-gen", it)
			assertEquals("bin", output.getOutputDirectory(it))
		]
	}

	@Test def void testprojectConfigMultipleSourceDirs3() {
		batchCompiler.sourcePath = '''ws/prj1/dir1/src«File.pathSeparator»ws/prj1/src-gen'''
		batchCompiler.outputPath = '''ws/prj1/dir2/bin'''

		batchCompiler.compile
		val project = batchCompiler.projectConfig
		assertEquals("prj1", project.name)
		val output = batchCompiler.outputConfiguration
		assertEquals(2, project.sourceFolders.size)
		val keyPaths = project.sourceFolders.map[name].sort
		keyPaths.get(0) => [
			assertEquals("dir1/src", it)
			assertEquals("dir2/bin", output.getOutputDirectory(it))
		]
		keyPaths.get(1) => [
			assertEquals("src-gen", it)
			assertEquals("dir2/bin", output.getOutputDirectory(it))
		]
	}

	@Test def void testprojectConfigMultipleSourceDirs4() {
		batchCompiler.sourcePath = '''ws/prj1/src«File.pathSeparator»ws/prj1/dir1/src-gen'''
		batchCompiler.outputPath = '''ws/prj1/bin'''

		batchCompiler.compile

		val project = batchCompiler.projectConfig
		assertEquals("prj1", project.name)
		val output = batchCompiler.outputConfiguration
		assertEquals(2, project.sourceFolders.size)
		val keyPaths = project.sourceFolders.map[name].sort
		keyPaths.get(0) => [
			assertEquals("dir1/src-gen", it)
			assertEquals("bin", output.getOutputDirectory(it))
		]
		keyPaths.get(1) => [
			assertEquals("src", it)
			assertEquals("bin", output.getOutputDirectory(it))
		]
	}

	@Test def void testprojectConfigMultipleSourceDirs5() {
		batchCompiler.sourcePath = '''ws/prj1/dir1/dir1a/src«File.pathSeparator»ws/prj1/dir3/dir3a/src-gen'''
		batchCompiler.outputPath = '''ws/prj1/dir2/dir2a/bin'''

		batchCompiler.compile
		val project = batchCompiler.projectConfig
		assertEquals("prj1", project.name)
		val output = batchCompiler.outputConfiguration
		assertEquals(2, project.sourceFolders.size)
		val keyPaths = project.sourceFolders.map[name].sort
		keyPaths.get(0) => [
			assertEquals("dir1/dir1a/src", it)
			assertEquals("dir2/dir2a/bin", output.getOutputDirectory(it))
		]
		keyPaths.get(1) => [
			assertEquals("dir3/dir3a/src-gen", it)
			assertEquals("dir2/dir2a/bin", output.getOutputDirectory(it))
		]
	}

	@Test def void testprojectConfigMultipleSourceDirs6() {
		batchCompiler.sourcePath = '''dir1/ws/prj1/dir2/dir3/dir4/src1«File.pathSeparator»dir1/ws/prj1/dir2/dir3/src2«File.
			pathSeparator»dir1/ws/prj1/dir2/src3«File.pathSeparator»dir1/ws/prj1/src4'''
		batchCompiler.outputPath = '''dir1/ws/prj1/dir2/dir3/dir4/dir5/bin'''

		batchCompiler.compile

		val project = batchCompiler.projectConfig
		assertEquals("prj1", project.name)
		val output = batchCompiler.outputConfiguration
		assertEquals(4, project.sourceFolders.size)
		val keyPaths = project.sourceFolders.map[name].sort
		keyPaths.get(0) => [
			assertEquals("dir2/dir3/dir4/src1", it)
			assertEquals("dir2/dir3/dir4/dir5/bin", output.getOutputDirectory(it))
		]
		keyPaths.get(1) => [
			assertEquals("dir2/dir3/src2", it)
			assertEquals("dir2/dir3/dir4/dir5/bin", output.getOutputDirectory(it))
		]
		keyPaths.get(2) => [
			assertEquals("dir2/src3", it)
			assertEquals("dir2/dir3/dir4/dir5/bin", output.getOutputDirectory(it))
		]
		keyPaths.get(3) => [
			assertEquals("src4", it)
			assertEquals("dir2/dir3/dir4/dir5/bin", output.getOutputDirectory(it))
		]
	}

	@Test def void testprojectConfigSameDir() {
		batchCompiler.sourcePath = "ws/prj1"
		batchCompiler.outputPath = "ws/prj1"

		assertFalse(batchCompiler.compile)
		assertNull(batchCompiler.projectConfig)
	}

	@Test def void testprojectConfigWithoutCommonProjectDir() {
		batchCompiler.sourcePath = '''/tmp/ws/prj1/src'''
		batchCompiler.outputPath = '''/usr/local/tmp/ws/prj1/bin'''

		batchCompiler.compile
		assertNull(batchCompiler.projectConfig)
		assertNull(batchCompiler.outputConfiguration)
	}

	@Test def void testprojectConfigWithoutCommonWorkspaceDir() {
		batchCompiler.sourcePath = '''/some_non_existing_folder/src'''
		batchCompiler.outputPath = '''/some_non_existing_folder/bin'''

		batchCompiler.compile
		assertNull(batchCompiler.projectConfig)
		assertNull(batchCompiler.outputConfiguration)
	}

	@Test def void testprojectConfigWithTopLevelCommonWorkspaceDir() {
		batchCompiler.sourcePath = '''/tmp/prj/src'''
		batchCompiler.outputPath = '''/tmp/prj/bin'''
		batchCompiler.compile
		assertNotNull(batchCompiler.projectConfig)
		assertNotNull(batchCompiler.outputConfiguration)
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
	@Ignore
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
		val logs = LoggingTester.captureLogging(Level.ERROR, XtendBatchCompiler)[
			assertFalse(batchCompiler.compile)
		]
		logs.assertNumberOfLogEntries(1)
	}

	@Test
	def void testActiveAnnotatons2() {
		batchCompiler.sourcePath = "./batch-compiler-data/activeAnnotations2"
		assertTrue(batchCompiler.compile)
		val javaFiles = new File(OUTPUT_DIRECTORY + "/mypackage").list[dir, name|name.endsWith(".java")].join(",")
		assertEquals("Client.java", javaFiles)
		val txtFile = new File(OUTPUT_DIRECTORY + "/Test.txt")
		assertTrue(txtFile.exists)
	}

	@Test
	def void testBug443800() {
		batchCompiler.sourcePath = "./batch-compiler-data/bug443800"
		assertTrue(batchCompiler.compile)
		val javaFiles = new File(OUTPUT_DIRECTORY + "/").list[dir, name|name.endsWith(".java")].join(",")
		assertEquals("Bug443800.java", javaFiles)
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
	def void testCompileTestDataWithStorage() {
		batchCompiler.writeStorageFiles = true
		batchCompiler.compile
		assertEquals(7, new File(OUTPUT_DIRECTORY + "/test").list[dir, name|name.endsWith(".java")].size)
		assertEquals(5, new File(OUTPUT_DIRECTORY + "/test").list[dir, name|name.endsWith(".xtendbin")].size)
	}

	@Test
	def void testCompileTestDataWithoutStorage() {
		batchCompiler.writeStorageFiles = false
		batchCompiler.compile
		assertEquals(7, new File(OUTPUT_DIRECTORY + "/test").list[dir, name|name.endsWith(".java")].size)
		assertEquals(0, new File(OUTPUT_DIRECTORY + "/test").list[dir, name|name.endsWith(".xtendbin")].size)
	}

	@Test
    def void testCompileSymlinkedResource() {
        val tstResources = new File("./batch-compiler-data/test-resources/").toURI().normalize().getPath()
        val wsRootFile = new File(tstResources, "symlink-test-ws/")
        val wsRootPath = wsRootFile.getPath()
        val linkToCreate = wsRootPath + "/plain-folder/linked-src"
        if (!createSymLink(tstResources + "/linked-folder/linked-src/", linkToCreate)) {
            System.err.println(
                "Symlink creation is not possible - skip test. org.eclipse.xtend.core.tests.compiler.batch.TestBatchCompiler.testCompileSymlinkedResource()")
            return
        }
        assertTrue("plain-folder/linked-src/ is a symlink", isSymlink(new File(wsRootFile, "plain-folder/linked-src/")))
        assertTrue("plain-folder/src/ is not a symlink", !isSymlink(new File(wsRootFile, "plain-folder/src/")))
        batchCompiler.writeTraceFiles = true
        batchCompiler.sourcePath = wsRootPath + "/plain-folder/src" + File.pathSeparator + wsRootPath +
            "/plain-folder/linked-src"
        val customOutput = wsRootPath + "/plain-folder/target"
        batchCompiler.outputPath = customOutput
        assertTrue(batchCompiler.compile)
        assertTrue(new File(wsRootPath + "/plain-folder/target/Test.txt").exists)
        assertEquals(2, new File(customOutput).list[dir, name|name.endsWith(".java")].size)
        assertEquals(2, new File(customOutput).list[dir, name|name.endsWith("._trace")].size)

    }

	def private boolean createSymLink(String linkTarget, String link) {
		var File linkFile = new File(link)
		abfalleimer.add(linkFile)
		if (linkFile.exists() && linkFile.symlink) {
			return true
		}
		var String[] cmd = #["ln", "-s", linkTarget, link]
		try {
			println("Exec: " + cmd.join(' '))
			val proc = Runtime.getRuntime.exec(cmd)
			return proc.waitFor == 0
		} catch (IOException ioe) {
			return false
		}
	}

	def private boolean isSymlink(File file) {
		var File canon
		if (file.getParent() == null) {
			canon = file
		} else {
			var File canonDir = file.getParentFile().getCanonicalFile()
			canon = new File(canonDir, file.getName())
		}
		return !canon.getCanonicalFile().equals(canon.getAbsoluteFile())
	}
	
	def private String getContents(String fileName) {
		Files.toString(new File(fileName), Charsets.UTF_8)
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
	
	@Test
	def void testNoSuppressWarningsAnnotations() {
		batchCompiler.generateSyntheticSuppressWarnings = false
		batchCompiler.sourcePath = "./batch-compiler-data/xtendClass"
		assertTrue(batchCompiler.compile)
		assertFalse((OUTPUT_DIRECTORY + "/XtendA.java").contents.contains("@SuppressWarnings"))
	}
	
	@Test
	def void testGeneratedAnnotation() {
		batchCompiler.generateGeneratedAnnotation = true
		batchCompiler.sourcePath = "./batch-compiler-data/xtendClass"
		assertTrue(batchCompiler.compile)
		assertTrue((OUTPUT_DIRECTORY + "/XtendA.java").contents.contains("@Generated"))
	}
	
	@Test
	def void testGeneratedAnnotationComment() {
		batchCompiler.generateGeneratedAnnotation = true
		batchCompiler.generatedAnnotationComment = "FooComment"
		batchCompiler.sourcePath = "./batch-compiler-data/xtendClass"
		assertTrue(batchCompiler.compile)
		val generated = (OUTPUT_DIRECTORY + "/XtendA.java").contents
		assertTrue(generated.contains("@Generated"))
		assertTrue(generated.contains("FooComment"))
	}
	
	@Test
	def void testGeneratedAnnotationDate1() {
		batchCompiler.generateGeneratedAnnotation = true
		batchCompiler.includeDateInGeneratedAnnotation = true
		batchCompiler.sourcePath = "./batch-compiler-data/xtendClass"
		assertTrue(batchCompiler.compile)
		val generated = (OUTPUT_DIRECTORY + "/XtendA.java").contents
		assertTrue(generated.contains("@Generated"))
		assertTrue(generated.contains("date ="))
	}
	
	@Test
	def void testJavaVersion5() {
		batchCompiler.javaSourceVersion = "1.5"
		batchCompiler.sourcePath = "./batch-compiler-data/javaVersion"
		assertTrue(batchCompiler.compile)
		val generated = (OUTPUT_DIRECTORY + "/XtendA.java").contents
		assertFalse(generated.contains("@Override"))
		assertTrue(generated.contains("new Function1<Integer, String>"))
	}
	
	@Test
	def void testJavaVersion6() {
		batchCompiler.javaSourceVersion = "1.6"
		batchCompiler.sourcePath = "./batch-compiler-data/javaVersion"
		assertTrue(batchCompiler.compile)
		val generated = (OUTPUT_DIRECTORY + "/XtendA.java").contents
		assertTrue(generated.contains("@Override"))
		assertTrue(generated.contains("new Function1<Integer, String>"))
	}
	
	@Test
	def void testJavaVersion7() {
		batchCompiler.javaSourceVersion = "1.7"
		batchCompiler.sourcePath = "./batch-compiler-data/javaVersion"
		assertTrue(batchCompiler.compile)
		val generated = (OUTPUT_DIRECTORY + "/XtendA.java").contents
		assertTrue(generated.contains("@Override"))
		assertTrue(generated.contains("new Function1<Integer, String>"))
	}
	
	@Test
	def void testJavaVersion8() {
		batchCompiler.javaSourceVersion = "1.8"
		batchCompiler.sourcePath = "./batch-compiler-data/javaVersion"
		assertTrue(batchCompiler.compile)
		val generated = (OUTPUT_DIRECTORY + "/XtendA.java").contents
		assertTrue(generated.contains("@Override"))
		assertTrue(generated.contains("(Integer it) ->"))
	}
}
