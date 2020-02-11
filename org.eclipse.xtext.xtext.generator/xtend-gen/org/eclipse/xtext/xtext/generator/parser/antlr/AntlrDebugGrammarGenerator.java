/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.xtext.generator.parser.antlr.AbstractAntlrGrammarGenerator;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrOptions;
import org.eclipse.xtext.xtext.generator.parser.antlr.DebugGrammarNaming;
import org.eclipse.xtext.xtext.generator.parser.antlr.GrammarNaming;

@SuppressWarnings("all")
public class AntlrDebugGrammarGenerator extends AbstractAntlrGrammarGenerator {
  @Inject
  private DebugGrammarNaming naming;
  
  @Override
  protected GrammarNaming getGrammarNaming() {
    return this.naming;
  }
  
  @Override
  protected CharSequence compileParserOptions(final Grammar it, final AntlrOptions options) {
    return "";
  }
  
  @Override
  protected CharSequence compileParserHeader(final Grammar it, final AntlrOptions options) {
    return "";
  }
  
  @Override
  protected CharSequence compileLexerHeader(final Grammar it, final AntlrOptions options) {
    return "";
  }
}
