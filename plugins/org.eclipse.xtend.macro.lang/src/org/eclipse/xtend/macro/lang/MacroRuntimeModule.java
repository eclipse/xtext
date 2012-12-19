/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.macro.lang;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.core.conversion.XtendValueConverterService;
import org.eclipse.xtend.core.featurecalls.XtendIdentifiableSimpleNameProvider;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.linking.XtendLinkingDiagnosticMessageProvider;
import org.eclipse.xtend.core.naming.XtendQualifiedNameProvider;
import org.eclipse.xtend.core.resource.XtendLocationInFileProvider;
import org.eclipse.xtend.core.resource.XtendResource;
import org.eclipse.xtend.core.scoping.XtendImportedNamespaceScopeProvider;
import org.eclipse.xtend.core.scoping.XtendScopeProvider;
import org.eclipse.xtend.core.typing.XtendExpressionHelper;
import org.eclipse.xtend.core.typing.XtendTypeProvider;
import org.eclipse.xtend.core.validation.XtendEarlyExitValidator;
import org.eclipse.xtend.macro.lang.resource.MacroResourceDescriptionStrategy;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.IndexingOrderer.IndexingPriorityProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.xbase.featurecalls.IdentifiableSimpleNameProvider;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xbase.util.XExpressionHelper;
import org.eclipse.xtext.xbase.validation.EarlyExitValidator;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class MacroRuntimeModule extends org.eclipse.xtend.macro.lang.AbstractMacroRuntimeModule {

	public Class<? extends IDefaultResourceDescriptionStrategy> bindIDefaultResourceDescriptionStrategy() {
		return MacroResourceDescriptionStrategy.class;
	}
		
	public Class<? extends XExpressionHelper> bindXExpressionHelper() {
		return XtendExpressionHelper.class;
	}
	
	@Override
	public Class<? extends ITypeProvider> bindITypeProvider() {
		return XtendTypeProvider.class;
	}
	
	@Override
	public Class<? extends XtextResource> bindXtextResource() {
		return XtendResource.class;
	}
	
	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return XtendValueConverterService.class;
	}
	
	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return XtendScopeProvider.class;
	}
	
	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return XtendQualifiedNameProvider.class;
	}
	
	@Override
	public Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return super
				.bindIGlobalScopeProvider();
	}
	
	@Override
	public void configureIScopeProviderDelegate(Binder binder) {
		binder.bind(IScopeProvider.class).annotatedWith(Names.named(AbstractDeclarativeScopeProvider.NAMED_DELEGATE))
		.to(XtendImportedNamespaceScopeProvider.class);
	}
	
	@Override
	public Class<? extends IdentifiableSimpleNameProvider> bindIdentifiableSimpleNameProvider() {
		return XtendIdentifiableSimpleNameProvider.class;
	}
	
	public Class<? extends JvmModelAssociator> bindJvmModelAssociator() {
		return IXtendJvmAssociations.Impl.class;
	}

	public Class<? extends EarlyExitValidator> bindEarlyExitValidator() {
		return XtendEarlyExitValidator.class;
	}
	
	@Override
	public Class<? extends ILocationInFileProvider> bindILocationInFileProvider() {
		return XtendLocationInFileProvider.class;
	}

	public Class<? extends ILinkingDiagnosticMessageProvider> bindILinkingDiagnosticMessageProvider() {
		return XtendLinkingDiagnosticMessageProvider.class;
	}
	
	public IndexingPriorityProvider bindIndexingPriorityProvider() {
		return new IndexingPriorityProvider() {
			@Override
			public int getIndexingPriority(ResourceSet resourceSet, URI uri) {
				return 42; //higher then 0, which is Xtend's priority
			}
		};
	}
}
