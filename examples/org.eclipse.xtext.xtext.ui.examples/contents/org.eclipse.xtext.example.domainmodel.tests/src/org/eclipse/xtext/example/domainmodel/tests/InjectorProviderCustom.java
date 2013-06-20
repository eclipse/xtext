package org.eclipse.xtext.example.domainmodel.tests;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.xtext.example.domainmodel.DomainmodelInjectorProvider;
import org.eclipse.xtext.example.domainmodel.DomainmodelRuntimeModule;
import org.eclipse.xtext.example.domainmodel.DomainmodelStandaloneSetup;
import org.eclipse.xtext.xbase.compiler.OnTheFlyJavaCompiler;
import org.eclipse.xtext.xbase.compiler.OnTheFlyJavaCompiler.EclipseRuntimeDependentJavaCompiler;
import org.eclipse.xtext.xbase.junit.evaluation.AbstractXbaseEvaluationTest;
import org.eclipse.xtext.xbase.lib.Functions;

import com.google.common.base.Supplier;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provider;

public class InjectorProviderCustom extends DomainmodelInjectorProvider {

	public Injector internalCreateInjector() {
			return new DomainmodelStandaloneSetup() {
				@Override
				public Injector createInjector() {
					return Guice.createInjector(new DomainmodelRuntimeModule() {
						@Override
						public ClassLoader bindClassLoaderToInstance() {
							return InjectorProviderCustom.class
									.getClassLoader();
						}

						@SuppressWarnings("unused")
						public Class<? extends OnTheFlyJavaCompiler> bindOnTheFlyJavaCompiler() {
							try {
								if (ResourcesPlugin.getWorkspace() != null)
									return EclipseRuntimeDependentJavaCompiler.class;
							} catch (Exception e) {
								// ignore
							}
							return OnTheFlyJavaCompiler.class;
						}
						
						@SuppressWarnings("unused")
						public Class<? extends OnTheFlyJavaCompiler.ClassPathAssembler> bindClassPathAssembler() {
							return TestClassPathAssembler.class;
						}
					});
				}
			}.createInjectorAndDoEMFRegistration();
	}

	public static class TestClassPathAssembler extends
			OnTheFlyJavaCompiler.ClassPathAssembler {
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
