/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase;

import org.eclipse.xtext.common.types.util.FeatureOverridesService;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.common.types.util.VisibilityService;
import org.eclipse.xtext.linking.LinkingScopeProviderBinding;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.serializer.tokens.SerializerScopeProviderBinding;
import org.eclipse.xtext.service.SingletonBinding;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer2;
import org.eclipse.xtext.xbase.interpreter.IExpressionInterpreter;
import org.eclipse.xtext.xbase.interpreter.impl.XbaseInterpreter;
import org.eclipse.xtext.xbase.resource.BatchLinkableResource;
import org.eclipse.xtext.xbase.scoping.batch.XbaseBatchScopeProvider;
import org.eclipse.xtext.xbase.serializer.SerializerScopeProvider;
import org.eclipse.xtext.xbase.typesystem.legacy.LegacyFeatureOverridesService;
import org.eclipse.xtext.xbase.typesystem.legacy.LegacyTypeArgumentContextProvider;
import org.eclipse.xtext.xbase.typesystem.legacy.LegacyVisibilityService;
import org.eclipse.xtext.xbase.typesystem.legacy.XbaseBatchTypeProvider;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xbase.validation.XbaseJavaValidator;
import org.eclipse.xtext.xbase.validation.XbaseJavaValidator2;

import com.google.inject.Binder;

/**
 * Use this class to register components to be used within the IDE.
 */
@SuppressWarnings("deprecation")
public class XbaseRuntimeModule extends AbstractXbaseRuntimeModule {
	
	@Override
	public void configureLinkingIScopeProvider(Binder binder) {
		binder.bind(IScopeProvider.class).annotatedWith(LinkingScopeProviderBinding.class)
				.to(XbaseBatchScopeProvider.class);
	}
	
	@Override
	public void configureSerializerIScopeProvider(Binder binder) {
		binder.bind(IScopeProvider.class).annotatedWith(SerializerScopeProviderBinding.class)
				.to(SerializerScopeProvider.class);
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
		return XbaseInterpreter.class;
	}
	
	@Override
	@SingletonBinding(eager=true)	
	public Class<? extends XbaseJavaValidator> bindXbaseJavaValidator() {
		return null;
	}
	
	@SingletonBinding(eager=true)	
	public Class<? extends XbaseJavaValidator2> bindDefaultXbaseValidator() {
		return XbaseJavaValidator2.class;
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
