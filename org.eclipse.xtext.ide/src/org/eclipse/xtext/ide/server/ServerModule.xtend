/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server

import com.google.inject.AbstractModule
import com.google.inject.name.Names
import io.typefox.lsapi.services.LanguageServer
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import org.eclipse.xtext.ide.server.concurrent.RequestManager
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.resource.ResourceServiceProviderServiceLoader
import org.eclipse.xtext.resource.IContainer
import org.eclipse.xtext.resource.containers.ProjectDescriptionBasedContainerManager

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.11
 */
class ServerModule extends AbstractModule {
    
    override protected configure() {
		val readExecutorService = Executors.newCachedThreadPool
		bind(ExecutorService).annotatedWith(Names.named(RequestManager.READ_EXECUTOR_SERVICE)).toInstance(readExecutorService)
		
		val writeExecutorService = Executors.newSingleThreadExecutor
		bind(ExecutorService).annotatedWith(Names.named(RequestManager.WRITE_EXECUTOR_SERVICE)).toInstance(writeExecutorService)
		
    	bind(LanguageServer).to(LanguageServerImpl)
        bind(IResourceServiceProvider.Registry).toProvider(ResourceServiceProviderServiceLoader)
        bind(IWorkspaceConfigFactory).to(ProjectWorkspaceConfigFactory)
        bind(IProjectDescriptionFactory).to(DefaultProjectDescriptionFactory)
        bind(IContainer.Manager).to(ProjectDescriptionBasedContainerManager)
    }
    
}