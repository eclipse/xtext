/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.test.languages;

import com.google.inject.Binder;
import com.google.inject.Provider;
import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.binder.ScopedBindingBuilder;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import java.util.concurrent.ExecutorService;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.ide.LexerIdeBindings;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider;
import org.eclipse.xtext.ide.editor.contentassist.antlr.IContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.ide.labels.IImageDescriptionProvider;
import org.eclipse.xtext.web.example.statemachine.ide.StatemachineImageDescriptionProvider;
import org.eclipse.xtext.web.example.statemachine.ide.StatemachineSemanticHighlightingCalculator;
import org.eclipse.xtext.web.example.statemachine.ide.contentassist.antlr.StatemachineParser;
import org.eclipse.xtext.web.example.statemachine.ide.contentassist.antlr.internal.InternalStatemachineLexer;
import org.eclipse.xtext.web.server.DefaultWebModule;
import org.eclipse.xtext.web.server.persistence.FileResourceHandler;
import org.eclipse.xtext.web.server.persistence.IResourceBaseProvider;
import org.eclipse.xtext.web.server.persistence.IServerResourceHandler;
import org.eclipse.xtext.web.server.test.languages.contentassist.StatemachineWebContentProposalProvider;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class StatemachineWebModule extends DefaultWebModule {
  private IResourceBaseProvider resourceBaseProvider;
  
  public StatemachineWebModule(final ExecutorService executorService, final ExecutorService executorServiceWithDocumentLock) {
    super(executorService, executorServiceWithDocumentLock);
  }
  
  public StatemachineWebModule(final Provider<ExecutorService> executorServiceProvider) {
    super(executorServiceProvider);
  }
  
  public ScopedBindingBuilder configureContentAssistLexer(final Binder binder) {
    AnnotatedBindingBuilder<Lexer> _bind = binder.<Lexer>bind(Lexer.class);
    Named _named = Names.named(LexerIdeBindings.CONTENT_ASSIST);
    LinkedBindingBuilder<Lexer> _annotatedWith = _bind.annotatedWith(_named);
    return _annotatedWith.to(InternalStatemachineLexer.class);
  }
  
  public Class<? extends IContentAssistParser> bindIContentAssistParser() {
    return StatemachineParser.class;
  }
  
  public Class<? extends IdeContentProposalProvider> bindIdeContentProposalProvider() {
    return StatemachineWebContentProposalProvider.class;
  }
  
  public Class<? extends IServerResourceHandler> bindIServerResourceHandler() {
    return FileResourceHandler.class;
  }
  
  public void configureResourceBaseProvider(final Binder binder) {
    if ((this.resourceBaseProvider != null)) {
      AnnotatedBindingBuilder<IResourceBaseProvider> _bind = binder.<IResourceBaseProvider>bind(IResourceBaseProvider.class);
      _bind.toInstance(this.resourceBaseProvider);
    }
  }
  
  public Class<? extends IImageDescriptionProvider> bindIImageDescriptionProvider() {
    return StatemachineImageDescriptionProvider.class;
  }
  
  public Class<? extends ISemanticHighlightingCalculator> bindSemanticHighlightingCalculator() {
    return StatemachineSemanticHighlightingCalculator.class;
  }
  
  @Pure
  public IResourceBaseProvider getResourceBaseProvider() {
    return this.resourceBaseProvider;
  }
  
  public void setResourceBaseProvider(final IResourceBaseProvider resourceBaseProvider) {
    this.resourceBaseProvider = resourceBaseProvider;
  }
}
