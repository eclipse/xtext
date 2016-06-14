/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.compiler;

import org.eclipse.xtext.util.JavaVersion;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.GeneratorConfig;
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.compiler.output.FakeTreeAppendable;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
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
	private IGeneratorConfigProvider generatorConfigProvider;
	
	protected void assertCompilesTo(final CharSequence expectedJavaCode, final CharSequence xbaseCode) throws Exception {
		assertCompilesTo(expectedJavaCode, xbaseCode, generatorConfigProvider.get(null));
	}
	
	protected void assertCompilesTo(final CharSequence expectedJavaCode, final CharSequence xbaseCode,
			JavaVersion javaVersion) throws Exception {
		GeneratorConfig generatorConfig = generatorConfigProvider.get(null);
		generatorConfig.setJavaSourceVersion(javaVersion);
		assertCompilesTo(expectedJavaCode, xbaseCode, generatorConfig);
	}
	
	protected void assertCompilesTo(final CharSequence expectedJavaCode, final CharSequence xbaseCode,
			GeneratorConfig generatorConfig) throws Exception {
		XExpression model = expression(xbaseCode.toString(),true);
		XbaseCompiler compiler = get(XbaseCompiler.class);
		FakeTreeAppendable tracing = new FakeTreeAppendable();
		tracing.setGeneratorConfig(generatorConfig);
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
		StandardTypeReferenceOwner owner = new StandardTypeReferenceOwner(services, model);
		LightweightTypeReference voidRef = owner.newReferenceTo(Void.TYPE);
		compiler.compile(model, tracing, voidRef);
		assertEquals(expectedJavaCode, tracing.getContent());
	}
	
	protected void compilesTo(final CharSequence xbaseCode, final CharSequence result) throws Exception {
		assertCompilesTo(result, xbaseCode);
	}
	
	protected void compilesTo(final CharSequence xbaseCode, final CharSequence result,
			JavaVersion javaVersion) throws Exception {
		assertCompilesTo(result, xbaseCode, javaVersion);
	}
	
	protected void compilesTo(final CharSequence xbaseCode, final CharSequence result,
			Pair<JavaVersion, JavaVersion> minAndMaxVersion) throws Exception {
		int min = minAndMaxVersion.getKey().ordinal();
		int max = minAndMaxVersion.getValue().ordinal();
		if (min > max)
			throw new IllegalArgumentException();
		for (int i = min; i <= max; i++) {
			JavaVersion version = JavaVersion.values()[i];
			assertCompilesTo(result, xbaseCode, version);
		}
	}
	
	protected void compilesTo(final CharSequence xbaseCode, final CharSequence result,
			GeneratorConfig generatorConfig) throws Exception {
		assertCompilesTo(result, xbaseCode, generatorConfig);
	}
	
}
