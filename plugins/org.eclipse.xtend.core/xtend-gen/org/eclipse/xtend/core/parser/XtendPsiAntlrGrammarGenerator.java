/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.parser;

import com.google.inject.Inject;
import java.util.HashSet;
import java.util.List;
import org.eclipse.xtend.core.parser.TokenNames;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xtext.generator.idea.parser.antlr.PsiAntlrGrammarGenerator;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrOptions;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendPsiAntlrGrammarGenerator extends PsiAntlrGrammarGenerator {
  @Inject
  @Extension
  private TokenNames _tokenNames;
  
  @Override
  protected String compileTokens(final Grammar it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("tokens {");
    _builder.newLine();
    {
      HashSet<String> _newHashSet = CollectionLiterals.<String>newHashSet();
      List<String> _tokens = this._tokenNames.getTokens(it, _newHashSet);
      for(final String token : _tokens) {
        _builder.append("  ");
        _builder.append(token, "  ");
        _builder.append(" ;");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
}
