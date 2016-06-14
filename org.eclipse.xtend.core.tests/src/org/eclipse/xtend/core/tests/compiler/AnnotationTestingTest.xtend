/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import com.google.common.io.Files
import com.google.inject.Inject
import java.io.File
import java.nio.charset.Charset
import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.CodeGenerationContext
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.eclipse.xtext.junit4.TemporaryFolder
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper
import org.junit.Rule
import org.junit.Test

/**
 * @author svenefftinge - Initial contribution and API
 */
class AnnotationTestingTest extends AbstractXtendCompilerTest {
	
	@Rule @Inject public TemporaryFolder temporaryFolder
	
	@Test def void testPath() {
		val sourceFileUri = compilationTestHelper.copyToWorkspace(CompilationTestHelper.PROJECT_NAME+"/res/template.txt", '''
			foo,bar,baz
		''')
		'''@org.eclipse.xtend.core.tests.compiler.MyAnnotation class Foo {}'''.compile [
			val compiledClass = it.compiledClass
			assertEquals(3,compiledClass.declaredFields.size)
			assertTrue(compiledClass.declaredFields.exists[name=='foo'])
			assertTrue(compiledClass.declaredFields.exists[name=='bar'])
			assertTrue(compiledClass.declaredFields.exists[name=='baz'])
			val targetFileUri = sourceFileUri.trimSegments(2).appendSegment("xtend-gen").appendSegment("out.txt")
			val targetFile = new File (targetFileUri.toFileString)
			val result = Files.toString(targetFile, Charset.defaultCharset)
			assertEquals("foo|bar|baz",result.trim)
		]
	}
}

@Active(FileProcessor)
annotation MyAnnotation {
}
class FileProcessor extends AbstractClassProcessor {
	
	override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {
		val path = annotatedClass.compilationUnit.filePath
		val contents = path.projectFolder.append("res/template.txt").contents.toString
		val segments = contents.trim.split(',')
		for (segment : segments) {
			annotatedClass.addField(segment) [
				type = string
			]
		}
	}
	
	override doGenerateCode(ClassDeclaration annotatedClass, extension CodeGenerationContext context) {
		val path = annotatedClass.compilationUnit.filePath
		val result = path.targetFolder.append("out.txt")
		val segments = path.projectFolder.append("res/template.txt").contents.toString.split(',')
		result.contents = '''«FOR seg : segments SEPARATOR '|'»«seg»«ENDFOR»'''
	}
		
}

