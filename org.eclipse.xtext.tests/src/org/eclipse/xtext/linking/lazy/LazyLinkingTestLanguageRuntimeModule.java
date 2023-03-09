/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.linking.lazy;

import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Use this class to register components to be used within the IDE.
 */
public class LazyLinkingTestLanguageRuntimeModule extends org.eclipse.xtext.linking.lazy.AbstractLazyLinkingTestLanguageRuntimeModule {
	
	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return LazyLinkingTestLanguageScopeProvider.class;
	}
	
	public void configureIScopeProviderDelegate(Binder binder) {
		binder.bind(IScopeProvider.class).annotatedWith(Names.named(AbstractDeclarativeScopeProvider.NAMED_DELEGATE)).to(ImportedNamespaceAwareLocalScopeProvider.class);
	}
	
	@Override
	public void configureUseIndexFragmentsForLazyLinking(Binder binder) {
		binder.bind(Boolean.TYPE).annotatedWith(Names.named(LazyURIEncoder.USE_INDEXED_FRAGMENTS_BINDING)).toInstance(Boolean.FALSE);
	}
}
