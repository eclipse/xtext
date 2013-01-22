/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests;

import org.eclipse.xtend.core.XtendRuntimeModule;
import org.eclipse.xtend.core.XtendStandaloneSetup;
import org.eclipse.xtend.core.compiler.XtendCompiler2;
import org.eclipse.xtend.core.jvmmodel.XtendJvmModelInferrer2;
import org.eclipse.xtend.core.typesystem.DispatchAndExtensionAwareReentrantTypeResolver;
import org.eclipse.xtend.core.typesystem.ExtensionAwareScopeProvider;
import org.eclipse.xtend.core.typesystem.XtendTypeComputer;
import org.eclipse.xtend.core.validation.XtendJavaValidator;
import org.eclipse.xtend.core.validation.XtendJavaValidator2;
import org.eclipse.xtend.core.xtend.XtendFactory;
import org.eclipse.xtext.common.types.util.FeatureOverridesService;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.common.types.util.VisibilityService;
import org.eclipse.xtext.linking.LinkingScopeProviderBinding;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.service.SingletonBinding;
import org.eclipse.xtext.xbase.annotations.typesystem.XbaseWithAnnotationsBatchScopeProvider;
import org.eclipse.xtext.xbase.annotations.typesystem.XbaseWithAnnotationsTypeComputer;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer2;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.interpreter.IExpressionInterpreter;
import org.eclipse.xtext.xbase.interpreter.impl.XbaseInterpreter2;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer;
import org.eclipse.xtext.xbase.resource.BatchLinkableResource;
import org.eclipse.xtext.xbase.scoping.batch.IBatchScopeProvider;
import org.eclipse.xtext.xbase.scoping.batch.XbaseBatchScopeProvider;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputer;
import org.eclipse.xtext.xbase.typesystem.internal.DefaultBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver;
import org.eclipse.xtext.xbase.typesystem.internal.LogicalContainerAwareBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.legacy.LegacyFeatureOverridesService;
import org.eclipse.xtext.xbase.typesystem.legacy.LegacyTypeArgumentContextProvider;
import org.eclipse.xtext.xbase.typesystem.legacy.LegacyVisibilityService;
import org.eclipse.xtext.xbase.typesystem.legacy.XbaseBatchTypeProvider;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xbase.validation.FeatureNameValidator;
import org.eclipse.xtext.xbase.validation.LogicalContainerAwareFeatureNameValidator;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings({ "deprecation", "unused" })
public class NewTypeSystemRuntimeTestSetup extends XtendStandaloneSetup {
	
	@Override
	public Injector createInjector() {
		return Guice.createInjector(new XtendRuntimeModule() {
			@Override
			public ClassLoader bindClassLoaderToInstance() {
				return AbstractXtendTestCase.class.getClassLoader();
			}
			
			public XtendFactory bindXtendFactory() {
				return XtendFactory.eINSTANCE;
			}
			
			@Override
			public void configureLinkingIScopeProvider(Binder binder) {
				binder.bind(IScopeProvider.class).annotatedWith(LinkingScopeProviderBinding.class)
						.to(ExtensionAwareScopeProvider.class);
			}
			
			public Class<? extends IBatchScopeProvider> bindIBatchScopeProvider() {
				return ExtensionAwareScopeProvider.class;
			}
			
			@Override
			public Class<? extends XtextResource> bindXtextResource() {
				return BatchLinkableResource.class;
			}
			
			@Override
			public Class<? extends ITypeProvider> bindITypeProvider() {
				return XbaseBatchTypeProvider.class;
			}
			
			public Class<? extends DefaultBatchTypeResolver> bindDefaultBatchTypeResolver() {
				return LogicalContainerAwareBatchTypeResolver.class;
			}
			
			public Class<? extends DefaultReentrantTypeResolver> bindReentrantTypeResolver() {
				return DispatchAndExtensionAwareReentrantTypeResolver.class;
			}
			
			public Class<? extends ITypeComputer> bindTypeComputer() {
				return XtendTypeComputer.class;
			}
			
			public Class<? extends XbaseBatchScopeProvider> bindBatchScopeProvider() {
				return XbaseWithAnnotationsBatchScopeProvider.class;
			}
			
			@Override
			public Class<? extends XbaseCompiler> bindXbaseCompiler() {
				return XtendCompiler2.class;
			}
			
			@Override
			public Class<? extends IExpressionInterpreter> bindIExpressionInterpreter() {
				return XbaseInterpreter2.class;
			}
			
			@Override
			public Class<? extends IJvmModelInferrer> bindIJvmModelInferrer() {
				return XtendJvmModelInferrer2.class;
			}
			
			@Override
			public Class<? extends XtendJavaValidator> bindXtendJavaValidator() {
				return null;
			}
			
			@SingletonBinding(eager = true)
			public Class<? extends XtendJavaValidator2> bindXtendJavaValidator2() {
				return XtendJavaValidator2.class;
			}
			
			public Class<? extends VisibilityService> bindVisibilityService() {
				return LegacyVisibilityService.class;
			}
			
			public Class<? extends FeatureOverridesService> bindFeatureOverridesService() {
				return LegacyFeatureOverridesService.class;
			}
			
			@Override
			public Class<? extends TypeArgumentContextProvider> bindTypeArgumentContextProvider() {
				return LegacyTypeArgumentContextProvider.class;
			}
			
			public Class<? extends TypeReferenceSerializer> bindTypeReferenceSerializer() {
				return TypeReferenceSerializer2.class;
			}
			
			public Class<? extends FeatureNameValidator> bindFeatureNameValidator() {
				return LogicalContainerAwareFeatureNameValidator.class;
			}
		});
	}
}