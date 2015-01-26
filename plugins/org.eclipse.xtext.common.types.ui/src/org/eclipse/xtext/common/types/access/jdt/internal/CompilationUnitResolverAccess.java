/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.WorkingCopyOwner;
import org.eclipse.jdt.core.dom.ASTRequestor;
import org.eclipse.jdt.internal.compiler.CompilationResult;
import org.eclipse.jdt.internal.compiler.ICompilerRequestor;
import org.eclipse.jdt.internal.compiler.IErrorHandlingPolicy;
import org.eclipse.jdt.internal.compiler.IProblemFactory;
import org.eclipse.jdt.internal.compiler.env.INameEnvironment;
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CompilationUnitResolverAccess implements IErrorHandlingPolicy, ICompilerRequestor {

	private static final Constructor<?> constructor;
	private static final Method resolveMethod;
	static {
		try {
			Class<?> clazz = Class.forName("org.eclipse.jdt.core.dom.CompilationUnitResolver");
			constructor = clazz.getDeclaredConstructor(INameEnvironment.class, IErrorHandlingPolicy.class,
					CompilerOptions.class, ICompilerRequestor.class, IProblemFactory.class, IProgressMonitor.class,
					Boolean.TYPE);
			constructor.setAccessible(true);
			resolveMethod = clazz.getDeclaredMethod("resolve", ICompilationUnit[].class, String[].class,
					ASTRequestor.class, Integer.TYPE, Map.class, WorkingCopyOwner.class, Integer.TYPE);
			resolveMethod.setAccessible(true);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private final INameEnvironment environment;
	private final CompilerOptions compilerOptions;
	private final IProblemFactory problemFactory;
	private final boolean fromJavaProject;

	public CompilationUnitResolverAccess(INameEnvironment environment, CompilerOptions compilerOptions,
			IProblemFactory problemFactory, boolean fromJavaProject) {
		this.environment = environment;
		this.compilerOptions = compilerOptions;
		this.problemFactory = problemFactory;
		this.fromJavaProject = fromJavaProject;

	}

	public void resolve(ICompilationUnit[] compilationUnits, String[] bindingKeys, ASTRequestor astRequestor,
			int apiLevel, Map<?, ?> options, WorkingCopyOwner owner, int flags) {
		try {
			Object resolver = constructor.newInstance(environment, this, this.compilerOptions, this, problemFactory, null,
					fromJavaProject);
			resolveMethod.invoke(resolver, compilationUnits, bindingKeys, astRequestor, apiLevel, options,
					owner, flags);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean stopOnFirstError() {
		return false;
	}

	@Override
	public boolean proceedOnErrors() {
		return false; // stop if there are some errors
	}

	@Override
	public boolean ignoreAllErrors() {
		return false;
	}

	@Override
	public void acceptResult(CompilationResult compilationResult) {
		// do nothing
	}
}
