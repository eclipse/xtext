/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.editor.model;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.util.Map;
import java.util.Set;
import org.antlr.runtime.Token;
import org.eclipse.xtext.ide.LexerIdeBindings;
import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;

/**
 * @author Anton Kosyakov
 * 
 * @since 2.9
 */
@SuppressWarnings("all")
public abstract class TokenTypeToStringMapper {
  private String[] mappedValues;
  
  @Inject
  public void setTokenDefProvider(@Named(LexerIdeBindings.HIGHLIGHTING) final ITokenDefProvider tokenDefProvider) {
    this.initIds(tokenDefProvider.getTokenDefMap());
  }
  
  protected void initIds(final Map<Integer, String> tokenDefMap) {
    this.mappedValues = new String[tokenDefMap.size()];
    Set<Map.Entry<Integer, String>> _entrySet = tokenDefMap.entrySet();
    for (final Map.Entry<Integer, String> entry : _entrySet) {
      Integer _key = entry.getKey();
      boolean _greaterEqualsThan = ((_key).intValue() >= Token.MIN_TOKEN_TYPE);
      if (_greaterEqualsThan) {
        Integer _key_1 = entry.getKey();
        int _minus = ((_key_1).intValue() - Token.MIN_TOKEN_TYPE);
        this.mappedValues[_minus] = this.calculateId(entry.getValue(), (entry.getKey()).intValue());
      }
    }
  }
  
  protected abstract String calculateId(final String tokenName, final int tokenType);
  
  protected String getMappedValue(final int tokenType) {
    String _xifexpression = null;
    if ((tokenType == Token.INVALID_TOKEN_TYPE)) {
      _xifexpression = HighlightingStyles.INVALID_TOKEN_ID;
    } else {
      _xifexpression = this.mappedValues[(tokenType - Token.MIN_TOKEN_TYPE)];
    }
    return _xifexpression;
  }
}
