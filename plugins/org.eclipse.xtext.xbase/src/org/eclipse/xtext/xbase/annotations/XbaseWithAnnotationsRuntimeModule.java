/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.annotations;

import org.eclipse.xtext.common.types.util.FeatureOverridesService;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.common.types.util.VisibilityService;
import org.eclipse.xtext.linking.LinkingScopeProviderBinding;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.service.SingletonBinding;
import org.eclipse.xtext.xbase.annotations.scoping.XbaseWithAnnotationsScopeProvider;
import org.eclipse.xtext.xbase.annotations.typesystem.XbaseWithAnnotationsBatchScopeProvider;
import org.eclipse.xtext.xbase.annotations.typesystem.XbaseWithAnnotationsTypeComputer;
import org.eclipse.xtext.xbase.annotations.typing.XbaseWithAnnotationsTypeProvider;
import org.eclipse.xtext.xbase.annotations.validation.XbaseWithAnnotationsJavaValidator;
import org.eclipse.xtext.xbase.annotations.validation.XbaseWithAnnotationsJavaValidator2;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer2;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler2;
import org.eclipse.xtext.xbase.interpreter.IExpressionInterpreter;
import org.eclipse.xtext.xbase.interpreter.impl.XbaseInterpreter2;
import org.eclipse.xtext.xbase.resource.BatchLinkableResource;
import org.eclipse.xtext.xbase.scoping.batch.IBatchScopeProvider;
import org.eclipse.xtext.xbase.scoping.batch.XbaseBatchScopeProvider;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputer;
import org.eclipse.xtext.xbase.typesystem.legacy.LegacyFeatureOverridesService;
import org.eclipse.xtext.xbase.typesystem.legacy.LegacyTypeArgumentContextProvider;
import org.eclipse.xtext.xbase.typesystem.legacy.LegacyVisibilityService;
import org.eclipse.xtext.xbase.typesystem.legacy.XbaseBatchTypeProvider;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xbase.typing.XbaseTypeProvider;

import com.google.inject.Binder;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
@SuppressWarnings("deprecation")
public class XbaseWithAnnotationsRuntimeModule extends org.eclipse.xtext.xbase.annotations.AbstractXbaseWithAnnotationsRuntimeModule {
	
	public Class<? extends XbaseTypeProvider> bindXbaseTypeProvider() {
		return XbaseWithAnnotationsTypeProvider.class;
	}
	
	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return XbaseWithAnnotationsScopeProvider.class;
	}
	
	@Override
	public void configureLinkingIScopeProvider(Binder binder) {
		binder.bind(IScopeProvider.class).annotatedWith(LinkingScopeProviderBinding.class)
				.to(IBatchScopeProvider.class);
	}

	@Override
	public Class<? extends XtextResource> bindXtextResource() {
		return BatchLinkableResource.class;
	}

	@Override
	public Class<? extends ITypeProvider> bindITypeProvider() {
		return XbaseBatchTypeProvider.class;
	}
	
	@Override
	public Class<? extends IExpressionInterpreter> bindIExpressionInterpreter() {
		return XbaseInterpreter2.class;
	}
	
	public Class<? extends XbaseCompiler> bindCompiler() {
		return XbaseCompiler2.class;
	}
	
	public Class<? extends ITypeComputer> bindITypeComputer() {
		return XbaseWithAnnotationsTypeComputer.class;
	}
	
	public Class<? extends XbaseBatchScopeProvider> bindBatchScopeProvider() {
		return XbaseWithAnnotationsBatchScopeProvider.class;
	}
	
	@Override
	@SingletonBinding(eager=true)	
	public Class<? extends XbaseWithAnnotationsJavaValidator> bindXbaseWithAnnotationsJavaValidator() {
		return null;
	}
	
	@SingletonBinding(eager=true)	
	public Class<? extends XbaseWithAnnotationsJavaValidator2> bindDefaultXbaseValidator() {
		return XbaseWithAnnotationsJavaValidator2.class;
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
	
}
