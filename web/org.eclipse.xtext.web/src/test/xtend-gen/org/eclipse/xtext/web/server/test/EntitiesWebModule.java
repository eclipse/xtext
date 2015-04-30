/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.test;

import com.google.inject.Binder;
import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.binder.ScopedBindingBuilder;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import java.util.concurrent.ExecutorService;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.ide.LexerIdeBindings;
import org.eclipse.xtext.ide.editor.contentassist.antlr.IContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
import org.eclipse.xtext.idea.example.entities.ide.contentassist.antlr.EntitiesParser;
import org.eclipse.xtext.idea.example.entities.ide.contentassist.antlr.internal.InternalEntitiesLexer;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.web.server.persistence.FileResourceHandler;
import org.eclipse.xtext.web.server.persistence.IResourceBaseProvider;
import org.eclipse.xtext.web.server.persistence.IServerResourceHandler;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class EntitiesWebModule extends AbstractGenericModule {
  private final ExecutorService executorService;
  
  private final IResourceBaseProvider resourceBaseProvider;
  
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
    _bind.toInstance(this.resourceBaseProvider);
  }
  
  public EntitiesWebModule(final ExecutorService executorService, final IResourceBaseProvider resourceBaseProvider) {
    super();
    this.executorService = executorService;
    this.resourceBaseProvider = resourceBaseProvider;
  }
}
