/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.web.test.languages;

import com.google.inject.Binder;
import com.google.inject.Provider;
import com.google.inject.binder.AnnotatedBindingBuilder;
import java.util.concurrent.ExecutorService;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.web.server.persistence.FileResourceHandler;
import org.eclipse.xtext.web.server.persistence.IResourceBaseProvider;
import org.eclipse.xtext.web.server.persistence.IServerResourceHandler;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.web.DefaultXbaseWebModule;

@Accessors
@SuppressWarnings("all")
public class EntitiesWebModule extends DefaultXbaseWebModule {
  private IResourceBaseProvider resourceBaseProvider;
  
  public EntitiesWebModule(final Provider<ExecutorService> executorServiceProvider) {
    super(executorServiceProvider);
  }
  
  public Class<? extends IServerResourceHandler> bindIServerResourceHandler() {
    return FileResourceHandler.class;
  }
  
  public void configureResourceBaseProvider(final Binder binder) {
    if ((this.resourceBaseProvider != null)) {
      AnnotatedBindingBuilder<IResourceBaseProvider> _bind = binder.<IResourceBaseProvider>bind(IResourceBaseProvider.class);
      _bind.toInstance(this.resourceBaseProvider);
    }
  }
  
  @Pure
  public IResourceBaseProvider getResourceBaseProvider() {
    return this.resourceBaseProvider;
  }
  
  public void setResourceBaseProvider(final IResourceBaseProvider resourceBaseProvider) {
    this.resourceBaseProvider = resourceBaseProvider;
  }
}
