/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder;

import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.builder.builderState.PersistableResourceDescriptionsImpl;
import org.eclipse.xtext.builder.impl.XtextBuilder;
import org.eclipse.xtext.resource.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.scoping.namespaces.SimpleNameProvider;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class BuilderModule extends AbstractModule {
	
	@Override
	protected void configure() {
		bindResourceSet();
		bindResourceProvider();
		bindIncrementalProjectBuilder();
		bindQualifiedNameProvider();
		bind(IResourceDescriptions.class).to(PersistableResourceDescriptionsImpl.class).in(Scopes.SINGLETON);
	}

	protected void bindQualifiedNameProvider() {
		bind(IQualifiedNameProvider.class).to(SimpleNameProvider.class);
	}

	protected void bindIncrementalProjectBuilder() {
		bind(IncrementalProjectBuilder.class).to(XtextBuilder.class);
	}

	protected void bindResourceProvider() {
	}

	protected void bindResourceSet() {
		bind(ResourceSet.class).to(ResourceSetImpl.class);
	}

}
