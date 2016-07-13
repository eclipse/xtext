/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server;

import com.google.inject.AbstractModule;
import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import io.typefox.lsapi.services.LanguageServer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.eclipse.xtext.ide.server.DefaultProjectDescriptionFactory;
import org.eclipse.xtext.ide.server.IProjectDescriptionFactory;
import org.eclipse.xtext.ide.server.IWorkspaceConfigFactory;
import org.eclipse.xtext.ide.server.LanguageServerImpl;
import org.eclipse.xtext.ide.server.ProjectWorkspaceConfigFactory;
import org.eclipse.xtext.ide.server.concurrent.RequestManager;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.ResourceServiceProviderServiceLoader;
import org.eclipse.xtext.resource.containers.ProjectDescriptionBasedContainerManager;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.11
 */
@SuppressWarnings("all")
public class ServerModule extends AbstractModule {
  @Override
  protected void configure() {
    final ExecutorService readExecutorService = Executors.newCachedThreadPool();
    AnnotatedBindingBuilder<ExecutorService> _bind = this.<ExecutorService>bind(ExecutorService.class);
    Named _named = Names.named(RequestManager.READ_EXECUTOR_SERVICE);
    LinkedBindingBuilder<ExecutorService> _annotatedWith = _bind.annotatedWith(_named);
    _annotatedWith.toInstance(readExecutorService);
    final ExecutorService writeExecutorService = Executors.newSingleThreadExecutor();
    AnnotatedBindingBuilder<ExecutorService> _bind_1 = this.<ExecutorService>bind(ExecutorService.class);
    Named _named_1 = Names.named(RequestManager.WRITE_EXECUTOR_SERVICE);
    LinkedBindingBuilder<ExecutorService> _annotatedWith_1 = _bind_1.annotatedWith(_named_1);
    _annotatedWith_1.toInstance(writeExecutorService);
    AnnotatedBindingBuilder<LanguageServer> _bind_2 = this.<LanguageServer>bind(LanguageServer.class);
    _bind_2.to(LanguageServerImpl.class);
    AnnotatedBindingBuilder<IResourceServiceProvider.Registry> _bind_3 = this.<IResourceServiceProvider.Registry>bind(IResourceServiceProvider.Registry.class);
    _bind_3.toProvider(ResourceServiceProviderServiceLoader.class);
    AnnotatedBindingBuilder<IWorkspaceConfigFactory> _bind_4 = this.<IWorkspaceConfigFactory>bind(IWorkspaceConfigFactory.class);
    _bind_4.to(ProjectWorkspaceConfigFactory.class);
    AnnotatedBindingBuilder<IProjectDescriptionFactory> _bind_5 = this.<IProjectDescriptionFactory>bind(IProjectDescriptionFactory.class);
    _bind_5.to(DefaultProjectDescriptionFactory.class);
    AnnotatedBindingBuilder<IContainer.Manager> _bind_6 = this.<IContainer.Manager>bind(IContainer.Manager.class);
    _bind_6.to(ProjectDescriptionBasedContainerManager.class);
  }
}
