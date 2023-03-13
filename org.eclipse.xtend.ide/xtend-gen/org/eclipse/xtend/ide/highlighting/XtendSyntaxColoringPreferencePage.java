/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.highlighting;

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
    if (id != null) {
      switch (id) {
        case XtendHighlightingStyles.INVALID_TOKEN_ID:
        case XtendHighlightingStyles.SEMANTIC_LINE_BREAK:
        case XtendHighlightingStyles.POTENTIAL_LINE_BREAK:
        case HighlightingStyles.COMMENT_ID:
          return;
        case HighlightingStyles.KEYWORD_ID:
          super.acceptDefaultHighlighting(id, "Keywords", style);
          break;
        case HighlightingStyles.NUMBER_ID:
          super.acceptDefaultHighlighting(id, "Numbers", style);
          break;
        case HighlightingStyles.STRING_ID:
          super.acceptDefaultHighlighting(id, "Strings", style);
          break;
        case HighlightingStyles.PUNCTUATION_ID:
          super.acceptDefaultHighlighting(id, "Punctuation Characters", style);
          break;
        case HighlightingStyles.TASK_ID:
          super.acceptDefaultHighlighting(id, "Task Tags", style);
          break;
        case HighlightingStyles.DEFAULT_ID:
          super.acceptDefaultHighlighting(id, "Others", style);
          break;
        case XbaseHighlightingStyles.LOCAL_VARIABLE:
        case XbaseHighlightingStyles.LOCAL_VARIABLE_DECLARATION:
          super.acceptDefaultHighlighting(id, (name + " (var)"), style);
          break;
        case XbaseHighlightingStyles.LOCAL_FINAL_VARIABLE:
        case XbaseHighlightingStyles.LOCAL_FINAL_VARIABLE_DECLARATION:
          super.acceptDefaultHighlighting(id, (name + " (val)"), style);
          break;
        default:
          super.acceptDefaultHighlighting(id, name, style);
          break;
      }
    } else {
      super.acceptDefaultHighlighting(id, name, style);
    }
  }
}
