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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.servlet.annotation.WebServlet;
import org.eclipse.xtext.idea.example.entities.EntitiesRuntimeModule;
import org.eclipse.xtext.idea.example.entities.EntitiesStandaloneSetup;
import org.eclipse.xtext.web.example.jetty.EntitiesWebModule;
import org.eclipse.xtext.web.example.jetty.StatemachineWebModule;
import org.eclipse.xtext.web.example.statemachine.StatemachineRuntimeModule;
import org.eclipse.xtext.web.example.statemachine.StatemachineStandaloneSetup;
import org.eclipse.xtext.web.server.persistence.ResourceBaseProviderImpl;
import org.eclipse.xtext.web.servlet.XtextServlet;
import org.eclipse.xtext.xbase.lib.Exceptions;

@WebServlet(name = "Xtext Services", urlPatterns = "/xtext-service/*")
@SuppressWarnings("all")
public class MyXtextServlet extends XtextServlet {
  private ExecutorService executorService;
  
  @Override
  public void init() {
    try {
      super.init();
      ExecutorService _newCachedThreadPool = Executors.newCachedThreadPool();
      this.executorService = _newCachedThreadPool;
      final ResourceBaseProviderImpl resourceBaseProvider = new ResourceBaseProviderImpl("./test-files");
      new StatemachineStandaloneSetup() {
        @Override
        public Injector createInjector() {
          final StatemachineRuntimeModule runtimeModule = new StatemachineRuntimeModule();
          final StatemachineWebModule webModule = new StatemachineWebModule(MyXtextServlet.this.executorService);
          webModule.setResourceBaseProvider(resourceBaseProvider);
          return Guice.createInjector(runtimeModule, webModule);
        }
      }.createInjectorAndDoEMFRegistration();
      new EntitiesStandaloneSetup() {
        @Override
        public Injector createInjector() {
          final EntitiesRuntimeModule runtimeModule = new EntitiesRuntimeModule();
          final EntitiesWebModule webModule = new EntitiesWebModule(MyXtextServlet.this.executorService);
          webModule.setResourceBaseProvider(resourceBaseProvider);
          return Guice.createInjector(runtimeModule, webModule);
        }
      }.createInjectorAndDoEMFRegistration();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public void destroy() {
    if ((this.executorService != null)) {
      this.executorService.shutdown();
    }
    this.executorService = null;
    super.destroy();
  }
}
