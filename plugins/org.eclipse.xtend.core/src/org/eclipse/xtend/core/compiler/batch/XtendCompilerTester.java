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

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XtendCompilerTester {
	
	@Inject CompilationTestHelper compilationTestHelper;
	@Inject ProcessorInstanceForJvmTypeProvider instanceForJvmTypeProvider;
	
	public XtendCompilerTester(Class<?> ...classesOnClassPath) {
		XtendInjectorSingleton.INJECTOR.injectMembers(this);
		compilationTestHelper.setJavaCompilerClassPath(classesOnClassPath);
		instanceForJvmTypeProvider.setClassLoader(getClass().getClassLoader());
	}
	
	public void assertCompilesTo(CharSequence source, final CharSequence expected) {
		try {
			compilationTestHelper.assertCompilesTo(source, expected);
		} catch (IOException e) {
			Exceptions.sneakyThrow(e);
		}
	}

	public void compile(CharSequence source, final IAcceptor<CompilationResult> acceptor) {
		try {
			compilationTestHelper.compile(source, new IAcceptor<CompilationTestHelper.Result>() {
				public void accept(final Result t) {
					acceptor.accept(new CompilationResult() {

						public Map<String, String> getGeneratedCode() {
							return t.getGeneratedCode();
						}

						public String getGeneratedCode(String typeName) {
							return t.getGeneratedCode(typeName);
						}

						public String getSingleGeneratedCode() {
							return t.getSingleGeneratedCode();
						}

						public Class<?> getCompiledClass() {
							return t.getCompiledClass();
						}

						public Class<?> getCompiledClass(String className) {
							return t.getCompiledClass(className);
						}

						public Map<String, CharSequence> getAllGeneratedResources() {
							return t.getAllGeneratedResources();
						}
						
						CompilationUnitImpl compilationUnitImpl;
						{
							compilationUnitImpl = new CompilationUnitImpl();
							XtendFile xtendFile = (XtendFile)t.getResourceSet().getResources().get(0).getContents().get(0);
							compilationUnitImpl.setXtendFile(xtendFile);
						}
						
						public CompilationUnit getCompilationUnit() {
							return compilationUnitImpl;
						}
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
