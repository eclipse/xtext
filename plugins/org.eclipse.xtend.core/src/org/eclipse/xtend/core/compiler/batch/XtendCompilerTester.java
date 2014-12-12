/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.compiler.batch;

import java.io.IOException;
import java.util.Map;

import org.eclipse.xtend.core.XtendInjectorSingleton;
import org.eclipse.xtend.core.macro.ProcessorInstanceForJvmTypeProvider;
import org.eclipse.xtend.core.macro.TransformationContextImpl;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.CompilationUnit;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper;
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper.Result;
import org.eclipse.xtext.xbase.lib.Exceptions;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XtendCompilerTester {
	
	public static XtendCompilerTester newXtendCompilerTester(Class<?> ...classesOnClassPath) {
		XtendCompilerTester instance = XtendInjectorSingleton.INJECTOR.getInstance(XtendCompilerTester.class);
		instance.setJavaCompilerClassPath(classesOnClassPath);
		ProcessorInstanceForJvmTypeProvider processorProvider = XtendInjectorSingleton.INJECTOR.getInstance(ProcessorInstanceForJvmTypeProvider.class);
		processorProvider.setClassLoader(XtendCompilerTester.class.getClassLoader());
		return instance;
	}
	
	public void setJavaCompilerClassPath(Class<?>[] classesOnClassPath) {
		compilationTestHelper.setJavaCompilerClassPath(classesOnClassPath);
	}

	@Inject CompilationTestHelper compilationTestHelper;
	@Inject ProcessorInstanceForJvmTypeProvider instanceForJvmTypeProvider;
	@Inject Provider<CompilationUnitImpl> compilationUnitProvider;
	
	public void assertCompilesTo(CharSequence source, final CharSequence expected) {
		try {
			compilationTestHelper.configureFreshWorkspace();
			compilationTestHelper.assertCompilesTo(source, expected);
		} catch (IOException e) {
			Exceptions.sneakyThrow(e);
		}
	}

	public void compile(CharSequence source, final IAcceptor<CompilationResult> acceptor) {
		try {
			compilationTestHelper.configureFreshWorkspace();
			compilationTestHelper.compile(source, new IAcceptor<CompilationTestHelper.Result>() {
				@Override
				public void accept(final Result t) {
					acceptor.accept(new CompilationResult() {

						@Override
						public Map<String, String> getGeneratedCode() {
							return t.getGeneratedCode();
						}

						@Override
						public String getGeneratedCode(String typeName) {
							return t.getGeneratedCode(typeName);
						}

						@Override
						public String getSingleGeneratedCode() {
							return t.getSingleGeneratedCode();
						}

						@Override
						public Class<?> getCompiledClass() {
							return t.getCompiledClass();
						}

						@Override
						public Class<?> getCompiledClass(String className) {
							return t.getCompiledClass(className);
						}

						@Override
						public Map<String, CharSequence> getAllGeneratedResources() {
							return t.getAllGeneratedResources();
						}
						
						CompilationUnitImpl compilationUnitImpl;
						{
							compilationUnitImpl = compilationUnitProvider.get();
							XtendFile xtendFile = (XtendFile)t.getResourceSet().getResources().get(0).getContents().get(0);
							compilationUnitImpl.setXtendFile(xtendFile);
						}
						
						@Override
						public CompilationUnit getCompilationUnit() {
							return compilationUnitImpl;
						}
						@Override
						public TransformationContext getTransformationContext() {
							TransformationContextImpl transformationContextImpl = new TransformationContextImpl();
							transformationContextImpl.setUnit(compilationUnitImpl);
							return transformationContextImpl;
						}
					});
				}
			});
		} catch (IOException e) {
			Exceptions.sneakyThrow(e);
		}
	}
	
	public static interface CompilationResult {
		
		Map<String,String> getGeneratedCode();

		String getGeneratedCode(String typeName);
		
		String getSingleGeneratedCode();

		Class<?> getCompiledClass();
		
		Class<?> getCompiledClass(String className);

		Map<String, CharSequence> getAllGeneratedResources();
		
		CompilationUnit getCompilationUnit();
		
		TransformationContext getTransformationContext();
	}
}
