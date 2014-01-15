/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext;

import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.binary.ClassReaderTypeProvider;
import org.eclipse.xtext.common.types.access.binary.ClassReaderTypeProviderFactory;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * A local scope provider for Java types on the classpath that are loaded from
 * class files.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClassReaderBasedTypeScopeProvider extends AbstractTypeScopeProvider {
	
	@Inject
	private ClassReaderTypeProviderFactory typeProviderFactory;

	@Inject 
	private IQualifiedNameConverter qualifiedNameConverter;
	
	@Override
	public ClassReaderBasedTypeScope createTypeScope(IJvmTypeProvider typeProvider, Predicate<IEObjectDescription> filter) {
		return new ClassReaderBasedTypeScope((ClassReaderTypeProvider) typeProvider, qualifiedNameConverter, filter);
	}
	
	@Override
	public AbstractConstructorScope createConstructorScope(IJvmTypeProvider typeProvider, Predicate<IEObjectDescription> filter) {
		ClassReaderBasedTypeScope typeScope = createTypeScope(typeProvider, filter);
		return new ClassReaderBasedConstructorScope(typeScope);
	}

	public void setTypeProviderFactory(ClassReaderTypeProviderFactory typeProviderFactory) {
		this.typeProviderFactory = typeProviderFactory;
	}

	@Override
	public ClassReaderTypeProviderFactory getTypeProviderFactory() {
		return typeProviderFactory;
	}
	
}
