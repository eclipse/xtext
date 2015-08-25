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
  
  public TypeReference getGrammarClass(final Grammar it, final String prefix) {
    String _parserPackage = this.getParserPackage(it);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(prefix, "");
    _builder.append("Internal");
    String _simpleName = GrammarUtil.getSimpleName(it);
    _builder.append(_simpleName, "");
    return new TypeReference(_parserPackage, _builder.toString());
  }
  
  public TypeReference getInternalParserClassName(final Grammar it) {
    String _parserPackage = this.getParserPackage(it);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Internal");
    String _simpleName = GrammarUtil.getSimpleName(it);
    _builder.append(_simpleName, "");
    _builder.append("Parser");
    return new TypeReference(_parserPackage, _builder.toString());
  }
  
  public String getParserPackage(final Grammar it) {
    StringConcatenation _builder = new StringConcatenation();
    String _runtimeBasePackage = this._xtextGeneratorNaming.getRuntimeBasePackage(it);
    _builder.append(_runtimeBasePackage, "");
    _builder.append(".idea.parser.antlr.internal");
    return _builder.toString();
  }
}
