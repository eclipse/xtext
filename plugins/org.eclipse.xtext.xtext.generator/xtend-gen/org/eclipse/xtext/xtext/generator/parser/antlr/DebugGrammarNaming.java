/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.parser.antlr;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.parser.antlr.GrammarNaming;

@SuppressWarnings("all")
public class DebugGrammarNaming extends GrammarNaming {
  @Override
  public TypeReference getInternalParserSuperClass(final Grammar it) {
    return null;
  }
  
  @Override
  public boolean isCombinedGrammar(final Grammar it) {
    return true;
  }
  
  @Override
  protected String getGrammarNamePrefix(final Grammar it) {
    return "Debug";
  }
}
