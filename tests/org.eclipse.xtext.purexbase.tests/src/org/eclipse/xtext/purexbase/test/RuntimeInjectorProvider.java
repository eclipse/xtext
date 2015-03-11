/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.purexbase.test;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.xtext.purexbase.PureXbaseInjectorProvider;
import org.eclipse.xtext.purexbase.PureXbaseStandaloneSetup;
import org.eclipse.xtext.xbase.compiler.OnTheFlyJavaCompiler;
import org.eclipse.xtext.xbase.compiler.OnTheFlyJavaCompiler.EclipseRuntimeDependentJavaCompiler;
import org.eclipse.xtext.xbase.junit.evaluation.AbstractXbaseEvaluationTest;
import org.eclipse.xtext.xbase.lib.Functions;

import com.google.common.base.Supplier;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provider;

public class RuntimeInjectorProvider extends PureXbaseInjectorProvider {

	@Override
	protected Injector internalCreateInjector() {
		return new PureXbaseStandaloneSetup() {
			public Injector createInjector() {
				return Guice.createInjector(new org.eclipse.xtext.purexbase.PureXbaseRuntimeModule() {
					public ClassLoader bindClassLoaderToInstance() {
						return RuntimeInjectorProvider.class.getClassLoader();
					}
					
					@SuppressWarnings("unused")
					public Class<? extends OnTheFlyJavaCompiler.ClassPathAssembler> bindClassPathAssembler() {
						return TestClassPathAssembler.class;
					}
					
					@SuppressWarnings("unused")
					public Class<? extends OnTheFlyJavaCompiler> bindOnTheFlyJavaCompiler() {
						try {
							if (ResourcesPlugin.getWorkspace() != null)
								return EclipseRuntimeDependentJavaCompiler.class;
						} catch(Exception e) {
							// ignore
						}
						return OnTheFlyJavaCompiler.class;
					}
				});
			}
		}.createInjectorAndDoEMFRegistration();
	}
	
	public static class TestClassPathAssembler extends OnTheFlyJavaCompiler.ClassPathAssembler {
		@Override
		public void assembleCompilerClassPath(OnTheFlyJavaCompiler compiler) {
			super.assembleCompilerClassPath(compiler);
			if (compiler instanceof EclipseRuntimeDependentJavaCompiler) {
				compiler.addClassPathOfClass(getClass());
				compiler.addClassPathOfClass(AbstractXbaseEvaluationTest.class);
				compiler.addClassPathOfClass(Functions.class);
				compiler.addClassPathOfClass(Provider.class);
				compiler.addClassPathOfClass(javax.inject.Provider.class);
				compiler.addClassPathOfClass(Supplier.class);
			}
		}
	}
	
}
