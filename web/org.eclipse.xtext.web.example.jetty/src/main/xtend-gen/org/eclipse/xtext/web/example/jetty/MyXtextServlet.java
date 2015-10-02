/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.example.jetty;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Provider;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.servlet.annotation.WebServlet;
import org.eclipse.xtext.idea.example.entities.EntitiesRuntimeModule;
import org.eclipse.xtext.idea.example.entities.EntitiesStandaloneSetup;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.web.example.jetty.EntitiesWebModule;
import org.eclipse.xtext.web.example.jetty.StatemachineWebModule;
import org.eclipse.xtext.web.example.statemachine.StatemachineRuntimeModule;
import org.eclipse.xtext.web.example.statemachine.StatemachineStandaloneSetup;
import org.eclipse.xtext.web.server.persistence.ResourceBaseProviderImpl;
import org.eclipse.xtext.web.servlet.XtextServlet;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@WebServlet(name = "Xtext Services", urlPatterns = "/xtext-service/*")
@SuppressWarnings("all")
public class MyXtextServlet extends XtextServlet {
  private final List<ExecutorService> executorServices = CollectionLiterals.<ExecutorService>newArrayList();
  
  @Override
  public void init() {
    try {
      super.init();
      final Provider<ExecutorService> _function = new Provider<ExecutorService>() {
        @Override
        public ExecutorService get() {
          ExecutorService _newCachedThreadPool = Executors.newCachedThreadPool();
          final Procedure1<ExecutorService> _function = new Procedure1<ExecutorService>() {
            @Override
            public void apply(final ExecutorService it) {
              MyXtextServlet.this.executorServices.add(it);
            }
          };
          return ObjectExtensions.<ExecutorService>operator_doubleArrow(_newCachedThreadPool, _function);
        }
      };
      final Provider<ExecutorService> executorServiceProvider = _function;
      final ResourceBaseProviderImpl resourceBaseProvider = new ResourceBaseProviderImpl("./test-files");
      new StatemachineStandaloneSetup() {
        @Override
        public Injector createInjector() {
          final StatemachineRuntimeModule runtimeModule = new StatemachineRuntimeModule();
          final StatemachineWebModule webModule = new StatemachineWebModule(executorServiceProvider);
          webModule.setResourceBaseProvider(resourceBaseProvider);
          Module _mixin = Modules2.mixin(runtimeModule, webModule);
          return Guice.createInjector(_mixin);
        }
      }.createInjectorAndDoEMFRegistration();
      new EntitiesStandaloneSetup() {
        @Override
        public Injector createInjector() {
          final EntitiesRuntimeModule runtimeModule = new EntitiesRuntimeModule();
          final EntitiesWebModule webModule = new EntitiesWebModule(executorServiceProvider);
          webModule.setResourceBaseProvider(resourceBaseProvider);
          Module _mixin = Modules2.mixin(runtimeModule, webModule);
          return Guice.createInjector(_mixin);
        }
      }.createInjectorAndDoEMFRegistration();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public void destroy() {
    final Procedure1<ExecutorService> _function = new Procedure1<ExecutorService>() {
      @Override
      public void apply(final ExecutorService it) {
        it.shutdown();
      }
    };
    IterableExtensions.<ExecutorService>forEach(this.executorServices, _function);
    this.executorServices.clear();
    super.destroy();
  }
}
