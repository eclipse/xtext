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
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.linking.LinkingScopeProviderBinding;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.xbase.conversion.XbaseValueConverterService;
import org.eclipse.xtext.xbase.interpreter.IEvaluationContext;
import org.eclipse.xtext.xbase.interpreter.IExpressionInterpreter;
import org.eclipse.xtext.xbase.interpreter.impl.DefaultEvaluationContext;
import org.eclipse.xtext.xbase.interpreter.impl.XbaseInterpreter;
import org.eclipse.xtext.xbase.linking.XbaseLinkingScopeProvider;
import org.eclipse.xtext.xbase.scoping.XbaseImportedNamespaceScopeProvider;
import org.eclipse.xtext.xbase.typing.XbaseExpectedTypeProvider;
import org.eclipse.xtext.xbase.typing.XbaseTypeArgumentContextProvider;
import org.eclipse.xtext.xbase.typing.XbaseTypeConformanceComputer;
import org.eclipse.xtext.xbase.typing.XbaseTypeProvider;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Use this class to register components to be used within the IDE.
 */
public class XbaseRuntimeModule extends AbstractXbaseRuntimeModule {
	public Class<? extends org.eclipse.xtext.typing.ITypeConformanceComputer<JvmTypeReference>> bindITypeService() {
		return IJvmTypeConformanceComputer.class;
	}
	
	public Class<? extends org.eclipse.xtext.typing.ITypeProvider<JvmTypeReference>> bindITypeProvider() {
		return XbaseTypeProvider.class;
	}
	
	public Class<? extends org.eclipse.xtext.typing.IExpectedTypeProvider<JvmTypeReference>> bindIExpectedTypeProvider() {
		return XbaseExpectedTypeProvider.class;
	}
	
	public Class<? extends TypeArgumentContext.Provider> bindTypeArgumentContextProvider() {
		return XbaseTypeArgumentContextProvider.class;
	}
	
	public Class<? extends IExpressionInterpreter> bindInterpreter() {
		return XbaseInterpreter.class;
	}
	
	public Class<? extends IEvaluationContext> bindEvaluationContext() {
		return DefaultEvaluationContext.class;
	}
	
	@Override
	public void configureLinkingIScopeProvider(Binder binder) {
		binder.bind(IScopeProvider.class).annotatedWith(LinkingScopeProviderBinding.class).to(XbaseLinkingScopeProvider.class);
	}

	@Override
	public void configureIScopeProviderDelegate(Binder binder) {
		binder.bind(IScopeProvider.class).annotatedWith(Names.named(AbstractDeclarativeScopeProvider.NAMED_DELEGATE)).to(XbaseImportedNamespaceScopeProvider.class);
	}
	
	public Class<? extends IJvmTypeConformanceComputer> bindIJvmTypeConformanceComputer() {
		return XbaseTypeConformanceComputer.class;
	}
	
	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return XbaseValueConverterService.class;
	}
	
}
