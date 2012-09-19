/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.compiler;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.compiler.output.FakeTreeAppendable;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typing.ITypeProvider;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractOutputComparingCompilerTests extends AbstractXbaseTestCase {
	
	@Inject
	private ITypeProvider typeProvider;
	
	@Inject
	private TypeReferences typeReferences;

	protected void assertCompilesTo(final CharSequence expectedJavaCode, final CharSequence xbaseCode) throws Exception {
		XExpression model = expression(xbaseCode.toString(),true);
		XbaseCompiler compiler = get(XbaseCompiler.class);
		ITreeAppendable tracing = new FakeTreeAppendable();
		JvmTypeReference returnType = typeProvider.getCommonReturnType(model, true);
		compiler.compile(model, tracing, returnType);
		assertEquals(expectedJavaCode.toString().trim(), tracing.getContent().toString().trim());
	}
	
	protected void assertCompilesToStatement(final CharSequence expectedJavaCode, final CharSequence xbaseCode) throws Exception {
		XExpression model = expression(xbaseCode.toString(),true);
		XbaseCompiler compiler = get(XbaseCompiler.class);
		ITreeAppendable tracing = new FakeTreeAppendable();
		compiler.compile(model, tracing, typeReferences.getTypeForName(Void.TYPE, model));
		assertEquals(expectedJavaCode, tracing.getContent());
	}
	
	protected void compilesTo(final CharSequence xbaseCode, final CharSequence result) throws Exception {
		assertCompilesTo(result, xbaseCode);
	}
}
