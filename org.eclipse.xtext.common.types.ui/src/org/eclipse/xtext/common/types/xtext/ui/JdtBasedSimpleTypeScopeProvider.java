/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui;

import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.jdt.IJdtTypeProvider;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProviderFactory;
import org.eclipse.xtext.common.types.xtext.AbstractConstructorScope;
import org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.base.Predicate;
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
	public AbstractConstructorScope createConstructorScope(IJvmTypeProvider typeProvider, Predicate<IEObjectDescription> filter) {
		JdtBasedSimpleTypeScope typeScope = createTypeScope(typeProvider, filter);
		return new JdtBasedConstructorScope(typeScope);
	}

	public JdtBasedSimpleTypeScopeProvider(JdtTypeProviderFactory typeProviderFactory, IQualifiedNameConverter qualifiedNameConverter) {
		this.typeProviderFactory = typeProviderFactory;
		this.qualifiedNameConverter = qualifiedNameConverter;
	}

	@Override
	public JdtBasedSimpleTypeScope createTypeScope(IJvmTypeProvider typeProvider, Predicate<IEObjectDescription> filter) {
		return new JdtBasedSimpleTypeScope((IJdtTypeProvider) typeProvider, qualifiedNameConverter, filter);
	}

	@Override
	public JdtTypeProviderFactory getTypeProviderFactory() {
		return typeProviderFactory;
	}

}
