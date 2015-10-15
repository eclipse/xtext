/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.parser.antlr;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammar;
import org.eclipse.xtext.xtext.generator.parser.antlr.ContentAssistGrammarNaming;

@SuppressWarnings("all")
public class ExtendedContentAssistGrammarNaming extends ContentAssistGrammarNaming {
  @Override
  public AntlrGrammar getParserGrammar(final Grammar it) {
    String _internalParserPackage = this.getInternalParserPackage(it);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Internal");
    String _simpleName = GrammarUtil.getSimpleName(it);
    _builder.append(_simpleName, "");
    _builder.append("Parser");
    return new AntlrGrammar(_internalParserPackage, _builder.toString());
  }
  
  @Override
  public AntlrGrammar getLexerGrammar(final Grammar it) {
    String _internalParserPackage = this.getInternalParserPackage(it);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Internal");
    String _simpleName = GrammarUtil.getSimpleName(it);
    _builder.append(_simpleName, "");
    _builder.append("Lexer");
    return new AntlrGrammar(_internalParserPackage, _builder.toString());
  }
  
  @Override
  public TypeReference getLexerClass(final Grammar it) {
    AntlrGrammar _lexerGrammar = this.getLexerGrammar(it);
    String _packageName = _lexerGrammar.getPackageName();
    AntlrGrammar _lexerGrammar_1 = this.getLexerGrammar(it);
    String _simpleName = _lexerGrammar_1.getSimpleName();
    return new TypeReference(_packageName, _simpleName);
  }
  
  @Override
  public TypeReference getParserClass(final Grammar it) {
    AntlrGrammar _parserGrammar = this.getParserGrammar(it);
    String _packageName = _parserGrammar.getPackageName();
    AntlrGrammar _parserGrammar_1 = this.getParserGrammar(it);
    String _simpleName = _parserGrammar_1.getSimpleName();
    return new TypeReference(_packageName, _simpleName);
  }
}
