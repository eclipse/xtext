/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone

import com.google.inject.AbstractModule
import com.google.inject.name.Names
import org.eclipse.xtext.builder.standalone.compiler.EclipseJavaCompiler
import org.eclipse.xtext.builder.standalone.compiler.IJavaCompiler
import org.eclipse.xtext.generator.AbstractFileSystemAccess
import org.eclipse.xtext.generator.JavaIoFileSystemAccess
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions

/**
 * @author Dennis Huebner - Initial contribution and API
 */
class StandaloneBuilderModule extends AbstractModule {

	override protected configure() {
		bind(XtextResourceSet).toProvider(XtextResourceSetProvider)
		bind(IResourceDescriptions).annotatedWith(Names.named(ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE)).to(
			ResourceSetBasedResourceDescriptions)
		bind(IResourceDescriptions).annotatedWith(Names.named(ResourceDescriptionsProvider.LIVE_SCOPE)).to(
			ResourceSetBasedResourceDescriptions);
		bind(IResourceDescriptions).to(ResourceSetBasedResourceDescriptions)

		// configurable
		bind(IIssueHandler).to(bindIIssueHandler)
		bind(AbstractFileSystemAccess).to(bindJavaIoFileSystemAccess)
		bind(IJavaCompiler).to(bindIJavaCompiler)
		bind(IEncodingProvider).to(bindIEncodingProvider)
	}

	def bindIJavaCompiler() {
		return EclipseJavaCompiler
	}

	protected def Class<? extends IIssueHandler> bindIIssueHandler() {
		return IIssueHandler.DefaultIssueHandler
	}

	protected def bindJavaIoFileSystemAccess() {
		return JavaIoFileSystemAccess
	}

	protected def Class<? extends IEncodingProvider> bindIEncodingProvider() {
		return IEncodingProvider.Runtime
	}
}
