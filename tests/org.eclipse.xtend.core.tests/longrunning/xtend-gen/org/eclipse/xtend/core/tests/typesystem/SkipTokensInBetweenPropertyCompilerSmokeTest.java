/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.typesystem;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.List;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.eclipse.xtend.core.tests.typesystem.AbstractPropertyCompilerSmokeTest;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class SkipTokensInBetweenPropertyCompilerSmokeTest extends AbstractPropertyCompilerSmokeTest {
  @Inject
  private Provider<Lexer> lexerProvider;
  
  public void assertNonSmoking(final CharSequence input) throws Exception {
    final String string = input.toString();
    final List<CommonToken> tokenList = CollectionLiterals.<CommonToken>newArrayList();
    {
      final Lexer lexer = this.lexerProvider.get();
      ANTLRStringStream _aNTLRStringStream = new ANTLRStringStream(string);
      lexer.setCharStream(_aNTLRStringStream);
      Token token = lexer.nextToken();
      boolean _notEquals = (!Objects.equal(token, Token.EOF_TOKEN));
      boolean _while = _notEquals;
      while (_while) {
        {
          tokenList.add(((CommonToken) token));
          Token _nextToken = lexer.nextToken();
          token = _nextToken;
        }
        boolean _notEquals_1 = (!Objects.equal(token, Token.EOF_TOKEN));
        _while = _notEquals_1;
      }
    }
    for (final CommonToken token : tokenList) {
      {
        final int start = token.getStartIndex();
        String _text = token.getText();
        final int length = _text.length();
        String _substring = string.substring(0, start);
        String _substring_1 = string.substring((start + length));
        String _plus = (_substring + _substring_1);
        this.processFile(_plus);
      }
    }
  }
}
