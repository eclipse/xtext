/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.parser.antlr;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

@Singleton
@SuppressWarnings("all")
public class GrammarNaming {
  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;
  
  public String getParserPackage(final Grammar it) {
    StringConcatenation _builder = new StringConcatenation();
    String _runtimeBasePackage = this._xtextGeneratorNaming.getRuntimeBasePackage(it);
    _builder.append(_runtimeBasePackage, "");
    _builder.append(".parser.antlr");
    return _builder.toString();
  }
  
  public String getInternalParserPackage(final Grammar it) {
    StringConcatenation _builder = new StringConcatenation();
    String _runtimeBasePackage = this._xtextGeneratorNaming.getRuntimeBasePackage(it);
    _builder.append(_runtimeBasePackage, "");
    _builder.append(".parser.antlr.internal");
    return _builder.toString();
  }
  
  public TypeReference getGrammarClass(final Grammar it) {
    String _internalParserPackage = this.getInternalParserPackage(it);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Internal");
    String _simpleName = GrammarUtil.getSimpleName(it);
    _builder.append(_simpleName, "");
    return new TypeReference(_internalParserPackage, _builder.toString());
  }
  
  public TypeReference getLexerClass(final Grammar it) {
    String _internalParserPackage = this.getInternalParserPackage(it);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Internal");
    String _simpleName = GrammarUtil.getSimpleName(it);
    _builder.append(_simpleName, "");
    _builder.append("Lexer");
    return new TypeReference(_internalParserPackage, _builder.toString());
  }
  
  public TypeReference getParserClass(final Grammar it) {
    String _parserPackage = this.getParserPackage(it);
    StringConcatenation _builder = new StringConcatenation();
    String _simpleName = GrammarUtil.getSimpleName(it);
    _builder.append(_simpleName, "");
    _builder.append("Parser");
    return new TypeReference(_parserPackage, _builder.toString());
  }
  
  public TypeReference getInternalParserClass(final Grammar it) {
    String _internalParserPackage = this.getInternalParserPackage(it);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Internal");
    String _simpleName = GrammarUtil.getSimpleName(it);
    _builder.append(_simpleName, "");
    _builder.append("Parser");
    return new TypeReference(_internalParserPackage, _builder.toString());
  }
  
  public TypeReference getContentAssistParserClass(final Grammar it) {
    StringConcatenation _builder = new StringConcatenation();
    String _genericIdeBasePackage = this._xtextGeneratorNaming.getGenericIdeBasePackage(it);
    _builder.append(_genericIdeBasePackage, "");
    _builder.append(".contentassist.antlr");
    StringConcatenation _builder_1 = new StringConcatenation();
    String _simpleName = GrammarUtil.getSimpleName(it);
    _builder_1.append(_simpleName, "");
    _builder_1.append("Parser");
    return new TypeReference(_builder.toString(), _builder_1.toString());
  }
  
  public TypeReference getInternalContentAssistLexerClass(final Grammar it) {
    StringConcatenation _builder = new StringConcatenation();
    String _genericIdeBasePackage = this._xtextGeneratorNaming.getGenericIdeBasePackage(it);
    _builder.append(_genericIdeBasePackage, "");
    _builder.append(".contentassist.antlr.internal");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Internal");
    String _simpleName = GrammarUtil.getSimpleName(it);
    _builder_1.append(_simpleName, "");
    _builder_1.append("Lexer");
    return new TypeReference(_builder.toString(), _builder_1.toString());
  }
  
  public TypeReference getAntlrTokenFileProviderClass(final Grammar it) {
    String _parserPackage = this.getParserPackage(it);
    StringConcatenation _builder = new StringConcatenation();
    String _simpleName = GrammarUtil.getSimpleName(it);
    _builder.append(_simpleName, "");
    _builder.append("AntlrTokenFileProvider");
    return new TypeReference(_parserPackage, _builder.toString());
  }
  
  public String getTokenFileName(final Grammar it) {
    String _internalParserPackage = this.getInternalParserPackage(it);
    String _replace = _internalParserPackage.replace(".", "/");
    String _plus = (_replace + "/Internal");
    String _simpleName = GrammarUtil.getSimpleName(it);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + ".tokens");
  }
}
