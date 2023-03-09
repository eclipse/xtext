/**
 * Copyright (c) 2013, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.builder.standalone;

import static com.google.inject.name.Names.*;

import org.eclipse.xtext.builder.standalone.compiler.EclipseJavaCompiler;
import org.eclipse.xtext.builder.standalone.compiler.IJavaCompiler;
import org.eclipse.xtext.generator.AbstractFileSystemAccess;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;

import com.google.inject.AbstractModule;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class StandaloneBuilderModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(IResourceDescriptions.class)
				.annotatedWith(named(ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE))
				.to(ResourceSetBasedResourceDescriptions.class);
		bind(IResourceDescriptions.class)
				.annotatedWith(named(ResourceDescriptionsProvider.LIVE_SCOPE))
				.to(ResourceSetBasedResourceDescriptions.class);
		bind(IResourceDescriptions.class)
				.annotatedWith(named(ResourceDescriptionsProvider.PERSISTED_DESCRIPTIONS))
				.to(ResourceSetBasedResourceDescriptions.class);
		bind(IResourceDescriptions.class).to(ResourceSetBasedResourceDescriptions.class);
		bind(IIssueHandler.class).to(this.bindIIssueHandler());
		bind(AbstractFileSystemAccess.class).to(this.bindJavaIoFileSystemAccess());
		bind(IJavaCompiler.class).to(this.bindIJavaCompiler());
		bind(IEncodingProvider.class).to(this.bindIEncodingProvider());
	}

	public Class<EclipseJavaCompiler> bindIJavaCompiler() {
		return EclipseJavaCompiler.class;
	}

	protected Class<? extends IIssueHandler> bindIIssueHandler() {
		return IIssueHandler.DefaultIssueHandler.class;
	}

	protected Class<JavaIoFileSystemAccess> bindJavaIoFileSystemAccess() {
		return JavaIoFileSystemAccess.class;
	}

	protected Class<? extends IEncodingProvider> bindIEncodingProvider() {
		return IEncodingProvider.Runtime.class;
	}
}
