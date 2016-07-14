/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.highlighting;

import com.intellij.ide.highlighter.JavaHighlightingColors;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.EditorColors;
import org.eclipse.xtend.ide.common.highlighting.XtendHighlightingStyles;
import org.eclipse.xtext.idea.highlighting.IHighlightingConfiguration;
import org.eclipse.xtext.xbase.idea.highlighting.XbaseHighlightingConfiguration;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendHighlightingConfiguration extends XbaseHighlightingConfiguration {
  @Override
  public void configure(final IHighlightingConfiguration.IHighlightingStyleAcceptor it) {
    super.configure(it);
    it.addStyle(XtendHighlightingStyles.RICH_TEXT_ID, "Template Text", EditorColors.INJECTED_LANGUAGE_FRAGMENT);
    it.addStyle(XtendHighlightingStyles.RICH_TEXT_DELIMITER_ID, "Template Terminals", DefaultLanguageHighlighterColors.PARENTHESES);
    it.addStyle(XtendHighlightingStyles.INSIGNIFICANT_TEMPLATE_TEXT, "Insignificant Template Whitespace", DefaultLanguageHighlighterColors.TEMPLATE_LANGUAGE_COLOR);
    it.addRedirect(XtendHighlightingStyles.POTENTIAL_LINE_BREAK, XtendHighlightingStyles.INSIGNIFICANT_TEMPLATE_TEXT);
    it.addRedirect(XtendHighlightingStyles.SEMANTIC_LINE_BREAK, XtendHighlightingStyles.INSIGNIFICANT_TEMPLATE_TEXT);
    it.addStyle(XtendHighlightingStyles.ACTIVE_ANNOTATION, "Active Annotation", JavaHighlightingColors.VALID_STRING_ESCAPE);
  }
}
