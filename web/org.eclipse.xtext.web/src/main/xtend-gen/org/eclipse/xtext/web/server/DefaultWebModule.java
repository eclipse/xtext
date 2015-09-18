/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server;

import com.google.inject.Binder;
import com.google.inject.Provider;
import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import java.util.concurrent.ExecutorService;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.web.server.generator.DefaultContentTypeProvider;
import org.eclipse.xtext.web.server.generator.IContentTypeProvider;

/**
 * Default Guice bindings for the web integration of Xtext.
 * It is the responsibility of the caller of the constructor of this module to shut down the
 * passed executor services. If a provider for executor services is given, it must provide a
 * new instance for each invocation.
 */
@SuppressWarnings("all")
public class DefaultWebModule extends AbstractGenericModule {
  private final ExecutorService executorService;
  
  private final ExecutorService executorServiceWithDocumentLock;
  
  public DefaultWebModule(final Provider<ExecutorService> executorServiceProvider) {
    ExecutorService _get = executorServiceProvider.get();
    this.executorService = _get;
    ExecutorService _get_1 = executorServiceProvider.get();
    this.executorServiceWithDocumentLock = _get_1;
  }
  
  public Class<? extends IContentTypeProvider> bindIContentTypeProvider() {
    return DefaultContentTypeProvider.class;
  }
  
  public void configureExecutorService(final Binder binder) {
    AnnotatedBindingBuilder<ExecutorService> _bind = binder.<ExecutorService>bind(ExecutorService.class);
    _bind.toInstance(this.executorService);
  }
  
  public void configureExecutorServiceWithDocumentLock(final Binder binder) {
    AnnotatedBindingBuilder<ExecutorService> _bind = binder.<ExecutorService>bind(ExecutorService.class);
    Named _named = Names.named("withDocumentLock");
    LinkedBindingBuilder<ExecutorService> _annotatedWith = _bind.annotatedWith(_named);
    _annotatedWith.toInstance(this.executorServiceWithDocumentLock);
  }
}
