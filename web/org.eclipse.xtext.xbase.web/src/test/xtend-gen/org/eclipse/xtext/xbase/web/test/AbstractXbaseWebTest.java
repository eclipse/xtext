/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.web.test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Provider;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.idea.example.entities.EntitiesRuntimeModule;
import org.eclipse.xtext.idea.example.entities.EntitiesStandaloneSetup;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.web.server.ISession;
import org.eclipse.xtext.web.server.XtextServiceDispatcher;
import org.eclipse.xtext.web.server.persistence.IResourceBaseProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.web.test.HashMapSession;
import org.eclipse.xtext.xbase.web.test.MockServiceContext;
import org.eclipse.xtext.xbase.web.test.languages.EntitiesWebModule;

@Accessors(AccessorType.PROTECTED_GETTER)
@SuppressWarnings("all")
public class AbstractXbaseWebTest extends AbstractXtextTests {
  public static class TestResourceBaseProvider implements IResourceBaseProvider {
    private final HashMap<String, URI> testFiles = new HashMap<String, URI>();
    
    @Override
    public URI getFileURI(final String resourceId) {
      return this.testFiles.get(resourceId);
    }
  }
  
  private final List<ExecutorService> executorServices = CollectionLiterals.<ExecutorService>newArrayList();
  
  private AbstractXbaseWebTest.TestResourceBaseProvider resourceBaseProvider;
  
  private XtextServiceDispatcher dispatcher;
  
  protected EntitiesRuntimeModule getRuntimeModule() {
    return new EntitiesRuntimeModule();
  }
  
  @Override
  public void setUp() {
    try {
      super.setUp();
      AbstractXbaseWebTest.TestResourceBaseProvider _testResourceBaseProvider = new AbstractXbaseWebTest.TestResourceBaseProvider();
      this.resourceBaseProvider = _testResourceBaseProvider;
      this.with(new EntitiesStandaloneSetup() {
        @Override
        public Injector createInjector() {
          final Provider<ExecutorService> _function = new Provider<ExecutorService>() {
            @Override
            public ExecutorService get() {
              ExecutorService _newCachedThreadPool = Executors.newCachedThreadPool();
              final Procedure1<ExecutorService> _function = new Procedure1<ExecutorService>() {
                @Override
                public void apply(final ExecutorService it) {
                  AbstractXbaseWebTest.this.executorServices.add(it);
                }
              };
              return ObjectExtensions.<ExecutorService>operator_doubleArrow(_newCachedThreadPool, _function);
            }
          };
          final EntitiesWebModule webModule = new EntitiesWebModule(_function);
          webModule.setResourceBaseProvider(AbstractXbaseWebTest.this.resourceBaseProvider);
          EntitiesRuntimeModule _runtimeModule = AbstractXbaseWebTest.this.getRuntimeModule();
          Module _mixin = Modules2.mixin(_runtimeModule, webModule);
          return Guice.createInjector(_mixin);
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
      final Procedure1<ExecutorService> _function = new Procedure1<ExecutorService>() {
        @Override
        public void apply(final ExecutorService it) {
          it.shutdown();
        }
      };
      IterableExtensions.<ExecutorService>forEach(this.executorServices, _function);
      this.executorServices.clear();
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
  
  @Pure
  protected List<ExecutorService> getExecutorServices() {
    return this.executorServices;
  }
  
  @Pure
  protected AbstractXbaseWebTest.TestResourceBaseProvider getResourceBaseProvider() {
    return this.resourceBaseProvider;
  }
  
  @Pure
  protected XtextServiceDispatcher getDispatcher() {
    return this.dispatcher;
  }
}
