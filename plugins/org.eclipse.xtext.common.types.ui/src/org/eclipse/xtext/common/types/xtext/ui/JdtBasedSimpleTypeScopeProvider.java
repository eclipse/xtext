/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui;

import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.jdt.IJdtTypeProvider;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProviderFactory;
import org.eclipse.xtext.common.types.xtext.AbstractConstructorScope;
import org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;

import com.google.inject.Inject;

/**
 * A local scope provider for Java types based on Java projects.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Jan Koehnlein - introduced QualifiedName
 */
public class JdtBasedSimpleTypeScopeProvider extends AbstractTypeScopeProvider {

	@Inject
	private JdtTypeProviderFactory typeProviderFactory;

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Inject
	public JdtBasedSimpleTypeScopeProvider() {
	}
	
	@Override
	public AbstractConstructorScope createConstructorScope(IJvmTypeProvider typeProvider) {
		JdtBasedSimpleTypeScope typeScope = createTypeScope(typeProvider);
		return new JdtBasedConstructorScope(typeScope);
	}

	public JdtBasedSimpleTypeScopeProvider(JdtTypeProviderFactory typeProviderFactory,
			IQualifiedNameConverter qualifiedNameConverter) {
		this.typeProviderFactory = typeProviderFactory;
		this.qualifiedNameConverter = qualifiedNameConverter;
	}

	@Override
	public JdtBasedSimpleTypeScope createTypeScope(IJvmTypeProvider typeProvider) {
		return new JdtBasedSimpleTypeScope((IJdtTypeProvider) typeProvider, qualifiedNameConverter);
	}

	@Override
	public JdtTypeProviderFactory getTypeProviderFactory() {
		return typeProviderFactory;
	}

}
