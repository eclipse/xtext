/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import bug380058.Amount
import com.google.common.collect.Lists
import com.google.inject.Inject
import javax.inject.Provider
import org.antlr.runtime.Lexer
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.core.macro.ProcessorInstanceForJvmTypeProvider
import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.generator.IFilePostProcessor
import org.eclipse.xtext.generator.trace.ITraceRegionProvider
import org.eclipse.xtext.util.concurrent.IReadAccess
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper
import org.eclipse.xtext.xbase.compiler.DisableCodeGenerationAdapter
import org.eclipse.xtext.xbase.compiler.GeneratorConfig
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator
import org.hamcrest.Matcher
import org.hamcrest.core.Is
import org.junit.Assert
import org.junit.Before
import testdata.Annotation1

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
abstract class AbstractXtendCompilerTest extends AbstractXtendTestCase {
	
	@Inject protected JvmModelGenerator generator
	@Inject protected IGeneratorConfigProvider generatorConfigProvider
	@Inject protected IFilePostProcessor postProcessor
	@Inject protected extension CompilationTestHelper compilationTestHelper
	@Inject ProcessorInstanceForJvmTypeProvider processorProvider
	
	protected boolean useJavaCompiler = false
	
	@Before
	public def setupCompiler() {
		val Class<?>[] classes = #[
			getClass(),
			Amount,
			Data,
			Inject,
			Provider,
			Lexer,
			InternalXtendLexer,
			IReadAccess,
			CollectionLiterals,
			JvmTypeParameter,
			ITraceRegionProvider,
			XExpression,
			Object,
			Annotation1,
			Lists,
			EObject,
			Matcher,
			Is,
			Assert]
		compilationTestHelper.setJavaCompilerClassPath(classes)
		processorProvider.classLoader = class.classLoader
	}
	
	def void assertCompilesTo(CharSequence input, CharSequence expected) {
		doAssertCompilesTo(input, expected, generatorConfigProvider.get(null), false)
	}
	
	protected def doAssertCompilesTo(CharSequence input, CharSequence expected, GeneratorConfig config,
			boolean serializeAllTypes) {
		val file = file(input.toString(), true)
		val results = newArrayList
		for (inferredType : file.eResource.contents.filter(typeof(JvmDeclaredType))) {
			assertFalse(DisableCodeGenerationAdapter::isDisabled(inferredType))
			var javaCode = generator.generateType(inferredType, config);
			javaCode = postProcessor.postProcess(null, javaCode);
			results += javaCode
			if (useJavaCompiler) {
				compilationTestHelper.compile(input) [
					it.compiledClass
				]
			}
		}
		if (serializeAllTypes)
			XtendCompilerTest::assertEquals(expected.toString, results.join('\n'))
		else
			XtendCompilerTest::assertEquals(expected.toString, results.head.toString)
		return file
	}
	
}