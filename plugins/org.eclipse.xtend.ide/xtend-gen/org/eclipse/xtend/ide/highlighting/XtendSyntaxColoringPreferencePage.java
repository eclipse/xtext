/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.highlighting;

import com.google.common.base.Objects;
import org.eclipse.xtend.ide.common.highlighting.XtendHighlightingStyles;
import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles;
import org.eclipse.xtext.ui.editor.syntaxcoloring.SyntaxColoringPreferencePage;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import org.eclipse.xtext.xbase.ide.highlighting.XbaseHighlightingStyles;

/**
 * @author Christian Schneider - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendSyntaxColoringPreferencePage extends SyntaxColoringPreferencePage {
  /**
   * Polishes the names of the inherited coloring profiles shown in the preference page.
   */
  @Override
  public void acceptDefaultHighlighting(final String id, final String name, final TextStyle style) {
    boolean _matched = false;
    if (Objects.equal(id, XtendHighlightingStyles.INVALID_TOKEN_ID)) {
      _matched=true;
    }
    if (!_matched) {
      if (Objects.equal(id, XtendHighlightingStyles.SEMANTIC_LINE_BREAK)) {
        _matched=true;
      }
    }
    if (!_matched) {
      if (Objects.equal(id, XtendHighlightingStyles.POTENTIAL_LINE_BREAK)) {
        _matched=true;
      }
    }
    if (!_matched) {
      if (Objects.equal(id, HighlightingStyles.COMMENT_ID)) {
        _matched=true;
      }
    }
    if (_matched) {
      return;
    }
    if (!_matched) {
      if (Objects.equal(id, HighlightingStyles.KEYWORD_ID)) {
        _matched=true;
        super.acceptDefaultHighlighting(id, "Keywords", style);
      }
    }
    if (!_matched) {
      if (Objects.equal(id, HighlightingStyles.NUMBER_ID)) {
        _matched=true;
        super.acceptDefaultHighlighting(id, "Numbers", style);
      }
    }
    if (!_matched) {
      if (Objects.equal(id, HighlightingStyles.STRING_ID)) {
        _matched=true;
        super.acceptDefaultHighlighting(id, "Strings", style);
      }
    }
    if (!_matched) {
      if (Objects.equal(id, HighlightingStyles.PUNCTUATION_ID)) {
        _matched=true;
        super.acceptDefaultHighlighting(id, "Punctuation Characters", style);
      }
    }
    if (!_matched) {
      if (Objects.equal(id, HighlightingStyles.TASK_ID)) {
        _matched=true;
        super.acceptDefaultHighlighting(id, "Task Tags", style);
      }
    }
    if (!_matched) {
      if (Objects.equal(id, HighlightingStyles.DEFAULT_ID)) {
        _matched=true;
        super.acceptDefaultHighlighting(id, "Others", style);
      }
    }
    if (!_matched) {
      if (Objects.equal(id, XbaseHighlightingStyles.LOCAL_VARIABLE)) {
        _matched=true;
      }
      if (!_matched) {
        if (Objects.equal(id, XbaseHighlightingStyles.LOCAL_VARIABLE_DECLARATION)) {
          _matched=true;
        }
      }
      if (_matched) {
        super.acceptDefaultHighlighting(id, (name + " (var)"), style);
      }
    }
    if (!_matched) {
      if (Objects.equal(id, XbaseHighlightingStyles.LOCAL_FINAL_VARIABLE)) {
        _matched=true;
      }
      if (!_matched) {
        if (Objects.equal(id, XbaseHighlightingStyles.LOCAL_FINAL_VARIABLE_DECLARATION)) {
          _matched=true;
        }
      }
      if (_matched) {
        super.acceptDefaultHighlighting(id, (name + " (val)"), style);
      }
    }
    if (!_matched) {
      super.acceptDefaultHighlighting(id, name, style);
    }
  }
}
