/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder;

import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.xtext.builder.builderState.IBuilderState;
import org.eclipse.xtext.builder.builderState.PersistableResourceDescriptionsImpl;
import org.eclipse.xtext.builder.impl.DirtyStateAwareResourceDescriptions;
import org.eclipse.xtext.builder.impl.XtextBuilder;
import org.eclipse.xtext.resource.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.scoping.namespaces.SimpleNameProvider;
import org.eclipse.xtext.ui.core.editor.DirtyStateManagerProvider;
import org.eclipse.xtext.ui.core.editor.IDirtyStateManager;
import org.eclipse.xtext.ui.core.notification.IStateChangeEventBroker;
import org.eclipse.xtext.ui.core.notification.StateChangeEventBrokerProvider;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class BuilderModule extends AbstractModule {
	
	@Override
	protected void configure() {
		bindIncrementalProjectBuilder();
		bindQualifiedNameProvider();
		bind(IBuilderState.class).to(PersistableResourceDescriptionsImpl.class).in(Scopes.SINGLETON);
		bind(IResourceDescriptions.class).to(DirtyStateAwareResourceDescriptions.class).in(Scopes.SINGLETON);
		bind(IStateChangeEventBroker.class).toProvider(StateChangeEventBrokerProvider.class);
		bind(IDirtyStateManager.class).toProvider(DirtyStateManagerProvider.class);
		bind(IResourceServiceProvider.Registry.class).toInstance(IResourceServiceProvider.Registry.INSTANCE);
	}

	protected void bindQualifiedNameProvider() {
		bind(IQualifiedNameProvider.class).to(SimpleNameProvider.class);
	}

	protected void bindIncrementalProjectBuilder() {
		bind(IncrementalProjectBuilder.class).to(XtextBuilder.class);
	}

}
