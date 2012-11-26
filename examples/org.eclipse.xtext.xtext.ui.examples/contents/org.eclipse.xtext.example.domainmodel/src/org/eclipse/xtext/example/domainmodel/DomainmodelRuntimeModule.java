/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel;

import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.example.domainmodel.valueconverter.DomainmodelValueConverterService;
import org.eclipse.xtext.linking.LinkingScopeProviderBinding;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler2;
import org.eclipse.xtext.xbase.interpreter.IExpressionInterpreter;
import org.eclipse.xtext.xbase.interpreter.impl.XbaseInterpreter2;
import org.eclipse.xtext.xbase.resource.BatchLinkableResource;
import org.eclipse.xtext.xbase.scoping.batch.XbaseBatchScopeProvider;
import org.eclipse.xtext.xbase.typesystem.internal.DefaultBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver;
import org.eclipse.xtext.xbase.typesystem.internal.LogicalContainerAwareBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.internal.LogicalContainerAwareReentrantTypeResolver;
import org.eclipse.xtext.xbase.typesystem.legacy.XbaseBatchTypeProvider;
import org.eclipse.xtext.xbase.typing.ITypeProvider;

import com.google.inject.Binder;

/**
 * used to register components to be used within the IDE.
 */
public class DomainmodelRuntimeModule extends AbstractDomainmodelRuntimeModule {
	
	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return DomainmodelValueConverterService.class;
	}
	
	@Override
	public void configureLinkingIScopeProvider(Binder binder) {
		binder.bind(IScopeProvider.class).annotatedWith(LinkingScopeProviderBinding.class)
				.to(XbaseBatchScopeProvider.class);
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
		return LogicalContainerAwareReentrantTypeResolver.class;
	}
	
	public Class<? extends XbaseCompiler> bindCompiler() {
		return XbaseCompiler2.class;
	}
	
	@Override
	public Class<? extends IExpressionInterpreter> bindIExpressionInterpreter() {
		return XbaseInterpreter2.class;
	}
	
}
