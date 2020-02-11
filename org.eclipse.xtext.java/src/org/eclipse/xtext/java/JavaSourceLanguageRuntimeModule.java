/*******************************************************************************
 * Copyright (c) 2018, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/

package org.eclipse.xtext.java;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.common.types.access.ClasspathTypeProviderFactory;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.xtext.JvmIdentifiableQualifiedNameProvider;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.java.resource.JavaResource;
import org.eclipse.xtext.java.resource.JavaResourceDescriptionManager;
import org.eclipse.xtext.java.resource.JavaResourceServiceProvider;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.parser.antlr.IReferableElementsUnloader;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptionsProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions;
import org.eclipse.xtext.resource.impl.SimpleResourceDescriptionsBasedContainerManager;
import org.eclipse.xtext.validation.IResourceValidator;

public class JavaSourceLanguageRuntimeModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(Resource.Factory.class).to(JavaResource.Factory.class);
		bind(IResourceValidator.class).toInstance(IResourceValidator.NULL);
		bind(IGenerator.class).to(IGenerator.NullGenerator.class);
		bind(IEncodingProvider.class).to(IEncodingProvider.Runtime.class);
		bind(IResourceServiceProvider.class).to(JavaResourceServiceProvider.class);
		bind(IContainer.Manager.class).to(SimpleResourceDescriptionsBasedContainerManager.class);
		bind(IResourceDescription.Manager.class).to(JavaResourceDescriptionManager.class);
		bind(IQualifiedNameProvider.class).to(JvmIdentifiableQualifiedNameProvider.class);
		bind(String.class).annotatedWith(Names.named(Constants.FILE_EXTENSIONS)).toInstance("java");
		bind(String.class).annotatedWith(Names.named(Constants.LANGUAGE_NAME))
				.toInstance("org.eclipse.xtext.java.Java");
		bind(IJvmTypeProvider.Factory.class).to(ClasspathTypeProviderFactory.class);
		bind(ClassLoader.class).toInstance(JavaSourceLanguageRuntimeModule.class.getClassLoader());
		bind(IReferableElementsUnloader.class).to(IReferableElementsUnloader.GenericUnloader.class);
		bind(IResourceDescriptionsProvider.class)
				.toInstance((ResourceSet rs) -> ChunkedResourceDescriptions.findInEmfObject(rs));
	}
}
