/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.test;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.util.DisposableRegistry;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.web.example.statemachine.StatemachineRuntimeModule;
import org.eclipse.xtext.web.example.statemachine.StatemachineStandaloneSetup;
import org.eclipse.xtext.web.example.statemachine.ide.StatemachineIdeModule;
import org.eclipse.xtext.web.example.statemachine.tests.StatemachineInjectorProvider;
import org.eclipse.xtext.web.server.ISession;
import org.eclipse.xtext.web.server.XtextServiceDispatcher;
import org.eclipse.xtext.web.server.persistence.IResourceBaseProvider;
import org.eclipse.xtext.web.server.test.HashMapSession;
import org.eclipse.xtext.web.server.test.MockServiceContext;
import org.eclipse.xtext.web.server.test.languages.StatemachineWebModule;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.After;
import org.junit.Before;

@SuppressWarnings("all")
public abstract class AbstractWebServerTest {
  public static class TestResourceBaseProvider implements IResourceBaseProvider {
    private final HashMap<String, URI> testFiles = new HashMap<String, URI>();
    
    @Override
    public URI getFileURI(final String resourceId) {
      return this.testFiles.get(resourceId);
    }
  }
  
  private final StatemachineInjectorProvider injectorProvider = new StatemachineInjectorProvider() {
    @Override
    protected Injector internalCreateInjector() {
      return new StatemachineStandaloneSetup() {
        @Override
        public Injector createInjector() {
          final StatemachineIdeModule ideModule = new StatemachineIdeModule();
          final StatemachineWebModule webModule = new StatemachineWebModule();
          webModule.setResourceBaseProvider(AbstractWebServerTest.this.resourceBaseProvider);
          return Guice.createInjector(Modules2.mixin(AbstractWebServerTest.this.getRuntimeModule(), ideModule, webModule));
        }
      }.createInjectorAndDoEMFRegistration();
    }
  };
  
  private AbstractWebServerTest.TestResourceBaseProvider resourceBaseProvider;
  
  @Inject
  private DisposableRegistry disposableRegistry;
  
  @Inject
  private XtextServiceDispatcher dispatcher;
  
  protected Module getRuntimeModule() {
    return new StatemachineRuntimeModule();
  }
  
  @Before
  public void setup() {
    AbstractWebServerTest.TestResourceBaseProvider _testResourceBaseProvider = new AbstractWebServerTest.TestResourceBaseProvider();
    this.resourceBaseProvider = _testResourceBaseProvider;
    final Injector injector = this.injectorProvider.getInjector();
    injector.injectMembers(this);
    this.injectorProvider.setupRegistry();
  }
  
  @After
  public void teardown() {
    this.disposableRegistry.dispose();
    this.resourceBaseProvider.testFiles.clear();
    this.injectorProvider.restoreRegistry();
  }
  
  protected File createFile(final String content) {
    try {
      final File file = File.createTempFile("test", ".statemachine");
      this.resourceBaseProvider.testFiles.put(file.getName(), URI.createFileURI(file.getAbsolutePath()));
      final FileWriter writer = new FileWriter(file);
      writer.write(content);
      writer.close();
      file.deleteOnExit();
      return file;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected XtextServiceDispatcher.ServiceDescriptor getService(final Map<String, String> parameters) {
    HashMapSession _hashMapSession = new HashMapSession();
    return this.getService(parameters, _hashMapSession);
  }
  
  protected XtextServiceDispatcher.ServiceDescriptor getService(final Map<String, String> parameters, final ISession session) {
    XtextServiceDispatcher.ServiceDescriptor _xblockexpression = null;
    {
      final MockServiceContext serviceContext = new MockServiceContext(parameters, session);
      _xblockexpression = this.dispatcher.getService(serviceContext);
    }
    return _xblockexpression;
  }
}
