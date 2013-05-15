/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import com.google.inject.Inject
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.xbase.compiler.DisableCodeGenerationAdapter
import org.eclipse.xtext.xbase.compiler.GeneratorConfig
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator
import org.eclipse.xtext.xbase.compiler.OnTheFlyJavaCompiler
import org.junit.Before
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.xbase.XExpression
import com.google.common.base.Objects
import bug380058.Amount
import org.eclipse.xtext.generator.trace.ITraceRegionProviderimport org.eclipse.xtext.generator.IFilePostProcessor

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
abstract class AbstractXtendCompilerTest extends AbstractXtendTestCase {
	
	@Inject protected JvmModelGenerator generator
	@Inject protected IGeneratorConfigProvider generatorConfigProvider
	@Inject protected OnTheFlyJavaCompiler compiler
	@Inject protected IFilePostProcessor postProcessor
	
	protected boolean useJavaCompiler = false
	
	@Before
	public def setupCompiler() {
		compiler.addClassPathOfClass(class)
		compiler.addClassPathOfClass(typeof(Amount))
		compiler.addClassPathOfClass(typeof(Data))
		compiler.addClassPathOfClass(typeof(Inject))
		compiler.addClassPathOfClass(typeof(CollectionLiterals))
		compiler.addClassPathOfClass(typeof(JvmTypeParameter))
		compiler.addClassPathOfClass(typeof(ITraceRegionProvider))
		compiler.addClassPathOfClass(typeof(XExpression))
		compiler.addClassPathOfClass(typeof(Objects))
		compiler.setParentClassLoader(class.classLoader)
	}
	
	def assertCompilesTo(CharSequence input, CharSequence expected){
		assertCompilesTo(input, expected, generatorConfigProvider.get(null))
	}

	def void assertCompilesTo(CharSequence input, CharSequence expected, GeneratorConfig config) {
		doAssertCompilesTo(input, expected, config)
	}
	
	protected def doAssertCompilesTo(CharSequence input, CharSequence expected, GeneratorConfig config) {
		val file = file(input.toString(), true)
		val inferredType = file.eResource.contents.filter(typeof(JvmDeclaredType)).head
		assertFalse(DisableCodeGenerationAdapter::isDisabled(inferredType))
		var javaCode = generator.generateType(inferredType, config);
		javaCode = postProcessor.postProcess(null, javaCode);
		XtendCompilerTest::assertEquals(expected.toString, javaCode.toString);
		if (useJavaCompiler && file.xtendTypes.size == 1) {
			val typeName = if (file.package != null) {
				file.package + '.' + file.xtendTypes.head.name
			} else {
				file.xtendTypes.head.name
			}
			compiler.compileToClass(typeName, expected.toString)
		}
		return file
	}
	
}