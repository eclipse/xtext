/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.IJvmTypeConformanceComputer;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.linking.LinkingScopeProviderBinding;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.typing.ITypeConformanceComputer;
import org.eclipse.xtext.xbase.conversion.XbaseValueConverterService;
import org.eclipse.xtext.xbase.interpreter.IEvaluationContext;
import org.eclipse.xtext.xbase.interpreter.IExpressionInterpreter;
import org.eclipse.xtext.xbase.interpreter.impl.DefaultEvaluationContext;
import org.eclipse.xtext.xbase.interpreter.impl.XbaseInterpreter;
import org.eclipse.xtext.xbase.linking.XbaseLinkingScopeProvider;
import org.eclipse.xtext.xbase.resource.XbaseResource;
import org.eclipse.xtext.xbase.scoping.XbaseImportedNamespaceScopeProvider;
import org.eclipse.xtext.xbase.typing.IXExpressionTypeProvider;
import org.eclipse.xtext.xbase.typing.XExpressionTypeProvider;
import org.eclipse.xtext.xbase.typing.XbaseTypeConformanceComputer;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Use this class to register components to be used within the IDE.
 */
public class XbaseRuntimeModule extends AbstractXbaseRuntimeModule {
	
	@Override
	public Class<? extends XtextResource> bindXtextResource() {
		return XbaseResource.class;
	}
	
	public Class<? extends IEvaluationContext> bindEvaluationContext() {
		return DefaultEvaluationContext.class;
	}
	
	public Class<? extends IJvmTypeConformanceComputer> bindIJvmTypeConformanceComputer() {
		return XbaseTypeConformanceComputer.class;
	}
	
	public Class<? extends IExpressionInterpreter> bindInterpreter() {
		return XbaseInterpreter.class;
	}
	
	public Class<? extends IQualifiedNameConverter> bindIQualifiedNameConverter() {
		return XbaseQualifiedNameConverter.class;
	}
	
	public Class<? extends IXExpressionTypeProvider> bindIXExpressionTypeProvider() {
		return XExpressionTypeProvider.class;
	}
	
	public Class<? extends ITypeConformanceComputer<JvmTypeReference>> bindITypeConformanceComputer() {
		return IJvmTypeConformanceComputer.class;
	}
	
	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return XbaseValueConverterService.class;
	}
	
	@Override
	public void configureIScopeProviderDelegate(Binder binder) {
		binder.bind(IScopeProvider.class).annotatedWith(Names.named(AbstractDeclarativeScopeProvider.NAMED_DELEGATE)).to(XbaseImportedNamespaceScopeProvider.class);
	}
	
	@Override
	public void configureLinkingIScopeProvider(Binder binder) {
		binder.bind(IScopeProvider.class).annotatedWith(LinkingScopeProviderBinding.class).to(XbaseLinkingScopeProvider.class);
	}
	
}
