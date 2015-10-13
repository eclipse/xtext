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
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammar;
import org.eclipse.xtext.xtext.generator.parser.antlr.GrammarNaming;

@SuppressWarnings("all")
public class DebugGrammarNaming extends GrammarNaming {
  @Override
  public AntlrGrammar getParserGrammar(final Grammar it) {
    String _internalParserPackage = this.getInternalParserPackage(it);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("DebugInternal");
    String _simpleName = GrammarUtil.getSimpleName(it);
    _builder.append(_simpleName, "");
    return new AntlrGrammar(_internalParserPackage, _builder.toString());
  }
}
