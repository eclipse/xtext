/*******************************************************************************
 * Copyright (c) 2010, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.compiler;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.compiler.output.FakeTreeAppendable;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.junit.ComparisonFailure;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.eclipse.xtext.xbase.tests.XbaseInjectorProvider;

/**
 * @author Stephane Galland - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XbaseInjectorProvider.class)
public class ConstantInlineExpansionTest {
	
	@Inject
	private Provider<XbaseCompiler> compilerProvider;

	@Inject
	private ParseHelper<XExpression> parseHelper;

	@Inject
	private ValidationTestHelper validationHelper;
	
	@Inject
	private CommonTypeComputationServices services;
	
	@Inject
	private IResourceScopeCache cache;

	@Test
	public void constantExpansion() throws Exception {
		String source = "(new org.eclipse.xtext.xbase.tests.compiler.ConstantInlineExpansionData()).value";
		final String expected = "\nint _value = 1;\nreturn Integer.valueOf(_value);";
		final String actual = compileToJavaCode(source);
		if (!expected.equals(actual)) {
			throw new ComparisonFailure("Not same Java code", expected, actual);
		}
	}
	
	/** The generated Java code is invalid because the ConstantInlineExpansionData#getValue2()
	 * function is not marked with a constantExpression inline.
	 * THE INVALID CODE IS THE EXPECTED RESULT.
	 */
	@Test
	public void invalidConstantExpansion() throws Exception {
		String source = "(new org.eclipse.xtext.xbase.tests.compiler.ConstantInlineExpansionData()).value2";
		final String expected = "\nint _value2 = new org.eclipse.xtext.xbase.tests.compiler.ConstantInlineExpansionData().1;\nreturn Integer.valueOf(_value2);";
		final String actual = compileToJavaCode(source);
		if (!expected.equals(actual)) {
			throw new ComparisonFailure("Not same Java code", expected, actual);
		}
	}

	protected String compileToJavaCode(String xtendCode) {
		XExpression model = null;
		ITreeAppendable appendable = new FakeTreeAppendable();
		try {
			model = expression(xtendCode, true);
			XbaseCompiler compiler = this.compilerProvider.get();
			LightweightTypeReference objectRef = new StandardTypeReferenceOwner(this.services, model).newReferenceToObject();
			compiler.compile(model, appendable, objectRef);
		} catch (Exception e) {
			throw new RuntimeException("Xtend compilation failed", e);
		} finally {
			if (model != null)
				this.cache.clear(model.eResource());
		}
		return appendable.getContent();
	}

	protected XExpression expression(String string, boolean resolve) throws Exception {
		XExpression result = this.parseHelper.parse(string);
		if (resolve) {
			this.validationHelper.assertNoErrors(result);
		}
		return result;
	}

}

