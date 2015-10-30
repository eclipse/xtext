/**
 * Copyright (c) 2010-2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.web;

import com.google.inject.Binder;
import com.google.inject.Provider;
import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import java.util.concurrent.ExecutorService;
import org.eclipse.xtend.core.linking.Linker;
import org.eclipse.xtend.ide.common.contentassist.antlr.DisabledInternalLexer;
import org.eclipse.xtend.ide.common.contentassist.antlr.FlexerBasedContentAssistContextFactory;
import org.eclipse.xtend.ide.common.contentassist.antlr.FlexerBasedContentAssistParser;
import org.eclipse.xtend.ide.common.contentassist.antlr.internal.InternalXtendLexer;
import org.eclipse.xtend.ide.common.highlighting.XtendHighlightingCalculator;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend.web.AbstractXtendWebModule;
import org.eclipse.xtend.web.ExampleResourceHandler;
import org.eclipse.xtend.web.XtendOccurrencesService;
import org.eclipse.xtend.web.XtendServiceDispatcher;
import org.eclipse.xtext.ide.LexerIdeBindings;
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory;
import org.eclipse.xtext.ide.editor.contentassist.antlr.IContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.parser.antlr.LexerProvider;
import org.eclipse.xtext.web.server.XtextServiceDispatcher;
import org.eclipse.xtext.web.server.occurrences.OccurrencesService;
import org.eclipse.xtext.web.server.persistence.IServerResourceHandler;

/**
 * Use this class to register additional components to be used within the web application.
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class XtendWebModule extends AbstractXtendWebModule {
  @Override
  public Class<? extends IContentAssistParser> bindIContentAssistParser() {
    return FlexerBasedContentAssistParser.class;
  }
  
  public void configureContentAssistLexerProvider(final Binder binder) {
    AnnotatedBindingBuilder<InternalXtendLexer> _bind = binder.<InternalXtendLexer>bind(InternalXtendLexer.class);
    LexerProvider<DisabledInternalLexer> _create = LexerProvider.<DisabledInternalLexer>create(DisabledInternalLexer.class);
    _bind.toProvider(_create);
    AnnotatedBindingBuilder<DisabledInternalLexer> _bind_1 = binder.<DisabledInternalLexer>bind(DisabledInternalLexer.class);
    LexerProvider<DisabledInternalLexer> _create_1 = LexerProvider.<DisabledInternalLexer>create(DisabledInternalLexer.class);
    _bind_1.toProvider(_create_1);
  }
  
  @Override
  public void configureContentAssistLexer(final Binder binder) {
    AnnotatedBindingBuilder<Lexer> _bind = binder.<Lexer>bind(Lexer.class);
    Named _named = Names.named(LexerIdeBindings.CONTENT_ASSIST);
    LinkedBindingBuilder<Lexer> _annotatedWith = _bind.annotatedWith(_named);
    _annotatedWith.to(DisabledInternalLexer.class);
  }
  
  public Class<? extends ILinker> bindILinker() {
    return Linker.class;
  }
  
  public Class<? extends ContentAssistContextFactory> bindContentAssistContextFactory() {
    return FlexerBasedContentAssistContextFactory.class;
  }
  
  public Class<? extends IServerResourceHandler> bindIServerResourceHandler() {
    return ExampleResourceHandler.class;
  }
  
  public Class<? extends OccurrencesService> bindOccurencesService() {
    return XtendOccurrencesService.class;
  }
  
  public Class<? extends XtextServiceDispatcher> bindXtextServiceDispatcher() {
    return XtendServiceDispatcher.class;
  }
  
  @Override
  public Class<? extends ISemanticHighlightingCalculator> bindSemanticHighlightingCalculator() {
    return XtendHighlightingCalculator.class;
  }
  
  public XtendWebModule(final Provider<ExecutorService> executorServiceProvider) {
    super(executorServiceProvider);
  }
}
