/*******************************************************************************
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import com.google.inject.Inject
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.generator.IFilePostProcessor
import org.eclipse.xtext.xbase.testing.CompilationTestHelper
import org.eclipse.xtext.xbase.compiler.DisableCodeGenerationAdapter
import org.eclipse.xtext.xbase.compiler.GeneratorConfig
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator
import org.junit.Before
import org.eclipse.xtend.core.xtend.XtendFile

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
abstract class AbstractXtendCompilerTest extends AbstractXtendTestCase {
	
	@Inject protected JvmModelGenerator generator
	@Inject protected IGeneratorConfigProvider generatorConfigProvider
	@Inject protected IFilePostProcessor postProcessor
	@Inject protected extension CompilationTestHelper compilationTestHelper
	
	protected boolean useJavaCompiler = false
	
	@Before
	def setupCompiler() {
		compilationTestHelper.javaCompilerClassPath = class.classLoader
	}
	
	def void assertCompilesTo(CharSequence input, CharSequence expected) {
		doAssertCompilesTo(input, expected, generatorConfigProvider.get(null), false)
	}
	
	protected def doAssertCompilesTo(CharSequence input, CharSequence expected, GeneratorConfig config,
			boolean serializeAllTypes) {
		val file = file(input.toString(), true)
		val results = compile(file, input, config)
		if (serializeAllTypes)
			assertEquals(expected.toString, results.join('\n'))
		else
			assertEquals(expected.toString, results.head.toString)
		return file
	}
	
	def void assertFilesCompileTo(Iterable<XtendFile> xtendFiles, CharSequence... expected) {
		val config = generatorConfigProvider.get(null)
		var i = 0;
		for (XtendFile file : xtendFiles) {
			val results = compile(file, null, config)
			assertEquals(expected.get(i).toString, results.head.toString)
			i++;
		}	
	}
	
	private def compile(XtendFile file, CharSequence input, GeneratorConfig config) {
		val results = newArrayList
		for (inferredType : file.eResource.contents.filter(typeof(JvmDeclaredType))) {
			assertFalse(DisableCodeGenerationAdapter::isDisabled(inferredType))
			var javaCode = generator.generateType(inferredType, config);
			javaCode = postProcessor.postProcess(null, javaCode);
			results += javaCode
			if (useJavaCompiler && input !== null) {
				compilationTestHelper.compile(input) [
					it.compiledClass
				]
			}
		}
		return results
	}
	
}