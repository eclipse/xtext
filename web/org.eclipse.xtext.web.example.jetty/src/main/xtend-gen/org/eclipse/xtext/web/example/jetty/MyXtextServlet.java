/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.example.jetty;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.binder.ScopedBindingBuilder;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.servlet.annotation.WebServlet;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.ide.LexerIdeBindings;
import org.eclipse.xtext.ide.editor.contentassist.antlr.IContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
import org.eclipse.xtext.idea.example.entities.EntitiesRuntimeModule;
import org.eclipse.xtext.idea.example.entities.EntitiesStandaloneSetup;
import org.eclipse.xtext.idea.example.entities.ide.contentassist.antlr.EntitiesParser;
import org.eclipse.xtext.idea.example.entities.ide.contentassist.antlr.internal.InternalEntitiesLexer;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.web.server.persistence.FileResourceHandler;
import org.eclipse.xtext.web.server.persistence.IResourceBaseProvider;
import org.eclipse.xtext.web.server.persistence.IServerResourceHandler;
import org.eclipse.xtext.web.server.persistence.ResourceBaseProviderImpl;
import org.eclipse.xtext.web.servlet.XtextServlet;
import org.eclipse.xtext.xbase.lib.Exceptions;

@WebServlet(name = "Xtext Services", urlPatterns = "/xtext-service/*")
@SuppressWarnings("all")
public class MyXtextServlet extends XtextServlet {
  @FinalFieldsConstructor
  public static class EntitiesIdeModule extends AbstractGenericModule {
    private final ExecutorService executorService;
    
    public void configureExecutorService(final Binder binder) {
      AnnotatedBindingBuilder<ExecutorService> _bind = binder.<ExecutorService>bind(ExecutorService.class);
      _bind.toInstance(this.executorService);
    }
    
    public ScopedBindingBuilder configureContentAssistLexer(final Binder binder) {
      AnnotatedBindingBuilder<Lexer> _bind = binder.<Lexer>bind(Lexer.class);
      Named _named = Names.named(LexerIdeBindings.CONTENT_ASSIST);
      LinkedBindingBuilder<Lexer> _annotatedWith = _bind.annotatedWith(_named);
      return _annotatedWith.to(InternalEntitiesLexer.class);
    }
    
    public Class<? extends IContentAssistParser> bindIContentAssistParser() {
      return EntitiesParser.class;
    }
    
    public Class<? extends IServerResourceHandler> bindIServerResourceHandler() {
      return FileResourceHandler.class;
    }
    
    public void configureResourceBaseProvider(final Binder binder) {
      AnnotatedBindingBuilder<IResourceBaseProvider> _bind = binder.<IResourceBaseProvider>bind(IResourceBaseProvider.class);
      String _resourceBase = this.getResourceBase();
      ResourceBaseProviderImpl _resourceBaseProviderImpl = new ResourceBaseProviderImpl(_resourceBase);
      _bind.toInstance(_resourceBaseProviderImpl);
    }
    
    private String getResourceBase() {
      return "./test-files";
    }
    
    public EntitiesIdeModule(final ExecutorService executorService) {
      super();
      this.executorService = executorService;
    }
  }
  
  private ExecutorService executorService;
  
  @Override
  public void init() {
    try {
      super.init();
      ExecutorService _newCachedThreadPool = Executors.newCachedThreadPool();
      this.executorService = _newCachedThreadPool;
      new EntitiesStandaloneSetup() {
        @Override
        public Injector createInjector() {
          EntitiesRuntimeModule _entitiesRuntimeModule = new EntitiesRuntimeModule();
          MyXtextServlet.EntitiesIdeModule _entitiesIdeModule = new MyXtextServlet.EntitiesIdeModule(MyXtextServlet.this.executorService);
          return Guice.createInjector(_entitiesRuntimeModule, _entitiesIdeModule);
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
    super.destroy();
  }
}
