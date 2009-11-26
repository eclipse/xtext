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
import org.eclipse.xtext.builder.impl.StorageUtil;
import org.eclipse.xtext.builder.impl.XtextBuilder;
import org.eclipse.xtext.builder.impl.javasupport.JdtStorageUtil;
import org.eclipse.xtext.resource.IQualifiedNameProvider;
import org.eclipse.xtext.scoping.namespaces.SimpleNameProvider;

import com.google.inject.AbstractModule;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class BuilderModule extends AbstractModule {
	
	@Override
	protected void configure() {
		bindStorageUtil();
		bindResourceSet();
		bindResourceProvider();
		bindIncrementalProjectBuilder();
		bindQualifiedNameProvider();
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

	protected void bindStorageUtil() {
		bind(StorageUtil.class).to(JdtStorageUtil.class);
	}

}
