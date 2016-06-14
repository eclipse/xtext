/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.testlanguage;

import com.google.inject.Binder;
import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.eclipse.xtext.ide.LexerIdeBindings;
import org.eclipse.xtext.ide.editor.contentassist.antlr.IContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IEditorHighlightingConfigurationProvider;
import org.eclipse.xtext.ide.tests.testlanguage.AbstractTestLanguageRuntimeModule;
import org.eclipse.xtext.ide.tests.testlanguage.highlighting.TestLanguageHighlightingProvider;
import org.eclipse.xtext.ide.tests.testlanguage.ide.contentassist.antlr.TestLanguageParser;
import org.eclipse.xtext.ide.tests.testlanguage.ide.contentassist.antlr.internal.InternalTestLanguageLexer;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
@SuppressWarnings("all")
public class TestLanguageRuntimeModule extends AbstractTestLanguageRuntimeModule {
  public void configureExecutorService(final Binder binder) {
    AnnotatedBindingBuilder<ExecutorService> _bind = binder.<ExecutorService>bind(ExecutorService.class);
    ExecutorService _newCachedThreadPool = Executors.newCachedThreadPool();
    _bind.toInstance(_newCachedThreadPool);
  }
  
  public void configureContentAssistLexer(final Binder binder) {
    AnnotatedBindingBuilder<Lexer> _bind = binder.<Lexer>bind(Lexer.class);
    Named _named = Names.named(LexerIdeBindings.CONTENT_ASSIST);
    LinkedBindingBuilder<Lexer> _annotatedWith = _bind.annotatedWith(_named);
    _annotatedWith.to(InternalTestLanguageLexer.class);
  }
  
  public Class<? extends IContentAssistParser> bindIContentAssistParser() {
    return TestLanguageParser.class;
  }
  
  public Class<? extends IEditorHighlightingConfigurationProvider> bindIEditorHighlightingConfigurationProvider() {
    return TestLanguageHighlightingProvider.class;
  }
}
