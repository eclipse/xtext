/*******************************************************************************
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.compiler.batch;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.XtendInjectorSingleton;
import org.eclipse.xtend.core.macro.ProcessorInstanceForJvmTypeProvider;
import org.eclipse.xtend.core.macro.TransformationContextImpl;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.ProblemImpl;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.CompilationUnit;
import org.eclipse.xtend.lib.macro.declaration.Element;
import org.eclipse.xtend.lib.macro.services.Problem;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.JavaVersion;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.eclipse.xtext.xbase.testing.CompilationTestHelper;
import org.eclipse.xtext.xbase.testing.CompilationTestHelper.Result;
import org.eclipse.xtext.xbase.lib.Exceptions;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XtendCompilerTester {
	
	@Deprecated
	public static XtendCompilerTester newXtendCompilerTester(Class<?> ...classesOnClassPath) {
		XtendCompilerTester instance = XtendInjectorSingleton.INJECTOR.getInstance(XtendCompilerTester.class);
		instance.setJavaCompilerClassPath(classesOnClassPath);
		return instance;
	}
	
	/**
	 * @since 2.9
	 */
	public static XtendCompilerTester newXtendCompilerTester(ClassLoader classesOnClassPath) {
		XtendCompilerTester instance = XtendInjectorSingleton.INJECTOR.getInstance(XtendCompilerTester.class);
		instance.setJavaCompilerClassPath(classesOnClassPath);
		return instance;
	}
	
	@Deprecated
	public void setJavaCompilerClassPath(Class<?>[] classesOnClassPath) {
		compilationTestHelper.setJavaCompilerClassPath(classesOnClassPath);
	}
	
	/**
	 * @since 2.9
	 */
	public void setJavaCompilerClassPath(ClassLoader classPath) {
		compilationTestHelper.setJavaCompilerClassPath(classPath);
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

	/**
	 * @since 2.13
	 */
	public void assertCompilesTo(CharSequence source, final CharSequence expected, JavaVersion javaVersion) {
		compilationTestHelper.setJavaVersion(javaVersion);
		assertCompilesTo(source, expected);
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
						public List<? extends Problem> getProblems(Element element) {
							return getTransformationContext().getProblems(element);
						}
						
						@Override
						public List<? extends Problem> getAllProblems() {
							Resource resource = compilationUnitImpl.getXtendFile().eResource();
							Iterable<EObjectDiagnosticImpl> issues = Iterables.filter(Iterables.concat(resource.getErrors(), resource.getWarnings()), EObjectDiagnosticImpl.class); 
							List<Problem> result = Lists.newArrayList(Iterables.transform(issues, new Function<EObjectDiagnosticImpl, Problem>() {

								@Override
								public Problem apply(EObjectDiagnosticImpl diag) {
									ProblemImpl result = new ProblemImpl(diag.getCode(), diag.getMessage(), translateSeverity(diag.getSeverity()));
									return result;
								}

								private org.eclipse.xtend.lib.macro.services.Problem.Severity translateSeverity(Severity severity) {
									switch (severity) {
										case ERROR : return Problem.Severity.ERROR;
										case WARNING : return Problem.Severity.WARNING;
										case INFO : return Problem.Severity.INFO;
										case IGNORE : return Problem.Severity.IGNORE;
										default: throw new IllegalArgumentException(String.valueOf(severity));
									}
								}
							}));
							return result;
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
	
	/**
	 * @since 2.8
	 * @noimplement This interface is not intended to be implemented by clients.
	 * @noextend This interface is not intended to be extended by clients.
	 */
	public static interface CompilationResult {
		
		Map<String,String> getGeneratedCode();

		String getGeneratedCode(String typeName);
		
		String getSingleGeneratedCode();

		Class<?> getCompiledClass();
		
		Class<?> getCompiledClass(String className);

		Map<String, CharSequence> getAllGeneratedResources();
		
		CompilationUnit getCompilationUnit();
		
		TransformationContext getTransformationContext();
		
		/**
		 * @since 2.8
		 */
		List<? extends Problem> getProblems(Element element);
		
		/**
		 * @since 2.8
		 */
		List<? extends Problem> getAllProblems();
	}
}
