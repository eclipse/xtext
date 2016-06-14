/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.example.jetty;

import com.google.inject.Provider;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import javax.servlet.annotation.WebServlet;
import org.eclipse.xtext.web.example.jetty.EntitiesWebSetup;
import org.eclipse.xtext.web.example.jetty.StatemachineWebSetup;
import org.eclipse.xtext.web.server.persistence.ResourceBaseProviderImpl;
import org.eclipse.xtext.web.servlet.XtextServlet;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
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
      final Provider<ExecutorService> _function = () -> {
        ExecutorService _newCachedThreadPool = Executors.newCachedThreadPool();
        final Procedure1<ExecutorService> _function_1 = (ExecutorService it) -> {
          this.executorServices.add(it);
        };
        return ObjectExtensions.<ExecutorService>operator_doubleArrow(_newCachedThreadPool, _function_1);
      };
      final Provider<ExecutorService> executorServiceProvider = _function;
      final ResourceBaseProviderImpl resourceBaseProvider = new ResourceBaseProviderImpl("./test-files");
      StatemachineWebSetup _statemachineWebSetup = new StatemachineWebSetup(executorServiceProvider, resourceBaseProvider);
      _statemachineWebSetup.createInjectorAndDoEMFRegistration();
      EntitiesWebSetup _entitiesWebSetup = new EntitiesWebSetup(executorServiceProvider, resourceBaseProvider);
      _entitiesWebSetup.createInjectorAndDoEMFRegistration();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public void destroy() {
    final Consumer<ExecutorService> _function = (ExecutorService it) -> {
      it.shutdown();
    };
    this.executorServices.forEach(_function);
    this.executorServices.clear();
    super.destroy();
  }
}
