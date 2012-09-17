/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem;

import java.lang.reflect.AnnotatedElement;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.access.ClasspathTypeProviderFactory;
import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider;
import org.eclipse.xtext.common.types.access.impl.DeclaredTypeFactory;
import org.eclipse.xtext.linking.LinkingScopeProviderBinding;
import org.eclipse.xtext.resource.SynchronizedXtextResourceSet;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.xbase.XbaseRuntimeModule;
import org.eclipse.xtext.xbase.XbaseStandaloneSetup;
import org.eclipse.xtext.xbase.scoping.batch.XbaseBatchScopeProvider;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase.SynchronizedXtextResourceSetProvider;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AvoidDeprecatedTypeSystemStandaloneSetup extends XbaseStandaloneSetup {
	
	public static Injector setup() {
		return new AvoidDeprecatedTypeSystemStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
	
	@Override
	public Injector createInjector() {
		return Guice.createInjector(new XbaseRuntimeModule() {
			@Override
			public ClassLoader bindClassLoaderToInstance() {
				return AbstractXbaseTestCase.class.getClassLoader();
			}
			@SuppressWarnings("unused")
			public Class<? extends Provider<SynchronizedXtextResourceSet>> provideSynchronizedResourceSet() {
				return SynchronizedXtextResourceSetProvider.class;
			}
			@Override
			public Class<? extends IScopeProvider> bindIScopeProvider() {
				return DisabledXbaseScopeProvider.class;
			}
			
			@Override
			public void configureLinkingIScopeProvider(Binder binder) {
				binder.bind(IScopeProvider.class).annotatedWith(LinkingScopeProviderBinding.class).to(XbaseBatchScopeProvider.class);
			}
			
			@SuppressWarnings("unused")
			public Class<? extends ClasspathTypeProviderFactory> bindClasspathTypeProviderFactory() {
				return ClasspathTypeProviderFactoryWithoutAnnotationValues.class;
			}
		});
	}
	
	@SuppressWarnings("deprecation")
	public static class DisabledXbaseScopeProvider extends org.eclipse.xtext.xbase.scoping.XbaseScopeProvider {
		@Override
		public IScope getScope(EObject context, EReference reference) {
			throw new UnsupportedOperationException();
		}
	}
	
	public static class ClasspathTypeProviderFactoryWithoutAnnotationValues extends ClasspathTypeProviderFactory {

		@Inject
		public ClasspathTypeProviderFactoryWithoutAnnotationValues(ClassLoader classLoader) {
			super(classLoader);
		}
		
		@Override
		protected ClasspathTypeProvider createClasspathTypeProvider(ResourceSet resourceSet) {
			return new ClasspathTypeProvider(getClassLoader(), resourceSet, getIndexedJvmTypeAccess()) {
				@Override
				protected DeclaredTypeFactory createDeclaredTypeFactory() {
					return new DeclaredTypeFactory(getClassURIHelper()) {
						@Override
						protected void createAnnotationValues(AnnotatedElement annotated, JvmAnnotationTarget result) {
							// disabled
						}
					};
				}
			};
		}
		
	}
}
