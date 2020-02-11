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
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil;

/**
 * Helper to identify synthetic terminal rules.
 * This implementation answers <code>true</code> for any terminal rule that has a body in the form
 * <code>terminal MY_TERMINAL: 'synthetic:MY_TERMINAL';</code>.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class SyntheticTerminalDetector {
  /**
   * Answers {@code true} if the given terminal rule is synthetic. That is,
   * the tokens for this rule will not be produced by the generated Antlr lexer
   * but manually in a custom token source.
   */
  public boolean isSyntheticTerminalRule(final TerminalRule rule) {
    AbstractElement _alternatives = rule.getAlternatives();
    if ((_alternatives instanceof Keyword)) {
      AbstractElement _alternatives_1 = rule.getAlternatives();
      String value = ((Keyword) _alternatives_1).getValue();
      String _name = AntlrGrammarGenUtil.<TerminalRule>getOriginalElement(rule).getName();
      String _plus = ("synthetic:" + _name);
      return Objects.equal(_plus, value);
    }
    return false;
  }
}
