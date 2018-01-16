/*******************************************************************************
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide

import com.google.inject.Binder
import com.google.inject.name.Names
import java.util.concurrent.ExecutorService
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.impl.LiveShadowedChunkedResourceDescriptions
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider
import org.eclipse.xtext.service.AbstractGenericModule
import org.eclipse.xtext.workspace.IProjectConfigProvider
import org.eclipse.xtext.workspace.ProjectConfigProvider

/**
 * Default Guice bindings for the generic IDE features of Xtext.
 */
class DefaultIdeModule extends AbstractGenericModule {
	
	def void configureExecutorService(Binder binder) {
		binder.bind(ExecutorService).toProvider(ExecutorServiceProvider)
	}
	
	def void configureIResourceDescriptionsLiveScope(Binder binder) {
		binder.bind(IResourceDescriptions)
			.annotatedWith(Names.named(ResourceDescriptionsProvider.LIVE_SCOPE))
			.to(LiveShadowedChunkedResourceDescriptions);
	}
		
	def Class<? extends IProjectConfigProvider> bindIProjectConfigProvider() {
		ProjectConfigProvider
	}
}
