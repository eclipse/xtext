/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.editor.syntaxcoloring;

import com.google.common.base.Objects;
import com.google.inject.Singleton;
import java.util.regex.Matcher;
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
  private final static Pattern QUOTED = Pattern.compile("(?:^\'([^\']*)\'$)|(?:^\"([^\"]*)\")$", Pattern.MULTILINE);
  
  private final static Pattern PUNCTUATION = Pattern.compile("\\p{Punct}*");
  
  @Override
  protected String calculateId(final String tokenName, final int tokenType) {
    String _switchResult = null;
    boolean _matched = false;
    Matcher _matcher = DefaultAntlrTokenToAttributeIdMapper.PUNCTUATION.matcher(tokenName);
    boolean _matches = _matcher.matches();
    if (_matches) {
      _matched=true;
      _switchResult = HighlightingStyles.PUNCTUATION_ID;
    }
    if (!_matched) {
      Matcher _matcher_1 = DefaultAntlrTokenToAttributeIdMapper.QUOTED.matcher(tokenName);
      boolean _matches_1 = _matcher_1.matches();
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
