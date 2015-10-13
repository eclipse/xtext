/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.highlighting;

import com.intellij.ide.highlighter.JavaHighlightingColors;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.CodeInsightColors;
import com.intellij.openapi.editor.colors.EditorColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles;

/**
 * Override this to register your own styles.
 * 
 * @author Jan Koehnlein
 */
@SuppressWarnings("all")
public interface IHighlightingConfiguration {
  public interface IHighlightingStyleAcceptor {
    /**
     * Register a new style.
     * 
     * @param xtextStyleId the style constant used by highlighting services.
     * @param displayName the name of this style shown on the properties page.
     * @param fallbackKey another text attribute style this one inherits from.
     * 	Good fallback attribute keys can be found in
     * {@link DefaultLanguageHighlighterColors}, {@link CodeInsightColors},
     * {@link EditorColors} or {@link JavaHighlightingColors}.
     * @see HighlightingStyles
     */
    public abstract TextAttributesKey addStyle(final String xtextStyleId, final String displayName, final TextAttributesKey fallbackKey);
    
    /**
     * Redirects xtextStyles.
     * Useful if you don't want to expose certain styles to the user.
     */
    public abstract void addRedirect(final String fromXtextStyleId, final String toXtextStyleId);
  }
  
  public abstract void configure(final IHighlightingConfiguration.IHighlightingStyleAcceptor it);
}
