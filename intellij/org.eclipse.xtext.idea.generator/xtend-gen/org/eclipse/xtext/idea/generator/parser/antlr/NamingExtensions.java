/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.generator.parser.antlr;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.xbase.lib.Extension;

@Singleton
@SuppressWarnings("all")
public class NamingExtensions {
  @Inject
  @Extension
  private Naming _naming;
  
  public String getGrammarFileName(final Grammar it, final String prefix) {
    StringConcatenation _builder = new StringConcatenation();
    String _parserPackage = this.getParserPackage(it);
    _builder.append(_parserPackage, "");
    _builder.append(".");
    _builder.append(prefix, "");
    _builder.append("Internal");
    String _simpleName = GrammarUtil.getSimpleName(it);
    _builder.append(_simpleName, "");
    return _builder.toString();
  }
  
  public String getInternalParserClassName(final Grammar it) {
    StringConcatenation _builder = new StringConcatenation();
    String _parserPackage = this.getParserPackage(it);
    _builder.append(_parserPackage, "");
    _builder.append(".Internal");
    String _simpleName = GrammarUtil.getSimpleName(it);
    _builder.append(_simpleName, "");
    _builder.append("Parser");
    return _builder.toString();
  }
  
  public String getParserPackage(final Grammar it) {
    StringConcatenation _builder = new StringConcatenation();
    String _basePackageRuntime = this._naming.basePackageRuntime(it);
    _builder.append(_basePackageRuntime, "");
    _builder.append(".idea.parser.antlr.internal");
    return _builder.toString();
  }
}
