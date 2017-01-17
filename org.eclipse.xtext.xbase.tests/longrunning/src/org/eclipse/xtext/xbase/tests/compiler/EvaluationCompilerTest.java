/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.compiler;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.testing.OnTheFlyJavaCompiler2;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.compiler.output.FakeTreeAppendable;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.junit.evaluation.AbstractXbaseEvaluationTest;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.tests.XbaseInjectorProvider;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.junit.runner.RunWith;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XbaseInjectorProvider.class)
public class EvaluationCompilerTest extends AbstractXbaseEvaluationTest {
	
	@Inject
	private Provider<XbaseCompiler> compilerProvider;
	
	@Inject
	private ParseHelper<XExpression> parseHelper;
	
	@Inject
	private ValidationTestHelper validationHelper;

	@Inject
	private OnTheFlyJavaCompiler2 javaCompiler;
	
	@Inject
	private CommonTypeComputationServices services;
	
	@Inject
	private IResourceScopeCache cache;
	
	@Override
	protected void assertEvaluatesTo(Object object, String string) {
		final String compileToJavaCode = compileToJavaCode(string);
		try {
			assertEquals("Java code was " + compileToJavaCode, object, compile(string).apply());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(compileToJavaCode);
			fail("Exception thrown " + e + ".Java code was " + compileToJavaCode);
		}
	}

	@Override
	protected void assertEvaluatesToArray(Object[] object, String string) {
		final String compileToJavaCode = compileToJavaCode(string);
		try {
			Object result = compile(string).apply();
			assertArrayEquals("Java code was " + compileToJavaCode, object, (Object[]) result);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(compileToJavaCode);
			fail("Exception thrown " + e + ".Java code was " + compileToJavaCode);
		}
	}

	@Override
	protected void assertEvaluatesWithException(Class<? extends Throwable> class1, String string) {
		try {
			Function0<Object> compile = null;
			try {
				compile = compile(string);
			} catch (Exception e) {
				throw new WrappedException(e);
			}
			compile.apply();
			fail("expected exception " + class1.getCanonicalName() + ". Java code was " + compileToJavaCode(string));
		} catch (AssertionError e) {
			throw e;
		} catch (Throwable e) {
			if (!class1.isInstance(e))
				e.printStackTrace();
			assertTrue("expected " + class1.getCanonicalName() + " but was " + e, class1.isInstance(e));
		}
	}

	protected Functions.Function0<Object> compile(String code) {
		String javaCode = compileToJavaCode(code);
		try {
			Function0<Object> function = javaCompiler.createFunction(javaCode, Object.class);
			return function;
		} catch (Exception e) {
			throw new RuntimeException("Java compilation failed. Java code was : \n" + javaCode, e);
		}
	}
	
	protected String compileToJavaCode(String xtendCode) {
		XExpression model = null;
		ITreeAppendable appendable = new FakeTreeAppendable();
		try {
			model = expression(xtendCode, true);
			XbaseCompiler compiler = compilerProvider.get();
			LightweightTypeReference objectRef = new StandardTypeReferenceOwner(services, model).newReferenceToObject();
			compiler.compile(model, appendable, objectRef);
		} catch (Exception e) {
			throw new RuntimeException("Xtend compilation failed", e);
		} finally {
			if (model != null)
				cache.clear(model.eResource());
		}
		return appendable.getContent();
	}

	protected XExpression expression(String string, boolean resolve) throws Exception {
		XExpression result = parseHelper.parse(string);
		if (resolve) {
			validationHelper.assertNoErrors(result);
		}
		return result;
	}
	
}
