/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenerator;
import org.eclipse.xtext.xtext.generator.parser.antlr.ExtendedGrammarNaming;
import org.eclipse.xtext.xtext.generator.parser.antlr.GrammarNaming;

@SuppressWarnings("all")
public class ExtendedAntlrGrammarGenerator extends AntlrGrammarGenerator {
  @Inject
  private ExtendedGrammarNaming naming;
  
  @Override
  protected GrammarNaming getGrammarNaming() {
    return this.naming;
  }
  
  @Override
  protected boolean isCombinedGrammar() {
    return false;
  }
}
