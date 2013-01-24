/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase;

import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.serializer.tokens.SerializerScopeProviderBinding;

import com.google.inject.Binder;

/**
 * Use this class to register components to be used within the IDE.
 */
public class XbaseRuntimeModule extends AbstractXbaseRuntimeModule {
	
	@Override
	public void configureSerializerIScopeProvider(Binder binder) {
		binder.bind(IScopeProvider.class).annotatedWith(SerializerScopeProviderBinding.class).to(IScopeProvider.class);
	}
	
}
