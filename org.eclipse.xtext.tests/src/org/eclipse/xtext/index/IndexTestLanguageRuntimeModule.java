/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.index;

import org.eclipse.xtext.generator.IGenerator2;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;


/**
 * Use this class to register components to be used within the IDE.
 */
public class IndexTestLanguageRuntimeModule extends org.eclipse.xtext.index.AbstractIndexTestLanguageRuntimeModule {
	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return DefaultDeclarativeQualifiedNameProvider.class;
	}
	
	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return ImportedNamespaceAwareLocalScopeProvider.class;
	}
	
	@Override
	public Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider.class;
	}

	@org.eclipse.xtext.service.SingletonBinding(eager = true)
	public Class<? extends IndexTestLanguageJavaValidator> bindIndexTestLanguageJavaValidator() {
		return IndexTestLanguageJavaValidator.class;
	}
	
	public Class<? extends IGenerator2> bindIGenerator2() {
		return IndexTestLanguageGenerator.class;
	}

//	public IResourceScopeCache bindIResourceScoprCache() {
//		return IResourceScopeCache.NullImpl.INSTANCE;
//	}
}
