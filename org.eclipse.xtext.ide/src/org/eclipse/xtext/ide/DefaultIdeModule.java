/*******************************************************************************
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide;

import com.google.inject.Binder;
import com.google.inject.name.Names;
import java.util.concurrent.ExecutorService;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.LiveShadowedChunkedResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.workspace.IProjectConfigProvider;
import org.eclipse.xtext.workspace.ProjectConfigProvider;

/**
 * Default Guice bindings for the generic IDE features of Xtext.
 */
public class DefaultIdeModule extends AbstractGenericModule {

	public void configureExecutorService(Binder binder) {
		binder.bind(ExecutorService.class).toProvider(ExecutorServiceProvider.class);
	}

	public void configureIResourceDescriptionsLiveScope(Binder binder) {
		binder.bind(IResourceDescriptions.class).annotatedWith(Names.named(ResourceDescriptionsProvider.LIVE_SCOPE))
				.to(LiveShadowedChunkedResourceDescriptions.class);
	}

	public Class<? extends IProjectConfigProvider> bindIProjectConfigProvider() {
		return ProjectConfigProvider.class;
	}
}
