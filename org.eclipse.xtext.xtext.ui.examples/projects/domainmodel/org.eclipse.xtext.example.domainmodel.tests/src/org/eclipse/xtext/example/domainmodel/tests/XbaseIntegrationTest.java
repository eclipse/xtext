/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.domainmodel.tests;

import java.lang.reflect.Method;

import org.eclipse.xtext.example.domainmodel.domainmodel.DomainModel;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.testing.OnTheFlyJavaCompiler2;
import org.eclipse.xtext.xbase.testing.evaluation.AbstractXbaseEvaluationTest;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 * Xbase integration test.
 * 
 * Runs all Xbase tests from {@link AbstractXbaseEvaluationTest} in the context
 * of an entity operation.
 * 
 * Unsupported features can be disabled by overriding the respective test
 * method.
 * 
 * @author Sven Efftinge
 */
@RunWith(XtextRunner.class)
@InjectWith(DomainmodelInjectorProvider.class)
public class XbaseIntegrationTest extends AbstractXbaseEvaluationTest {
	@Inject
	private OnTheFlyJavaCompiler2 javaCompiler;

	@Inject
	private ParseHelper<DomainModel> parseHelper;

	@Inject
	private ValidationTestHelper validationTestHelper;

	@Inject
	private JvmModelGenerator generator;

	@Override
	protected Object invokeXbaseExpression(String expression) throws Exception {
		DomainModel model = parseHelper.parse("entity Foo { op doStuff() : Object { " + expression + " } } ");
		validationTestHelper.assertNoErrors(model);
		InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
		generator.doGenerate(model.eResource(), fsa);
		CharSequence concatenation = fsa.getTextFiles().values().iterator().next();
		Class<?> clazz = javaCompiler.compileToClass("Foo", concatenation.toString());
		Object foo = clazz.getDeclaredConstructor().newInstance();
		Method method = clazz.getDeclaredMethod("doStuff");
		return method.invoke(foo);
	}
}
