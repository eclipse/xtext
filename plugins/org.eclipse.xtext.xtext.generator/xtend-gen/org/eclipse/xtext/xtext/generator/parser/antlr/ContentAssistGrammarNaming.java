/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.parser.antlr.GrammarNaming;

@SuppressWarnings("all")
public class ContentAssistGrammarNaming extends GrammarNaming {
  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;
  
  @Override
  protected String getParserPackage(final Grammar it) {
    StringConcatenation _builder = new StringConcatenation();
    String _genericIdeBasePackage = this._xtextGeneratorNaming.getGenericIdeBasePackage(it);
    _builder.append(_genericIdeBasePackage, "");
    _builder.append(".contentassist.antlr");
    return _builder.toString();
  }
  
  @Override
  public TypeReference getLexerSuperClass(final Grammar it) {
    return new TypeReference("org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer");
  }
  
  @Override
  public TypeReference getInternalParserSuperClass(final Grammar it) {
    return new TypeReference("org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser");
  }
  
  @Override
  public TypeReference getParserSuperClass(final Grammar it, final boolean partialParsing) {
    TypeReference _xifexpression = null;
    if (partialParsing) {
      _xifexpression = new TypeReference("org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractPartialContentAssistParser");
    } else {
      _xifexpression = new TypeReference("org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser");
    }
    return _xifexpression;
  }
}
