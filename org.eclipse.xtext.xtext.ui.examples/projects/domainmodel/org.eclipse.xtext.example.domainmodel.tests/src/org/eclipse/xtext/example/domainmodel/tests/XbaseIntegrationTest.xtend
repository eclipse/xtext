/*******************************************************************************
 * Copyright (c) 2013, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.tests

import com.google.inject.Inject
import org.eclipse.xtext.example.domainmodel.domainmodel.DomainModel
import org.eclipse.xtext.generator.InMemoryFileSystemAccess
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator
import org.eclipse.xtext.xbase.testing.OnTheFlyJavaCompiler2
import org.eclipse.xtext.xbase.testing.evaluation.AbstractXbaseEvaluationTest
import org.junit.runner.RunWith

/**
 * Xbase integration test.
 *
 * runs all Xbase tests from {@link AbstractXbaseEvaluationTest} in the context of an
 * entity operation.
 *
 * Unsupported features can be disabled by overriding the respective test method.
 *
 * @author Sven Efftinge
 */
@RunWith(XtextRunner)
@InjectWith(DomainmodelInjectorProvider)
class XbaseIntegrationTest extends AbstractXbaseEvaluationTest {

	@Inject OnTheFlyJavaCompiler2 javaCompiler

	@Inject extension ParseHelper<DomainModel>

	@Inject extension ValidationTestHelper

	@Inject JvmModelGenerator generator

	protected override invokeXbaseExpression(String expression) {
		val model = ("entity Foo { op doStuff() : Object { "+expression+" } } ").parse
		model.assertNoErrors
		val fsa = new InMemoryFileSystemAccess
		generator.doGenerate(model.eResource, fsa)
		val concatenation = fsa.textFiles.values.iterator.next
		val clazz = javaCompiler.compileToClass("Foo", concatenation.toString)
		val foo = clazz.declaredConstructor.newInstance
		val method = clazz.getDeclaredMethod("doStuff")
		method.invoke(foo)
	}

}