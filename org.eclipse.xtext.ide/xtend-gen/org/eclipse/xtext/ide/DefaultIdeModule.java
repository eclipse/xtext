/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide;

import com.google.inject.Binder;
import com.google.inject.Provider;
import com.google.inject.binder.AnnotatedBindingBuilder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.eclipse.xtext.service.AbstractGenericModule;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class DefaultIdeModule extends AbstractGenericModule {
  private final Provider<ExecutorService> executorServiceProvider;
  
  public DefaultIdeModule() {
    final Provider<ExecutorService> _function = () -> {
      return Executors.newCachedThreadPool();
    };
    this.executorServiceProvider = _function;
  }
  
  public DefaultIdeModule(final Provider<ExecutorService> executorServiceProvider) {
    this.executorServiceProvider = executorServiceProvider;
  }
  
  public void configureExecutorService(final Binder binder) {
    AnnotatedBindingBuilder<ExecutorService> _bind = binder.<ExecutorService>bind(ExecutorService.class);
    ExecutorService _get = this.executorServiceProvider.get();
    _bind.toInstance(_get);
  }
}
