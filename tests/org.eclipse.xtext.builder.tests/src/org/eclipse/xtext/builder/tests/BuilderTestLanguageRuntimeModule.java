/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.tests;

import org.eclipse.xtext.builder.impl.ShadowingResourceDescriptions;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.namespaces.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.scoping.namespaces.DefaultGlobalScopeProvider;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Use this class to register components to be used within the IDE.
 */
public class BuilderTestLanguageRuntimeModule extends org.eclipse.xtext.builder.tests.AbstractBuilderTestLanguageRuntimeModule {
	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(IResourceDescriptions.class).annotatedWith(Names.named(DefaultGlobalScopeProvider.NAMED_BUILDER_SCOPE)).to(ShadowingResourceDescriptions.class);
		binder.bind(IContainer.Manager.class).to(org.eclipse.xtext.resource.impl.SimpleResourceDescriptionsBasedContainerManager.class);
		binder.bind(IResourceDescriptions.class).to(ResourceSetBasedResourceDescriptions.class);
	}
	
	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return DefaultDeclarativeQualifiedNameProvider.class;
	}
	
	@Override
	public Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return DefaultGlobalScopeProvider.class;
	}
	
}
