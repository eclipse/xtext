package org.eclipse.xtext.xtend2.standalone.tests

import com.google.inject.Inject
import java.io.File
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xtend2.compiler.batch.Xtend2BatchCompiler
import org.junit.runner.RunWith

import static org.eclipse.xtext.util.Files.*
import static junit.framework.Assert.*
import org.junit.Test
import org.junit.Before
import org.junit.After

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(XtendInjectorProvider))
class TestBatchCompiler {
	
	@Inject
	Xtend2BatchCompiler batchCompiler
	
    static String OUTPUT_DIRECTORY = "./test-result"
    static String TEMP_DIRECTORY = "./test-temp-dir"
    static String XTEND_SRC_DIRECTORY = "./testdata"

	@Before
	def void onSetup () {
        batchCompiler.sourcePath = XTEND_SRC_DIRECTORY
        batchCompiler.outputPath = OUTPUT_DIRECTORY
        batchCompiler.deleteTempDirectory = true
        new File(OUTPUT_DIRECTORY).mkdir
        cleanFolder(new File(OUTPUT_DIRECTORY), null, true, false)
	}

	@After
	def void onTearDown() {
       cleanFolder(new File(OUTPUT_DIRECTORY), null, true, true)
       if (new File(TEMP_DIRECTORY).exists) {
        cleanFolder(new File(TEMP_DIRECTORY), null, true, true)
       }
	}

	@Test
	def void testCompileTestData() {
		batchCompiler.compile
		assertEquals(2, new File(OUTPUT_DIRECTORY+"/test").list.size)
	}

	@Test
	def void tempDirectory() {
        batchCompiler.deleteTempDirectory = false
        batchCompiler.tempDirectory = TEMP_DIRECTORY
        assertTrue(batchCompiler.compile)
        assertEquals(2, new File(batchCompiler.tempDirectory).list.size)
        assertTrue(batchCompiler.compile)
        assertEquals(4, new File(batchCompiler.tempDirectory).list.size)
	}

	@Test
    def void deleteTempDirectory() {
        batchCompiler.deleteTempDirectory = true
        batchCompiler.tempDirectory = TEMP_DIRECTORY
        assertTrue(batchCompiler.compile)
        assertEquals(0, new File(TEMP_DIRECTORY).list.size)
    }
}