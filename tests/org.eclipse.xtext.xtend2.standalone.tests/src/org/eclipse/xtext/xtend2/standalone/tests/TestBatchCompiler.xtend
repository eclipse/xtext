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

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(XtendInjectorProvider))
class TestBatchCompiler {
	
	@Inject
	Xtend2BatchCompiler batchCompiler
	
	@Test
	def void testCompileTestData() {
		val out = "./test-result"
		val src = "./testdata"
		
		batchCompiler.sourcePath = src
		batchCompiler.outputPath = out
		
		new File(out).mkdir
		cleanFolder(new File(out), null, true, false)
		batchCompiler.compile
		assertEquals(2, new File(out+"/test").list.size)
		cleanFolder(new File(out), null, true, true)
	}
}