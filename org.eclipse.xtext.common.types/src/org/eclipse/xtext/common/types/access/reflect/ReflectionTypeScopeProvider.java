/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.reflect;

import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.xtext.AbstractConstructorScope;
import org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
public class ReflectionTypeScopeProvider extends AbstractTypeScopeProvider {

	@Inject 
	private IQualifiedNameConverter qualifiedNameConverter;
	
	@Inject
	private ReflectionTypeProviderFactory typeProviderFactory;

	@Override
	public ReflectionTypeScope createTypeScope(IJvmTypeProvider typeProvider, Predicate<IEObjectDescription> filter) {
		return new ReflectionTypeScope((ReflectionTypeProvider) typeProvider, qualifiedNameConverter, filter);
	}

	@Override
	public AbstractConstructorScope createConstructorScope(IJvmTypeProvider typeProvider,
			Predicate<IEObjectDescription> filter) {
		ReflectionTypeScope typeScope = createTypeScope(typeProvider, filter);
		return new ReflectionConstructorScope(typeScope);
	}

	@Override
	public ReflectionTypeProviderFactory getTypeProviderFactory() {
		return typeProviderFactory;
	}
	
	public void setTypeProviderFactory(ReflectionTypeProviderFactory typeProviderFactory) {
		this.typeProviderFactory = typeProviderFactory;
	}

}
