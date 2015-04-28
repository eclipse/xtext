/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.idea.example.entities.EntitiesRuntimeModule;
import org.eclipse.xtext.idea.example.entities.EntitiesStandaloneSetup;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.web.server.XtextServiceDispatcher;
import org.eclipse.xtext.web.server.persistence.IResourceBaseProvider;
import org.eclipse.xtext.web.server.test.EntitiesIdeModule;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors(AccessorType.PROTECTED_GETTER)
@SuppressWarnings("all")
public class AbstractWebServerTest extends AbstractXtextTests {
  public static class TestResourceBaseProvider implements IResourceBaseProvider {
    private final HashMap<String, URI> testFiles = new HashMap<String, URI>();
    
    @Override
    public URI getFileURI(final String resourceId) {
      return this.testFiles.get(resourceId);
    }
  }
  
  private ExecutorService executorService;
  
  private AbstractWebServerTest.TestResourceBaseProvider resourceBaseProvider;
  
  private XtextServiceDispatcher dispatcher;
  
  @Override
  public void setUp() {
    try {
      super.setUp();
      ExecutorService _newCachedThreadPool = Executors.newCachedThreadPool();
      this.executorService = _newCachedThreadPool;
      AbstractWebServerTest.TestResourceBaseProvider _testResourceBaseProvider = new AbstractWebServerTest.TestResourceBaseProvider();
      this.resourceBaseProvider = _testResourceBaseProvider;
      this.with(new EntitiesStandaloneSetup() {
        @Override
        public Injector createInjector() {
          final EntitiesRuntimeModule runtimeModule = new EntitiesRuntimeModule();
          final EntitiesIdeModule ideModule = new EntitiesIdeModule(AbstractWebServerTest.this.executorService, AbstractWebServerTest.this.resourceBaseProvider);
          return Guice.createInjector(runtimeModule, ideModule);
        }
      });
      Injector _injector = this.getInjector();
      XtextServiceDispatcher _instance = _injector.<XtextServiceDispatcher>getInstance(XtextServiceDispatcher.class);
      this.dispatcher = _instance;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public void tearDown() {
    try {
      this.executorService.shutdown();
      super.tearDown();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
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
  
  @Pure
  protected ExecutorService getExecutorService() {
    return this.executorService;
  }
  
  @Pure
  protected AbstractWebServerTest.TestResourceBaseProvider getResourceBaseProvider() {
    return this.resourceBaseProvider;
  }
  
  @Pure
  protected XtextServiceDispatcher getDispatcher() {
    return this.dispatcher;
  }
}
