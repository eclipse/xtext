/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.example.jetty;

import javax.servlet.annotation.WebServlet;
import org.eclipse.xtext.util.DisposableRegistry;
import org.eclipse.xtext.web.example.jetty.EntitiesWebSetup;
import org.eclipse.xtext.web.example.jetty.StatemachineWebSetup;
import org.eclipse.xtext.web.server.persistence.ResourceBaseProviderImpl;
import org.eclipse.xtext.web.servlet.XtextServlet;
import org.eclipse.xtext.xbase.lib.Exceptions;

@WebServlet(name = "Xtext Services", urlPatterns = "/xtext-service/*")
@SuppressWarnings("all")
public class MyXtextServlet extends XtextServlet {
  private DisposableRegistry disposableRegistry;
  
  @Override
  public void init() {
    try {
      super.init();
      final ResourceBaseProviderImpl resourceBaseProvider = new ResourceBaseProviderImpl("./test-files");
      StatemachineWebSetup _statemachineWebSetup = new StatemachineWebSetup(resourceBaseProvider);
      _statemachineWebSetup.createInjectorAndDoEMFRegistration();
      EntitiesWebSetup _entitiesWebSetup = new EntitiesWebSetup(resourceBaseProvider);
      _entitiesWebSetup.createInjectorAndDoEMFRegistration();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public void destroy() {
    if ((this.disposableRegistry != null)) {
      this.disposableRegistry.dispose();
      this.disposableRegistry = null;
    }
    super.destroy();
  }
}
