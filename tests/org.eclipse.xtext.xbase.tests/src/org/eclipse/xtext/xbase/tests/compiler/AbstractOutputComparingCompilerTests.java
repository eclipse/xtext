/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.compiler;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.compiler.output.FakeTreeAppendable;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.legacy.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractOutputComparingCompilerTests extends AbstractXbaseTestCase {
	
	@Inject
	private IBatchTypeResolver typeResolver;
	
	@Inject
	private CommonTypeComputationServices services;
	
	@Inject
	private TypeReferences typeReferences;

	protected void assertCompilesTo(final CharSequence expectedJavaCode, final CharSequence xbaseCode) throws Exception {
		XExpression model = expression(xbaseCode.toString(),true);
		XbaseCompiler compiler = get(XbaseCompiler.class);
		ITreeAppendable tracing = new FakeTreeAppendable();
		LightweightTypeReference returnType = typeResolver.resolveTypes(model).getReturnType(model);
		if (returnType == null) {
			throw new IllegalStateException();
		}
		compiler.compile(model, tracing, returnType);
		assertEquals(expectedJavaCode.toString().trim(), tracing.getContent().toString().trim());
	}
	
	protected void assertCompilesToStatement(final CharSequence expectedJavaCode, final CharSequence xbaseCode) throws Exception {
		XExpression model = expression(xbaseCode.toString(),true);
		XbaseCompiler compiler = get(XbaseCompiler.class);
		ITreeAppendable tracing = new FakeTreeAppendable();
		JvmType voidType = typeReferences.findDeclaredType(Void.TYPE, model);
		ParameterizedTypeReference voidRef = new ParameterizedTypeReference(new StandardTypeReferenceOwner(services, model), voidType);
		compiler.compile(model, tracing, voidRef);
		assertEquals(expectedJavaCode, tracing.getContent());
	}
	
	protected void compilesTo(final CharSequence xbaseCode, final CharSequence result) throws Exception {
		assertCompilesTo(result, xbaseCode);
	}
}
