/**
 * Copyright (c) 2010-2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.web;

import com.google.inject.Provider;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.xtend.web.XtendWebSetup;
import org.eclipse.xtext.web.server.XtextServiceDispatcher;
import org.eclipse.xtext.web.servlet.XtextServlet;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * Deploy this class into a servlet container to enable DSL-specific services.
 */
@WebServlet(name = "XtextServices", urlPatterns = "/xtext-service/*")
@SuppressWarnings("all")
public class XtendServlet extends XtextServlet {
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
              XtendServlet.this.executorServices.add(it);
            }
          };
          return ObjectExtensions.<ExecutorService>operator_doubleArrow(_newCachedThreadPool, _function);
        }
      };
      final Provider<ExecutorService> executorServiceProvider = _function;
      XtendWebSetup _xtendWebSetup = new XtendWebSetup(executorServiceProvider);
      _xtendWebSetup.createInjectorAndDoEMFRegistration();
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
  
  @Override
  protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
    final XtextServiceDispatcher.ServiceDescriptor service = this.getService(req);
    this.doService(service, resp);
  }
}
