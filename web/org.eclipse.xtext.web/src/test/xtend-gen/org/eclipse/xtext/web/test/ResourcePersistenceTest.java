/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import java.io.File;
import java.io.FileWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.idea.example.entities.EntitiesRuntimeModule;
import org.eclipse.xtext.idea.example.entities.EntitiesStandaloneSetup;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.web.server.XtextServiceDispatcher;
import org.eclipse.xtext.web.server.persistence.IResourceBaseProvider;
import org.eclipse.xtext.web.server.persistence.ResourceContentResult;
import org.eclipse.xtext.web.test.EntitiesIdeModule;
import org.eclipse.xtext.web.test.HashMapSessionStore;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class ResourcePersistenceTest extends AbstractXtextTests {
  public static class TestResourceBaseProvider implements IResourceBaseProvider {
    private final HashMap<String, URI> testFiles = new HashMap<String, URI>();
    
    @Override
    public URI getFileURI(final String resourceId) {
      return this.testFiles.get(resourceId);
    }
  }
  
  private ExecutorService executorService;
  
  private ResourcePersistenceTest.TestResourceBaseProvider resourceBaseProvider;
  
  private XtextServiceDispatcher dispatcher;
  
  @Override
  public void setUp() {
    try {
      super.setUp();
      ExecutorService _newCachedThreadPool = Executors.newCachedThreadPool();
      this.executorService = _newCachedThreadPool;
      ResourcePersistenceTest.TestResourceBaseProvider _testResourceBaseProvider = new ResourcePersistenceTest.TestResourceBaseProvider();
      this.resourceBaseProvider = _testResourceBaseProvider;
      this.with(new EntitiesStandaloneSetup() {
        @Override
        public Injector createInjector() {
          final EntitiesRuntimeModule runtimeModule = new EntitiesRuntimeModule();
          final EntitiesIdeModule ideModule = new EntitiesIdeModule(ResourcePersistenceTest.this.executorService, ResourcePersistenceTest.this.resourceBaseProvider);
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
  
  @Test
  public void testLoadFile() {
    try {
      final String resourceContent = "entity foo {}";
      final File file = this.createFile(resourceContent);
      final HashMapSessionStore sessionStore = new HashMapSessionStore();
      String _name = file.getName();
      Pair<String, String> _mappedTo = Pair.<String, String>of("resource", _name);
      final Map<String, String> parameters = Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo));
      final XtextServiceDispatcher.ServiceDescriptor service = this.dispatcher.getService("/load", parameters, sessionStore);
      boolean _isHasSideEffects = service.isHasSideEffects();
      Assert.assertFalse(_isHasSideEffects);
      boolean _isHasTextInput = service.isHasTextInput();
      Assert.assertFalse(_isHasTextInput);
      Function0<? extends IServiceResult> _service = service.getService();
      IServiceResult _apply = _service.apply();
      final ResourceContentResult result = ((ResourceContentResult) _apply);
      String _fullText = result.getFullText();
      Assert.assertEquals(resourceContent, _fullText);
      boolean _isDirty = result.isDirty();
      Assert.assertFalse(_isDirty);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
