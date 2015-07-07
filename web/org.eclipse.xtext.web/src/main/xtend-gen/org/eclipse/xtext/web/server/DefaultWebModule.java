/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server;

import com.google.inject.Binder;
import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.web.server.generator.DefaultContentTypeProvider;
import org.eclipse.xtext.web.server.generator.IContentTypeProvider;

/**
 * Default Guice bindings for the web integration of Xtext.
 */
@SuppressWarnings("all")
public class DefaultWebModule extends AbstractGenericModule {
  public Class<? extends IContentTypeProvider> bindIContentTypeProvider() {
    return DefaultContentTypeProvider.class;
  }
  
  public void configureExecutorService2(final Binder binder) {
    AnnotatedBindingBuilder<ExecutorService> _bind = binder.<ExecutorService>bind(ExecutorService.class);
    Named _named = Names.named("withDocumentLock");
    LinkedBindingBuilder<ExecutorService> _annotatedWith = _bind.annotatedWith(_named);
    ExecutorService _newCachedThreadPool = Executors.newCachedThreadPool();
    _annotatedWith.toInstance(_newCachedThreadPool);
  }
}
