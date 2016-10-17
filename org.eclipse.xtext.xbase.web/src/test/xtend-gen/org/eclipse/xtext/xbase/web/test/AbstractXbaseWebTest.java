/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.web.test;

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
import org.eclipse.xtext.web.example.entities.EntitiesRuntimeModule;
import org.eclipse.xtext.web.example.entities.EntitiesStandaloneSetup;
import org.eclipse.xtext.web.example.entities.ide.EntitiesIdeModule;
import org.eclipse.xtext.web.example.entities.tests.EntitiesInjectorProvider;
import org.eclipse.xtext.web.server.ISession;
import org.eclipse.xtext.web.server.XtextServiceDispatcher;
import org.eclipse.xtext.web.server.persistence.IResourceBaseProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.web.test.HashMapSession;
import org.eclipse.xtext.xbase.web.test.MockServiceContext;
import org.eclipse.xtext.xbase.web.test.languages.EntitiesWebModule;
import org.junit.After;
import org.junit.Before;

@SuppressWarnings("all")
public abstract class AbstractXbaseWebTest {
  public static class TestResourceBaseProvider implements IResourceBaseProvider {
    private final HashMap<String, URI> testFiles = new HashMap<String, URI>();
    
    @Override
    public URI getFileURI(final String resourceId) {
      return this.testFiles.get(resourceId);
    }
  }
  
  private final EntitiesInjectorProvider injectorProvider = new EntitiesInjectorProvider() {
    @Override
    protected Injector internalCreateInjector() {
      return new EntitiesStandaloneSetup() {
        @Override
        public Injector createInjector() {
          final EntitiesWebModule webModule = new EntitiesWebModule();
          final EntitiesIdeModule ideModule = new EntitiesIdeModule();
          webModule.setResourceBaseProvider(AbstractXbaseWebTest.this.resourceBaseProvider);
          Module _runtimeModule = AbstractXbaseWebTest.this.getRuntimeModule();
          Module _mixin = Modules2.mixin(_runtimeModule, ideModule, webModule);
          return Guice.createInjector(_mixin);
        }
      }.createInjectorAndDoEMFRegistration();
    }
  };
  
  private AbstractXbaseWebTest.TestResourceBaseProvider resourceBaseProvider;
  
  @Inject
  private DisposableRegistry disposableRegistry;
  
  @Inject
  private XtextServiceDispatcher dispatcher;
  
  protected Module getRuntimeModule() {
    return new EntitiesRuntimeModule();
  }
  
  @Before
  public void setup() {
    AbstractXbaseWebTest.TestResourceBaseProvider _testResourceBaseProvider = new AbstractXbaseWebTest.TestResourceBaseProvider();
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
      final File file = File.createTempFile("test", ".entities");
      String _name = file.getName();
      String _absolutePath = file.getAbsolutePath();
      URI _createFileURI = URI.createFileURI(_absolutePath);
      this.resourceBaseProvider.testFiles.put(_name, _createFileURI);
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
