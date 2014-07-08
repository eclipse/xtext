/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.List;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractSmokeTest;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class SkipTokensInBetween extends AbstractSmokeTest {
  @Inject
  private Provider<Lexer> lexerProvider;
  
  public void assertNonSmoking(final String input) throws Exception {
    final List<CommonToken> tokenList = CollectionLiterals.<CommonToken>newArrayList();
    {
      final Lexer lexer = this.lexerProvider.get();
      ANTLRStringStream _aNTLRStringStream = new ANTLRStringStream(input);
      lexer.setCharStream(_aNTLRStringStream);
      Token token = lexer.nextToken();
      while ((!Objects.equal(token, Token.EOF_TOKEN))) {
        {
          tokenList.add(((CommonToken) token));
          Token _nextToken = lexer.nextToken();
          token = _nextToken;
        }
      }
    }
    for (final CommonToken token : tokenList) {
      {
        final int start = token.getStartIndex();
        String _text = token.getText();
        final int length = _text.length();
        String _substring = input.substring(0, start);
        String _substring_1 = input.substring((start + length));
        String _plus = (_substring + _substring_1);
        this.processExpression(_plus);
      }
    }
  }
  
  @Ignore("Disables since it is pretty much the same as testFeatureCall_25_a")
  @Test
  public void testFeatureCall_25_b() throws Exception {
    super.testFeatureCall_25_b();
  }
  
  @Ignore("Disables since it is pretty much the same as testFeatureCall_25_a")
  @Test
  public void testFeatureCall_25_c() throws Exception {
    super.testFeatureCall_25_c();
  }
  
  @Ignore("Disables since it is pretty much the same as testFeatureCall_25_a")
  @Test
  public void testFeatureCall_25_d() throws Exception {
    super.testFeatureCall_25_d();
  }
}
