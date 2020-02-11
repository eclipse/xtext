/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.util;

import com.google.common.base.Objects;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class GrammarUtil2 extends GrammarUtil {
  public static final String TERMINALS = "org.eclipse.xtext.common.Terminals";
  
  public static boolean inherits(final Grammar grammar, final String languageID) {
    String _name = grammar.getName();
    boolean _equals = Objects.equal(_name, languageID);
    if (_equals) {
      return true;
    }
    EList<Grammar> _usedGrammars = grammar.getUsedGrammars();
    for (final Grammar grammar2 : _usedGrammars) {
      boolean _inherits = GrammarUtil2.inherits(grammar2, languageID);
      if (_inherits) {
        return true;
      }
    }
    return false;
  }
  
  public static Grammar getNonTerminalsSuperGrammar(final Grammar grammar) {
    final Function1<Grammar, Boolean> _function = (Grammar it) -> {
      String _name = it.getName();
      return Boolean.valueOf((!Objects.equal(_name, GrammarUtil2.TERMINALS)));
    };
    return IterableExtensions.<Grammar>findFirst(grammar.getUsedGrammars(), _function);
  }
}
