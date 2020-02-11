/**
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.editor.syntaxcoloring;

import com.google.common.base.Objects;
import com.google.inject.Singleton;
import java.util.regex.Pattern;
import org.eclipse.xtext.ide.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles;

/**
 * @author Anton Kosyakov
 * @since 2.9
 */
@Singleton
@SuppressWarnings("all")
public class DefaultAntlrTokenToAttributeIdMapper extends AbstractAntlrTokenToAttributeIdMapper {
  private static final Pattern QUOTED = Pattern.compile("(?:^\'([^\']*)\'$)|(?:^\"([^\"]*)\")$", Pattern.MULTILINE);
  
  private static final Pattern PUNCTUATION = Pattern.compile("\\p{Punct}*");
  
  @Override
  protected String calculateId(final String tokenName, final int tokenType) {
    String _switchResult = null;
    boolean _matched = false;
    boolean _matches = DefaultAntlrTokenToAttributeIdMapper.PUNCTUATION.matcher(tokenName).matches();
    if (_matches) {
      _matched=true;
      _switchResult = HighlightingStyles.PUNCTUATION_ID;
    }
    if (!_matched) {
      boolean _matches_1 = DefaultAntlrTokenToAttributeIdMapper.QUOTED.matcher(tokenName).matches();
      if (_matches_1) {
        _matched=true;
        _switchResult = HighlightingStyles.KEYWORD_ID;
      }
    }
    if (!_matched) {
      if (Objects.equal(tokenName, "RULE_STRING")) {
        _matched=true;
        _switchResult = HighlightingStyles.STRING_ID;
      }
    }
    if (!_matched) {
      if (Objects.equal(tokenName, "RULE_INT")) {
        _matched=true;
        _switchResult = HighlightingStyles.NUMBER_ID;
      }
    }
    if (!_matched) {
      if (Objects.equal(tokenName, "RULE_ML_COMMENT")) {
        _matched=true;
      }
      if (!_matched) {
        if (Objects.equal(tokenName, "RULE_SL_COMMENT")) {
          _matched=true;
        }
      }
      if (_matched) {
        _switchResult = HighlightingStyles.COMMENT_ID;
      }
    }
    if (!_matched) {
      _switchResult = HighlightingStyles.DEFAULT_ID;
    }
    return _switchResult;
  }
}
